# Gymrats
Original App Design Project - README Template
===

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This app will essentially be a social media for individuals who attend the gym or others who are looking for a frinedly community to be a part of that welcomes both experienced and inexpreienced gymrats to come together for their love of body building and fitness.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Social Media/Fitness
- **Mobile:** It will be primarily used in mobile development as it is with most social medias. This allows users to have access to their accounts on the go.
- **Story:** Allow users to come together as part of a fitness community in which they can post, communicate, and sahre workout experiences with eachtother.
- **Market:** It will mostly be targeted towards users who attend the gym or are looking into getting into fitness and do not know where to start.
- **Habit:** This app can be used almost everyday that the users attend the gym to let their fellow gymrats know they are at the gym and what they are working out.
- **Scope:** First individuals would login or create an account. This would then give them choices of indiviuals who are most active on the site and have experience attending the gym and fitness to showcase in their timeline.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Must Login or Signup (Week 1)
* Must have a timeline (Week 1)
* Must include a navigation bar on top (Week 2)
* Access to list of exercises (Week 3)
* Exercise list includes videos to correctly complete the exercises with the right form (Week 4)

**Optional Nice-to-have Stories**

* Like and comment on post (Week 5)
* Google Maps API to locate nearest gym (Week 5)
* View profile (Week 6)
* Gym calendar (Week 6)
* Workout Routine per day (Week 7)
* Diabetes tracker??

### 2. Screen Archetypes

* [list first screen here]
   * [list associated required story here]
   * ...
* [list second screen here]
   * [list associated required story here]
   * ...

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* [fill out your first tab]
* [fill out your second tab]
* [fill out your third tab]

**Flow Navigation** (Screen to Screen)

* Sign up/ Login screen
   * user can sign up or register for the website
  
* Timeline
   * Showcases the post and comments of different individuals
* Excercises
   * Showcases the different exercises by calling on the API and putting them in a recycler view
* Youtube 
    * Shows videos on how to corretly perform exercises 
   

## Wireframes

<img src="![](https://i.imgur.com/gfFm7Dv.png)
          
" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | userId      | String   | unique id for the user post (default field) |
   | author        | Pointer to User| image author |
   | image         | File     | image that user posts |
   | caption       | String   | image caption by author |
   | commentsCount | Number   | number of comments that has been posted to an image |
   | likesCount    | Number   | number of likes for the post |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
   
### Networking
- Home Feed Screen
      - (Read/GET) Query all posts where user is author
         ```swift
         let query = PFQuery(className:"Post")
         query.whereKey("author", equalTo: currentUser)
         query.order(byDescending: "createdAt")
         query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
            if let error = error { 
               print(error.localizedDescription)
            } else if let posts = posts {
               print("Successfully retrieved \(posts.count) posts.")
           // TODO: Do something with posts...
            }
         }
         ```
      - (Create/POST) Create a new like on a post
      - (Delete) Delete existing like
      - (Create/POST) Create a new comment on a post
      - (Delete) Delete existing comment
   - Create Post Screen
      - (Create/POST) Create a new post object
   - Profile Screen
      - (Read/GET) Query logged in user object
      - (Update/PUT) Update user profile image
