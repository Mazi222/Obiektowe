package lab2.Relacje.Relacje2;

import lab2.Relacje.Relacje1.B;

public class C extends B {
    void changeName(String _name){
        super.callchangeName(_name+"CCC");
    }
    public C(int _number,String _name)
    {
        super(_number,_name);
    }
}
