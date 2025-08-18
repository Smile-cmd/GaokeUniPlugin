package com.gksc.plugin.sql;

import android.util.Log;

/**
 * @author wh
 * @date 2025/8/18 11:57
 **/
public interface DataCallback <T>{
    // 当异步操作成功时调用，传入结果数据
    void onSuccess(T data);
    // 当异步操作失败时调用，传入异常信息
    default void onFailure(Exception e){
        Log.e("DataCallback", "操作失败！");
    };
}
