package com.springernature.etl;

import com.springernature.etl.extractors.Extractor;
import com.springernature.etl.extractors.FileExtractor;
import com.springernature.etl.loaders.FileLoader;
import com.springernature.etl.loaders.Loader;
import com.springernature.etl.transformers.CapitalizeTransformer;
import com.springernature.etl.transformers.Transformer;
import com.springernature.etl.transformers.WordCountTransformer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hrishikeshshinde on 03/12/16.
 */
public class Application {
    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    public static final String INVALID_TRANSFORMER_OPTION = "Invalid transformer option, " +
                                                            "valid options are 'capitalize' or 'wordcount'";
    public static final String INVALID_CLI_ARGUMENTS = "Invalid CLI arguments, expecting exactly 3 arguments ";
    public static final String ETL_EXECUTED_SUCCESSFULLY = "ETL executed successfully";

    private String sourceLocation;
    private String destinationLocation;
    private String transformer;

    public String getSourceLocation() {
        return sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getTransformer() {
        return transformer;
    }

    public void extractCLIArguments(String[] arguments) {
        if(arguments.length != 3) {
            throw new RuntimeException(INVALID_CLI_ARGUMENTS);
        }

        sourceLocation = arguments[0];
        destinationLocation = arguments[1];
        transformer = arguments[2];
    }

    public static void main(String args[]) {
        try {
            Application etlApp = new Application();
            etlApp.extractCLIArguments(args);

            Extractor extractor = new FileExtractor(etlApp.getSourceLocation());
            Transformer transformer = selectTransformer(etlApp.getTransformer());
            Loader loader = new FileLoader(etlApp.getDestinationLocation());

            ETLExecutor etlExecutor = new ETLExecutor(extractor, transformer, loader);
            etlExecutor.executeParallely();

            LOGGER.log(Level.INFO, ETL_EXECUTED_SUCCESSFULLY);

        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } catch (RuntimeException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    private static Transformer selectTransformer(String transformer) throws ClassNotFoundException {
        switch(transformer) {
            case "capitalize":
                return new CapitalizeTransformer();
            case "wordcount":
                return new WordCountTransformer();
            default:
                throw new ClassNotFoundException(INVALID_TRANSFORMER_OPTION);
        }
    }
}
