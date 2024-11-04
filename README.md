
# TicTacToe

A simple and interactive Tic-Tac-Toe game built for Android using Kotlin for the logic and XML for the layout. This project allows two players to alternate turns, automatically detecting when a player wins or when the game results in a draw.

## Features
- **Interactive Gameplay**: Players alternate turns by clicking on a 3x3 grid to place "X" or "O".
- **Game Status**: Displays the current player’s turn and announces the winner or a draw at the end of the game.
- **Invalid Move Prevention**: Ensures players cannot place a mark on an already occupied cell.
- **Reset Button**: A button to restart the game at any time.

## Project Structure
The game interface is structured with a `GridLayout` in XML, representing the Tic-Tac-Toe board as a 3x3 grid of buttons. Above the board, a `TextView` shows the current game status. The game logic, including turn alternation and win/draw detection, is implemented in Kotlin.

## How to Play
1. Player X goes first, followed by Player O. Alternate turns by tapping on any empty cell in the grid.
2. The first player to align three of their symbols horizontally, vertically, or diagonally wins.
3. If all cells are filled without a winner, the game declares a draw.
4. Use the "Restart Game" button to reset the board and start a new game.

## Getting Started
To try the game:
1. Clone this repository.
2. Open the project in Android Studio.
3. Run the application on an Android emulator or physical device.

## Installation
Clone the repository using the command:# PassGen

**PassGen** is a lightweight, user-friendly Android application that helps users generate secure, random passwords with customizable settings. This project is ideal for those who want quick and personalized password generation on their Android device.

## Features

- **Customizable Password Length**: Choose the desired length of your password.
- **Include Uppercase & Lowercase Letters**: Optionally add uppercase and lowercase letters to increase password complexity.
- **Include Numbers**: Add numbers for an additional layer of security.
- **Exclude Similar Characters**: Option to exclude easily confusable characters (e.g., `1`, `I`, `0`, `O`).
- **Hide/Show Password**: Toggle the visibility of the generated password.
- **Copy to Clipboard**: Easily copy your generated password with a single tap.

## Screenshots

![image](https://github.com/user-attachments/assets/263c5963-2db7-466e-9eff-cb0694918957)

## Installation

Clone the repository and open it in Android Studio:

    git clone https://github.com/yourusername/PassGen.git

Then, build and run the project on an Android device or emulator.

## Usage

1. Set the desired password length using the slider.
2. Choose which character sets to include:
   - Uppercase Letters
   - Lowercase Letters
   - Numbers
   - Exclude Similar Characters
3. Tap **Generate Password** to create a new password.
4. Tap the **eye icon** to toggle password visibility.
5. Tap **Copy to Clipboard** to copy the password to your device's clipboard.

## Built With

- **Kotlin** - Main language used
- **Android SDK** - Platform SDK for Android development

---

Enjoy secure and easy password generation with **PassGen**!
