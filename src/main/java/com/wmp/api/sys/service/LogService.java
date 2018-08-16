package com.wmp.api.sys.service;


import java.util.List;

import com.wmp.api.sys.entity.Log;

public interface LogService {
	//增删改
	int createLog(Log log);
	int updateLog(Log log);
	List<Log> listLogs();
	

	
}
