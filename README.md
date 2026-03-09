# Soccer Player Data Project

## Overview

This project is a Java program that reads and processes a dataset of professional soccer players from a CSV file containing approximately 3000 players. The program parses the dataset, stores player information in custom data structures, and allows sorting and searching of player data.

The goal of the project is to demonstrate the implementation of core data structures and algorithms in Java rather than relying on built-in libraries.

## Features

* Parse a CSV dataset of soccer players
* Store player objects in a custom ArrayList implementation
* Sort players using the Merge Sort algorithm
* Search players efficiently using a HashMap
* Display selected player information

## Dataset

The dataset contains player information including:

* Player name
* Age
* National team
* Playing positions
* Overall rating
* Potential rating
* Current club
* Contract start and end year
* Market value
* Weekly wage

The dataset used contains around **3000 players**.

Example entry:

T. Almada,22,Argentina,"CAM, CM, CF",79,87,Atlanta United,2022,2025,39500000,10000

## Project Structure

src/

Main.java – program entry point

model/
SoccerPlayer.java – player data object

parser/
CSVParser.java – handles reading and parsing the dataset

structures/
MyArrayList.java – custom dynamic array implementation
MyHashMap.java – custom hashmap implementation

algorithms/
MergeSort.java – sorting algorithm implementation

dataset/
players.csv – dataset file

## Technologies Used

* Java
* CSV data parsing
* Custom data structures
* Merge Sort algorithm

## Learning Objectives

This project was created to practice:

* File I/O in Java
* CSV parsing
* Implementing custom data structures
* Implementing and applying sorting algorithms
* Working with moderately sized datasets

## How to Run

1. Clone the repository

2. Compile the project

3. Run the main class

Make sure the dataset file (`players.csv`) is located in the dataset folder.

## Authors

Project developed as part of a programming and data structures exercise.

