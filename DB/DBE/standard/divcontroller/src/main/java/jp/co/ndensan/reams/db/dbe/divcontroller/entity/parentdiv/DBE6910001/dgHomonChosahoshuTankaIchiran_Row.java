package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 19 19:40:42 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHomonChosahoshuTankaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHomonChosahoshuTankaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">

    private RString columnState;
    private RString chosaKubun;
    private RString chosaKubunCode;
    private RString homonShubetsu;
    private RString homonShubetsuCode;
    private TextBoxFlexibleDate kaishiYM;
    private TextBoxFlexibleDate shuryoYM;
    private TextBoxNum tanka;

    public dgHomonChosahoshuTankaIchiran_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.chosaKubun = RString.EMPTY;
        this.chosaKubunCode = RString.EMPTY;
        this.homonShubetsu = RString.EMPTY;
        this.homonShubetsuCode = RString.EMPTY;
        this.kaishiYM = new TextBoxFlexibleDate();
        this.shuryoYM = new TextBoxFlexibleDate();
        this.tanka = new TextBoxNum();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("chosaKubun", chosaKubun);
        this.setOriginalData("chosaKubunCode", chosaKubunCode);
        this.setOriginalData("homonShubetsu", homonShubetsu);
        this.setOriginalData("homonShubetsuCode", homonShubetsuCode);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("tanka", tanka);
    }

    public dgHomonChosahoshuTankaIchiran_Row(RString columnState, RString chosaKubun, RString chosaKubunCode, RString homonShubetsu, RString homonShubetsuCode, TextBoxFlexibleDate kaishiYM, TextBoxFlexibleDate shuryoYM, TextBoxNum tanka) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("chosaKubun", chosaKubun);
        this.setOriginalData("chosaKubunCode", chosaKubunCode);
        this.setOriginalData("homonShubetsu", homonShubetsu);
        this.setOriginalData("homonShubetsuCode", homonShubetsuCode);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("tanka", tanka);
        this.columnState = columnState;
        this.chosaKubun = chosaKubun;
        this.chosaKubunCode = chosaKubunCode;
        this.homonShubetsu = homonShubetsu;
        this.homonShubetsuCode = homonShubetsuCode;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.tanka = tanka;
    }

    public RString getColumnState() {
        return columnState;
    }

    public RString getChosaKubun() {
        return chosaKubun;
    }

    public RString getChosaKubunCode() {
        return chosaKubunCode;
    }

    public RString getHomonShubetsu() {
        return homonShubetsu;
    }

    public RString getHomonShubetsuCode() {
        return homonShubetsuCode;
    }

    public TextBoxFlexibleDate getKaishiYM() {
        return kaishiYM;
    }

    public TextBoxFlexibleDate getShuryoYM() {
        return shuryoYM;
    }

    public TextBoxNum getTanka() {
        return tanka;
    }

    public void setColumnState(RString columnState) {
        this.setOriginalData("columnState", columnState);
        this.columnState = columnState;
    }

    public void setChosaKubun(RString chosaKubun) {
        this.setOriginalData("chosaKubun", chosaKubun);
        this.chosaKubun = chosaKubun;
    }

    public void setChosaKubunCode(RString chosaKubunCode) {
        this.setOriginalData("chosaKubunCode", chosaKubunCode);
        this.chosaKubunCode = chosaKubunCode;
    }

    public void setHomonShubetsu(RString homonShubetsu) {
        this.setOriginalData("homonShubetsu", homonShubetsu);
        this.homonShubetsu = homonShubetsu;
    }

    public void setHomonShubetsuCode(RString homonShubetsuCode) {
        this.setOriginalData("homonShubetsuCode", homonShubetsuCode);
        this.homonShubetsuCode = homonShubetsuCode;
    }

    public void setKaishiYM(TextBoxFlexibleDate kaishiYM) {
        this.setOriginalData("kaishiYM", kaishiYM);
        this.kaishiYM = kaishiYM;
    }

    public void setShuryoYM(TextBoxFlexibleDate shuryoYM) {
        this.setOriginalData("shuryoYM", shuryoYM);
        this.shuryoYM = shuryoYM;
    }

    public void setTanka(TextBoxNum tanka) {
        this.setOriginalData("tanka", tanka);
        this.tanka = tanka;
    }

    // </editor-fold>
}
