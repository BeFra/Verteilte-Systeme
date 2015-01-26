package blatt5;

import distributedSystem.Message;
import distributedSystem.Process;

public class ElectionResponse extends Message {

	protected ElectionResponse(Process sender) {
		super(sender);
	}

	@Override
	public void getProcessedBy(Process process) {
		((BullyProcess) process).process(this);

	}

}
