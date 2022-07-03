package com.suraj.blog.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

	private Integer categoryId;
	private String cateoryTitle;
	private String categoryDescription;
}
