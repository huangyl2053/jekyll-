package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 22 14:27:20 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKanrijoho2_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKanrijoho2_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">

    private RString txtKoumoku;
    private RString txtNaiyo;

    public dgKanrijoho2_Row() {
        super();
        this.txtKoumoku = RString.EMPTY;
        this.txtNaiyo = RString.EMPTY;
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