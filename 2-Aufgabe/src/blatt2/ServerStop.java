package blatt2;

import blatt1.ClientEndpoint;
import java.net.InetSocketAddress;
import javax.swing.JOptionPane;


public final class ServerStop implements Runnable {

	private ThreadPooledPrimeServer server;
	private ClientEndpoint endpoint;
	
	public ServerStop(ThreadPooledPrimeServer server) {
		this.server = server;
		endpoint = new ClientEndpoint();
	}
	
	@Override
	public void run() {
		JOptionPane.showMessageDialog(null, "Press OK Button to stop the server.");
		server.poisonPill = true;
		endpoint.send(new InetSocketAddress("localhost", 4711), 1);
	}

}
