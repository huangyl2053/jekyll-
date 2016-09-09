package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 16 16:37:50 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgIdoReanrakuhyoEraTeisei_Row のクラスファイル
 *
 * @reamsid_L DBC-2720-010 liuxiaoyu
 */
public class dgIdoReanrakuhyoEraTeisei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxDate txtIdobi;
    private RString txtHihoBango;
    private RString txtKanaShimei;
    private RString txtKomoku;

    public dgIdoReanrakuhyoEraTeisei_Row() {
        super();
        this.txtIdobi = new TextBoxDate();
        this.txtHihoBango = RString.EMPTY;
        this.txtKanaShimei = RString.EMPTY;
        this.txtKomoku = RString.EMPTY;
        this.setOriginalData("txtIdobi", txtIdobi);
        this.setOriginalData("txtHihoBango", txtHihoBango);
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.setOriginalData("txtKomoku", txtKomoku);
    }

    public dgIdoReanrakuhyoEraTeisei_Row(TextBoxDate txtIdobi, RString txtHihoBango, RString txtKanaShimei, RString txtKomoku) {
        super();
        this.setOriginalData("txtIdobi", txtIdobi);
        this.setOriginalData("txtHihoBango", txtHihoBango);
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtIdobi = txtIdobi;
        this.txtHihoBango = txtHihoBango;
        this.txtKanaShimei = txtKanaShimei;
        this.txtKomoku = txtKomoku;
    }

    public TextBoxDate getTxtIdobi() {
        return txtIdobi;
    }

    public RString getTxtHihoBango() {
        return txtHihoBango;
    }

    public RString getTxtKanaShimei() {
        return txtKanaShimei;
    }

    public RString getTxtKomoku() {
        return txtKomoku;
    }

    public void setTxtIdobi(TextBoxDate txtIdobi) {
        this.setOriginalData("txtIdobi", txtIdobi);
        this.txtIdobi = txtIdobi;
    }

    public void setTxtHihoBango(RString txtHihoBango) {
        this.setOriginalData("txtHihoBango", txtHihoBango);
        this.txtHihoBango = txtHihoBango;
    }

    public void setTxtKanaShimei(RString txtKanaShimei) {
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.txtKanaShimei = txtKanaShimei;
    }

    public void setTxtKomoku(RString txtKomoku) {
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtKomoku = txtKomoku;
    }

    // </editor-fold>
}
