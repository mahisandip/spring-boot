package com.thales.logger;

import java.util.List;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Component;

@Component
public class LoggingTraceRepository implements HttpTraceRepository {

	private HttpTraceRepository delegate = new InMemoryHttpTraceRepository();

	@Override
	public List<HttpTrace> findAll() {

		List<HttpTrace> traces = delegate.findAll();
		delegate = new InMemoryHttpTraceRepository();
		return traces;
	}

	@Override
	public void add(HttpTrace trace) {

		if (!trace.getRequest().getUri().getPath().startsWith("/h2")
				&& !trace.getRequest().getUri().getPath().startsWith("/logging")
				&& !trace.getRequest().getUri().getPath().startsWith("/actuator"))
			this.delegate.add(trace);
	}
}