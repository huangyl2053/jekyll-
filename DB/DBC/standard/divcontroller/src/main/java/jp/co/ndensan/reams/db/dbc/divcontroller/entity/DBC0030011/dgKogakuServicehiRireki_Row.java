package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 18 11:25:36 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKogakuServicehiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKogakuServicehiRireki_Row extends DataRow {

    private Button btnSelect;
    private RString txtHihoNo;
    private RString txtHihoName;
    private RString txtTeikyoYM;
    private TextBoxNum txtKogakuShikyuAmount;
    private RString txtShinseiDate;
    private RString txtKetteiDate;
    private RString txtShikyuKubun;
    private TextBoxNum txtShikyuKingaku;
    private RString txtKogakuAutoShokan;
    private RString txtHokensha;

    public dgKogakuServicehiRireki_Row() {
        super();
        this.btnSelect = new Button();
        this.txtHihoNo = RString.EMPTY;
        this.txtHihoName = RString.EMPTY;
        this.txtTeikyoYM = RString.EMPTY;
        this.txtKogakuShikyuAmount = new TextBoxNum();
        this.txtShinseiDate = RString.EMPTY;
        this.txtKetteiDate = RString.EMPTY;
        this.txtShikyuKubun = RString.EMPTY;
        this.txtShikyuKingaku = new TextBoxNum();
        this.txtKogakuAutoShokan = RString.EMPTY;
        this.txtHokensha = RString.EMPTY;
    }

    public dgKogakuServicehiRireki_Row(Button btnSelect, RString txtHihoNo, RString txtHihoName, RString txtTeikyoYM, TextBoxNum txtKogakuShikyuAmount, RString txtShinseiDate, RString txtKetteiDate, RString txtShikyuKubun, TextBoxNum txtShikyuKingaku, RString txtKogakuAutoShokan, RString txtHokensha) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.setOriginalData("txtShikyuKingaku", txtShikyuKingaku);
        this.setOriginalData("txtKogakuAutoShokan", txtKogakuAutoShokan);
        this.setOriginalData("txtHokensha", txtHokensha);
        this.btnSelect = btnSelect;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
        this.txtShinseiDate = txtShinseiDate;
        this.txtKetteiDate = txtKetteiDate;
        this.txtShikyuKubun = txtShikyuKubun;
        this.txtShikyuKingaku = txtShikyuKingaku;
        this.txtKogakuAutoShokan = txtKogakuAutoShokan;
        this.txtHokensha = txtHokensha;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihoName() {
        return txtHihoName;
    }

    public RString getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public TextBoxNum getTxtKogakuShikyuAmount() {
        return txtKogakuShikyuAmount;
    }

    public RString getTxtShinseiDate() {
        return txtShinseiDate;
    }

    public RString getTxtKetteiDate() {
        return txtKetteiDate;
    }

    public RString getTxtShikyuKubun() {
        return txtShikyuKubun;
    }

    public TextBoxNum getTxtShikyuKingaku() {
        return txtShikyuKingaku;
    }

    public RString getTxtKogakuAutoShokan() {
        return txtKogakuAutoShokan;
    }

    public RString getTxtHokensha() {
        return txtHokensha;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihoName(RString txtHihoName) {
        this.setOriginalData("txtHihoName", txtHihoName);
        this.txtHihoName = txtHihoName;
    }

    public void setTxtTeikyoYM(RString txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtKogakuShikyuAmount(TextBoxNum txtKogakuShikyuAmount) {
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
    }

    public void setTxtShinseiDate(RString txtShinseiDate) {
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.txtShinseiDate = txtShinseiDate;
    }

    public void setTxtKetteiDate(RString txtKetteiDate) {
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.txtKetteiDate = txtKetteiDate;
    }

    public void setTxtShikyuKubun(RString txtShikyuKubun) {
        this.setOriginalData("txtShikyuKubun", txtShikyuKubun);
        this.txtShikyuKubun = txtShikyuKubun;
    }

    public void setTxtShikyuKingaku(TextBoxNum txtShikyuKingaku) {
        this.setOriginalData("txtShikyuKingaku", txtShikyuKingaku);
        this.txtShikyuKingaku = txtShikyuKingaku;
    }

    public void setTxtKogakuAutoShokan(RString txtKogakuAutoShokan) {
        this.setOriginalData("txtKogakuAutoShokan", txtKogakuAutoShokan);
        this.txtKogakuAutoShokan = txtKogakuAutoShokan;
    }

    public void setTxtHokensha(RString txtHokensha) {
        this.setOriginalData("txtHokensha", txtHokensha);
        this.txtHokensha = txtHokensha;
    }

}