//package com.gksc.plugin.sql;
//
//import androidx.room.Entity;
//import androidx.room.Index;
//import androidx.room.PrimaryKey;
//
//import java.io.Serializable;
//
//// 定义数据库表名为user
//@Entity(tableName = "user", indices = {@Index(value = {"rybh"}, unique = true)}  )
//public class User implements Serializable {
//    // 人脸ID，自动递增
//    @PrimaryKey(autoGenerate = true)
//    private long faceId;
//
//    /**
//     * 人员编号
//     */
//    private String rybh;
//
//    /**
//     * 人员姓名
//     */
//    private String name;
//
//    /**
//     * 年纪
//     */
//    private int age;
//
//
//    /**
//     * 人脸特征
//     */
//    private String feature;
//
//    /**
//     * 人懒图片路径
//     */
//    private String imgPath;
//
//    /**
//     * 记录人脸特征是否注册成功
//     */
//    private int status;
//
//    // 构造方法
//    public User( String name, int age, String rybh, String feature, String imgPath, int status) {
//        this.name = name;
//        this.age = age;
//        this.rybh = rybh;
//        this.feature = feature;
//        this.imgPath = imgPath;
//        this.status = status;
//    }
//
//    // Getter 和 Setter 方法
//    public long getFaceId() {
//        return faceId;
//    }
//
//    public void setFaceId(long faceId) {
//        this.faceId = faceId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getRybh() {
//        return rybh;
//    }
//
//    public void setRybh(String rybh) {
//        this.rybh = rybh;
//    }
//
//    public String getFeature() {
//        return feature;
//    }
//
//    public void setFeature(String feature) {
//        this.feature = feature;
//    }
//
//    public String getImgPath() {
//        return imgPath;
//    }
//
//    public void setImgPath(String imgPath) {
//        this.imgPath = imgPath;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//}
