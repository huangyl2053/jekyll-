package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 24 14:14:28 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
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

    private TextBoxDate txtShikyuShinseiDate;
    private TextBoxDate txtTenkyoYM;
    private TextBoxCode txtHihoNo;
    private TextBox txtHihoName;
    private TextBoxNum txtHokenKyufuAmount;
    private TextBoxNum txtRiyoshaFutanAmount;
    private TextBoxNum txtHiyoTotal;
    private TextBox txtShinsaResult;
    private TextBox txtSeiriNo;

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row() {
        super();
        this.txtShikyuShinseiDate = new TextBoxDate();
        this.txtTenkyoYM = new TextBoxDate();
        this.txtHihoNo = new TextBoxCode();
        this.txtHihoName = new TextBox();
        this.txtHokenKyufuAmount = new TextBoxNum();
        this.txtRiyoshaFutanAmount = new TextBoxNum();
        this.txtHiyoTotal = new TextBoxNum();
        this.txtShinsaResult = new TextBox();
        this.txtSeiriNo = new TextBox();
    }

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(TextBoxDate txtShikyuShinseiDate, TextBoxDate txtTenkyoYM, TextBoxCode txtHihoNo, TextBox txtHihoName, TextBoxNum txtHokenKyufuAmount, TextBoxNum txtRiyoshaFutanAmount, TextBoxNum txtHiyoTotal, TextBox txtShinsaResult, TextBox txtSeiriNo) {
        super();
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtHiyoTotal", txtHiyoTotal);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
        this.txtTenkyoYM = txtTenkyoYM;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtHokenKyufuAmount = txtHokenKyufuAmount;
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
        this.txtHiyoTotal = txtHiyoTotal;
        this.txtShinsaResult = txtShinsaResult;
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

    public TextBoxNum getTxtHokenKyufuAmount() {
        return txtHokenKyufuAmount;
    }

    public TextBoxNum getTxtRiyoshaFutanAmount() {
        return txtRiyoshaFutanAmount;
    }

    public TextBoxNum getTxtHiyoTotal() {
        return txtHiyoTotal;
    }

    public TextBox getTxtShinsaResult() {
        return txtShinsaResult;
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

    public void setTxtHokenKyufuAmount(TextBoxNum txtHokenKyufuAmount) {
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.txtHokenKyufuAmount = txtHokenKyufuAmount;
    }

    public void setTxtRiyoshaFutanAmount(TextBoxNum txtRiyoshaFutanAmount) {
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
    }

    public void setTxtHiyoTotal(TextBoxNum txtHiyoTotal) {
        this.setOriginalData("txtHiyoTotal", txtHiyoTotal);
        this.txtHiyoTotal = txtHiyoTotal;
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