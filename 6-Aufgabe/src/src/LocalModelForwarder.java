package versy;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import forum.framework.IForumModel;
import forum.framework.IForumView;

public class LocalModelForwarder implements IForumModel
{

	@Override
	public void deregisterView(String name) throws NotBoundException,
			IOException
	{
		LocalModelReceiver.getInstance().deregisterView(name);
	}

	@Override
	public void moveEast(String name) throws NotBoundException, IOException
	{
		LocalModelReceiver.getInstance().moveEast(name);

	}

	@Override
	public void moveNorth(String name) throws NotBoundException, IOException
	{
		LocalModelReceiver.getInstance().moveNorth(name);

	}

	@Override
	public void moveSouth(String name) throws NotBoundException, IOException
	{
		LocalModelReceiver.getInstance().moveSouth(name);

	}

	@Override
	public void moveWest(String name) throws NotBoundException, IOException
	{
		LocalModelReceiver.getInstance().moveWest(name);

	}

	@Override
	public void registerView(String name, IForumView view)
			throws AlreadyBoundException, IOException
	{
		LocalModelReceiver.getInstance().registerView(name, view);

	}

}
