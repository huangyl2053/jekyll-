package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Feb 11 11:17:06 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHanteiTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHanteiTaishosha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-10_08-47-42">

    private RString columnState;
    private RString hanteiKekka;
    private RString hokensha;
    private RString hihokenNo;
    private RString hihokenshaName;
    private TextBoxFlexibleDate shinseibi;
    private RString shinseiKbnShin;
    private RString ikenshoJuryo;
    private TextBoxFlexibleDate ichijiHanteibi;
    private RString ichijiHanteiKubun;
    private RString ichijiHanteiKekka;
    private RString ichijiHanteiKekkaCode;
    private RString ichijiHanteiKekkaNinchishoKasan;
    private RString ichijiHanteiKekkaNinchishoKasanCode;
    private RString keikokuCode;
    private RString hiddenKeikokuCode;
    private TextBoxFlexibleDate chosaJissibi;
    private TextBoxFlexibleDate ikenshoJuryobi;
    private RString shinseishoKanriNo;
    private TextBoxNum kijunJikan;
    private TextBoxNum kijunJikanShokuji;
    private TextBoxNum kijunJikanHaisetsu;
    private TextBoxNum kijunJikanIdo;
    private TextBoxNum kijunJikanSeiketsuHoji;
    private TextBoxNum kijunJikanKansetsuCare;
    private TextBoxNum kijunJikanBPSDKanren;
    private TextBoxNum kijunJikanKinoKunren;
    private TextBoxNum kijunJikanIryoKanren;
    private TextBoxNum kijunJikanNinchishoKasan;
    private TextBoxNum chukanHyokaKomoku1gun;
    private TextBoxNum chukanHyokaKomoku2gun;
    private TextBoxNum chukanHyokaKomoku3gun;
    private TextBoxNum chukanHyokaKomoku4gun;
    private TextBoxNum chukanHyokaKomoku5gun;
    private RString ninteiChosaTorikomiUmu;
    private RString ninteiChosaNinchishodo;
    private RString ikenshoTorikomiUmu;
    private RString ikenshoNinchishodo;
    private TextBoxNum ninchishoJiritsudoIIijoNoGaizensei;
    private TextBoxNum hiddenNinchishoJiritsudoIIijoNoGaizensei;
    private RString jotaiAnteiseiCode;
    private RString suiteiKyufuKubunCode;
    private RString koroshoIfShikibetsuCode;

    public dgHanteiTaishosha_Row() {
        super();
        this.columnState = RString.EMPTY;
        this.hanteiKekka = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.hihokenNo = RString.EMPTY;
        this.hihokenshaName = RString.EMPTY;
        this.shinseibi = new TextBoxFlexibleDate();
        this.shinseiKbnShin = RString.EMPTY;
        this.ikenshoJuryo = RString.EMPTY;
        this.ichijiHanteibi = new TextBoxFlexibleDate();
        this.ichijiHanteiKubun = RString.EMPTY;
        this.ichijiHanteiKekka = RString.EMPTY;
        this.ichijiHanteiKekkaCode = RString.EMPTY;
        this.ichijiHanteiKekkaNinchishoKasan = RString.EMPTY;
        this.ichijiHanteiKekkaNinchishoKasanCode = RString.EMPTY;
        this.keikokuCode = RString.EMPTY;
        this.hiddenKeikokuCode = RString.EMPTY;
        this.chosaJissibi = new TextBoxFlexibleDate();
        this.ikenshoJuryobi = new TextBoxFlexibleDate();
        this.shinseishoKanriNo = RString.EMPTY;
        this.kijunJikan = new TextBoxNum();
        this.kijunJikanShokuji = new TextBoxNum();
        this.kijunJikanHaisetsu = new TextBoxNum();
        this.kijunJikanIdo = new TextBoxNum();
        this.kijunJikanSeiketsuHoji = new TextBoxNum();
        this.kijunJikanKansetsuCare = new TextBoxNum();
        this.kijunJikanBPSDKanren = new TextBoxNum();
        this.kijunJikanKinoKunren = new TextBoxNum();
        this.kijunJikanIryoKanren = new TextBoxNum();
        this.kijunJikanNinchishoKasan = new TextBoxNum();
        this.chukanHyokaKomoku1gun = new TextBoxNum();
        this.chukanHyokaKomoku2gun = new TextBoxNum();
        this.chukanHyokaKomoku3gun = new TextBoxNum();
        this.chukanHyokaKomoku4gun = new TextBoxNum();
        this.chukanHyokaKomoku5gun = new TextBoxNum();
        this.ninteiChosaTorikomiUmu = RString.EMPTY;
        this.ninteiChosaNinchishodo = RString.EMPTY;
        this.ikenshoTorikomiUmu = RString.EMPTY;
        this.ikenshoNinchishodo = RString.EMPTY;
        this.ninchishoJiritsudoIIijoNoGaizensei = new TextBoxNum();
        this.hiddenNinchishoJiritsudoIIijoNoGaizensei = new TextBoxNum();
        this.jotaiAnteiseiCode = RString.EMPTY;
        this.suiteiKyufuKubunCode = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenNo", hihokenNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.setOriginalData("ikenshoJuryo", ikenshoJuryo);
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.setOriginalData("ichijiHanteiKubun", ichijiHanteiKubun);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiKekkaCode", ichijiHanteiKekkaCode);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasan", ichijiHanteiKekkaNinchishoKasan);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.setOriginalData("keikokuCode", keikokuCode);
        this.setOriginalData("hiddenKeikokuCode", hiddenKeikokuCode);
        this.setOriginalData("chosaJissibi", chosaJissibi);
        this.setOriginalData("ikenshoJuryobi", ikenshoJuryobi);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("kijunJikan", kijunJikan);
        this.setOriginalData("kijunJikanShokuji", kijunJikanShokuji);
        this.setOriginalData("kijunJikanHaisetsu", kijunJikanHaisetsu);
        this.setOriginalData("kijunJikanIdo", kijunJikanIdo);
        this.setOriginalData("kijunJikanSeiketsuHoji", kijunJikanSeiketsuHoji);
        this.setOriginalData("kijunJikanKansetsuCare", kijunJikanKansetsuCare);
        this.setOriginalData("kijunJikanBPSDKanren", kijunJikanBPSDKanren);
        this.setOriginalData("kijunJikanKinoKunren", kijunJikanKinoKunren);
        this.setOriginalData("kijunJikanIryoKanren", kijunJikanIryoKanren);
        this.setOriginalData("kijunJikanNinchishoKasan", kijunJikanNinchishoKasan);
        this.setOriginalData("chukanHyokaKomoku1gun", chukanHyokaKomoku1gun);
        this.setOriginalData("chukanHyokaKomoku2gun", chukanHyokaKomoku2gun);
        this.setOriginalData("chukanHyokaKomoku3gun", chukanHyokaKomoku3gun);
        this.setOriginalData("chukanHyokaKomoku4gun", chukanHyokaKomoku4gun);
        this.setOriginalData("chukanHyokaKomoku5gun", chukanHyokaKomoku5gun);
        this.setOriginalData("ninteiChosaTorikomiUmu", ninteiChosaTorikomiUmu);
        this.setOriginalData("ninteiChosaNinchishodo", ninteiChosaNinchishodo);
        this.setOriginalData("ikenshoTorikomiUmu", ikenshoTorikomiUmu);
        this.setOriginalData("ikenshoNinchishodo", ikenshoNinchishodo);
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("hiddenNinchishoJiritsudoIIijoNoGaizensei", hiddenNinchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
    }

    public dgHanteiTaishosha_Row(RString columnState, RString hanteiKekka, RString hokensha, RString hihokenNo, RString hihokenshaName, TextBoxFlexibleDate shinseibi, RString shinseiKbnShin, RString ikenshoJuryo, TextBoxFlexibleDate ichijiHanteibi, RString ichijiHanteiKubun, RString ichijiHanteiKekka, RString ichijiHanteiKekkaCode, RString ichijiHanteiKekkaNinchishoKasan, RString ichijiHanteiKekkaNinchishoKasanCode, RString keikokuCode, RString hiddenKeikokuCode, TextBoxFlexibleDate chosaJissibi, TextBoxFlexibleDate ikenshoJuryobi, RString shinseishoKanriNo, TextBoxNum kijunJikan, TextBoxNum kijunJikanShokuji, TextBoxNum kijunJikanHaisetsu, TextBoxNum kijunJikanIdo, TextBoxNum kijunJikanSeiketsuHoji, TextBoxNum kijunJikanKansetsuCare, TextBoxNum kijunJikanBPSDKanren, TextBoxNum kijunJikanKinoKunren, TextBoxNum kijunJikanIryoKanren, TextBoxNum kijunJikanNinchishoKasan, TextBoxNum chukanHyokaKomoku1gun, TextBoxNum chukanHyokaKomoku2gun, TextBoxNum chukanHyokaKomoku3gun, TextBoxNum chukanHyokaKomoku4gun, TextBoxNum chukanHyokaKomoku5gun, RString ninteiChosaTorikomiUmu, RString ninteiChosaNinchishodo, RString ikenshoTorikomiUmu, RString ikenshoNinchishodo, TextBoxNum ninchishoJiritsudoIIijoNoGaizensei, TextBoxNum hiddenNinchishoJiritsudoIIijoNoGaizensei, RString jotaiAnteiseiCode, RString suiteiKyufuKubunCode, RString koroshoIfShikibetsuCode) {
        super();
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenNo", hihokenNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.setOriginalData("ikenshoJuryo", ikenshoJuryo);
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.setOriginalData("ichijiHanteiKubun", ichijiHanteiKubun);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiKekkaCode", ichijiHanteiKekkaCode);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasan", ichijiHanteiKekkaNinchishoKasan);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.setOriginalData("keikokuCode", keikokuCode);
        this.setOriginalData("hiddenKeikokuCode", hiddenKeikokuCode);
        this.setOriginalData("chosaJissibi", chosaJissibi);
        this.setOriginalData("ikenshoJuryobi", ikenshoJuryobi);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("kijunJikan", kijunJikan);
        this.setOriginalData("kijunJikanShokuji", kijunJikanShokuji);
        this.setOriginalData("kijunJikanHaisetsu", kijunJikanHaisetsu);
        this.setOriginalData("kijunJikanIdo", kijunJikanIdo);
        this.setOriginalData("kijunJikanSeiketsuHoji", kijunJikanSeiketsuHoji);
        this.setOriginalData("kijunJikanKansetsuCare", kijunJikanKansetsuCare);
        this.setOriginalData("kijunJikanBPSDKanren", kijunJikanBPSDKanren);
        this.setOriginalData("kijunJikanKinoKunren", kijunJikanKinoKunren);
        this.setOriginalData("kijunJikanIryoKanren", kijunJikanIryoKanren);
        this.setOriginalData("kijunJikanNinchishoKasan", kijunJikanNinchishoKasan);
        this.setOriginalData("chukanHyokaKomoku1gun", chukanHyokaKomoku1gun);
        this.setOriginalData("chukanHyokaKomoku2gun", chukanHyokaKomoku2gun);
        this.setOriginalData("chukanHyokaKomoku3gun", chukanHyokaKomoku3gun);
        this.setOriginalData("chukanHyokaKomoku4gun", chukanHyokaKomoku4gun);
        this.setOriginalData("chukanHyokaKomoku5gun", chukanHyokaKomoku5gun);
        this.setOriginalData("ninteiChosaTorikomiUmu", ninteiChosaTorikomiUmu);
        this.setOriginalData("ninteiChosaNinchishodo", ninteiChosaNinchishodo);
        this.setOriginalData("ikenshoTorikomiUmu", ikenshoTorikomiUmu);
        this.setOriginalData("ikenshoNinchishodo", ikenshoNinchishodo);
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("hiddenNinchishoJiritsudoIIijoNoGaizensei", hiddenNinchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.columnState = columnState;
        this.hanteiKekka = hanteiKekka;
        this.hokensha = hokensha;
        this.hihokenNo = hihokenNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseibi = shinseibi;
        this.shinseiKbnShin = shinseiKbnShin;
        this.ikenshoJuryo = ikenshoJuryo;
        this.ichijiHanteibi = ichijiHanteibi;
        this.ichijiHanteiKubun = ichijiHanteiKubun;
        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
        this.ichijiHanteiKekkaNinchishoKasan = ichijiHanteiKekkaNinchishoKasan;
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
        this.keikokuCode = keikokuCode;
        this.hiddenKeikokuCode = hiddenKeikokuCode;
        this.chosaJissibi = chosaJissibi;
        this.ikenshoJuryobi = ikenshoJuryobi;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.kijunJikan = kijunJikan;
        this.kijunJikanShokuji = kijunJikanShokuji;
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
        this.kijunJikanIdo = kijunJikanIdo;
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
        this.ninteiChosaTorikomiUmu = ninteiChosaTorikomiUmu;
        this.ninteiChosaNinchishodo = ninteiChosaNinchishodo;
        this.ikenshoTorikomiUmu = ikenshoTorikomiUmu;
        this.ikenshoNinchishodo = ikenshoNinchishodo;
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
        this.hiddenNinchishoJiritsudoIIijoNoGaizensei = hiddenNinchishoJiritsudoIIijoNoGaizensei;
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public RString getColumnState() {
        return columnState;
    }

    public RString getHanteiKekka() {
        return hanteiKekka;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenNo() {
        return hihokenNo;
    }

    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    public TextBoxFlexibleDate getShinseibi() {
        return shinseibi;
    }

    public RString getShinseiKbnShin() {
        return shinseiKbnShin;
    }

    public RString getIkenshoJuryo() {
        return ikenshoJuryo;
    }

    public TextBoxFlexibleDate getIchijiHanteibi() {
        return ichijiHanteibi;
    }

    public RString getIchijiHanteiKubun() {
        return ichijiHanteiKubun;
    }

    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    public RString getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    public RString getIchijiHanteiKekkaNinchishoKasan() {
        return ichijiHanteiKekkaNinchishoKasan;
    }

    public RString getIchijiHanteiKekkaNinchishoKasanCode() {
        return ichijiHanteiKekkaNinchishoKasanCode;
    }

    public RString getKeikokuCode() {
        return keikokuCode;
    }

    public RString getHiddenKeikokuCode() {
        return hiddenKeikokuCode;
    }

    public TextBoxFlexibleDate getChosaJissibi() {
        return chosaJissibi;
    }

    public TextBoxFlexibleDate getIkenshoJuryobi() {
        return ikenshoJuryobi;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public TextBoxNum getKijunJikan() {
        return kijunJikan;
    }

    public TextBoxNum getKijunJikanShokuji() {
        return kijunJikanShokuji;
    }

    public TextBoxNum getKijunJikanHaisetsu() {
        return kijunJikanHaisetsu;
    }

    public TextBoxNum getKijunJikanIdo() {
        return kijunJikanIdo;
    }

    public TextBoxNum getKijunJikanSeiketsuHoji() {
        return kijunJikanSeiketsuHoji;
    }

    public TextBoxNum getKijunJikanKansetsuCare() {
        return kijunJikanKansetsuCare;
    }

    public TextBoxNum getKijunJikanBPSDKanren() {
        return kijunJikanBPSDKanren;
    }

    public TextBoxNum getKijunJikanKinoKunren() {
        return kijunJikanKinoKunren;
    }

    public TextBoxNum getKijunJikanIryoKanren() {
        return kijunJikanIryoKanren;
    }

    public TextBoxNum getKijunJikanNinchishoKasan() {
        return kijunJikanNinchishoKasan;
    }

    public TextBoxNum getChukanHyokaKomoku1gun() {
        return chukanHyokaKomoku1gun;
    }

    public TextBoxNum getChukanHyokaKomoku2gun() {
        return chukanHyokaKomoku2gun;
    }

    public TextBoxNum getChukanHyokaKomoku3gun() {
        return chukanHyokaKomoku3gun;
    }

    public TextBoxNum getChukanHyokaKomoku4gun() {
        return chukanHyokaKomoku4gun;
    }

    public TextBoxNum getChukanHyokaKomoku5gun() {
        return chukanHyokaKomoku5gun;
    }

    public RString getNinteiChosaTorikomiUmu() {
        return ninteiChosaTorikomiUmu;
    }

    public RString getNinteiChosaNinchishodo() {
        return ninteiChosaNinchishodo;
    }

    public RString getIkenshoTorikomiUmu() {
        return ikenshoTorikomiUmu;
    }

    public RString getIkenshoNinchishodo() {
        return ikenshoNinchishodo;
    }

    public TextBoxNum getNinchishoJiritsudoIIijoNoGaizensei() {
        return ninchishoJiritsudoIIijoNoGaizensei;
    }

    public TextBoxNum getHiddenNinchishoJiritsudoIIijoNoGaizensei() {
        return hiddenNinchishoJiritsudoIIijoNoGaizensei;
    }

    public RString getJotaiAnteiseiCode() {
        return jotaiAnteiseiCode;
    }

    public RString getSuiteiKyufuKubunCode() {
        return suiteiKyufuKubunCode;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public void setColumnState(RString columnState) {
        this.setOriginalData("columnState", columnState);
        this.columnState = columnState;
    }

    public void setHanteiKekka(RString hanteiKekka) {
        this.setOriginalData("hanteiKekka", hanteiKekka);
        this.hanteiKekka = hanteiKekka;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenNo(RString hihokenNo) {
        this.setOriginalData("hihokenNo", hihokenNo);
        this.hihokenNo = hihokenNo;
    }

    public void setHihokenshaName(RString hihokenshaName) {
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.hihokenshaName = hihokenshaName;
    }

    public void setShinseibi(TextBoxFlexibleDate shinseibi) {
        this.setOriginalData("shinseibi", shinseibi);
        this.shinseibi = shinseibi;
    }

    public void setShinseiKbnShin(RString shinseiKbnShin) {
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.shinseiKbnShin = shinseiKbnShin;
    }

    public void setIkenshoJuryo(RString ikenshoJuryo) {
        this.setOriginalData("ikenshoJuryo", ikenshoJuryo);
        this.ikenshoJuryo = ikenshoJuryo;
    }

    public void setIchijiHanteibi(TextBoxFlexibleDate ichijiHanteibi) {
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.ichijiHanteibi = ichijiHanteibi;
    }

    public void setIchijiHanteiKubun(RString ichijiHanteiKubun) {
        this.setOriginalData("ichijiHanteiKubun", ichijiHanteiKubun);
        this.ichijiHanteiKubun = ichijiHanteiKubun;
    }

    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    public void setIchijiHanteiKekkaCode(RString ichijiHanteiKekkaCode) {
        this.setOriginalData("ichijiHanteiKekkaCode", ichijiHanteiKekkaCode);
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    public void setIchijiHanteiKekkaNinchishoKasan(RString ichijiHanteiKekkaNinchishoKasan) {
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasan", ichijiHanteiKekkaNinchishoKasan);
        this.ichijiHanteiKekkaNinchishoKasan = ichijiHanteiKekkaNinchishoKasan;
    }

    public void setIchijiHanteiKekkaNinchishoKasanCode(RString ichijiHanteiKekkaNinchishoKasanCode) {
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
    }

    public void setKeikokuCode(RString keikokuCode) {
        this.setOriginalData("keikokuCode", keikokuCode);
        this.keikokuCode = keikokuCode;
    }

    public void setHiddenKeikokuCode(RString hiddenKeikokuCode) {
        this.setOriginalData("hiddenKeikokuCode", hiddenKeikokuCode);
        this.hiddenKeikokuCode = hiddenKeikokuCode;
    }

    public void setChosaJissibi(TextBoxFlexibleDate chosaJissibi) {
        this.setOriginalData("chosaJissibi", chosaJissibi);
        this.chosaJissibi = chosaJissibi;
    }

    public void setIkenshoJuryobi(TextBoxFlexibleDate ikenshoJuryobi) {
        this.setOriginalData("ikenshoJuryobi", ikenshoJuryobi);
        this.ikenshoJuryobi = ikenshoJuryobi;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setKijunJikan(TextBoxNum kijunJikan) {
        this.setOriginalData("kijunJikan", kijunJikan);
        this.kijunJikan = kijunJikan;
    }

    public void setKijunJikanShokuji(TextBoxNum kijunJikanShokuji) {
        this.setOriginalData("kijunJikanShokuji", kijunJikanShokuji);
        this.kijunJikanShokuji = kijunJikanShokuji;
    }

    public void setKijunJikanHaisetsu(TextBoxNum kijunJikanHaisetsu) {
        this.setOriginalData("kijunJikanHaisetsu", kijunJikanHaisetsu);
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
    }

    public void setKijunJikanIdo(TextBoxNum kijunJikanIdo) {
        this.setOriginalData("kijunJikanIdo", kijunJikanIdo);
        this.kijunJikanIdo = kijunJikanIdo;
    }

    public void setKijunJikanSeiketsuHoji(TextBoxNum kijunJikanSeiketsuHoji) {
        this.setOriginalData("kijunJikanSeiketsuHoji", kijunJikanSeiketsuHoji);
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
    }

    public void setKijunJikanKansetsuCare(TextBoxNum kijunJikanKansetsuCare) {
        this.setOriginalData("kijunJikanKansetsuCare", kijunJikanKansetsuCare);
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
    }

    public void setKijunJikanBPSDKanren(TextBoxNum kijunJikanBPSDKanren) {
        this.setOriginalData("kijunJikanBPSDKanren", kijunJikanBPSDKanren);
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
    }

    public void setKijunJikanKinoKunren(TextBoxNum kijunJikanKinoKunren) {
        this.setOriginalData("kijunJikanKinoKunren", kijunJikanKinoKunren);
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
    }

    public void setKijunJikanIryoKanren(TextBoxNum kijunJikanIryoKanren) {
        this.setOriginalData("kijunJikanIryoKanren", kijunJikanIryoKanren);
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
    }

    public void setKijunJikanNinchishoKasan(TextBoxNum kijunJikanNinchishoKasan) {
        this.setOriginalData("kijunJikanNinchishoKasan", kijunJikanNinchishoKasan);
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
    }

    public void setChukanHyokaKomoku1gun(TextBoxNum chukanHyokaKomoku1gun) {
        this.setOriginalData("chukanHyokaKomoku1gun", chukanHyokaKomoku1gun);
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
    }

    public void setChukanHyokaKomoku2gun(TextBoxNum chukanHyokaKomoku2gun) {
        this.setOriginalData("chukanHyokaKomoku2gun", chukanHyokaKomoku2gun);
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
    }

    public void setChukanHyokaKomoku3gun(TextBoxNum chukanHyokaKomoku3gun) {
        this.setOriginalData("chukanHyokaKomoku3gun", chukanHyokaKomoku3gun);
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
    }

    public void setChukanHyokaKomoku4gun(TextBoxNum chukanHyokaKomoku4gun) {
        this.setOriginalData("chukanHyokaKomoku4gun", chukanHyokaKomoku4gun);
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
    }

    public void setChukanHyokaKomoku5gun(TextBoxNum chukanHyokaKomoku5gun) {
        this.setOriginalData("chukanHyokaKomoku5gun", chukanHyokaKomoku5gun);
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
    }

    public void setNinteiChosaTorikomiUmu(RString ninteiChosaTorikomiUmu) {
        this.setOriginalData("ninteiChosaTorikomiUmu", ninteiChosaTorikomiUmu);
        this.ninteiChosaTorikomiUmu = ninteiChosaTorikomiUmu;
    }

    public void setNinteiChosaNinchishodo(RString ninteiChosaNinchishodo) {
        this.setOriginalData("ninteiChosaNinchishodo", ninteiChosaNinchishodo);
        this.ninteiChosaNinchishodo = ninteiChosaNinchishodo;
    }

    public void setIkenshoTorikomiUmu(RString ikenshoTorikomiUmu) {
        this.setOriginalData("ikenshoTorikomiUmu", ikenshoTorikomiUmu);
        this.ikenshoTorikomiUmu = ikenshoTorikomiUmu;
    }

    public void setIkenshoNinchishodo(RString ikenshoNinchishodo) {
        this.setOriginalData("ikenshoNinchishodo", ikenshoNinchishodo);
        this.ikenshoNinchishodo = ikenshoNinchishodo;
    }

    public void setNinchishoJiritsudoIIijoNoGaizensei(TextBoxNum ninchishoJiritsudoIIijoNoGaizensei) {
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
    }

    public void setHiddenNinchishoJiritsudoIIijoNoGaizensei(TextBoxNum hiddenNinchishoJiritsudoIIijoNoGaizensei) {
        this.setOriginalData("hiddenNinchishoJiritsudoIIijoNoGaizensei", hiddenNinchishoJiritsudoIIijoNoGaizensei);
        this.hiddenNinchishoJiritsudoIIijoNoGaizensei = hiddenNinchishoJiritsudoIIijoNoGaizensei;
    }

    public void setJotaiAnteiseiCode(RString jotaiAnteiseiCode) {
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    public void setSuiteiKyufuKubunCode(RString suiteiKyufuKubunCode) {
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    // </editor-fold>
}
