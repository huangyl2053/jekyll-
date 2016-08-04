package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 04 09:19:13 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinseishaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseishaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private ButtonDialog shokai;
    private RString status;
    private RString hihokenshaNo;
    private RString hihokennshaShimei;
    private RString seibetsu;
    private TextBoxDate shinseiDay;
    private RString shinseiKubunShinseiji;
    private RString jusho;
    private RString shujiiIryoKikan;
    private RString shujii;
    private TextBoxDate shujiiIkenshoSakuseiIraiDay;
    private RString iraiKubun;
    private RString hokensha;
    private RString zenkaiShujiiIryoKikan;
    private RString zenkaiShujii;
    private TextBoxDate iraishoShutsuryokuDay;
    private TextBoxDate ikenshoShutsuryokuDay;
    private TextBoxDate seikyushoShutsuryokuDay;
    private RString rirekiNo;
    private Boolean sakujoKbn;
    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private RString ishiKbnCode;
    private Boolean shiteiiFlag;
    private RString shiseishoKanriNo;
    private TextBoxFlexibleDate birthYMD;
    private RString hihokenshaShimeiKana;
    private Boolean shisetsuNyushoFlag;
    private RString yubinNo;
    private RString koroshoIfShikibetsuCode;
    private RString iryoukikanShozaichi;
    private RString hokenshaNo;
    private RString iryoKikanTelNo;
    private RString preRirekiNo;
    private RString shichosonCode;
    private RString telNo;
    private RString age;
    private RString iryoKikanFaxNo;

    public dgShinseishaIchiran_Row() {
        super();
        this.shokai = new ButtonDialog();
        this.status = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.hihokennshaShimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.shinseiDay = new TextBoxDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.shujiiIryoKikan = RString.EMPTY;
        this.shujii = RString.EMPTY;
        this.shujiiIkenshoSakuseiIraiDay = new TextBoxDate();
        this.iraiKubun = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.zenkaiShujiiIryoKikan = RString.EMPTY;
        this.zenkaiShujii = RString.EMPTY;
        this.iraishoShutsuryokuDay = new TextBoxDate();
        this.ikenshoShutsuryokuDay = new TextBoxDate();
        this.seikyushoShutsuryokuDay = new TextBoxDate();
        this.rirekiNo = RString.EMPTY;
        this.sakujoKbn = false;
        this.shujiiIryoKikanCode = RString.EMPTY;
        this.shujiiCode = RString.EMPTY;
        this.ishiKbnCode = RString.EMPTY;
        this.shiteiiFlag = false;
        this.shiseishoKanriNo = RString.EMPTY;
        this.birthYMD = new TextBoxFlexibleDate();
        this.hihokenshaShimeiKana = RString.EMPTY;
        this.shisetsuNyushoFlag = false;
        this.yubinNo = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.iryoukikanShozaichi = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.iryoKikanTelNo = RString.EMPTY;
        this.preRirekiNo = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.telNo = RString.EMPTY;
        this.age = RString.EMPTY;
        this.iryoKikanFaxNo = RString.EMPTY;
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("status", status);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokennshaShimei", hihokennshaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shujiiIryoKikan", shujiiIryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("shujiiIkenshoSakuseiIraiDay", shujiiIkenshoSakuseiIraiDay);
        this.setOriginalData("iraiKubun", iraiKubun);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("zenkaiShujiiIryoKikan", zenkaiShujiiIryoKikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.setOriginalData("ikenshoShutsuryokuDay", ikenshoShutsuryokuDay);
        this.setOriginalData("seikyushoShutsuryokuDay", seikyushoShutsuryokuDay);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("sakujoKbn", sakujoKbn);
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("ishiKbnCode", ishiKbnCode);
        this.setOriginalData("shiteiiFlag", shiteiiFlag);
        this.setOriginalData("shiseishoKanriNo", shiseishoKanriNo);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.setOriginalData("shisetsuNyushoFlag", shisetsuNyushoFlag);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("iryoukikanShozaichi", iryoukikanShozaichi);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("iryoKikanTelNo", iryoKikanTelNo);
        this.setOriginalData("preRirekiNo", preRirekiNo);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("age", age);
        this.setOriginalData("iryoKikanFaxNo", iryoKikanFaxNo);
    }

    public dgShinseishaIchiran_Row(ButtonDialog shokai, RString status, RString hihokenshaNo, RString hihokennshaShimei, RString seibetsu, TextBoxDate shinseiDay, RString shinseiKubunShinseiji, RString jusho, RString shujiiIryoKikan, RString shujii, TextBoxDate shujiiIkenshoSakuseiIraiDay, RString iraiKubun, RString hokensha, RString zenkaiShujiiIryoKikan, RString zenkaiShujii, TextBoxDate iraishoShutsuryokuDay, TextBoxDate ikenshoShutsuryokuDay, TextBoxDate seikyushoShutsuryokuDay, RString rirekiNo, Boolean sakujoKbn, RString shujiiIryoKikanCode, RString shujiiCode, RString ishiKbnCode, Boolean shiteiiFlag, RString shiseishoKanriNo, TextBoxFlexibleDate birthYMD, RString hihokenshaShimeiKana, Boolean shisetsuNyushoFlag, RString yubinNo, RString koroshoIfShikibetsuCode, RString iryoukikanShozaichi, RString hokenshaNo, RString iryoKikanTelNo, RString preRirekiNo, RString shichosonCode, RString telNo, RString age, RString iryoKikanFaxNo) {
        super();
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("status", status);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokennshaShimei", hihokennshaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shujiiIryoKikan", shujiiIryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("shujiiIkenshoSakuseiIraiDay", shujiiIkenshoSakuseiIraiDay);
        this.setOriginalData("iraiKubun", iraiKubun);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("zenkaiShujiiIryoKikan", zenkaiShujiiIryoKikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.setOriginalData("ikenshoShutsuryokuDay", ikenshoShutsuryokuDay);
        this.setOriginalData("seikyushoShutsuryokuDay", seikyushoShutsuryokuDay);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("sakujoKbn", sakujoKbn);
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("ishiKbnCode", ishiKbnCode);
        this.setOriginalData("shiteiiFlag", shiteiiFlag);
        this.setOriginalData("shiseishoKanriNo", shiseishoKanriNo);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.setOriginalData("shisetsuNyushoFlag", shisetsuNyushoFlag);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("iryoukikanShozaichi", iryoukikanShozaichi);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("iryoKikanTelNo", iryoKikanTelNo);
        this.setOriginalData("preRirekiNo", preRirekiNo);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("age", age);
        this.setOriginalData("iryoKikanFaxNo", iryoKikanFaxNo);
        this.shokai = shokai;
        this.status = status;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokennshaShimei = hihokennshaShimei;
        this.seibetsu = seibetsu;
        this.shinseiDay = shinseiDay;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.jusho = jusho;
        this.shujiiIryoKikan = shujiiIryoKikan;
        this.shujii = shujii;
        this.shujiiIkenshoSakuseiIraiDay = shujiiIkenshoSakuseiIraiDay;
        this.iraiKubun = iraiKubun;
        this.hokensha = hokensha;
        this.zenkaiShujiiIryoKikan = zenkaiShujiiIryoKikan;
        this.zenkaiShujii = zenkaiShujii;
        this.iraishoShutsuryokuDay = iraishoShutsuryokuDay;
        this.ikenshoShutsuryokuDay = ikenshoShutsuryokuDay;
        this.seikyushoShutsuryokuDay = seikyushoShutsuryokuDay;
        this.rirekiNo = rirekiNo;
        this.sakujoKbn = sakujoKbn;
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
        this.shujiiCode = shujiiCode;
        this.ishiKbnCode = ishiKbnCode;
        this.shiteiiFlag = shiteiiFlag;
        this.shiseishoKanriNo = shiseishoKanriNo;
        this.birthYMD = birthYMD;
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
        this.shisetsuNyushoFlag = shisetsuNyushoFlag;
        this.yubinNo = yubinNo;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.iryoukikanShozaichi = iryoukikanShozaichi;
        this.hokenshaNo = hokenshaNo;
        this.iryoKikanTelNo = iryoKikanTelNo;
        this.preRirekiNo = preRirekiNo;
        this.shichosonCode = shichosonCode;
        this.telNo = telNo;
        this.age = age;
        this.iryoKikanFaxNo = iryoKikanFaxNo;
    }

    public ButtonDialog getShokai() {
        return shokai;
    }

    public RString getStatus() {
        return status;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokennshaShimei() {
        return hihokennshaShimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxDate getShinseiDay() {
        return shinseiDay;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getShujiiIryoKikan() {
        return shujiiIryoKikan;
    }

    public RString getShujii() {
        return shujii;
    }

    public TextBoxDate getShujiiIkenshoSakuseiIraiDay() {
        return shujiiIkenshoSakuseiIraiDay;
    }

    public RString getIraiKubun() {
        return iraiKubun;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getZenkaiShujiiIryoKikan() {
        return zenkaiShujiiIryoKikan;
    }

    public RString getZenkaiShujii() {
        return zenkaiShujii;
    }

    public TextBoxDate getIraishoShutsuryokuDay() {
        return iraishoShutsuryokuDay;
    }

    public TextBoxDate getIkenshoShutsuryokuDay() {
        return ikenshoShutsuryokuDay;
    }

    public TextBoxDate getSeikyushoShutsuryokuDay() {
        return seikyushoShutsuryokuDay;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public Boolean getSakujoKbn() {
        return sakujoKbn;
    }

    public RString getShujiiIryoKikanCode() {
        return shujiiIryoKikanCode;
    }

    public RString getShujiiCode() {
        return shujiiCode;
    }

    public RString getIshiKbnCode() {
        return ishiKbnCode;
    }

    public Boolean getShiteiiFlag() {
        return shiteiiFlag;
    }

    public RString getShiseishoKanriNo() {
        return shiseishoKanriNo;
    }

    public TextBoxFlexibleDate getBirthYMD() {
        return birthYMD;
    }

    public RString getHihokenshaShimeiKana() {
        return hihokenshaShimeiKana;
    }

    public Boolean getShisetsuNyushoFlag() {
        return shisetsuNyushoFlag;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public RString getIryoukikanShozaichi() {
        return iryoukikanShozaichi;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getIryoKikanTelNo() {
        return iryoKikanTelNo;
    }

    public RString getPreRirekiNo() {
        return preRirekiNo;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getTelNo() {
        return telNo;
    }

    public RString getAge() {
        return age;
    }

    public RString getIryoKikanFaxNo() {
        return iryoKikanFaxNo;
    }

    public void setShokai(ButtonDialog shokai) {
        this.setOriginalData("shokai", shokai);
        this.shokai = shokai;
    }

    public void setStatus(RString status) {
        this.setOriginalData("status", status);
        this.status = status;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokennshaShimei(RString hihokennshaShimei) {
        this.setOriginalData("hihokennshaShimei", hihokennshaShimei);
        this.hihokennshaShimei = hihokennshaShimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setShinseiDay(TextBoxDate shinseiDay) {
        this.setOriginalData("shinseiDay", shinseiDay);
        this.shinseiDay = shinseiDay;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setShujiiIryoKikan(RString shujiiIryoKikan) {
        this.setOriginalData("shujiiIryoKikan", shujiiIryoKikan);
        this.shujiiIryoKikan = shujiiIryoKikan;
    }

    public void setShujii(RString shujii) {
        this.setOriginalData("shujii", shujii);
        this.shujii = shujii;
    }

    public void setShujiiIkenshoSakuseiIraiDay(TextBoxDate shujiiIkenshoSakuseiIraiDay) {
        this.setOriginalData("shujiiIkenshoSakuseiIraiDay", shujiiIkenshoSakuseiIraiDay);
        this.shujiiIkenshoSakuseiIraiDay = shujiiIkenshoSakuseiIraiDay;
    }

    public void setIraiKubun(RString iraiKubun) {
        this.setOriginalData("iraiKubun", iraiKubun);
        this.iraiKubun = iraiKubun;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setZenkaiShujiiIryoKikan(RString zenkaiShujiiIryoKikan) {
        this.setOriginalData("zenkaiShujiiIryoKikan", zenkaiShujiiIryoKikan);
        this.zenkaiShujiiIryoKikan = zenkaiShujiiIryoKikan;
    }

    public void setZenkaiShujii(RString zenkaiShujii) {
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.zenkaiShujii = zenkaiShujii;
    }

    public void setIraishoShutsuryokuDay(TextBoxDate iraishoShutsuryokuDay) {
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.iraishoShutsuryokuDay = iraishoShutsuryokuDay;
    }

    public void setIkenshoShutsuryokuDay(TextBoxDate ikenshoShutsuryokuDay) {
        this.setOriginalData("ikenshoShutsuryokuDay", ikenshoShutsuryokuDay);
        this.ikenshoShutsuryokuDay = ikenshoShutsuryokuDay;
    }

    public void setSeikyushoShutsuryokuDay(TextBoxDate seikyushoShutsuryokuDay) {
        this.setOriginalData("seikyushoShutsuryokuDay", seikyushoShutsuryokuDay);
        this.seikyushoShutsuryokuDay = seikyushoShutsuryokuDay;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setSakujoKbn(Boolean sakujoKbn) {
        this.setOriginalData("sakujoKbn", sakujoKbn);
        this.sakujoKbn = sakujoKbn;
    }

    public void setShujiiIryoKikanCode(RString shujiiIryoKikanCode) {
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
    }

    public void setShujiiCode(RString shujiiCode) {
        this.setOriginalData("shujiiCode", shujiiCode);
        this.shujiiCode = shujiiCode;
    }

    public void setIshiKbnCode(RString ishiKbnCode) {
        this.setOriginalData("ishiKbnCode", ishiKbnCode);
        this.ishiKbnCode = ishiKbnCode;
    }

    public void setShiteiiFlag(Boolean shiteiiFlag) {
        this.setOriginalData("shiteiiFlag", shiteiiFlag);
        this.shiteiiFlag = shiteiiFlag;
    }

    public void setShiseishoKanriNo(RString shiseishoKanriNo) {
        this.setOriginalData("shiseishoKanriNo", shiseishoKanriNo);
        this.shiseishoKanriNo = shiseishoKanriNo;
    }

    public void setBirthYMD(TextBoxFlexibleDate birthYMD) {
        this.setOriginalData("birthYMD", birthYMD);
        this.birthYMD = birthYMD;
    }

    public void setHihokenshaShimeiKana(RString hihokenshaShimeiKana) {
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
    }

    public void setShisetsuNyushoFlag(Boolean shisetsuNyushoFlag) {
        this.setOriginalData("shisetsuNyushoFlag", shisetsuNyushoFlag);
        this.shisetsuNyushoFlag = shisetsuNyushoFlag;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public void setIryoukikanShozaichi(RString iryoukikanShozaichi) {
        this.setOriginalData("iryoukikanShozaichi", iryoukikanShozaichi);
        this.iryoukikanShozaichi = iryoukikanShozaichi;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setIryoKikanTelNo(RString iryoKikanTelNo) {
        this.setOriginalData("iryoKikanTelNo", iryoKikanTelNo);
        this.iryoKikanTelNo = iryoKikanTelNo;
    }

    public void setPreRirekiNo(RString preRirekiNo) {
        this.setOriginalData("preRirekiNo", preRirekiNo);
        this.preRirekiNo = preRirekiNo;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setTelNo(RString telNo) {
        this.setOriginalData("telNo", telNo);
        this.telNo = telNo;
    }

    public void setAge(RString age) {
        this.setOriginalData("age", age);
        this.age = age;
    }

    public void setIryoKikanFaxNo(RString iryoKikanFaxNo) {
        this.setOriginalData("iryoKikanFaxNo", iryoKikanFaxNo);
        this.iryoKikanFaxNo = iryoKikanFaxNo;
    }

    // </editor-fold>
}
