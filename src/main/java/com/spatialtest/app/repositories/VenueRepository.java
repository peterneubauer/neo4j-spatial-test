package com.spatialtest.app.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.SpatialRepository;

import com.spatialtest.app.model.domain.Venue;

public interface VenueRepository extends GraphRepository<Venue>, 
	SpatialRepository<Venue>, NamedIndexRepository<Venue>{}