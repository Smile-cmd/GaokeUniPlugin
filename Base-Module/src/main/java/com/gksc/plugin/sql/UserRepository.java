package com.gksc.plugin.sql;


import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final String TAG = "UserRepository";
    private final UserDao userDao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUserByIdAsync(long id, DataCallback<User> callback){
        executor.execute(() ->{
            User userById = userDao.getUserById(id);
            new Handler(Looper.getMainLooper()).post(() -> callback.onSuccess(userById));
        });
    }

    public void getAllUsersAsync(DataCallback<List<User>> callback){
        executor.execute(() ->{
            List<User> userList = userDao.getAllUsers();
            new Handler(Looper.getMainLooper()).post(() -> callback.onSuccess(userList));
        });
    }

    // 修改用户并判断结果
    public void updateUser(User user, UpdateCallback callback) {
        new UpdateAsyncTask(userDao, callback).execute(user);
    }

    // 定义回调接口
    public interface UpdateCallback {
        void onSuccess(boolean isUpdated);
        default void onFailure(Exception e){
            Log.e("UpdateCallback", "修改失败："+ e.getMessage());
        }
    }

    // 异步任务处理数据库操作
    private static class UpdateAsyncTask extends AsyncTask<User, Void, Integer> {
        private final UserDao userDao;
        private final UpdateCallback callback;
        private Exception exception;

        UpdateAsyncTask(UserDao userDao, UpdateCallback callback) {
            this.userDao = userDao;
            this.callback = callback;
        }

        @Override
        protected Integer doInBackground(User... users) {
            try {
                // 执行修改并返回受影响的行数
                return userDao.update(users[0]);
            } catch (Exception e) {
                exception = e;
                return -1; // 发生异常时返回-1
            }
        }

        @Override
        protected void onPostExecute(Integer affectedRows) {
            if (exception != null) {
                callback.onFailure(exception);
            } else {
                // 受影响行数为1表示修改成功，0表示未找到数据或未修改
                callback.onSuccess(affectedRows > 0);
            }
        }
    }

    public void deleteUser(User user){
        executor.execute(() ->{
            userDao.delete(user);
        });
    }

    // 插入单条数据并获取ID（使用异步任务避免主线程操作）
    public void insertUser(User user, InsertCallback callback) {
        new InsertAsyncTask(userDao, callback).execute(user);
    }

    // 插入多条数据
    public void insertUsers(List<User> users, InsertListCallback callback) {
        new InsertListAsyncTask(userDao, callback).execute(users);
    }

    // 回调接口用于返回插入的ID
    public interface InsertCallback {
        void onSuccess(long insertedId);
        default void onFailure(Exception e){
            Log.e("InsertCallback", "插入失败！");
        }
    }

    public interface InsertListCallback {
        void onSuccess(List<Long> insertedIds);
        void onFailure(Exception e);
    }

    // 异步任务处理单条插入
    private static class InsertAsyncTask extends AsyncTask<User, Void, Long> {
        private final UserDao userDao;
        private final InsertCallback callback;
        private Exception exception;

        InsertAsyncTask(UserDao userDao, InsertCallback callback) {
            this.userDao = userDao;
            this.callback = callback;
        }

        @Override
        protected Long doInBackground(User... users) {
            try {
                return userDao.insertUser(users[0]);
            } catch (Exception e) {
                exception = e;
                return -1L;
            }
        }

        @Override
        protected void onPostExecute(Long insertedId) {
            if (exception == null && callback != null) {
                callback.onSuccess(insertedId);
            } else if (callback != null) {
                callback.onFailure(exception);
            }
        }
    }

    // 异步任务处理多条插入
    private static class InsertListAsyncTask extends AsyncTask<List<User>, Void, List<Long>> {
        private final UserDao userDao;
        private final InsertListCallback callback;
        private Exception exception;

        InsertListAsyncTask(UserDao userDao, InsertListCallback callback) {
            this.userDao = userDao;
            this.callback = callback;
        }

        @Override
        protected List<Long> doInBackground(List<User>... lists) {
            try {
                return userDao.insertUserList(lists[0]);
            } catch (Exception e) {
                exception = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Long> insertedIds) {
            if (exception == null && callback != null) {
                callback.onSuccess(insertedIds);
            } else if (callback != null) {
                callback.onFailure(exception);
            }
        }
    }
}
