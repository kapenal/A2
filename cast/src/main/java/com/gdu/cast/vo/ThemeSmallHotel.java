package com.gdu.cast.vo;

import lombok.Data;

@Data
// 테이블 스몰 호텔
public class ThemeSmallHotel {
	private int themeSmallId;
	private int HotelId;
	private String createDate;
	private String updateDate;
	
	private Hotel hotel;
	private ThemeSmall themeSmall;
	private HotelImage hotelImage;
}
