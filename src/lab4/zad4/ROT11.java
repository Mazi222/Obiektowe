package lab4.zad4;

public class ROT11 implements Algorithm {

    //private static String alfabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKMNIPQRSTUVWXYZ";

    private static byte charactershift = 11;
    @Override
    public String crypt(String singleWordToCrypt) {

        StringBuilder cryptedWordBuilder = new StringBuilder();
        int asciiLetterFromWordToCrypt;

        for(int i=0;i<singleWordToCrypt.length();++i)
        {
            asciiLetterFromWordToCrypt=singleWordToCrypt.charAt(i);
            asciiLetterFromWordToCrypt+=charactershift;

            if (asciiLetterFromWordToCrypt > 122) {                                                 //mała litera zakres przekroczony od góry (zakres 97-122)
                asciiLetterFromWordToCrypt=asciiLetterFromWordToCrypt-26;
            }
            else if(asciiLetterFromWordToCrypt > 90 && asciiLetterFromWordToCrypt < 91+charactershift)      //duża litera zakres przekroczony od góry (zakres (65-90)
            {
                asciiLetterFromWordToCrypt=asciiLetterFromWordToCrypt-26;
            }
            cryptedWordBuilder.append((char)asciiLetterFromWordToCrypt);
        }

        return cryptedWordBuilder.toString();
    }

    @Override
    public String decrypt(String singleWordToDecrypt) {

        StringBuilder decryptedWordBuilder = new StringBuilder();
        int asciiCharFromWordToDecrypt;

        for(int i=0;i<singleWordToDecrypt.length();++i)
        {
            asciiCharFromWordToDecrypt=singleWordToDecrypt.charAt(i);
            asciiCharFromWordToDecrypt-=charactershift;
            if (asciiCharFromWordToDecrypt < 97 && asciiCharFromWordToDecrypt > 96-charactershift) {
                asciiCharFromWordToDecrypt=asciiCharFromWordToDecrypt+26;
            }
            else if(asciiCharFromWordToDecrypt < 65)
            {
                asciiCharFromWordToDecrypt=asciiCharFromWordToDecrypt+26;
            }
            decryptedWordBuilder.append((char)asciiCharFromWordToDecrypt);
        }

        return decryptedWordBuilder.toString();
    }
}
