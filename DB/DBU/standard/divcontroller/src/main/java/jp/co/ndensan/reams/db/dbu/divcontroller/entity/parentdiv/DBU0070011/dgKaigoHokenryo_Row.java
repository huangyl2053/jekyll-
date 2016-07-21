package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 20 18:21:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKaigoHokenryo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKaigoHokenryo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString dankaiKubun;
    private RString dankai;
    private RString tokureiHyoki;
    private RString dankaiAndTokurei;
    private TextBoxNum hokenryo;

    public dgKaigoHokenryo_Row() {
        super();
        this.dankaiKubun = RString.EMPTY;
        this.dankai = RString.EMPTY;
        this.tokureiHyoki = RString.EMPTY;
        this.dankaiAndTokurei = RString.EMPTY;
        this.hokenryo = new TextBoxNum();
        this.setOriginalData("dankaiKubun", dankaiKubun);
        this.setOriginalData("dankai", dankai);
        this.setOriginalData("tokureiHyoki", tokureiHyoki);
        this.setOriginalData("dankaiAndTokurei", dankaiAndTokurei);
        this.setOriginalData("hokenryo", hokenryo);
    }

    public dgKaigoHokenryo_Row(RString dankaiKubun, RString dankai, RString tokureiHyoki, RString dankaiAndTokurei, TextBoxNum hokenryo) {
        super();
        this.setOriginalData("dankaiKubun", dankaiKubun);
        this.setOriginalData("dankai", dankai);
        this.setOriginalData("tokureiHyoki", tokureiHyoki);
        this.setOriginalData("dankaiAndTokurei", dankaiAndTokurei);
        this.setOriginalData("hokenryo", hokenryo);
        this.dankaiKubun = dankaiKubun;
        this.dankai = dankai;
        this.tokureiHyoki = tokureiHyoki;
        this.dankaiAndTokurei = dankaiAndTokurei;
        this.hokenryo = hokenryo;
    }

    public RString getDankaiKubun() {
        return dankaiKubun;
    }

    public RString getDankai() {
        return dankai;
    }

    public RString getTokureiHyoki() {
        return tokureiHyoki;
    }

    public RString getDankaiAndTokurei() {
        return dankaiAndTokurei;
    }

    public TextBoxNum getHokenryo() {
        return hokenryo;
    }

    public void setDankaiKubun(RString dankaiKubun) {
        this.setOriginalData("dankaiKubun", dankaiKubun);
        this.dankaiKubun = dankaiKubun;
    }

    public void setDankai(RString dankai) {
        this.setOriginalData("dankai", dankai);
        this.dankai = dankai;
    }

    public void setTokureiHyoki(RString tokureiHyoki) {
        this.setOriginalData("tokureiHyoki", tokureiHyoki);
        this.tokureiHyoki = tokureiHyoki;
    }

    public void setDankaiAndTokurei(RString dankaiAndTokurei) {
        this.setOriginalData("dankaiAndTokurei", dankaiAndTokurei);
        this.dankaiAndTokurei = dankaiAndTokurei;
    }

    public void setHokenryo(TextBoxNum hokenryo) {
        this.setOriginalData("hokenryo", hokenryo);
        this.hokenryo = hokenryo;
    }

    // </editor-fold>
}
