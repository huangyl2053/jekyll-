package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 10 15:26:35 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgSeikyuDetail_Row のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class dgSeikyuDetail_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private TextBoxDate txtBuyYMD;
    private TextBox txtShumoku;
    private TextBox txtShohinName;
    private TextBoxNum txtBuyAmount;
    private TextBox txtShinsaMethod;
    private TextBox fukushiYoguSeizoJigyoshaName;
    private TextBox fukushiYoguHanbaiJigyoshaName;
    private RString renban;
    private TextBox hinmokuCode;
    private RString txtShinsa;

    public dgSeikyuDetail_Row() {
        super();
        this.txtBuyYMD = new TextBoxDate();
        this.txtShumoku = new TextBox();
        this.txtShohinName = new TextBox();
        this.txtBuyAmount = new TextBoxNum();
        this.txtShinsaMethod = new TextBox();
        this.fukushiYoguSeizoJigyoshaName = new TextBox();
        this.fukushiYoguHanbaiJigyoshaName = new TextBox();
        this.renban = RString.EMPTY;
        this.hinmokuCode = new TextBox();
        this.txtShinsa = RString.EMPTY;
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.setOriginalData("fukushiYoguSeizoJigyoshaName", fukushiYoguSeizoJigyoshaName);
        this.setOriginalData("fukushiYoguHanbaiJigyoshaName", fukushiYoguHanbaiJigyoshaName);
        this.setOriginalData("renban", renban);
        this.setOriginalData("hinmokuCode", hinmokuCode);
        this.setOriginalData("txtShinsa", txtShinsa);
    }

    public dgSeikyuDetail_Row(TextBoxDate txtBuyYMD, TextBox txtShumoku, TextBox txtShohinName, TextBoxNum txtBuyAmount, TextBox txtShinsaMethod, TextBox fukushiYoguSeizoJigyoshaName, TextBox fukushiYoguHanbaiJigyoshaName, RString renban, TextBox hinmokuCode, RString txtShinsa) {
        super();
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.setOriginalData("fukushiYoguSeizoJigyoshaName", fukushiYoguSeizoJigyoshaName);
        this.setOriginalData("fukushiYoguHanbaiJigyoshaName", fukushiYoguHanbaiJigyoshaName);
        this.setOriginalData("renban", renban);
        this.setOriginalData("hinmokuCode", hinmokuCode);
        this.setOriginalData("txtShinsa", txtShinsa);
        this.txtBuyYMD = txtBuyYMD;
        this.txtShumoku = txtShumoku;
        this.txtShohinName = txtShohinName;
        this.txtBuyAmount = txtBuyAmount;
        this.txtShinsaMethod = txtShinsaMethod;
        this.fukushiYoguSeizoJigyoshaName = fukushiYoguSeizoJigyoshaName;
        this.fukushiYoguHanbaiJigyoshaName = fukushiYoguHanbaiJigyoshaName;
        this.renban = renban;
        this.hinmokuCode = hinmokuCode;
        this.txtShinsa = txtShinsa;
    }

    public TextBoxDate getTxtBuyYMD() {
        return txtBuyYMD;
    }

    public TextBox getTxtShumoku() {
        return txtShumoku;
    }

    public TextBox getTxtShohinName() {
        return txtShohinName;
    }

    public TextBoxNum getTxtBuyAmount() {
        return txtBuyAmount;
    }

    public TextBox getTxtShinsaMethod() {
        return txtShinsaMethod;
    }

    public TextBox getFukushiYoguSeizoJigyoshaName() {
        return fukushiYoguSeizoJigyoshaName;
    }

    public TextBox getFukushiYoguHanbaiJigyoshaName() {
        return fukushiYoguHanbaiJigyoshaName;
    }

    public RString getRenban() {
        return renban;
    }

    public TextBox getHinmokuCode() {
        return hinmokuCode;
    }

    public RString getTxtShinsa() {
        return txtShinsa;
    }

    public void setTxtBuyYMD(TextBoxDate txtBuyYMD) {
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.txtBuyYMD = txtBuyYMD;
    }

    public void setTxtShumoku(TextBox txtShumoku) {
        this.setOriginalData("txtShumoku", txtShumoku);
        this.txtShumoku = txtShumoku;
    }

    public void setTxtShohinName(TextBox txtShohinName) {
        this.setOriginalData("txtShohinName", txtShohinName);
        this.txtShohinName = txtShohinName;
    }

    public void setTxtBuyAmount(TextBoxNum txtBuyAmount) {
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.txtBuyAmount = txtBuyAmount;
    }

    public void setTxtShinsaMethod(TextBox txtShinsaMethod) {
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.txtShinsaMethod = txtShinsaMethod;
    }

    public void setFukushiYoguSeizoJigyoshaName(TextBox fukushiYoguSeizoJigyoshaName) {
        this.setOriginalData("fukushiYoguSeizoJigyoshaName", fukushiYoguSeizoJigyoshaName);
        this.fukushiYoguSeizoJigyoshaName = fukushiYoguSeizoJigyoshaName;
    }

    public void setFukushiYoguHanbaiJigyoshaName(TextBox fukushiYoguHanbaiJigyoshaName) {
        this.setOriginalData("fukushiYoguHanbaiJigyoshaName", fukushiYoguHanbaiJigyoshaName);
        this.fukushiYoguHanbaiJigyoshaName = fukushiYoguHanbaiJigyoshaName;
    }

    public void setRenban(RString renban) {
        this.setOriginalData("renban", renban);
        this.renban = renban;
    }

    public void setHinmokuCode(TextBox hinmokuCode) {
        this.setOriginalData("hinmokuCode", hinmokuCode);
        this.hinmokuCode = hinmokuCode;
    }

    public void setTxtShinsa(RString txtShinsa) {
        this.setOriginalData("txtShinsa", txtShinsa);
        this.txtShinsa = txtShinsa;
    }

    // </editor-fold>
}
