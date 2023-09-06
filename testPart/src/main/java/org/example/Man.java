package org.example;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/8/10 9:04
 */
@Data
public class Man extends People{
    private String sex = "男";

    @JSONField(name = "feature")
    private String featur;

    @Override
    public String toString() {
        return "Man{" +
                "sex='" + sex + '\'' +
                ", feature='" + featur + '\'' +
                '}' + super.getName();
    }
}
