package com.spatialtest.app;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spatialtest.app.model.domain.Venue;
import com.spatialtest.app.repositories.VenueRepository;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
@ContextConfiguration("classpath:testContext.xml")
@Transactional
public class SpatialTest {
	
/*    @Configuration
    @EnableNeo4jRepositories
    static class TestConfig extends Neo4jConfiguration {
        @Bean
        GraphDatabaseService graphDatabaseService() {
            return new ImpermanentGraphDatabase();
        }
    }
*/
    private static final String[] vArray =
            {"Apollo Theatre",
    		"Carnegie Hall",
            "Roseland Ballroom",
            "Radio City Music Hall",
            "Bowery Ballroom"};

    private static final float[][] locArray =
            {{(float) 40.810764, (float) -73.950231},
    		{(float) 40.765331, (float) -73.979451},
            {(float) 40.763186, (float) -73.984215},
            {(float) 40.760553, (float) -73.980052},
            {(float) 40.720656, (float) -73.99327}};

    @Autowired
    private VenueRepository venueRep;

    @Autowired
    GraphDatabaseService graphDatabaseService;

    @Test
    public void testFiveNodes() {

        for (int i = 0; i < vArray.length; i++) {
            Venue venue = new Venue();
            venue.setLocation(locArray[i][1], locArray[i][0]);
            System.out.println(i + ": " + venue.getLocation());

            venue = venueRep.save(venue);
        }
        assertEquals(venueRep.findAll().as(Set.class).size(), 5);
    }
}
