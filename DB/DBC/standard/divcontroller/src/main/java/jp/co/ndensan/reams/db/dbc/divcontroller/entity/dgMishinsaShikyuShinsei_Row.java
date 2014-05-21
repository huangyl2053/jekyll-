package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 22 08:53:28 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;


/**
 * dgMishinsaShikyuShinsei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgMishinsaShikyuShinsei_Row extends DataRow {

    private Button btnModify;
    private TextBoxDate txtShikyuShinseiDate;
    private TextBoxDate txtTeikyoYM;
    private RString txtHihoNo;
    private RString txtHihokenshaName;
    private TextBoxNum txtHokenKyufuAmount;
    private TextBoxNum txtRiyoshaFutanAmount;
    private TextBoxNum txtHiyoTotalAmount;
    private Boolean txtTenkyoReset;
    private Boolean txt3DankaiReset;
    private RString txtShinsaResult;
    private TextBoxCode txtSeiriNo;

    public dgMishinsaShikyuShinsei_Row() {
        super();
    }

    public dgMishinsaShikyuShinsei_Row(Button btnModify, TextBoxDate txtShikyuShinseiDate, TextBoxDate txtTeikyoYM, RString txtHihoNo, RString txtHihokenshaName, TextBoxNum txtHokenKyufuAmount, TextBoxNum txtRiyoshaFutanAmount, TextBoxNum txtHiyoTotalAmount, Boolean txtTenkyoReset, Boolean txt3DankaiReset, RString txtShinsaResult, TextBoxCode txtSeiriNo) {
        super();
        this.setOriginalData("btnModify", btnModify);
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtHiyoTotalAmount", txtHiyoTotalAmount);
        this.setOriginalData("txtTenkyoReset", txtTenkyoReset);
        this.setOriginalData("txt3DankaiReset", txt3DankaiReset);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.btnModify = btnModify;
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtHihoNo = txtHihoNo;
        this.txtHihokenshaName = txtHihokenshaName;
        this.txtHokenKyufuAmount = txtHokenKyufuAmount;
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
        this.txtHiyoTotalAmount = txtHiyoTotalAmount;
        this.txtTenkyoReset = txtTenkyoReset;
        this.txt3DankaiReset = txt3DankaiReset;
        this.txtShinsaResult = txtShinsaResult;
        this.txtSeiriNo = txtSeiriNo;
    }

    public Button getBtnModify() {
        return btnModify;
    }

    public TextBoxDate getTxtShikyuShinseiDate() {
        return txtShikyuShinseiDate;
    }

    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    public TextBoxNum getTxtHokenKyufuAmount() {
        return txtHokenKyufuAmount;
    }

    public TextBoxNum getTxtRiyoshaFutanAmount() {
        return txtRiyoshaFutanAmount;
    }

    public TextBoxNum getTxtHiyoTotalAmount() {
        return txtHiyoTotalAmount;
    }

    public Boolean getTxtTenkyoReset() {
        return txtTenkyoReset;
    }

    public Boolean getTxt3DankaiReset() {
        return txt3DankaiReset;
    }

    public RString getTxtShinsaResult() {
        return txtShinsaResult;
    }

    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    public void setBtnModify(Button btnModify) {
        this.setOriginalData("btnModify", btnModify);
        this.btnModify = btnModify;
    }

    public void setTxtShikyuShinseiDate(TextBoxDate txtShikyuShinseiDate) {
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
    }

    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihokenshaName(RString txtHihokenshaName) {
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.txtHihokenshaName = txtHihokenshaName;
    }

    public void setTxtHokenKyufuAmount(TextBoxNum txtHokenKyufuAmount) {
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.txtHokenKyufuAmount = txtHokenKyufuAmount;
    }

    public void setTxtRiyoshaFutanAmount(TextBoxNum txtRiyoshaFutanAmount) {
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
    }

    public void setTxtHiyoTotalAmount(TextBoxNum txtHiyoTotalAmount) {
        this.setOriginalData("txtHiyoTotalAmount", txtHiyoTotalAmount);
        this.txtHiyoTotalAmount = txtHiyoTotalAmount;
    }

    public void setTxtTenkyoReset(Boolean txtTenkyoReset) {
        this.setOriginalData("txtTenkyoReset", txtTenkyoReset);
        this.txtTenkyoReset = txtTenkyoReset;
    }

    public void setTxt3DankaiReset(Boolean txt3DankaiReset) {
        this.setOriginalData("txt3DankaiReset", txt3DankaiReset);
        this.txt3DankaiReset = txt3DankaiReset;
    }

    public void setTxtShinsaResult(RString txtShinsaResult) {
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.txtShinsaResult = txtShinsaResult;
    }

    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtSeiriNo = txtSeiriNo;
    }

}