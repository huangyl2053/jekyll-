package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 02 16:22:04 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgKomokuNaiyo_Row のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class dgKomokuNaiyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString komoku;
    private RString naiyo;

    public dgKomokuNaiyo_Row() {
        super();
        this.komoku = RString.EMPTY;
        this.naiyo = RString.EMPTY;
        this.setOriginalData("komoku", komoku);
        this.setOriginalData("naiyo", naiyo);
    }

    public dgKomokuNaiyo_Row(RString komoku, RString naiyo) {
        super();
        this.setOriginalData("komoku", komoku);
        this.setOriginalData("naiyo", naiyo);
        this.komoku = komoku;
        this.naiyo = naiyo;
    }

    public RString getKomoku() {
        return komoku;
    }

    public RString getNaiyo() {
        return naiyo;
    }

    public void setKomoku(RString komoku) {
        this.setOriginalData("komoku", komoku);
        this.komoku = komoku;
    }

    public void setNaiyo(RString naiyo) {
        this.setOriginalData("naiyo", naiyo);
        this.naiyo = naiyo;
    }

    // </editor-fold>
}
