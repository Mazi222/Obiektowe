package Relacje.Relacje1;

public class B extends A {
    protected void decrement(){
        number-=2;
    }
    void changeName(String _name){
        name=_name+"BBB";
    }
    private void increment(){
        number+=2;
    }
    public B(int _number, String _name){
        super(_number,_name);
    }
}
