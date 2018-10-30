package lab4.zad3;

public class Polibiusz implements Algorithm{

    private char [][] polybiusBoard = new char[5][5];

    Polibiusz()
    {
        char letterToTable = 'a';
        for(int i=0;i<25;++i)
        {
            polybiusBoard[i/5][i%5]=letterToTable++;
            if(letterToTable == 'j') {
                ++letterToTable;
            }
        }
    }

    @Override
    public String crypt(String singleWordToCrypt)
    {
        StringBuilder cryptedWordBuilder = new StringBuilder();
        char letterFromWordToCrypt;
        byte flag;

        for(int i=0;i<singleWordToCrypt.length();++i)
        {
            flag=0;
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
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    break;
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
            decryptedWordBuilder.append(polybiusBoard[singleWordToDecrypt.charAt(i)-49][singleWordToDecrypt.charAt(i+1)-49]);       // -49 bo uzyskiwana jest wartość chara dla cyfry równej conajmniej 1 a jej wartość wynosi ona 49
        }

        return decryptedWordBuilder.toString();
    }
}
