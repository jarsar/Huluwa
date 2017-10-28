//小喽啰
public class LittleMonster extends Monster {
    public LittleMonster(NAME name) {
        this.name = name;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
        position.setHolder(this);
    }
}
