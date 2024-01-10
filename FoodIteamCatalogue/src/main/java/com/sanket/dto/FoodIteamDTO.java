package com.sanket.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodIteamDTO {
	
	private int id;
	private String itemName;
	private String iteamDescription;
	private boolean isVeg;
	private long price;
	private Integer restaurentId;
	private Integer quantity;

}
