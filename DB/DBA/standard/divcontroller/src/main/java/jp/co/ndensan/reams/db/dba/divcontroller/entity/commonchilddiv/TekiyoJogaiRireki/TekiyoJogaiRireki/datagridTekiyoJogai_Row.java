package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 28 13:41:15 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * datagridTekiyoJogai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class datagridTekiyoJogai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxDate tekiyoDate;
    private TextBoxDate tekiyoTodokeDate;
    private RString tekiyoJiyuCode;
    private RString tekiyoJiyu;
    private TextBoxDate kayijoDate;
    private TextBoxDate kaijoTodokeDate;
    private RString kaijoJiyuCode;
    private RString kaijoJiyu;
    private TextBoxDate nyuShoDate;
    private TextBoxDate taiShoDate;
    private RString nyushoShisetsuCode;
    private RString nyuShoShisetu;
    private RString daichoShubetsu;
    private RString shisetsuShurui;
    private RString rirekiNo;
    private RString idoYMD;
    private RString idoJiyuCode;
    private RString edaNo;
    private RString shichosonCode;
    private RString nyushoTsuchiHakkoYMD;
    private RString taishoTsuchiHakkoYMD;
    private RString henkoTsuchiHakkoYMD;
    private RString henkoumaeTekiyoDate;
    private RString henkoumaeIdoYMD;
    private RString henkoumaeEdaNo;
    private RString henkougoTekiyoDate;
    private RString henkougoIdoYMD;
    private RString henkougoEdaNo;

    public datagridTekiyoJogai_Row() {
        super();
        this.tekiyoDate = new TextBoxDate();
        this.tekiyoTodokeDate = new TextBoxDate();
        this.tekiyoJiyuCode = RString.EMPTY;
        this.tekiyoJiyu = RString.EMPTY;
        this.kayijoDate = new TextBoxDate();
        this.kaijoTodokeDate = new TextBoxDate();
        this.kaijoJiyuCode = RString.EMPTY;
        this.kaijoJiyu = RString.EMPTY;
        this.nyuShoDate = new TextBoxDate();
        this.taiShoDate = new TextBoxDate();
        this.nyushoShisetsuCode = RString.EMPTY;
        this.nyuShoShisetu = RString.EMPTY;
        this.daichoShubetsu = RString.EMPTY;
        this.shisetsuShurui = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.idoYMD = RString.EMPTY;
        this.idoJiyuCode = RString.EMPTY;
        this.edaNo = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.nyushoTsuchiHakkoYMD = RString.EMPTY;
        this.taishoTsuchiHakkoYMD = RString.EMPTY;
        this.henkoTsuchiHakkoYMD = RString.EMPTY;
        this.henkoumaeTekiyoDate = RString.EMPTY;
        this.henkoumaeIdoYMD = RString.EMPTY;
        this.henkoumaeEdaNo = RString.EMPTY;
        this.henkougoTekiyoDate = RString.EMPTY;
        this.henkougoIdoYMD = RString.EMPTY;
        this.henkougoEdaNo = RString.EMPTY;
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokeDate", tekiyoTodokeDate);
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("kayijoDate", kayijoDate);
        this.setOriginalData("kaijoTodokeDate", kaijoTodokeDate);
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("nyuShoDate", nyuShoDate);
        this.setOriginalData("taiShoDate", taiShoDate);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("nyuShoShisetu", nyuShoShisetu);
        this.setOriginalData("daichoShubetsu", daichoShubetsu);
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("nyushoTsuchiHakkoYMD", nyushoTsuchiHakkoYMD);
        this.setOriginalData("taishoTsuchiHakkoYMD", taishoTsuchiHakkoYMD);
        this.setOriginalData("henkoTsuchiHakkoYMD", henkoTsuchiHakkoYMD);
        this.setOriginalData("henkoumaeTekiyoDate", henkoumaeTekiyoDate);
        this.setOriginalData("henkoumaeIdoYMD", henkoumaeIdoYMD);
        this.setOriginalData("henkoumaeEdaNo", henkoumaeEdaNo);
        this.setOriginalData("henkougoTekiyoDate", henkougoTekiyoDate);
        this.setOriginalData("henkougoIdoYMD", henkougoIdoYMD);
        this.setOriginalData("henkougoEdaNo", henkougoEdaNo);
    }

    public datagridTekiyoJogai_Row(TextBoxDate tekiyoDate, TextBoxDate tekiyoTodokeDate, RString tekiyoJiyuCode, RString tekiyoJiyu, TextBoxDate kayijoDate, TextBoxDate kaijoTodokeDate, RString kaijoJiyuCode, RString kaijoJiyu, TextBoxDate nyuShoDate, TextBoxDate taiShoDate, RString nyushoShisetsuCode, RString nyuShoShisetu, RString daichoShubetsu, RString shisetsuShurui, RString rirekiNo, RString idoYMD, RString idoJiyuCode, RString edaNo, RString shichosonCode, RString nyushoTsuchiHakkoYMD, RString taishoTsuchiHakkoYMD, RString henkoTsuchiHakkoYMD, RString henkoumaeTekiyoDate, RString henkoumaeIdoYMD, RString henkoumaeEdaNo, RString henkougoTekiyoDate, RString henkougoIdoYMD, RString henkougoEdaNo) {
        super();
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokeDate", tekiyoTodokeDate);
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("kayijoDate", kayijoDate);
        this.setOriginalData("kaijoTodokeDate", kaijoTodokeDate);
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("nyuShoDate", nyuShoDate);
        this.setOriginalData("taiShoDate", taiShoDate);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("nyuShoShisetu", nyuShoShisetu);
        this.setOriginalData("daichoShubetsu", daichoShubetsu);
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("nyushoTsuchiHakkoYMD", nyushoTsuchiHakkoYMD);
        this.setOriginalData("taishoTsuchiHakkoYMD", taishoTsuchiHakkoYMD);
        this.setOriginalData("henkoTsuchiHakkoYMD", henkoTsuchiHakkoYMD);
        this.setOriginalData("henkoumaeTekiyoDate", henkoumaeTekiyoDate);
        this.setOriginalData("henkoumaeIdoYMD", henkoumaeIdoYMD);
        this.setOriginalData("henkoumaeEdaNo", henkoumaeEdaNo);
        this.setOriginalData("henkougoTekiyoDate", henkougoTekiyoDate);
        this.setOriginalData("henkougoIdoYMD", henkougoIdoYMD);
        this.setOriginalData("henkougoEdaNo", henkougoEdaNo);
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokeDate = tekiyoTodokeDate;
        this.tekiyoJiyuCode = tekiyoJiyuCode;
        this.tekiyoJiyu = tekiyoJiyu;
        this.kayijoDate = kayijoDate;
        this.kaijoTodokeDate = kaijoTodokeDate;
        this.kaijoJiyuCode = kaijoJiyuCode;
        this.kaijoJiyu = kaijoJiyu;
        this.nyuShoDate = nyuShoDate;
        this.taiShoDate = taiShoDate;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.nyuShoShisetu = nyuShoShisetu;
        this.daichoShubetsu = daichoShubetsu;
        this.shisetsuShurui = shisetsuShurui;
        this.rirekiNo = rirekiNo;
        this.idoYMD = idoYMD;
        this.idoJiyuCode = idoJiyuCode;
        this.edaNo = edaNo;
        this.shichosonCode = shichosonCode;
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
        this.henkoTsuchiHakkoYMD = henkoTsuchiHakkoYMD;
        this.henkoumaeTekiyoDate = henkoumaeTekiyoDate;
        this.henkoumaeIdoYMD = henkoumaeIdoYMD;
        this.henkoumaeEdaNo = henkoumaeEdaNo;
        this.henkougoTekiyoDate = henkougoTekiyoDate;
        this.henkougoIdoYMD = henkougoIdoYMD;
        this.henkougoEdaNo = henkougoEdaNo;
    }

    public TextBoxDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxDate getTekiyoTodokeDate() {
        return tekiyoTodokeDate;
    }

    public RString getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    public RString getTekiyoJiyu() {
        return tekiyoJiyu;
    }

    public TextBoxDate getKayijoDate() {
        return kayijoDate;
    }

    public TextBoxDate getKaijoTodokeDate() {
        return kaijoTodokeDate;
    }

    public RString getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public TextBoxDate getNyuShoDate() {
        return nyuShoDate;
    }

    public TextBoxDate getTaiShoDate() {
        return taiShoDate;
    }

    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    public RString getNyuShoShisetu() {
        return nyuShoShisetu;
    }

    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    public RString getShisetsuShurui() {
        return shisetsuShurui;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getIdoYMD() {
        return idoYMD;
    }

    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    public RString getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    public RString getHenkoTsuchiHakkoYMD() {
        return henkoTsuchiHakkoYMD;
    }

    public RString getHenkoumaeTekiyoDate() {
        return henkoumaeTekiyoDate;
    }

    public RString getHenkoumaeIdoYMD() {
        return henkoumaeIdoYMD;
    }

    public RString getHenkoumaeEdaNo() {
        return henkoumaeEdaNo;
    }

    public RString getHenkougoTekiyoDate() {
        return henkougoTekiyoDate;
    }

    public RString getHenkougoIdoYMD() {
        return henkougoIdoYMD;
    }

    public RString getHenkougoEdaNo() {
        return henkougoEdaNo;
    }

    public void setTekiyoDate(TextBoxDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setTekiyoTodokeDate(TextBoxDate tekiyoTodokeDate) {
        this.setOriginalData("tekiyoTodokeDate", tekiyoTodokeDate);
        this.tekiyoTodokeDate = tekiyoTodokeDate;
    }

    public void setTekiyoJiyuCode(RString tekiyoJiyuCode) {
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.tekiyoJiyuCode = tekiyoJiyuCode;
    }

    public void setTekiyoJiyu(RString tekiyoJiyu) {
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.tekiyoJiyu = tekiyoJiyu;
    }

    public void setKayijoDate(TextBoxDate kayijoDate) {
        this.setOriginalData("kayijoDate", kayijoDate);
        this.kayijoDate = kayijoDate;
    }

    public void setKaijoTodokeDate(TextBoxDate kaijoTodokeDate) {
        this.setOriginalData("kaijoTodokeDate", kaijoTodokeDate);
        this.kaijoTodokeDate = kaijoTodokeDate;
    }

    public void setKaijoJiyuCode(RString kaijoJiyuCode) {
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.kaijoJiyuCode = kaijoJiyuCode;
    }

    public void setKaijoJiyu(RString kaijoJiyu) {
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.kaijoJiyu = kaijoJiyu;
    }

    public void setNyuShoDate(TextBoxDate nyuShoDate) {
        this.setOriginalData("nyuShoDate", nyuShoDate);
        this.nyuShoDate = nyuShoDate;
    }

    public void setTaiShoDate(TextBoxDate taiShoDate) {
        this.setOriginalData("taiShoDate", taiShoDate);
        this.taiShoDate = taiShoDate;
    }

    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    public void setNyuShoShisetu(RString nyuShoShisetu) {
        this.setOriginalData("nyuShoShisetu", nyuShoShisetu);
        this.nyuShoShisetu = nyuShoShisetu;
    }

    public void setDaichoShubetsu(RString daichoShubetsu) {
        this.setOriginalData("daichoShubetsu", daichoShubetsu);
        this.daichoShubetsu = daichoShubetsu;
    }

    public void setShisetsuShurui(RString shisetsuShurui) {
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.shisetsuShurui = shisetsuShurui;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setIdoYMD(RString idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
        this.idoJiyuCode = idoJiyuCode;
    }

    public void setEdaNo(RString edaNo) {
        this.setOriginalData("edaNo", edaNo);
        this.edaNo = edaNo;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setNyushoTsuchiHakkoYMD(RString nyushoTsuchiHakkoYMD) {
        this.setOriginalData("nyushoTsuchiHakkoYMD", nyushoTsuchiHakkoYMD);
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    public void setTaishoTsuchiHakkoYMD(RString taishoTsuchiHakkoYMD) {
        this.setOriginalData("taishoTsuchiHakkoYMD", taishoTsuchiHakkoYMD);
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

    public void setHenkoTsuchiHakkoYMD(RString henkoTsuchiHakkoYMD) {
        this.setOriginalData("henkoTsuchiHakkoYMD", henkoTsuchiHakkoYMD);
        this.henkoTsuchiHakkoYMD = henkoTsuchiHakkoYMD;
    }

    public void setHenkoumaeTekiyoDate(RString henkoumaeTekiyoDate) {
        this.setOriginalData("henkoumaeTekiyoDate", henkoumaeTekiyoDate);
        this.henkoumaeTekiyoDate = henkoumaeTekiyoDate;
    }

    public void setHenkoumaeIdoYMD(RString henkoumaeIdoYMD) {
        this.setOriginalData("henkoumaeIdoYMD", henkoumaeIdoYMD);
        this.henkoumaeIdoYMD = henkoumaeIdoYMD;
    }

    public void setHenkoumaeEdaNo(RString henkoumaeEdaNo) {
        this.setOriginalData("henkoumaeEdaNo", henkoumaeEdaNo);
        this.henkoumaeEdaNo = henkoumaeEdaNo;
    }

    public void setHenkougoTekiyoDate(RString henkougoTekiyoDate) {
        this.setOriginalData("henkougoTekiyoDate", henkougoTekiyoDate);
        this.henkougoTekiyoDate = henkougoTekiyoDate;
    }

    public void setHenkougoIdoYMD(RString henkougoIdoYMD) {
        this.setOriginalData("henkougoIdoYMD", henkougoIdoYMD);
        this.henkougoIdoYMD = henkougoIdoYMD;
    }

    public void setHenkougoEdaNo(RString henkougoEdaNo) {
        this.setOriginalData("henkougoEdaNo", henkougoEdaNo);
        this.henkougoEdaNo = henkougoEdaNo;
    }

    // </editor-fold>
}
