package com.example.firebasedemo.pojo;

import lombok.Data;

@Data
public class SalesItemVo {

	private ProductVo product;
	private double quantity;
	private double netamount;
}
