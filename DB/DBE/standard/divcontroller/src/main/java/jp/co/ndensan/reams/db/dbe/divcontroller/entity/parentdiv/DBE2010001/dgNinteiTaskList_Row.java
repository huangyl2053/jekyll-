package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Mar 04 10:19:33 JST 2017 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">

    private RString jotai;
    private RString hokenshaCode;
    private RString hokensha;
    private TextBoxDate ninteiShinseiDay;
    private RString hihoNumber;
    private RString hihoShimei;
    private RString shinseiKubunShinseiji;
    private TextBoxDate chosaIraiKanryoDay;
    private TextBoxNum chosaIraiSaichosaCount;
    private TextBoxDate ninteichosaIraiYmd;
    private TextBoxDate chosaIraishoHakkoDay;
    private TextBoxDate chousahyoOutput;
    private TextBoxDate chosaIraiDataShutsuryokuDay;
    private TextBoxDate chosaIraiKigen;
    private RString chosaIraiKubunCode;
    private RString chosaIraiKubun;
    private RString konkaiChosaItakusakiCode;
    private RString konkaiChosaItakusaki;
    private RString konkaiChosainCode;
    private RString konkaiChosain;
    private TextBoxNum konkaiChosaCount;
    private RString zenkaiChosaItakusaki;
    private RString zenkaiChosain;
    private RString zenzenkaiChosaItakusaki;
    private RString zenzenkaiChosain;
    private RString yubinNumber;
    private RString jusho;
    private RString nyushoShisetsu;
    private TextBoxDate chosaTokusokuHakkoDay;
    private RString chosaTokusokuHoho;
    private TextBoxNum chosaTokusokuCount;
    private RString chosaTokusokuChiku;
    private RString shichosonName;
    private RString ninteichosaIraiRirekiNo;
    private RString chikuCode;
    private RString shinseishoKanriNo;
    private RString koroshoIfShikibetsuCode;
    private RString getShoKisaiHokenshaNo;
    private RString shichosonCode;

    public dgNinteiTaskList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.hokenshaCode = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.ninteiShinseiDay = new TextBoxDate();
        this.hihoNumber = RString.EMPTY;
        this.hihoShimei = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.chosaIraiKanryoDay = new TextBoxDate();
        this.chosaIraiSaichosaCount = new TextBoxNum();
        this.ninteichosaIraiYmd = new TextBoxDate();
        this.chosaIraishoHakkoDay = new TextBoxDate();
        this.chousahyoOutput = new TextBoxDate();
        this.chosaIraiDataShutsuryokuDay = new TextBoxDate();
        this.chosaIraiKigen = new TextBoxDate();
        this.chosaIraiKubunCode = RString.EMPTY;
        this.chosaIraiKubun = RString.EMPTY;
        this.konkaiChosaItakusakiCode = RString.EMPTY;
        this.konkaiChosaItakusaki = RString.EMPTY;
        this.konkaiChosainCode = RString.EMPTY;
        this.konkaiChosain = RString.EMPTY;
        this.konkaiChosaCount = new TextBoxNum();
        this.zenkaiChosaItakusaki = RString.EMPTY;
        this.zenkaiChosain = RString.EMPTY;
        this.zenzenkaiChosaItakusaki = RString.EMPTY;
        this.zenzenkaiChosain = RString.EMPTY;
        this.yubinNumber = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
        this.chosaTokusokuHakkoDay = new TextBoxDate();
        this.chosaTokusokuHoho = RString.EMPTY;
        this.chosaTokusokuCount = new TextBoxNum();
        this.chosaTokusokuChiku = RString.EMPTY;
        this.shichosonName = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = RString.EMPTY;
        this.chikuCode = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.getShoKisaiHokenshaNo = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.setOriginalData("ninteichosaIraiYmd", ninteichosaIraiYmd);
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.setOriginalData("chosaIraiKubunCode", chosaIraiKubunCode);
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.setOriginalData("konkaiChosaItakusakiCode", konkaiChosaItakusakiCode);
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.setOriginalData("konkaiChosainCode", konkaiChosainCode);
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.setOriginalData("shichosonName", shichosonName);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("getShoKisaiHokenshaNo", getShoKisaiHokenshaNo);
        this.setOriginalData("shichosonCode", shichosonCode);
    }

    public dgNinteiTaskList_Row(RString jotai, RString hokenshaCode, RString hokensha, TextBoxDate ninteiShinseiDay, RString hihoNumber, RString hihoShimei, RString shinseiKubunShinseiji, TextBoxDate chosaIraiKanryoDay, TextBoxNum chosaIraiSaichosaCount, TextBoxDate ninteichosaIraiYmd, TextBoxDate chosaIraishoHakkoDay, TextBoxDate chousahyoOutput, TextBoxDate chosaIraiDataShutsuryokuDay, TextBoxDate chosaIraiKigen, RString chosaIraiKubunCode, RString chosaIraiKubun, RString konkaiChosaItakusakiCode, RString konkaiChosaItakusaki, RString konkaiChosainCode, RString konkaiChosain, TextBoxNum konkaiChosaCount, RString zenkaiChosaItakusaki, RString zenkaiChosain, RString zenzenkaiChosaItakusaki, RString zenzenkaiChosain, RString yubinNumber, RString jusho, RString nyushoShisetsu, TextBoxDate chosaTokusokuHakkoDay, RString chosaTokusokuHoho, TextBoxNum chosaTokusokuCount, RString chosaTokusokuChiku, RString shichosonName, RString ninteichosaIraiRirekiNo, RString chikuCode, RString shinseishoKanriNo, RString koroshoIfShikibetsuCode, RString getShoKisaiHokenshaNo, RString shichosonCode) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.setOriginalData("ninteichosaIraiYmd", ninteichosaIraiYmd);
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.setOriginalData("chosaIraiKubunCode", chosaIraiKubunCode);
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.setOriginalData("konkaiChosaItakusakiCode", konkaiChosaItakusakiCode);
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.setOriginalData("konkaiChosainCode", konkaiChosainCode);
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.setOriginalData("shichosonName", shichosonName);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("getShoKisaiHokenshaNo", getShoKisaiHokenshaNo);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.jotai = jotai;
        this.hokenshaCode = hokenshaCode;
        this.hokensha = hokensha;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.hihoNumber = hihoNumber;
        this.hihoShimei = hihoShimei;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.chosaIraiKanryoDay = chosaIraiKanryoDay;
        this.chosaIraiSaichosaCount = chosaIraiSaichosaCount;
        this.ninteichosaIraiYmd = ninteichosaIraiYmd;
        this.chosaIraishoHakkoDay = chosaIraishoHakkoDay;
        this.chousahyoOutput = chousahyoOutput;
        this.chosaIraiDataShutsuryokuDay = chosaIraiDataShutsuryokuDay;
        this.chosaIraiKigen = chosaIraiKigen;
        this.chosaIraiKubunCode = chosaIraiKubunCode;
        this.chosaIraiKubun = chosaIraiKubun;
        this.konkaiChosaItakusakiCode = konkaiChosaItakusakiCode;
        this.konkaiChosaItakusaki = konkaiChosaItakusaki;
        this.konkaiChosainCode = konkaiChosainCode;
        this.konkaiChosain = konkaiChosain;
        this.konkaiChosaCount = konkaiChosaCount;
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
        this.zenkaiChosain = zenkaiChosain;
        this.zenzenkaiChosaItakusaki = zenzenkaiChosaItakusaki;
        this.zenzenkaiChosain = zenzenkaiChosain;
        this.yubinNumber = yubinNumber;
        this.jusho = jusho;
        this.nyushoShisetsu = nyushoShisetsu;
        this.chosaTokusokuHakkoDay = chosaTokusokuHakkoDay;
        this.chosaTokusokuHoho = chosaTokusokuHoho;
        this.chosaTokusokuCount = chosaTokusokuCount;
        this.chosaTokusokuChiku = chosaTokusokuChiku;
        this.shichosonName = shichosonName;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
        this.chikuCode = chikuCode;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.getShoKisaiHokenshaNo = getShoKisaiHokenshaNo;
        this.shichosonCode = shichosonCode;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getHokenshaCode() {
        return hokenshaCode;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public TextBoxDate getNinteiShinseiDay() {
        return ninteiShinseiDay;
    }

    public RString getHihoNumber() {
        return hihoNumber;
    }

    public RString getHihoShimei() {
        return hihoShimei;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public TextBoxDate getChosaIraiKanryoDay() {
        return chosaIraiKanryoDay;
    }

    public TextBoxNum getChosaIraiSaichosaCount() {
        return chosaIraiSaichosaCount;
    }

    public TextBoxDate getNinteichosaIraiYmd() {
        return ninteichosaIraiYmd;
    }

    public TextBoxDate getChosaIraishoHakkoDay() {
        return chosaIraishoHakkoDay;
    }

    public TextBoxDate getChousahyoOutput() {
        return chousahyoOutput;
    }

    public TextBoxDate getChosaIraiDataShutsuryokuDay() {
        return chosaIraiDataShutsuryokuDay;
    }

    public TextBoxDate getChosaIraiKigen() {
        return chosaIraiKigen;
    }

    public RString getChosaIraiKubunCode() {
        return chosaIraiKubunCode;
    }

    public RString getChosaIraiKubun() {
        return chosaIraiKubun;
    }

    public RString getKonkaiChosaItakusakiCode() {
        return konkaiChosaItakusakiCode;
    }

    public RString getKonkaiChosaItakusaki() {
        return konkaiChosaItakusaki;
    }

    public RString getKonkaiChosainCode() {
        return konkaiChosainCode;
    }

    public RString getKonkaiChosain() {
        return konkaiChosain;
    }

    public TextBoxNum getKonkaiChosaCount() {
        return konkaiChosaCount;
    }

    public RString getZenkaiChosaItakusaki() {
        return zenkaiChosaItakusaki;
    }

    public RString getZenkaiChosain() {
        return zenkaiChosain;
    }

    public RString getZenzenkaiChosaItakusaki() {
        return zenzenkaiChosaItakusaki;
    }

    public RString getZenzenkaiChosain() {
        return zenzenkaiChosain;
    }

    public RString getYubinNumber() {
        return yubinNumber;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public TextBoxDate getChosaTokusokuHakkoDay() {
        return chosaTokusokuHakkoDay;
    }

    public RString getChosaTokusokuHoho() {
        return chosaTokusokuHoho;
    }

    public TextBoxNum getChosaTokusokuCount() {
        return chosaTokusokuCount;
    }

    public RString getChosaTokusokuChiku() {
        return chosaTokusokuChiku;
    }

    public RString getShichosonName() {
        return shichosonName;
    }

    public RString getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public RString getChikuCode() {
        return chikuCode;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public RString getGetShoKisaiHokenshaNo() {
        return getShoKisaiHokenshaNo;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setHokenshaCode(RString hokenshaCode) {
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.hokenshaCode = hokenshaCode;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setNinteiShinseiDay(TextBoxDate ninteiShinseiDay) {
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.ninteiShinseiDay = ninteiShinseiDay;
    }

    public void setHihoNumber(RString hihoNumber) {
        this.setOriginalData("hihoNumber", hihoNumber);
        this.hihoNumber = hihoNumber;
    }

    public void setHihoShimei(RString hihoShimei) {
        this.setOriginalData("hihoShimei", hihoShimei);
        this.hihoShimei = hihoShimei;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setChosaIraiKanryoDay(TextBoxDate chosaIraiKanryoDay) {
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.chosaIraiKanryoDay = chosaIraiKanryoDay;
    }

    public void setChosaIraiSaichosaCount(TextBoxNum chosaIraiSaichosaCount) {
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.chosaIraiSaichosaCount = chosaIraiSaichosaCount;
    }

    public void setNinteichosaIraiYmd(TextBoxDate ninteichosaIraiYmd) {
        this.setOriginalData("ninteichosaIraiYmd", ninteichosaIraiYmd);
        this.ninteichosaIraiYmd = ninteichosaIraiYmd;
    }

    public void setChosaIraishoHakkoDay(TextBoxDate chosaIraishoHakkoDay) {
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.chosaIraishoHakkoDay = chosaIraishoHakkoDay;
    }

    public void setChousahyoOutput(TextBoxDate chousahyoOutput) {
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.chousahyoOutput = chousahyoOutput;
    }

    public void setChosaIraiDataShutsuryokuDay(TextBoxDate chosaIraiDataShutsuryokuDay) {
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.chosaIraiDataShutsuryokuDay = chosaIraiDataShutsuryokuDay;
    }

    public void setChosaIraiKigen(TextBoxDate chosaIraiKigen) {
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.chosaIraiKigen = chosaIraiKigen;
    }

    public void setChosaIraiKubunCode(RString chosaIraiKubunCode) {
        this.setOriginalData("chosaIraiKubunCode", chosaIraiKubunCode);
        this.chosaIraiKubunCode = chosaIraiKubunCode;
    }

    public void setChosaIraiKubun(RString chosaIraiKubun) {
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.chosaIraiKubun = chosaIraiKubun;
    }

    public void setKonkaiChosaItakusakiCode(RString konkaiChosaItakusakiCode) {
        this.setOriginalData("konkaiChosaItakusakiCode", konkaiChosaItakusakiCode);
        this.konkaiChosaItakusakiCode = konkaiChosaItakusakiCode;
    }

    public void setKonkaiChosaItakusaki(RString konkaiChosaItakusaki) {
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.konkaiChosaItakusaki = konkaiChosaItakusaki;
    }

    public void setKonkaiChosainCode(RString konkaiChosainCode) {
        this.setOriginalData("konkaiChosainCode", konkaiChosainCode);
        this.konkaiChosainCode = konkaiChosainCode;
    }

    public void setKonkaiChosain(RString konkaiChosain) {
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.konkaiChosain = konkaiChosain;
    }

    public void setKonkaiChosaCount(TextBoxNum konkaiChosaCount) {
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.konkaiChosaCount = konkaiChosaCount;
    }

    public void setZenkaiChosaItakusaki(RString zenkaiChosaItakusaki) {
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
    }

    public void setZenkaiChosain(RString zenkaiChosain) {
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.zenkaiChosain = zenkaiChosain;
    }

    public void setZenzenkaiChosaItakusaki(RString zenzenkaiChosaItakusaki) {
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.zenzenkaiChosaItakusaki = zenzenkaiChosaItakusaki;
    }

    public void setZenzenkaiChosain(RString zenzenkaiChosain) {
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.zenzenkaiChosain = zenzenkaiChosain;
    }

    public void setYubinNumber(RString yubinNumber) {
        this.setOriginalData("yubinNumber", yubinNumber);
        this.yubinNumber = yubinNumber;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setNyushoShisetsu(RString nyushoShisetsu) {
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public void setChosaTokusokuHakkoDay(TextBoxDate chosaTokusokuHakkoDay) {
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.chosaTokusokuHakkoDay = chosaTokusokuHakkoDay;
    }

    public void setChosaTokusokuHoho(RString chosaTokusokuHoho) {
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.chosaTokusokuHoho = chosaTokusokuHoho;
    }

    public void setChosaTokusokuCount(TextBoxNum chosaTokusokuCount) {
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.chosaTokusokuCount = chosaTokusokuCount;
    }

    public void setChosaTokusokuChiku(RString chosaTokusokuChiku) {
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.chosaTokusokuChiku = chosaTokusokuChiku;
    }

    public void setShichosonName(RString shichosonName) {
        this.setOriginalData("shichosonName", shichosonName);
        this.shichosonName = shichosonName;
    }

    public void setNinteichosaIraiRirekiNo(RString ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public void setChikuCode(RString chikuCode) {
        this.setOriginalData("chikuCode", chikuCode);
        this.chikuCode = chikuCode;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public void setGetShoKisaiHokenshaNo(RString getShoKisaiHokenshaNo) {
        this.setOriginalData("getShoKisaiHokenshaNo", getShoKisaiHokenshaNo);
        this.getShoKisaiHokenshaNo = getShoKisaiHokenshaNo;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    // </editor-fold>
}
