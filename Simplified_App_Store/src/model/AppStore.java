package model;

public class AppStore {
	// attributes
	private String branch;
	private int maxApps;
	private App[] apps;
	private int numberOfApps;
	
	// constructors
	public AppStore(String branch, int maxApps) {
		this.branch = branch;
		this.maxApps = maxApps;
		this.apps = new App[maxApps];
	}
	
	// getters for each of the data fields 
	public String getBranch() {
		return this.branch;
	}
	
	public App[] getPrivateAppArray() {
		return this.apps;
	}
	
	public int getMaxApps() {
		return this.maxApps;
	}
	
	public int getNumberOfApps() {
		return this.numberOfApps;
	}
	
	public App[] getApps() {
		App[] na = new App[this.numberOfApps];
		for (int i = 0; i < this.numberOfApps; i++) {
			na[i] = this.apps[i];
		}
		return na;
	}
	
	// setters for each of the data fields
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public void setMaxApps(int maxApps) {
		this.maxApps = maxApps;
	}
	
	
	// return the app object of the given name
	public App getApp(String name) {
		int index = -1;
		for (int i = 0; i < this.numberOfApps; i++) {
			App app = this.apps[i];
			if (app.getName().equals(name)) {
				index = i;
			}
		}
		
		if (index < 0) {
			return null;
		}
		else {
			return this.apps[index];
		}
	}
	
	// return the info of all available apps that are stable (i.e., contain more than x updates)
	public String[] getStableApps(int x) {
		int count = 0;
		int[] indices = new int[this.numberOfApps];
		
		for (int i = 0; i < this.numberOfApps; i++) {
			int num = this.apps[i].getNumberOfUpdates();
			if (num >= x) {
				indices[count] = i;
				count++;
			}
		}
		
		String[] stableApps = new String[count];
		
		for (int i = 0; i < count; i++) {
			App app = this.apps[indices[i]];
			
			stableApps[i] = String.format("%s (%d versions; Current Version: %s)", app.getName(), app.getNumberOfUpdates(), app.getWhatIsNew());
		}
		
		return stableApps;
	}
	
	// add app to store
	public void addApp(App app) {
		this.apps[this.numberOfApps] = app;
		this.numberOfApps++;
	}
	
	
}
