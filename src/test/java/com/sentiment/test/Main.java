package com.sentiment.test;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.print("Please enter your message: ");
        // Get the user sentence
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        ArrayList<ArrayList<String>> answers = sentimentAnalysis.predictSentiment(text);
        for (ArrayList<String> list : answers)
        {
            String sentence = list.get(0);
            String sentiment = list.get(1);
            System.out.println(sentence + ": " + sentiment);
        }
    }
}
