# QuizAppSummer2023
Add pictures to each question
Added a setup/settings page that allows the user to choose:
choose a mode of navigations through the quiz (no skipping, skipping-with penalty)
user can choose one of four colors, respectively, for each button
user (should be change for a manager) can pick the point value of rewards and penalties
These implemented features store and recall all settings in a SharedPreference file making user selection and high score data persistent.
Back button (override back on phone, penalize score)
Option 1: Accumulate a list of high scores using a data storage technique, and display those scores and the users who earned them in a HighScoresActivity.
this added features also ranks three top scores: Top, Middle, Low, and breaks ties by using time duration of play
Option 2: Any data storage solution (SharedPreference, FileStorage, or Firebase) incorporated into the quiz app.
SharePreference files are used throughout
The timed play was implemented and records display along with highest score data.
A HighScore class was added with the intention to use it to create an arraylist with which populate a GridView Layout of the Highest scores.  However, time ran out on implementing it.  I settled for a much more straightforward display using a linearlayout with TextViews instead.
player can choose whether or not to play music.
music added,
top three ranking enhanced to compare both score and time when determing each placing, not just when new score is equal.
