public class Playground {
    private Position[] positions;

    private int height_of_playground;

    public Position[] getPositions() {
        return positions;
    }

    public int getHeight_of_playground() {
        return height_of_playground;
    }

    private Creature[] creatures;

    public Playground(Huluwa[] brothers, GrandPa grandPa, Scorpion scorpion,
                      Snake snake, LittleMonster[] littleMonsters,Queue queue) {

        //scorpion.print_position();

        int position_length = brothers.length + littleMonsters.length + 4;
        this.height_of_playground = position_length;
        this.positions = new Position[position_length * position_length];


        for (int i = 0; i < position_length; i++) {
            for (int j = 0; j < position_length; j++) {
                this.positions[i + j * position_length] = new Position(i, j, 0);
            }
        }

        this.creatures = brothers;
        for (int j = 0; j < brothers.length; j++) {
            positions[(position_length / 2) + (position_length - j - 1) * position_length] = queue.getPositions()[brothers.length - j-1];
            positions[(position_length / 2) + (position_length - j - 1) * position_length].setX(position_length / 2);
            //this.creatures[6 - j].setPosition(this.positions[(position_length / 2) + (position_length - j - 1) * position_length]);
            //this.positions[(position_length / 2) + (position_length - j - 1) * position_length].setCheck(1);

        }

        grandPa.setPosition(positions[(position_length - 1) * position_length]);
        positions[(position_length - 1) * position_length].setCheck(1);

        int[] Monster_Ponistion = scorpion.getPositions();
        int k = 0;
        this.creatures = littleMonsters;
        for (int i = 0; i < scorpion.getLittlemonster_num() + 1; i++) {
            for (int j = 0; j < scorpion.getLittlemonster_num() + 1; j++) {
                if (Monster_Ponistion[j + i * (scorpion.getLittlemonster_num() + 1)] == 3) {
                    this.creatures[k].setPosition(this.positions[(position_length - littleMonsters.length - 1) / 2 + j + i * position_length]);
                    this.positions[(position_length - littleMonsters.length - 1) / 2 + j + i * position_length].setCheck(1);
                    k++;
                } else if (Monster_Ponistion[j + i * (scorpion.getLittlemonster_num() + 1)] == 1) {
                    scorpion.setPosition(this.positions[(position_length - littleMonsters.length - 1) / 2 + j + i * position_length]);
                    this.positions[(position_length - littleMonsters.length - 1) / 2 + j + i * position_length].setCheck(1);
                }
            }
        }
        snake.setPosition(this.positions[0]);
        this.positions[0].setCheck(1);
    }

    public void PrintPlayground(Huluwa[] brothers, GrandPa grandPa, Scorpion scorpion,
                                Snake snake) {
        for (int i = 0; i < height_of_playground; i++) {
            for (int j = 0; j < height_of_playground; j++) {
                if (positions[j + i * height_of_playground].getCheck() == 1) {
                    if (positions[j + i * height_of_playground].getHolder() == brothers[0]) {
                        System.out.printf("1");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[1]) {
                        System.out.printf("2");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[2]) {
                        System.out.printf("3");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[3]) {
                        System.out.printf("4");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[4]) {
                        System.out.printf("5");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[5]) {
                        System.out.printf("6");
                    } else if (positions[j + i * height_of_playground].getHolder() == brothers[6]) {
                        System.out.printf("7");
                    } else if (positions[j + i * height_of_playground].getHolder() == grandPa) {
                        System.out.printf("G");
                    } else if (positions[j + i * height_of_playground].getHolder() == scorpion) {
                        System.out.printf("#");
                    } else if (positions[j + i * height_of_playground].getHolder() == snake) {
                        System.out.printf("s");
                    } else {
                        System.out.printf("*");
                    }
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
    }
}
