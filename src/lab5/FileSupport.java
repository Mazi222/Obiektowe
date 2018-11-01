package lab5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSupport {

    private String pathToPhotos;

    public FileSupport(String pathToPhotos)
    {
        this.pathToPhotos = pathToPhotos;
    }

    private File[] readCatalog()
    {
        File catalogWithPhotos = new File();        //TODO
        File [] photos = catalogWithPhotos.listFiles();
        return photos;
    }

    private void buildNewCatalogFromGivenName(String catalogNewName) throws IOException {
        Files.createFile(Paths.get(pathToPhotos + "/" + catalogNewName));
    }

    private void saveToCatalog(String catalogNewName)
    {

    }

    private void loadPhotoFromPath()
    {
        //TODO
    }
}
