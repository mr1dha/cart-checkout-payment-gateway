import marketplace.*;

class Main {
	public static void main(String[] args) {
		Gopay gopay = new Gopay (250);
		Dana dana = new Dana (100);
		Ovo ovo = new Ovo (1000);

		Cart cart = new Cart ();
		CheckoutButton button = new CheckoutButton ();

		button.connectTo (cart);
		cart.connectTo (gopay);

		// gopay.topUp(100);

		cart.addProduct ( new Product ("product1", 50));
		cart.addProduct ( new Product ("product2", 150));

		button.pressed();
	}
}
