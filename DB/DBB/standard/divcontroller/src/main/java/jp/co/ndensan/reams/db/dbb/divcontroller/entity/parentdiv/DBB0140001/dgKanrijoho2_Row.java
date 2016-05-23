package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 09 13:44:16 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgKanrijoho2_Row のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class dgKanrijoho2_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString txtKoumoku;
    private RString txtNaiyo;

    public dgKanrijoho2_Row() {
        super();
        this.txtKoumoku = RString.EMPTY;
        this.txtNaiyo = RString.EMPTY;
        this.setOriginalData("txtKoumoku", txtKoumoku);
        this.setOriginalData("txtNaiyo", txtNaiyo);
    }

    public dgKanrijoho2_Row(RString txtKoumoku, RString txtNaiyo) {
        super();
        this.setOriginalData("txtKoumoku", txtKoumoku);
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.txtKoumoku = txtKoumoku;
        this.txtNaiyo = txtNaiyo;
    }

    public RString getTxtKoumoku() {
        return txtKoumoku;
    }

    public RString getTxtNaiyo() {
        return txtNaiyo;
    }

    public void setTxtKoumoku(RString txtKoumoku) {
        this.setOriginalData("txtKoumoku", txtKoumoku);
        this.txtKoumoku = txtKoumoku;
    }

    public void setTxtNaiyo(RString txtNaiyo) {
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.txtNaiyo = txtNaiyo;
    }

    // </editor-fold>
}
