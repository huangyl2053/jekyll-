package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0240011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Sep 30 16:28:08 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgIdoReanrakuhyoEraTeisei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIdoReanrakuhyoEraTeisei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxDate txtIdobi;
    private RString txtHihoBango;
    private RString txtHihokenshaShimei;
    private RString txtSofuKubun;
    private RString txtKomoku;

    public dgIdoReanrakuhyoEraTeisei_Row() {
        super();
        this.txtIdobi = new TextBoxDate();
        this.txtHihoBango = RString.EMPTY;
        this.txtHihokenshaShimei = RString.EMPTY;
        this.txtSofuKubun = RString.EMPTY;
        this.txtKomoku = RString.EMPTY;
        this.setOriginalData("txtIdobi", txtIdobi);
        this.setOriginalData("txtHihoBango", txtHihoBango);
        this.setOriginalData("txtHihokenshaShimei", txtHihokenshaShimei);
        this.setOriginalData("txtSofuKubun", txtSofuKubun);
        this.setOriginalData("txtKomoku", txtKomoku);
    }

    public dgIdoReanrakuhyoEraTeisei_Row(TextBoxDate txtIdobi, RString txtHihoBango, RString txtHihokenshaShimei, RString txtSofuKubun, RString txtKomoku) {
        super();
        this.setOriginalData("txtIdobi", txtIdobi);
        this.setOriginalData("txtHihoBango", txtHihoBango);
        this.setOriginalData("txtHihokenshaShimei", txtHihokenshaShimei);
        this.setOriginalData("txtSofuKubun", txtSofuKubun);
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtIdobi = txtIdobi;
        this.txtHihoBango = txtHihoBango;
        this.txtHihokenshaShimei = txtHihokenshaShimei;
        this.txtSofuKubun = txtSofuKubun;
        this.txtKomoku = txtKomoku;
    }

    public TextBoxDate getTxtIdobi() {
        return txtIdobi;
    }

    public RString getTxtHihoBango() {
        return txtHihoBango;
    }

    public RString getTxtHihokenshaShimei() {
        return txtHihokenshaShimei;
    }

    public RString getTxtSofuKubun() {
        return txtSofuKubun;
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

    public void setTxtHihokenshaShimei(RString txtHihokenshaShimei) {
        this.setOriginalData("txtHihokenshaShimei", txtHihokenshaShimei);
        this.txtHihokenshaShimei = txtHihokenshaShimei;
    }

    public void setTxtSofuKubun(RString txtSofuKubun) {
        this.setOriginalData("txtSofuKubun", txtSofuKubun);
        this.txtSofuKubun = txtSofuKubun;
    }

    public void setTxtKomoku(RString txtKomoku) {
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtKomoku = txtKomoku;
    }

    // </editor-fold>
}
