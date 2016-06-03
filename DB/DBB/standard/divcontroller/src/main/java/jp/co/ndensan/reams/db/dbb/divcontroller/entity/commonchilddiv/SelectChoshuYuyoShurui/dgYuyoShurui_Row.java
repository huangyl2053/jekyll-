package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.SelectChoshuYuyoShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Apr 01 22:49:59 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgYuyoShurui_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgYuyoShurui_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString naiyo;
    private RString hyojiMongon;

    public dgYuyoShurui_Row() {
        super();
        this.naiyo = RString.EMPTY;
        this.hyojiMongon = RString.EMPTY;
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("hyojiMongon", hyojiMongon);
    }

    public dgYuyoShurui_Row(RString naiyo, RString hyojiMongon) {
        super();
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("hyojiMongon", hyojiMongon);
        this.naiyo = naiyo;
        this.hyojiMongon = hyojiMongon;
    }

    public RString getNaiyo() {
        return naiyo;
    }

    public RString getHyojiMongon() {
        return hyojiMongon;
    }

    public void setNaiyo(RString naiyo) {
        this.setOriginalData("naiyo", naiyo);
        this.naiyo = naiyo;
    }

    public void setHyojiMongon(RString hyojiMongon) {
        this.setOriginalData("hyojiMongon", hyojiMongon);
        this.hyojiMongon = hyojiMongon;
    }

    // </editor-fold>
}
