# RecipeApp (App_Name)

This is one of my task projects for Start Innovation Fellowship program. 
This app helps those who wants to cook a particular food but either does not know the ingredients or has forgotten 
how it's done or might want to try a new food, so they can make use of this app and have a successful cooking experience. 

#Features

With the app, you can:
Login which will require your email and password, then to the list of food and their recipes, could add any of the food to his/her 
favourite list by just a click on the favourite button and vise verse to remove it from the favourite list.
Discover that there are much food you need to try.

#Prerequisites

The things you need to be able to run the app.
You need an android phone with at least of API 16 (LOLLIPOP ANDROID VERSION 4.1--4.4)or a system with with an android enabled features.
you will need data on the phone for the app to be able to load the recipes from the API to the phone interfers.
You can clone the app if i give you my repo link, run it on your android studio or download the APK and run it on your android phone.

#Built With

The app was built with android studio, and an android phone for testing.

#Coding

The language used in the development of this app is pure Java.
I used about six XML resouce files, about Seven java classes and one interfers. 
I used about four colours on the app, which are Red, Green, Blue and Gold.

#Implementation

I will only explain in summarry the Loggin Activity, Recipe_Details_Activity and the MainActivity.
Starting with the Login Activity, After designing the layout and identifying the various ids i went to create the login java activity 
and extend it with Apcompativity so as for it to be compatible with the API of the app, features and other dependencies used on the app
instantiate the objects and then cast them to their various view positions using findViewbyid. Then created the protected class 
onCreate and call their various methods to help validate the email and pasword inputted by the users.

Recipe_Detail_Activity, after also finishing with the layout  which is the interface of the app, i went on to the implementation.
Three main methods came up here, which are the CollapsingToolbar, the details display of the recipes and the Favouriting.
The CollapsingToolBar help hide the image of the recipe when wrapped up to display other details of the recipe.
The Favouriting controls what happens to the favourite and unfavourite button while the main detail activvity itself handles how the 
recipes behaves when displaced in list and details views.

Finally the Main Activity controls and handles the parent or the general activity of the app. Here, it controls the Swipe refresh 
on the list view of the app and the RecycleView taht helps arrange the recipes in a verticle recycling rows. 

#Contributors

None for now.

#Acknowledgments

All thanks to Start Innovation Hub for the oppurtunity she has given to me to learn and the ability to push me to get to learn new 
things.
To the oganiser of Start Up Fellowship team, Mr. Hanson, Mr. Dave, Mr. Nsikak, to mention a few, i really appreciate your great work.
To my fellow colleages, i thank you guys for the love and unity kudos.
