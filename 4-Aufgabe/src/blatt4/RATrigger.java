package blatt4;
import distributedSystem.Message;
import distributedSystem.Process;


public class RATrigger extends Message {
	RATrigger() {
		super(null);
	}
	
	@Override public void getProcessedBy(Process process) {
		((RAProcess) process).process(this);
	}

}
