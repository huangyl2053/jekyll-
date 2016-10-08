package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Oct 08 10:49:33 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">

    private RString jotai;
    private RString kakuninNo;
    private TextBoxFlexibleDate txtShinseiYMD;
    private RString shinseiRiyu;
    private RString ketteiKubun;
    private TextBoxFlexibleDate txtKetteiYMD;
    private TextBoxFlexibleDate txtTekiyoYMD;
    private TextBoxFlexibleDate txtYukoKigenYMD;
    private RString keigenritsu;
    private RString shoninShinaiRiyu;
    private RString hiddenShoKisaiHokenshaNo;
    private RString hiddenShinseiRirekiNo;

    public dgShinseiList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.kakuninNo = RString.EMPTY;
        this.txtShinseiYMD = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.ketteiKubun = RString.EMPTY;
        this.txtKetteiYMD = new TextBoxFlexibleDate();
        this.txtTekiyoYMD = new TextBoxFlexibleDate();
        this.txtYukoKigenYMD = new TextBoxFlexibleDate();
        this.keigenritsu = RString.EMPTY;
        this.shoninShinaiRiyu = RString.EMPTY;
        this.hiddenShoKisaiHokenshaNo = RString.EMPTY;
        this.hiddenShinseiRirekiNo = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("kakuninNo", kakuninNo);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("keigenritsu", keigenritsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("hiddenShoKisaiHokenshaNo", hiddenShoKisaiHokenshaNo);
        this.setOriginalData("hiddenShinseiRirekiNo", hiddenShinseiRirekiNo);
    }

    public dgShinseiList_Row(RString jotai, RString kakuninNo, TextBoxFlexibleDate txtShinseiYMD, RString shinseiRiyu, RString ketteiKubun, TextBoxFlexibleDate txtKetteiYMD, TextBoxFlexibleDate txtTekiyoYMD, TextBoxFlexibleDate txtYukoKigenYMD, RString keigenritsu, RString shoninShinaiRiyu, RString hiddenShoKisaiHokenshaNo, RString hiddenShinseiRirekiNo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("kakuninNo", kakuninNo);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("keigenritsu", keigenritsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("hiddenShoKisaiHokenshaNo", hiddenShoKisaiHokenshaNo);
        this.setOriginalData("hiddenShinseiRirekiNo", hiddenShinseiRirekiNo);
        this.jotai = jotai;
        this.kakuninNo = kakuninNo;
        this.txtShinseiYMD = txtShinseiYMD;
        this.shinseiRiyu = shinseiRiyu;
        this.ketteiKubun = ketteiKubun;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtTekiyoYMD = txtTekiyoYMD;
        this.txtYukoKigenYMD = txtYukoKigenYMD;
        this.keigenritsu = keigenritsu;
        this.shoninShinaiRiyu = shoninShinaiRiyu;
        this.hiddenShoKisaiHokenshaNo = hiddenShoKisaiHokenshaNo;
        this.hiddenShinseiRirekiNo = hiddenShinseiRirekiNo;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getKakuninNo() {
        return kakuninNo;
    }

    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return txtYukoKigenYMD;
    }

    public RString getKeigenritsu() {
        return keigenritsu;
    }

    public RString getShoninShinaiRiyu() {
        return shoninShinaiRiyu;
    }

    public RString getHiddenShoKisaiHokenshaNo() {
        return hiddenShoKisaiHokenshaNo;
    }

    public RString getHiddenShinseiRirekiNo() {
        return hiddenShinseiRirekiNo;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setKakuninNo(RString kakuninNo) {
        this.setOriginalData("kakuninNo", kakuninNo);
        this.kakuninNo = kakuninNo;
    }

    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setShinseiRiyu(RString shinseiRiyu) {
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.shinseiRiyu = shinseiRiyu;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.txtKetteiYMD = txtKetteiYMD;
    }

    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.txtYukoKigenYMD = txtYukoKigenYMD;
    }

    public void setKeigenritsu(RString keigenritsu) {
        this.setOriginalData("keigenritsu", keigenritsu);
        this.keigenritsu = keigenritsu;
    }

    public void setShoninShinaiRiyu(RString shoninShinaiRiyu) {
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.shoninShinaiRiyu = shoninShinaiRiyu;
    }

    public void setHiddenShoKisaiHokenshaNo(RString hiddenShoKisaiHokenshaNo) {
        this.setOriginalData("hiddenShoKisaiHokenshaNo", hiddenShoKisaiHokenshaNo);
        this.hiddenShoKisaiHokenshaNo = hiddenShoKisaiHokenshaNo;
    }

    public void setHiddenShinseiRirekiNo(RString hiddenShinseiRirekiNo) {
        this.setOriginalData("hiddenShinseiRirekiNo", hiddenShinseiRirekiNo);
        this.hiddenShinseiRirekiNo = hiddenShinseiRirekiNo;
    }

    // </editor-fold>
}
