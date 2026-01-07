package model;

public class Account {
	// attributes
	private String accountName;
	private AppStore store;
	private String status;
	private int numberOfDownloads;
	private App[] downloadedApps;

	
	// constructor
	public Account(String accountName, AppStore store) {
		this.accountName = accountName;
		this.store = store;
		this.downloadedApps = new App[this.store.getMaxApps()];
		this.status = String.format("An account linked to the %s store is created for %s.", getStore().getBranch(), getAccountName());;
		this.numberOfDownloads = 0;
	}
	
	// getters for each of the private instance fields
	public String getAccountName() {
		return this.accountName;
	}
	
	public AppStore getStore() {
		return this.store;
	}
	
	public int getNumberOfDownloads() {
		return this.numberOfDownloads;
	}
	
	// setters for each of the private instance fields
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public void setStore(AppStore store) {
		this.store = store;
	}
	
	public int indexOf(String name) {
		int index = -1;
		for (int i = 0; i < this.numberOfDownloads; i++) {
			if (this.downloadedApps[i].getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}
	
	// return the names of downloaded apps
	public String[] getNamesOfDownloadedApps() {
		String [] names = new String[this.numberOfDownloads];
		for (int i = 0; i < this.numberOfDownloads; i++) {
			App app = this.downloadedApps[i];
			names[i] = app.getName();
		}
		return names;
	}
	
	// return all app objects of downloaded apps
	public App[] getObjectsOfDownloadedApps() {
		App[] da = new App[this.numberOfDownloads];
		for (int i = 0; i < this.numberOfDownloads; i++) {
			da[i] = this.downloadedApps[i];
		}
		return da;
	}
	
	// download app for registered accounts
	public void download(String name) {
		boolean isDownloaded = false;
		for (int i = 0; i < this.numberOfDownloads; i++) {
			String appName = getNamesOfDownloadedApps()[i];
			if (appName.equals(name)) {
				isDownloaded = true;
			}
		}
		if (isDownloaded == false) {
			this.downloadedApps[this.numberOfDownloads] = this.store.getApp(name);
			this.numberOfDownloads++;
			this.status = String.format("%s is successfully downloaded for %s.", name, getAccountName());
		}
		else {
			this.status = String.format("Error: %s has already been downloaded for %s.", name, getAccountName());
		}
		
	}
	
	// uninstall app with given name, if it exists (i.e., remove app from account)
	public void uninstall(String name) {
		if (indexOf(name) < 0) {
			this.status = String.format("Error: %s has not been downloaded for %s.", name, getAccountName());
		}
		else {
			App[] na = new App[this.numberOfDownloads];
			for (int i = 0, j = 0; i < this.numberOfDownloads; i++) {
				if (i != indexOf(name)) {
					na[j] = this.downloadedApps[i];
					j++;
				}
			}
			this.numberOfDownloads--;
			this.downloadedApps = na;
			this.status = String.format("%s is successfully uninstalled for %s.", name, getAccountName());
		}
		
	}
	
	// if app object is found with given name, then submit rating with given rating
	public void submitRating(String name, int rating) {
		if (indexOf(name) < 0) {
			this.status = String.format("Error: %s is not a downloaded app for %s.", name, getAccountName());
		}
		else {
			this.downloadedApps[indexOf(name)].submitRating(rating);
			this.status = String.format("Rating score %d of %s is successfully submitted for %s.", rating, getAccountName(), name);
		}
	}
	
	// switch to a different store for the account
	public void switchStore(AppStore store) {
		setStore(store);
		this.status = String.format("Account for %s is now linked to the %s store.", getAccountName(), getStore().getBranch());
	}
	
	// toString method for Account
	public String toString() {
		return this.status;
	}
	
}
