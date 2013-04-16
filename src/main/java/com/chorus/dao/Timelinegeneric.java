package com.chorus.dao;

import java.util.List;

import com.chorus.model.Timeline;

public interface Timelinegeneric {
	
	void add(Timeline timeline);
	
	List<Timeline> searchSimilarTitle(String lista);
	

}
