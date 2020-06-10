package com.lbs0912.springboot.app.common;


import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *  实体类基类
 * @author lbs
 * @date 2020-06-10 11:21
 */
@Getter
@Setter
public abstract class BaseCommon implements Serializable {

    /**
     * 创建人
     */
    private String createUser;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
