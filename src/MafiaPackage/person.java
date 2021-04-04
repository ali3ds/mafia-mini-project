package MafiaPackage;

public abstract class person {
	 String name;
	int votes=0;
	boolean isAlive = true;
	boolean isSilenced=false;
	boolean hasToWakeUp = false;

	public void dead() {
		isAlive=false;
	}
	public void resetVotes() {
		this.votes=0;
	}
}
