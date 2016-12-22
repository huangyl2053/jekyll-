package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 22 11:18:26 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgchosainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgchosainIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private TextBoxCode chosainCode;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString chosainSeibetsu;
    private RString chosainTelNo;
    private RString chosaChiku;
    private TextBoxNum waritsukeZumi;
    private RString chosainShikaku;
    private RString hokenshaCode;
    private RString hokenshaName;
    private RString chosaKanoNinzuPerMonth;

    public dgchosainIchiran_Row() {
        super();
        this.chosainCode = new TextBoxCode();
        this.chosainShimei = RString.EMPTY;
        this.chosainKanaShimei = RString.EMPTY;
        this.chosainSeibetsu = RString.EMPTY;
        this.chosainTelNo = RString.EMPTY;
        this.chosaChiku = RString.EMPTY;
        this.waritsukeZumi = new TextBoxNum();
        this.chosainShikaku = RString.EMPTY;
        this.hokenshaCode = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.chosaKanoNinzuPerMonth = RString.EMPTY;
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chosainShimei", chosainShimei);
        this.setOriginalData("chosainKanaShimei", chosainKanaShimei);
        this.setOriginalData("chosainSeibetsu", chosainSeibetsu);
        this.setOriginalData("chosainTelNo", chosainTelNo);
        this.setOriginalData("chosaChiku", chosaChiku);
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
    }

    public dgchosainIchiran_Row(TextBoxCode chosainCode, RString chosainShimei, RString chosainKanaShimei, RString chosainSeibetsu, RString chosainTelNo, RString chosaChiku, TextBoxNum waritsukeZumi, RString chosainShikaku, RString hokenshaCode, RString hokenshaName, RString chosaKanoNinzuPerMonth) {
        super();
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chosainShimei", chosainShimei);
        this.setOriginalData("chosainKanaShimei", chosainKanaShimei);
        this.setOriginalData("chosainSeibetsu", chosainSeibetsu);
        this.setOriginalData("chosainTelNo", chosainTelNo);
        this.setOriginalData("chosaChiku", chosaChiku);
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
        this.chosainCode = chosainCode;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.chosainSeibetsu = chosainSeibetsu;
        this.chosainTelNo = chosainTelNo;
        this.chosaChiku = chosaChiku;
        this.waritsukeZumi = waritsukeZumi;
        this.chosainShikaku = chosainShikaku;
        this.hokenshaCode = hokenshaCode;
        this.hokenshaName = hokenshaName;
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
    }

    public TextBoxCode getChosainCode() {
        return chosainCode;
    }

    public RString getChosainShimei() {
        return chosainShimei;
    }

    public RString getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    public RString getChosainSeibetsu() {
        return chosainSeibetsu;
    }

    public RString getChosainTelNo() {
        return chosainTelNo;
    }

    public RString getChosaChiku() {
        return chosaChiku;
    }

    public TextBoxNum getWaritsukeZumi() {
        return waritsukeZumi;
    }

    public RString getChosainShikaku() {
        return chosainShikaku;
    }

    public RString getHokenshaCode() {
        return hokenshaCode;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public RString getChosaKanoNinzuPerMonth() {
        return chosaKanoNinzuPerMonth;
    }

    public void setChosainCode(TextBoxCode chosainCode) {
        this.setOriginalData("chosainCode", chosainCode);
        this.chosainCode = chosainCode;
    }

    public void setChosainShimei(RString chosainShimei) {
        this.setOriginalData("chosainShimei", chosainShimei);
        this.chosainShimei = chosainShimei;
    }

    public void setChosainKanaShimei(RString chosainKanaShimei) {
        this.setOriginalData("chosainKanaShimei", chosainKanaShimei);
        this.chosainKanaShimei = chosainKanaShimei;
    }

    public void setChosainSeibetsu(RString chosainSeibetsu) {
        this.setOriginalData("chosainSeibetsu", chosainSeibetsu);
        this.chosainSeibetsu = chosainSeibetsu;
    }

    public void setChosainTelNo(RString chosainTelNo) {
        this.setOriginalData("chosainTelNo", chosainTelNo);
        this.chosainTelNo = chosainTelNo;
    }

    public void setChosaChiku(RString chosaChiku) {
        this.setOriginalData("chosaChiku", chosaChiku);
        this.chosaChiku = chosaChiku;
    }

    public void setWaritsukeZumi(TextBoxNum waritsukeZumi) {
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.waritsukeZumi = waritsukeZumi;
    }

    public void setChosainShikaku(RString chosainShikaku) {
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.chosainShikaku = chosainShikaku;
    }

    public void setHokenshaCode(RString hokenshaCode) {
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.hokenshaCode = hokenshaCode;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setChosaKanoNinzuPerMonth(RString chosaKanoNinzuPerMonth) {
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
    }

    // </editor-fold>
}
