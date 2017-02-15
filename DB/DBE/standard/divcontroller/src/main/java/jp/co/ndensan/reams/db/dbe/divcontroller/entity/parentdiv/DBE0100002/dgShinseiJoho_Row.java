package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Feb 15 09:43:54 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgShinseiJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseiJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">

    private Button btnShokai;
    private RString hokensha;
    private RString hihokenshaNo;
    private RString shimei;
    private TextBoxFlexibleDate hihokenshaBirthDay;
    private TextBoxNum hihokenshaNenrei;
    private RString hihokenshaSeibetsu;
    private TextBoxDate shinseiDay;
    private RString shinseikubunshinseiji;
    private RString ichijiHanteiKekka;
    private TextBoxFlexibleDate ichijiHanteiYMD;
    private RString nijiHanteiYokaigoJotaiKubun;
    private TextBoxFlexibleDate nijiHanteiYMD;
    private RString nijiHanteiNinteiYukoKikan;
    private TextBoxFlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private TextBoxFlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private RString yubinno;
    private RString telno;
    private RString jyusho;
    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString ikenshoIraiRirekiNo;
    private RString ninteichosaIraiRirekiNo;

    public dgShinseiJoho_Row() {
        super();
        this.btnShokai = new Button();
        this.hokensha = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.hihokenshaBirthDay = new TextBoxFlexibleDate();
        this.hihokenshaNenrei = new TextBoxNum();
        this.hihokenshaSeibetsu = RString.EMPTY;
        this.shinseiDay = new TextBoxDate();
        this.shinseikubunshinseiji = RString.EMPTY;
        this.ichijiHanteiKekka = RString.EMPTY;
        this.ichijiHanteiYMD = new TextBoxFlexibleDate();
        this.nijiHanteiYokaigoJotaiKubun = RString.EMPTY;
        this.nijiHanteiYMD = new TextBoxFlexibleDate();
        this.nijiHanteiNinteiYukoKikan = RString.EMPTY;
        this.nijiHanteiNinteiYukoKaishiYMD = new TextBoxFlexibleDate();
        this.nijiHanteiNinteiYukoShuryoYMD = new TextBoxFlexibleDate();
        this.yubinno = RString.EMPTY;
        this.telno = RString.EMPTY;
        this.jyusho = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.shoKisaiHokenshaNo = RString.EMPTY;
        this.ikenshoIraiRirekiNo = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = RString.EMPTY;
        this.setOriginalData("btnShokai", btnShokai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("hihokenshaBirthDay", hihokenshaBirthDay);
        this.setOriginalData("hihokenshaNenrei", hihokenshaNenrei);
        this.setOriginalData("hihokenshaSeibetsu", hihokenshaSeibetsu);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseikubunshinseiji", shinseikubunshinseiji);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiYMD", ichijiHanteiYMD);
        this.setOriginalData("nijiHanteiYokaigoJotaiKubun", nijiHanteiYokaigoJotaiKubun);
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.setOriginalData("nijiHanteiNinteiYukoKikan", nijiHanteiNinteiYukoKikan);
        this.setOriginalData("nijiHanteiNinteiYukoKaishiYMD", nijiHanteiNinteiYukoKaishiYMD);
        this.setOriginalData("nijiHanteiNinteiYukoShuryoYMD", nijiHanteiNinteiYukoShuryoYMD);
        this.setOriginalData("yubinno", yubinno);
        this.setOriginalData("telno", telno);
        this.setOriginalData("jyusho", jyusho);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
    }

    public dgShinseiJoho_Row(Button btnShokai, RString hokensha, RString hihokenshaNo, RString shimei, TextBoxFlexibleDate hihokenshaBirthDay, TextBoxNum hihokenshaNenrei, RString hihokenshaSeibetsu, TextBoxDate shinseiDay, RString shinseikubunshinseiji, RString ichijiHanteiKekka, TextBoxFlexibleDate ichijiHanteiYMD, RString nijiHanteiYokaigoJotaiKubun, TextBoxFlexibleDate nijiHanteiYMD, RString nijiHanteiNinteiYukoKikan, TextBoxFlexibleDate nijiHanteiNinteiYukoKaishiYMD, TextBoxFlexibleDate nijiHanteiNinteiYukoShuryoYMD, RString yubinno, RString telno, RString jyusho, RString shinseishoKanriNo, RString shoKisaiHokenshaNo, RString ikenshoIraiRirekiNo, RString ninteichosaIraiRirekiNo) {
        super();
        this.setOriginalData("btnShokai", btnShokai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("hihokenshaBirthDay", hihokenshaBirthDay);
        this.setOriginalData("hihokenshaNenrei", hihokenshaNenrei);
        this.setOriginalData("hihokenshaSeibetsu", hihokenshaSeibetsu);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseikubunshinseiji", shinseikubunshinseiji);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiYMD", ichijiHanteiYMD);
        this.setOriginalData("nijiHanteiYokaigoJotaiKubun", nijiHanteiYokaigoJotaiKubun);
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.setOriginalData("nijiHanteiNinteiYukoKikan", nijiHanteiNinteiYukoKikan);
        this.setOriginalData("nijiHanteiNinteiYukoKaishiYMD", nijiHanteiNinteiYukoKaishiYMD);
        this.setOriginalData("nijiHanteiNinteiYukoShuryoYMD", nijiHanteiNinteiYukoShuryoYMD);
        this.setOriginalData("yubinno", yubinno);
        this.setOriginalData("telno", telno);
        this.setOriginalData("jyusho", jyusho);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.btnShokai = btnShokai;
        this.hokensha = hokensha;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.hihokenshaBirthDay = hihokenshaBirthDay;
        this.hihokenshaNenrei = hihokenshaNenrei;
        this.hihokenshaSeibetsu = hihokenshaSeibetsu;
        this.shinseiDay = shinseiDay;
        this.shinseikubunshinseiji = shinseikubunshinseiji;
        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.ichijiHanteiYMD = ichijiHanteiYMD;
        this.nijiHanteiYokaigoJotaiKubun = nijiHanteiYokaigoJotaiKubun;
        this.nijiHanteiYMD = nijiHanteiYMD;
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
        this.nijiHanteiNinteiYukoKaishiYMD = nijiHanteiNinteiYukoKaishiYMD;
        this.nijiHanteiNinteiYukoShuryoYMD = nijiHanteiNinteiYukoShuryoYMD;
        this.yubinno = yubinno;
        this.telno = telno;
        this.jyusho = jyusho;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public Button getBtnShokai() {
        return btnShokai;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public TextBoxFlexibleDate getHihokenshaBirthDay() {
        return hihokenshaBirthDay;
    }

    public TextBoxNum getHihokenshaNenrei() {
        return hihokenshaNenrei;
    }

    public RString getHihokenshaSeibetsu() {
        return hihokenshaSeibetsu;
    }

    public TextBoxDate getShinseiDay() {
        return shinseiDay;
    }

    public RString getShinseikubunshinseiji() {
        return shinseikubunshinseiji;
    }

    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    public TextBoxFlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    public RString getNijiHanteiYokaigoJotaiKubun() {
        return nijiHanteiYokaigoJotaiKubun;
    }

    public TextBoxFlexibleDate getNijiHanteiYMD() {
        return nijiHanteiYMD;
    }

    public RString getNijiHanteiNinteiYukoKikan() {
        return nijiHanteiNinteiYukoKikan;
    }

    public TextBoxFlexibleDate getNijiHanteiNinteiYukoKaishiYMD() {
        return nijiHanteiNinteiYukoKaishiYMD;
    }

    public TextBoxFlexibleDate getNijiHanteiNinteiYukoShuryoYMD() {
        return nijiHanteiNinteiYukoShuryoYMD;
    }

    public RString getYubinno() {
        return yubinno;
    }

    public RString getTelno() {
        return telno;
    }

    public RString getJyusho() {
        return jyusho;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    public RString getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public void setBtnShokai(Button btnShokai) {
        this.setOriginalData("btnShokai", btnShokai);
        this.btnShokai = btnShokai;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setHihokenshaBirthDay(TextBoxFlexibleDate hihokenshaBirthDay) {
        this.setOriginalData("hihokenshaBirthDay", hihokenshaBirthDay);
        this.hihokenshaBirthDay = hihokenshaBirthDay;
    }

    public void setHihokenshaNenrei(TextBoxNum hihokenshaNenrei) {
        this.setOriginalData("hihokenshaNenrei", hihokenshaNenrei);
        this.hihokenshaNenrei = hihokenshaNenrei;
    }

    public void setHihokenshaSeibetsu(RString hihokenshaSeibetsu) {
        this.setOriginalData("hihokenshaSeibetsu", hihokenshaSeibetsu);
        this.hihokenshaSeibetsu = hihokenshaSeibetsu;
    }

    public void setShinseiDay(TextBoxDate shinseiDay) {
        this.setOriginalData("shinseiDay", shinseiDay);
        this.shinseiDay = shinseiDay;
    }

    public void setShinseikubunshinseiji(RString shinseikubunshinseiji) {
        this.setOriginalData("shinseikubunshinseiji", shinseikubunshinseiji);
        this.shinseikubunshinseiji = shinseikubunshinseiji;
    }

    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    public void setIchijiHanteiYMD(TextBoxFlexibleDate ichijiHanteiYMD) {
        this.setOriginalData("ichijiHanteiYMD", ichijiHanteiYMD);
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    public void setNijiHanteiYokaigoJotaiKubun(RString nijiHanteiYokaigoJotaiKubun) {
        this.setOriginalData("nijiHanteiYokaigoJotaiKubun", nijiHanteiYokaigoJotaiKubun);
        this.nijiHanteiYokaigoJotaiKubun = nijiHanteiYokaigoJotaiKubun;
    }

    public void setNijiHanteiYMD(TextBoxFlexibleDate nijiHanteiYMD) {
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.nijiHanteiYMD = nijiHanteiYMD;
    }

    public void setNijiHanteiNinteiYukoKikan(RString nijiHanteiNinteiYukoKikan) {
        this.setOriginalData("nijiHanteiNinteiYukoKikan", nijiHanteiNinteiYukoKikan);
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
    }

    public void setNijiHanteiNinteiYukoKaishiYMD(TextBoxFlexibleDate nijiHanteiNinteiYukoKaishiYMD) {
        this.setOriginalData("nijiHanteiNinteiYukoKaishiYMD", nijiHanteiNinteiYukoKaishiYMD);
        this.nijiHanteiNinteiYukoKaishiYMD = nijiHanteiNinteiYukoKaishiYMD;
    }

    public void setNijiHanteiNinteiYukoShuryoYMD(TextBoxFlexibleDate nijiHanteiNinteiYukoShuryoYMD) {
        this.setOriginalData("nijiHanteiNinteiYukoShuryoYMD", nijiHanteiNinteiYukoShuryoYMD);
        this.nijiHanteiNinteiYukoShuryoYMD = nijiHanteiNinteiYukoShuryoYMD;
    }

    public void setYubinno(RString yubinno) {
        this.setOriginalData("yubinno", yubinno);
        this.yubinno = yubinno;
    }

    public void setTelno(RString telno) {
        this.setOriginalData("telno", telno);
        this.telno = telno;
    }

    public void setJyusho(RString jyusho) {
        this.setOriginalData("jyusho", jyusho);
        this.jyusho = jyusho;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    public void setNinteichosaIraiRirekiNo(RString ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    // </editor-fold>
}
