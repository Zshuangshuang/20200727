import java.util.Arrays;

/**
 * Created With IntelliJ IDEA.
 * Description:顺序表练习题
 * User:ZouSS
 * Date:2020-07-27
 * Time:19:28
 **/
public class MyArrayList{

    private int[] elem;
    private int usedSize;
    private final int SIZE = 20;

    public MyArrayList() {
        this.elem = new int[SIZE];
        this.usedSize = usedSize;
    }
    public void add(int pos,int data){
        if (isFull()){
            Arrays.copyOf(this.elem,this.elem.length*2);
            return;
        }
        if (pos < 0 || pos > this.usedSize ){
            return;
        }
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }
    public void remove(int key){
        int ret = search(key);
        if (ret == -1){
            return;
        }
        for (int i = ret; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    public int getPos(int pos){
        if (pos < 0  || pos > this.usedSize){
            System.out.println("当前pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    public int search(int toFind){
        for (int i = 0; i < this.usedSize-1; i++) {
            if (this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public boolean isContains(int toFind){
        for (int i = 0; i < this.usedSize-1; i++) {
            if (this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public boolean isFull(){

        if (this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    public int size(){
        return this.usedSize;
    }
    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
    }
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);

        myArrayList.remove(20);
        myArrayList.display();
    }

}
