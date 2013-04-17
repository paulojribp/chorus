package com.chorus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;

import com.chorus.entity.Chorus;
import com.chorus.model.Timeline;


@Component
public class TimelineDao implements Timelinegeneric{

	
	private final Session session;
	
	public TimelineDao(Session session) {
		this.session = session;
	}
	
	public void add(Chorus chorus) {
		this.session.save(chorus);
	}
	
	public List<Timeline> searchSimilarTitle(String mensagem) {
		return session.createCriteria(Timeline.class).add(
				Restrictions.ilike("mensagem", "%" + mensagem + "%")).list();
	}
	
	
}
