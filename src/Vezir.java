import java.util.ArrayList;

/* vezirin hereketleri

 */
public class Vezir extends AbstractTas {




    Vezir(char team, int[] konum){
        this.konum = konum;
        this.team = team;
    }

    public ArrayList<ArrayList<int[]>> vezirMoves() {
        ArrayList<ArrayList<int[]>> vezirHareketleri = new ArrayList<>() ;

        ArrayList<int[]> yukari = new ArrayList<>();

        yukari.add(new int[]{-1, 0});
        yukari.add(new int[]{-2, 0});
        yukari.add(new int[]{-3, 0});
        yukari.add(new int[]{-4, 0});
        yukari.add(new int[]{-5, 0});
        yukari.add(new int[]{-6, 0});
        yukari.add(new int[]{-7, 0});
        yukari.add(new int[]{-8, 0});

        ArrayList<int[]> asagi = new ArrayList<>();

        asagi.add(new int[]{1, 0});
        asagi.add(new int[]{2, 0});
        asagi.add(new int[]{3, 0});
        asagi.add(new int[]{4, 0});
        asagi.add(new int[]{5, 0});
        asagi.add(new int[]{6, 0});
        asagi.add(new int[]{7, 0});
        asagi.add(new int[]{8, 0});

        ArrayList<int[]> sola = new ArrayList<>();

        sola.add(new int[]{0, -1});
        sola.add(new int[]{0, -2});
        sola.add(new int[]{0, -3});
        sola.add(new int[]{0, -4});
        sola.add(new int[]{0, -5});
        sola.add(new int[]{0, -6});
        sola.add(new int[]{0, -7});
        sola.add(new int[]{0, -8});

        ArrayList<int[]> saga = new ArrayList<>();

        saga.add(new int[]{0, 1});
        saga.add(new int[]{0, 2});
        saga.add(new int[]{0, 3});
        saga.add(new int[]{0, 4});
        saga.add(new int[]{0, 5});
        saga.add(new int[]{0, 6});
        saga.add(new int[]{0, 7});
        saga.add(new int[]{0, 8});

        ArrayList<int[]> solYukari = new ArrayList<>();

        solYukari.add(new int[]{-1, -1});
        solYukari.add(new int[]{-2, -2});
        solYukari.add(new int[]{-3, -3});
        solYukari.add(new int[]{-4, -4});
        solYukari.add(new int[]{-5, -5});
        solYukari.add(new int[]{-6, -6});
        solYukari.add(new int[]{-7, -7});
        solYukari.add(new int[]{-8, -8});

        ArrayList<int[]> sagYukari = new ArrayList<>();

        sagYukari.add(new int[]{-1, 1});
        sagYukari.add(new int[]{-2, 2});
        sagYukari.add(new int[]{-3, 3});
        sagYukari.add(new int[]{-4, 4});
        sagYukari.add(new int[]{-5, 5});
        sagYukari.add(new int[]{-6, 6});
        sagYukari.add(new int[]{-7, 7});
        sagYukari.add(new int[]{-8, 8});

        ArrayList<int[]> solAsagi = new ArrayList<>();

        solAsagi.add(new int[]{1, -1});
        solAsagi.add(new int[]{2, -2});
        solAsagi.add(new int[]{3, -3});
        solAsagi.add(new int[]{4, -4});
        solAsagi.add(new int[]{5, -5});
        solAsagi.add(new int[]{6, -6});
        solAsagi.add(new int[]{7, -7});
        solAsagi.add(new int[]{8, -8});

        ArrayList<int[]> sagAsagi = new ArrayList<>();

        sagAsagi.add(new int[]{1, 1});
        sagAsagi.add(new int[]{2, 2});
        sagAsagi.add(new int[]{3, 3});
        sagAsagi.add(new int[]{4, 4});
        sagAsagi.add(new int[]{5, 5});
        sagAsagi.add(new int[]{6, 6});
        sagAsagi.add(new int[]{7, 7});
        sagAsagi.add(new int[]{8, 8});

        vezirHareketleri.add(sola);
        vezirHareketleri.add(saga);
        vezirHareketleri.add(asagi);
        vezirHareketleri.add(yukari);
        vezirHareketleri.add(sagAsagi);
        vezirHareketleri.add(solYukari);
        vezirHareketleri.add(solAsagi);
        vezirHareketleri.add(sagYukari);

        return vezirHareketleri;
    }


//sevgili olmayacagımız override
    @Override
    public ArrayList<int[]> moves() {
        return null;
    }
}
