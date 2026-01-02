package model;

public class Log {
	// attributes
	private String version;
	private int numberOfFixes;
	private String fixes;
	private final int maxFixes = 10;
	
	// constructors
	public Log(String version) {
		this.version = version;
		this.numberOfFixes = 0;
		this.fixes = "";
	}
	
	// getters for each of the data fields
	public String getVersion() {
		return this.version;
	}
	
	public int getNumberOfFixes() {
		return this.numberOfFixes;
	}
	
	public String getFixes() {
		return String.format("[%s]", this.fixes);
	}
	
	public int getMaxFixes() {
		return this.maxFixes;
	}
	
	
	// setters for each of the data fields
	public void setVersion(String version) {
		this.version = version;
	}
	
	// add fix to log
	public void addFix(String fix) {
		if (this.fixes.equals("")) {
			this.fixes += fix;
		}
		else {
			this.fixes += ", ";
			this.fixes += fix;
		}
		this.numberOfFixes++;
	}
	
	// toString method
	public String toString() {
		return String.format("Version %s contains %d fixes %s", getVersion(), getNumberOfFixes(), getFixes());
	}
	
	
	
	
}
