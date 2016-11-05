package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Nov 05 14:43:41 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHokenryoDankai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHokenryoDankai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private RString hokenryoDankai;
    private TextBoxNum hokenryoRitsu;

    public dgHokenryoDankai_Row() {
        super();
        this.hokenryoDankai = RString.EMPTY;
        this.hokenryoRitsu = new TextBoxNum();
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
    }

    public dgHokenryoDankai_Row(RString hokenryoDankai, TextBoxNum hokenryoRitsu) {
        super();
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
        this.hokenryoDankai = hokenryoDankai;
        this.hokenryoRitsu = hokenryoRitsu;
    }

    public RString getHokenryoDankai() {
        return hokenryoDankai;
    }

    public TextBoxNum getHokenryoRitsu() {
        return hokenryoRitsu;
    }

    public void setHokenryoDankai(RString hokenryoDankai) {
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.hokenryoDankai = hokenryoDankai;
    }

    public void setHokenryoRitsu(TextBoxNum hokenryoRitsu) {
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
        this.hokenryoRitsu = hokenryoRitsu;
    }

    // </editor-fold>
}
