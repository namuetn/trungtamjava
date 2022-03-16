package javathread;

public class Ticket implements Runnable {
	private int ticket = 2;
	
	public synchronized void buyTicket() {
		
		try {
			ticket -= 1;
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(3000);
			
			if (ticket > 0)
				System.out.println("Can buy");
			else
				System.out.println("Sold out");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		buyTicket();
	}
}
