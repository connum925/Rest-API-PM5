# Book Discovery and User Authentication App - Practice 5 - APP MOBILE COURSE

This Android application allows users to discover books using the Open Library API and manage user accounts and favorite books with Firebase Realtime Database.

## Table of Contents

* [Features](#features)
* [Technologies Used](#technologies-used)
* [Setup Instructions](#setup-instructions)
    * [Prerequisites](#prerequisites)
    * [Firebase Configuration](#firebase-configuration)
    * [Open Library API](#open-library-api)
    * [Building the App](#building-the-app)
* [Firebase Realtime Database Details](#firebase-realtime-database-details)
    * [User Authentication](#user-authentication)
    * [Favorite Books Management](#favorite-books-management)
* [Screenshots](#screenshots)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

## Features

* **User Authentication:** Users can create accounts (sign up) and log in using Firebase Realtime Database for secure storage of user credentials.
* **Book Search:** The app utilizes the Open Library API to search for books by keywords.
* **Book Details:** Users can view detailed information about a selected book, including title, author, cover image, and description.
* **Favorite Books:** Users can add and remove books from their favorites list.  These favorites are persisted in Firebase Realtime Database, specific to each user.
* **Navigation Drawer:** A navigation drawer provides a user-friendly interface for accessing different sections of the app (Home, Favorites).
* **Logout:** Users can log out of their session.

## Technologies Used

* **Kotlin:** The primary programming language for Android development.
* **Android SDK:** The software development kit for building Android applications.
* **Firebase Realtime Database:** Used for user authentication (sign-up and login) and managing user's favorite books.
* **Retrofit:** A type-safe HTTP client for making network requests to the Open Library API.
* **Gson:** A Java library to convert JSON into Kotlin objects.
* **Glide:** An image loading library for displaying book covers.
* **AndroidX:** For modern Android development practices.
* **Navigation Component:** For handling in-app navigation (partially implemented).
* **ViewModel and LiveData:** For managing UI-related data in a lifecycle-conscious way.

## Setup Instructions

### Prerequisites

* Android Studio installed on your development machine.
* A Firebase project created on the Firebase Console ([https://console.firebase.google.com/](https://console.firebase.google.com/)).
* A Google account.

### Firebase Configuration

1.  **Create a Firebase Project:**
    * Go to the Firebase Console and create a new project.
    * Give your project a name.
    * Follow the steps to set up your project.

2.  **Enable Realtime Database:**
    * In your Firebase project, go to "Realtime Database" in the "Build" section.
    * Create a new Realtime Database. You can start in test mode for development.
    * Take note of your Realtime Database URL (you'll need this for configuration, though it's usually handled by the `google-services.json` file).

3.  **Download `google-services.json`:**
    * In your Firebase project, go to "Project settings".
    * Under "Your apps," select the Android icon to add your app if you haven't already.
    * Enter your app's package name (e.g., `com.example.practica5f`). **This is crucial and must match your app's package name.**
    * Register the app and download the `google-services.json` file.

4.  **Add `google-services.json` to your project:**
    * In Android Studio, switch to the "Project" view (not "Android").
    * Place the `google-services.json` file in the `app/` directory of your project.

5.  **Configure Project-Level `build.gradle.kts`:**
    * Open the `build.gradle.kts` file at the **project root**.
    * Add the Google Services plugin as a classpath dependency:

    ```kotlin
    plugins {
        // ... other plugins
        id("com.google.gms.google-services") version "4.4.0" apply false // Check for the latest version
    }
    ```

6.  **Configure App-Level `build.gradle.kts`:**
    * Open the `build.gradle.kts` file in the `app/` directory.
    * Apply the Google Services plugin:

    ```kotlin
    plugins {
        // ... other plugins
        id("com.google.gms.google-services")
    }
    ```
    * Ensure you have the Firebase Realtime Database dependency:

    ```kotlin
    dependencies {
        // ... other dependencies
        implementation(platform("com.google.firebase:firebase-bom:32.7.2")) // Or latest version
        implementation("com.google.firebase:firebase-database-ktx")
    }
    ```
    * **Important:** Replace `"32.7.2"` with the latest Firebase BoM (Bill of Materials) version. Check the Firebase documentation for the most up-to-date version.

7.  **Enable Internet Permission:**
    * Open your `AndroidManifest.xml` file and ensure you have the internet permission:

    ```xml
    <uses-permission android:name="android.permission.INTERNET" />
    ```

### Open Library API

This application uses the Open Library API to fetch book data. No specific API key is required, as the Open Library API is generally open for public use. The base URL for the API is defined in `RetrofitClient.kt`:

```kotlin
private const val BASE_URL = "[https://openlibrary.org/](https://openlibrary.org/)"
