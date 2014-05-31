package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat May 31 12:40:15 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinList_Row extends DataRow {

    private RString shinsakaiIinNo;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimei;
    private RString gender;
    private RString shozokuKikan;
    private RString shikaku;

    public dgShinsakaiIinList_Row() {
        super();
    }

    public dgShinsakaiIinList_Row(RString shinsakaiIinNo, RString shimei, RString kanaShimei, RString shimeiAndKanaShimei, RString gender, RString shozokuKikan, RString shikaku) {
        super();
        this.setOriginalData("shinsakaiIinNo", shinsakaiIinNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("shikaku", shikaku);
        this.shinsakaiIinNo = shinsakaiIinNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
        this.gender = gender;
        this.shozokuKikan = shozokuKikan;
        this.shikaku = shikaku;
    }

    public RString getShinsakaiIinNo() {
        return shinsakaiIinNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiAndKanaShimei() {
        return shimeiAndKanaShimei;
    }

    public RString getGender() {
        return gender;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public void setShinsakaiIinNo(RString shinsakaiIinNo) {
        this.setOriginalData("shinsakaiIinNo", shinsakaiIinNo);
        this.shinsakaiIinNo = shinsakaiIinNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiAndKanaShimei(RString shimeiAndKanaShimei) {
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

}