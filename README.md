# AI-Based Recommendation System (Java Project)

"COMPANY": CODETECH IT SOLUTIONS

"NAME": S VENKATESH

"INTERN ID": CT04DH921

"DOMAIN": JAVA PROGRAMMING

"DURATION": 4 WEEKS

"MENTOR": NEELA SANTOSH KUMAR

This project is a simple yet elegant **AI-based recommendation system** developed using **pure Java**. It simulates a basic version of a collaborative filtering engine to recommend books to users based on the ratings given by others.

The system reads user-item-rating data from a `.csv` file and recommends top books using a hybrid logic of personalized and popular item-based filtering.

## Objective

To build a **Java-based recommendation engine** that:

- Loads user-item rating data from a CSV file
- Recommends books to a user based on other users' ratings
- Applies logic similar to collaborative filtering
- Is fully functional through terminal/CLI (no GUI)
- Avoids third-party APIs (follows handwritten coding style)

## Technologies Used

- Java Core (OOP, Collections)
- File handling with CSV
- Terminal-based interaction
- Clean folder structure
- No external libraries or frameworks

## Sample Data (`books.csv`)

userId,bookName,rating
1,The Alchemist,5
1,Atomic Habits,3
2,The Alchemist,4
2,Deep Work,5
3,Atomic Habits,4
3,Deep Work,2
4,1984,5
4,Atomic Habits,4
4,Rich Dad Poor Dad,5
5,Rich Dad Poor Dad,4
5,The Psychology of Money,5

## How to Run

Step-by-Step (Windows or Linux/Mac)
Open terminal and navigate to project folder.

### Compile the project:

javac -d out src/*.java

### Run the program:

java -cp out Main
Enter a user ID (e.g. 1–5) to get book recommendations.

## Screenshots

![Image](https://github.com/user-attachments/assets/bc588226-5460-46b8-b501-5d1774909afa)
