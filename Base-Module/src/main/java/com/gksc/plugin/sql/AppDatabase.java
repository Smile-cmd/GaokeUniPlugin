//package com.gksc.plugin.sql;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import android.content.Context;
//
//// 定义数据库版本和包含的实体类
//@Database(entities = {User.class},
//        version = 1,
//        exportSchema = false
//)
//public abstract class AppDatabase extends RoomDatabase {
//
//    private static final String database_name = "user_database";
//    // 单例模式
//    private static AppDatabase INSTANCE;
//
//    // 获取DAO
//    public abstract UserDao userDao();
//
//    // 获取数据库实例
//    public static synchronized AppDatabase getInstance(Context context) {
//        if (INSTANCE == null) {
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            AppDatabase.class, database_name)
//                    //.allowMainThreadQueries() // 允许在主线程操作数据库，实际开发中不推荐
//                    .fallbackToDestructiveMigration() // 版本变动时候，无视规则，抛弃数据直接重建库
//                    .build();
//        }
//        return INSTANCE;
//    }
//
//    // 可选：提供手动删除数据库的方法（如需主动触发重建）
//    public static void destroyInstance(Context context) {
//        if (INSTANCE != null) {
//            INSTANCE.close();
//            INSTANCE = null;
//            // 手动删除数据库文件
//            context.getApplicationContext().deleteDatabase(database_name);
//        }
//    }
//}
