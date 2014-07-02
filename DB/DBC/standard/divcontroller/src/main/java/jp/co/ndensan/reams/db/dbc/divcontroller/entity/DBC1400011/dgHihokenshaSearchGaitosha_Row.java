package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 25 13:41:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHihokenshaSearchGaitosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHihokenshaSearchGaitosha_Row extends DataRow {

    private Button btnSelect;
    private Boolean chkCreateMoshitatesho;
    private RString txtJigyoshaNo;
    private RString txtJigyoshaName;
    private RString txtHihoNo;
    private RString txtHihoName;
    private RString txtKagoForm;
    private RString txtTeikyoYM;
    private RString txtKyufuJissekiSakuseiKubun;
    private RString txtKyufuKubun;
    private RString txtShinsaYM;

    public dgHihokenshaSearchGaitosha_Row() {
        super();
        this.btnSelect = new Button();
        this.chkCreateMoshitatesho = false;
        this.txtJigyoshaNo = RString.EMPTY;
        this.txtJigyoshaName = RString.EMPTY;
        this.txtHihoNo = RString.EMPTY;
        this.txtHihoName = RString.EMPTY;
        this.txtKagoForm = RString.EMPTY;
        this.txtTeikyoYM = RString.EMPTY;
        this.txtKyufuJissekiSakuseiKubun = RString.EMPTY;
        this.txtKyufuKubun = RString.EMPTY;
        this.txtShinsaYM = RString.EMPTY;
    }

    public dgHihokenshaSearchGaitosha_Row(Button btnSelect, Boolean chkCreateMoshitatesho, RString txtJigyoshaNo, RString txtJigyoshaName, RString txtHihoNo, RString txtHihoName, RString txtKagoForm, RString txtTeikyoYM, RString txtKyufuJissekiSakuseiKubun, RString txtKyufuKubun, RString txtShinsaYM) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("chkCreateMoshitatesho", chkCreateMoshitatesho);
        this.setOriginalData("txtJigyoshaNo", txtJigyoshaNo);
        this.setOriginalData("txtJigyoshaName", txtJigyoshaName);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtKagoForm", txtKagoForm);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtKyufuJissekiSakuseiKubun", txtKyufuJissekiSakuseiKubun);
        this.setOriginalData("txtKyufuKubun", txtKyufuKubun);
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.btnSelect = btnSelect;
        this.chkCreateMoshitatesho = chkCreateMoshitatesho;
        this.txtJigyoshaNo = txtJigyoshaNo;
        this.txtJigyoshaName = txtJigyoshaName;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtKagoForm = txtKagoForm;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtKyufuJissekiSakuseiKubun = txtKyufuJissekiSakuseiKubun;
        this.txtKyufuKubun = txtKyufuKubun;
        this.txtShinsaYM = txtShinsaYM;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public Boolean getChkCreateMoshitatesho() {
        return chkCreateMoshitatesho;
    }

    public RString getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    public RString getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihoName() {
        return txtHihoName;
    }

    public RString getTxtKagoForm() {
        return txtKagoForm;
    }

    public RString getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public RString getTxtKyufuJissekiSakuseiKubun() {
        return txtKyufuJissekiSakuseiKubun;
    }

    public RString getTxtKyufuKubun() {
        return txtKyufuKubun;
    }

    public RString getTxtShinsaYM() {
        return txtShinsaYM;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setChkCreateMoshitatesho(Boolean chkCreateMoshitatesho) {
        this.setOriginalData("chkCreateMoshitatesho", chkCreateMoshitatesho);
        this.chkCreateMoshitatesho = chkCreateMoshitatesho;
    }

    public void setTxtJigyoshaNo(RString txtJigyoshaNo) {
        this.setOriginalData("txtJigyoshaNo", txtJigyoshaNo);
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    public void setTxtJigyoshaName(RString txtJigyoshaName) {
        this.setOriginalData("txtJigyoshaName", txtJigyoshaName);
        this.txtJigyoshaName = txtJigyoshaName;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihoName(RString txtHihoName) {
        this.setOriginalData("txtHihoName", txtHihoName);
        this.txtHihoName = txtHihoName;
    }

    public void setTxtKagoForm(RString txtKagoForm) {
        this.setOriginalData("txtKagoForm", txtKagoForm);
        this.txtKagoForm = txtKagoForm;
    }

    public void setTxtTeikyoYM(RString txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtKyufuJissekiSakuseiKubun(RString txtKyufuJissekiSakuseiKubun) {
        this.setOriginalData("txtKyufuJissekiSakuseiKubun", txtKyufuJissekiSakuseiKubun);
        this.txtKyufuJissekiSakuseiKubun = txtKyufuJissekiSakuseiKubun;
    }

    public void setTxtKyufuKubun(RString txtKyufuKubun) {
        this.setOriginalData("txtKyufuKubun", txtKyufuKubun);
        this.txtKyufuKubun = txtKyufuKubun;
    }

    public void setTxtShinsaYM(RString txtShinsaYM) {
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.txtShinsaYM = txtShinsaYM;
    }

}