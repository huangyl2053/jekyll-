package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 14:28:50 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShokanShikyuShinseishoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShokanShikyuShinseishoList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtServiceYM;
    private RString txtShinseiYMD;
    private RString txtSeiriNo;
    private RString txtShiharaiGokei;
    private RString txtHokenGokei;
    private RString txtJikoGokei;

    public dgShokanShikyuShinseishoList_Row() {
        super();
    }

    public dgShokanShikyuShinseishoList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtServiceYM, RString txtShinseiYMD, RString txtSeiriNo, RString txtShiharaiGokei, RString txtHokenGokei, RString txtJikoGokei) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtServiceYM", txtServiceYM);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.setOriginalData("txtShiharaiGokei", txtShiharaiGokei);
        this.setOriginalData("txtHokenGokei", txtHokenGokei);
        this.setOriginalData("txtJikoGokei", txtJikoGokei);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtServiceYM = txtServiceYM;
        this.txtShinseiYMD = txtShinseiYMD;
        this.txtSeiriNo = txtSeiriNo;
        this.txtShiharaiGokei = txtShiharaiGokei;
        this.txtHokenGokei = txtHokenGokei;
        this.txtJikoGokei = txtJikoGokei;
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

    public RString getTxtServiceYM() {
        return txtServiceYM;
    }

    public RString getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getTxtSeiriNo() {
        return txtSeiriNo;
    }

    public RString getTxtShiharaiGokei() {
        return txtShiharaiGokei;
    }

    public RString getTxtHokenGokei() {
        return txtHokenGokei;
    }

    public RString getTxtJikoGokei() {
        return txtJikoGokei;
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

    public void setTxtServiceYM(RString txtServiceYM) {
        this.setOriginalData("txtServiceYM", txtServiceYM);
        this.txtServiceYM = txtServiceYM;
    }

    public void setTxtShinseiYMD(RString txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setTxtSeiriNo(RString txtSeiriNo) {
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtSeiriNo = txtSeiriNo;
    }

    public void setTxtShiharaiGokei(RString txtShiharaiGokei) {
        this.setOriginalData("txtShiharaiGokei", txtShiharaiGokei);
        this.txtShiharaiGokei = txtShiharaiGokei;
    }

    public void setTxtHokenGokei(RString txtHokenGokei) {
        this.setOriginalData("txtHokenGokei", txtHokenGokei);
        this.txtHokenGokei = txtHokenGokei;
    }

    public void setTxtJikoGokei(RString txtJikoGokei) {
        this.setOriginalData("txtJikoGokei", txtJikoGokei);
        this.txtJikoGokei = txtJikoGokei;
    }

}