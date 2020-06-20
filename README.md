# Calculator-Android-App
###  A simple Calculator app using kotlin

#### Update:
* Now the apps uses MVVM (View Model) design Pattern. Where the business logic (View Model) for calculating operations and handling operands is completely seperated from the client (View) and Activity (Model).
* The View Model does not hold any referrences to view or the model.
* This helped me in designing this app in such a way that I am able to restore the all the values even if the activity is destroyed. (Bye bye SharedPrefereneces!!)

#### ScreenShot 1
<img src = "https://github.com/kshadep7/Calculator-Android-App-/blob/master/app/src/main/res/calcy1.png" width="300" height="500" alt = "ScreenShot_1">

#### ScreenShot 2
<img src = "https://github.com/kshadep7/Calculator-Android-App-/blob/master/app/src/main/res/calcy2.png" width="500" height="300" alt = "ScreenShot_2">
