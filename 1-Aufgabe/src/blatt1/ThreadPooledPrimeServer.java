package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThreadPooledPrimeServer {

	private final ServerEndpoint endpoint;
	private final int nThreads = 3;
	volatile private boolean stopFlag = false;
 
	private class Worker implements Runnable {
		long number;
		SocketAddress sender;
		Worker(long number, SocketAddress sender) {
			this.number = number;
			this.sender = sender;
		}

		@Override
		public void run() {
			boolean isPrime = true;
			for (long i = 2; i <= Math.sqrt(number); i++) {
	    		if (number % i == 0) {
	    			isPrime =  false;
	    			break;
	    		}
	    	}
			endpoint.send(sender, isPrime);

		}
	}
	
	private class stopRequest implements Runnable {
		
		stopRequest() {}
		
		@Override
		public void run() {
			//int test = JOptionPane.showConfirmDialog(null, "Press OK button to stop server", "Message", JOptionPane.OK_OPTION);
			JOptionPane.showMessageDialog(null, "Press OK button to stop server");
			
			//if (test == JOptionPane.OK_OPTION) {
				stopFlag = true;
				
				ClientEndpoint endpoint = new ClientEndpoint();
				SocketAddress server = new InetSocketAddress("localhost", 4711);		
				endpoint.send(server, 0);
				
				
			//}
		}
	}
	

	
	ThreadPooledPrimeServer() {
		endpoint = new ServerEndpoint();
		
	}
	
	public void dispatcher() {

		ExecutorService executor =  Executors.newFixedThreadPool(nThreads);
		
		System.out.println("ThreadPooledPrimeServer up and running...");
		
		new Thread(new stopRequest()).start();
		
		while(!stopFlag) {
			ServerEndpoint.Request request = endpoint.blockingReceive();
			if(request.getNumber() == 0) {
				System.out.println("server stopped");
				break;
			}
			executor.execute(new Worker(request.getNumber(),request.getSender()));
		}	
		executor.shutdown();	
	}	
	public static void main(String[] args) {
		new ThreadPooledPrimeServer().dispatcher();
	}

}





