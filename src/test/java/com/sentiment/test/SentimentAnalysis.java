package com.sentiment.test;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows for performance of a sentiment analysis on an inputted text.
 * Allows for passing of more than one sentence instance, but it will be split into parts and everything
 * will be evaluated seperately.
 */
public class SentimentAnalysis
{
    // Initiate the state of the class to allow for text processing
    private StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

    /**
     * Predict the sentiment of the input text.
     * @param text - any user defined text.
     * @return ArrayList of ArrayLists {String} - list of strings - sentence passed and the sentiment of it.
     */
    public ArrayList<ArrayList<String>> predictSentiment(String text)
    {
        ArrayList<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
        // Call a method initially that first seperates the whole text into sentences for processing
        List<CoreSentence> sentences = this.splitSentences(text);

        // Now itterate through each sentence and make sentiment-base predictions about them
        int i = 0;
        for (CoreSentence sentence : sentences)
        {
            String sentiment = sentence.sentiment();
            ArrayList<String> pair = new ArrayList<String>();
            pair.add(sentence.text());
            pair.add(sentiment.toString());
            answers.add(pair);
            i++;
        }
        return answers;
    }

    /**
     * Methods that allows for text splitting in parts, returning a list of sentence that needs to be
     * processed.
     * @param text Main text that is inputed and attempted to be evaluated for the sentiment value.
     * @return List {CoreSentence} - a list of individual sentences is returned for processing.
     */
    private List<CoreSentence> splitSentences(String text)
    {
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences = coreDocument.sentences();
        return sentences;
    }
}