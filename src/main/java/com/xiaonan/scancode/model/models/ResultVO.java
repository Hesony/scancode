package com.xiaonan.scancode.model.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求返回的最外层对象
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    /** 错误码. */
    private String code;

    /** 提示信息. */
    private String msg;

}
