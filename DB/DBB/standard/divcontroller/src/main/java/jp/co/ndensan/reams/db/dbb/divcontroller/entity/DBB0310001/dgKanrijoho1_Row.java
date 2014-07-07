package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jul 04 19:47:10 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKanrijoho1_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKanrijoho1_Row extends DataRow {

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

}