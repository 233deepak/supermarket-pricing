package shopper;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PricerTest {

	private Pricer pricer;

	@Before
	public void setup() {
		pricer = new Pricer();
	}

	@Test
	public void buyNothing() throws NoPricingAvailable {
		assertEquals(0, pricer.priceForProduct(0), 0.001);
	}
	
	@Test(expected = NoPricingAvailable.class)
	public void buyOneWithNoPricing() throws NoPricingAvailable {
		assertEquals(0, pricer.priceForProduct(1), 0.001);
	}

	@Test
	public void buyProductsWithSimplePricing() throws NoPricingAvailable {
		pricer.setPricingGatway(new SimpleProductPricingGatewayStub());
		pricer.setProductOfferGateway(new ProductOfferGatewayDummy());
		assertEquals(1, pricer.priceForProduct(1), 0.001);
		assertEquals(2, pricer.priceForProduct(2), 0.001);
	}

	@Test
	public void buyProductsWithSimplePricingAndPercentageDiscount() throws NoPricingAvailable {
		pricer.setPricingGatway(new SimpleProductPricingGatewayStub());
		pricer.setProductOfferGateway(new ProductPercentageOfferGatewayStub());
		assertEquals(0.5, pricer.priceForProduct(1), 0.001);
		assertEquals(1, pricer.priceForProduct(2), 0.001);
	}
}
