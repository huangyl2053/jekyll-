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
 * dgIkenShohoshuTankaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIkenShohoshuTankaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString columnState;
    private TextBoxFlexibleDate kaishiYM;
    private TextBoxFlexibleDate shuryoYM;
    private RString zaitakuShisetsuKubun;
    private RString zaitakuShisetsuKubunCode;
    private RString ikenshoSakuseiKaisuKubun;
    private RString ikenshoSakuseiKaisuKubunCode;
    private TextBoxNum tanka;

    public dgIkenShohoshuTankaIchiran_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.kaishiYM = new TextBoxFlexibleDate();
        this.shuryoYM = new TextBoxFlexibleDate();
        this.zaitakuShisetsuKubun = RString.EMPTY;
        this.zaitakuShisetsuKubunCode = RString.EMPTY;
        this.ikenshoSakuseiKaisuKubun = RString.EMPTY;
        this.ikenshoSakuseiKaisuKubunCode = RString.EMPTY;
        this.tanka = new TextBoxNum();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("zaitakuShisetsuKubun", zaitakuShisetsuKubun);
        this.setOriginalData("zaitakuShisetsuKubunCode", zaitakuShisetsuKubunCode);
        this.setOriginalData("ikenshoSakuseiKaisuKubun", ikenshoSakuseiKaisuKubun);
        this.setOriginalData("ikenshoSakuseiKaisuKubunCode", ikenshoSakuseiKaisuKubunCode);
        this.setOriginalData("tanka", tanka);
    }

    public dgIkenShohoshuTankaIchiran_Row(RString columnState, TextBoxFlexibleDate kaishiYM, TextBoxFlexibleDate shuryoYM, RString zaitakuShisetsuKubun, RString zaitakuShisetsuKubunCode, RString ikenshoSakuseiKaisuKubun, RString ikenshoSakuseiKaisuKubunCode, TextBoxNum tanka) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("kaishiYM", kaishiYM);
        this.setOriginalData("shuryoYM", shuryoYM);
        this.setOriginalData("zaitakuShisetsuKubun", zaitakuShisetsuKubun);
        this.setOriginalData("zaitakuShisetsuKubunCode", zaitakuShisetsuKubunCode);
        this.setOriginalData("ikenshoSakuseiKaisuKubun", ikenshoSakuseiKaisuKubun);
        this.setOriginalData("ikenshoSakuseiKaisuKubunCode", ikenshoSakuseiKaisuKubunCode);
        this.setOriginalData("tanka", tanka);
        this.columnState = columnState;
        this.kaishiYM = kaishiYM;
        this.shuryoYM = shuryoYM;
        this.zaitakuShisetsuKubun = zaitakuShisetsuKubun;
        this.zaitakuShisetsuKubunCode = zaitakuShisetsuKubunCode;
        this.ikenshoSakuseiKaisuKubun = ikenshoSakuseiKaisuKubun;
        this.ikenshoSakuseiKaisuKubunCode = ikenshoSakuseiKaisuKubunCode;
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

    public RString getZaitakuShisetsuKubun() {
        return zaitakuShisetsuKubun;
    }

    public RString getZaitakuShisetsuKubunCode() {
        return zaitakuShisetsuKubunCode;
    }

    public RString getIkenshoSakuseiKaisuKubun() {
        return ikenshoSakuseiKaisuKubun;
    }

    public RString getIkenshoSakuseiKaisuKubunCode() {
        return ikenshoSakuseiKaisuKubunCode;
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

    public void setZaitakuShisetsuKubun(RString zaitakuShisetsuKubun) {
        this.setOriginalData("zaitakuShisetsuKubun", zaitakuShisetsuKubun);
        this.zaitakuShisetsuKubun = zaitakuShisetsuKubun;
    }

    public void setZaitakuShisetsuKubunCode(RString zaitakuShisetsuKubunCode) {
        this.setOriginalData("zaitakuShisetsuKubunCode", zaitakuShisetsuKubunCode);
        this.zaitakuShisetsuKubunCode = zaitakuShisetsuKubunCode;
    }

    public void setIkenshoSakuseiKaisuKubun(RString ikenshoSakuseiKaisuKubun) {
        this.setOriginalData("ikenshoSakuseiKaisuKubun", ikenshoSakuseiKaisuKubun);
        this.ikenshoSakuseiKaisuKubun = ikenshoSakuseiKaisuKubun;
    }

    public void setIkenshoSakuseiKaisuKubunCode(RString ikenshoSakuseiKaisuKubunCode) {
        this.setOriginalData("ikenshoSakuseiKaisuKubunCode", ikenshoSakuseiKaisuKubunCode);
        this.ikenshoSakuseiKaisuKubunCode = ikenshoSakuseiKaisuKubunCode;
    }

    public void setTanka(TextBoxNum tanka) {
        this.setOriginalData("tanka", tanka);
        this.tanka = tanka;
    }

    // </editor-fold>
}
