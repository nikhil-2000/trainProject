package pkg;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapTests {

	@Before
	public void setUp() throws Exception {
	}
	Map tubeMap = new Map();

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findStationWithStartStation() throws InterruptedException {
		//fail("Not yet implemented");
		Station testStartStation = new Station("Kenton Station");
		assertEquals(testStartStation.getName(),tubeMap.findStation("Kenton Station").getName());
	}
	
	@Test	
	public void findStationNearby() throws InterruptedException{
		Station testOtherStation = new Station("Northwick Park");
		Station returnedStation = tubeMap.findStation("Northwick Park");
		assertEquals(testOtherStation.getName(),returnedStation.getName());
	}

	@Test	
	public void findStationWithNonExistentStation() throws InterruptedException {
		assertEquals(null,tubeMap.findStation("fakeStation"));
	}
	
	@Test	
	public void findStationOnSameLine() throws InterruptedException {
		Station testOtherStation = new Station("Wembley Park");
		Station returnedStation = tubeMap.findStation("Wembley Park");
		assertEquals(testOtherStation.getName(),returnedStation.getName());
		//assertEquals(returnedStation.getNearbyStations().get(0).getWeight(), 3);
	}
		
		

}
