package threadsBasic;

public class threadsLoop implements Runnable{

	public void run() {
		synchronized(this){
		for(int x=1;x<1001;++x) {
			try {
				System.out.println(Thread.currentThread().getName()+"   " + x);
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				
			}
		}
		}
	}
	public static void main(String[] args) {
		threadsLoop th = new threadsLoop();
		Thread a = new Thread(th);
		Thread b = new Thread(th);
		
		a.start();
		b.start();

	}

}
