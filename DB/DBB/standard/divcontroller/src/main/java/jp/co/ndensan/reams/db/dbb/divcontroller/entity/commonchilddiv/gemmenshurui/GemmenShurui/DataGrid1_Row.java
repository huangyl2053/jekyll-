package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 11 21:46:52 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * DataGrid1_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class DataGrid1_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString txtNaiyo;
    private RString txtHyojiMongon;

    public DataGrid1_Row() {
        super();
        this.txtNaiyo = RString.EMPTY;
        this.txtHyojiMongon = RString.EMPTY;
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
    }

    public DataGrid1_Row(RString txtNaiyo, RString txtHyojiMongon) {
        super();
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
        this.txtNaiyo = txtNaiyo;
        this.txtHyojiMongon = txtHyojiMongon;
    }

    public RString getTxtNaiyo() {
        return txtNaiyo;
    }

    public RString getTxtHyojiMongon() {
        return txtHyojiMongon;
    }

    public void setTxtNaiyo(RString txtNaiyo) {
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.txtNaiyo = txtNaiyo;
    }

    public void setTxtHyojiMongon(RString txtHyojiMongon) {
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
        this.txtHyojiMongon = txtHyojiMongon;
    }

    // </editor-fold>
}
