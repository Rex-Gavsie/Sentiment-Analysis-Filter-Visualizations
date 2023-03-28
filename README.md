# Goal
The goal of this project is to be able to look at how a NN processes text in a visual manner by looking at the filters in a convolutional nueral network

# Parts:

## The Preprocessor
The preprocessor will take Strings/Text files as inputs and will convert them into images where the color at any given pixel represents its ASCII table index.

For the sake of looks/being able to tell apart the 128 colors, I'll add in an ability to convert the char into RGB values instead of grayscale.

## The Model
The Sentiment Analysis itself will be done by a convolutional nueral network. This may not be the greatest way to do it, but as long as it works, it doesn't matter.

## The Model Visualizer
The Model Visualizer will be a program that allows you to access and see the filters of the nueral network. They might not look like anything, but they also might look cool, and either way, it'll be 'art'.
