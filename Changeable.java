package snippet;

public class Changeable {

    public int value;
    public boolean y;

    public Changeable(int x , boolean y){
        this.value = x;
        this.y=y;
    }

    public void SetValue(int x) {

        this.value = x;
    }

    public void Sety(boolean y) {

        this.y = y;
    }

    public int getvalue() {
        return value;
    }

    public boolean gety() {
        return y;
    }
}

