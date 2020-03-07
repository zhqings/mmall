package com.eureka.client_first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author Administrator
 * @Description //商口信息
 * @Date 2020-03-06
 */
@Data
@AllArgsConstructor
@ToString
public class ProductInfo {
    //    索引
    private Integer id;
    //    商品名称
    private String productName;
    //    数量
    private Integer number;
}
