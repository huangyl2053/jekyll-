package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 16:03:14 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinChildList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinChildList_Row extends DataRow {

    private Button btnToSelect;
    private RString shinsakaiIinNo;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimei;
    private RString shozokuKikan;
    private RString gender;
    private RString shikaku;

    public dgShinsakaiIinChildList_Row() {
        super();
        this.btnToSelect = new Button();
        this.shinsakaiIinNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiAndKanaShimei = RString.EMPTY;
        this.shozokuKikan = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.shikaku = RString.EMPTY;
    }

    public dgShinsakaiIinChildList_Row(Button btnToSelect, RString shinsakaiIinNo, RString shimei, RString kanaShimei, RString shimeiAndKanaShimei, RString shozokuKikan, RString gender, RString shikaku) {
        super();
        this.setOriginalData("btnToSelect", btnToSelect);
        this.setOriginalData("shinsakaiIinNo", shinsakaiIinNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("gender", gender);
        this.setOriginalData("shikaku", shikaku);
        this.btnToSelect = btnToSelect;
        this.shinsakaiIinNo = shinsakaiIinNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
        this.shozokuKikan = shozokuKikan;
        this.gender = gender;
        this.shikaku = shikaku;
    }

    public Button getBtnToSelect() {
        return btnToSelect;
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

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public RString getGender() {
        return gender;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public void setBtnToSelect(Button btnToSelect) {
        this.setOriginalData("btnToSelect", btnToSelect);
        this.btnToSelect = btnToSelect;
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

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

}