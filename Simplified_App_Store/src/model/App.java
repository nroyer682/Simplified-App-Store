package model;

public class App {
	// attributes
	private String name;
	private int maxRatings;
	private int numberOfUpdates;
	private Log[] updateHistory;
	private final int maxUpdates = 20;
	private int numberOfRatings;
	private int score1;
	private int score2;
	private int score3;
	private int score4;
	private int score5;
	
	// constructors
	public App(String name, int maxRatings) {
		this.name = name;
		this.maxRatings = maxRatings;
		this.numberOfUpdates = 0;
		this.updateHistory = new Log[maxUpdates];
		this.numberOfRatings = 0;
	}
	
	// getters for each of the data fields
	public String getName() {
		return this.name;
	}
	
	public int getMaxRatings() {
		return this.maxRatings;
	}
	
	public int getNumberOfUpdates() {
		return this.numberOfUpdates;
	}
	
	public Log[] getUpdateHistory() {
		Log[] nl = new Log[this.numberOfUpdates];
		for (int i = 0; i < this.numberOfUpdates; i++) {
			nl[i] = this.updateHistory[i];
		}
		return nl;
	}
	
	public int getMaxUpdates() {
		return this.maxRatings;
	}
	
	public int getNumberOfRatings() {
		return this.numberOfRatings;
	}
	
	// setters for each of the data fields
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMaxRatings(int maxRatings) {
		this.maxRatings = maxRatings;
	}
	
	// get information of the last-released version
	public String getWhatIsNew() {
		if (getUpdateHistory().length == 0) {
			return "n/a";
		}
		else {
			int index = getUpdateHistory().length - 1;
			return getUpdateHistory()[index].toString();
		}
	}
	
	public Log[] getPrivateLogArray() {
		return this.updateHistory;
	}
	
	
	
	// returns Log object associated with the given version number
	public Log getVersionInfo(String version) {
		int index = -1; 
		for (int i = 0; i < this.numberOfUpdates; i++) {
			Log log = this.updateHistory[i];
			if (log.getVersion().equals(version)) {
				index = i;
			}
		}
		if (index < 0) {
			return null;
		}
		else {
			return this.updateHistory[index];
		}
	}
	
	// return the average of submitted ratings
	public String getAverageRating() {
		double average;
		if (this.numberOfRatings == 0) {
			return "n/a";
		}
		else {
			average = (double) (score1 * 1 + score2 * 2 + score3 * 3 + score4 * 4 + score5 * 5) / this.numberOfRatings;
			return String.format("%.1f", average);
		}
	}
	
	// returns ratings report submitted by registered account
	public String getRatingReport() {
		if (this.numberOfRatings == 0) {
			return "No ratings submitted so far!";
		}
		else {
			return String.format("Average of %d ratings: %s (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)", 
					getNumberOfRatings(), getAverageRating(), this.score5, this.score4, this.score3, this.score2, this.score1);
		}
	}
	
	// toString method
	public String toString() {
		return String.format("%s (Current Version: %s; Average Rating: %s)", getName(), getWhatIsNew(), getAverageRating());
	}
	
	// releases app update by adding their version numbers
	public void releaseUpdate(String version) {
		Log update = new Log(version);
		this.updateHistory[this.numberOfUpdates] = update;
		this.numberOfUpdates++;
	}
	
	// submits rating scores to the app, the max amount of ratings is set by the constructor, ratings are assumed to be between 1-5
	public void submitRating(int rating) {
		switch (rating) {
			case 1: 
				score1++;
				break;
			case 2:
				score2++;
				break;
			case 3:
				score3++;
				break;
			case 4:
				score4++;
				break;
			case 5:
				score5++;
				break;
		}
		this.numberOfRatings++;
	}
	
	
}
