package com.example.firebasedemo.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesVo {

	private long salesid;
	private String salesno;
	private String status;
	private String availablestatus;
	private double total;
	private ContactVo contactdetails;
	List<SalesItemVo> salesitemvos;

}
