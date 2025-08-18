//package com.gksc.plugin.sql;
//
//
//import android.util.Log;
//import android.widget.Toast;
//
//import java.util.List;
//
//import io.dcloud.feature.uniapp.annotation.UniJSMethod;
//import io.dcloud.feature.uniapp.bridge.UniJSCallback;
//import io.dcloud.feature.uniapp.common.UniModule;
//
///**
// * @author wh
// */
//public class DatabaseModule extends UniModule {
//
//    private UserRepository userRepository;
//
//    public void getById(long id, UniJSCallback jsCallback){
//        userRepository.getUserByIdAsync(id, user -> {
//            if (jsCallback != null) {
//                jsCallback.invoke(user);
//            }
//        });
//    }
//
//    @UniJSMethod
//    public void list(UniJSCallback jsCallback){
//        userRepository.getAllUsersAsync(users -> {
//            if (users != null) {
//                jsCallback.invoke(users);
//            }
//        });
//    }
//
//    @UniJSMethod
//    public void update(User user){
//        long targetUserId = user.getFaceId();
//        userRepository.updateUser(user, new UserRepository.UpdateCallback() {
//            @Override
//            public void onSuccess(boolean isUpdated) {
//                if (isUpdated) {
//                    Toast.makeText(mUniSDKInstance.getContext(), "修改成功", Toast.LENGTH_SHORT).show();
//                    Log.d("UpdateResult", "用户ID: " + targetUserId + " 修改成功");
//                } else {
//                    Toast.makeText(mUniSDKInstance.getContext(), "修改失败，未找到用户或数据未变化", Toast.LENGTH_SHORT).show();
//                    Log.d("UpdateResult", "用户ID: " + targetUserId + " 修改失败");
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Toast.makeText(mUniSDKInstance.getContext(), "修改出错: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("UpdateError", "修改失败", e);
//            }
//        });
//    }
//
//    @UniJSMethod
//    public void delete(User user){
//        userRepository.deleteUser(user);
//    }
//
//    @UniJSMethod
//    public void insert(User user){
//        userRepository.insertUser(user, new UserRepository.InsertCallback() {
//            @Override
//            public void onSuccess(long insertedId) {
//                Log.d("InsertResult", "插入成功，ID: " + insertedId);
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Log.e("InsertError", "插入失败: " + e.getMessage());
//            }
//        });
//    }
//
//    @UniJSMethod
//    public void insertUserList(List<User> userList){
//        userRepository.insertUsers(userList, new UserRepository.InsertListCallback() {
//            @Override
//            public void onSuccess(List<Long> insertedIds) {
//                Log.d("InsertResult", "批量插入成功，ID: " + insertedIds);
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                Log.e("InsertError", "批量插入失败: " + e.getMessage());
//            }
//        });
//    }
//
//    //@UniJSMethod
//    //public void initDb(){
//    //    if (userRepository == null) {
//    //        AppDatabase db = AppDatabase.getInstance(mUniSDKInstance.getContext());
//    //        userRepository = new UserRepository(db.userDao());
//    //    }
//    //}
//}
