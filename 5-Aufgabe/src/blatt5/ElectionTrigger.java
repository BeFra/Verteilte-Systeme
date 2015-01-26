package blatt5;

import distributedSystem.Message;
import distributedSystem.Process;

public class ElectionTrigger extends Message {

	protected ElectionTrigger() {
		super(null);
	}

	@Override
	public void getProcessedBy(Process process) {
		((BullyProcess) process).process(this);

	}

}
