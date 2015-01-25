package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

public class PollingPrimeClient {

    private final long number;
    private Boolean isPrime; 
    PollingPrimeClient(long number) {
		this.number = number;
    }
    
    public void run() {
	ClientEndpoint endpoint = new ClientEndpoint();
	SocketAddress server = new InetSocketAddress("localhost", 4711);
		
	endpoint.send(server, number);
	System.out.print("Die Zahl " + number + " ist ");
	while( (isPrime = endpoint.nonBlockingReceive() ) == null) {
		
		System.out.print(".");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		System.out.println((isPrime ? "eine " : "keine ") + "Primzahl");
    }
    
    public static void main(String[] args) {
		for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
		    new PollingPrimeClient(i).run();
		}
    
    }
}
