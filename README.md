# Simplified-App-Store

A Java-based application store management system that simulates the functionality of a basic app store. This project demonstrates object-oriented programming concepts including encapsulation, data management, and object relationships.

## Overview

The Simplified App Store allows you to:
- Manage multiple app stores with different regional branches
- Add and manage apps with version history and update logs
- Create user accounts linked to specific stores
- Download and uninstall apps
- Submit and track app ratings
- Query stable apps based on number of updates

## Project Structure

```
Simplified_App_Store/
├── src/
│   ├── model/              # Core application classes
│   │   ├── AppStore.java   # Manages apps in a store branch
│   │   ├── App.java        # Represents an application
│   │   ├── Account.java    # User account management
│   │   └── Log.java        # Version update logs
│   └── junit_tests/        # Unit tests
│       └── StarterTests.java
└── bin/                    # Compiled classes
```

## Classes

### Log
Represents a version update log for an app.
- **Attributes**: version number, fixes (comma-separated string), number of fixes, max fixes (10)
- **Methods**: `addFix()`, `getVersion()`, `getFixes()`, `getNumberOfFixes()`, `toString()`

### App
Represents an application in the store.
- **Attributes**: name, ratings (1-5 stars), update history, version information
- **Methods**: 
  - `releaseUpdate(String version)` - Add a new version
  - `submitRating(int rating)` - Submit a rating (1-5)
  - `getAverageRating()` - Get average rating
  - `getRatingReport()` - Get detailed rating breakdown
  - `getVersionInfo(String version)` - Get specific version info
  - `getWhatIsNew()` - Get latest version info

### AppStore
Manages a collection of apps for a specific regional branch.
- **Attributes**: branch name, maximum apps, app collection
- **Methods**:
  - `addApp(App app)` - Add an app to the store
  - `getApp(String name)` - Retrieve app by name
  - `getStableApps(int x)` - Get apps with x or more updates

### Account
Represents a user account linked to a specific store.
- **Attributes**: account name, linked store, downloaded apps
- **Methods**:
  - `download(String name)` - Download an app
  - `uninstall(String name)` - Uninstall an app
  - `submitRating(String name, int rating)` - Rate a downloaded app
  - `switchStore(AppStore store)` - Switch to a different regional store
  - `getNamesOfDownloadedApps()` - Get list of downloaded app names
  - `getObjectsOfDownloadedApps()` - Get downloaded app objects

## Building the Project

This is a standard Java project. To compile:

```bash
# Navigate to the project directory
cd Simplified_App_Store

# Compile all Java files
javac -d bin src/model/*.java src/junit_tests/*.java
```

## Running Tests

The project includes JUnit tests to verify functionality:

```bash
# Ensure JUnit is in your classpath, then run:
java -cp bin:path/to/junit.jar org.junit.runner.JUnitCore junit_tests.StarterTests

# Alternatively, you can use Maven or Gradle to manage dependencies and run tests
```

## Usage Example

```java
// Create an app store
AppStore canadianStore = new AppStore("Canada", 100);

// Create an app (name, max number of ratings allowed)
App app = new App("GoodNotes 5", 15);
app.releaseUpdate("5.7.31");
app.getUpdateHistory()[0].addFix("Better logging");
app.getUpdateHistory()[0].addFix("Improved performance");

// Add app to store
canadianStore.addApp(app);

// Create user account
Account user = new Account("John", canadianStore);

// Download and rate app
user.download("GoodNotes 5");
user.submitRating("GoodNotes 5", 5);

// View app rating
System.out.println(app.getRatingReport());
```

## Features

- **Version Management**: Track app versions with detailed update logs
- **Rating System**: 5-star rating system with average calculations and breakdowns
- **Multi-Store Support**: Support for multiple regional app stores
- **Account Management**: User accounts with download history and rating capabilities
- **Stable App Filtering**: Query apps based on update frequency
- **Error Handling**: Built-in validation for common operations (duplicate downloads, rating uninstalled apps, etc.)

## License

This project is available for educational purposes.