package com.chorus.dao;

import java.util.List;

import com.chorus.entity.Chorus;
import com.chorus.model.Timeline;

public interface Timelinegeneric {
	
	void add(Chorus chorus);
	
	List<Timeline> searchSimilarTitle(String lista);
	

}
