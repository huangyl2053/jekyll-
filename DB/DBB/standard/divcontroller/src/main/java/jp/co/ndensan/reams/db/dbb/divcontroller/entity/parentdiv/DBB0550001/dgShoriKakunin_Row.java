package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 26 10:59:03 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * dgShoriKakunin_Row のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class dgShoriKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private TextBox txtShoriMei;
    private TextBox txtJokyo;
    private TextBox txtShoriNichiji;

    public dgShoriKakunin_Row() {
        super();
        this.txtShoriMei = new TextBox();
        this.txtJokyo = new TextBox();
        this.txtShoriNichiji = new TextBox();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
    }

    public dgShoriKakunin_Row(TextBox txtShoriMei, TextBox txtJokyo, TextBox txtShoriNichiji) {
        super();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriMei = txtShoriMei;
        this.txtJokyo = txtJokyo;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public TextBox getTxtShoriMei() {
        return txtShoriMei;
    }

    public TextBox getTxtJokyo() {
        return txtJokyo;
    }

    public TextBox getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public void setTxtShoriMei(TextBox txtShoriMei) {
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.txtShoriMei = txtShoriMei;
    }

    public void setTxtJokyo(TextBox txtJokyo) {
        this.setOriginalData("txtJokyo", txtJokyo);
        this.txtJokyo = txtJokyo;
    }

    public void setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

    // </editor-fold>
}
