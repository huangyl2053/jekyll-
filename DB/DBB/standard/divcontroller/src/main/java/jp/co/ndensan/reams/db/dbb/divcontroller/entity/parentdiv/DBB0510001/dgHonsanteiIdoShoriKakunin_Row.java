package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jul 04 19:12:40 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgHonsanteiIdoShoriKakunin_Row のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class dgHonsanteiIdoShoriKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtShoriMei;
    private RString txtJokyo;
    private RString txtShoriNichiji;

    public dgHonsanteiIdoShoriKakunin_Row() {
        super();
        this.txtShoriMei = RString.EMPTY;
        this.txtJokyo = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
    }

    public dgHonsanteiIdoShoriKakunin_Row(RString txtShoriMei, RString txtJokyo, RString txtShoriNichiji) {
        super();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriMei = txtShoriMei;
        this.txtJokyo = txtJokyo;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public RString getTxtShoriMei() {
        return txtShoriMei;
    }

    public RString getTxtJokyo() {
        return txtJokyo;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public void setTxtShoriMei(RString txtShoriMei) {
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.txtShoriMei = txtShoriMei;
    }

    public void setTxtJokyo(RString txtJokyo) {
        this.setOriginalData("txtJokyo", txtJokyo);
        this.txtJokyo = txtJokyo;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

    // </editor-fold>
}
