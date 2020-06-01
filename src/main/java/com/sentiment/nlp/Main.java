package com.sentiment.nlp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JavaSentiment("Sentiment Analysis");
        frame.setLocationRelativeTo(null);
        frame.setSize(450,250);
        frame.setVisible(true);
    }
}
