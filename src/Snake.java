//蛇精
public class Snake extends Monster {
    public Snake(NAME name) {
        this.name = name;
    }

    @Override
    public void report() {
        super.report();
        System.out.printf("夫君加油，999！\n");
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
        position.setHolder(this);
    }
}
