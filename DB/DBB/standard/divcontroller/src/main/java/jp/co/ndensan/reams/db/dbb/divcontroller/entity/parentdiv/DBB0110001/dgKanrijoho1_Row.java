package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 17:36:46 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKanrijoho1_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKanrijoho1_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString txtHokenryoDankai;
    private TextBoxNum txtHokenryoritsu;

    public dgKanrijoho1_Row() {
        super();
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtHokenryoritsu = new TextBoxNum();
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoritsu", txtHokenryoritsu);
    }

    public dgKanrijoho1_Row(RString txtHokenryoDankai, TextBoxNum txtHokenryoritsu) {
        super();
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoritsu", txtHokenryoritsu);
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtHokenryoritsu = txtHokenryoritsu;
    }

    public RString getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    public TextBoxNum getTxtHokenryoritsu() {
        return txtHokenryoritsu;
    }

    public void setTxtHokenryoDankai(RString txtHokenryoDankai) {
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    public void setTxtHokenryoritsu(TextBoxNum txtHokenryoritsu) {
        this.setOriginalData("txtHokenryoritsu", txtHokenryoritsu);
        this.txtHokenryoritsu = txtHokenryoritsu;
    }

    // </editor-fold>
}
