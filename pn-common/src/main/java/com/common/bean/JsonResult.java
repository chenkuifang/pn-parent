package com.common.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 结果返回类,控制器返回值只可以是String,和JsonResult这两种类型
 *
 * @author QuiFar
 * @version V1.0
 */
@Getter
@Setter
@ToString
public final class JsonResult implements Serializable {

    private static final long serialVersionUID = -4908915966053299827L;

    private JsonResult() {
    }

    /**
     * 编码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 列表总数，供分页使用
     */
    private Integer count;
    /**
     * 数据列表
     */
    private List<?> data;

    private static JsonResult resultBean = null;

    private static List<?> list = new ArrayList<>();

    /***
     * 获取单例(双重检查锁定) 懒汉单例
     *
     * @return
     */
    public static JsonResult getInstance() {
        if (resultBean == null) {
            synchronized (JsonResult.class) {
                if (resultBean == null) {
                    resultBean = new JsonResult();
                }
            }
        }

        initList();

        return resultBean;
    }

    /**
     * 初始化对象
     */
    private static void initList() {
        if (list == null) {
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        resultBean.setData(list);
    }

}
