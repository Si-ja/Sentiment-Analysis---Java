package com.sentiment.test;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;

/**
 * A class that allows to pass a sentence through the Pipeline, that holds information on what transformations
 * can be applied.
 */
public class Pipeline
{

    // Initialize all of the important components for the Pipeline to function from bare bones.
    private static Properties properties = new Properties();
    private static String propertiesNames = "tokenize, ssplit, pos, parse, sentiment";
    private static StanfordCoreNLP stanfordCoreNLP;

    static
    {
        properties.setProperty("annotators", propertiesNames);
    }

    /**
     * Initiates an instance of the Pipeline into existence, if it is empty in the created object. Otherwise,
     * does nothing. Does not take any parameters.
     * @return an update to the StanfordCoreNLP parameter.
     */
    public static StanfordCoreNLP getPipeline()
    {
        if (stanfordCoreNLP == null)
        {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}