import java.util.*;

public class App{
      

    static Board solve (Board b, int i, int k){
        //00, 01, 02...., 08, 10, ..... 18, 20
        if(k == b.getW()){
            k = 0;
            i += 1;
        }
        if(i == b.getH()){
            return b;
        }

        for(int num = 1; num < 10; num++){
            if(b.fits(num, i, k)){
                b.setNum(num, i, k);
                b.print();
                System.out.println("i= " + i + ", k= " + k);
                System.out.println("num = " + num);
                Board bf = solve(b, i, k + 1);
                if(bf != null){
                    return bf;
                }
            }                    
        }   
        return null;             
    }
        
    


    public static void main (String args[]){
        int HEIGHT, WIDTH;
        HEIGHT = 9;
        WIDTH = 9;

        Board board = new Board(HEIGHT, WIDTH);

        board = solve(board, 0, 0);
        if(board != null){
            board.print();
        }else{
            System.out.println("End of the program");
        }




    }
}