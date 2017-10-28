import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {


    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }


    public Creature[] getCreatures() {
        return creatures;
    }


    private Creature[] creatures;

    public Queue(Huluwa[] brothers) {


        this.positions = new Position[brothers.length];

        this.creatures = brothers;


        for (int j = 0; j < brothers.length; j++) {

            this.positions[j] = new Position(0, j, 1);
            this.creatures[j].setPosition(this.positions[j]);
        }
    }


    public void rollCall() {
        for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
        System.out.flush();

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    private void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }

    public static void main(String[] args) {

        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        GrandPa grandPa = new GrandPa(GrandPa.NAME.valueOf("爷爷"));

        Scorpion scorpion = new Scorpion(Monster.NAME.valueOf("蝎子精"), 4);

        LittleMonster[] littleMonsters = new LittleMonster[scorpion.getLittlemonster_num()];
        for (int i = 0; i < littleMonsters.length; i++) {
            littleMonsters[i] = new LittleMonster(Monster.NAME.valueOf("小喽啰"));
        }

        Snake snake = new Snake(Monster.NAME.valueOf("蛇精"));

        Queue queue = new Queue(brothers);

        //queue.rollCall();

        queue.shuffle();


        //queue.rollCall();

        new InsertionSorter().sort(queue);

        //queue.rollCall();

        queue.shuffle();


        //queue.rollCall();

        new BubbleSorter().sort(queue);
        //queue.rollCall();

        scorpion.Set_Formation(Formation.KIND_OF_FORMATION.valueOf("鹤翼"));

        Playground playground1 = new Playground(brothers, grandPa, scorpion, snake, littleMonsters,queue);
        scorpion.report();
        snake.report();
        grandPa.report();

        playground1.PrintPlayground(brothers, grandPa, scorpion, snake);

        scorpion.Set_Formation(Formation.KIND_OF_FORMATION.valueOf("雁行"));

        Playground playground2 = new Playground(brothers, grandPa, scorpion, snake, littleMonsters,queue);
        scorpion.report();
        snake.report();
        grandPa.report();

        playground2.PrintPlayground(brothers, grandPa, scorpion, snake);
    }
}

