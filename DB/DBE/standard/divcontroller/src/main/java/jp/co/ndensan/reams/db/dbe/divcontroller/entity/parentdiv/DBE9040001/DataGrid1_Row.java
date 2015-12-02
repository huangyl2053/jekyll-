package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Nov 24 10:18:45 CST 2015
 */

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * DataGrid1_Row のクラスファイル
 *
 * @author 自動生成
 */
public class DataGrid1_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString jotai;
    private RString shichoson;
    private TextBoxCode chosainCode;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private TextBoxCode chosaItakusakiCode;
    private RString chosaItakusakiMeisho;
    private RString seibetsu;
    private RString chiku;
    private RString chosainShikaku;
    private TextBoxNum chosaKanoNinzu;
    private RString jokyoFlag;
    private RString yubinNo;
    private RString jusho;
    private RString telNo;
    private RString faxNo;

    public DataGrid1_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.shichoson = RString.EMPTY;
        this.chosainCode = new TextBoxCode();
        this.chosainShimei = RString.EMPTY;
        this.chosainKanaShimei = RString.EMPTY;
        this.chosaItakusakiCode = new TextBoxCode();
        this.chosaItakusakiMeisho = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.chiku = RString.EMPTY;
        this.chosainShikaku = RString.EMPTY;
        this.chosaKanoNinzu = new TextBoxNum();
        this.jokyoFlag = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.telNo = RString.EMPTY;
        this.faxNo = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chosainShimei", chosainShimei);
        this.setOriginalData("chosainKanaShimei", chosainKanaShimei);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.setOriginalData("chosaKanoNinzu", chosaKanoNinzu);
        this.setOriginalData("jokyoFlag", jokyoFlag);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("faxNo", faxNo);
    }

    public DataGrid1_Row(RString jotai, RString shichoson, TextBoxCode chosainCode, RString chosainShimei, RString chosainKanaShimei, TextBoxCode chosaItakusakiCode, RString chosaItakusakiMeisho, RString seibetsu, RString chiku, RString chosainShikaku, TextBoxNum chosaKanoNinzu, RString jokyoFlag, RString yubinNo, RString jusho, RString telNo, RString faxNo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chosainShimei", chosainShimei);
        this.setOriginalData("chosainKanaShimei", chosainKanaShimei);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.setOriginalData("chosaKanoNinzu", chosaKanoNinzu);
        this.setOriginalData("jokyoFlag", jokyoFlag);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("faxNo", faxNo);
        this.jotai = jotai;
        this.shichoson = shichoson;
        this.chosainCode = chosainCode;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
        this.seibetsu = seibetsu;
        this.chiku = chiku;
        this.chosainShikaku = chosainShikaku;
        this.chosaKanoNinzu = chosaKanoNinzu;
        this.jokyoFlag = jokyoFlag;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getShichoson() {
        return shichoson;
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

    public TextBoxCode getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getChosaItakusakiMeisho() {
        return chosaItakusakiMeisho;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getChosainShikaku() {
        return chosainShikaku;
    }

    public TextBoxNum getChosaKanoNinzu() {
        return chosaKanoNinzu;
    }

    public RString getJokyoFlag() {
        return jokyoFlag;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTelNo() {
        return telNo;
    }

    public RString getFaxNo() {
        return faxNo;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setShichoson(RString shichoson) {
        this.setOriginalData("shichoson", shichoson);
        this.shichoson = shichoson;
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

    public void setChosaItakusakiCode(TextBoxCode chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setChosaItakusakiMeisho(RString chosaItakusakiMeisho) {
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setChosainShikaku(RString chosainShikaku) {
        this.setOriginalData("chosainShikaku", chosainShikaku);
        this.chosainShikaku = chosainShikaku;
    }

    public void setChosaKanoNinzu(TextBoxNum chosaKanoNinzu) {
        this.setOriginalData("chosaKanoNinzu", chosaKanoNinzu);
        this.chosaKanoNinzu = chosaKanoNinzu;
    }

    public void setJokyoFlag(RString jokyoFlag) {
        this.setOriginalData("jokyoFlag", jokyoFlag);
        this.jokyoFlag = jokyoFlag;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setTelNo(RString telNo) {
        this.setOriginalData("telNo", telNo);
        this.telNo = telNo;
    }

    public void setFaxNo(RString faxNo) {
        this.setOriginalData("faxNo", faxNo);
        this.faxNo = faxNo;
    }

    // </editor-fold>
    void setChikuCode(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setJigyoshaMeisho(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setNinteichosaItakusakiCode(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getTelNo(TelNo telNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getFaxNo(TelNo telNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setChosaKanoNinzuPerMonth(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setShichosonMeisho(RString rString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setNinteiChosainNo(ChosainCode chosainCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
