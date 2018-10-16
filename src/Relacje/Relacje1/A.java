package Relacje.Relacje1;

public class A {
    protected int number;
    String name;
    public A(int _number, String _name){
        number=_number;
        name=_name;
    }
    public void callDecrement(){
        decrement();
    }
    public void callchangeName(String _name){
        changeName(_name);
    }
    public void callIncremental(){
        increment();
    }
    private void increment(){
        number+=1;
    }
    protected void decrement(){
        number-=1;
    }
    void changeName(String _name){
        name=_name;
    }

}
