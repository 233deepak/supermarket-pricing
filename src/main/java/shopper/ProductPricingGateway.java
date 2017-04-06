package shopper;

public interface ProductPricingGateway {

	public int getPriceForProduct() throws NoPricingAvailable;
}
