package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 16 15:18:34 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString shinsakaiJunjo;
    private RString hokenshaNo;
    private RString hokenshaMeisho;
    private RString hihokenshaNo;
    private RString shimei;
    private RString hihoKubun;
    private RString shinseiKubunShinseiji;
    private RString shinseiKubunLaw;
    private TextBoxFlexibleDate shinseiDay;
    private TextBoxFlexibleDate zenkaiYukoKikanShuryoDay;
    private RString zenkaiIchijiHantei;
    private RString konkaiIchijiHantei;
    private RString zenkaiNijiHantei;
    private RString konkaiNijiHantei;
    private RString hanteiKekka;
    private TextBoxFlexibleDate nijiHanteiDate;
    private RString tokuteiShippei;
    private RString jotaizo;
    private TextBoxFlexibleDate ninteiKikanKaishi;
    private TextBoxFlexibleDate ninteiKikanShuryo;
    private RString ninteiKikanTukisu;
    private Boolean shinsakaiMemo;
    private Boolean shinsakaiIken;
    private RString shinsakaiIkenShurui;
    private RString ichijiHanteiKekkaHenkoRiyu;
    private RString chosahyoNetakirido;
    private RString chosahyoNinchido;
    private RString ikenshoNetakirido;
    private RString ikenshoNinchido;
    private RString model;

    public dgTaishoshaIchiran_Row() {
        super();
        this.shinsakaiJunjo = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.hokenshaMeisho = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.hihoKubun = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.shinseiKubunLaw = RString.EMPTY;
        this.shinseiDay = new TextBoxFlexibleDate();
        this.zenkaiYukoKikanShuryoDay = new TextBoxFlexibleDate();
        this.zenkaiIchijiHantei = RString.EMPTY;
        this.konkaiIchijiHantei = RString.EMPTY;
        this.zenkaiNijiHantei = RString.EMPTY;
        this.konkaiNijiHantei = RString.EMPTY;
        this.hanteiKekka = RString.EMPTY;
        this.nijiHanteiDate = new TextBoxFlexibleDate();
        this.tokuteiShippei = RString.EMPTY;
        this.jotaizo = RString.EMPTY;
        this.ninteiKikanKaishi = new TextBoxFlexibleDate();
        this.ninteiKikanShuryo = new TextBoxFlexibleDate();
        this.ninteiKikanTukisu = RString.EMPTY;
        this.shinsakaiMemo = false;
        this.shinsakaiIken = false;
        this.shinsakaiIkenShurui = RString.EMPTY;
        this.ichijiHanteiKekkaHenkoRiyu = RString.EMPTY;
        this.chosahyoNetakirido = RString.EMPTY;
        this.chosahyoNinchido = RString.EMPTY;
        this.ikenshoNetakirido = RString.EMPTY;
        this.ikenshoNinchido = RString.EMPTY;
        this.model = RString.EMPTY;
        this.setOriginalData("shinsakaiJunjo", shinsakaiJunjo);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("hihoKubun", hihoKubun);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseiKubunLaw", shinseiKubunLaw);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.setOriginalData("konkaiNijiHantei", konkaiNijiHantei);
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.setOriginalData("nijiHanteiDate", nijiHanteiDate);
        this.setOriginalData("tokuteiShippei", tokuteiShippei);
        this.setOriginalData("jotaizo", jotaizo);
        this.setOriginalData("ninteiKikanKaishi", ninteiKikanKaishi);
        this.setOriginalData("ninteiKikanShuryo", ninteiKikanShuryo);
        this.setOriginalData("ninteiKikanTukisu", ninteiKikanTukisu);
        this.setOriginalData("shinsakaiMemo", shinsakaiMemo);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.setOriginalData("shinsakaiIkenShurui", shinsakaiIkenShurui);
        this.setOriginalData("ichijiHanteiKekkaHenkoRiyu", ichijiHanteiKekkaHenkoRiyu);
        this.setOriginalData("chosahyoNetakirido", chosahyoNetakirido);
        this.setOriginalData("chosahyoNinchido", chosahyoNinchido);
        this.setOriginalData("ikenshoNetakirido", ikenshoNetakirido);
        this.setOriginalData("ikenshoNinchido", ikenshoNinchido);
        this.setOriginalData("model", model);
    }

    public dgTaishoshaIchiran_Row(RString shinsakaiJunjo, RString hokenshaNo, RString hokenshaMeisho, RString hihokenshaNo, RString shimei, RString hihoKubun, RString shinseiKubunShinseiji, RString shinseiKubunLaw, TextBoxFlexibleDate shinseiDay, TextBoxFlexibleDate zenkaiYukoKikanShuryoDay, RString zenkaiIchijiHantei, RString konkaiIchijiHantei, RString zenkaiNijiHantei, RString konkaiNijiHantei, RString hanteiKekka, TextBoxFlexibleDate nijiHanteiDate, RString tokuteiShippei, RString jotaizo, TextBoxFlexibleDate ninteiKikanKaishi, TextBoxFlexibleDate ninteiKikanShuryo, RString ninteiKikanTukisu, Boolean shinsakaiMemo, Boolean shinsakaiIken, RString shinsakaiIkenShurui, RString ichijiHanteiKekkaHenkoRiyu, RString chosahyoNetakirido, RString chosahyoNinchido, RString ikenshoNetakirido, RString ikenshoNinchido, RString model) {
        super();
        this.setOriginalData("shinsakaiJunjo", shinsakaiJunjo);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("hihoKubun", hihoKubun);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseiKubunLaw", shinseiKubunLaw);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.setOriginalData("konkaiNijiHantei", konkaiNijiHantei);
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.setOriginalData("nijiHanteiDate", nijiHanteiDate);
        this.setOriginalData("tokuteiShippei", tokuteiShippei);
        this.setOriginalData("jotaizo", jotaizo);
        this.setOriginalData("ninteiKikanKaishi", ninteiKikanKaishi);
        this.setOriginalData("ninteiKikanShuryo", ninteiKikanShuryo);
        this.setOriginalData("ninteiKikanTukisu", ninteiKikanTukisu);
        this.setOriginalData("shinsakaiMemo", shinsakaiMemo);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.setOriginalData("shinsakaiIkenShurui", shinsakaiIkenShurui);
        this.setOriginalData("ichijiHanteiKekkaHenkoRiyu", ichijiHanteiKekkaHenkoRiyu);
        this.setOriginalData("chosahyoNetakirido", chosahyoNetakirido);
        this.setOriginalData("chosahyoNinchido", chosahyoNinchido);
        this.setOriginalData("ikenshoNetakirido", ikenshoNetakirido);
        this.setOriginalData("ikenshoNinchido", ikenshoNinchido);
        this.setOriginalData("model", model);
        this.shinsakaiJunjo = shinsakaiJunjo;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaMeisho = hokenshaMeisho;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.hihoKubun = hihoKubun;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.shinseiKubunLaw = shinseiKubunLaw;
        this.shinseiDay = shinseiDay;
        this.zenkaiYukoKikanShuryoDay = zenkaiYukoKikanShuryoDay;
        this.zenkaiIchijiHantei = zenkaiIchijiHantei;
        this.konkaiIchijiHantei = konkaiIchijiHantei;
        this.zenkaiNijiHantei = zenkaiNijiHantei;
        this.konkaiNijiHantei = konkaiNijiHantei;
        this.hanteiKekka = hanteiKekka;
        this.nijiHanteiDate = nijiHanteiDate;
        this.tokuteiShippei = tokuteiShippei;
        this.jotaizo = jotaizo;
        this.ninteiKikanKaishi = ninteiKikanKaishi;
        this.ninteiKikanShuryo = ninteiKikanShuryo;
        this.ninteiKikanTukisu = ninteiKikanTukisu;
        this.shinsakaiMemo = shinsakaiMemo;
        this.shinsakaiIken = shinsakaiIken;
        this.shinsakaiIkenShurui = shinsakaiIkenShurui;
        this.ichijiHanteiKekkaHenkoRiyu = ichijiHanteiKekkaHenkoRiyu;
        this.chosahyoNetakirido = chosahyoNetakirido;
        this.chosahyoNinchido = chosahyoNinchido;
        this.ikenshoNetakirido = ikenshoNetakirido;
        this.ikenshoNinchido = ikenshoNinchido;
        this.model = model;
    }

    public RString getShinsakaiJunjo() {
        return shinsakaiJunjo;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getHihoKubun() {
        return hihoKubun;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getShinseiKubunLaw() {
        return shinseiKubunLaw;
    }

    public TextBoxFlexibleDate getShinseiDay() {
        return shinseiDay;
    }

    public TextBoxFlexibleDate getZenkaiYukoKikanShuryoDay() {
        return zenkaiYukoKikanShuryoDay;
    }

    public RString getZenkaiIchijiHantei() {
        return zenkaiIchijiHantei;
    }

    public RString getKonkaiIchijiHantei() {
        return konkaiIchijiHantei;
    }

    public RString getZenkaiNijiHantei() {
        return zenkaiNijiHantei;
    }

    public RString getKonkaiNijiHantei() {
        return konkaiNijiHantei;
    }

    public RString getHanteiKekka() {
        return hanteiKekka;
    }

    public TextBoxFlexibleDate getNijiHanteiDate() {
        return nijiHanteiDate;
    }

    public RString getTokuteiShippei() {
        return tokuteiShippei;
    }

    public RString getJotaizo() {
        return jotaizo;
    }

    public TextBoxFlexibleDate getNinteiKikanKaishi() {
        return ninteiKikanKaishi;
    }

    public TextBoxFlexibleDate getNinteiKikanShuryo() {
        return ninteiKikanShuryo;
    }

    public RString getNinteiKikanTukisu() {
        return ninteiKikanTukisu;
    }

    public Boolean getShinsakaiMemo() {
        return shinsakaiMemo;
    }

    public Boolean getShinsakaiIken() {
        return shinsakaiIken;
    }

    public RString getShinsakaiIkenShurui() {
        return shinsakaiIkenShurui;
    }

    public RString getIchijiHanteiKekkaHenkoRiyu() {
        return ichijiHanteiKekkaHenkoRiyu;
    }

    public RString getChosahyoNetakirido() {
        return chosahyoNetakirido;
    }

    public RString getChosahyoNinchido() {
        return chosahyoNinchido;
    }

    public RString getIkenshoNetakirido() {
        return ikenshoNetakirido;
    }

    public RString getIkenshoNinchido() {
        return ikenshoNinchido;
    }

    public RString getModel() {
        return model;
    }

    public void setShinsakaiJunjo(RString shinsakaiJunjo) {
        this.setOriginalData("shinsakaiJunjo", shinsakaiJunjo);
        this.shinsakaiJunjo = shinsakaiJunjo;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.hokenshaMeisho = hokenshaMeisho;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setHihoKubun(RString hihoKubun) {
        this.setOriginalData("hihoKubun", hihoKubun);
        this.hihoKubun = hihoKubun;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setShinseiKubunLaw(RString shinseiKubunLaw) {
        this.setOriginalData("shinseiKubunLaw", shinseiKubunLaw);
        this.shinseiKubunLaw = shinseiKubunLaw;
    }

    public void setShinseiDay(TextBoxFlexibleDate shinseiDay) {
        this.setOriginalData("shinseiDay", shinseiDay);
        this.shinseiDay = shinseiDay;
    }

    public void setZenkaiYukoKikanShuryoDay(TextBoxFlexibleDate zenkaiYukoKikanShuryoDay) {
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.zenkaiYukoKikanShuryoDay = zenkaiYukoKikanShuryoDay;
    }

    public void setZenkaiIchijiHantei(RString zenkaiIchijiHantei) {
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.zenkaiIchijiHantei = zenkaiIchijiHantei;
    }

    public void setKonkaiIchijiHantei(RString konkaiIchijiHantei) {
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.konkaiIchijiHantei = konkaiIchijiHantei;
    }

    public void setZenkaiNijiHantei(RString zenkaiNijiHantei) {
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.zenkaiNijiHantei = zenkaiNijiHantei;
    }

    public void setKonkaiNijiHantei(RString konkaiNijiHantei) {
        this.setOriginalData("konkaiNijiHantei", konkaiNijiHantei);
        this.konkaiNijiHantei = konkaiNijiHantei;
    }

    public void setHanteiKekka(RString hanteiKekka) {
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.hanteiKekka = hanteiKekka;
    }

    public void setNijiHanteiDate(TextBoxFlexibleDate nijiHanteiDate) {
        this.setOriginalData("nijiHanteiDate", nijiHanteiDate);
        this.nijiHanteiDate = nijiHanteiDate;
    }

    public void setTokuteiShippei(RString tokuteiShippei) {
        this.setOriginalData("tokuteiShippei", tokuteiShippei);
        this.tokuteiShippei = tokuteiShippei;
    }

    public void setJotaizo(RString jotaizo) {
        this.setOriginalData("jotaizo", jotaizo);
        this.jotaizo = jotaizo;
    }

    public void setNinteiKikanKaishi(TextBoxFlexibleDate ninteiKikanKaishi) {
        this.setOriginalData("ninteiKikanKaishi", ninteiKikanKaishi);
        this.ninteiKikanKaishi = ninteiKikanKaishi;
    }

    public void setNinteiKikanShuryo(TextBoxFlexibleDate ninteiKikanShuryo) {
        this.setOriginalData("ninteiKikanShuryo", ninteiKikanShuryo);
        this.ninteiKikanShuryo = ninteiKikanShuryo;
    }

    public void setNinteiKikanTukisu(RString ninteiKikanTukisu) {
        this.setOriginalData("ninteiKikanTukisu", ninteiKikanTukisu);
        this.ninteiKikanTukisu = ninteiKikanTukisu;
    }

    public void setShinsakaiMemo(Boolean shinsakaiMemo) {
        this.setOriginalData("shinsakaiMemo", shinsakaiMemo);
        this.shinsakaiMemo = shinsakaiMemo;
    }

    public void setShinsakaiIken(Boolean shinsakaiIken) {
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.shinsakaiIken = shinsakaiIken;
    }

    public void setShinsakaiIkenShurui(RString shinsakaiIkenShurui) {
        this.setOriginalData("shinsakaiIkenShurui", shinsakaiIkenShurui);
        this.shinsakaiIkenShurui = shinsakaiIkenShurui;
    }

    public void setIchijiHanteiKekkaHenkoRiyu(RString ichijiHanteiKekkaHenkoRiyu) {
        this.setOriginalData("ichijiHanteiKekkaHenkoRiyu", ichijiHanteiKekkaHenkoRiyu);
        this.ichijiHanteiKekkaHenkoRiyu = ichijiHanteiKekkaHenkoRiyu;
    }

    public void setChosahyoNetakirido(RString chosahyoNetakirido) {
        this.setOriginalData("chosahyoNetakirido", chosahyoNetakirido);
        this.chosahyoNetakirido = chosahyoNetakirido;
    }

    public void setChosahyoNinchido(RString chosahyoNinchido) {
        this.setOriginalData("chosahyoNinchido", chosahyoNinchido);
        this.chosahyoNinchido = chosahyoNinchido;
    }

    public void setIkenshoNetakirido(RString ikenshoNetakirido) {
        this.setOriginalData("ikenshoNetakirido", ikenshoNetakirido);
        this.ikenshoNetakirido = ikenshoNetakirido;
    }

    public void setIkenshoNinchido(RString ikenshoNinchido) {
        this.setOriginalData("ikenshoNinchido", ikenshoNinchido);
        this.ikenshoNinchido = ikenshoNinchido;
    }

    public void setModel(RString model) {
        this.setOriginalData("model", model);
        this.model = model;
    }

    // </editor-fold>
}
