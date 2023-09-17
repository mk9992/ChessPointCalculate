import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ToplamPuan {

    public static double[] toplam(char[][][] konum) {
        double[] puanlar = new double[2];
        for (char[][] satir : konum) {
            for (char[] sutun : satir) {
                char renk = sutun[1];
                char cins = sutun[0];


                int puan = 0;

                //bulunan taşların cinsine göre ne kadar puan ekleneceği
                switch (cins) {
                    case 's':
                        puan = 100;
                        break;
                    case 'a':
                        puan = 3;
                        break;
                    case 'f':
                        puan = 3;
                        break;
                    case 'v':
                        puan = 9;
                        break;
                    case 'k':
                        puan = 5;
                        break;
                    case 'p':
                        puan = 1;
                        break;
                }
                //bulunan taşların cinsine göre hangi takıma ekleneceği
                switch (renk) {
                    case 's':
                        puanlar[0] += puan;
                        break;
                    case 'b':
                        puanlar[1] += puan;
                        break;

                }

            }


        }


        return puanlar;
    }

    public static double[] sonuc(double[] puanlar) {
        HashSet<TehditAltindaOlanlar> tehditler = new HashSet<>();


        char[][][] konum = MatrisOlusturma.doldur();
        // System.out.println(konum[5][2]);
        List<AbstractTas> taslar = TasBulma.tasBul(konum);
        for (AbstractTas tas : taslar) {
            int dikeyKonum = tas.konum[0];
            int yatayKonum = tas.konum[1];
            ArrayList<int[]> hareketler = tas.moves();
            ArrayList<int[]> hamleler = new ArrayList<>();
            if (tas instanceof Vezir) {
                ArrayList<ArrayList<int[]>> vezirHareket = ((Vezir) tas).vezirMoves();

                for (ArrayList<int[]> vezirYon : vezirHareket) {
                    for (int[] vezirHamle : vezirYon) {
                        int dikey = vezirHamle[0];
                        int yatay = vezirHamle[1];
                        int dikeyHamle = dikey + dikeyKonum;
                        int yatayHamle = yatay + yatayKonum;

                        try {
                            char[] hedef = konum[dikeyHamle][yatayHamle];
                            char cins = hedef[0];
                            char renk = hedef[1];


                            if (renk != '-') {
                                if (tas.team == renk) {
                                    break;
                                } else {

                                    //  System.out.println(tas.team);
                                    //System.out.println("hedefin konumu: " + dikeyHamle + ", " + yatayHamle + " cins: " + cins );
                                    tehditler.add(new TehditAltindaOlanlar(dikeyHamle, yatayHamle, renk, cins));
                                    break;
                                }

                            }
                        } catch (Exception e) {

                        }
                    }
                }
            } else {
                for (int[] hareket : hareketler) {
                    int dikeyHareket = hareket[0];
                    int yatayHareket = hareket[1];
                    int dikeyHamle = dikeyHareket + dikeyKonum;
                    int yatayHamle = yatayHareket + yatayKonum;

                    try {
                        char[] hedef = konum[dikeyHamle][yatayHamle];
                        char cins = hedef[0];
                        char renk = hedef[1];
                        if (tas instanceof Vezir) {
                            //System.out.println("vezir bulundu");

                            continue;

                        }
                        if (renk != '-' && renk != tas.team) {
                            // System.out.println(tas.team);
                            // System.out.println("hedefin konumu: " + dikeyHamle + ", " + yatayHamle + " cins: " + cins + " renk: " + renk);
                            tehditler.add(new TehditAltindaOlanlar(dikeyHamle, yatayHamle, renk, cins));

                        }
                    } catch (Exception e) {
                    }

                }
            }
        }
        //System.out.println(tehditler.size());
        for (TehditAltindaOlanlar tehdit : tehditler) {
            int dikeyKonum = tehdit.dikeyKonum;
            int yatayKonum = tehdit.yatayKonum;
            char cins = tehdit.cins;
            char takim = tehdit.takim;

            double ceza = 0;
            switch (cins) {
                case 's':
                    ceza = 50;
                    break;
                case 'a':
                    ceza = 1.5;
                    break;
                case 'f':
                    ceza = 1.5;
                    break;
                case 'v':
                    ceza = 4.5;
                    break;
                case 'k':
                    ceza = 2.5;
                    break;
                case 'p':
                    ceza = 0.5;
                    break;
            }

            switch (takim) {
                case 's':
                    puanlar[0] -= ceza;
                    break;
                case 'b':
                    puanlar[1] -= ceza;
                    break;

            }
        }
        return puanlar;
    }
}


