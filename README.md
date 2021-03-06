# BuildItBigger
Udacity Android Nanodegree: Project 4

#Project description:

#Gradle for Android and Java Final Project
In this project, you will create an app with multiple flavors that uses multiple libraries and Google Could Endpoints. The finished app will consist of four modules. A Java library that provides jokes, a Google Could Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

#Why this Project
As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.

#What Will I Learn?
You will learn the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. You'll learn to:
<ul>
<li>Add free and paid flavors to an app, and set up your build to share code between them</br></li>
<li>Factor reusable functionality into a Java library</br></li>
<li>Factor reusable Android functionality into an Android library</br></li>
<li>Configure a multi project build to compile your libraries and app</br></li>
<li>Use the Gradle App Engine plugin to deploy a backend</br></li>
<li>Configure an integration test suite that runs against the local App Engine development server</br></li>
</ul>

#How Do I Complete this Project?
##Step 0: Starting Point
This is the starting point for the final project, which is provided to you in the course repository. It contains an activity with a banner ad and a button that purports to tell a joke, but actually just complains. The banner ad was set up following the instructions here:

https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start

You may need to download the Google Repository from the Extras section of the Android SDK Manager.

When you can build an deploy this starter code to an emulator, you're ready to move on.

##Step 1: Create a Java library

Your first task is to create a Java library that provides jokes. Create a new Gradle Java project either using the Android Studio wizard, or by hand. Then introduce a project dependency between your app and the new Java Library. If you need review, check out demo 4.01 from the course code.

Make the button display a toast showing a joke retrieved from your Java joke telling library.

##Step 2: Create an Android Library

Create an Android Library containing an Activity that will display a joke passed to it as an intent extra. Wire up project dependencies so that the button can now pass the joke from the Java Library to the Android Library.

For review on how to create an Android library, check out demo 4.03. For a refresher on intent extras, check out;

http://developer.android.com/guide/components/intents-filters.html

##Step 3: Create GCE Module

This next task will be pretty tricky. Instead of pulling jokes directly from our Java library, we'll set up a Google Cloud Endpoints development server, and pull our jokes from there. Follow the instructions in the following tutorial to add a Google Could Endpoints module to your project:

https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints

Introduce a project dependency between your Java library and your GCE module, and modify the GCE starter code to pull jokes from your Java library. Create an Async task to retrieve jokes. Make the button kick off a task to retrieve a joke, then launch the activity from your Android Library to display it.

##Step 4: Add a Paid Flavor

Add free and paid product flavors to your app. Remove the ad (and any dependencies you can) from the paid flavor.

#Rubric
##Required Components
<ul>
<li>Project contains a Java library for supplying jokes</li>
<li>Project contains an Android library with an activity that displays jokes passed to it as intent extras.</li>
<li>Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.</li>
<li>Project contains connected tests to verify that the async task is indeed loading jokes.</li>
<li>Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.</li>
</ul>

#Required Behavior
<ul>
<li>App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.</li>
</ul>

