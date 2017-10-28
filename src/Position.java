public class Position {

    private int x;

    private int y;

    private int check;

    private Creature holder;

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y, int check) {
        super();
        this.x = x;
        this.y = y;
        this.check=check;
    }

    public void setCheck(int check){
        this.check=check;
    }
    public int getCheck(){
        return check;
    }
}
