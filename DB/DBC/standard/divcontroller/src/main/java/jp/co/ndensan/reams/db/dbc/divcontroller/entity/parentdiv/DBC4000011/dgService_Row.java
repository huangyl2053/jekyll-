package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Sep 19 15:52:36 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgService_Row のクラスファイル
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class dgService_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString serviceCd;
    private RString teikyoKaishiYM;
    private RString teikyoShuryoYM;
    private RString serviceName;
    private RString serviceNameRyaku;
    private RString taniSu;
    private RString tanisuShikibetsu;
    private RString tanisuSanteiTani;
    private RString idouJiyu;
    private RString gendogakuTaishogai;
    private RString gaibuServiceRiyoKata;
    private RString tokubetsuChiikiKasan;
    private RString serviceShuruiCd;
    private RString serviceKoumokuCd;
    private RString rirekiNo;
    private RString tanisuShikibetsuCode;
    private RString tanisuSanteiTaniCode;
    private RString idouJiyuCode;
    private RString gendogakuTaishogaiFlag;
    private RString gaibuServiceRiyoKataKubun;
    private RString tokubetsuChiikiKasanFlag;
    private RString riyosyaFutanTeiritsuTeigakuKubun;
    private RString riyoshaFutanGaku;
    private RString kyufuRitsu;
    private RString nijiyoboJigyoTaishaJishiKubunHigaito;
    private RString yoshien1JukyushaJishiKubun;
    private RString yoshien2JukyushaJishiKubun;
    private TextBoxFlexibleDate teikyoKaishiKey;
    private RString serviceBunrruicode;
    private RString serviceShoBunrui;

    public dgService_Row() {
        super();
        this.serviceCd = RString.EMPTY;
        this.teikyoKaishiYM = RString.EMPTY;
        this.teikyoShuryoYM = RString.EMPTY;
        this.serviceName = RString.EMPTY;
        this.serviceNameRyaku = RString.EMPTY;
        this.taniSu = RString.EMPTY;
        this.tanisuShikibetsu = RString.EMPTY;
        this.tanisuSanteiTani = RString.EMPTY;
        this.idouJiyu = RString.EMPTY;
        this.gendogakuTaishogai = RString.EMPTY;
        this.gaibuServiceRiyoKata = RString.EMPTY;
        this.tokubetsuChiikiKasan = RString.EMPTY;
        this.serviceShuruiCd = RString.EMPTY;
        this.serviceKoumokuCd = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.tanisuShikibetsuCode = RString.EMPTY;
        this.tanisuSanteiTaniCode = RString.EMPTY;
        this.idouJiyuCode = RString.EMPTY;
        this.gendogakuTaishogaiFlag = RString.EMPTY;
        this.gaibuServiceRiyoKataKubun = RString.EMPTY;
        this.tokubetsuChiikiKasanFlag = RString.EMPTY;
        this.riyosyaFutanTeiritsuTeigakuKubun = RString.EMPTY;
        this.riyoshaFutanGaku = RString.EMPTY;
        this.kyufuRitsu = RString.EMPTY;
        this.nijiyoboJigyoTaishaJishiKubunHigaito = RString.EMPTY;
        this.yoshien1JukyushaJishiKubun = RString.EMPTY;
        this.yoshien2JukyushaJishiKubun = RString.EMPTY;
        this.teikyoKaishiKey = new TextBoxFlexibleDate();
        this.serviceBunrruicode = RString.EMPTY;
        this.serviceShoBunrui = RString.EMPTY;
        this.setOriginalData("serviceCd", serviceCd);
        this.setOriginalData("teikyoKaishiYM", teikyoKaishiYM);
        this.setOriginalData("teikyoShuryoYM", teikyoShuryoYM);
        this.setOriginalData("serviceName", serviceName);
        this.setOriginalData("serviceNameRyaku", serviceNameRyaku);
        this.setOriginalData("taniSu", taniSu);
        this.setOriginalData("tanisuShikibetsu", tanisuShikibetsu);
        this.setOriginalData("tanisuSanteiTani", tanisuSanteiTani);
        this.setOriginalData("idouJiyu", idouJiyu);
        this.setOriginalData("gendogakuTaishogai", gendogakuTaishogai);
        this.setOriginalData("gaibuServiceRiyoKata", gaibuServiceRiyoKata);
        this.setOriginalData("tokubetsuChiikiKasan", tokubetsuChiikiKasan);
        this.setOriginalData("serviceShuruiCd", serviceShuruiCd);
        this.setOriginalData("serviceKoumokuCd", serviceKoumokuCd);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("tanisuShikibetsuCode", tanisuShikibetsuCode);
        this.setOriginalData("tanisuSanteiTaniCode", tanisuSanteiTaniCode);
        this.setOriginalData("idouJiyuCode", idouJiyuCode);
        this.setOriginalData("gendogakuTaishogaiFlag", gendogakuTaishogaiFlag);
        this.setOriginalData("gaibuServiceRiyoKataKubun", gaibuServiceRiyoKataKubun);
        this.setOriginalData("tokubetsuChiikiKasanFlag", tokubetsuChiikiKasanFlag);
        this.setOriginalData("riyosyaFutanTeiritsuTeigakuKubun", riyosyaFutanTeiritsuTeigakuKubun);
        this.setOriginalData("riyoshaFutanGaku", riyoshaFutanGaku);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("nijiyoboJigyoTaishaJishiKubunHigaito", nijiyoboJigyoTaishaJishiKubunHigaito);
        this.setOriginalData("yoshien1JukyushaJishiKubun", yoshien1JukyushaJishiKubun);
        this.setOriginalData("yoshien2JukyushaJishiKubun", yoshien2JukyushaJishiKubun);
        this.setOriginalData("teikyoKaishiKey", teikyoKaishiKey);
        this.setOriginalData("serviceBunrruicode", serviceBunrruicode);
        this.setOriginalData("serviceShoBunrui", serviceShoBunrui);
    }

    public dgService_Row(RString serviceCd, RString teikyoKaishiYM, RString teikyoShuryoYM, RString serviceName, RString serviceNameRyaku, RString taniSu, RString tanisuShikibetsu, RString tanisuSanteiTani, RString idouJiyu, RString gendogakuTaishogai, RString gaibuServiceRiyoKata, RString tokubetsuChiikiKasan, RString serviceShuruiCd, RString serviceKoumokuCd, RString rirekiNo, RString tanisuShikibetsuCode, RString tanisuSanteiTaniCode, RString idouJiyuCode, RString gendogakuTaishogaiFlag, RString gaibuServiceRiyoKataKubun, RString tokubetsuChiikiKasanFlag, RString riyosyaFutanTeiritsuTeigakuKubun, RString riyoshaFutanGaku, RString kyufuRitsu, RString nijiyoboJigyoTaishaJishiKubunHigaito, RString yoshien1JukyushaJishiKubun, RString yoshien2JukyushaJishiKubun, TextBoxFlexibleDate teikyoKaishiKey, RString serviceBunrruicode, RString serviceShoBunrui) {
        super();
        this.setOriginalData("serviceCd", serviceCd);
        this.setOriginalData("teikyoKaishiYM", teikyoKaishiYM);
        this.setOriginalData("teikyoShuryoYM", teikyoShuryoYM);
        this.setOriginalData("serviceName", serviceName);
        this.setOriginalData("serviceNameRyaku", serviceNameRyaku);
        this.setOriginalData("taniSu", taniSu);
        this.setOriginalData("tanisuShikibetsu", tanisuShikibetsu);
        this.setOriginalData("tanisuSanteiTani", tanisuSanteiTani);
        this.setOriginalData("idouJiyu", idouJiyu);
        this.setOriginalData("gendogakuTaishogai", gendogakuTaishogai);
        this.setOriginalData("gaibuServiceRiyoKata", gaibuServiceRiyoKata);
        this.setOriginalData("tokubetsuChiikiKasan", tokubetsuChiikiKasan);
        this.setOriginalData("serviceShuruiCd", serviceShuruiCd);
        this.setOriginalData("serviceKoumokuCd", serviceKoumokuCd);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("tanisuShikibetsuCode", tanisuShikibetsuCode);
        this.setOriginalData("tanisuSanteiTaniCode", tanisuSanteiTaniCode);
        this.setOriginalData("idouJiyuCode", idouJiyuCode);
        this.setOriginalData("gendogakuTaishogaiFlag", gendogakuTaishogaiFlag);
        this.setOriginalData("gaibuServiceRiyoKataKubun", gaibuServiceRiyoKataKubun);
        this.setOriginalData("tokubetsuChiikiKasanFlag", tokubetsuChiikiKasanFlag);
        this.setOriginalData("riyosyaFutanTeiritsuTeigakuKubun", riyosyaFutanTeiritsuTeigakuKubun);
        this.setOriginalData("riyoshaFutanGaku", riyoshaFutanGaku);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("nijiyoboJigyoTaishaJishiKubunHigaito", nijiyoboJigyoTaishaJishiKubunHigaito);
        this.setOriginalData("yoshien1JukyushaJishiKubun", yoshien1JukyushaJishiKubun);
        this.setOriginalData("yoshien2JukyushaJishiKubun", yoshien2JukyushaJishiKubun);
        this.setOriginalData("teikyoKaishiKey", teikyoKaishiKey);
        this.setOriginalData("serviceBunrruicode", serviceBunrruicode);
        this.setOriginalData("serviceShoBunrui", serviceShoBunrui);
        this.serviceCd = serviceCd;
        this.teikyoKaishiYM = teikyoKaishiYM;
        this.teikyoShuryoYM = teikyoShuryoYM;
        this.serviceName = serviceName;
        this.serviceNameRyaku = serviceNameRyaku;
        this.taniSu = taniSu;
        this.tanisuShikibetsu = tanisuShikibetsu;
        this.tanisuSanteiTani = tanisuSanteiTani;
        this.idouJiyu = idouJiyu;
        this.gendogakuTaishogai = gendogakuTaishogai;
        this.gaibuServiceRiyoKata = gaibuServiceRiyoKata;
        this.tokubetsuChiikiKasan = tokubetsuChiikiKasan;
        this.serviceShuruiCd = serviceShuruiCd;
        this.serviceKoumokuCd = serviceKoumokuCd;
        this.rirekiNo = rirekiNo;
        this.tanisuShikibetsuCode = tanisuShikibetsuCode;
        this.tanisuSanteiTaniCode = tanisuSanteiTaniCode;
        this.idouJiyuCode = idouJiyuCode;
        this.gendogakuTaishogaiFlag = gendogakuTaishogaiFlag;
        this.gaibuServiceRiyoKataKubun = gaibuServiceRiyoKataKubun;
        this.tokubetsuChiikiKasanFlag = tokubetsuChiikiKasanFlag;
        this.riyosyaFutanTeiritsuTeigakuKubun = riyosyaFutanTeiritsuTeigakuKubun;
        this.riyoshaFutanGaku = riyoshaFutanGaku;
        this.kyufuRitsu = kyufuRitsu;
        this.nijiyoboJigyoTaishaJishiKubunHigaito = nijiyoboJigyoTaishaJishiKubunHigaito;
        this.yoshien1JukyushaJishiKubun = yoshien1JukyushaJishiKubun;
        this.yoshien2JukyushaJishiKubun = yoshien2JukyushaJishiKubun;
        this.teikyoKaishiKey = teikyoKaishiKey;
        this.serviceBunrruicode = serviceBunrruicode;
        this.serviceShoBunrui = serviceShoBunrui;
    }

    public RString getServiceCd() {
        return serviceCd;
    }

    public RString getTeikyoKaishiYM() {
        return teikyoKaishiYM;
    }

    public RString getTeikyoShuryoYM() {
        return teikyoShuryoYM;
    }

    public RString getServiceName() {
        return serviceName;
    }

    public RString getServiceNameRyaku() {
        return serviceNameRyaku;
    }

    public RString getTaniSu() {
        return taniSu;
    }

    public RString getTanisuShikibetsu() {
        return tanisuShikibetsu;
    }

    public RString getTanisuSanteiTani() {
        return tanisuSanteiTani;
    }

    public RString getIdouJiyu() {
        return idouJiyu;
    }

    public RString getGendogakuTaishogai() {
        return gendogakuTaishogai;
    }

    public RString getGaibuServiceRiyoKata() {
        return gaibuServiceRiyoKata;
    }

    public RString getTokubetsuChiikiKasan() {
        return tokubetsuChiikiKasan;
    }

    public RString getServiceShuruiCd() {
        return serviceShuruiCd;
    }

    public RString getServiceKoumokuCd() {
        return serviceKoumokuCd;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getTanisuShikibetsuCode() {
        return tanisuShikibetsuCode;
    }

    public RString getTanisuSanteiTaniCode() {
        return tanisuSanteiTaniCode;
    }

    public RString getIdouJiyuCode() {
        return idouJiyuCode;
    }

    public RString getGendogakuTaishogaiFlag() {
        return gendogakuTaishogaiFlag;
    }

    public RString getGaibuServiceRiyoKataKubun() {
        return gaibuServiceRiyoKataKubun;
    }

    public RString getTokubetsuChiikiKasanFlag() {
        return tokubetsuChiikiKasanFlag;
    }

    public RString getRiyosyaFutanTeiritsuTeigakuKubun() {
        return riyosyaFutanTeiritsuTeigakuKubun;
    }

    public RString getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    public RString getKyufuRitsu() {
        return kyufuRitsu;
    }

    public RString getNijiyoboJigyoTaishaJishiKubunHigaito() {
        return nijiyoboJigyoTaishaJishiKubunHigaito;
    }

    public RString getYoshien1JukyushaJishiKubun() {
        return yoshien1JukyushaJishiKubun;
    }

    public RString getYoshien2JukyushaJishiKubun() {
        return yoshien2JukyushaJishiKubun;
    }

    public TextBoxFlexibleDate getTeikyoKaishiKey() {
        return teikyoKaishiKey;
    }

    public RString getServiceBunrruicode() {
        return serviceBunrruicode;
    }

    public RString getServiceShoBunrui() {
        return serviceShoBunrui;
    }

    public void setServiceCd(RString serviceCd) {
        this.setOriginalData("serviceCd", serviceCd);
        this.serviceCd = serviceCd;
    }

    public void setTeikyoKaishiYM(RString teikyoKaishiYM) {
        this.setOriginalData("teikyoKaishiYM", teikyoKaishiYM);
        this.teikyoKaishiYM = teikyoKaishiYM;
    }

    public void setTeikyoShuryoYM(RString teikyoShuryoYM) {
        this.setOriginalData("teikyoShuryoYM", teikyoShuryoYM);
        this.teikyoShuryoYM = teikyoShuryoYM;
    }

    public void setServiceName(RString serviceName) {
        this.setOriginalData("serviceName", serviceName);
        this.serviceName = serviceName;
    }

    public void setServiceNameRyaku(RString serviceNameRyaku) {
        this.setOriginalData("serviceNameRyaku", serviceNameRyaku);
        this.serviceNameRyaku = serviceNameRyaku;
    }

    public void setTaniSu(RString taniSu) {
        this.setOriginalData("taniSu", taniSu);
        this.taniSu = taniSu;
    }

    public void setTanisuShikibetsu(RString tanisuShikibetsu) {
        this.setOriginalData("tanisuShikibetsu", tanisuShikibetsu);
        this.tanisuShikibetsu = tanisuShikibetsu;
    }

    public void setTanisuSanteiTani(RString tanisuSanteiTani) {
        this.setOriginalData("tanisuSanteiTani", tanisuSanteiTani);
        this.tanisuSanteiTani = tanisuSanteiTani;
    }

    public void setIdouJiyu(RString idouJiyu) {
        this.setOriginalData("idouJiyu", idouJiyu);
        this.idouJiyu = idouJiyu;
    }

    public void setGendogakuTaishogai(RString gendogakuTaishogai) {
        this.setOriginalData("gendogakuTaishogai", gendogakuTaishogai);
        this.gendogakuTaishogai = gendogakuTaishogai;
    }

    public void setGaibuServiceRiyoKata(RString gaibuServiceRiyoKata) {
        this.setOriginalData("gaibuServiceRiyoKata", gaibuServiceRiyoKata);
        this.gaibuServiceRiyoKata = gaibuServiceRiyoKata;
    }

    public void setTokubetsuChiikiKasan(RString tokubetsuChiikiKasan) {
        this.setOriginalData("tokubetsuChiikiKasan", tokubetsuChiikiKasan);
        this.tokubetsuChiikiKasan = tokubetsuChiikiKasan;
    }

    public void setServiceShuruiCd(RString serviceShuruiCd) {
        this.setOriginalData("serviceShuruiCd", serviceShuruiCd);
        this.serviceShuruiCd = serviceShuruiCd;
    }

    public void setServiceKoumokuCd(RString serviceKoumokuCd) {
        this.setOriginalData("serviceKoumokuCd", serviceKoumokuCd);
        this.serviceKoumokuCd = serviceKoumokuCd;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setTanisuShikibetsuCode(RString tanisuShikibetsuCode) {
        this.setOriginalData("tanisuShikibetsuCode", tanisuShikibetsuCode);
        this.tanisuShikibetsuCode = tanisuShikibetsuCode;
    }

    public void setTanisuSanteiTaniCode(RString tanisuSanteiTaniCode) {
        this.setOriginalData("tanisuSanteiTaniCode", tanisuSanteiTaniCode);
        this.tanisuSanteiTaniCode = tanisuSanteiTaniCode;
    }

    public void setIdouJiyuCode(RString idouJiyuCode) {
        this.setOriginalData("idouJiyuCode", idouJiyuCode);
        this.idouJiyuCode = idouJiyuCode;
    }

    public void setGendogakuTaishogaiFlag(RString gendogakuTaishogaiFlag) {
        this.setOriginalData("gendogakuTaishogaiFlag", gendogakuTaishogaiFlag);
        this.gendogakuTaishogaiFlag = gendogakuTaishogaiFlag;
    }

    public void setGaibuServiceRiyoKataKubun(RString gaibuServiceRiyoKataKubun) {
        this.setOriginalData("gaibuServiceRiyoKataKubun", gaibuServiceRiyoKataKubun);
        this.gaibuServiceRiyoKataKubun = gaibuServiceRiyoKataKubun;
    }

    public void setTokubetsuChiikiKasanFlag(RString tokubetsuChiikiKasanFlag) {
        this.setOriginalData("tokubetsuChiikiKasanFlag", tokubetsuChiikiKasanFlag);
        this.tokubetsuChiikiKasanFlag = tokubetsuChiikiKasanFlag;
    }

    public void setRiyosyaFutanTeiritsuTeigakuKubun(RString riyosyaFutanTeiritsuTeigakuKubun) {
        this.setOriginalData("riyosyaFutanTeiritsuTeigakuKubun", riyosyaFutanTeiritsuTeigakuKubun);
        this.riyosyaFutanTeiritsuTeigakuKubun = riyosyaFutanTeiritsuTeigakuKubun;
    }

    public void setRiyoshaFutanGaku(RString riyoshaFutanGaku) {
        this.setOriginalData("riyoshaFutanGaku", riyoshaFutanGaku);
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    public void setKyufuRitsu(RString kyufuRitsu) {
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.kyufuRitsu = kyufuRitsu;
    }

    public void setNijiyoboJigyoTaishaJishiKubunHigaito(RString nijiyoboJigyoTaishaJishiKubunHigaito) {
        this.setOriginalData("nijiyoboJigyoTaishaJishiKubunHigaito", nijiyoboJigyoTaishaJishiKubunHigaito);
        this.nijiyoboJigyoTaishaJishiKubunHigaito = nijiyoboJigyoTaishaJishiKubunHigaito;
    }

    public void setYoshien1JukyushaJishiKubun(RString yoshien1JukyushaJishiKubun) {
        this.setOriginalData("yoshien1JukyushaJishiKubun", yoshien1JukyushaJishiKubun);
        this.yoshien1JukyushaJishiKubun = yoshien1JukyushaJishiKubun;
    }

    public void setYoshien2JukyushaJishiKubun(RString yoshien2JukyushaJishiKubun) {
        this.setOriginalData("yoshien2JukyushaJishiKubun", yoshien2JukyushaJishiKubun);
        this.yoshien2JukyushaJishiKubun = yoshien2JukyushaJishiKubun;
    }

    public void setTeikyoKaishiKey(TextBoxFlexibleDate teikyoKaishiKey) {
        this.setOriginalData("teikyoKaishiKey", teikyoKaishiKey);
        this.teikyoKaishiKey = teikyoKaishiKey;
    }

    public void setServiceBunrruicode(RString serviceBunrruicode) {
        this.setOriginalData("serviceBunrruicode", serviceBunrruicode);
        this.serviceBunrruicode = serviceBunrruicode;
    }

    public void setServiceShoBunrui(RString serviceShoBunrui) {
        this.setOriginalData("serviceShoBunrui", serviceShoBunrui);
        this.serviceShoBunrui = serviceShoBunrui;
    }

    // </editor-fold>
}
