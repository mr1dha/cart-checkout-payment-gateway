package marketplace;

public interface Checkout {
	void connectTo (PaymentGateway channel);
	boolean checkout ();
	float calculatePrice ();
	boolean isEmpty ();
}