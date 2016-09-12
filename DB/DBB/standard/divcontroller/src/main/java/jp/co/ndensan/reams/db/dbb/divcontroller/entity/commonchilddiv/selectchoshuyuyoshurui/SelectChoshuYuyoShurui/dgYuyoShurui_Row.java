package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selectchoshuyuyoshurui.SelectChoshuYuyoShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 30 16:48:43 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgYuyoShurui_Row のクラスファイル
 *
 * @reamsid_L DBB-1680-030 xupeng
 */
public class dgYuyoShurui_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString naiyo;
    private RString hyojiMongon;
    private RString code;

    public dgYuyoShurui_Row() {
        super();
        this.naiyo = RString.EMPTY;
        this.hyojiMongon = RString.EMPTY;
        this.code = RString.EMPTY;
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("hyojiMongon", hyojiMongon);
        this.setOriginalData("code", code);
    }

    public dgYuyoShurui_Row(RString naiyo, RString hyojiMongon, RString code) {
        super();
        this.setOriginalData("naiyo", naiyo);
        this.setOriginalData("hyojiMongon", hyojiMongon);
        this.setOriginalData("code", code);
        this.naiyo = naiyo;
        this.hyojiMongon = hyojiMongon;
        this.code = code;
    }

    public RString getNaiyo() {
        return naiyo;
    }

    public RString getHyojiMongon() {
        return hyojiMongon;
    }

    public RString getCode() {
        return code;
    }

    public void setNaiyo(RString naiyo) {
        this.setOriginalData("naiyo", naiyo);
        this.naiyo = naiyo;
    }

    public void setHyojiMongon(RString hyojiMongon) {
        this.setOriginalData("hyojiMongon", hyojiMongon);
        this.hyojiMongon = hyojiMongon;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    // </editor-fold>
}
