package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 22 15:02:11 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKanrijoho1_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKanrijoho1_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">

    private RString txtHokenryoDankai;
    private RString txtHokenryoritsu;

    public dgKanrijoho1_Row() {
        super();
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtHokenryoritsu = RString.EMPTY;
    }

    public dgKanrijoho1_Row(RString txtHokenryoDankai, RString txtHokenryoritsu) {
        super();
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoritsu", txtHokenryoritsu);
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtHokenryoritsu = txtHokenryoritsu;
    }

    public RString getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    public RString getTxtHokenryoritsu() {
        return txtHokenryoritsu;
    }

    public void setTxtHokenryoDankai(RString txtHokenryoDankai) {
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    public void setTxtHokenryoritsu(RString txtHokenryoritsu) {
        this.setOriginalData("txtHokenryoritsu", txtHokenryoritsu);
        this.txtHokenryoritsu = txtHokenryoritsu;
    }

    // </editor-fold>
}