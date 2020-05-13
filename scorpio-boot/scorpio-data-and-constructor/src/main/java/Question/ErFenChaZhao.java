package Question;

public class ErFenChaZhao {
    public  static  int key =10;
    private int[] data = new int[key];
    private int min;
    private int max;
    private int mid;

    public ErFenChaZhao() {
        for (int i = 0; i < key; i++) {
            data[i] = i+1;
        }
        this.min = 0;
        this.max = data.length - 1;
    }

    public int get(int target){
        return getIndex(min,  max, target);
    }

    public int getIndex(int min, int max, int target){

        if(min >= max){
            if(data[max]  == target){
                return max;
            }
            return -1;
        }

        mid = (min + max)/2;

        if(data[mid] == target){
            return mid;
        }

        if(data[mid] > target){
            max = mid;
        }else {
            min = mid+1;
        }



        return getIndex(min, max, target);
    }
}

class ErFenMain{
    public static void main(String[] args) {
        ErFenChaZhao erFenChaZhao = new ErFenChaZhao();
        System.out.println(erFenChaZhao.get(9));
    }
}
