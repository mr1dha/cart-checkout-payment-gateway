package marketplace;

public interface PaymentGateway {
	boolean pay (float ammout);
	void topUp (float ammount);
	void withdraw (float ammount);
	float getBalance ();
	String getChannelName(); 
}