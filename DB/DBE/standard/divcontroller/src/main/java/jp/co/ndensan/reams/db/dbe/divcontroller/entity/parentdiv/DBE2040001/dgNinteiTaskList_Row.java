package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 14 18:35:05 JST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-10_12-10-23">

    private RString jyotai;
    private RString hokensha;
    private TextBoxDate ninteiShinseiDay;
    private RString hihoNumber;
    private RString hihoShimei;
    private RString shinseiKubunShinseiji;
    private TextBoxNum ikenshoIraiIkenCount;
    private TextBoxDate ikenshoIraiDay;
    private TextBoxDate ikenshoIraiIraishoHakkoDay;
    private TextBoxDate ikenshoIraiIkenshoShutsuryokuDay;
    private TextBoxDate ikenshoIraiKigen;
    private RString ikenshoIraiShokai;
    private RString konkaiShujiiIryokikan;
    private RString konkaiShujii;
    private RString zenkaiIryokikan;
    private RString zenkaiShujii;
    private RString yubinNumber;
    private RString jusho;
    private RString nyushoShisetsu;
    private TextBoxDate ikenshoTokusokuHakkoDay;
    private RString ikenshoTokusokuHoho;
    private TextBoxNum ikenshoTokusokuCount;
    private TextBoxDate ikenshoTokusokuLimit;
    private TextBoxNum keikaNissu;
    private TextBoxDate ikenshoIraiKanryoDay;
    private RString shinseishoKanriNo;
    private RString nyushoShisetsuCode;

    public dgNinteiTaskList_Row() {
        super();
        this.jyotai = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.ninteiShinseiDay = new TextBoxDate();
        this.hihoNumber = RString.EMPTY;
        this.hihoShimei = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.ikenshoIraiIkenCount = new TextBoxNum();
        this.ikenshoIraiDay = new TextBoxDate();
        this.ikenshoIraiIraishoHakkoDay = new TextBoxDate();
        this.ikenshoIraiIkenshoShutsuryokuDay = new TextBoxDate();
        this.ikenshoIraiKigen = new TextBoxDate();
        this.ikenshoIraiShokai = RString.EMPTY;
        this.konkaiShujiiIryokikan = RString.EMPTY;
        this.konkaiShujii = RString.EMPTY;
        this.zenkaiIryokikan = RString.EMPTY;
        this.zenkaiShujii = RString.EMPTY;
        this.yubinNumber = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
        this.ikenshoTokusokuHakkoDay = new TextBoxDate();
        this.ikenshoTokusokuHoho = RString.EMPTY;
        this.ikenshoTokusokuCount = new TextBoxNum();
        this.ikenshoTokusokuLimit = new TextBoxDate();
        this.keikaNissu = new TextBoxNum();
        this.ikenshoIraiKanryoDay = new TextBoxDate();
        this.shinseishoKanriNo = RString.EMPTY;
        this.nyushoShisetsuCode = RString.EMPTY;
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.setOriginalData("keikaNissu", keikaNissu);
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
    }

    public dgNinteiTaskList_Row(RString jyotai, RString hokensha, TextBoxDate ninteiShinseiDay, RString hihoNumber, RString hihoShimei, RString shinseiKubunShinseiji, TextBoxNum ikenshoIraiIkenCount, TextBoxDate ikenshoIraiDay, TextBoxDate ikenshoIraiIraishoHakkoDay, TextBoxDate ikenshoIraiIkenshoShutsuryokuDay, TextBoxDate ikenshoIraiKigen, RString ikenshoIraiShokai, RString konkaiShujiiIryokikan, RString konkaiShujii, RString zenkaiIryokikan, RString zenkaiShujii, RString yubinNumber, RString jusho, RString nyushoShisetsu, TextBoxDate ikenshoTokusokuHakkoDay, RString ikenshoTokusokuHoho, TextBoxNum ikenshoTokusokuCount, TextBoxDate ikenshoTokusokuLimit, TextBoxNum keikaNissu, TextBoxDate ikenshoIraiKanryoDay, RString shinseishoKanriNo, RString nyushoShisetsuCode) {
        super();
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.setOriginalData("keikaNissu", keikaNissu);
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.jyotai = jyotai;
        this.hokensha = hokensha;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.hihoNumber = hihoNumber;
        this.hihoShimei = hihoShimei;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.ikenshoIraiIkenCount = ikenshoIraiIkenCount;
        this.ikenshoIraiDay = ikenshoIraiDay;
        this.ikenshoIraiIraishoHakkoDay = ikenshoIraiIraishoHakkoDay;
        this.ikenshoIraiIkenshoShutsuryokuDay = ikenshoIraiIkenshoShutsuryokuDay;
        this.ikenshoIraiKigen = ikenshoIraiKigen;
        this.ikenshoIraiShokai = ikenshoIraiShokai;
        this.konkaiShujiiIryokikan = konkaiShujiiIryokikan;
        this.konkaiShujii = konkaiShujii;
        this.zenkaiIryokikan = zenkaiIryokikan;
        this.zenkaiShujii = zenkaiShujii;
        this.yubinNumber = yubinNumber;
        this.jusho = jusho;
        this.nyushoShisetsu = nyushoShisetsu;
        this.ikenshoTokusokuHakkoDay = ikenshoTokusokuHakkoDay;
        this.ikenshoTokusokuHoho = ikenshoTokusokuHoho;
        this.ikenshoTokusokuCount = ikenshoTokusokuCount;
        this.ikenshoTokusokuLimit = ikenshoTokusokuLimit;
        this.keikaNissu = keikaNissu;
        this.ikenshoIraiKanryoDay = ikenshoIraiKanryoDay;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    public RString getJyotai() {
        return jyotai;
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

    public TextBoxNum getIkenshoIraiIkenCount() {
        return ikenshoIraiIkenCount;
    }

    public TextBoxDate getIkenshoIraiDay() {
        return ikenshoIraiDay;
    }

    public TextBoxDate getIkenshoIraiIraishoHakkoDay() {
        return ikenshoIraiIraishoHakkoDay;
    }

    public TextBoxDate getIkenshoIraiIkenshoShutsuryokuDay() {
        return ikenshoIraiIkenshoShutsuryokuDay;
    }

    public TextBoxDate getIkenshoIraiKigen() {
        return ikenshoIraiKigen;
    }

    public RString getIkenshoIraiShokai() {
        return ikenshoIraiShokai;
    }

    public RString getKonkaiShujiiIryokikan() {
        return konkaiShujiiIryokikan;
    }

    public RString getKonkaiShujii() {
        return konkaiShujii;
    }

    public RString getZenkaiIryokikan() {
        return zenkaiIryokikan;
    }

    public RString getZenkaiShujii() {
        return zenkaiShujii;
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

    public TextBoxDate getIkenshoTokusokuHakkoDay() {
        return ikenshoTokusokuHakkoDay;
    }

    public RString getIkenshoTokusokuHoho() {
        return ikenshoTokusokuHoho;
    }

    public TextBoxNum getIkenshoTokusokuCount() {
        return ikenshoTokusokuCount;
    }

    public TextBoxDate getIkenshoTokusokuLimit() {
        return ikenshoTokusokuLimit;
    }

    public TextBoxNum getKeikaNissu() {
        return keikaNissu;
    }

    public TextBoxDate getIkenshoIraiKanryoDay() {
        return ikenshoIraiKanryoDay;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    public void setJyotai(RString jyotai) {
        this.setOriginalData("jyotai", jyotai);
        this.jyotai = jyotai;
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

    public void setIkenshoIraiIkenCount(TextBoxNum ikenshoIraiIkenCount) {
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.ikenshoIraiIkenCount = ikenshoIraiIkenCount;
    }

    public void setIkenshoIraiDay(TextBoxDate ikenshoIraiDay) {
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.ikenshoIraiDay = ikenshoIraiDay;
    }

    public void setIkenshoIraiIraishoHakkoDay(TextBoxDate ikenshoIraiIraishoHakkoDay) {
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.ikenshoIraiIraishoHakkoDay = ikenshoIraiIraishoHakkoDay;
    }

    public void setIkenshoIraiIkenshoShutsuryokuDay(TextBoxDate ikenshoIraiIkenshoShutsuryokuDay) {
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.ikenshoIraiIkenshoShutsuryokuDay = ikenshoIraiIkenshoShutsuryokuDay;
    }

    public void setIkenshoIraiKigen(TextBoxDate ikenshoIraiKigen) {
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.ikenshoIraiKigen = ikenshoIraiKigen;
    }

    public void setIkenshoIraiShokai(RString ikenshoIraiShokai) {
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.ikenshoIraiShokai = ikenshoIraiShokai;
    }

    public void setKonkaiShujiiIryokikan(RString konkaiShujiiIryokikan) {
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.konkaiShujiiIryokikan = konkaiShujiiIryokikan;
    }

    public void setKonkaiShujii(RString konkaiShujii) {
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.konkaiShujii = konkaiShujii;
    }

    public void setZenkaiIryokikan(RString zenkaiIryokikan) {
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.zenkaiIryokikan = zenkaiIryokikan;
    }

    public void setZenkaiShujii(RString zenkaiShujii) {
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.zenkaiShujii = zenkaiShujii;
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

    public void setIkenshoTokusokuHakkoDay(TextBoxDate ikenshoTokusokuHakkoDay) {
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.ikenshoTokusokuHakkoDay = ikenshoTokusokuHakkoDay;
    }

    public void setIkenshoTokusokuHoho(RString ikenshoTokusokuHoho) {
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.ikenshoTokusokuHoho = ikenshoTokusokuHoho;
    }

    public void setIkenshoTokusokuCount(TextBoxNum ikenshoTokusokuCount) {
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.ikenshoTokusokuCount = ikenshoTokusokuCount;
    }

    public void setIkenshoTokusokuLimit(TextBoxDate ikenshoTokusokuLimit) {
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.ikenshoTokusokuLimit = ikenshoTokusokuLimit;
    }

    public void setKeikaNissu(TextBoxNum keikaNissu) {
        this.setOriginalData("keikaNissu", keikaNissu);
        this.keikaNissu = keikaNissu;
    }

    public void setIkenshoIraiKanryoDay(TextBoxDate ikenshoIraiKanryoDay) {
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.ikenshoIraiKanryoDay = ikenshoIraiKanryoDay;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    // </editor-fold>
}
