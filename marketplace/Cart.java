package marketplace;

import java.util.ArrayList;

public class Cart implements Checkout {
	private PaymentGateway channel;
	private ArrayList <Product> products;

	public Cart () {
		channel = null;
		products = new ArrayList<> ();
	}

	@Override
	public void connectTo (PaymentGateway channel) {
		System.out.println("\nConnecting to payment gateway ... ");
		this.channel = channel;
		System.out.println("--> Payment gateway connected to channel : "+ channel.getChannelName());
	}

	@Override
	public boolean checkout () {
		boolean checkoutStatus = false;

		System.out.println("\nStarting checkout "+products.size()+" products ...");
		if ( !isEmpty() && channel != null ) {
			boolean paymentStatus = channel.pay (calculatePrice());

			if (paymentStatus)
				checkoutStatus = true;
			else
				System.out.println("\nPayment Failed, Out of balance!");
			System.out.println("Your remaining "+channel.getChannelName()+" balance is = IDR"+channel.getBalance());
		}
		return checkoutStatus;
	}

	@Override
	public float calculatePrice () {
		float totalPrice = 0.0f;

		for ( Product product : products ) {
			totalPrice += product.getPrice();
		}

		return totalPrice;
	}

	@Override
	public boolean isEmpty () {
		return products.size() == 0;
	}

	public void addProduct (Product product) {
		System.out.println("\nAdding "+product.getProductId()+" to cart...");
		this.products.add (product);
	}
}