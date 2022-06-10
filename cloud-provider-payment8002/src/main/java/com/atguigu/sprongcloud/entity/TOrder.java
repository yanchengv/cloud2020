package com.atguigu.sprongcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TOrder {
    private int id;
    private int userId;
    private int count;
    private int money;
}
