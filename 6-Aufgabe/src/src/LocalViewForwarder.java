package versy;

import java.io.IOException;
import java.util.Map;

import forum.framework.IForumView;
import forum.framework.Position;

public class LocalViewForwarder implements IForumView
{
	
	@Override
	public void notifyView(Map<String, Position> folks) throws IOException
	{
		LocalViewReceiver.getInstance().notifyView(folks);
		
	}

}
