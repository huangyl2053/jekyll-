package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 22 11:18:26 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgWaritsukeZumiShinseishaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgWaritsukeZumiShinseishaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private TextBoxNum no;
    private ButtonDialog shokai;
    private RString jotai;
    private RString hihokenshaNo;
    private RString hihokenshaShimei;
    private RString seibetsu;
    private TextBoxDate ninteiShinseiDay;
    private RString shinseiKubunShinseiji;
    private RString chiku;
    private RString zenkaiChosaItakusaki;
    private RString zenkaiChosain;
    private RString chosaIraiDay;
    private RString chosaKubun;
    private RString hokensha;
    private RString jusho;
    private RString shujiIryoKikan;
    private RString shujii;
    private RString zenkaiShujiIryoKikan;
    private RString zenkaiShujii;
    private TextBoxDate iraishoShutsuryokuDay;
    private TextBoxDate chosahyoNadoShutsuryookuDay;
    private RString ninteichosaKanryoYMD;
    private RString shinseishoKanriNo;
    private RString ninteichosaIraiRirekiNo;
    private RString koroshoIfShikibetsuCode;
    private RString waritsukeTeiin;
    private RString chosaKanoNinzuPerMonth;
    private RString ninteichosaKigenYMD;
    private RString hihokenshaKana;
    private RString seinengappiYMD;
    private RString yubinNo;
    private RString telNo;
    private RString homonChosasakiYubinNo;
    private RString homonChosasakiJusho;
    private RString homonChosasakiName;
    private RString homonChosasakiTelNo;
    private RString ninteiShinseiYMDKoShin;
    private RString zenkaiNinteiYMD;
    private RString zenYokaigoKubunCode;
    private RString age;
    private RString ninteiChosainCode;
    private RString hokenshaNo;
    private RString ninteiChosaItakusakiCode;
    private RString renrakusakiYubinNo;
    private RString renrakusakiTelNo;
    private RString renrakusakiKeitaiTelNo;
    private RString renrakusakiShimei;
    private RString renrakusakiTuzukigara;
    private RString renrakusakiJusho;
    private RString shichosonCode;

    public dgWaritsukeZumiShinseishaIchiran_Row() {
        super();
        this.no = new TextBoxNum();
        this.shokai = new ButtonDialog();
        this.jotai = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaShimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.ninteiShinseiDay = new TextBoxDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.chiku = RString.EMPTY;
        this.zenkaiChosaItakusaki = RString.EMPTY;
        this.zenkaiChosain = RString.EMPTY;
        this.chosaIraiDay = RString.EMPTY;
        this.chosaKubun = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.shujiIryoKikan = RString.EMPTY;
        this.shujii = RString.EMPTY;
        this.zenkaiShujiIryoKikan = RString.EMPTY;
        this.zenkaiShujii = RString.EMPTY;
        this.iraishoShutsuryokuDay = new TextBoxDate();
        this.chosahyoNadoShutsuryookuDay = new TextBoxDate();
        this.ninteichosaKanryoYMD = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.waritsukeTeiin = RString.EMPTY;
        this.chosaKanoNinzuPerMonth = RString.EMPTY;
        this.ninteichosaKigenYMD = RString.EMPTY;
        this.hihokenshaKana = RString.EMPTY;
        this.seinengappiYMD = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.telNo = RString.EMPTY;
        this.homonChosasakiYubinNo = RString.EMPTY;
        this.homonChosasakiJusho = RString.EMPTY;
        this.homonChosasakiName = RString.EMPTY;
        this.homonChosasakiTelNo = RString.EMPTY;
        this.ninteiShinseiYMDKoShin = RString.EMPTY;
        this.zenkaiNinteiYMD = RString.EMPTY;
        this.zenYokaigoKubunCode = RString.EMPTY;
        this.age = RString.EMPTY;
        this.ninteiChosainCode = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.ninteiChosaItakusakiCode = RString.EMPTY;
        this.renrakusakiYubinNo = RString.EMPTY;
        this.renrakusakiTelNo = RString.EMPTY;
        this.renrakusakiKeitaiTelNo = RString.EMPTY;
        this.renrakusakiShimei = RString.EMPTY;
        this.renrakusakiTuzukigara = RString.EMPTY;
        this.renrakusakiJusho = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("chosaIraiDay", chosaIraiDay);
        this.setOriginalData("chosaKubun", chosaKubun);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shujiIryoKikan", shujiIryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("zenkaiShujiIryoKikan", zenkaiShujiIryoKikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.setOriginalData("chosahyoNadoShutsuryookuDay", chosahyoNadoShutsuryookuDay);
        this.setOriginalData("ninteichosaKanryoYMD", ninteichosaKanryoYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
        this.setOriginalData("ninteichosaKigenYMD", ninteichosaKigenYMD);
        this.setOriginalData("hihokenshaKana", hihokenshaKana);
        this.setOriginalData("seinengappiYMD", seinengappiYMD);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("homonChosasakiYubinNo", homonChosasakiYubinNo);
        this.setOriginalData("homonChosasakiJusho", homonChosasakiJusho);
        this.setOriginalData("homonChosasakiName", homonChosasakiName);
        this.setOriginalData("homonChosasakiTelNo", homonChosasakiTelNo);
        this.setOriginalData("ninteiShinseiYMDKoShin", ninteiShinseiYMDKoShin);
        this.setOriginalData("zenkaiNinteiYMD", zenkaiNinteiYMD);
        this.setOriginalData("zenYokaigoKubunCode", zenYokaigoKubunCode);
        this.setOriginalData("age", age);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("renrakusakiYubinNo", renrakusakiYubinNo);
        this.setOriginalData("renrakusakiTelNo", renrakusakiTelNo);
        this.setOriginalData("renrakusakiKeitaiTelNo", renrakusakiKeitaiTelNo);
        this.setOriginalData("renrakusakiShimei", renrakusakiShimei);
        this.setOriginalData("renrakusakiTuzukigara", renrakusakiTuzukigara);
        this.setOriginalData("renrakusakiJusho", renrakusakiJusho);
        this.setOriginalData("shichosonCode", shichosonCode);
    }

    public dgWaritsukeZumiShinseishaIchiran_Row(TextBoxNum no, ButtonDialog shokai, RString jotai, RString hihokenshaNo, RString hihokenshaShimei, RString seibetsu, TextBoxDate ninteiShinseiDay, RString shinseiKubunShinseiji, RString chiku, RString zenkaiChosaItakusaki, RString zenkaiChosain, RString chosaIraiDay, RString chosaKubun, RString hokensha, RString jusho, RString shujiIryoKikan, RString shujii, RString zenkaiShujiIryoKikan, RString zenkaiShujii, TextBoxDate iraishoShutsuryokuDay, TextBoxDate chosahyoNadoShutsuryookuDay, RString ninteichosaKanryoYMD, RString shinseishoKanriNo, RString ninteichosaIraiRirekiNo, RString koroshoIfShikibetsuCode, RString waritsukeTeiin, RString chosaKanoNinzuPerMonth, RString ninteichosaKigenYMD, RString hihokenshaKana, RString seinengappiYMD, RString yubinNo, RString telNo, RString homonChosasakiYubinNo, RString homonChosasakiJusho, RString homonChosasakiName, RString homonChosasakiTelNo, RString ninteiShinseiYMDKoShin, RString zenkaiNinteiYMD, RString zenYokaigoKubunCode, RString age, RString ninteiChosainCode, RString hokenshaNo, RString ninteiChosaItakusakiCode, RString renrakusakiYubinNo, RString renrakusakiTelNo, RString renrakusakiKeitaiTelNo, RString renrakusakiShimei, RString renrakusakiTuzukigara, RString renrakusakiJusho, RString shichosonCode) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("chosaIraiDay", chosaIraiDay);
        this.setOriginalData("chosaKubun", chosaKubun);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shujiIryoKikan", shujiIryoKikan);
        this.setOriginalData("shujii", shujii);
        this.setOriginalData("zenkaiShujiIryoKikan", zenkaiShujiIryoKikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.setOriginalData("chosahyoNadoShutsuryookuDay", chosahyoNadoShutsuryookuDay);
        this.setOriginalData("ninteichosaKanryoYMD", ninteichosaKanryoYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
        this.setOriginalData("ninteichosaKigenYMD", ninteichosaKigenYMD);
        this.setOriginalData("hihokenshaKana", hihokenshaKana);
        this.setOriginalData("seinengappiYMD", seinengappiYMD);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("homonChosasakiYubinNo", homonChosasakiYubinNo);
        this.setOriginalData("homonChosasakiJusho", homonChosasakiJusho);
        this.setOriginalData("homonChosasakiName", homonChosasakiName);
        this.setOriginalData("homonChosasakiTelNo", homonChosasakiTelNo);
        this.setOriginalData("ninteiShinseiYMDKoShin", ninteiShinseiYMDKoShin);
        this.setOriginalData("zenkaiNinteiYMD", zenkaiNinteiYMD);
        this.setOriginalData("zenYokaigoKubunCode", zenYokaigoKubunCode);
        this.setOriginalData("age", age);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("renrakusakiYubinNo", renrakusakiYubinNo);
        this.setOriginalData("renrakusakiTelNo", renrakusakiTelNo);
        this.setOriginalData("renrakusakiKeitaiTelNo", renrakusakiKeitaiTelNo);
        this.setOriginalData("renrakusakiShimei", renrakusakiShimei);
        this.setOriginalData("renrakusakiTuzukigara", renrakusakiTuzukigara);
        this.setOriginalData("renrakusakiJusho", renrakusakiJusho);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.no = no;
        this.shokai = shokai;
        this.jotai = jotai;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaShimei = hihokenshaShimei;
        this.seibetsu = seibetsu;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.chiku = chiku;
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
        this.zenkaiChosain = zenkaiChosain;
        this.chosaIraiDay = chosaIraiDay;
        this.chosaKubun = chosaKubun;
        this.hokensha = hokensha;
        this.jusho = jusho;
        this.shujiIryoKikan = shujiIryoKikan;
        this.shujii = shujii;
        this.zenkaiShujiIryoKikan = zenkaiShujiIryoKikan;
        this.zenkaiShujii = zenkaiShujii;
        this.iraishoShutsuryokuDay = iraishoShutsuryokuDay;
        this.chosahyoNadoShutsuryookuDay = chosahyoNadoShutsuryookuDay;
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.waritsukeTeiin = waritsukeTeiin;
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
        this.hihokenshaKana = hihokenshaKana;
        this.seinengappiYMD = seinengappiYMD;
        this.yubinNo = yubinNo;
        this.telNo = telNo;
        this.homonChosasakiYubinNo = homonChosasakiYubinNo;
        this.homonChosasakiJusho = homonChosasakiJusho;
        this.homonChosasakiName = homonChosasakiName;
        this.homonChosasakiTelNo = homonChosasakiTelNo;
        this.ninteiShinseiYMDKoShin = ninteiShinseiYMDKoShin;
        this.zenkaiNinteiYMD = zenkaiNinteiYMD;
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
        this.age = age;
        this.ninteiChosainCode = ninteiChosainCode;
        this.hokenshaNo = hokenshaNo;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.renrakusakiYubinNo = renrakusakiYubinNo;
        this.renrakusakiTelNo = renrakusakiTelNo;
        this.renrakusakiKeitaiTelNo = renrakusakiKeitaiTelNo;
        this.renrakusakiShimei = renrakusakiShimei;
        this.renrakusakiTuzukigara = renrakusakiTuzukigara;
        this.renrakusakiJusho = renrakusakiJusho;
        this.shichosonCode = shichosonCode;
    }

    public TextBoxNum getNo() {
        return no;
    }

    public ButtonDialog getShokai() {
        return shokai;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxDate getNinteiShinseiDay() {
        return ninteiShinseiDay;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getZenkaiChosaItakusaki() {
        return zenkaiChosaItakusaki;
    }

    public RString getZenkaiChosain() {
        return zenkaiChosain;
    }

    public RString getChosaIraiDay() {
        return chosaIraiDay;
    }

    public RString getChosaKubun() {
        return chosaKubun;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getShujiIryoKikan() {
        return shujiIryoKikan;
    }

    public RString getShujii() {
        return shujii;
    }

    public RString getZenkaiShujiIryoKikan() {
        return zenkaiShujiIryoKikan;
    }

    public RString getZenkaiShujii() {
        return zenkaiShujii;
    }

    public TextBoxDate getIraishoShutsuryokuDay() {
        return iraishoShutsuryokuDay;
    }

    public TextBoxDate getChosahyoNadoShutsuryookuDay() {
        return chosahyoNadoShutsuryookuDay;
    }

    public RString getNinteichosaKanryoYMD() {
        return ninteichosaKanryoYMD;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public RString getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    public RString getChosaKanoNinzuPerMonth() {
        return chosaKanoNinzuPerMonth;
    }

    public RString getNinteichosaKigenYMD() {
        return ninteichosaKigenYMD;
    }

    public RString getHihokenshaKana() {
        return hihokenshaKana;
    }

    public RString getSeinengappiYMD() {
        return seinengappiYMD;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getTelNo() {
        return telNo;
    }

    public RString getHomonChosasakiYubinNo() {
        return homonChosasakiYubinNo;
    }

    public RString getHomonChosasakiJusho() {
        return homonChosasakiJusho;
    }

    public RString getHomonChosasakiName() {
        return homonChosasakiName;
    }

    public RString getHomonChosasakiTelNo() {
        return homonChosasakiTelNo;
    }

    public RString getNinteiShinseiYMDKoShin() {
        return ninteiShinseiYMDKoShin;
    }

    public RString getZenkaiNinteiYMD() {
        return zenkaiNinteiYMD;
    }

    public RString getZenYokaigoKubunCode() {
        return zenYokaigoKubunCode;
    }

    public RString getAge() {
        return age;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    public RString getRenrakusakiYubinNo() {
        return renrakusakiYubinNo;
    }

    public RString getRenrakusakiTelNo() {
        return renrakusakiTelNo;
    }

    public RString getRenrakusakiKeitaiTelNo() {
        return renrakusakiKeitaiTelNo;
    }

    public RString getRenrakusakiShimei() {
        return renrakusakiShimei;
    }

    public RString getRenrakusakiTuzukigara() {
        return renrakusakiTuzukigara;
    }

    public RString getRenrakusakiJusho() {
        return renrakusakiJusho;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public void setNo(TextBoxNum no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setShokai(ButtonDialog shokai) {
        this.setOriginalData("shokai", shokai);
        this.shokai = shokai;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaShimei(RString hihokenshaShimei) {
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.hihokenshaShimei = hihokenshaShimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setNinteiShinseiDay(TextBoxDate ninteiShinseiDay) {
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.ninteiShinseiDay = ninteiShinseiDay;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setZenkaiChosaItakusaki(RString zenkaiChosaItakusaki) {
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
    }

    public void setZenkaiChosain(RString zenkaiChosain) {
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.zenkaiChosain = zenkaiChosain;
    }

    public void setChosaIraiDay(RString chosaIraiDay) {
        this.setOriginalData("chosaIraiDay", chosaIraiDay);
        this.chosaIraiDay = chosaIraiDay;
    }

    public void setChosaKubun(RString chosaKubun) {
        this.setOriginalData("chosaKubun", chosaKubun);
        this.chosaKubun = chosaKubun;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setShujiIryoKikan(RString shujiIryoKikan) {
        this.setOriginalData("shujiIryoKikan", shujiIryoKikan);
        this.shujiIryoKikan = shujiIryoKikan;
    }

    public void setShujii(RString shujii) {
        this.setOriginalData("shujii", shujii);
        this.shujii = shujii;
    }

    public void setZenkaiShujiIryoKikan(RString zenkaiShujiIryoKikan) {
        this.setOriginalData("zenkaiShujiIryoKikan", zenkaiShujiIryoKikan);
        this.zenkaiShujiIryoKikan = zenkaiShujiIryoKikan;
    }

    public void setZenkaiShujii(RString zenkaiShujii) {
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.zenkaiShujii = zenkaiShujii;
    }

    public void setIraishoShutsuryokuDay(TextBoxDate iraishoShutsuryokuDay) {
        this.setOriginalData("iraishoShutsuryokuDay", iraishoShutsuryokuDay);
        this.iraishoShutsuryokuDay = iraishoShutsuryokuDay;
    }

    public void setChosahyoNadoShutsuryookuDay(TextBoxDate chosahyoNadoShutsuryookuDay) {
        this.setOriginalData("chosahyoNadoShutsuryookuDay", chosahyoNadoShutsuryookuDay);
        this.chosahyoNadoShutsuryookuDay = chosahyoNadoShutsuryookuDay;
    }

    public void setNinteichosaKanryoYMD(RString ninteichosaKanryoYMD) {
        this.setOriginalData("ninteichosaKanryoYMD", ninteichosaKanryoYMD);
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNinteichosaIraiRirekiNo(RString ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public void setWaritsukeTeiin(RString waritsukeTeiin) {
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.waritsukeTeiin = waritsukeTeiin;
    }

    public void setChosaKanoNinzuPerMonth(RString chosaKanoNinzuPerMonth) {
        this.setOriginalData("chosaKanoNinzuPerMonth", chosaKanoNinzuPerMonth);
        this.chosaKanoNinzuPerMonth = chosaKanoNinzuPerMonth;
    }

    public void setNinteichosaKigenYMD(RString ninteichosaKigenYMD) {
        this.setOriginalData("ninteichosaKigenYMD", ninteichosaKigenYMD);
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
    }

    public void setHihokenshaKana(RString hihokenshaKana) {
        this.setOriginalData("hihokenshaKana", hihokenshaKana);
        this.hihokenshaKana = hihokenshaKana;
    }

    public void setSeinengappiYMD(RString seinengappiYMD) {
        this.setOriginalData("seinengappiYMD", seinengappiYMD);
        this.seinengappiYMD = seinengappiYMD;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setTelNo(RString telNo) {
        this.setOriginalData("telNo", telNo);
        this.telNo = telNo;
    }

    public void setHomonChosasakiYubinNo(RString homonChosasakiYubinNo) {
        this.setOriginalData("homonChosasakiYubinNo", homonChosasakiYubinNo);
        this.homonChosasakiYubinNo = homonChosasakiYubinNo;
    }

    public void setHomonChosasakiJusho(RString homonChosasakiJusho) {
        this.setOriginalData("homonChosasakiJusho", homonChosasakiJusho);
        this.homonChosasakiJusho = homonChosasakiJusho;
    }

    public void setHomonChosasakiName(RString homonChosasakiName) {
        this.setOriginalData("homonChosasakiName", homonChosasakiName);
        this.homonChosasakiName = homonChosasakiName;
    }

    public void setHomonChosasakiTelNo(RString homonChosasakiTelNo) {
        this.setOriginalData("homonChosasakiTelNo", homonChosasakiTelNo);
        this.homonChosasakiTelNo = homonChosasakiTelNo;
    }

    public void setNinteiShinseiYMDKoShin(RString ninteiShinseiYMDKoShin) {
        this.setOriginalData("ninteiShinseiYMDKoShin", ninteiShinseiYMDKoShin);
        this.ninteiShinseiYMDKoShin = ninteiShinseiYMDKoShin;
    }

    public void setZenkaiNinteiYMD(RString zenkaiNinteiYMD) {
        this.setOriginalData("zenkaiNinteiYMD", zenkaiNinteiYMD);
        this.zenkaiNinteiYMD = zenkaiNinteiYMD;
    }

    public void setZenYokaigoKubunCode(RString zenYokaigoKubunCode) {
        this.setOriginalData("zenYokaigoKubunCode", zenYokaigoKubunCode);
        this.zenYokaigoKubunCode = zenYokaigoKubunCode;
    }

    public void setAge(RString age) {
        this.setOriginalData("age", age);
        this.age = age;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setNinteiChosaItakusakiCode(RString ninteiChosaItakusakiCode) {
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    public void setRenrakusakiYubinNo(RString renrakusakiYubinNo) {
        this.setOriginalData("renrakusakiYubinNo", renrakusakiYubinNo);
        this.renrakusakiYubinNo = renrakusakiYubinNo;
    }

    public void setRenrakusakiTelNo(RString renrakusakiTelNo) {
        this.setOriginalData("renrakusakiTelNo", renrakusakiTelNo);
        this.renrakusakiTelNo = renrakusakiTelNo;
    }

    public void setRenrakusakiKeitaiTelNo(RString renrakusakiKeitaiTelNo) {
        this.setOriginalData("renrakusakiKeitaiTelNo", renrakusakiKeitaiTelNo);
        this.renrakusakiKeitaiTelNo = renrakusakiKeitaiTelNo;
    }

    public void setRenrakusakiShimei(RString renrakusakiShimei) {
        this.setOriginalData("renrakusakiShimei", renrakusakiShimei);
        this.renrakusakiShimei = renrakusakiShimei;
    }

    public void setRenrakusakiTuzukigara(RString renrakusakiTuzukigara) {
        this.setOriginalData("renrakusakiTuzukigara", renrakusakiTuzukigara);
        this.renrakusakiTuzukigara = renrakusakiTuzukigara;
    }

    public void setRenrakusakiJusho(RString renrakusakiJusho) {
        this.setOriginalData("renrakusakiJusho", renrakusakiJusho);
        this.renrakusakiJusho = renrakusakiJusho;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    // </editor-fold>
}
