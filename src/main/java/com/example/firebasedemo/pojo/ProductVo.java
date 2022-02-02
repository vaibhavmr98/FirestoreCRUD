package com.example.firebasedemo.pojo;

import lombok.Data;

@Data
public class ProductVo {

	private long productid;
	private double mrp;
	private double sellingprice;
	private String productname;
}
