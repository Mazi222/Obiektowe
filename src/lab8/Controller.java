package lab8;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {

    private String getAll = "SELECT * FROM books";
    @FXML private TextField textfieldFindByAuthor;
    @FXML private TextField textfieldFindByISBN;
    @FXML private TextField textfieldAddISBN;
    @FXML private TextField textfieldAddTitle;
    @FXML private TextField textfieldAddAuthor;
    @FXML private TextField textfieldAddYear;
    @FXML private ListView<String> lista;
    private DataBase dataBase = new DataBase();

    @FXML
    public void addBookWhenButtonIsClick()
    {
        dataBase.addBook(new Book(textfieldAddISBN.getText(),textfieldAddTitle.getText(),textfieldAddAuthor.getText(),Integer.parseInt(textfieldAddYear.getText())));
    }
    @FXML
    public void bClear(){
        lista.getItems().clear();
    }

    @FXML
    public void getBooks()
    {
        bClear();
        List<Book> list = dataBase.getData(getAll);
        for(Book le : list)
        {
           lista.getItems().add(le.getIsbn()+" "+le.getTitle()+" "+le.getAuthor()+" "+Integer.toString(le.getYear()));
        }
    }

    @FXML
    public void getBooksWithAuthor()
    {
        bClear();
        String author = textfieldFindByAuthor.getText();
        String query = null;
        if(author.contains(" "))
            query = "SELECT * FROM books WHERE author LIKE '"+author+"'";
        else
            query = "SELECT * FROM books WHERE author LIKE '%"+author+"'";
        List<Book> list = dataBase.getData(query);
        for(Book le : list)
        {
            lista.getItems().add(le.getIsbn()+" "+le.getTitle()+" "+le.getAuthor()+" "+Integer.toString(le.getYear()));
        }
    }

    @FXML
    public void getBooksWithISBN()
    {
        bClear();
        textfieldFindByISBN.getText();
        String query = "SELECT * FROM books WHERE isbn LIKE '"+textfieldFindByISBN.getText()+"'";
        List<Book> list = dataBase.getData(query);
        for(Book le : list)
        {
            lista.getItems().add(le.getIsbn()+" "+le.getTitle()+" "+le.getAuthor()+" "+Integer.toString(le.getYear()));
        }
    }
}
