package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Nov 19 13:20:53 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgFutanGendogakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFutanGendogakuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private RString gemmenGengakuShurui;
    private TextBoxFlexibleDate tekiyoKaishiYMD;
    private TextBoxFlexibleDate tekiyoShuryoYMD;
    private TextBoxNum shokuhiFutanGendogaku;
    private TextBoxNum unitKoshitsu;
    private TextBoxNum unitJunkoshitsu;
    private TextBoxNum juraiKoshitsuTokuyo;
    private TextBoxNum juraiKoshitsuRokenRyoyo;
    private TextBoxNum tashoshitsu;

    public dgFutanGendogakuList_Row() {
        super();
        this.gemmenGengakuShurui = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxFlexibleDate();
        this.tekiyoShuryoYMD = new TextBoxFlexibleDate();
        this.shokuhiFutanGendogaku = new TextBoxNum();
        this.unitKoshitsu = new TextBoxNum();
        this.unitJunkoshitsu = new TextBoxNum();
        this.juraiKoshitsuTokuyo = new TextBoxNum();
        this.juraiKoshitsuRokenRyoyo = new TextBoxNum();
        this.tashoshitsu = new TextBoxNum();
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("shokuhiFutanGendogaku", shokuhiFutanGendogaku);
        this.setOriginalData("unitKoshitsu", unitKoshitsu);
        this.setOriginalData("unitJunkoshitsu", unitJunkoshitsu);
        this.setOriginalData("juraiKoshitsuTokuyo", juraiKoshitsuTokuyo);
        this.setOriginalData("juraiKoshitsuRokenRyoyo", juraiKoshitsuRokenRyoyo);
        this.setOriginalData("tashoshitsu", tashoshitsu);
    }

    public dgFutanGendogakuList_Row(RString gemmenGengakuShurui, TextBoxFlexibleDate tekiyoKaishiYMD, TextBoxFlexibleDate tekiyoShuryoYMD, TextBoxNum shokuhiFutanGendogaku, TextBoxNum unitKoshitsu, TextBoxNum unitJunkoshitsu, TextBoxNum juraiKoshitsuTokuyo, TextBoxNum juraiKoshitsuRokenRyoyo, TextBoxNum tashoshitsu) {
        super();
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("shokuhiFutanGendogaku", shokuhiFutanGendogaku);
        this.setOriginalData("unitKoshitsu", unitKoshitsu);
        this.setOriginalData("unitJunkoshitsu", unitJunkoshitsu);
        this.setOriginalData("juraiKoshitsuTokuyo", juraiKoshitsuTokuyo);
        this.setOriginalData("juraiKoshitsuRokenRyoyo", juraiKoshitsuRokenRyoyo);
        this.setOriginalData("tashoshitsu", tashoshitsu);
        this.gemmenGengakuShurui = gemmenGengakuShurui;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
        this.unitKoshitsu = unitKoshitsu;
        this.unitJunkoshitsu = unitJunkoshitsu;
        this.juraiKoshitsuTokuyo = juraiKoshitsuTokuyo;
        this.juraiKoshitsuRokenRyoyo = juraiKoshitsuRokenRyoyo;
        this.tashoshitsu = tashoshitsu;
    }

    public RString getGemmenGengakuShurui() {
        return gemmenGengakuShurui;
    }

    public TextBoxFlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxFlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBoxNum getShokuhiFutanGendogaku() {
        return shokuhiFutanGendogaku;
    }

    public TextBoxNum getUnitKoshitsu() {
        return unitKoshitsu;
    }

    public TextBoxNum getUnitJunkoshitsu() {
        return unitJunkoshitsu;
    }

    public TextBoxNum getJuraiKoshitsuTokuyo() {
        return juraiKoshitsuTokuyo;
    }

    public TextBoxNum getJuraiKoshitsuRokenRyoyo() {
        return juraiKoshitsuRokenRyoyo;
    }

    public TextBoxNum getTashoshitsu() {
        return tashoshitsu;
    }

    public void setGemmenGengakuShurui(RString gemmenGengakuShurui) {
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.gemmenGengakuShurui = gemmenGengakuShurui;
    }

    public void setTekiyoKaishiYMD(TextBoxFlexibleDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxFlexibleDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setShokuhiFutanGendogaku(TextBoxNum shokuhiFutanGendogaku) {
        this.setOriginalData("shokuhiFutanGendogaku", shokuhiFutanGendogaku);
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
    }

    public void setUnitKoshitsu(TextBoxNum unitKoshitsu) {
        this.setOriginalData("unitKoshitsu", unitKoshitsu);
        this.unitKoshitsu = unitKoshitsu;
    }

    public void setUnitJunkoshitsu(TextBoxNum unitJunkoshitsu) {
        this.setOriginalData("unitJunkoshitsu", unitJunkoshitsu);
        this.unitJunkoshitsu = unitJunkoshitsu;
    }

    public void setJuraiKoshitsuTokuyo(TextBoxNum juraiKoshitsuTokuyo) {
        this.setOriginalData("juraiKoshitsuTokuyo", juraiKoshitsuTokuyo);
        this.juraiKoshitsuTokuyo = juraiKoshitsuTokuyo;
    }

    public void setJuraiKoshitsuRokenRyoyo(TextBoxNum juraiKoshitsuRokenRyoyo) {
        this.setOriginalData("juraiKoshitsuRokenRyoyo", juraiKoshitsuRokenRyoyo);
        this.juraiKoshitsuRokenRyoyo = juraiKoshitsuRokenRyoyo;
    }

    public void setTashoshitsu(TextBoxNum tashoshitsu) {
        this.setOriginalData("tashoshitsu", tashoshitsu);
        this.tashoshitsu = tashoshitsu;
    }

    // </editor-fold>
}
