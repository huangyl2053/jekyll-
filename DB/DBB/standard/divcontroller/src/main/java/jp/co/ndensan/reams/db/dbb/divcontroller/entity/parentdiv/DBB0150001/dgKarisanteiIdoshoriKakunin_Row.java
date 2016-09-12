package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 02 16:22:04 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * dgKarisanteiIdoshoriKakunin_Row のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class dgKarisanteiIdoshoriKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private TextBox txtShoriMei;
    private TextBox txtJokyo;
    private TextBox txtShoriNichiji;

    public dgKarisanteiIdoshoriKakunin_Row() {
        super();
        this.txtShoriMei = new TextBox();
        this.txtJokyo = new TextBox();
        this.txtShoriNichiji = new TextBox();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
    }

    public dgKarisanteiIdoshoriKakunin_Row(TextBox txtShoriMei, TextBox txtJokyo, TextBox txtShoriNichiji) {
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
