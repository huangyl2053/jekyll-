package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 30 18:48:07 JST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private TextBox txtShoriMei;
    private TextBox txtJokyo;
    private TextBox txtShoriNichiji;

    public dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row() {
        super();
        this.txtShoriMei = new TextBox();
        this.txtJokyo = new TextBox();
        this.txtShoriNichiji = new TextBox();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
    }

    public dgTokuchoTaishoshaDoteiShoriKakuninTanitsu_Row(TextBox txtShoriMei, TextBox txtJokyo, TextBox txtShoriNichiji) {
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
