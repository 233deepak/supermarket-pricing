package shopper;

public class PercentageProductOffer implements ProductOffer {
	private double percentage;

	public PercentageProductOffer(double percentage) {
		super();
		this.percentage = percentage;
	}

	public double getDiscount(double basePriceForProducts, int productCount) {
		return basePriceForProducts * percentage;
	}
}
