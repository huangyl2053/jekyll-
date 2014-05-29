package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 29 19:45:02 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsainKoseiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsainKoseiIchiran_Row extends DataRow {

    private RString shinsainNo;
    private RString shinsainShimei;
    private RString shozokukikan;
    private RString seibetsu;
    private RString shinsainShikaku;
    private RString shinsainKbn;
    private RString gogitaiKbn;
    private RString shukketsuKbn;

    public dgShinsainKoseiIchiran_Row() {
        super();
    }

    public dgShinsainKoseiIchiran_Row(RString shinsainNo, RString shinsainShimei, RString shozokukikan, RString seibetsu, RString shinsainShikaku, RString shinsainKbn, RString gogitaiKbn, RString shukketsuKbn) {
        super();
        this.setOriginalData("shinsainNo", shinsainNo);
        this.setOriginalData("shinsainShimei", shinsainShimei);
        this.setOriginalData("shozokukikan", shozokukikan);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shinsainShikaku", shinsainShikaku);
        this.setOriginalData("shinsainKbn", shinsainKbn);
        this.setOriginalData("gogitaiKbn", gogitaiKbn);
        this.setOriginalData("shukketsuKbn", shukketsuKbn);
        this.shinsainNo = shinsainNo;
        this.shinsainShimei = shinsainShimei;
        this.shozokukikan = shozokukikan;
        this.seibetsu = seibetsu;
        this.shinsainShikaku = shinsainShikaku;
        this.shinsainKbn = shinsainKbn;
        this.gogitaiKbn = gogitaiKbn;
        this.shukketsuKbn = shukketsuKbn;
    }

    public RString getShinsainNo() {
        return shinsainNo;
    }

    public RString getShinsainShimei() {
        return shinsainShimei;
    }

    public RString getShozokukikan() {
        return shozokukikan;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getShinsainShikaku() {
        return shinsainShikaku;
    }

    public RString getShinsainKbn() {
        return shinsainKbn;
    }

    public RString getGogitaiKbn() {
        return gogitaiKbn;
    }

    public RString getShukketsuKbn() {
        return shukketsuKbn;
    }

    public void setShinsainNo(RString shinsainNo) {
        this.setOriginalData("shinsainNo", shinsainNo);
        this.shinsainNo = shinsainNo;
    }

    public void setShinsainShimei(RString shinsainShimei) {
        this.setOriginalData("shinsainShimei", shinsainShimei);
        this.shinsainShimei = shinsainShimei;
    }

    public void setShozokukikan(RString shozokukikan) {
        this.setOriginalData("shozokukikan", shozokukikan);
        this.shozokukikan = shozokukikan;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setShinsainShikaku(RString shinsainShikaku) {
        this.setOriginalData("shinsainShikaku", shinsainShikaku);
        this.shinsainShikaku = shinsainShikaku;
    }

    public void setShinsainKbn(RString shinsainKbn) {
        this.setOriginalData("shinsainKbn", shinsainKbn);
        this.shinsainKbn = shinsainKbn;
    }

    public void setGogitaiKbn(RString gogitaiKbn) {
        this.setOriginalData("gogitaiKbn", gogitaiKbn);
        this.gogitaiKbn = gogitaiKbn;
    }

    public void setShukketsuKbn(RString shukketsuKbn) {
        this.setOriginalData("shukketsuKbn", shukketsuKbn);
        this.shukketsuKbn = shukketsuKbn;
    }

}