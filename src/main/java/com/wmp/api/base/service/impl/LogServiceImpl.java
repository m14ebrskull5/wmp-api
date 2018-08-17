package com.wmp.api.base.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wmp.api.base.entity.Log;
import com.wmp.api.base.service.LogService;


@Service("logService")
public class LogServiceImpl  implements LogService{
	private static final Map<String, Log> Logs = new HashMap<>();

//	@Autowired
//	private LogDao logDao;
	
	@Override
	public int createLog(Log log) {
		//return this.logDao.insertSelective(log);
		System.out.println("模拟日志入库"+log);
		Logs.put(log.getLogId(), log);
		return 1;
	}
	
	@Override
	public int updateLog(Log log) {
		//return this.logDao.updateByPrimaryKeySelective(log);
		System.out.println("模拟日志更新"+log);
		Logs.put(log.getLogId(), log);
		return 1;
	}

	@Override
	public List<Log> listLogs() {
	
		return null;
	}


	





}
