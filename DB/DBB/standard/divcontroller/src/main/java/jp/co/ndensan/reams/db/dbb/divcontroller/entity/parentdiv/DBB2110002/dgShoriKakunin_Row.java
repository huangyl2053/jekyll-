package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Sep 12 16:15:01 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * dgShoriKakunin_Row のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class dgShoriKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBox txtTsuki;
    private TextBox txtShoriMei;
    private TextBox txtJokyo;
    private TextBox txtShoriNichiji;

    public dgShoriKakunin_Row() {
        super();
        this.txtTsuki = new TextBox();
        this.txtShoriMei = new TextBox();
        this.txtJokyo = new TextBox();
        this.txtShoriNichiji = new TextBox();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
    }

    public dgShoriKakunin_Row(TextBox txtTsuki, TextBox txtShoriMei, TextBox txtJokyo, TextBox txtShoriNichiji) {
        super();
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtTsuki = txtTsuki;
        this.txtShoriMei = txtShoriMei;
        this.txtJokyo = txtJokyo;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public TextBox getTxtTsuki() {
        return txtTsuki;
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

    public void setTxtTsuki(TextBox txtTsuki) {
        this.setOriginalData("txtTsuki", txtTsuki);
        this.txtTsuki = txtTsuki;
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
