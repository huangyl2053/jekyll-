package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Oct 06 19:03:21 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * ddlShinseiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class ddlShinseiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private RString jotai;
    private TextBoxFlexibleDate txtShinseiYMD;
    private RString shinseiRiyu;
    private RString ketteiKubun;
    private TextBoxFlexibleDate txtKetteiYMD;
    private TextBoxFlexibleDate txtTekiyoYMD;
    private TextBoxFlexibleDate txtYukoKigen;
    private Boolean kyusochishaUmu;
    private TextBoxNum txtKyufuritsu;
    private RString shoninShinaiRiyu;
    private RString hiddenShoKisaiHokenshaNo;
    private RString hiddenShinseiRirekiNo;

    public ddlShinseiIchiran_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.txtShinseiYMD = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.ketteiKubun = RString.EMPTY;
        this.txtKetteiYMD = new TextBoxFlexibleDate();
        this.txtTekiyoYMD = new TextBoxFlexibleDate();
        this.txtYukoKigen = new TextBoxFlexibleDate();
        this.kyusochishaUmu = false;
        this.txtKyufuritsu = new TextBoxNum();
        this.shoninShinaiRiyu = RString.EMPTY;
        this.hiddenShoKisaiHokenshaNo = RString.EMPTY;
        this.hiddenShinseiRirekiNo = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.setOriginalData("kyusochishaUmu", kyusochishaUmu);
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("hiddenShoKisaiHokenshaNo", hiddenShoKisaiHokenshaNo);
        this.setOriginalData("hiddenShinseiRirekiNo", hiddenShinseiRirekiNo);
    }

    public ddlShinseiIchiran_Row(RString jotai, TextBoxFlexibleDate txtShinseiYMD, RString shinseiRiyu, RString ketteiKubun, TextBoxFlexibleDate txtKetteiYMD, TextBoxFlexibleDate txtTekiyoYMD, TextBoxFlexibleDate txtYukoKigen, Boolean kyusochishaUmu, TextBoxNum txtKyufuritsu, RString shoninShinaiRiyu, RString hiddenShoKisaiHokenshaNo, RString hiddenShinseiRirekiNo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.setOriginalData("kyusochishaUmu", kyusochishaUmu);
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("hiddenShoKisaiHokenshaNo", hiddenShoKisaiHokenshaNo);
        this.setOriginalData("hiddenShinseiRirekiNo", hiddenShinseiRirekiNo);
        this.jotai = jotai;
        this.txtShinseiYMD = txtShinseiYMD;
        this.shinseiRiyu = shinseiRiyu;
        this.ketteiKubun = ketteiKubun;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtTekiyoYMD = txtTekiyoYMD;
        this.txtYukoKigen = txtYukoKigen;
        this.kyusochishaUmu = kyusochishaUmu;
        this.txtKyufuritsu = txtKyufuritsu;
        this.shoninShinaiRiyu = shoninShinaiRiyu;
        this.hiddenShoKisaiHokenshaNo = hiddenShoKisaiHokenshaNo;
        this.hiddenShinseiRirekiNo = hiddenShinseiRirekiNo;
    }

    public RString getJotai() {
        return jotai;
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

    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    public Boolean getKyusochishaUmu() {
        return kyusochishaUmu;
    }

    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
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

    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.txtYukoKigen = txtYukoKigen;
    }

    public void setKyusochishaUmu(Boolean kyusochishaUmu) {
        this.setOriginalData("kyusochishaUmu", kyusochishaUmu);
        this.kyusochishaUmu = kyusochishaUmu;
    }

    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.txtKyufuritsu = txtKyufuritsu;
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
