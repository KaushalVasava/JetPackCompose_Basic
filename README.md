# JetPackCompose Basic to Intermediate

# Introduction
This repository useful to learn basic to intermediate level of Jetpack compose. Jetpack compose(JC) is a modern ui development toolkit.
It serves as a beginner-friendly project, providing an introduction to Jetpack Compose for newcomers and go upto Intermediate level.

UI : You will learn how Compose basic UI element works. Like how to add image, text, list, how to scroll layout, about theming, animaations and colors, etc.

State : You will learn how state management of UI element works in compose. learn about state handling 
        when configuration change, during recomposition and how to use state variable for state-hoisting to re-use 
        Stateless compose element.
        
# Here you will learn
- What is composable function? (BRANCH-1)
- How you can build simple and basic ui elements(composable in JC)(views in xml)? (BRANCH-3)
- How you can build simple screen with these composables? (BRANCH-3)
- What is recomposition and How it works? (BRANCH-4)
- What is State in JC? (BRANCH-4)
- What is State hoisting. (BRANCH-4)
- How to resuse composable to build complex ui? (BRANCH-3,4,5)
- What is LazyRow, LazyColumn and how it works? (ie.Recyclerview in xml) (BRANCH-5)
- How to make animation in JC? (BRANCH-6)
- ViewPager, Card, TabLayout in JC (BRANCH-7, BOTTOM_VIEWPAGER, TAB_LAYOUT)
- News app using these concepts and also use MVVM architecture, Rest API, Retrofit, Coil for Imageloading, Navigation, Testing API in JC. (BRANCH-NEWS_APP)

# Topics
- What is Jetpack compose?:

   Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

- Composable functions:

    Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the @Composable annotation to the function name.
More info 👉 https://developer.android.com/jetpack/compose/tutorial#lesson-1:-composable-functions

- Layouts:

    UI elements are hierarchical, with elements contained in other elements. In Compose, you build a UI hierarchy by calling composable functions from other composable functions.

- Lists and animations:

    Lists and animations are everywhere in apps. In this lesson, you will learn how Compose makes it easy to create lists and fun to add animations.
More info 👉 https://developer.android.com/jetpack/compose/lists

- Navigation:

     The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component’s infrastructure and features.
  
     More info 👉 https://developer.android.com/jetpack/compose/navigation
  
# Branches Info:

#basic_ui_elements : 
Add basic compose elements like searchview, radiobutton,checkbox, edittext, textview, etc.

#1_composable_function_info : 
How composable function works is show in this branch code and how recomposition works in jetpack compose.

#2_add_surface_and_resuse_composable :
Add Surface composable function and how to reuse composable function to make code light weight and clean.

#3_add_rows_and_columns: 
Add Row and colomn to create complex layout in compose.

#4_state_of_composable: 
State of composable is good topic to learn in detail because of it you will find difficulty in recomposition.

#5_add_lazy_list_aka_recyclerview:
Lazy row and lazy column is like horizontal and vertical recyclerview but easy way to implement scrolling behaviour in compose. 

#6_add_animation_and_theme:
Add animation when composable element state changes.

#7_add_card_composable:
Add Card composable or custom composable to maek UI better.

#bottom_viewpager: 
It is a viewpager in Jetpack compose.

#tab-layout: 
Tab layout in Jetpack compose.

#news-app:
News app using Retrofit, MVVM architecture, Compose, Navigation, Lazy list  etc.
# Screenshots 
![Screenshot_2023-07-20-22-40-57-132_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/8dd37cc0-45fe-42a4-b9e0-f598adbf2ba7)
![Screenshot_2023-07-20-22-40-52-894_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/07bc6301-dc44-46d4-a5f6-e667f86481a2)
![Screenshot_2023-07-20-22-41-19-897_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/f560be8b-6ddc-4d9a-8b3e-99ac0bcffcd4)

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/b28eeb2a-fb6a-43bd-9823-dedb83f4cfab

# Android component used:
- Jepack compose for UI development
- Kotlin for programming
- MVVM architecture
- Coil library for dynamic Image loading
- Retrofit for REST API data consuming
- Jetpack compose Navigation
- Lazy list, Card, Other composable functions
- Unit Testing of API

Author: 
Kaushal Vasava

If you like my work then Follow me on LinkedInm  Twitter, Add to Favorite on Github for more information related to app development, Kotlin, etc.
