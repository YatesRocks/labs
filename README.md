# Project Layout

I follow Model-View-Controller throughout this project. I try my best to split functionality up, but there are a few bloated classes.

- `${PROJECT_DIR}/src/main/java/labs/yates/App.java` 
  - The entry point.
- `${PROJECT_DIR}/src/main/java/labs/yates/view/panels` 
  - This is where the "views" are held, each one deriving from BasePanel.
- `${PROJECT_DIR}/src/main/java/labs/yates/view/components` 
  - This is where reusable UI components live.
- `${PROJECT_DIR}/src/main/java/labs/yates/model` 
  - This is where complex business logic is stored, except Lab 11 which
    was trivial enough to stick in the controller.
- `${PROJECT_DIR}/src/main/java/labs/yates/controller` 
  - This is where I store the controllers, responsible for updating
    the model based on events that happen (save, open file, etc).


### Out of the ordinary

Some of the things that might be unexpected is the `CardController` class.
CardController just switches the "view" from one JPanel to another, these
"views" are held in a CardLayout that the singleton CardController manages
and can switch between at any point. It makes it trivial to add new pages
to the application.

## How to run

Super simple setup. If you're in IntelliJ, you should be able to
see the **run** task in the Gradle menu under **Application** group. 
Or if you're on the command line:

**Windows**: `gradlew.bat run`

**Linux**: `./gradlew run`