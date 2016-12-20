package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 15 15:53:42 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgResultList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgResultList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    private RString no;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString seibetsu;
    private TextBoxDate birthDay;
    private RString age;
    private TextBoxDate shinseiYMD;
    private RString shinseiKubunOnShinsei;
    private RString shinseiKubunOnHorei;
    private TextBoxDate nijiHanteiYMD;
    private RString nijiHanteiKekka;
    private RString yukoKikan;
    private TextBoxDate yukoKikanFrom;
    private TextBoxDate yukoKikanTo;
    private TextBoxDate ninteiJokyoTeikyoYMD;
    private RString shinseishoKanriNo;

    public dgResultList_Row() {
        super();
        this.no = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaName = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.birthDay = new TextBoxDate();
        this.age = RString.EMPTY;
        this.shinseiYMD = new TextBoxDate();
        this.shinseiKubunOnShinsei = RString.EMPTY;
        this.shinseiKubunOnHorei = RString.EMPTY;
        this.nijiHanteiYMD = new TextBoxDate();
        this.nijiHanteiKekka = RString.EMPTY;
        this.yukoKikan = RString.EMPTY;
        this.yukoKikanFrom = new TextBoxDate();
        this.yukoKikanTo = new TextBoxDate();
        this.ninteiJokyoTeikyoYMD = new TextBoxDate();
        this.shinseishoKanriNo = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("age", age);
        this.setOriginalData("shinseiYMD", shinseiYMD);
        this.setOriginalData("shinseiKubunOnShinsei", shinseiKubunOnShinsei);
        this.setOriginalData("shinseiKubunOnHorei", shinseiKubunOnHorei);
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("yukoKikan", yukoKikan);
        this.setOriginalData("yukoKikanFrom", yukoKikanFrom);
        this.setOriginalData("yukoKikanTo", yukoKikanTo);
        this.setOriginalData("ninteiJokyoTeikyoYMD", ninteiJokyoTeikyoYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
    }

    public dgResultList_Row(RString no, RString hihokenshaNo, RString hihokenshaName, RString seibetsu, TextBoxDate birthDay, RString age, TextBoxDate shinseiYMD, RString shinseiKubunOnShinsei, RString shinseiKubunOnHorei, TextBoxDate nijiHanteiYMD, RString nijiHanteiKekka, RString yukoKikan, TextBoxDate yukoKikanFrom, TextBoxDate yukoKikanTo, TextBoxDate ninteiJokyoTeikyoYMD, RString shinseishoKanriNo) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("age", age);
        this.setOriginalData("shinseiYMD", shinseiYMD);
        this.setOriginalData("shinseiKubunOnShinsei", shinseiKubunOnShinsei);
        this.setOriginalData("shinseiKubunOnHorei", shinseiKubunOnHorei);
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("yukoKikan", yukoKikan);
        this.setOriginalData("yukoKikanFrom", yukoKikanFrom);
        this.setOriginalData("yukoKikanTo", yukoKikanTo);
        this.setOriginalData("ninteiJokyoTeikyoYMD", ninteiJokyoTeikyoYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.no = no;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthDay = birthDay;
        this.age = age;
        this.shinseiYMD = shinseiYMD;
        this.shinseiKubunOnShinsei = shinseiKubunOnShinsei;
        this.shinseiKubunOnHorei = shinseiKubunOnHorei;
        this.nijiHanteiYMD = nijiHanteiYMD;
        this.nijiHanteiKekka = nijiHanteiKekka;
        this.yukoKikan = yukoKikan;
        this.yukoKikanFrom = yukoKikanFrom;
        this.yukoKikanTo = yukoKikanTo;
        this.ninteiJokyoTeikyoYMD = ninteiJokyoTeikyoYMD;
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public RString getNo() {
        return no;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxDate getBirthDay() {
        return birthDay;
    }

    public RString getAge() {
        return age;
    }

    public TextBoxDate getShinseiYMD() {
        return shinseiYMD;
    }

    public RString getShinseiKubunOnShinsei() {
        return shinseiKubunOnShinsei;
    }

    public RString getShinseiKubunOnHorei() {
        return shinseiKubunOnHorei;
    }

    public TextBoxDate getNijiHanteiYMD() {
        return nijiHanteiYMD;
    }

    public RString getNijiHanteiKekka() {
        return nijiHanteiKekka;
    }

    public RString getYukoKikan() {
        return yukoKikan;
    }

    public TextBoxDate getYukoKikanFrom() {
        return yukoKikanFrom;
    }

    public TextBoxDate getYukoKikanTo() {
        return yukoKikanTo;
    }

    public TextBoxDate getNinteiJokyoTeikyoYMD() {
        return ninteiJokyoTeikyoYMD;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaName(RString hihokenshaName) {
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.hihokenshaName = hihokenshaName;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setBirthDay(TextBoxDate birthDay) {
        this.setOriginalData("birthDay", birthDay);
        this.birthDay = birthDay;
    }

    public void setAge(RString age) {
        this.setOriginalData("age", age);
        this.age = age;
    }

    public void setShinseiYMD(TextBoxDate shinseiYMD) {
        this.setOriginalData("shinseiYMD", shinseiYMD);
        this.shinseiYMD = shinseiYMD;
    }

    public void setShinseiKubunOnShinsei(RString shinseiKubunOnShinsei) {
        this.setOriginalData("shinseiKubunOnShinsei", shinseiKubunOnShinsei);
        this.shinseiKubunOnShinsei = shinseiKubunOnShinsei;
    }

    public void setShinseiKubunOnHorei(RString shinseiKubunOnHorei) {
        this.setOriginalData("shinseiKubunOnHorei", shinseiKubunOnHorei);
        this.shinseiKubunOnHorei = shinseiKubunOnHorei;
    }

    public void setNijiHanteiYMD(TextBoxDate nijiHanteiYMD) {
        this.setOriginalData("nijiHanteiYMD", nijiHanteiYMD);
        this.nijiHanteiYMD = nijiHanteiYMD;
    }

    public void setNijiHanteiKekka(RString nijiHanteiKekka) {
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.nijiHanteiKekka = nijiHanteiKekka;
    }

    public void setYukoKikan(RString yukoKikan) {
        this.setOriginalData("yukoKikan", yukoKikan);
        this.yukoKikan = yukoKikan;
    }

    public void setYukoKikanFrom(TextBoxDate yukoKikanFrom) {
        this.setOriginalData("yukoKikanFrom", yukoKikanFrom);
        this.yukoKikanFrom = yukoKikanFrom;
    }

    public void setYukoKikanTo(TextBoxDate yukoKikanTo) {
        this.setOriginalData("yukoKikanTo", yukoKikanTo);
        this.yukoKikanTo = yukoKikanTo;
    }

    public void setNinteiJokyoTeikyoYMD(TextBoxDate ninteiJokyoTeikyoYMD) {
        this.setOriginalData("ninteiJokyoTeikyoYMD", ninteiJokyoTeikyoYMD);
        this.ninteiJokyoTeikyoYMD = ninteiJokyoTeikyoYMD;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    // </editor-fold>
}
