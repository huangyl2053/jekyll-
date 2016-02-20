package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Feb 17 14:11:38 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">

    private RString txtJotai;
    private TextBoxDate txtShikyuShinseiDate;
    private TextBoxDate txtTenkyoYM;
    private TextBoxCode txtHihoNo;
    private TextBox txtHihoName;
    private TextBoxNum txtHokenKyufuAmount;
    private TextBoxNum txtRiyoshaFutanAmount;
    private TextBoxNum txtHiyoTotal;
    private TextBox txtShinsaResult;
    private TextBox txtSeiriNo;
    private TextBoxCode txtJigyoshaNo;
    private TextBoxCode txtYoshikiNo;
    private TextBoxCode txtMeisaiNo;
    private TextBoxCode txtShinsaNo;
    private TextBoxNum rowNum;

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row() {
        super();
        this.txtJotai = RString.EMPTY;
        this.txtShikyuShinseiDate = new TextBoxDate();
        this.txtTenkyoYM = new TextBoxDate();
        this.txtHihoNo = new TextBoxCode();
        this.txtHihoName = new TextBox();
        this.txtHokenKyufuAmount = new TextBoxNum();
        this.txtRiyoshaFutanAmount = new TextBoxNum();
        this.txtHiyoTotal = new TextBoxNum();
        this.txtShinsaResult = new TextBox();
        this.txtSeiriNo = new TextBox();
        this.txtJigyoshaNo = new TextBoxCode();
        this.txtYoshikiNo = new TextBoxCode();
        this.txtMeisaiNo = new TextBoxCode();
        this.txtShinsaNo = new TextBoxCode();
        this.rowNum = new TextBoxNum();
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtHiyoTotal", txtHiyoTotal);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.setOriginalData("txtJigyoshaNo", txtJigyoshaNo);
        this.setOriginalData("txtYoshikiNo", txtYoshikiNo);
        this.setOriginalData("txtMeisaiNo", txtMeisaiNo);
        this.setOriginalData("txtShinsaNo", txtShinsaNo);
        this.setOriginalData("rowNum", rowNum);
    }

    public dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(RString txtJotai, TextBoxDate txtShikyuShinseiDate, TextBoxDate txtTenkyoYM, TextBoxCode txtHihoNo, TextBox txtHihoName, TextBoxNum txtHokenKyufuAmount, TextBoxNum txtRiyoshaFutanAmount, TextBoxNum txtHiyoTotal, TextBox txtShinsaResult, TextBox txtSeiriNo, TextBoxCode txtJigyoshaNo, TextBoxCode txtYoshikiNo, TextBoxCode txtMeisaiNo, TextBoxCode txtShinsaNo, TextBoxNum rowNum) {
        super();
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtShikyuShinseiDate", txtShikyuShinseiDate);
        this.setOriginalData("txtTenkyoYM", txtTenkyoYM);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihoName", txtHihoName);
        this.setOriginalData("txtHokenKyufuAmount", txtHokenKyufuAmount);
        this.setOriginalData("txtRiyoshaFutanAmount", txtRiyoshaFutanAmount);
        this.setOriginalData("txtHiyoTotal", txtHiyoTotal);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.setOriginalData("txtJigyoshaNo", txtJigyoshaNo);
        this.setOriginalData("txtYoshikiNo", txtYoshikiNo);
        this.setOriginalData("txtMeisaiNo", txtMeisaiNo);
        this.setOriginalData("txtShinsaNo", txtShinsaNo);
        this.setOriginalData("rowNum", rowNum);
        this.txtJotai = txtJotai;
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
        this.txtTenkyoYM = txtTenkyoYM;
        this.txtHihoNo = txtHihoNo;
        this.txtHihoName = txtHihoName;
        this.txtHokenKyufuAmount = txtHokenKyufuAmount;
        this.txtRiyoshaFutanAmount = txtRiyoshaFutanAmount;
        this.txtHiyoTotal = txtHiyoTotal;
        this.txtShinsaResult = txtShinsaResult;
        this.txtSeiriNo = txtSeiriNo;
        this.txtJigyoshaNo = txtJigyoshaNo;
        this.txtYoshikiNo = txtYoshikiNo;
        this.txtMeisaiNo = txtMeisaiNo;
        this.txtShinsaNo = txtShinsaNo;
        this.rowNum = rowNum;
    }

    public RString getTxtJotai() {
        return txtJotai;
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

    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    public TextBoxCode getTxtYoshikiNo() {
        return txtYoshikiNo;
    }

    public TextBoxCode getTxtMeisaiNo() {
        return txtMeisaiNo;
    }

    public TextBoxCode getTxtShinsaNo() {
        return txtShinsaNo;
    }

    public TextBoxNum getRowNum() {
        return rowNum;
    }

    public void setTxtJotai(RString txtJotai) {
        this.setOriginalData("txtJotai", txtJotai);
        this.txtJotai = txtJotai;
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

    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.setOriginalData("txtJigyoshaNo", txtJigyoshaNo);
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    public void setTxtYoshikiNo(TextBoxCode txtYoshikiNo) {
        this.setOriginalData("txtYoshikiNo", txtYoshikiNo);
        this.txtYoshikiNo = txtYoshikiNo;
    }

    public void setTxtMeisaiNo(TextBoxCode txtMeisaiNo) {
        this.setOriginalData("txtMeisaiNo", txtMeisaiNo);
        this.txtMeisaiNo = txtMeisaiNo;
    }

    public void setTxtShinsaNo(TextBoxCode txtShinsaNo) {
        this.setOriginalData("txtShinsaNo", txtShinsaNo);
        this.txtShinsaNo = txtShinsaNo;
    }

    public void setRowNum(TextBoxNum rowNum) {
        this.setOriginalData("rowNum", rowNum);
        this.rowNum = rowNum;
    }

    // </editor-fold>
}
