package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Feb 28 16:46:17 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.Icon;


/**
 * dgTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">

    private RString jotaiFlag;
    private RString shinsajunKakuteiFlag;
    private RString shinseishoKanriNo;
    private RString no;
    private RString priority;
    private RString hihokenshaNumber;
    private RString shimei;
    private RString seibetsu;
    private RString hihokenshaKubun;
    private RString sihinseiKubunShinseiji;
    private TextBoxFlexibleDate shinseiDay;
    private TextBoxFlexibleDate zenkaiYukoKikanKaishiDay;
    private TextBoxFlexibleDate zenkaiYukoKikanShuryoDay;
    private TextBoxFlexibleDate shinsakaiShiryoSakuseiYMD;
    private RString konkaiIchijiHantei;
    private RString masking;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString zenkaiIchijiHantei;
    private RString zenkaiNijiHantei;
    private RString chosahyoNetakirido;
    private RString chosahyoNinchido;
    private RString ikenshoNetakirido;
    private RString ikenshoNinchido;
    private RString nyushiShisetsu;
    private RString chosaKikan;
    private RString chosain;
    private RString saiChosa;
    private RString iryoKikan;
    private RString shujii;
    private Icon observerCheckShujii;
    private Icon observerCheckChosain;
    private Icon observerCheckNyushoShisetsu;
    private Icon observerCheckSonota;
    private Boolean torokuZumiFlag;
    private RString torokuZumiNo;
    private RString ninteiShinsakaiWariateKanryoYMD;
    private TextBoxFlexibleDate shinsakaiShiryoSofuYMD;

    public dgTaishoshaIchiran_Row() {
        super();
        this.jotaiFlag = RString.EMPTY;
        this.shinsajunKakuteiFlag = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.no = RString.EMPTY;
        this.priority = RString.EMPTY;
        this.hihokenshaNumber = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.hihokenshaKubun = RString.EMPTY;
        this.sihinseiKubunShinseiji = RString.EMPTY;
        this.shinseiDay = new TextBoxFlexibleDate();
        this.zenkaiYukoKikanKaishiDay = new TextBoxFlexibleDate();
        this.zenkaiYukoKikanShuryoDay = new TextBoxFlexibleDate();
        this.shinsakaiShiryoSakuseiYMD = new TextBoxFlexibleDate();
        this.konkaiIchijiHantei = RString.EMPTY;
        this.masking = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.zenkaiIchijiHantei = RString.EMPTY;
        this.zenkaiNijiHantei = RString.EMPTY;
        this.chosahyoNetakirido = RString.EMPTY;
        this.chosahyoNinchido = RString.EMPTY;
        this.ikenshoNetakirido = RString.EMPTY;
        this.ikenshoNinchido = RString.EMPTY;
        this.nyushiShisetsu = RString.EMPTY;
        this.chosaKikan = RString.EMPTY;
        this.chosain = RString.EMPTY;
        this.saiChosa = RString.EMPTY;
        this.iryoKikan = RString.EMPTY;
        this.shujii = RString.EMPTY;
        this.observerCheckShujii = new Icon();
        this.observerCheckChosain = new Icon();
        this.observerCheckNyushoShisetsu = new Icon();
        this.observerCheckSonota = new Icon();
        this.torokuZumiFlag = false;
        this.torokuZumiNo = RString.EMPTY;
        this.ninteiShinsakaiWariateKanryoYMD = RString.EMPTY;
        this.shinsakaiShiryoSofuYMD = new TextBoxFlexibleDate();
        this.setOriginalData("jotaiFlag", jotaiFlag);
        this.setOriginalData("shinsajunKakuteiFlag", shinsajunKakuteiFlag);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("no", no);
        this.setOriginalData("priority", priority);
        this.setOriginalData("hihokenshaNumber", hihokenshaNumber);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("sihinseiKubunShinseiji", sihinseiKubunShinseiji);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("zenkaiYukoKikanKaishiDay", zenkaiYukoKikanKaishiDay);
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.setOriginalData("shinsakaiShiryoSakuseiYMD", shinsakaiShiryoSakuseiYMD);
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.setOriginalData("masking", masking);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.setOriginalData("chosahyoNetakirido", chosahyoNetakirido);
        this.setOriginalData("chosahyoNinchido", chosahyoNinchido);
        this.setOriginalData("ikenshoNetakirido", ikenshoNetakirido);
        this.setOriginalData("ikenshoNinchido", ikenshoNinchido);
        this.setOriginalData("nyushiShisetsu", nyushiShisetsu);
        this.setOriginalData("chosaKikan", chosaKikan);
        this.setOriginalData("chosain", chosain);
        this.setOriginalData("saiChosa", saiChosa);
        this.setOriginalData("iryoKikan", iryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("observerCheckShujii", observerCheckShujii);
        this.setOriginalData("observerCheckChosain", observerCheckChosain);
        this.setOriginalData("observerCheckNyushoShisetsu", observerCheckNyushoShisetsu);
        this.setOriginalData("observerCheckSonota", observerCheckSonota);
        this.setOriginalData("torokuZumiFlag", torokuZumiFlag);
        this.setOriginalData("torokuZumiNo", torokuZumiNo);
        this.setOriginalData("ninteiShinsakaiWariateKanryoYMD", ninteiShinsakaiWariateKanryoYMD);
        this.setOriginalData("shinsakaiShiryoSofuYMD", shinsakaiShiryoSofuYMD);
    }

    public dgTaishoshaIchiran_Row(RString jotaiFlag, RString shinsajunKakuteiFlag, RString shinseishoKanriNo, RString no, RString priority, RString hihokenshaNumber, RString shimei, RString seibetsu, RString hihokenshaKubun, RString sihinseiKubunShinseiji, TextBoxFlexibleDate shinseiDay, TextBoxFlexibleDate zenkaiYukoKikanKaishiDay, TextBoxFlexibleDate zenkaiYukoKikanShuryoDay, TextBoxFlexibleDate shinsakaiShiryoSakuseiYMD, RString konkaiIchijiHantei, RString masking, RString hokenshaNo, RString hokenshaName, RString zenkaiIchijiHantei, RString zenkaiNijiHantei, RString chosahyoNetakirido, RString chosahyoNinchido, RString ikenshoNetakirido, RString ikenshoNinchido, RString nyushiShisetsu, RString chosaKikan, RString chosain, RString saiChosa, RString iryoKikan, RString shujii, Icon observerCheckShujii, Icon observerCheckChosain, Icon observerCheckNyushoShisetsu, Icon observerCheckSonota, Boolean torokuZumiFlag, RString torokuZumiNo, RString ninteiShinsakaiWariateKanryoYMD, TextBoxFlexibleDate shinsakaiShiryoSofuYMD) {
        super();
        this.setOriginalData("jotaiFlag", jotaiFlag);
        this.setOriginalData("shinsajunKakuteiFlag", shinsajunKakuteiFlag);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("no", no);
        this.setOriginalData("priority", priority);
        this.setOriginalData("hihokenshaNumber", hihokenshaNumber);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("sihinseiKubunShinseiji", sihinseiKubunShinseiji);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("zenkaiYukoKikanKaishiDay", zenkaiYukoKikanKaishiDay);
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.setOriginalData("shinsakaiShiryoSakuseiYMD", shinsakaiShiryoSakuseiYMD);
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.setOriginalData("masking", masking);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.setOriginalData("chosahyoNetakirido", chosahyoNetakirido);
        this.setOriginalData("chosahyoNinchido", chosahyoNinchido);
        this.setOriginalData("ikenshoNetakirido", ikenshoNetakirido);
        this.setOriginalData("ikenshoNinchido", ikenshoNinchido);
        this.setOriginalData("nyushiShisetsu", nyushiShisetsu);
        this.setOriginalData("chosaKikan", chosaKikan);
        this.setOriginalData("chosain", chosain);
        this.setOriginalData("saiChosa", saiChosa);
        this.setOriginalData("iryoKikan", iryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("observerCheckShujii", observerCheckShujii);
        this.setOriginalData("observerCheckChosain", observerCheckChosain);
        this.setOriginalData("observerCheckNyushoShisetsu", observerCheckNyushoShisetsu);
        this.setOriginalData("observerCheckSonota", observerCheckSonota);
        this.setOriginalData("torokuZumiFlag", torokuZumiFlag);
        this.setOriginalData("torokuZumiNo", torokuZumiNo);
        this.setOriginalData("ninteiShinsakaiWariateKanryoYMD", ninteiShinsakaiWariateKanryoYMD);
        this.setOriginalData("shinsakaiShiryoSofuYMD", shinsakaiShiryoSofuYMD);
        this.jotaiFlag = jotaiFlag;
        this.shinsajunKakuteiFlag = shinsajunKakuteiFlag;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.no = no;
        this.priority = priority;
        this.hihokenshaNumber = hihokenshaNumber;
        this.shimei = shimei;
        this.seibetsu = seibetsu;
        this.hihokenshaKubun = hihokenshaKubun;
        this.sihinseiKubunShinseiji = sihinseiKubunShinseiji;
        this.shinseiDay = shinseiDay;
        this.zenkaiYukoKikanKaishiDay = zenkaiYukoKikanKaishiDay;
        this.zenkaiYukoKikanShuryoDay = zenkaiYukoKikanShuryoDay;
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
        this.konkaiIchijiHantei = konkaiIchijiHantei;
        this.masking = masking;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.zenkaiIchijiHantei = zenkaiIchijiHantei;
        this.zenkaiNijiHantei = zenkaiNijiHantei;
        this.chosahyoNetakirido = chosahyoNetakirido;
        this.chosahyoNinchido = chosahyoNinchido;
        this.ikenshoNetakirido = ikenshoNetakirido;
        this.ikenshoNinchido = ikenshoNinchido;
        this.nyushiShisetsu = nyushiShisetsu;
        this.chosaKikan = chosaKikan;
        this.chosain = chosain;
        this.saiChosa = saiChosa;
        this.iryoKikan = iryoKikan;
        this.shujii = shujii;
        this.observerCheckShujii = observerCheckShujii;
        this.observerCheckChosain = observerCheckChosain;
        this.observerCheckNyushoShisetsu = observerCheckNyushoShisetsu;
        this.observerCheckSonota = observerCheckSonota;
        this.torokuZumiFlag = torokuZumiFlag;
        this.torokuZumiNo = torokuZumiNo;
        this.ninteiShinsakaiWariateKanryoYMD = ninteiShinsakaiWariateKanryoYMD;
        this.shinsakaiShiryoSofuYMD = shinsakaiShiryoSofuYMD;
    }

    public RString getJotaiFlag() {
        return jotaiFlag;
    }

    public RString getShinsajunKakuteiFlag() {
        return shinsajunKakuteiFlag;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNo() {
        return no;
    }

    public RString getPriority() {
        return priority;
    }

    public RString getHihokenshaNumber() {
        return hihokenshaNumber;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getHihokenshaKubun() {
        return hihokenshaKubun;
    }

    public RString getSihinseiKubunShinseiji() {
        return sihinseiKubunShinseiji;
    }

    public TextBoxFlexibleDate getShinseiDay() {
        return shinseiDay;
    }

    public TextBoxFlexibleDate getZenkaiYukoKikanKaishiDay() {
        return zenkaiYukoKikanKaishiDay;
    }

    public TextBoxFlexibleDate getZenkaiYukoKikanShuryoDay() {
        return zenkaiYukoKikanShuryoDay;
    }

    public TextBoxFlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    public RString getKonkaiIchijiHantei() {
        return konkaiIchijiHantei;
    }

    public RString getMasking() {
        return masking;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public RString getZenkaiIchijiHantei() {
        return zenkaiIchijiHantei;
    }

    public RString getZenkaiNijiHantei() {
        return zenkaiNijiHantei;
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

    public RString getNyushiShisetsu() {
        return nyushiShisetsu;
    }

    public RString getChosaKikan() {
        return chosaKikan;
    }

    public RString getChosain() {
        return chosain;
    }

    public RString getSaiChosa() {
        return saiChosa;
    }

    public RString getIryoKikan() {
        return iryoKikan;
    }

    public RString getShujii() {
        return shujii;
    }

    public Icon getObserverCheckShujii() {
        return observerCheckShujii;
    }

    public Icon getObserverCheckChosain() {
        return observerCheckChosain;
    }

    public Icon getObserverCheckNyushoShisetsu() {
        return observerCheckNyushoShisetsu;
    }

    public Icon getObserverCheckSonota() {
        return observerCheckSonota;
    }

    public Boolean getTorokuZumiFlag() {
        return torokuZumiFlag;
    }

    public RString getTorokuZumiNo() {
        return torokuZumiNo;
    }

    public RString getNinteiShinsakaiWariateKanryoYMD() {
        return ninteiShinsakaiWariateKanryoYMD;
    }

    public TextBoxFlexibleDate getShinsakaiShiryoSofuYMD() {
        return shinsakaiShiryoSofuYMD;
    }

    public void setJotaiFlag(RString jotaiFlag) {
        this.setOriginalData("jotaiFlag", jotaiFlag);
        this.jotaiFlag = jotaiFlag;
    }

    public void setShinsajunKakuteiFlag(RString shinsajunKakuteiFlag) {
        this.setOriginalData("shinsajunKakuteiFlag", shinsajunKakuteiFlag);
        this.shinsajunKakuteiFlag = shinsajunKakuteiFlag;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setPriority(RString priority) {
        this.setOriginalData("priority", priority);
        this.priority = priority;
    }

    public void setHihokenshaNumber(RString hihokenshaNumber) {
        this.setOriginalData("hihokenshaNumber", hihokenshaNumber);
        this.hihokenshaNumber = hihokenshaNumber;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setHihokenshaKubun(RString hihokenshaKubun) {
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.hihokenshaKubun = hihokenshaKubun;
    }

    public void setSihinseiKubunShinseiji(RString sihinseiKubunShinseiji) {
        this.setOriginalData("sihinseiKubunShinseiji", sihinseiKubunShinseiji);
        this.sihinseiKubunShinseiji = sihinseiKubunShinseiji;
    }

    public void setShinseiDay(TextBoxFlexibleDate shinseiDay) {
        this.setOriginalData("shinseiDay", shinseiDay);
        this.shinseiDay = shinseiDay;
    }

    public void setZenkaiYukoKikanKaishiDay(TextBoxFlexibleDate zenkaiYukoKikanKaishiDay) {
        this.setOriginalData("zenkaiYukoKikanKaishiDay", zenkaiYukoKikanKaishiDay);
        this.zenkaiYukoKikanKaishiDay = zenkaiYukoKikanKaishiDay;
    }

    public void setZenkaiYukoKikanShuryoDay(TextBoxFlexibleDate zenkaiYukoKikanShuryoDay) {
        this.setOriginalData("zenkaiYukoKikanShuryoDay", zenkaiYukoKikanShuryoDay);
        this.zenkaiYukoKikanShuryoDay = zenkaiYukoKikanShuryoDay;
    }

    public void setShinsakaiShiryoSakuseiYMD(TextBoxFlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.setOriginalData("shinsakaiShiryoSakuseiYMD", shinsakaiShiryoSakuseiYMD);
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    public void setKonkaiIchijiHantei(RString konkaiIchijiHantei) {
        this.setOriginalData("konkaiIchijiHantei", konkaiIchijiHantei);
        this.konkaiIchijiHantei = konkaiIchijiHantei;
    }

    public void setMasking(RString masking) {
        this.setOriginalData("masking", masking);
        this.masking = masking;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setZenkaiIchijiHantei(RString zenkaiIchijiHantei) {
        this.setOriginalData("zenkaiIchijiHantei", zenkaiIchijiHantei);
        this.zenkaiIchijiHantei = zenkaiIchijiHantei;
    }

    public void setZenkaiNijiHantei(RString zenkaiNijiHantei) {
        this.setOriginalData("zenkaiNijiHantei", zenkaiNijiHantei);
        this.zenkaiNijiHantei = zenkaiNijiHantei;
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

    public void setNyushiShisetsu(RString nyushiShisetsu) {
        this.setOriginalData("nyushiShisetsu", nyushiShisetsu);
        this.nyushiShisetsu = nyushiShisetsu;
    }

    public void setChosaKikan(RString chosaKikan) {
        this.setOriginalData("chosaKikan", chosaKikan);
        this.chosaKikan = chosaKikan;
    }

    public void setChosain(RString chosain) {
        this.setOriginalData("chosain", chosain);
        this.chosain = chosain;
    }

    public void setSaiChosa(RString saiChosa) {
        this.setOriginalData("saiChosa", saiChosa);
        this.saiChosa = saiChosa;
    }

    public void setIryoKikan(RString iryoKikan) {
        this.setOriginalData("iryoKikan", iryoKikan);
        this.iryoKikan = iryoKikan;
    }

    public void setShujii(RString shujii) {
        this.setOriginalData("shujii", shujii);
        this.shujii = shujii;
    }

    public void setObserverCheckShujii(Icon observerCheckShujii) {
        this.setOriginalData("observerCheckShujii", observerCheckShujii);
        this.observerCheckShujii = observerCheckShujii;
    }

    public void setObserverCheckChosain(Icon observerCheckChosain) {
        this.setOriginalData("observerCheckChosain", observerCheckChosain);
        this.observerCheckChosain = observerCheckChosain;
    }

    public void setObserverCheckNyushoShisetsu(Icon observerCheckNyushoShisetsu) {
        this.setOriginalData("observerCheckNyushoShisetsu", observerCheckNyushoShisetsu);
        this.observerCheckNyushoShisetsu = observerCheckNyushoShisetsu;
    }

    public void setObserverCheckSonota(Icon observerCheckSonota) {
        this.setOriginalData("observerCheckSonota", observerCheckSonota);
        this.observerCheckSonota = observerCheckSonota;
    }

    public void setTorokuZumiFlag(Boolean torokuZumiFlag) {
        this.setOriginalData("torokuZumiFlag", torokuZumiFlag);
        this.torokuZumiFlag = torokuZumiFlag;
    }

    public void setTorokuZumiNo(RString torokuZumiNo) {
        this.setOriginalData("torokuZumiNo", torokuZumiNo);
        this.torokuZumiNo = torokuZumiNo;
    }

    public void setNinteiShinsakaiWariateKanryoYMD(RString ninteiShinsakaiWariateKanryoYMD) {
        this.setOriginalData("ninteiShinsakaiWariateKanryoYMD", ninteiShinsakaiWariateKanryoYMD);
        this.ninteiShinsakaiWariateKanryoYMD = ninteiShinsakaiWariateKanryoYMD;
    }

    public void setShinsakaiShiryoSofuYMD(TextBoxFlexibleDate shinsakaiShiryoSofuYMD) {
        this.setOriginalData("shinsakaiShiryoSofuYMD", shinsakaiShiryoSofuYMD);
        this.shinsakaiShiryoSofuYMD = shinsakaiShiryoSofuYMD;
    }

    // </editor-fold>
}
