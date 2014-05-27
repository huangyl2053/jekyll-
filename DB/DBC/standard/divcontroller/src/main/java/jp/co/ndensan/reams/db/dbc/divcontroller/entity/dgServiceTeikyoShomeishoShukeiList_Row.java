package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:58:09 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoShukeiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoShukeiList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtServiceShurui;
    private RString txtTanisuGokei;
    private RString txtTanisuTanka;
    private RString txtSeikyugaku;
    private RString txtRiyoshaFutangaku;
    private RString txtShinsaHoho;

    public dgServiceTeikyoShomeishoShukeiList_Row() {
        super();
    }

    public dgServiceTeikyoShomeishoShukeiList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtServiceShurui, RString txtTanisuGokei, RString txtTanisuTanka, RString txtSeikyugaku, RString txtRiyoshaFutangaku, RString txtShinsaHoho) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtTanisuGokei", txtTanisuGokei);
        this.setOriginalData("txtTanisuTanka", txtTanisuTanka);
        this.setOriginalData("txtSeikyugaku", txtSeikyugaku);
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.setOriginalData("txtShinsaHoho", txtShinsaHoho);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtServiceShurui = txtServiceShurui;
        this.txtTanisuGokei = txtTanisuGokei;
        this.txtTanisuTanka = txtTanisuTanka;
        this.txtSeikyugaku = txtSeikyugaku;
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
        this.txtShinsaHoho = txtShinsaHoho;
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

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public RString getTxtTanisuGokei() {
        return txtTanisuGokei;
    }

    public RString getTxtTanisuTanka() {
        return txtTanisuTanka;
    }

    public RString getTxtSeikyugaku() {
        return txtSeikyugaku;
    }

    public RString getTxtRiyoshaFutangaku() {
        return txtRiyoshaFutangaku;
    }

    public RString getTxtShinsaHoho() {
        return txtShinsaHoho;
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

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtTanisuGokei(RString txtTanisuGokei) {
        this.setOriginalData("txtTanisuGokei", txtTanisuGokei);
        this.txtTanisuGokei = txtTanisuGokei;
    }

    public void setTxtTanisuTanka(RString txtTanisuTanka) {
        this.setOriginalData("txtTanisuTanka", txtTanisuTanka);
        this.txtTanisuTanka = txtTanisuTanka;
    }

    public void setTxtSeikyugaku(RString txtSeikyugaku) {
        this.setOriginalData("txtSeikyugaku", txtSeikyugaku);
        this.txtSeikyugaku = txtSeikyugaku;
    }

    public void setTxtRiyoshaFutangaku(RString txtRiyoshaFutangaku) {
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
    }

    public void setTxtShinsaHoho(RString txtShinsaHoho) {
        this.setOriginalData("txtShinsaHoho", txtShinsaHoho);
        this.txtShinsaHoho = txtShinsaHoho;
    }

}