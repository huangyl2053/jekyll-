package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jul 24 15:40:52 JST 2015
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgSeikatsuHogoRireki_Row のクラスファイル
 *
 * @reamsid_L DBA-0520-030 wangkun
 */
public class dgSeikatsuHogoRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">

    private TextBoxFlexibleDate kaishiDate;
    private TextBoxFlexibleDate shuryoDate;
    private RString seihoShubetsuKey;
    private RString seihoShubetsu;
    private RString jukyushaNo;

    public dgSeikatsuHogoRireki_Row() {
        super();
        this.kaishiDate = new TextBoxFlexibleDate();
        this.shuryoDate = new TextBoxFlexibleDate();
        this.seihoShubetsuKey = RString.EMPTY;
        this.seihoShubetsu = RString.EMPTY;
        this.jukyushaNo = RString.EMPTY;
    }

    public dgSeikatsuHogoRireki_Row(TextBoxFlexibleDate kaishiDate, TextBoxFlexibleDate shuryoDate, RString seihoShubetsuKey, RString seihoShubetsu, RString jukyushaNo) {
        super();
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("seihoShubetsuKey", seihoShubetsuKey);
        this.setOriginalData("seihoShubetsu", seihoShubetsu);
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.kaishiDate = kaishiDate;
        this.shuryoDate = shuryoDate;
        this.seihoShubetsuKey = seihoShubetsuKey;
        this.seihoShubetsu = seihoShubetsu;
        this.jukyushaNo = jukyushaNo;
    }

    public TextBoxFlexibleDate getKaishiDate() {
        return kaishiDate;
    }

    public TextBoxFlexibleDate getShuryoDate() {
        return shuryoDate;
    }

    public RString getSeihoShubetsuKey() {
        return seihoShubetsuKey;
    }

    public RString getSeihoShubetsu() {
        return seihoShubetsu;
    }

    public RString getJukyushaNo() {
        return jukyushaNo;
    }

    public void setKaishiDate(TextBoxFlexibleDate kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setShuryoDate(TextBoxFlexibleDate shuryoDate) {
        this.setOriginalData("shuryoDate", shuryoDate);
        this.shuryoDate = shuryoDate;
    }

    public void setSeihoShubetsuKey(RString seihoShubetsuKey) {
        this.setOriginalData("seihoShubetsuKey", seihoShubetsuKey);
        this.seihoShubetsuKey = seihoShubetsuKey;
    }

    public void setSeihoShubetsu(RString seihoShubetsu) {
        this.setOriginalData("seihoShubetsu", seihoShubetsu);
        this.seihoShubetsu = seihoShubetsu;
    }

    public void setJukyushaNo(RString jukyushaNo) {
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.jukyushaNo = jukyushaNo;
    }

    // </editor-fold>
}
