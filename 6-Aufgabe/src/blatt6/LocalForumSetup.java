package blatt6;

import forum.framework.ForumClient;
import forum.framework.ForumServer;

public class LocalForumSetup
{
	public static void main(String[] args)
	{
		ForumServer server = new ForumServer(LocalModelReceiver.getInstance());
		
		try
		{
			ForumClient client1 = new ForumClient(new LocalModelForwarder());
			ForumClient client2 = new ForumClient(new LocalModelForwarder());
			client1.register();
			client2.register();
		}
		catch ( Exception e)
		{
			System.err.printf("Error: %s: %s.", e.toString(), e.getMessage());
		}
	}
}
