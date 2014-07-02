package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 03 19:17:49 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShokanShikyuKetteiInfoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShokanShikyuKetteiInfoList_Row extends DataRow {

    private RString txtServiceShurui;
    private RString txtTaniKingaku;
    private RString txtShiharaigaku;
    private RString txtSagaku;

    public dgShokanShikyuKetteiInfoList_Row() {
        super();
    }

    public dgShokanShikyuKetteiInfoList_Row(RString txtServiceShurui, RString txtTaniKingaku, RString txtShiharaigaku, RString txtSagaku) {
        super();
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtTaniKingaku", txtTaniKingaku);
        this.setOriginalData("txtShiharaigaku", txtShiharaigaku);
        this.setOriginalData("txtSagaku", txtSagaku);
        this.txtServiceShurui = txtServiceShurui;
        this.txtTaniKingaku = txtTaniKingaku;
        this.txtShiharaigaku = txtShiharaigaku;
        this.txtSagaku = txtSagaku;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public RString getTxtTaniKingaku() {
        return txtTaniKingaku;
    }

    public RString getTxtShiharaigaku() {
        return txtShiharaigaku;
    }

    public RString getTxtSagaku() {
        return txtSagaku;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtTaniKingaku(RString txtTaniKingaku) {
        this.setOriginalData("txtTaniKingaku", txtTaniKingaku);
        this.txtTaniKingaku = txtTaniKingaku;
    }

    public void setTxtShiharaigaku(RString txtShiharaigaku) {
        this.setOriginalData("txtShiharaigaku", txtShiharaigaku);
        this.txtShiharaigaku = txtShiharaigaku;
    }

    public void setTxtSagaku(RString txtSagaku) {
        this.setOriginalData("txtSagaku", txtSagaku);
        this.txtSagaku = txtSagaku;
    }

}