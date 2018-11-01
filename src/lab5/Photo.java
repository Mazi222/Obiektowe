package lab5;


import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;


public class Photo {

    private String apiKey;
    FileSupport fileSupport;

    Photo(String apiKey, String pathToPhotos)
    {
        this.apiKey=apiKey;
        fileSupport=new FileSupport(pathToPhotos);
    }

    public void photoSortInCatalogs() throws IndicoException {
        //TODO
        Indico indico = new Indico(apiKey);
        IndicoResult result = indico.imageRecognition.predict();
    }


}
