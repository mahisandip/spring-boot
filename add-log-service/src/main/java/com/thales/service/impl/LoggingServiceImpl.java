package com.thales.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Service;

import com.thales.jpa.LogEntity;
import com.thales.logger.ILogger;
import com.thales.logger.LoggingTraceRepository;
import com.thales.repository.LoggingJpaRepository;
import com.thales.service.LoggingService;
import com.thales.vo.Log;

@Service
public class LoggingServiceImpl extends ILogger implements LoggingService {

	@Autowired
	private LoggingJpaRepository loggingJpaRepository;

	@Autowired
	private LoggingTraceRepository loggingTraceRepository;

	@Override
	public Void saveLogs() {

		logger.debug(getClass().getSimpleName() + " - saveLogs");

		List<HttpTrace> traces = loggingTraceRepository.findAll();
		List<LogEntity> logEntities = new ArrayList<>();

		for (HttpTrace httpTrace : traces) {

			LogEntity logEntity = new LogEntity();
			logEntity.setCreatedTime(new Date());
			logEntity.setLastUpdatedTime(new Date());
			logEntity.setMethod(httpTrace.getRequest().getMethod());
			logEntity.setApiName(httpTrace.getRequest().getUri().getPath());
			logEntity.setIpAddr(httpTrace.getRequest().getRemoteAddress());
			logEntity.setInputParams(httpTrace.getRequest().getUri().getQuery());
			logEntity.setRequestedTime(new Date(httpTrace.getTimestamp().toEpochMilli()));
			logEntities.add(logEntity);
		}

		loggingJpaRepository.saveAll(logEntities);
		return null;
	}

	@Override
	public List<Log> getLogs() {

		logger.debug(getClass().getSimpleName() + " - getLogs");

		List<LogEntity> logEntities = loggingJpaRepository.findAll();
		List<Log> logs = new ArrayList<>();

		for (LogEntity logEntity : logEntities) {
			Log log = new Log();
			BeanUtils.copyProperties(logEntity, log);
			logs.add(log);
		}

		return logs;
	}

}
