package lab1.Pesel;

public class PESELTest {
    public static void main(String [] argv){
        String [] ToTest = {"90090515836","23232323232","09012304568","98120103750"};   //przykładowe numery pesel
        for(int i=0;i<4;++i) {              //test dla przykładowych wartości
            if (PESEL.check(ToTest[i])) System.out.println("Poprawne");
            else System.out.println("Niepoprawne");
        }

        PESEL ps = new PESEL("98120103750");        //sprawdzenie działania
        System.out.println(ps.getPESEL());
    }
}
