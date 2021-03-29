package marketplace;

public class Dana implements PaymentGateway {
	private float balance;

	public Dana () {
		this.balance = 0;
	}

	public Dana (float balance) {
		this.balance = balance;
	}

	@Override
	public boolean pay (float ammout) {
		boolean paymentStatus = false;

		System.out.println("\nStarting payment IDR"+ammout);

		if ( this.getBalance() >= ammout ) {
			this.withdraw(ammout);
			paymentStatus = true;
		}

		return paymentStatus;
	}

	@Override
	public void topUp (float ammout) {
		this.balance += ammout;
		System.out.println("\nTop up "+this.getChannelName()+" IDR"+ammout+" Success");
	}

	@Override
	public void withdraw (float ammout) {
		this.balance -= ammout;
	}

	@Override
	public float getBalance () {
		return this.balance;
	}

	@Override
	public String getChannelName () {
		return "Dana";
	}
}