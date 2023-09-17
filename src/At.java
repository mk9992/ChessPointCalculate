import java.util.ArrayList;

public class At extends AbstractTas {



//abstract classa atı ekleme
    At(char team, int[] konum){
        this.konum = konum;
        this.team = team;
    }
//Atın hareketleri
    @Override
    public ArrayList<int[]> moves() {
        ArrayList<int[]> moves = new ArrayList<>() ;
        moves.add(new int[]{-2, 1});
        moves.add(new int[]{-2, -1});
        moves.add(new int[]{2, -1});
        moves.add(new int[]{2, 1});
        moves.add(new int[]{-1, 2});
        moves.add(new int[]{-1, -2});
        moves.add(new int[]{1, 2});
        moves.add(new int[]{1, -2});


        return moves;
    }

}
