package shopper;

public class ProductPercentageOfferGatewayStub implements ProductOfferGateway {

	@Override
	public PercentageProductOffer offerForProduct() {
		return new PercentageProductOffer(0.5);
	}

}
