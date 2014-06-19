package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 19 16:16:59 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgNinteichosaResultTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteichosaResultTaishosha_Row extends DataRow {

    private Button btnToDecide;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString hihokenshaNo;
    private RString shikibetsuCode;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimei;
    private TextBoxFlexibleDate shinseiDate;
    private RString shinseiKubun;
    private TextBoxFlexibleDate chosaIraiDate;
    private TextBoxFlexibleDate chosaJisshiDate;
    private TextBoxFlexibleDate chosaKanryoDate;
    private RString chosaItakusakiCode;
    private RString chosaItakusakiName;
    private RString chosainCode;
    private RString chosainName;
    private RString chosaJisshiBashoType;
    private RString chosaJisshiBashoOther;
    private TextBoxFlexibleDate birthDay;
    private RString gender;
    private RString yubinNo;
    private RString jusho;
    private TextBoxFlexibleDate receptionDate;
    private TextBoxFlexibleDate dataInputDate;

    public dgNinteichosaResultTaishosha_Row() {
        super();
        this.btnToDecide = new Button();
        this.hokenshaNo = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiAndKanaShimei = RString.EMPTY;
        this.shinseiDate = new TextBoxFlexibleDate();
        this.shinseiKubun = RString.EMPTY;
        this.chosaIraiDate = new TextBoxFlexibleDate();
        this.chosaJisshiDate = new TextBoxFlexibleDate();
        this.chosaKanryoDate = new TextBoxFlexibleDate();
        this.chosaItakusakiCode = RString.EMPTY;
        this.chosaItakusakiName = RString.EMPTY;
        this.chosainCode = RString.EMPTY;
        this.chosainName = RString.EMPTY;
        this.chosaJisshiBashoType = RString.EMPTY;
        this.chosaJisshiBashoOther = RString.EMPTY;
        this.birthDay = new TextBoxFlexibleDate();
        this.gender = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.receptionDate = new TextBoxFlexibleDate();
        this.dataInputDate = new TextBoxFlexibleDate();
    }

    public dgNinteichosaResultTaishosha_Row(Button btnToDecide, RString hokenshaNo, RString hokenshaName, RString hihokenshaNo, RString shikibetsuCode, RString shimei, RString kanaShimei, RString shimeiAndKanaShimei, TextBoxFlexibleDate shinseiDate, RString shinseiKubun, TextBoxFlexibleDate chosaIraiDate, TextBoxFlexibleDate chosaJisshiDate, TextBoxFlexibleDate chosaKanryoDate, RString chosaItakusakiCode, RString chosaItakusakiName, RString chosainCode, RString chosainName, RString chosaJisshiBashoType, RString chosaJisshiBashoOther, TextBoxFlexibleDate birthDay, RString gender, RString yubinNo, RString jusho, TextBoxFlexibleDate receptionDate, TextBoxFlexibleDate dataInputDate) {
        super();
        this.setOriginalData("btnToDecide", btnToDecide);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("chosaIraiDate", chosaIraiDate);
        this.setOriginalData("chosaJisshiDate", chosaJisshiDate);
        this.setOriginalData("chosaKanryoDate", chosaKanryoDate);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.setOriginalData("chosainCode", chosainCode);
        this.setOriginalData("chosainName", chosainName);
        this.setOriginalData("chosaJisshiBashoType", chosaJisshiBashoType);
        this.setOriginalData("chosaJisshiBashoOther", chosaJisshiBashoOther);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("gender", gender);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("receptionDate", receptionDate);
        this.setOriginalData("dataInputDate", dataInputDate);
        this.btnToDecide = btnToDecide;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
        this.shinseiDate = shinseiDate;
        this.shinseiKubun = shinseiKubun;
        this.chosaIraiDate = chosaIraiDate;
        this.chosaJisshiDate = chosaJisshiDate;
        this.chosaKanryoDate = chosaKanryoDate;
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.chosaItakusakiName = chosaItakusakiName;
        this.chosainCode = chosainCode;
        this.chosainName = chosainName;
        this.chosaJisshiBashoType = chosaJisshiBashoType;
        this.chosaJisshiBashoOther = chosaJisshiBashoOther;
        this.birthDay = birthDay;
        this.gender = gender;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.receptionDate = receptionDate;
        this.dataInputDate = dataInputDate;
    }

    public Button getBtnToDecide() {
        return btnToDecide;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiAndKanaShimei() {
        return shimeiAndKanaShimei;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public TextBoxFlexibleDate getChosaIraiDate() {
        return chosaIraiDate;
    }

    public TextBoxFlexibleDate getChosaJisshiDate() {
        return chosaJisshiDate;
    }

    public TextBoxFlexibleDate getChosaKanryoDate() {
        return chosaKanryoDate;
    }

    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    public RString getChosainCode() {
        return chosainCode;
    }

    public RString getChosainName() {
        return chosainName;
    }

    public RString getChosaJisshiBashoType() {
        return chosaJisshiBashoType;
    }

    public RString getChosaJisshiBashoOther() {
        return chosaJisshiBashoOther;
    }

    public TextBoxFlexibleDate getBirthDay() {
        return birthDay;
    }

    public RString getGender() {
        return gender;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public TextBoxFlexibleDate getReceptionDate() {
        return receptionDate;
    }

    public TextBoxFlexibleDate getDataInputDate() {
        return dataInputDate;
    }

    public void setBtnToDecide(Button btnToDecide) {
        this.setOriginalData("btnToDecide", btnToDecide);
        this.btnToDecide = btnToDecide;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiAndKanaShimei(RString shimeiAndKanaShimei) {
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setChosaIraiDate(TextBoxFlexibleDate chosaIraiDate) {
        this.setOriginalData("chosaIraiDate", chosaIraiDate);
        this.chosaIraiDate = chosaIraiDate;
    }

    public void setChosaJisshiDate(TextBoxFlexibleDate chosaJisshiDate) {
        this.setOriginalData("chosaJisshiDate", chosaJisshiDate);
        this.chosaJisshiDate = chosaJisshiDate;
    }

    public void setChosaKanryoDate(TextBoxFlexibleDate chosaKanryoDate) {
        this.setOriginalData("chosaKanryoDate", chosaKanryoDate);
        this.chosaKanryoDate = chosaKanryoDate;
    }

    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiName = chosaItakusakiName;
    }

    public void setChosainCode(RString chosainCode) {
        this.setOriginalData("chosainCode", chosainCode);
        this.chosainCode = chosainCode;
    }

    public void setChosainName(RString chosainName) {
        this.setOriginalData("chosainName", chosainName);
        this.chosainName = chosainName;
    }

    public void setChosaJisshiBashoType(RString chosaJisshiBashoType) {
        this.setOriginalData("chosaJisshiBashoType", chosaJisshiBashoType);
        this.chosaJisshiBashoType = chosaJisshiBashoType;
    }

    public void setChosaJisshiBashoOther(RString chosaJisshiBashoOther) {
        this.setOriginalData("chosaJisshiBashoOther", chosaJisshiBashoOther);
        this.chosaJisshiBashoOther = chosaJisshiBashoOther;
    }

    public void setBirthDay(TextBoxFlexibleDate birthDay) {
        this.setOriginalData("birthDay", birthDay);
        this.birthDay = birthDay;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setReceptionDate(TextBoxFlexibleDate receptionDate) {
        this.setOriginalData("receptionDate", receptionDate);
        this.receptionDate = receptionDate;
    }

    public void setDataInputDate(TextBoxFlexibleDate dataInputDate) {
        this.setOriginalData("dataInputDate", dataInputDate);
        this.dataInputDate = dataInputDate;
    }

}