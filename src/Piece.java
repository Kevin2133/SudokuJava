public class Piece {

    private int i, k, num;
    private boolean blocked;

    public Piece(int i, int k, int num){
        this.i = i;
        this.k = k;
        this.num = num;
        this.blocked = false;
    }

    public int getRow(){
        return this.i;
    }

    public int getCol(){
        return this.k;
    }

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setBlock(boolean b){
        this.blocked = b;
    }

    public boolean getBlock(){
        return this.blocked;
    }

    
}
