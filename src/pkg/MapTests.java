package pkg;

import static org.junit.Assert.*;

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
	public void findStationOnSameLine() throws InterruptedException {
		Station testOtherStation = new Station("Wembley Park");
		Station returnedStation = tubeMap.findStation("Wembley Park");
		assertEquals(testOtherStation.getName(),returnedStation.getName());
		assertEquals(returnedStation.getNearbyStations().get(0).getWeight(), 3);
	}
	
	@Test
	public void findStationThatDoesntExist() throws InterruptedException{
		assertEquals(null,tubeMap.findStation("FakeStation"));
	}
		
	@Test
	public void linkStationByFoot() {
		Station Kenton = new Station("Kenton");
		Station SouthKenton = new Station("South Kenton");
		tubeMap.linkStationsByFoot(Kenton, SouthKenton, 1);
		
		assertTrue(Kenton.areStationsConnected(SouthKenton));
		assertTrue(Kenton.getStationLinkWeight(SouthKenton) == 1);
	}
	
	@Test
	public void linkStationByTrain() {
		Station Kenton = new Station("Kenton");
		Station SouthKenton = new Station("South Kenton");
		tubeMap.linkStationsByTrain(Kenton, SouthKenton, 1);
		
		assertTrue(Kenton.areStationsConnected(SouthKenton));
		assertTrue(Kenton.getStationLinkWeight(SouthKenton) == 1);
	}
}
