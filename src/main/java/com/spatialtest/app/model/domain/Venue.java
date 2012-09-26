package com.spatialtest.app.model.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class Venue {
	
	@GraphId private Long graphId;
	
	@Indexed(indexType = IndexType.POINT, indexName = "VenueLocation")
	private String wkt;

	String name;
	
	public void setLocation(float lon, float lat) {
		this.wkt = String.format("POINT( %s %s )",lon,lat);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return wkt;
	}
}