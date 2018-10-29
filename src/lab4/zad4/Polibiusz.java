package lab4.zad4;

public class Polibiusz implements Algorithm{

    private char [][] polybiusBoard = new char[5][5];

    Polibiusz()
    {
        char letterToTable = 'a';
        for(int i=0;i<25;++i)
        {
            polybiusBoard[i/5][i%5]=letterToTable++;
            if(letterToTable != 'j') {
                ++letterToTable;
            }
        }
    }

    @Override
    public String crypt(String singleWordToCrypt)
    {
        StringBuilder cryptedWordBuilder = new StringBuilder();
        char letterFromWordToCrypt;

        for(int i=0;i<singleWordToCrypt.length();++i)
        {
            letterFromWordToCrypt=singleWordToCrypt.charAt(i);
            letterFromWordToCrypt=Character.toLowerCase(letterFromWordToCrypt);     //zamiana na małą literę

            if(letterFromWordToCrypt == 'j')
                letterFromWordToCrypt='i';

            for(int row=0;row<5;++row)
            {
                for(int col=0;col<5;++col)
                {
                    if(polybiusBoard[row][col]==letterFromWordToCrypt)
                    {
                        cryptedWordBuilder.append(row+1);
                        cryptedWordBuilder.append(col+1);
                    }
                }
            }
        }

        return cryptedWordBuilder.toString();
    }
    @Override
    public String decrypt(String singleWordToDecrypt)
    {
        StringBuilder decryptedWordBuilder = new StringBuilder();

        for(int i=0;i<singleWordToDecrypt.length();i+=2)
        {
            decryptedWordBuilder.append(polybiusBoard[singleWordToDecrypt.charAt(i)-48][singleWordToDecrypt.charAt(i+1)-48]);       // -48 bo uzyskiwana jest wartość chara dla cyfry a dla 0 wynosi ona 48
        }

        return decryptedWordBuilder.toString();
    }
}
