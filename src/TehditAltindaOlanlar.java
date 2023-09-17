import java.util.Objects;

public class TehditAltindaOlanlar {
    public int dikeyKonum;
    public int yatayKonum;
    public char takim;
    public char cins;

    public TehditAltindaOlanlar(int dikey, int yatay, char takim, char cins) {
        this.dikeyKonum = dikey;
        this.yatayKonum = yatay;
        this.takim = takim;
        this.cins = cins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TehditAltindaOlanlar that = (TehditAltindaOlanlar) o;
        return dikeyKonum == that.dikeyKonum &&
                yatayKonum == that.yatayKonum &&
                takim == that.takim &&
                cins == that.cins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dikeyKonum, yatayKonum, takim, cins);
    }
}
