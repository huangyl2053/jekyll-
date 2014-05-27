package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:56:16 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoRyoyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoRyoyoList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtShoteiShikkanName;
    private RString txtRyoyoKaishiYMD;
    private RString txtShoteiShikkanGokei;
    private RString txtKinkyujiName;
    private RString txtChiryoKaishiYMD;
    private RString txtKinkyujiGokei;
    private RString txtRyoyohiGokei;

    public dgServiceTeikyoShomeishoRyoyoList_Row() {
        super();
    }

    public dgServiceTeikyoShomeishoRyoyoList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtShoteiShikkanName, RString txtRyoyoKaishiYMD, RString txtShoteiShikkanGokei, RString txtKinkyujiName, RString txtChiryoKaishiYMD, RString txtKinkyujiGokei, RString txtRyoyohiGokei) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShoteiShikkanName", txtShoteiShikkanName);
        this.setOriginalData("txtRyoyoKaishiYMD", txtRyoyoKaishiYMD);
        this.setOriginalData("txtShoteiShikkanGokei", txtShoteiShikkanGokei);
        this.setOriginalData("txtKinkyujiName", txtKinkyujiName);
        this.setOriginalData("txtChiryoKaishiYMD", txtChiryoKaishiYMD);
        this.setOriginalData("txtKinkyujiGokei", txtKinkyujiGokei);
        this.setOriginalData("txtRyoyohiGokei", txtRyoyohiGokei);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtShoteiShikkanName = txtShoteiShikkanName;
        this.txtRyoyoKaishiYMD = txtRyoyoKaishiYMD;
        this.txtShoteiShikkanGokei = txtShoteiShikkanGokei;
        this.txtKinkyujiName = txtKinkyujiName;
        this.txtChiryoKaishiYMD = txtChiryoKaishiYMD;
        this.txtKinkyujiGokei = txtKinkyujiGokei;
        this.txtRyoyohiGokei = txtRyoyohiGokei;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtShoteiShikkanName() {
        return txtShoteiShikkanName;
    }

    public RString getTxtRyoyoKaishiYMD() {
        return txtRyoyoKaishiYMD;
    }

    public RString getTxtShoteiShikkanGokei() {
        return txtShoteiShikkanGokei;
    }

    public RString getTxtKinkyujiName() {
        return txtKinkyujiName;
    }

    public RString getTxtChiryoKaishiYMD() {
        return txtChiryoKaishiYMD;
    }

    public RString getTxtKinkyujiGokei() {
        return txtKinkyujiGokei;
    }

    public RString getTxtRyoyohiGokei() {
        return txtRyoyohiGokei;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setBtnEdit(Button btnEdit) {
        this.setOriginalData("btnEdit", btnEdit);
        this.btnEdit = btnEdit;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtShoteiShikkanName(RString txtShoteiShikkanName) {
        this.setOriginalData("txtShoteiShikkanName", txtShoteiShikkanName);
        this.txtShoteiShikkanName = txtShoteiShikkanName;
    }

    public void setTxtRyoyoKaishiYMD(RString txtRyoyoKaishiYMD) {
        this.setOriginalData("txtRyoyoKaishiYMD", txtRyoyoKaishiYMD);
        this.txtRyoyoKaishiYMD = txtRyoyoKaishiYMD;
    }

    public void setTxtShoteiShikkanGokei(RString txtShoteiShikkanGokei) {
        this.setOriginalData("txtShoteiShikkanGokei", txtShoteiShikkanGokei);
        this.txtShoteiShikkanGokei = txtShoteiShikkanGokei;
    }

    public void setTxtKinkyujiName(RString txtKinkyujiName) {
        this.setOriginalData("txtKinkyujiName", txtKinkyujiName);
        this.txtKinkyujiName = txtKinkyujiName;
    }

    public void setTxtChiryoKaishiYMD(RString txtChiryoKaishiYMD) {
        this.setOriginalData("txtChiryoKaishiYMD", txtChiryoKaishiYMD);
        this.txtChiryoKaishiYMD = txtChiryoKaishiYMD;
    }

    public void setTxtKinkyujiGokei(RString txtKinkyujiGokei) {
        this.setOriginalData("txtKinkyujiGokei", txtKinkyujiGokei);
        this.txtKinkyujiGokei = txtKinkyujiGokei;
    }

    public void setTxtRyoyohiGokei(RString txtRyoyohiGokei) {
        this.setOriginalData("txtRyoyohiGokei", txtRyoyohiGokei);
        this.txtRyoyohiGokei = txtRyoyohiGokei;
    }

}