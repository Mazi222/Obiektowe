package lab5.Image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSupport {

    private String pathToPhotos=null;

    private File[] photos=null;

    public FileSupport(String pathToPhotos)
    {
        this.pathToPhotos = pathToPhotos;
    }

    private File[] readCatalog()
    {
        File catalogWithPhotos = new File(pathToPhotos);        //TODO
        photos = catalogWithPhotos.listFiles();
        return photos;
    }

    private void buildNewCatalogFromGivenName(String catalogNewName, int numberOfPhoto) throws IOException {
        Files.createFile(Paths.get(pathToPhotos + "/" + catalogNewName));
        copyToCatalog(catalogNewName,numberOfPhoto);
    }

    private void copyToCatalog(String catalogNewName, int numberOfPhoto) throws IOException {
        Files.copy(Paths.get(pathToPhotos+"/"),Paths.get(pathToPhotos+"/"+catalogNewName));
    }

    private File loadPhotoFromPath(int i)
    {
        if(photos.length>i)
            return new photos[i];
        //TODO rzucanie i obsługa wyjątku
    }

    public File[] getPhotos() {
        return photos;
    }
}
