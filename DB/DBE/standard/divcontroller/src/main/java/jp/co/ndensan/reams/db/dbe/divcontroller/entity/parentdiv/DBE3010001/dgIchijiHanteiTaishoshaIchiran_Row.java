package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Aug 06 14:21:15 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgIchijiHanteiTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIchijiHanteiTaishoshaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private ButtonDialog btnSyokai;
    private ButtonDialog btnSentaku;
    private RString columnState;
    private RString hokensha;
    private RString hihokenNo;
    private RString hihokenshaName;
    private TextBoxFlexibleDate shinseibi;
    private RString shinseiKbnShin;
    private TextBoxFlexibleDate ichijiHanteibi;
    private RString ichijiHanteiKekka;
    private RString ichijiHanteiKekkaNinchishoKasanCode;
    private RString keikokuCode;
    private TextBoxFlexibleDate chosaJissibi;
    private TextBoxFlexibleDate ikenshoJuryobi;
    private RString shinseishoKanriNo;
    private RString kijunJikan;
    private RString kijunJikanShokuji;
    private RString kijunJikanHaisetsu;
    private RString kijunJikanIdo;
    private RString kijunJikanSeiketsuHoji;
    private RString kijunJikanKansetsuCare;
    private RString kijunJikanBPSDKanren;
    private RString kijunJikanKinoKunren;
    private RString kijunJikanIryoKanren;
    private RString kijunJikanNinchishoKasan;
    private RString chukanHyokaKomoku1gun;
    private RString chukanHyokaKomoku2gun;
    private RString chukanHyokaKomoku3gun;
    private RString chukanHyokaKomoku4gun;
    private RString chukanHyokaKomoku5gun;
    private RString jotaiAnteiseiCode;
    private RString ninchishoJiritsudoIIijoNoGaizensei;
    private RString suiteiKyufuKubunCode;
    private RString chosahyoCount;
    private RString ikenshoCount;
    private RString koroshoIfShikibetsuCode;

    public dgIchijiHanteiTaishoshaIchiran_Row() {
        super();
        this.btnSyokai = new ButtonDialog();
        this.btnSentaku = new ButtonDialog();
        this.columnState = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.hihokenNo = RString.EMPTY;
        this.hihokenshaName = RString.EMPTY;
        this.shinseibi = new TextBoxFlexibleDate();
        this.shinseiKbnShin = RString.EMPTY;
        this.ichijiHanteibi = new TextBoxFlexibleDate();
        this.ichijiHanteiKekka = RString.EMPTY;
        this.ichijiHanteiKekkaNinchishoKasanCode = RString.EMPTY;
        this.keikokuCode = RString.EMPTY;
        this.chosaJissibi = new TextBoxFlexibleDate();
        this.ikenshoJuryobi = new TextBoxFlexibleDate();
        this.shinseishoKanriNo = RString.EMPTY;
        this.kijunJikan = RString.EMPTY;
        this.kijunJikanShokuji = RString.EMPTY;
        this.kijunJikanHaisetsu = RString.EMPTY;
        this.kijunJikanIdo = RString.EMPTY;
        this.kijunJikanSeiketsuHoji = RString.EMPTY;
        this.kijunJikanKansetsuCare = RString.EMPTY;
        this.kijunJikanBPSDKanren = RString.EMPTY;
        this.kijunJikanKinoKunren = RString.EMPTY;
        this.kijunJikanIryoKanren = RString.EMPTY;
        this.kijunJikanNinchishoKasan = RString.EMPTY;
        this.chukanHyokaKomoku1gun = RString.EMPTY;
        this.chukanHyokaKomoku2gun = RString.EMPTY;
        this.chukanHyokaKomoku3gun = RString.EMPTY;
        this.chukanHyokaKomoku4gun = RString.EMPTY;
        this.chukanHyokaKomoku5gun = RString.EMPTY;
        this.jotaiAnteiseiCode = RString.EMPTY;
        this.ninchishoJiritsudoIIijoNoGaizensei = RString.EMPTY;
        this.suiteiKyufuKubunCode = RString.EMPTY;
        this.chosahyoCount = RString.EMPTY;
        this.ikenshoCount = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.setOriginalData("btnSyokai", btnSyokai);
        this.setOriginalData("btnSentaku", btnSentaku);
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenNo", hihokenNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.setOriginalData("keikokuCode", keikokuCode);
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
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.setOriginalData("chosahyoCount", chosahyoCount);
        this.setOriginalData("ikenshoCount", ikenshoCount);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
    }

    public dgIchijiHanteiTaishoshaIchiran_Row(ButtonDialog btnSyokai, ButtonDialog btnSentaku, RString columnState, RString hokensha, RString hihokenNo, RString hihokenshaName, TextBoxFlexibleDate shinseibi, RString shinseiKbnShin, TextBoxFlexibleDate ichijiHanteibi, RString ichijiHanteiKekka, RString ichijiHanteiKekkaNinchishoKasanCode, RString keikokuCode, TextBoxFlexibleDate chosaJissibi, TextBoxFlexibleDate ikenshoJuryobi, RString shinseishoKanriNo, RString kijunJikan, RString kijunJikanShokuji, RString kijunJikanHaisetsu, RString kijunJikanIdo, RString kijunJikanSeiketsuHoji, RString kijunJikanKansetsuCare, RString kijunJikanBPSDKanren, RString kijunJikanKinoKunren, RString kijunJikanIryoKanren, RString kijunJikanNinchishoKasan, RString chukanHyokaKomoku1gun, RString chukanHyokaKomoku2gun, RString chukanHyokaKomoku3gun, RString chukanHyokaKomoku4gun, RString chukanHyokaKomoku5gun, RString jotaiAnteiseiCode, RString ninchishoJiritsudoIIijoNoGaizensei, RString suiteiKyufuKubunCode, RString chosahyoCount, RString ikenshoCount, RString koroshoIfShikibetsuCode) {
        super();
        this.setOriginalData("btnSyokai", btnSyokai);
        this.setOriginalData("btnSentaku", btnSentaku);
        this.setOriginalData("columnState", columnState);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenNo", hihokenNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.setOriginalData("keikokuCode", keikokuCode);
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
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.setOriginalData("chosahyoCount", chosahyoCount);
        this.setOriginalData("ikenshoCount", ikenshoCount);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.btnSyokai = btnSyokai;
        this.btnSentaku = btnSentaku;
        this.columnState = columnState;
        this.hokensha = hokensha;
        this.hihokenNo = hihokenNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseibi = shinseibi;
        this.shinseiKbnShin = shinseiKbnShin;
        this.ichijiHanteibi = ichijiHanteibi;
        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
        this.keikokuCode = keikokuCode;
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
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
        this.chosahyoCount = chosahyoCount;
        this.ikenshoCount = ikenshoCount;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public ButtonDialog getBtnSyokai() {
        return btnSyokai;
    }

    public ButtonDialog getBtnSentaku() {
        return btnSentaku;
    }

    public RString getColumnState() {
        return columnState;
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

    public TextBoxFlexibleDate getIchijiHanteibi() {
        return ichijiHanteibi;
    }

    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    public RString getIchijiHanteiKekkaNinchishoKasanCode() {
        return ichijiHanteiKekkaNinchishoKasanCode;
    }

    public RString getKeikokuCode() {
        return keikokuCode;
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

    public RString getKijunJikan() {
        return kijunJikan;
    }

    public RString getKijunJikanShokuji() {
        return kijunJikanShokuji;
    }

    public RString getKijunJikanHaisetsu() {
        return kijunJikanHaisetsu;
    }

    public RString getKijunJikanIdo() {
        return kijunJikanIdo;
    }

    public RString getKijunJikanSeiketsuHoji() {
        return kijunJikanSeiketsuHoji;
    }

    public RString getKijunJikanKansetsuCare() {
        return kijunJikanKansetsuCare;
    }

    public RString getKijunJikanBPSDKanren() {
        return kijunJikanBPSDKanren;
    }

    public RString getKijunJikanKinoKunren() {
        return kijunJikanKinoKunren;
    }

    public RString getKijunJikanIryoKanren() {
        return kijunJikanIryoKanren;
    }

    public RString getKijunJikanNinchishoKasan() {
        return kijunJikanNinchishoKasan;
    }

    public RString getChukanHyokaKomoku1gun() {
        return chukanHyokaKomoku1gun;
    }

    public RString getChukanHyokaKomoku2gun() {
        return chukanHyokaKomoku2gun;
    }

    public RString getChukanHyokaKomoku3gun() {
        return chukanHyokaKomoku3gun;
    }

    public RString getChukanHyokaKomoku4gun() {
        return chukanHyokaKomoku4gun;
    }

    public RString getChukanHyokaKomoku5gun() {
        return chukanHyokaKomoku5gun;
    }

    public RString getJotaiAnteiseiCode() {
        return jotaiAnteiseiCode;
    }

    public RString getNinchishoJiritsudoIIijoNoGaizensei() {
        return ninchishoJiritsudoIIijoNoGaizensei;
    }

    public RString getSuiteiKyufuKubunCode() {
        return suiteiKyufuKubunCode;
    }

    public RString getChosahyoCount() {
        return chosahyoCount;
    }

    public RString getIkenshoCount() {
        return ikenshoCount;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public void setBtnSyokai(ButtonDialog btnSyokai) {
        this.setOriginalData("btnSyokai", btnSyokai);
        this.btnSyokai = btnSyokai;
    }

    public void setBtnSentaku(ButtonDialog btnSentaku) {
        this.setOriginalData("btnSentaku", btnSentaku);
        this.btnSentaku = btnSentaku;
    }

    public void setColumnState(RString columnState) {
        this.setOriginalData("columnState", columnState);
        this.columnState = columnState;
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

    public void setIchijiHanteibi(TextBoxFlexibleDate ichijiHanteibi) {
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.ichijiHanteibi = ichijiHanteibi;
    }

    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    public void setIchijiHanteiKekkaNinchishoKasanCode(RString ichijiHanteiKekkaNinchishoKasanCode) {
        this.setOriginalData("ichijiHanteiKekkaNinchishoKasanCode", ichijiHanteiKekkaNinchishoKasanCode);
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
    }

    public void setKeikokuCode(RString keikokuCode) {
        this.setOriginalData("keikokuCode", keikokuCode);
        this.keikokuCode = keikokuCode;
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

    public void setKijunJikan(RString kijunJikan) {
        this.setOriginalData("kijunJikan", kijunJikan);
        this.kijunJikan = kijunJikan;
    }

    public void setKijunJikanShokuji(RString kijunJikanShokuji) {
        this.setOriginalData("kijunJikanShokuji", kijunJikanShokuji);
        this.kijunJikanShokuji = kijunJikanShokuji;
    }

    public void setKijunJikanHaisetsu(RString kijunJikanHaisetsu) {
        this.setOriginalData("kijunJikanHaisetsu", kijunJikanHaisetsu);
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
    }

    public void setKijunJikanIdo(RString kijunJikanIdo) {
        this.setOriginalData("kijunJikanIdo", kijunJikanIdo);
        this.kijunJikanIdo = kijunJikanIdo;
    }

    public void setKijunJikanSeiketsuHoji(RString kijunJikanSeiketsuHoji) {
        this.setOriginalData("kijunJikanSeiketsuHoji", kijunJikanSeiketsuHoji);
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
    }

    public void setKijunJikanKansetsuCare(RString kijunJikanKansetsuCare) {
        this.setOriginalData("kijunJikanKansetsuCare", kijunJikanKansetsuCare);
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
    }

    public void setKijunJikanBPSDKanren(RString kijunJikanBPSDKanren) {
        this.setOriginalData("kijunJikanBPSDKanren", kijunJikanBPSDKanren);
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
    }

    public void setKijunJikanKinoKunren(RString kijunJikanKinoKunren) {
        this.setOriginalData("kijunJikanKinoKunren", kijunJikanKinoKunren);
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
    }

    public void setKijunJikanIryoKanren(RString kijunJikanIryoKanren) {
        this.setOriginalData("kijunJikanIryoKanren", kijunJikanIryoKanren);
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
    }

    public void setKijunJikanNinchishoKasan(RString kijunJikanNinchishoKasan) {
        this.setOriginalData("kijunJikanNinchishoKasan", kijunJikanNinchishoKasan);
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
    }

    public void setChukanHyokaKomoku1gun(RString chukanHyokaKomoku1gun) {
        this.setOriginalData("chukanHyokaKomoku1gun", chukanHyokaKomoku1gun);
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
    }

    public void setChukanHyokaKomoku2gun(RString chukanHyokaKomoku2gun) {
        this.setOriginalData("chukanHyokaKomoku2gun", chukanHyokaKomoku2gun);
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
    }

    public void setChukanHyokaKomoku3gun(RString chukanHyokaKomoku3gun) {
        this.setOriginalData("chukanHyokaKomoku3gun", chukanHyokaKomoku3gun);
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
    }

    public void setChukanHyokaKomoku4gun(RString chukanHyokaKomoku4gun) {
        this.setOriginalData("chukanHyokaKomoku4gun", chukanHyokaKomoku4gun);
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
    }

    public void setChukanHyokaKomoku5gun(RString chukanHyokaKomoku5gun) {
        this.setOriginalData("chukanHyokaKomoku5gun", chukanHyokaKomoku5gun);
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
    }

    public void setJotaiAnteiseiCode(RString jotaiAnteiseiCode) {
        this.setOriginalData("jotaiAnteiseiCode", jotaiAnteiseiCode);
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    public void setNinchishoJiritsudoIIijoNoGaizensei(RString ninchishoJiritsudoIIijoNoGaizensei) {
        this.setOriginalData("ninchishoJiritsudoIIijoNoGaizensei", ninchishoJiritsudoIIijoNoGaizensei);
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
    }

    public void setSuiteiKyufuKubunCode(RString suiteiKyufuKubunCode) {
        this.setOriginalData("suiteiKyufuKubunCode", suiteiKyufuKubunCode);
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
    }

    public void setChosahyoCount(RString chosahyoCount) {
        this.setOriginalData("chosahyoCount", chosahyoCount);
        this.chosahyoCount = chosahyoCount;
    }

    public void setIkenshoCount(RString ikenshoCount) {
        this.setOriginalData("ikenshoCount", ikenshoCount);
        this.ikenshoCount = ikenshoCount;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    // </editor-fold>
}
