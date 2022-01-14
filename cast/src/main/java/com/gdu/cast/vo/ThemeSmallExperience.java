package com.gdu.cast.vo;

import java.util.List;

import lombok.Data;

@Data
// 테이블 스몰 체험
public class ThemeSmallExperience {
	private int themeSmallId;
	private int experienceId;
	private String createDate;
	private String updateDate;
	
	private Experience experience;
	private ThemeSmall themeSmall;
	private ExperienceImage experienceImage;
}
