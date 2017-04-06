package shopper;

public class SimpleProductPricingGatewayStub implements ProductPricingGateway{


	@Override
	public int getPriceForProduct() throws NoPricingAvailable {
		return 1;
	}

}
