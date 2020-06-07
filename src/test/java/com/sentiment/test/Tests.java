package com.sentiment.test;
import org.junit.*;
import com.sentiment.nlp.*;

import java.util.ArrayList;

public class Tests
    {
    @Test
    public void SentencesThatShouldYiledPositiveSentiment()
        {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String PositiveSentence_1 = "Today is a beautiful day!";
        String PositiveSentence_2 = "It is very bright and warm outside.";
        String PositiveSentence_3 = "We are having fun celebrating Olegs' birthday.";

        ArrayList<ArrayList<String>> Prediction_1 = sentimentAnalysis.predictSentiment(PositiveSentence_1);
        ArrayList<ArrayList<String>> Prediction_2 = sentimentAnalysis.predictSentiment(PositiveSentence_2);
        ArrayList<ArrayList<String>> Prediction_3 = sentimentAnalysis.predictSentiment(PositiveSentence_3);

        for (ArrayList<String> list : Prediction_1)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Very positive", sentiment);
            }

        for (ArrayList<String> list : Prediction_2)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Very positive", sentiment);
            }

        for (ArrayList<String> list : Prediction_3)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Positive", sentiment);
            }
        }

    @Test
    public void SentencesThatShouldYiledNeutralSentiment()
        {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String NeutralSentence_1 = "Today is another regular day.";
        String NeutralSentence_2 = "I ate a tasteless apple.";
        String NeutralSentence_3 = "Four is two times two";

        ArrayList<ArrayList<String>> Prediction_1 = sentimentAnalysis.predictSentiment(NeutralSentence_1);
        ArrayList<ArrayList<String>> Prediction_2 = sentimentAnalysis.predictSentiment(NeutralSentence_2);
        ArrayList<ArrayList<String>> Prediction_3 = sentimentAnalysis.predictSentiment(NeutralSentence_3);

        for (ArrayList<String> list : Prediction_1)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Neutral", sentiment);
            }

        for (ArrayList<String> list : Prediction_2)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Neutral", sentiment);
            }

        for (ArrayList<String> list : Prediction_3)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Neutral", sentiment);
            }
        }

    @Test
    public void SentencesThatShouldYiledNegativeSentiment()
        {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String NegativeSentence_1 = "I hurt my knee and cried very very much.";
        String NegativeSentence_2 = "Someone just got stabbed and is dying!";
        String NegativeSentence_3 = "He is the biggest loser in the city...";

        ArrayList<ArrayList<String>> Prediction_1 = sentimentAnalysis.predictSentiment(NegativeSentence_1);
        ArrayList<ArrayList<String>> Prediction_2 = sentimentAnalysis.predictSentiment(NegativeSentence_2);
        ArrayList<ArrayList<String>> Prediction_3 = sentimentAnalysis.predictSentiment(NegativeSentence_3);

        for (ArrayList<String> list : Prediction_1)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Negative", sentiment);
            }

        for (ArrayList<String> list : Prediction_2)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Negative", sentiment);
            }

        for (ArrayList<String> list : Prediction_3)
            {
            String sentiment = list.get(1);
            Assert.assertEquals("Negative", sentiment);
            }
        }

    @Test
    public void OutputOfSentencesShouldSucceedIfItDoesNotMatchOriginalInput()
        {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String Sentence_1 = "One, two, three";
        String Sentence_2 = "It is wednesday.";
        String Sentence_3 = "This is great!";

        ArrayList<ArrayList<String>> Prediction_1 = sentimentAnalysis.predictSentiment(Sentence_1);
        ArrayList<ArrayList<String>> Prediction_2 = sentimentAnalysis.predictSentiment(Sentence_2);
        ArrayList<ArrayList<String>> Prediction_3 = sentimentAnalysis.predictSentiment(Sentence_3);

        for (ArrayList<String> list : Prediction_1)
            {
            String sentence = list.get(0);
            Assert.assertNotEquals("One two three", sentence);
            }

        for (ArrayList<String> list : Prediction_2)
            {
            String sentence = list.get(0);
            Assert.assertNotEquals("Itiswednesday.", sentence);
            }

        for (ArrayList<String> list : Prediction_3)
            {
            String sentence = list.get(0);
            Assert.assertNotEquals("This is awful!", sentence);
            }
        }

    @Test
    public void OutputOfSentencesShouldSucceedIfItMatchesOriginalInput()
        {
        SentimentAnalysis sentimentAnalysis = new SentimentAnalysis();
        String Sentence_1 = "One, two, three";
        String Sentence_2 = "It is wednesday.";
        String Sentence_3 = "This is great!";

        ArrayList<ArrayList<String>> Prediction_1 = sentimentAnalysis.predictSentiment(Sentence_1);
        ArrayList<ArrayList<String>> Prediction_2 = sentimentAnalysis.predictSentiment(Sentence_2);
        ArrayList<ArrayList<String>> Prediction_3 = sentimentAnalysis.predictSentiment(Sentence_3);

        for (ArrayList<String> list : Prediction_1)
            {
            String sentence = list.get(0);
            Assert.assertEquals("One, two, three", sentence);
            }

        for (ArrayList<String> list : Prediction_2)
            {
            String sentence = list.get(0);
            Assert.assertEquals("It is wednesday.", sentence);
            }

        for (ArrayList<String> list : Prediction_3)
            {
            String sentence = list.get(0);
            Assert.assertEquals("This is great!", sentence);
            }
        }
    }

