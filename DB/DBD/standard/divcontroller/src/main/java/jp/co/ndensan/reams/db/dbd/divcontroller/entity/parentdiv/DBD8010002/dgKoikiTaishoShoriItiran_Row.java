package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Aug 15 15:30:40 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKoikiTaishoShoriItiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoikiTaishoShoriItiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private Boolean txtTorikomi;
    private RString txtShichoson;

    public dgKoikiTaishoShoriItiran_Row() {
        super();
        this.txtTorikomi = false;
        this.txtShichoson = RString.EMPTY;
        this.setOriginalData("txtTorikomi", txtTorikomi);
        this.setOriginalData("txtShichoson", txtShichoson);
    }

    public dgKoikiTaishoShoriItiran_Row(Boolean txtTorikomi, RString txtShichoson) {
        super();
        this.setOriginalData("txtTorikomi", txtTorikomi);
        this.setOriginalData("txtShichoson", txtShichoson);
        this.txtTorikomi = txtTorikomi;
        this.txtShichoson = txtShichoson;
    }

    public Boolean getTxtTorikomi() {
        return txtTorikomi;
    }

    public RString getTxtShichoson() {
        return txtShichoson;
    }

    public void setTxtTorikomi(Boolean txtTorikomi) {
        this.setOriginalData("txtTorikomi", txtTorikomi);
        this.txtTorikomi = txtTorikomi;
    }

    public void setTxtShichoson(RString txtShichoson) {
        this.setOriginalData("txtShichoson", txtShichoson);
        this.txtShichoson = txtShichoson;
    }

    // </editor-fold>
}
