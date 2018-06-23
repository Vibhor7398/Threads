package threadsBasic;

public class threadsLoop implements Runnable {
	public void run() {
		synchronized (this) {

			try {
				for (int count = 1; count < 501; ++count) {
					System.out.println(Thread.currentThread().getName() + "   " + count);
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		threadsLoop t500 = new threadsLoop();
		threadsLoop2 t1000 = new threadsLoop2();
		Thread t1 = new Thread(t500);
		Thread t2 = new Thread(t1000);
		t1.start();
		t1.join();
		t2.start();
		t2.join();

	}

}

class threadsLoop2 implements Runnable {
	int i = 501;

	public void run() {
		synchronized (this) {

			try {
				for (int count = 501; count < 1001; ++count) {
					System.out.println(Thread.currentThread().getName() + "   " + count);
				}
				Thread.sleep(5);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
}
