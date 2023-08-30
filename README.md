# JetPackCompose Basic to Intermediate

# Introduction
This repository useful to learn basic to intermediate level of Jetpack compose. Jetpack compose(JC) is a modern ui development toolkit.
It serves as a beginner-friendly project, providing an introduction to Jetpack Compose for newcomers and go up to Intermediate level.

UI : You will learn how Compose basic UI element works. Like how to add image, text, list, how to scroll layout, about theming, animations and colors, etc.

State : You will learn how state management of UI element works in compose. learn about state handling 
        when configuration change, during recomposition and how to use state variable for state-hoisting to re-use 
        Stateless compose element.
        
# Here you will learn
- What is composable function? (BRANCH-1)
- How you can build simple and basic ui elements(composable in JC)(views in xml)? (BRANCH-3)
- How you can build simple screen with these composable? (BRANCH-3)
- What is recomposition and How it works? (BRANCH-4)
- What is State in JC? (BRANCH-4)
- What is State hoisting. (BRANCH-4)
- How to reuse composable to build complex ui? (BRANCH-3,4,5)
- What is LazyRow, LazyColumn and how it works? (ie.Recyclerview in xml) (BRANCH-5)
- How to make animation in JC? (BRANCH-6)
- ViewPager, Card, TabLayout in JC (BRANCH-7, BOTTOM_VIEWPAGER, TAB_LAYOUT)
- How to create Widget in Jetpack Compose? (BRANCH- ADD_WIDGET)
- How to create bottom navigation bar in Jetpack compose? (BRANCH - bottom_nav)
- How to create simple timer app with canvas? (BRANCH - timer)
- Build complex mediation ui. (BRANCH - meditation_ui)
- News app using these concepts and also use MVVM architecture, Rest API, Retrofit, Coil for Image loading, Navigation, Testing API in JC. (BRANCH-NEWS_APP)
- Add Text style using shape and animation to text. (BRANCH - text-styling)
- Navigate back with next screen to previous screen. (BRANCH - navigate-back-with-result)
  
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

     The Navigation component provides support for Jetpack Compose applications. You can navigate between composable while taking advantage of the Navigation component’s infrastructure and features.

     More info 👉 https://developer.android.com/jetpack/compose/navigation

# Android components used:
- Jetpack compose for UI development
- Kotlin for programming
- MVVM architecture
- Coil library for dynamic Image loading
- Retrofit for REST API data consuming
- Jetpack compose Navigation
- Lazy list, Card, Other composable functions
- Unit Testing of API
- Animations
- Viewpager
- Bottomsheet
- Tab layout
- State managements

# Branches Info:
#1_composable_function_info : 
How composable function works is show in this branch code and how recomposition works in jetpack compose.

#3_add_rows_and_columns: 
Add Row and column to create complex layout in compose.

#4_state_of_composable: 
State of composable is good topic to learn in detail because of it you will find difficulty in recomposition.

#5_add_lazy_list_aka_recyclerview:
Lazy row and lazy column is like horizontal and vertical recyclerview but easy way to implement scrolling behaviour in compose. 

#6_add_animation_and_theme:
Add animation when composable element state changes.

#7_add_card_composable:
Add Card composable or custom composable to make UI better.

#bottom_viewpager: 
It is a viewpager in Jetpack compose.

#tab-layout: 
Tab layout in Jetpack compose.

#Constraint-layout:
Use Constaint layout to make Indian flag.

#add_widget:
Create Simple counter widget in JC.

#bottom_nav_bar:
Created botttom navigation bar.

#meditation_ui:
Created complex UI

#timer:
Created timer app

#news-app:
News app using Retrofit, MVVM architecture, Compose, Navigation, Lazy list  etc.

#text-styling
Add Text stlying and animations

#navigate-back-with-result
Navigate back with next screen to previous screen

# Screenshots & Videos: 

![Screenshot_2023-07-20-22-40-57-132_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/8dd37cc0-45fe-42a4-b9e0-f598adbf2ba7)
![Screenshot_2023-07-20-22-40-52-894_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/07bc6301-dc44-46d4-a5f6-e667f86481a2)
![Screenshot_2023-07-20-22-41-19-897_com lahsuak apps jetpackcomposebasic](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/f560be8b-6ddc-4d9a-8b3e-99ac0bcffcd4)
![Screenshot 2023-07-25 155236](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/249576b5-e9f5-4d04-9f10-0f032b02693c)
![Screenshot 2023-08-01 185044](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/9c6019df-8195-41ee-8a7d-0e8df8bd1f3d)

Lazy column with animations

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/7e92754d-b7d8-4b93-bdf2-5b06d30c2d00

NewsApp

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/b28eeb2a-fb6a-43bd-9823-dedb83f4cfab

Timer

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/b77cb850-f710-4155-9500-961bca5413eb

Bottom Navigation Bar

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/2cf7f449-08f7-4973-a8f0-46e7b5dcc4f8

Tab layout

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/2ec0b2f2-5ecd-43f7-ac8a-77d092664cf2

Viewpager 

[Screen_recording_20230801_184816.webm](https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/1efc21d0-e5db-4d2c-b7e3-aeb67ff19235)

Text Styling

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/6de7f19b-e2b5-48ab-a7c0-ec46d593e3cb

Navigate back with result

https://github.com/KaushalVasava/JetPackCompose_Basic/assets/49050597/1d96d44f-66e1-4f3b-bba1-2844ab6553cc

# Contribution
You can contribute this project. Just Solve issue or update code and raise PR. I'll do code review and merge your changes into main branch. See Commit message guidelines https://initialcommit.com/blog/git-commit-messages-best-practices

# Licence
Copyright 2023 Kaushal Vasava

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

# Author
Kaushal Vasava

If you like my work then Follow me on LinkedIn, Twitter for more information related to app development, Kotlin, etc and Add to Favorite on Github .
