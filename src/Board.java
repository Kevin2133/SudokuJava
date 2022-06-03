public class Board {
    

    private int[][] board;
    private int h, w, nh, nw;

    public Board(int height, int width){
        this.h = height;
        this.w = width;
        this.nh = this.h / 3;
        this.nw = this.w / 3;
        this.board = new int[this.h][this.w];
        for(int i = 0; i < height; i++){
            for(int k = 0; k < width; k++){
                this.board[i][k] = 0;
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
                System.out.print("|" + this.board[i][k] + "   ");
            }
            System.out.println("|");
        }
        System.out.println(".----".repeat(9) + ".");
    }

    public void setNum (int num, int i, int k){
        this.board[i][k] = num;
    }

    public boolean fits (int num, int i, int k){
        boolean rows = true, columns = true, nonets = true;
        int nr, nc;

        nr = i / this.nh;
        nc = k / this.nh;

        for(int r = 0; r < this.h; r++){
            if(this.board[r][k] == num){
                columns = false;
            }            
        }

        for(int c = 0; c < this.w; c++){
            if(this.board[i][c] == num){
                rows = false;
            }
        }

        for(int r = nr*this.nh; r < (nr + 1)*this.nh; r++){
            for(int c = nc*this.nw; c < (nc + 1)*this.nw; c++){
                if(board[r][c] == num){
                    nonets = false;
                }
            }
        }

        return rows && columns && nonets;
    }

}
