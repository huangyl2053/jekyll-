package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Feb 16 19:40:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgDetail_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">

    private RString txtShikibetsuCode;
    private RString txtShikibetsuKomoku;

    public dgDetail_Row() {
        super();
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtShikibetsuKomoku = RString.EMPTY;
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtShikibetsuKomoku", txtShikibetsuKomoku);
    }

    public dgDetail_Row(RString txtShikibetsuCode, RString txtShikibetsuKomoku) {
        super();
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtShikibetsuKomoku", txtShikibetsuKomoku);
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtShikibetsuKomoku = txtShikibetsuKomoku;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public RString getTxtShikibetsuKomoku() {
        return txtShikibetsuKomoku;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtShikibetsuKomoku(RString txtShikibetsuKomoku) {
        this.setOriginalData("txtShikibetsuKomoku", txtShikibetsuKomoku);
        this.txtShikibetsuKomoku = txtShikibetsuKomoku;
    }

    // </editor-fold>
}
