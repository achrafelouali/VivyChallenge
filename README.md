

# VIVY TAKE HOME TEST CHALLENGE
This repository contains a nearby doctor search application for VIVY
<p align="center">
  <img src="http://achraf.fps-platform.com/splash_screen.png" width="250">
  <img src="http://achraf.fps-platform.com/login_screen.png" width="250">
  <img src="http://achraf.fps-platform.com/doctors_list_screen.png" width="250">
</p>
<br>
<br>

# Project Structure
![Structure](http://achraf.fps-platform.com/architecture.jpg)
<br>

# MVP ARCHITECTURE

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **service**: Services for the application.
5. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. Dagger2: [https://github.com/google/dagger](https://github.com/google/dagger)
2. FastAndroidNetworking: [https://github.com/amitshekhariitbhu/Fast-Android-Networking](https://github.com/amitshekhariitbhu/Fast-Android-Networking)
3. Gson : [https://github.com/google/gson](https://github.com/google/gson)
4. Glide : [https://github.com/bumptech/glide](https://github.com/bumptech/glide)
5. PlaceHolderView: https://github.com/janishar/PlaceHolderView
6. ButterKnife: http://jakewharton.github.io/butterknife/
7. RxJava2: [https://github.com/amitshekhariitbhu/RxJava2-Android-Samples](https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
8.  RxPermission: [https://github.com/vanniktech/RxPermission](https://github.com/vanniktech/RxPermission)
9.  RxLocation:[ https://github.com/abdularis/rxlocation](https://github.com/abdularis/rxlocation)

# App features
```
1. Launching the App
2. Checking ACCESS_COARSE_LOCATION
3. Fetching location
4. Redirect to Login screen or Main screen
5. User Log-in with email and password
6. User redirected to search screen
7. Search by name
8. Get results
```

# REMARKS
1. After calling the Log-in API with a valid email and login, API provides AccessToken, RefreshToken and token expiry time, however in best practices when the user is logged in and access token is expired we need to renew it using the given refresh token instead of forcing user to Logout.
In our case we force user to logout since the API of renewing token was not found.
2. Location fetching is done in the splash screen for a simple reason that the app don't need a real time location tracking
3. I remarked that the "Search doctors" API is providing results even if the location is far away from Germany (Tested with moroccan location) you can find a curl for testing it below :  [https://reqbin.com/vk6ofkne](https://reqbin.com/vk6ofkne)


# TESTING
Using the MVP architecture makes doing unit test an easy task, i JUnit and MOCKITO to test Model and Presenter Layers : 
<p align="center">
  <img src="http://achraf.fps-platform.com/tests.png" width="250">
</p>

ESPRESSO was used for UI tests :
<p align="center">
  <img src="http://achraf.fps-platform.com/ui_test.png" width="250">
</p>



### License
```
Licensed under the Apache License, Version 2.0