package blatt2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import blatt1.ServerEndpoint;

public final class ThreadPooledPrimeServer {
	
	private ExecutorService executor;
	private final ServerEndpoint endpoint;
	private static final int nThreads = 2;
	public volatile boolean poisonPill;
	
	
	
	public ThreadPooledPrimeServer()
	{
		executor = Executors.newFixedThreadPool(nThreads);
		endpoint = new ServerEndpoint();
		poisonPill= false;
	}
	
	void run() {
		System.out.println("ThreadPooledPrimeServer up and running...");

		new Thread(new ServerStop(this)).start();
		
		while (true)
		{
			ServerEndpoint.Request request = endpoint.blockingReceive();
			if (poisonPill){
				break;				
			}
			PrimeCalculator calc = new PrimeCalculator(endpoint, request);
			executor.execute(calc);
		}
	
		executor.shutdown();
		System.out.println("Server stopped.");
	}

	public static void main(String[] args)
	{
		new ThreadPooledPrimeServer().run();
	}
		
}
