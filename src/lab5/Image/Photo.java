package lab5.Image;


import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;


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
