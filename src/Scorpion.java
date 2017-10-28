//蝎子精
public class Scorpion extends Monster {
    private int littlemonster_num;
    private KIND_OF_FORMATION formation;
    private int[] positions;

    public Scorpion(NAME name, int half_num_of_littlemonster) {
        super();
        this.name = name;
        this.littlemonster_num = half_num_of_littlemonster * 2;
    }

    public void Set_Formation(KIND_OF_FORMATION kind_of_formation){
        this.formation = kind_of_formation;
        this.Chang_Formation();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
        position.setHolder(this);
    }

    @Override
    public void report() {
        super.report();
        System.out.printf("我们用的是" + formation + "阵\n");
    }

    private void Chang_Formation() {
        int positions_length = littlemonster_num + 1;
        this.positions = new int[positions_length * positions_length];
        switch (formation) {
            case 鹤翼:
                Heyi();
                break;
            case 雁行:
                Yanxing();
                break;
            case 冲轭:
                break;
            case 长蛇:
                break;
            case 鱼鳞:
                break;
            case 方圆:
                break;
            case 偃月:
                break;
            case 锋失:
                break;
            default:
                System.out.printf("错误，没有此类阵型!");
        }
    }

    private void Heyi() {
        int before = 0, last = littlemonster_num,j;
        for (j = 0; j < littlemonster_num; j++) {
            positions[before + j * (littlemonster_num + 1)] = 3;//3表示小喽啰
            positions[last + j * (littlemonster_num + 1)] = 3;
            before++;
            last--;
            if(before==last)
                break;
        }
        positions[before +(j+1)* (littlemonster_num + 1)] = 1;//1表示蝎子精
    }

    private void Yanxing() {
        int last = littlemonster_num;
        for (int j = 0; j < littlemonster_num; j++) {
            positions[last + j * (littlemonster_num + 1)] = 3;
            last--;
        }
        positions[last + littlemonster_num * (littlemonster_num + 1)] = 1;
    }

    public int[] getPositions(){
        return positions;
    }
    public int getLittlemonster_num(){
        return littlemonster_num;
    }

    /*public void print_position(){
        for(int i=0;i<littlemonster_num+1;i++){
            for(int j=0;j<littlemonster_num+1;j++){
                if(positions[j+i*(littlemonster_num+1)]==1)
                    System.out.printf("#");
                else if(positions[j+i*(littlemonster_num+1)]==3)
                    System.out.printf("*");
                else
                    System.out.printf(" ");
            }
            System.out.printf("\n");
        }
    }*/
}
