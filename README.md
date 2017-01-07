# Splash Activity Sample 2
 
 A simple logic to run a splash screen on the first run of the app, based on:
 1. invisible activity
 2. shared preferences flag
 
 The read/write is done (correctly) on a user thread.
 
 
 #### Advantages
 - The invisible activity can be used to bootstrap the database and load assets before the first activity is shown. 
 - Splash will be called again after data wipe (or is this a disadvantage?)
 - Not requiring additional run configuration
 - Simple
 
 #### Disadvantages
 - The invisible activity will always be called before the app, not the very first time only.
 - splash will always appear during development, but it could be disabled in debug mode:
    - if (BuildConfig.DEBUG) { skip splash }
 - There will be a short overhead with this approach of an additional 500-1000 ms on loading. 
  
 To save the overhead time, consider using the [other](https://github.com/auval/SplashActivityExample) approach.
  
 