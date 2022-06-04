import java.io.PipedOutputStream;
import java.util.*;

public class App{
      

    static Board solve (Board b, int i, int k){
        //00, 01, 02...., 08, 10, ..... 18, 20
        if(k == b.getW()){
            k = 0;
            i += 1;
        }
        if(i == b.getH()){
            System.out.println("return b");
            return b;
        }
        if(b.getBlock(i, k)){
            Board bf = solve(b, i, k + 1);
            if(bf != null){
                return bf;
            }
            return null;
        }

        for(int num = 1; num < 10; num++){
            System.out.println(num + "=  " + b.fits(num, i, k));
            if(b.fits(num, i, k)){
                System.out.println(num + "=  " + b.fits(num, i, k));
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

        Piece[] sudokuScheme = {new Piece(0, 1, 7), new Piece(0, 5, 1), new Piece(1, 1, 6),
                                new Piece(1, 7, 2), new Piece(2, 0, 2), new Piece(2, 2, 1),
                                new Piece(2, 4, 5), new Piece(2, 8, 3), new Piece(3, 1, 2),
                                new Piece(4, 0, 8), new Piece(4, 2, 4), new Piece(4, 5, 6),
                                new Piece(4, 7, 3), new Piece(5, 3, 9), new Piece(5, 8, 5),
                                new Piece(6, 4, 6), new Piece(6, 6, 4), new Piece(7, 0, 1),
                                new Piece(7, 2, 3), new Piece(7, 5, 4), new Piece(7, 7, 8),
                                new Piece(8, 2, 7), new Piece(5, 4, 8)};


        Board board = new Board(HEIGHT, WIDTH);

        board.piecesToBoard(sudokuScheme);
        board.print();
        
        board = solve(board, 0, 0);
        if(board != null){
            board.print();
        }else{
            System.out.println("End of the program");
        }




    }
}