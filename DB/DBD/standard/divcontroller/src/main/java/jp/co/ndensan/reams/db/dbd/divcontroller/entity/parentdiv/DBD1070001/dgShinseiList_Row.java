package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 06 10:12:16 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString jotai;
    private TextBoxFlexibleDate txtShinseiYMD;
    private RString shinseiRiyu;
    private RString ketteiKubun;
    private TextBoxFlexibleDate txtKetteiYMD;
    private TextBoxFlexibleDate txtTekiyoYMD;
    private TextBoxFlexibleDate txtYukoKigen;
    private RString hobetsuKubun;
    private TextBoxNum txtKyufuritsu;
    private RString kohiFutanshaNo;
    private RString kohiJukyushaNo;
    private RString shogaishaNo;
    private RString shoninShinaiRiyu;
    private RString dataId;

    public dgShinseiList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.txtShinseiYMD = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.ketteiKubun = RString.EMPTY;
        this.txtKetteiYMD = new TextBoxFlexibleDate();
        this.txtTekiyoYMD = new TextBoxFlexibleDate();
        this.txtYukoKigen = new TextBoxFlexibleDate();
        this.hobetsuKubun = RString.EMPTY;
        this.txtKyufuritsu = new TextBoxNum();
        this.kohiFutanshaNo = RString.EMPTY;
        this.kohiJukyushaNo = RString.EMPTY;
        this.shogaishaNo = RString.EMPTY;
        this.shoninShinaiRiyu = RString.EMPTY;
        this.dataId = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.setOriginalData("kohiFutanshaNo", kohiFutanshaNo);
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.setOriginalData("shogaishaNo", shogaishaNo);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("dataId", dataId);
    }

    public dgShinseiList_Row(RString jotai, TextBoxFlexibleDate txtShinseiYMD, RString shinseiRiyu, RString ketteiKubun, TextBoxFlexibleDate txtKetteiYMD, TextBoxFlexibleDate txtTekiyoYMD, TextBoxFlexibleDate txtYukoKigen, RString hobetsuKubun, TextBoxNum txtKyufuritsu, RString kohiFutanshaNo, RString kohiJukyushaNo, RString shogaishaNo, RString shoninShinaiRiyu, RString dataId) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.setOriginalData("kohiFutanshaNo", kohiFutanshaNo);
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.setOriginalData("shogaishaNo", shogaishaNo);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.setOriginalData("dataId", dataId);
        this.jotai = jotai;
        this.txtShinseiYMD = txtShinseiYMD;
        this.shinseiRiyu = shinseiRiyu;
        this.ketteiKubun = ketteiKubun;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtTekiyoYMD = txtTekiyoYMD;
        this.txtYukoKigen = txtYukoKigen;
        this.hobetsuKubun = hobetsuKubun;
        this.txtKyufuritsu = txtKyufuritsu;
        this.kohiFutanshaNo = kohiFutanshaNo;
        this.kohiJukyushaNo = kohiJukyushaNo;
        this.shogaishaNo = shogaishaNo;
        this.shoninShinaiRiyu = shoninShinaiRiyu;
        this.dataId = dataId;
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

    public RString getHobetsuKubun() {
        return hobetsuKubun;
    }

    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    public RString getShogaishaNo() {
        return shogaishaNo;
    }

    public RString getShoninShinaiRiyu() {
        return shoninShinaiRiyu;
    }

    public RString getDataId() {
        return dataId;
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

    public void setHobetsuKubun(RString hobetsuKubun) {
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.hobetsuKubun = hobetsuKubun;
    }

    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.txtKyufuritsu = txtKyufuritsu;
    }

    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.setOriginalData("kohiFutanshaNo", kohiFutanshaNo);
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    public void setShogaishaNo(RString shogaishaNo) {
        this.setOriginalData("shogaishaNo", shogaishaNo);
        this.shogaishaNo = shogaishaNo;
    }

    public void setShoninShinaiRiyu(RString shoninShinaiRiyu) {
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.shoninShinaiRiyu = shoninShinaiRiyu;
    }

    public void setDataId(RString dataId) {
        this.setOriginalData("dataId", dataId);
        this.dataId = dataId;
    }

    // </editor-fold>
}
