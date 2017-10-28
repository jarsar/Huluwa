//爷爷
public class GrandPa implements Creature {
    private NAME name;
    private Position position;

    public GrandPa(NAME name){
        this.name=name;
    }

    @Override
    public void report() {
        System.out.printf("葫芦娃加油，666！\n");
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    enum NAME {
        爷爷
    }
}
