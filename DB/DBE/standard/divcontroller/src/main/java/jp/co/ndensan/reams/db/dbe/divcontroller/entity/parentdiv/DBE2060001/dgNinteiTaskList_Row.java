package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 19 16:31:10 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgNinteiTaskList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiTaskList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">

    private RString jotai;
    private RString hokensha;
    private TextBoxDate ninteiShinseiYMD;
    private RString hihoNo;
    private RString hihoShimei;
    private RString shinseiKubunShinseiji;
    private TextBoxDate chosaIraiKanryoYMD;
    private RString chosaItakusaki;
    private RString chosain;
    private TextBoxDate chosaJisshiYMD;
    private TextBoxDate tokusokuHakkoYMD;
    private RString tokusokuHoho;
    private TextBoxNum tokusokuKaisu;
    private TextBoxDate tokusokuKigen;
    private RString tokusokuChiku;
    private RString chosaItakusakiCode;
    private RString chosainCode;
    private RString chikuCode;
    private RString shinseishoKanriNo;
    private RString ninteichosaIraiRirekiNo;

    public dgNinteiTaskList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.ninteiShinseiYMD = new TextBoxDate();
        this.hihoNo = RString.EMPTY;
        this.hihoShimei = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.chosaIraiKanryoYMD = new TextBoxDate();
        this.chosaItakusaki = RString.EMPTY;
        this.chosain = RString.EMPTY;
        this.chosaJisshiYMD = new TextBoxDate();
        this.tokusokuHakkoYMD = new TextBoxDate();
        this.tokusokuHoho = RString.EMPTY;
        this.tokusokuKaisu = new TextBoxNum();
        this.tokusokuKigen = new TextBoxDate();
        this.tokusokuChiku = RString.EMPTY;
        this.chosaItakusakiCode = RString.EMPTY;
        this.chosainCode = RString.EMPTY;
        this.chikuCode = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chosaIraiKanryoYMD", chosaIraiKanryoYMD);
        this.setOriginalData("chosaItakusaki", chosaItakusaki);
        this.setOriginalData("chosain", chosain);
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.setOriginalData("tokusokuHakkoYMD", tokusokuHakkoYMD);
        this.setOriginalData("tokusokuHoho", tokusokuHoho);
        this.setOriginalData("tokusokuKaisu", tokusokuKaisu);
        this.setOriginalData("tokusokuKigen", tokusokuKigen);
        this.setOriginalData("tokusokuChiku", tokusokuChiku);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
    }

    public dgNinteiTaskList_Row(RString jotai, RString hokensha, TextBoxDate ninteiShinseiYMD, RString hihoNo, RString hihoShimei, RString shinseiKubunShinseiji, TextBoxDate chosaIraiKanryoYMD, RString chosaItakusaki, RString chosain, TextBoxDate chosaJisshiYMD, TextBoxDate tokusokuHakkoYMD, RString tokusokuHoho, TextBoxNum tokusokuKaisu, TextBoxDate tokusokuKigen, RString tokusokuChiku, RString chosaItakusakiCode, RString chosainCode, RString chikuCode, RString shinseishoKanriNo, RString ninteichosaIraiRirekiNo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chosaIraiKanryoYMD", chosaIraiKanryoYMD);
        this.setOriginalData("chosaItakusaki", chosaItakusaki);
        this.setOriginalData("chosain", chosain);
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.setOriginalData("tokusokuHakkoYMD", tokusokuHakkoYMD);
        this.setOriginalData("tokusokuHoho", tokusokuHoho);
        this.setOriginalData("tokusokuKaisu", tokusokuKaisu);
        this.setOriginalData("tokusokuKigen", tokusokuKigen);
        this.setOriginalData("tokusokuChiku", tokusokuChiku);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.jotai = jotai;
        this.hokensha = hokensha;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihoNo = hihoNo;
        this.hihoShimei = hihoShimei;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.chosaIraiKanryoYMD = chosaIraiKanryoYMD;
        this.chosaItakusaki = chosaItakusaki;
        this.chosain = chosain;
        this.chosaJisshiYMD = chosaJisshiYMD;
        this.tokusokuHakkoYMD = tokusokuHakkoYMD;
        this.tokusokuHoho = tokusokuHoho;
        this.tokusokuKaisu = tokusokuKaisu;
        this.tokusokuKigen = tokusokuKigen;
        this.tokusokuChiku = tokusokuChiku;
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.chosainCode = chosainCode;
        this.chikuCode = chikuCode;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public TextBoxDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    public RString getHihoNo() {
        return hihoNo;
    }

    public RString getHihoShimei() {
        return hihoShimei;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public TextBoxDate getChosaIraiKanryoYMD() {
        return chosaIraiKanryoYMD;
    }

    public RString getChosaItakusaki() {
        return chosaItakusaki;
    }

    public RString getChosain() {
        return chosain;
    }

    public TextBoxDate getChosaJisshiYMD() {
        return chosaJisshiYMD;
    }

    public TextBoxDate getTokusokuHakkoYMD() {
        return tokusokuHakkoYMD;
    }

    public RString getTokusokuHoho() {
        return tokusokuHoho;
    }

    public TextBoxNum getTokusokuKaisu() {
        return tokusokuKaisu;
    }

    public TextBoxDate getTokusokuKigen() {
        return tokusokuKigen;
    }

    public RString getTokusokuChiku() {
        return tokusokuChiku;
    }

    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getChosainCode() {
        return chosainCode;
    }

    public RString getChikuCode() {
        return chikuCode;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setNinteiShinseiYMD(TextBoxDate ninteiShinseiYMD) {
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    public void setHihoNo(RString hihoNo) {
        this.setOriginalData("hihoNo", hihoNo);
        this.hihoNo = hihoNo;
    }

    public void setHihoShimei(RString hihoShimei) {
        this.setOriginalData("hihoShimei", hihoShimei);
        this.hihoShimei = hihoShimei;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setChosaIraiKanryoYMD(TextBoxDate chosaIraiKanryoYMD) {
        this.setOriginalData("chosaIraiKanryoYMD", chosaIraiKanryoYMD);
        this.chosaIraiKanryoYMD = chosaIraiKanryoYMD;
    }

    public void setChosaItakusaki(RString chosaItakusaki) {
        this.setOriginalData("chosaItakusaki", chosaItakusaki);
        this.chosaItakusaki = chosaItakusaki;
    }

    public void setChosain(RString chosain) {
        this.setOriginalData("chosain", chosain);
        this.chosain = chosain;
    }

    public void setChosaJisshiYMD(TextBoxDate chosaJisshiYMD) {
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.chosaJisshiYMD = chosaJisshiYMD;
    }

    public void setTokusokuHakkoYMD(TextBoxDate tokusokuHakkoYMD) {
        this.setOriginalData("tokusokuHakkoYMD", tokusokuHakkoYMD);
        this.tokusokuHakkoYMD = tokusokuHakkoYMD;
    }

    public void setTokusokuHoho(RString tokusokuHoho) {
        this.setOriginalData("tokusokuHoho", tokusokuHoho);
        this.tokusokuHoho = tokusokuHoho;
    }

    public void setTokusokuKaisu(TextBoxNum tokusokuKaisu) {
        this.setOriginalData("tokusokuKaisu", tokusokuKaisu);
        this.tokusokuKaisu = tokusokuKaisu;
    }

    public void setTokusokuKigen(TextBoxDate tokusokuKigen) {
        this.setOriginalData("tokusokuKigen", tokusokuKigen);
        this.tokusokuKigen = tokusokuKigen;
    }

    public void setTokusokuChiku(RString tokusokuChiku) {
        this.setOriginalData("tokusokuChiku", tokusokuChiku);
        this.tokusokuChiku = tokusokuChiku;
    }

    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setChosainCode(RString chosainCode) {
        this.setOriginalData("chosainCode", chosainCode);
        this.chosainCode = chosainCode;
    }

    public void setChikuCode(RString chikuCode) {
        this.setOriginalData("chikuCode", chikuCode);
        this.chikuCode = chikuCode;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNinteichosaIraiRirekiNo(RString ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    // </editor-fold>
}
