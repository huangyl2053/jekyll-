package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 14 17:38:01 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * dgShichosonIchiran_Row のクラスファイル
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class dgShichosonIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBox txtCityCode;
    private TextBox txtCityName;
    private TextBox txtShoriState;
    private TextBox txtSaishinShoriNitiji;

    public dgShichosonIchiran_Row() {
        super();
        this.txtCityCode = new TextBox();
        this.txtCityName = new TextBox();
        this.txtShoriState = new TextBox();
        this.txtSaishinShoriNitiji = new TextBox();
        this.setOriginalData("txtCityCode", txtCityCode);
        this.setOriginalData("txtCityName", txtCityName);
        this.setOriginalData("txtShoriState", txtShoriState);
        this.setOriginalData("txtSaishinShoriNitiji", txtSaishinShoriNitiji);
    }

    public dgShichosonIchiran_Row(TextBox txtCityCode, TextBox txtCityName, TextBox txtShoriState, TextBox txtSaishinShoriNitiji) {
        super();
        this.setOriginalData("txtCityCode", txtCityCode);
        this.setOriginalData("txtCityName", txtCityName);
        this.setOriginalData("txtShoriState", txtShoriState);
        this.setOriginalData("txtSaishinShoriNitiji", txtSaishinShoriNitiji);
        this.txtCityCode = txtCityCode;
        this.txtCityName = txtCityName;
        this.txtShoriState = txtShoriState;
        this.txtSaishinShoriNitiji = txtSaishinShoriNitiji;
    }

    public TextBox getTxtCityCode() {
        return txtCityCode;
    }

    public TextBox getTxtCityName() {
        return txtCityName;
    }

    public TextBox getTxtShoriState() {
        return txtShoriState;
    }

    public TextBox getTxtSaishinShoriNitiji() {
        return txtSaishinShoriNitiji;
    }

    public void setTxtCityCode(TextBox txtCityCode) {
        this.setOriginalData("txtCityCode", txtCityCode);
        this.txtCityCode = txtCityCode;
    }

    public void setTxtCityName(TextBox txtCityName) {
        this.setOriginalData("txtCityName", txtCityName);
        this.txtCityName = txtCityName;
    }

    public void setTxtShoriState(TextBox txtShoriState) {
        this.setOriginalData("txtShoriState", txtShoriState);
        this.txtShoriState = txtShoriState;
    }

    public void setTxtSaishinShoriNitiji(TextBox txtSaishinShoriNitiji) {
        this.setOriginalData("txtSaishinShoriNitiji", txtSaishinShoriNitiji);
        this.txtSaishinShoriNitiji = txtSaishinShoriNitiji;
    }

    // </editor-fold>
}
