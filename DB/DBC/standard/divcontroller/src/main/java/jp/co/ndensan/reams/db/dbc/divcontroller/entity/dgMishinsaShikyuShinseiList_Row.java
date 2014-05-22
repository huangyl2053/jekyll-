package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 21 15:00:07 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgMishinsaShikyuShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgMishinsaShikyuShinseiList_Row extends DataRow {

    private TextBoxDate txtShikyuShinseiDate;
    private TextBoxDate txtTenkyoYM;
    private TextBoxCode txtHihoNo;
    private TextBox txtHihoName;
    private TextBoxNum txtHokenSeikyuAmount;
    private TextBoxNum txtRiyoshaFutanAmount;
    private TextBoxNum txtLimitOverAmount;
    private TextBox txtShinsaResult;
    private TextBoxDate txtShinsaDate;
    private TextBox txtSeiriNo;

    public dgMishinsaShikyuShinseiList_Row() {
        super();
    }

    public dgMishinsaShikyuShinseiList_Row(TextBoxDate txtShikyuShinseiDate, TextBoxDate txtTenkyoYM, TextBoxCode txtHihoNo, TextBox txtHihoName, TextBoxNum txtHokenSeikyuAmount, TextBoxNum txtRiyoshaFutanAmount, TextBoxNum txtLimitOverAmount, TextBox txtShinsaResult, TextBoxDate txtShinsaDate, TextBox txtSeiriNo) {
        super();
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtHokenSeikyuAmount", txtHokenSeikyuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtLimitOverAmount", txtLimitOverAmount);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtShinsaDate", txtShinsaDate);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
        this.txtTenkyoYM = txtTenkyoYM;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtHokenSeikyuAmount = txtHokenSeikyuAmount;
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
        this.txtLimitOverAmount = txtLimitOverAmount;
        this.txtShinsaResult = txtShinsaResult;
        this.txtShinsaDate = txtShinsaDate;
        this.txtSeiriNo = txtSeiriNo;
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

    public TextBoxDate getTxtShinsaDate() {
        return txtShinsaDate;
    }

    public TextBox getTxtSeiriNo() {
        return txtSeiriNo;
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

    public void setTxtShinsaDate(TextBoxDate txtShinsaDate) {
        this.setOriginalData("txtShinsaDate", txtShinsaDate);
        this.txtShinsaDate = txtShinsaDate;
    }

    public void setTxtSeiriNo(TextBox txtSeiriNo) {
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtSeiriNo = txtSeiriNo;
    }

}