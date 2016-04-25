package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 25 16:35:09 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKeiyakuJigyosya_Row のクラスファイル
 *
 * @reamsid_L DBC-2120-010 panhe
 */
public class dgKeiyakuJigyosya_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString txtKeiyakuJigyoshaNo;
    private RString txtKeiyakuJigyoshaName;
    private RString txtKeiyakuJigyoshaJusho;
    private TextBoxDate txtKeiyakuFromYMD;
    private TextBoxDate txtKeiyakuToYMD;
    private RString txtKeiyakuShurui;

    public dgKeiyakuJigyosya_Row() {
        super();
        this.txtKeiyakuJigyoshaNo = RString.EMPTY;
        this.txtKeiyakuJigyoshaName = RString.EMPTY;
        this.txtKeiyakuJigyoshaJusho = RString.EMPTY;
        this.txtKeiyakuFromYMD = new TextBoxDate();
        this.txtKeiyakuToYMD = new TextBoxDate();
        this.txtKeiyakuShurui = RString.EMPTY;
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.setOriginalData("txtKeiyakuJigyoshaName", txtKeiyakuJigyoshaName);
        this.setOriginalData("txtKeiyakuJigyoshaJusho", txtKeiyakuJigyoshaJusho);
        this.setOriginalData("txtKeiyakuFromYMD", txtKeiyakuFromYMD);
        this.setOriginalData("txtKeiyakuToYMD", txtKeiyakuToYMD);
        this.setOriginalData("txtKeiyakuShurui", txtKeiyakuShurui);
    }

    public dgKeiyakuJigyosya_Row(RString txtKeiyakuJigyoshaNo, RString txtKeiyakuJigyoshaName, RString txtKeiyakuJigyoshaJusho, TextBoxDate txtKeiyakuFromYMD, TextBoxDate txtKeiyakuToYMD, RString txtKeiyakuShurui) {
        super();
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.setOriginalData("txtKeiyakuJigyoshaName", txtKeiyakuJigyoshaName);
        this.setOriginalData("txtKeiyakuJigyoshaJusho", txtKeiyakuJigyoshaJusho);
        this.setOriginalData("txtKeiyakuFromYMD", txtKeiyakuFromYMD);
        this.setOriginalData("txtKeiyakuToYMD", txtKeiyakuToYMD);
        this.setOriginalData("txtKeiyakuShurui", txtKeiyakuShurui);
        this.txtKeiyakuJigyoshaNo = txtKeiyakuJigyoshaNo;
        this.txtKeiyakuJigyoshaName = txtKeiyakuJigyoshaName;
        this.txtKeiyakuJigyoshaJusho = txtKeiyakuJigyoshaJusho;
        this.txtKeiyakuFromYMD = txtKeiyakuFromYMD;
        this.txtKeiyakuToYMD = txtKeiyakuToYMD;
        this.txtKeiyakuShurui = txtKeiyakuShurui;
    }

    public RString getTxtKeiyakuJigyoshaNo() {
        return txtKeiyakuJigyoshaNo;
    }

    public RString getTxtKeiyakuJigyoshaName() {
        return txtKeiyakuJigyoshaName;
    }

    public RString getTxtKeiyakuJigyoshaJusho() {
        return txtKeiyakuJigyoshaJusho;
    }

    public TextBoxDate getTxtKeiyakuFromYMD() {
        return txtKeiyakuFromYMD;
    }

    public TextBoxDate getTxtKeiyakuToYMD() {
        return txtKeiyakuToYMD;
    }

    public RString getTxtKeiyakuShurui() {
        return txtKeiyakuShurui;
    }

    public void setTxtKeiyakuJigyoshaNo(RString txtKeiyakuJigyoshaNo) {
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.txtKeiyakuJigyoshaNo = txtKeiyakuJigyoshaNo;
    }

    public void setTxtKeiyakuJigyoshaName(RString txtKeiyakuJigyoshaName) {
        this.setOriginalData("txtKeiyakuJigyoshaName", txtKeiyakuJigyoshaName);
        this.txtKeiyakuJigyoshaName = txtKeiyakuJigyoshaName;
    }

    public void setTxtKeiyakuJigyoshaJusho(RString txtKeiyakuJigyoshaJusho) {
        this.setOriginalData("txtKeiyakuJigyoshaJusho", txtKeiyakuJigyoshaJusho);
        this.txtKeiyakuJigyoshaJusho = txtKeiyakuJigyoshaJusho;
    }

    public void setTxtKeiyakuFromYMD(TextBoxDate txtKeiyakuFromYMD) {
        this.setOriginalData("txtKeiyakuFromYMD", txtKeiyakuFromYMD);
        this.txtKeiyakuFromYMD = txtKeiyakuFromYMD;
    }

    public void setTxtKeiyakuToYMD(TextBoxDate txtKeiyakuToYMD) {
        this.setOriginalData("txtKeiyakuToYMD", txtKeiyakuToYMD);
        this.txtKeiyakuToYMD = txtKeiyakuToYMD;
    }

    public void setTxtKeiyakuShurui(RString txtKeiyakuShurui) {
        this.setOriginalData("txtKeiyakuShurui", txtKeiyakuShurui);
        this.txtKeiyakuShurui = txtKeiyakuShurui;
    }

    // </editor-fold>
}
