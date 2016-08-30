package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 24 11:23:23 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * dgKoikiShoriTaishoSelect_Row のクラスファイル
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class dgKoikiShoriTaishoSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBox txtCityCode;
    private TextBox txtCityName;
    private RString txtCityShikibetsuId;
    private RString txtShukeibiKbnData;
    private TextBox txtShukeibiKbn;
    private TextBox txtKikanStHosei;
    private TextBox txtKikanEdHosei;
    private TextBox txtZenShoriNichiji;
    private TextBoxDate txtZenShoriYMD;
    private TextBoxTime txtZenShoriTime;

    public dgKoikiShoriTaishoSelect_Row() {
        super();
        this.txtCityCode = new TextBox();
        this.txtCityName = new TextBox();
        this.txtCityShikibetsuId = RString.EMPTY;
        this.txtShukeibiKbnData = RString.EMPTY;
        this.txtShukeibiKbn = new TextBox();
        this.txtKikanStHosei = new TextBox();
        this.txtKikanEdHosei = new TextBox();
        this.txtZenShoriNichiji = new TextBox();
        this.txtZenShoriYMD = new TextBoxDate();
        this.txtZenShoriTime = new TextBoxTime();
        this.setOriginalData("txtCityCode", txtCityCode);
        this.setOriginalData("txtCityName", txtCityName);
        this.setOriginalData("txtCityShikibetsuId", txtCityShikibetsuId);
        this.setOriginalData("txtShukeibiKbnData", txtShukeibiKbnData);
        this.setOriginalData("txtShukeibiKbn", txtShukeibiKbn);
        this.setOriginalData("txtKikanStHosei", txtKikanStHosei);
        this.setOriginalData("txtKikanEdHosei", txtKikanEdHosei);
        this.setOriginalData("txtZenShoriNichiji", txtZenShoriNichiji);
        this.setOriginalData("txtZenShoriYMD", txtZenShoriYMD);
        this.setOriginalData("txtZenShoriTime", txtZenShoriTime);
    }

    public dgKoikiShoriTaishoSelect_Row(TextBox txtCityCode, TextBox txtCityName, RString txtCityShikibetsuId, RString txtShukeibiKbnData, TextBox txtShukeibiKbn, TextBox txtKikanStHosei, TextBox txtKikanEdHosei, TextBox txtZenShoriNichiji, TextBoxDate txtZenShoriYMD, TextBoxTime txtZenShoriTime) {
        super();
        this.setOriginalData("txtCityCode", txtCityCode);
        this.setOriginalData("txtCityName", txtCityName);
        this.setOriginalData("txtCityShikibetsuId", txtCityShikibetsuId);
        this.setOriginalData("txtShukeibiKbnData", txtShukeibiKbnData);
        this.setOriginalData("txtShukeibiKbn", txtShukeibiKbn);
        this.setOriginalData("txtKikanStHosei", txtKikanStHosei);
        this.setOriginalData("txtKikanEdHosei", txtKikanEdHosei);
        this.setOriginalData("txtZenShoriNichiji", txtZenShoriNichiji);
        this.setOriginalData("txtZenShoriYMD", txtZenShoriYMD);
        this.setOriginalData("txtZenShoriTime", txtZenShoriTime);
        this.txtCityCode = txtCityCode;
        this.txtCityName = txtCityName;
        this.txtCityShikibetsuId = txtCityShikibetsuId;
        this.txtShukeibiKbnData = txtShukeibiKbnData;
        this.txtShukeibiKbn = txtShukeibiKbn;
        this.txtKikanStHosei = txtKikanStHosei;
        this.txtKikanEdHosei = txtKikanEdHosei;
        this.txtZenShoriNichiji = txtZenShoriNichiji;
        this.txtZenShoriYMD = txtZenShoriYMD;
        this.txtZenShoriTime = txtZenShoriTime;
    }

    public TextBox getTxtCityCode() {
        return txtCityCode;
    }

    public TextBox getTxtCityName() {
        return txtCityName;
    }

    public RString getTxtCityShikibetsuId() {
        return txtCityShikibetsuId;
    }

    public RString getTxtShukeibiKbnData() {
        return txtShukeibiKbnData;
    }

    public TextBox getTxtShukeibiKbn() {
        return txtShukeibiKbn;
    }

    public TextBox getTxtKikanStHosei() {
        return txtKikanStHosei;
    }

    public TextBox getTxtKikanEdHosei() {
        return txtKikanEdHosei;
    }

    public TextBox getTxtZenShoriNichiji() {
        return txtZenShoriNichiji;
    }

    public TextBoxDate getTxtZenShoriYMD() {
        return txtZenShoriYMD;
    }

    public TextBoxTime getTxtZenShoriTime() {
        return txtZenShoriTime;
    }

    public void setTxtCityCode(TextBox txtCityCode) {
        this.setOriginalData("txtCityCode", txtCityCode);
        this.txtCityCode = txtCityCode;
    }

    public void setTxtCityName(TextBox txtCityName) {
        this.setOriginalData("txtCityName", txtCityName);
        this.txtCityName = txtCityName;
    }

    public void setTxtCityShikibetsuId(RString txtCityShikibetsuId) {
        this.setOriginalData("txtCityShikibetsuId", txtCityShikibetsuId);
        this.txtCityShikibetsuId = txtCityShikibetsuId;
    }

    public void setTxtShukeibiKbnData(RString txtShukeibiKbnData) {
        this.setOriginalData("txtShukeibiKbnData", txtShukeibiKbnData);
        this.txtShukeibiKbnData = txtShukeibiKbnData;
    }

    public void setTxtShukeibiKbn(TextBox txtShukeibiKbn) {
        this.setOriginalData("txtShukeibiKbn", txtShukeibiKbn);
        this.txtShukeibiKbn = txtShukeibiKbn;
    }

    public void setTxtKikanStHosei(TextBox txtKikanStHosei) {
        this.setOriginalData("txtKikanStHosei", txtKikanStHosei);
        this.txtKikanStHosei = txtKikanStHosei;
    }

    public void setTxtKikanEdHosei(TextBox txtKikanEdHosei) {
        this.setOriginalData("txtKikanEdHosei", txtKikanEdHosei);
        this.txtKikanEdHosei = txtKikanEdHosei;
    }

    public void setTxtZenShoriNichiji(TextBox txtZenShoriNichiji) {
        this.setOriginalData("txtZenShoriNichiji", txtZenShoriNichiji);
        this.txtZenShoriNichiji = txtZenShoriNichiji;
    }

    public void setTxtZenShoriYMD(TextBoxDate txtZenShoriYMD) {
        this.setOriginalData("txtZenShoriYMD", txtZenShoriYMD);
        this.txtZenShoriYMD = txtZenShoriYMD;
    }

    public void setTxtZenShoriTime(TextBoxTime txtZenShoriTime) {
        this.setOriginalData("txtZenShoriTime", txtZenShoriTime);
        this.txtZenShoriTime = txtZenShoriTime;
    }

    // </editor-fold>
}
