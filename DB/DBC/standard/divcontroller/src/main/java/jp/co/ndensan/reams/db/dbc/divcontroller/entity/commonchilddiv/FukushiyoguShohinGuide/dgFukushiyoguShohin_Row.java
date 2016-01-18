package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jan 15 19:25:13 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgFukushiyoguShohin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFukushiyoguShohin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString shohinNo;
    private TextBoxDate kanriKaishiYMD;
    private TextBoxDate kanriShuryoYMD;
    private RString shohinmei;
    private RString seizoJigyoshamei;
    private RString hinmokuCode;

    public dgFukushiyoguShohin_Row() {
        super();
        this.shohinNo = RString.EMPTY;
        this.kanriKaishiYMD = new TextBoxDate();
        this.kanriShuryoYMD = new TextBoxDate();
        this.shohinmei = RString.EMPTY;
        this.seizoJigyoshamei = RString.EMPTY;
        this.hinmokuCode = RString.EMPTY;
        this.setOriginalData("shohinNo", shohinNo);
        this.setOriginalData("kanriKaishiYMD", kanriKaishiYMD);
        this.setOriginalData("kanriShuryoYMD", kanriShuryoYMD);
        this.setOriginalData("shohinmei", shohinmei);
        this.setOriginalData("seizoJigyoshamei", seizoJigyoshamei);
        this.setOriginalData("hinmokuCode", hinmokuCode);
    }

    public dgFukushiyoguShohin_Row(RString shohinNo, TextBoxDate kanriKaishiYMD, TextBoxDate kanriShuryoYMD, RString shohinmei, RString seizoJigyoshamei, RString hinmokuCode) {
        super();
        this.setOriginalData("shohinNo", shohinNo);
        this.setOriginalData("kanriKaishiYMD", kanriKaishiYMD);
        this.setOriginalData("kanriShuryoYMD", kanriShuryoYMD);
        this.setOriginalData("shohinmei", shohinmei);
        this.setOriginalData("seizoJigyoshamei", seizoJigyoshamei);
        this.setOriginalData("hinmokuCode", hinmokuCode);
        this.shohinNo = shohinNo;
        this.kanriKaishiYMD = kanriKaishiYMD;
        this.kanriShuryoYMD = kanriShuryoYMD;
        this.shohinmei = shohinmei;
        this.seizoJigyoshamei = seizoJigyoshamei;
        this.hinmokuCode = hinmokuCode;
    }

    public RString getShohinNo() {
        return shohinNo;
    }

    public TextBoxDate getKanriKaishiYMD() {
        return kanriKaishiYMD;
    }

    public TextBoxDate getKanriShuryoYMD() {
        return kanriShuryoYMD;
    }

    public RString getShohinmei() {
        return shohinmei;
    }

    public RString getSeizoJigyoshamei() {
        return seizoJigyoshamei;
    }

    public RString getHinmokuCode() {
        return hinmokuCode;
    }

    public void setShohinNo(RString shohinNo) {
        this.setOriginalData("shohinNo", shohinNo);
        this.shohinNo = shohinNo;
    }

    public void setKanriKaishiYMD(TextBoxDate kanriKaishiYMD) {
        this.setOriginalData("kanriKaishiYMD", kanriKaishiYMD);
        this.kanriKaishiYMD = kanriKaishiYMD;
    }

    public void setKanriShuryoYMD(TextBoxDate kanriShuryoYMD) {
        this.setOriginalData("kanriShuryoYMD", kanriShuryoYMD);
        this.kanriShuryoYMD = kanriShuryoYMD;
    }

    public void setShohinmei(RString shohinmei) {
        this.setOriginalData("shohinmei", shohinmei);
        this.shohinmei = shohinmei;
    }

    public void setSeizoJigyoshamei(RString seizoJigyoshamei) {
        this.setOriginalData("seizoJigyoshamei", seizoJigyoshamei);
        this.seizoJigyoshamei = seizoJigyoshamei;
    }

    public void setHinmokuCode(RString hinmokuCode) {
        this.setOriginalData("hinmokuCode", hinmokuCode);
        this.hinmokuCode = hinmokuCode;
    }

    // </editor-fold>
}
