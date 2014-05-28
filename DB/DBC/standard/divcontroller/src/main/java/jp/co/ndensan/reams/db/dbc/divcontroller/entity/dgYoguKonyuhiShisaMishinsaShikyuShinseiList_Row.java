package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 17:23:16 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row extends DataRow {

    private Button btnModifyShinsei;
    private TextBoxDate txtShikyuShinseiDate;
    private TextBoxDate txtTenkyoYM;
    private TextBoxCode txtHihoNo;
    private TextBox txtHihoName;
    private TextBoxNum txtHokenSeikyuAmount;
    private TextBoxNum txtRiyoshaFutanAmount;
    private TextBoxNum txtLimitOverAmount;
    private TextBox txtShinsaResult;
    private TextBox txtSeiriNo;

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row() {
        super();
    }

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(Button btnModifyShinsei, TextBoxDate txtShikyuShinseiDate, TextBoxDate txtTenkyoYM, TextBoxCode txtHihoNo, TextBox txtHihoName, TextBoxNum txtHokenSeikyuAmount, TextBoxNum txtRiyoshaFutanAmount, TextBoxNum txtLimitOverAmount, TextBox txtShinsaResult, TextBox txtSeiriNo) {
        super();
        this.setOriginalData("btnModifyShinsei", btnModifyShinsei);
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtHokenSeikyuAmount", txtHokenSeikyuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtLimitOverAmount", txtLimitOverAmount);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.btnModifyShinsei = btnModifyShinsei;
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
        this.txtTenkyoYM = txtTenkyoYM;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtHokenSeikyuAmount = txtHokenSeikyuAmount;
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
        this.txtLimitOverAmount = txtLimitOverAmount;
        this.txtShinsaResult = txtShinsaResult;
        this.txtSeiriNo = txtSeiriNo;
    }

    public Button getBtnModifyShinsei() {
        return btnModifyShinsei;
    }

    public TextBoxDate getTxtShikyuShinseiDate() {
        return txtShikyuShinseiDate;
    }

    public TextBoxDate getTxtTenkyoYM() {
        return txtTenkyoYM;
    }

    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    public TextBox getTxtHihoName() {
        return txtHihoName;
    }

    public TextBoxNum getTxtHokenSeikyuAmount() {
        return txtHokenSeikyuAmount;
    }

    public TextBoxNum getTxtRiyoshaFutanAmount() {
        return txtRiyoshaFutanAmount;
    }

    public TextBoxNum getTxtLimitOverAmount() {
        return txtLimitOverAmount;
    }

    public TextBox getTxtShinsaResult() {
        return txtShinsaResult;
    }

    public TextBox getTxtSeiriNo() {
        return txtSeiriNo;
    }

    public void setBtnModifyShinsei(Button btnModifyShinsei) {
        this.setOriginalData("btnModifyShinsei", btnModifyShinsei);
        this.btnModifyShinsei = btnModifyShinsei;
    }

    public void setTxtShikyuShinseiDate(TextBoxDate txtShikyuShinseiDate) {
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
    }

    public void setTxtTenkyoYM(TextBoxDate txtTenkyoYM) {
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.txtTenkyoYM = txtTenkyoYM;
    }

    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihoName(TextBox txtHihoName) {
        this.setOriginalData("txtHihoName", txtHihoName);
        this.txtHihoName = txtHihoName;
    }

    public void setTxtHokenSeikyuAmount(TextBoxNum txtHokenSeikyuAmount) {
        this.setOriginalData("txtHokenSeikyuAmount", txtHokenSeikyuAmount);
        this.txtHokenSeikyuAmount = txtHokenSeikyuAmount;
    }

    public void setTxtRiyoshaFutanAmount(TextBoxNum txtRiyoshaFutanAmount) {
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
    }

    public void setTxtLimitOverAmount(TextBoxNum txtLimitOverAmount) {
        this.setOriginalData("txtLimitOverAmount", txtLimitOverAmount);
        this.txtLimitOverAmount = txtLimitOverAmount;
    }

    public void setTxtShinsaResult(TextBox txtShinsaResult) {
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.txtShinsaResult = txtShinsaResult;
    }

    public void setTxtSeiriNo(TextBox txtSeiriNo) {
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtSeiriNo = txtSeiriNo;
    }

}