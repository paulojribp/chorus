package com.chorus.dao;

import java.util.List;

import org.hibernate.classic.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.model.Timeline;


@Component
public class TimelineDao implements Timelinegeneric{

	
//   private final Session session;
	
	public void add(Timeline timeline) {
	}
	
	public List<Timeline> searchSimilarTitle(String title) {
		return null;
	}
	
	
	
}
