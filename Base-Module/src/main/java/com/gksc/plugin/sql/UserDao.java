package com.gksc.plugin.sql;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface UserDao {
    // 插入用户
    @Insert
    long insertUser(User user);

    @Insert
    List<Long> insertUserList(List<User> userList);

    // 更新用户
    @Update
    int update(User user);

    // 删除用户
    @Delete
    void delete(User user);

    @Delete
    void deleteMultipleUsers(List<User> users);

    @Query("DELETE FROM user")
    void deleteAll();

    // 查询所有用户
    @Query("SELECT * FROM user ORDER BY faceId DESC")
    List<User> getAllUsers();

    // 查询指定用户
    @Query("SELECT * FROM user WHERE faceId IN (:userIds)")
    List<User> getUsersByIds(List<Integer> userIds);

    // 根据ID查询用户
    @Query("SELECT * FROM user WHERE faceId = :id")
    User getUserById(long id);

    // 分页查询（配合 LIMIT 和 OFFSET）
    @Query("SELECT * FROM user ORDER BY faceId LIMIT :pageSize OFFSET :offset")
    LiveData<List<User>> getUsersByPage(int pageSize, int offset);

    @Query("SELECT * FROM user WHERE faceId = :id")
    LiveData<User> getUserByIdLiveData(long id);

    @Query("SELECT * FROM user ORDER BY faceId DESC")
    LiveData<List<User>> getAllUsersLiveData();
}
