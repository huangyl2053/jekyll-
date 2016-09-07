package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 02 10:49:13 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgChosainhoshuTankaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainhoshuTankaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString columnState;
    private TextBoxFlexibleDate kaishiYM;
    private TextBoxFlexibleDate shuryoYM;
    private RString kaigoNinteiShinsaIinShubetsu;
    private RString kaigoNinteiShinsaIinShubetsuCode;
    private TextBoxNum tanka;

    public dgChosainhoshuTankaIchiran_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.kaishiYM = new TextBoxFlexibleDate();
        this.shuryoYM = new TextBoxFlexibleDate();
        this.kaigoNinteiShinsaIinShubetsu = RString.EMPTY;
        this.kaigoNinteiShinsaIinShubetsuCode = RString.EMPTY;
        this.tanka = new TextBoxNum();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("kaigoNinteiShinsaIinShubetsu", kaigoNinteiShinsaIinShubetsu);
        this.setOriginalData("kaigoNinteiShinsaIinShubetsuCode", kaigoNinteiShinsaIinShubetsuCode);
        this.setOriginalData("tanka", tanka);
    }

    public dgChosainhoshuTankaIchiran_Row(RString columnState, TextBoxFlexibleDate kaishiYM, TextBoxFlexibleDate shuryoYM, RString kaigoNinteiShinsaIinShubetsu, RString kaigoNinteiShinsaIinShubetsuCode, TextBoxNum tanka) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("kaigoNinteiShinsaIinShubetsu", kaigoNinteiShinsaIinShubetsu);
        this.setOriginalData("kaigoNinteiShinsaIinShubetsuCode", kaigoNinteiShinsaIinShubetsuCode);
        this.setOriginalData("tanka", tanka);
        this.columnState = columnState;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.kaigoNinteiShinsaIinShubetsu = kaigoNinteiShinsaIinShubetsu;
        this.kaigoNinteiShinsaIinShubetsuCode = kaigoNinteiShinsaIinShubetsuCode;
        this.tanka = tanka;
    }

    public RString getColumnState() {
        return columnState;
    }

    public TextBoxFlexibleDate getKaishiYM() {
        return kaishiYM;
    }

    public TextBoxFlexibleDate getShuryoYM() {
        return shuryoYM;
    }

    public RString getKaigoNinteiShinsaIinShubetsu() {
        return kaigoNinteiShinsaIinShubetsu;
    }

    public RString getKaigoNinteiShinsaIinShubetsuCode() {
        return kaigoNinteiShinsaIinShubetsuCode;
    }

    public TextBoxNum getTanka() {
        return tanka;
    }

    public void setColumnState(RString columnState) {
        this.setOriginalData("columnState", columnState);
        this.columnState = columnState;
    }

    public void setKaishiYM(TextBoxFlexibleDate kaishiYM) {
        this.setOriginalData("kaishiYM", kaishiYM);
        this.kaishiYM = kaishiYM;
    }

    public void setShuryoYM(TextBoxFlexibleDate shuryoYM) {
        this.setOriginalData("shuryoYM", shuryoYM);
        this.shuryoYM = shuryoYM;
    }

    public void setKaigoNinteiShinsaIinShubetsu(RString kaigoNinteiShinsaIinShubetsu) {
        this.setOriginalData("kaigoNinteiShinsaIinShubetsu", kaigoNinteiShinsaIinShubetsu);
        this.kaigoNinteiShinsaIinShubetsu = kaigoNinteiShinsaIinShubetsu;
    }

    public void setKaigoNinteiShinsaIinShubetsuCode(RString kaigoNinteiShinsaIinShubetsuCode) {
        this.setOriginalData("kaigoNinteiShinsaIinShubetsuCode", kaigoNinteiShinsaIinShubetsuCode);
        this.kaigoNinteiShinsaIinShubetsuCode = kaigoNinteiShinsaIinShubetsuCode;
    }

    public void setTanka(TextBoxNum tanka) {
        this.setOriginalData("tanka", tanka);
        this.tanka = tanka;
    }

    // </editor-fold>
}
