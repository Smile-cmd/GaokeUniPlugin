package com.gksc.plugin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gksc.plugin.sql.DataCallback;

import java.util.List;

public class RoomDBActivity extends AppCompatActivity {
    //private UserRepository userDao;
    //private UserDao userDao;
    private EditText etName, etAge, etId;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        // 初始化数据库
        //AppDatabase db = AppDatabase.getInstance(this);
        //userDao = new UserRepository(db.userDao());
        //
        //// 绑定控件
        //etName = findViewById(R.id.et_name);
        //etAge = findViewById(R.id.et_age);
        //etId = findViewById(R.id.et_id);
        //tvResult = findViewById(R.id.tv_result);
        //
        //Button btnAdd = findViewById(R.id.btn_add);
        //Button btnUpdate = findViewById(R.id.btn_update);
        //Button btnDelete = findViewById(R.id.btn_delete);
        //Button btnQuery = findViewById(R.id.btn_query);
        //
        //// 添加用户
        //btnAdd.setOnClickListener(v -> {
        //    String name = etName.getText().toString();
        //    int age = Integer.parseInt(etAge.getText().toString());
        //    String rybh = etId.getText().toString();
        //    //userDao.insertUser(new User(name, age, null, null, "123",-1));
        //    userDao.insertUser(new User(name, age, rybh, "", "", -1), new UserRepository.InsertCallback() {
        //        @Override
        //        public void onSuccess(long insertedId) {
        //            Log.d("InsertResult", "插入成功，ID: " + insertedId + "，人员编号：" + rybh);
        //            showAllUsers();
        //        }
        //
        //        @Override
        //        public void onFailure(Exception e) {
        //            Log.e("InsertError", "人员编号："+rybh+ "插入失败: " + e.getMessage());
        //        }
        //    });
        //});
        //
        //// 更新用户
        //btnUpdate.setOnClickListener(v -> {
        //    try {
        //        int id = Integer.parseInt(etId.getText().toString());
        //        //User user = userDao.getUserById(id);
        //        userDao.getUserByIdAsync(id, user -> {
        //            if (user != null) {
        //                user.setName(etName.getText().toString());
        //                user.setAge(Integer.parseInt(etAge.getText().toString()));
        //                //userDao.updateUser(user);
        //                userDao.updateUser(user, new UserRepository.UpdateCallback() {
        //                    long targetUserId = user.getFaceId();
        //                    @Override
        //                    public void onSuccess(boolean isUpdated) {
        //                        if (isUpdated) {
        //                            Toast.makeText(RoomDBActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
        //                            Log.d("UpdateResult", "用户ID: " + targetUserId + " 修改成功");
        //                            showAllUsers();
        //                        } else {
        //                            Toast.makeText(RoomDBActivity.this, "修改失败，未找到用户或数据未变化", Toast.LENGTH_SHORT).show();
        //                            Log.d("UpdateResult", "用户ID: " + targetUserId + " 修改失败");
        //                        }
        //                    }
        //
        //                    @Override
        //                    public void onFailure(Exception e) {
        //                        Toast.makeText(RoomDBActivity.this, "修改出错: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        //                        Log.e("UpdateError", "修改失败", e);
        //                    }
        //                });
        //            }
        //        });
        //    } catch (NumberFormatException e) {
        //        tvResult.setText("请输入正确的ID");
        //    }
        //});
        //
        //// 删除用户
        //btnDelete.setOnClickListener(v -> {
        //    try {
        //        long id = Long.parseLong(etId.getText().toString());
        //        userDao.getUserByIdAsync(id, user -> {
        //            if (user != null) {
        //                userDao.deleteUser(user);
        //                showAllUsers();
        //            }
        //        });
        //    } catch (NumberFormatException e) {
        //        tvResult.setText("请输入正确的ID");
        //    }
        //});
        //
        //// 查询所有用户
        //btnQuery.setOnClickListener(v -> showAllUsers());
    }

    // 显示所有用户
    //private void showAllUsers() {
    //    tvResult.setText("");
    //    String faceId = etId.getText().toString();
    //    if (!"".equalsIgnoreCase(faceId)) {
    //        StringBuilder sb = new StringBuilder();
    //        userDao.getUserByIdAsync(Long.parseLong(faceId), new DataCallback<User>() {
    //            @Override
    //            public void onSuccess(User user) {
    //                if (user != null) {
    //                    sb.append("人脸id: ").append(user.getFaceId())
    //                            .append("，姓名: ").append(user.getName())
    //                            .append("，人员编号: ").append(user.getRybh())
    //                            .append("\n");
    //                    tvResult.setText(sb.toString());
    //                }
    //            }
    //
    //            @Override
    //            public void onFailure(Exception e) {
    //                tvResult.setText("查询失败");
    //            }
    //        });
    //    }else {
    //        //List<User> users = userDao.getAllUsers();
    //        userDao.getAllUsersAsync(new DataCallback<List<User>>() {
    //            @Override
    //            public void onSuccess(List<User> users) {
    //                if (users != null) {
    //                    StringBuilder sb = new StringBuilder();
    //                    for (User user : users) {
    //                        sb.append("人脸id: ").append(user.getFaceId())
    //                                .append("，姓名: ").append(user.getName())
    //                                .append("，人员编号: ").append(user.getRybh())
    //                                .append("\n");
    //                    }
    //                    tvResult.setText(sb.toString());
    //                }
    //            }
    //
    //            @Override
    //            public void onFailure(Exception e) {
    //                tvResult.setText("查询失败");
    //            }
    //        });
    //    }
    //}
}
