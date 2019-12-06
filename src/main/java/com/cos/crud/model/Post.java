package com.cos.crud.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	private int id;
	private String title;
	private String content;
	private int userId; //FK
	private Timestamp createDate;
}
