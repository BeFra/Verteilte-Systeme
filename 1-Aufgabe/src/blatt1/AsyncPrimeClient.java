package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

public class AsyncPrimeClient {

	volatile boolean rec = false;
	private long number;
	
	 AsyncPrimeClient(long number) {
		 this.number = number;
	 }
	
	
	private class Receiver implements Runnable{
		ClientEndpoint endpoint;
		
		
		
		Receiver(ClientEndpoint endpoint) {
			this.endpoint = endpoint;
		}
		
		@Override
		public void run() {
			
			boolean isPrime = endpoint.blockingReceive();
			rec = true;
			System.out.println((isPrime ? "eine " : "keine ") + "Primzahl");
		}
		
	}
	
	public void run() {
		SocketAddress server = new InetSocketAddress("localhost", 4711);
		ClientEndpoint endpoint = new ClientEndpoint();
		
		
		
		endpoint.send(server, number);
		
		new Thread( new Receiver(endpoint)).start();
		System.out.print("Die Zahl " + number + " ist " );
		while (rec == false) {
			
			System.out.print(".");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	
	
	public static void main(String[] args) {
		for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
		    new AsyncPrimeClient(i).run();
		}

	}

}
