/**
 * Created by jar on 2017/10/24.
 */
public class Monster implements Creature, Formation {
    protected NAME name;
    protected Position position;
    @Override
    public void report() {

    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public NAME getName() {
        return name;
    }

    enum NAME {
        蝎子精, 蛇精, 小喽啰
    }
}
