package shopper;

public class Pricer {

	private ProductPricingGateway productPricingGateway;
	private ProductOfferGateway productOfferGateway;

	public double priceForProduct(int productCount) throws NoPricingAvailable {
		if(productCount >  0){
			if(productPricingGateway == null){
				throw new NoPricingAvailable();
			}
			return calcluatePriceForProduct(productCount);
		}
		return 0;
	}

	private double calcluatePriceForProduct(int productCount) throws NoPricingAvailable {
		double basePriceForProducts = productPricingGateway.getPriceForProduct() * productCount;
		ProductOffer offer = productOfferGateway.offerForProduct();
		if (offer != null) {
			double discountAmount = offer.getDiscount(basePriceForProducts, productCount);
			return basePriceForProducts - discountAmount;
		}
		return basePriceForProducts;
	}

	public void setPricingGatway(ProductPricingGateway productPricingGateway) {
		this.productPricingGateway = productPricingGateway;
	}

	public void setProductOfferGateway(ProductOfferGateway productOfferGateway) {
		this.productOfferGateway = productOfferGateway;
	}

}
