package com.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizContent {

	private String out_trade_no;
	
	private String product_code;
	
	private Float total_amount;
	
	private String subject;
	
	private SyServiceProvider extend_params;

}
