package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 14 19:48:14 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinList_Row extends DataRow {

    private Button btnToSelect;
    private RString shinsakaiIinNo;
    private RString shimei;
    private RString kanaShimei;
    private RString shozokuKikan;
    private RString gender;
    private RString shikaku;

    public dgShinsakaiIinList_Row() {
        super();
    }

    public dgShinsakaiIinList_Row(Button btnToSelect, RString shinsakaiIinNo, RString shimei, RString kanaShimei, RString shozokuKikan, RString gender, RString shikaku) {
        super();
        this.setOriginalData("btnToSelect", btnToSelect);
        this.setOriginalData("shinsakaiIinNo", shinsakaiIinNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("gender", gender);
        this.setOriginalData("shikaku", shikaku);
        this.btnToSelect = btnToSelect;
        this.shinsakaiIinNo = shinsakaiIinNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
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