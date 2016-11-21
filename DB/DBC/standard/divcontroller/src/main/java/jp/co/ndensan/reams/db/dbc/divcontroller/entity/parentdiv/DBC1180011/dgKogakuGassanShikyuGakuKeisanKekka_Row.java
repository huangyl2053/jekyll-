package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Nov 21 14:07:44 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKogakuGassanShikyuGakuKeisanKekka_Row のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class dgKogakuGassanShikyuGakuKeisanKekka_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxDate txtTaishoNendo;
    private RString txtSanteiKubun;
    private RString txtShikyuShinseishoSeiriNo;
    private RString txtJikoFutanSeiriNo;
    private RString txtDataShurui;
    private RString txtUketoriYM;
    private RString txtSofuYM;
    private Boolean chkisDeleted;
    private RString txtHihokenshaNo;
    private RString txtShoKisaiHokenshaNo;
    private RString txtRirekiNo;

    public dgKogakuGassanShikyuGakuKeisanKekka_Row() {
        super();
        this.txtTaishoNendo = new TextBoxDate();
        this.txtSanteiKubun = RString.EMPTY;
        this.txtShikyuShinseishoSeiriNo = RString.EMPTY;
        this.txtJikoFutanSeiriNo = RString.EMPTY;
        this.txtDataShurui = RString.EMPTY;
        this.txtUketoriYM = RString.EMPTY;
        this.txtSofuYM = RString.EMPTY;
        this.chkisDeleted = false;
        this.txtHihokenshaNo = RString.EMPTY;
        this.txtShoKisaiHokenshaNo = RString.EMPTY;
        this.txtRirekiNo = RString.EMPTY;
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.setOriginalData("txtSanteiKubun", txtSanteiKubun);
        this.setOriginalData("txtShikyuShinseishoSeiriNo", txtShikyuShinseishoSeiriNo);
        this.setOriginalData("txtJikoFutanSeiriNo", txtJikoFutanSeiriNo);
        this.setOriginalData("txtDataShurui", txtDataShurui);
        this.setOriginalData("txtUketoriYM", txtUketoriYM);
        this.setOriginalData("txtSofuYM", txtSofuYM);
        this.setOriginalData("chkisDeleted", chkisDeleted);
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.setOriginalData("txtShoKisaiHokenshaNo", txtShoKisaiHokenshaNo);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
    }

    public dgKogakuGassanShikyuGakuKeisanKekka_Row(TextBoxDate txtTaishoNendo, RString txtSanteiKubun, RString txtShikyuShinseishoSeiriNo, RString txtJikoFutanSeiriNo, RString txtDataShurui, RString txtUketoriYM, RString txtSofuYM, Boolean chkisDeleted, RString txtHihokenshaNo, RString txtShoKisaiHokenshaNo, RString txtRirekiNo) {
        super();
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.setOriginalData("txtSanteiKubun", txtSanteiKubun);
        this.setOriginalData("txtShikyuShinseishoSeiriNo", txtShikyuShinseishoSeiriNo);
        this.setOriginalData("txtJikoFutanSeiriNo", txtJikoFutanSeiriNo);
        this.setOriginalData("txtDataShurui", txtDataShurui);
        this.setOriginalData("txtUketoriYM", txtUketoriYM);
        this.setOriginalData("txtSofuYM", txtSofuYM);
        this.setOriginalData("chkisDeleted", chkisDeleted);
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.setOriginalData("txtShoKisaiHokenshaNo", txtShoKisaiHokenshaNo);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtTaishoNendo = txtTaishoNendo;
        this.txtSanteiKubun = txtSanteiKubun;
        this.txtShikyuShinseishoSeiriNo = txtShikyuShinseishoSeiriNo;
        this.txtJikoFutanSeiriNo = txtJikoFutanSeiriNo;
        this.txtDataShurui = txtDataShurui;
        this.txtUketoriYM = txtUketoriYM;
        this.txtSofuYM = txtSofuYM;
        this.chkisDeleted = chkisDeleted;
        this.txtHihokenshaNo = txtHihokenshaNo;
        this.txtShoKisaiHokenshaNo = txtShoKisaiHokenshaNo;
        this.txtRirekiNo = txtRirekiNo;
    }

    public TextBoxDate getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    public RString getTxtSanteiKubun() {
        return txtSanteiKubun;
    }

    public RString getTxtShikyuShinseishoSeiriNo() {
        return txtShikyuShinseishoSeiriNo;
    }

    public RString getTxtJikoFutanSeiriNo() {
        return txtJikoFutanSeiriNo;
    }

    public RString getTxtDataShurui() {
        return txtDataShurui;
    }

    public RString getTxtUketoriYM() {
        return txtUketoriYM;
    }

    public RString getTxtSofuYM() {
        return txtSofuYM;
    }

    public Boolean getChkisDeleted() {
        return chkisDeleted;
    }

    public RString getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    public RString getTxtShoKisaiHokenshaNo() {
        return txtShoKisaiHokenshaNo;
    }

    public RString getTxtRirekiNo() {
        return txtRirekiNo;
    }

    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.setOriginalData("txtTaishoNendo", txtTaishoNendo);
        this.txtTaishoNendo = txtTaishoNendo;
    }

    public void setTxtSanteiKubun(RString txtSanteiKubun) {
        this.setOriginalData("txtSanteiKubun", txtSanteiKubun);
        this.txtSanteiKubun = txtSanteiKubun;
    }

    public void setTxtShikyuShinseishoSeiriNo(RString txtShikyuShinseishoSeiriNo) {
        this.setOriginalData("txtShikyuShinseishoSeiriNo", txtShikyuShinseishoSeiriNo);
        this.txtShikyuShinseishoSeiriNo = txtShikyuShinseishoSeiriNo;
    }

    public void setTxtJikoFutanSeiriNo(RString txtJikoFutanSeiriNo) {
        this.setOriginalData("txtJikoFutanSeiriNo", txtJikoFutanSeiriNo);
        this.txtJikoFutanSeiriNo = txtJikoFutanSeiriNo;
    }

    public void setTxtDataShurui(RString txtDataShurui) {
        this.setOriginalData("txtDataShurui", txtDataShurui);
        this.txtDataShurui = txtDataShurui;
    }

    public void setTxtUketoriYM(RString txtUketoriYM) {
        this.setOriginalData("txtUketoriYM", txtUketoriYM);
        this.txtUketoriYM = txtUketoriYM;
    }

    public void setTxtSofuYM(RString txtSofuYM) {
        this.setOriginalData("txtSofuYM", txtSofuYM);
        this.txtSofuYM = txtSofuYM;
    }

    public void setChkisDeleted(Boolean chkisDeleted) {
        this.setOriginalData("chkisDeleted", chkisDeleted);
        this.chkisDeleted = chkisDeleted;
    }

    public void setTxtHihokenshaNo(RString txtHihokenshaNo) {
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    public void setTxtShoKisaiHokenshaNo(RString txtShoKisaiHokenshaNo) {
        this.setOriginalData("txtShoKisaiHokenshaNo", txtShoKisaiHokenshaNo);
        this.txtShoKisaiHokenshaNo = txtShoKisaiHokenshaNo;
    }

    public void setTxtRirekiNo(RString txtRirekiNo) {
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtRirekiNo = txtRirekiNo;
    }

    // </editor-fold>
}
