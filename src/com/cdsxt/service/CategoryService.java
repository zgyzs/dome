package com.cdsxt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdsxt.base.BaseService;
import com.cdsxt.ro.CategoryRo;


@Service
public class CategoryService extends BaseService{

	public 	List<CategoryRo> selectAll(){
		return categoryDao.selectAll();
	}
}
