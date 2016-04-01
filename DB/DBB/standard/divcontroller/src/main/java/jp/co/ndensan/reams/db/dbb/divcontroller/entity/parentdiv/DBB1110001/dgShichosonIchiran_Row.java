package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Mar 31 10:51:14 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgShichosonIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShichosonIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private TextBox txtShichosonCode;
    private TextBox txtShichosonName;
    private TextBoxDate txtShoriStYMD;
    private TextBoxTime txtShoriStTime;
    private TextBoxDate txtShoriEdYMD;
    private TextBoxTime txtShoriEdTime;

    public dgShichosonIchiran_Row() {
        super();
        this.txtShichosonCode = new TextBox();
        this.txtShichosonName = new TextBox();
        this.txtShoriStYMD = new TextBoxDate();
        this.txtShoriStTime = new TextBoxTime();
        this.txtShoriEdYMD = new TextBoxDate();
        this.txtShoriEdTime = new TextBoxTime();
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtShichosonName", txtShichosonName);
        this.setOriginalData("txtShoriStYMD", txtShoriStYMD);
        this.setOriginalData("txtShoriStTime", txtShoriStTime);
        this.setOriginalData("txtShoriEdYMD", txtShoriEdYMD);
        this.setOriginalData("txtShoriEdTime", txtShoriEdTime);
    }

    public dgShichosonIchiran_Row(TextBox txtShichosonCode, TextBox txtShichosonName, TextBoxDate txtShoriStYMD, TextBoxTime txtShoriStTime, TextBoxDate txtShoriEdYMD, TextBoxTime txtShoriEdTime) {
        super();
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtShichosonName", txtShichosonName);
        this.setOriginalData("txtShoriStYMD", txtShoriStYMD);
        this.setOriginalData("txtShoriStTime", txtShoriStTime);
        this.setOriginalData("txtShoriEdYMD", txtShoriEdYMD);
        this.setOriginalData("txtShoriEdTime", txtShoriEdTime);
        this.txtShichosonCode = txtShichosonCode;
        this.txtShichosonName = txtShichosonName;
        this.txtShoriStYMD = txtShoriStYMD;
        this.txtShoriStTime = txtShoriStTime;
        this.txtShoriEdYMD = txtShoriEdYMD;
        this.txtShoriEdTime = txtShoriEdTime;
    }

    public TextBox getTxtShichosonCode() {
        return txtShichosonCode;
    }

    public TextBox getTxtShichosonName() {
        return txtShichosonName;
    }

    public TextBoxDate getTxtShoriStYMD() {
        return txtShoriStYMD;
    }

    public TextBoxTime getTxtShoriStTime() {
        return txtShoriStTime;
    }

    public TextBoxDate getTxtShoriEdYMD() {
        return txtShoriEdYMD;
    }

    public TextBoxTime getTxtShoriEdTime() {
        return txtShoriEdTime;
    }

    public void setTxtShichosonCode(TextBox txtShichosonCode) {
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.txtShichosonCode = txtShichosonCode;
    }

    public void setTxtShichosonName(TextBox txtShichosonName) {
        this.setOriginalData("txtShichosonName", txtShichosonName);
        this.txtShichosonName = txtShichosonName;
    }

    public void setTxtShoriStYMD(TextBoxDate txtShoriStYMD) {
        this.setOriginalData("txtShoriStYMD", txtShoriStYMD);
        this.txtShoriStYMD = txtShoriStYMD;
    }

    public void setTxtShoriStTime(TextBoxTime txtShoriStTime) {
        this.setOriginalData("txtShoriStTime", txtShoriStTime);
        this.txtShoriStTime = txtShoriStTime;
    }

    public void setTxtShoriEdYMD(TextBoxDate txtShoriEdYMD) {
        this.setOriginalData("txtShoriEdYMD", txtShoriEdYMD);
        this.txtShoriEdYMD = txtShoriEdYMD;
    }

    public void setTxtShoriEdTime(TextBoxTime txtShoriEdTime) {
        this.setOriginalData("txtShoriEdTime", txtShoriEdTime);
        this.txtShoriEdTime = txtShoriEdTime;
    }

    // </editor-fold>
}
