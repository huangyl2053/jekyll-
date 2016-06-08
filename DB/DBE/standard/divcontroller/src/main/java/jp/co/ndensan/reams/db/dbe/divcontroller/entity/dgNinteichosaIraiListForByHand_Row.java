package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 16:01:48 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgNinteichosaIraiListForByHand_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteichosaIraiListForByHand_Row extends DataRow {

    private Boolean chosaKanryoFlag;
    private RString chosaJokyo;
    private Button btnToShowDetail;
    private RString hokenshaNo;
    private RString shichoson;
    private RString shishoCode;
    private RString shoshoName;
    private RString hihokenshaNo;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiWithKana;
    private RString ninteiShinseiKubun;
    private TextBoxFlexibleDate ninteiShinseiDate;
    private RString chiku;
    private RString chosaIraiKubun;
    private TextBoxFlexibleDate chosaIraiDate;
    private TextBoxFlexibleDate chosaKigenDate;
    private TextBoxFlexibleDate iraishoHakkoDate;
    private RString chosaItakusakiNo;
    private RString chosaItakusakiName;
    private RString chosainNo;
    private RString chosainName;
    private RString chosaItakusakiNo1TA;
    private RString chosaItakusakiName1TA;
    private RString chosainNo1TA;
    private RString chosainName1TA;
    private RString chosaItakusakiNo2TA;
    private RString chosaItakusakiName2TA;
    private RString chosainNo2TA;
    private RString chosainName2TA;
    private TextBoxFlexibleDate tokusokuDate;
    private RString tokusokuCount;
    private RString yubinNo;
    private RString jusho;
    private RString nyushoShisetsu;

    public dgNinteichosaIraiListForByHand_Row() {
        super();
        this.chosaKanryoFlag = false;
        this.chosaJokyo = RString.EMPTY;
        this.btnToShowDetail = new Button();
        this.hokenshaNo = RString.EMPTY;
        this.shichoson = RString.EMPTY;
        this.shishoCode = RString.EMPTY;
        this.shoshoName = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiWithKana = RString.EMPTY;
        this.ninteiShinseiKubun = RString.EMPTY;
        this.ninteiShinseiDate = new TextBoxFlexibleDate();
        this.chiku = RString.EMPTY;
        this.chosaIraiKubun = RString.EMPTY;
        this.chosaIraiDate = new TextBoxFlexibleDate();
        this.chosaKigenDate = new TextBoxFlexibleDate();
        this.iraishoHakkoDate = new TextBoxFlexibleDate();
        this.chosaItakusakiNo = RString.EMPTY;
        this.chosaItakusakiName = RString.EMPTY;
        this.chosainNo = RString.EMPTY;
        this.chosainName = RString.EMPTY;
        this.chosaItakusakiNo1TA = RString.EMPTY;
        this.chosaItakusakiName1TA = RString.EMPTY;
        this.chosainNo1TA = RString.EMPTY;
        this.chosainName1TA = RString.EMPTY;
        this.chosaItakusakiNo2TA = RString.EMPTY;
        this.chosaItakusakiName2TA = RString.EMPTY;
        this.chosainNo2TA = RString.EMPTY;
        this.chosainName2TA = RString.EMPTY;
        this.tokusokuDate = new TextBoxFlexibleDate();
        this.tokusokuCount = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
    }

    public dgNinteichosaIraiListForByHand_Row(Boolean chosaKanryoFlag, RString chosaJokyo, Button btnToShowDetail, RString hokenshaNo, RString shichoson, RString shishoCode, RString shoshoName, RString hihokenshaNo, RString shimei, RString kanaShimei, RString shimeiWithKana, RString ninteiShinseiKubun, TextBoxFlexibleDate ninteiShinseiDate, RString chiku, RString chosaIraiKubun, TextBoxFlexibleDate chosaIraiDate, TextBoxFlexibleDate chosaKigenDate, TextBoxFlexibleDate iraishoHakkoDate, RString chosaItakusakiNo, RString chosaItakusakiName, RString chosainNo, RString chosainName, RString chosaItakusakiNo1TA, RString chosaItakusakiName1TA, RString chosainNo1TA, RString chosainName1TA, RString chosaItakusakiNo2TA, RString chosaItakusakiName2TA, RString chosainNo2TA, RString chosainName2TA, TextBoxFlexibleDate tokusokuDate, RString tokusokuCount, RString yubinNo, RString jusho, RString nyushoShisetsu) {
        super();
        this.setOriginalData("chosaKanryoFlag", chosaKanryoFlag);
        this.setOriginalData("chosaJokyo", chosaJokyo);
        this.setOriginalData("btnToShowDetail", btnToShowDetail);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("shishoCode", shishoCode);
        this.setOriginalData("shoshoName", shoshoName);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiWithKana", shimeiWithKana);
        this.setOriginalData("ninteiShinseiKubun", ninteiShinseiKubun);
        this.setOriginalData("ninteiShinseiDate", ninteiShinseiDate);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.setOriginalData("chosaIraiDate", chosaIraiDate);
        this.setOriginalData("chosaKigenDate", chosaKigenDate);
        this.setOriginalData("iraishoHakkoDate", iraishoHakkoDate);
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.setOriginalData("chosainNo", chosainNo);
        this.setOriginalData("chosainName", chosainName);
        this.setOriginalData("chosaItakusakiNo1TA", chosaItakusakiNo1TA);
        this.setOriginalData("chosaItakusakiName1TA", chosaItakusakiName1TA);
        this.setOriginalData("chosainNo1TA", chosainNo1TA);
        this.setOriginalData("chosainName1TA", chosainName1TA);
        this.setOriginalData("chosaItakusakiNo2TA", chosaItakusakiNo2TA);
        this.setOriginalData("chosaItakusakiName2TA", chosaItakusakiName2TA);
        this.setOriginalData("chosainNo2TA", chosainNo2TA);
        this.setOriginalData("chosainName2TA", chosainName2TA);
        this.setOriginalData("tokusokuDate", tokusokuDate);
        this.setOriginalData("tokusokuCount", tokusokuCount);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.chosaKanryoFlag = chosaKanryoFlag;
        this.chosaJokyo = chosaJokyo;
        this.btnToShowDetail = btnToShowDetail;
        this.hokenshaNo = hokenshaNo;
        this.shichoson = shichoson;
        this.shishoCode = shishoCode;
        this.shoshoName = shoshoName;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiWithKana = shimeiWithKana;
        this.ninteiShinseiKubun = ninteiShinseiKubun;
        this.ninteiShinseiDate = ninteiShinseiDate;
        this.chiku = chiku;
        this.chosaIraiKubun = chosaIraiKubun;
        this.chosaIraiDate = chosaIraiDate;
        this.chosaKigenDate = chosaKigenDate;
        this.iraishoHakkoDate = iraishoHakkoDate;
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
        this.chosainNo = chosainNo;
        this.chosainName = chosainName;
        this.chosaItakusakiNo1TA = chosaItakusakiNo1TA;
        this.chosaItakusakiName1TA = chosaItakusakiName1TA;
        this.chosainNo1TA = chosainNo1TA;
        this.chosainName1TA = chosainName1TA;
        this.chosaItakusakiNo2TA = chosaItakusakiNo2TA;
        this.chosaItakusakiName2TA = chosaItakusakiName2TA;
        this.chosainNo2TA = chosainNo2TA;
        this.chosainName2TA = chosainName2TA;
        this.tokusokuDate = tokusokuDate;
        this.tokusokuCount = tokusokuCount;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public Boolean getChosaKanryoFlag() {
        return chosaKanryoFlag;
    }

    public RString getChosaJokyo() {
        return chosaJokyo;
    }

    public Button getBtnToShowDetail() {
        return btnToShowDetail;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getShichoson() {
        return shichoson;
    }

    public RString getShishoCode() {
        return shishoCode;
    }

    public RString getShoshoName() {
        return shoshoName;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiWithKana() {
        return shimeiWithKana;
    }

    public RString getNinteiShinseiKubun() {
        return ninteiShinseiKubun;
    }

    public TextBoxFlexibleDate getNinteiShinseiDate() {
        return ninteiShinseiDate;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getChosaIraiKubun() {
        return chosaIraiKubun;
    }

    public TextBoxFlexibleDate getChosaIraiDate() {
        return chosaIraiDate;
    }

    public TextBoxFlexibleDate getChosaKigenDate() {
        return chosaKigenDate;
    }

    public TextBoxFlexibleDate getIraishoHakkoDate() {
        return iraishoHakkoDate;
    }

    public RString getChosaItakusakiNo() {
        return chosaItakusakiNo;
    }

    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    public RString getChosainNo() {
        return chosainNo;
    }

    public RString getChosainName() {
        return chosainName;
    }

    public RString getChosaItakusakiNo1TA() {
        return chosaItakusakiNo1TA;
    }

    public RString getChosaItakusakiName1TA() {
        return chosaItakusakiName1TA;
    }

    public RString getChosainNo1TA() {
        return chosainNo1TA;
    }

    public RString getChosainName1TA() {
        return chosainName1TA;
    }

    public RString getChosaItakusakiNo2TA() {
        return chosaItakusakiNo2TA;
    }

    public RString getChosaItakusakiName2TA() {
        return chosaItakusakiName2TA;
    }

    public RString getChosainNo2TA() {
        return chosainNo2TA;
    }

    public RString getChosainName2TA() {
        return chosainName2TA;
    }

    public TextBoxFlexibleDate getTokusokuDate() {
        return tokusokuDate;
    }

    public RString getTokusokuCount() {
        return tokusokuCount;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public void setChosaKanryoFlag(Boolean chosaKanryoFlag) {
        this.setOriginalData("chosaKanryoFlag", chosaKanryoFlag);
        this.chosaKanryoFlag = chosaKanryoFlag;
    }

    public void setChosaJokyo(RString chosaJokyo) {
        this.setOriginalData("chosaJokyo", chosaJokyo);
        this.chosaJokyo = chosaJokyo;
    }

    public void setBtnToShowDetail(Button btnToShowDetail) {
        this.setOriginalData("btnToShowDetail", btnToShowDetail);
        this.btnToShowDetail = btnToShowDetail;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setShichoson(RString shichoson) {
        this.setOriginalData("shichoson", shichoson);
        this.shichoson = shichoson;
    }

    public void setShishoCode(RString shishoCode) {
        this.setOriginalData("shishoCode", shishoCode);
        this.shishoCode = shishoCode;
    }

    public void setShoshoName(RString shoshoName) {
        this.setOriginalData("shoshoName", shoshoName);
        this.shoshoName = shoshoName;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiWithKana(RString shimeiWithKana) {
        this.setOriginalData("shimeiWithKana", shimeiWithKana);
        this.shimeiWithKana = shimeiWithKana;
    }

    public void setNinteiShinseiKubun(RString ninteiShinseiKubun) {
        this.setOriginalData("ninteiShinseiKubun", ninteiShinseiKubun);
        this.ninteiShinseiKubun = ninteiShinseiKubun;
    }

    public void setNinteiShinseiDate(TextBoxFlexibleDate ninteiShinseiDate) {
        this.setOriginalData("ninteiShinseiDate", ninteiShinseiDate);
        this.ninteiShinseiDate = ninteiShinseiDate;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setChosaIraiKubun(RString chosaIraiKubun) {
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.chosaIraiKubun = chosaIraiKubun;
    }

    public void setChosaIraiDate(TextBoxFlexibleDate chosaIraiDate) {
        this.setOriginalData("chosaIraiDate", chosaIraiDate);
        this.chosaIraiDate = chosaIraiDate;
    }

    public void setChosaKigenDate(TextBoxFlexibleDate chosaKigenDate) {
        this.setOriginalData("chosaKigenDate", chosaKigenDate);
        this.chosaKigenDate = chosaKigenDate;
    }

    public void setIraishoHakkoDate(TextBoxFlexibleDate iraishoHakkoDate) {
        this.setOriginalData("iraishoHakkoDate", iraishoHakkoDate);
        this.iraishoHakkoDate = iraishoHakkoDate;
    }

    public void setChosaItakusakiNo(RString chosaItakusakiNo) {
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.chosaItakusakiNo = chosaItakusakiNo;
    }

    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiName = chosaItakusakiName;
    }

    public void setChosainNo(RString chosainNo) {
        this.setOriginalData("chosainNo", chosainNo);
        this.chosainNo = chosainNo;
    }

    public void setChosainName(RString chosainName) {
        this.setOriginalData("chosainName", chosainName);
        this.chosainName = chosainName;
    }

    public void setChosaItakusakiNo1TA(RString chosaItakusakiNo1TA) {
        this.setOriginalData("chosaItakusakiNo1TA", chosaItakusakiNo1TA);
        this.chosaItakusakiNo1TA = chosaItakusakiNo1TA;
    }

    public void setChosaItakusakiName1TA(RString chosaItakusakiName1TA) {
        this.setOriginalData("chosaItakusakiName1TA", chosaItakusakiName1TA);
        this.chosaItakusakiName1TA = chosaItakusakiName1TA;
    }

    public void setChosainNo1TA(RString chosainNo1TA) {
        this.setOriginalData("chosainNo1TA", chosainNo1TA);
        this.chosainNo1TA = chosainNo1TA;
    }

    public void setChosainName1TA(RString chosainName1TA) {
        this.setOriginalData("chosainName1TA", chosainName1TA);
        this.chosainName1TA = chosainName1TA;
    }

    public void setChosaItakusakiNo2TA(RString chosaItakusakiNo2TA) {
        this.setOriginalData("chosaItakusakiNo2TA", chosaItakusakiNo2TA);
        this.chosaItakusakiNo2TA = chosaItakusakiNo2TA;
    }

    public void setChosaItakusakiName2TA(RString chosaItakusakiName2TA) {
        this.setOriginalData("chosaItakusakiName2TA", chosaItakusakiName2TA);
        this.chosaItakusakiName2TA = chosaItakusakiName2TA;
    }

    public void setChosainNo2TA(RString chosainNo2TA) {
        this.setOriginalData("chosainNo2TA", chosainNo2TA);
        this.chosainNo2TA = chosainNo2TA;
    }

    public void setChosainName2TA(RString chosainName2TA) {
        this.setOriginalData("chosainName2TA", chosainName2TA);
        this.chosainName2TA = chosainName2TA;
    }

    public void setTokusokuDate(TextBoxFlexibleDate tokusokuDate) {
        this.setOriginalData("tokusokuDate", tokusokuDate);
        this.tokusokuDate = tokusokuDate;
    }

    public void setTokusokuCount(RString tokusokuCount) {
        this.setOriginalData("tokusokuCount", tokusokuCount);
        this.tokusokuCount = tokusokuCount;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setNyushoShisetsu(RString nyushoShisetsu) {
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.nyushoShisetsu = nyushoShisetsu;
    }

}