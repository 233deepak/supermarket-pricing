package shopper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductOfferGatewayTest {

	@Test
	public void testNoOfferForProduct() {
		ProductOfferGateway productOfferGateway = new ProductOfferGatewayDummy();
		assertEquals(null, productOfferGateway.offerForProduct());
	}

	
	@Test
	public void testOfferForProduct() {
		ProductOfferGateway productOfferGateway = new ProductPercentageOfferGatewayStub();
		assertTrue(productOfferGateway.offerForProduct() != null);		
	}
	
	
}
