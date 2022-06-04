public class Board {
    

    private Piece[][] board;
    private int h, w, nh, nw;

    public Board(int height, int width){
        this.h = height;
        this.w = width;
        this.nh = this.h / 3;
        this.nw = this.w / 3;
        this.board = new Piece[this.h][this.w];
        for(int i = 0; i < height; i++){
            for(int k = 0; k < width; k++){
                this.board[i][k] = new Piece(i, k, 0);
            }
        }
    }

    public int getH(){
        return this.h;
    }
    
    public int getW(){
        return this.w;
    }


    public void print(){
        for(int i = 0; i < this.h; i++){
            System.out.println(".----".repeat(9) + ".");
            for(int k = 0; k < this.w; k++){
                System.out.print("|" + this.board[i][k].getNum() + "   ");
            }
            System.out.println("|");
        }
        System.out.println(".----".repeat(9) + ".");
    }

    public void setNum (int num, int i, int k){
        this.board[i][k].setNum(num);
    }

    public void setBlock(int i, int k, boolean b){
         this.board[i][k].setBlock(b);
    }

    public boolean getBlock(int i, int k){
        return this.board[i][k].getBlock();
    }

    public boolean fits (int num, int i, int k){
        boolean rows = true, columns = true, nonets = true;
        int nr, nc;

        nr = i / this.nh;
        nc = k / this.nh;

        for(int r = 0; r < this.h; r++){
            if(this.board[r][k].getNum() == num){
                columns = false;
            }            
        }

        for(int c = 0; c < this.w; c++){
            if(this.board[i][c].getNum() == num){
                rows = false;
            }
        }

        for(int r = nr*this.nh; r < (nr + 1)*this.nh; r++){
            for(int c = nc*this.nw; c < (nc + 1)*this.nw; c++){
                if(board[r][c].getNum() == num){
                    nonets = false;
                }
            }
        }

        return rows && columns && nonets;
    }

    public void piecesToBoard (Piece[] p){
        for(Piece pi : p){
            this.board[pi.getRow()][pi.getCol()] = pi;
            this.board[pi.getRow()][pi.getCol()].setBlock(true);
        }
    }

}
