package blatt6;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import forum.framework.ForumModel;
import forum.framework.IForumModel;
import forum.framework.IForumView;

public class LocalModelReceiver implements IForumModel, Runnable
{

	private static LocalModelReceiver instance = new LocalModelReceiver();
	private ForumModel forumModel;

	private LocalModelReceiver()
	{
		forumModel = ForumModel.INSTANCE;
	}

	public static LocalModelReceiver getInstance()
	{
		return instance;
	}

	@Override
	public void deregisterView(String name) throws NotBoundException,
			IOException
	{
		forumModel.deregisterView(name);
	}

	@Override
	public void moveEast(String name) throws NotBoundException, IOException
	{
		forumModel.moveEast(name);

	}

	@Override
	public void moveNorth(String name) throws NotBoundException, IOException
	{
		forumModel.moveNorth(name);

	}

	@Override
	public void moveSouth(String name) throws NotBoundException, IOException
	{
		forumModel.moveSouth(name);
	}

	@Override
	public void moveWest(String name) throws NotBoundException, IOException
	{
		forumModel.moveWest(name);
	}

	@Override
	public void registerView(String name, IForumView view)
			throws AlreadyBoundException, IOException
	{
		forumModel.registerView(name, view);
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	}

}
