package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:56:53 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoShafukuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoShafukuList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtShurui;
    private RString txtKeigenritsu;
    private RString txtFutanSogaku;
    private RString txtKeigengaku;
    private RString txtKeigengoRiyoshaFutangaku;
    private RString txtBiko;

    public dgServiceTeikyoShomeishoShafukuList_Row() {
        super();
    }

    public dgServiceTeikyoShomeishoShafukuList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtShurui, RString txtKeigenritsu, RString txtFutanSogaku, RString txtKeigengaku, RString txtKeigengoRiyoshaFutangaku, RString txtBiko) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShurui", txtShurui);
        this.setOriginalData("txtKeigenritsu", txtKeigenritsu);
        this.setOriginalData("txtFutanSogaku", txtFutanSogaku);
        this.setOriginalData("txtKeigengaku", txtKeigengaku);
        this.setOriginalData("txtKeigengoRiyoshaFutangaku", txtKeigengoRiyoshaFutangaku);
        this.setOriginalData("txtBiko", txtBiko);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtShurui = txtShurui;
        this.txtKeigenritsu = txtKeigenritsu;
        this.txtFutanSogaku = txtFutanSogaku;
        this.txtKeigengaku = txtKeigengaku;
        this.txtKeigengoRiyoshaFutangaku = txtKeigengoRiyoshaFutangaku;
        this.txtBiko = txtBiko;
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

    public RString getTxtShurui() {
        return txtShurui;
    }

    public RString getTxtKeigenritsu() {
        return txtKeigenritsu;
    }

    public RString getTxtFutanSogaku() {
        return txtFutanSogaku;
    }

    public RString getTxtKeigengaku() {
        return txtKeigengaku;
    }

    public RString getTxtKeigengoRiyoshaFutangaku() {
        return txtKeigengoRiyoshaFutangaku;
    }

    public RString getTxtBiko() {
        return txtBiko;
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

    public void setTxtShurui(RString txtShurui) {
        this.setOriginalData("txtShurui", txtShurui);
        this.txtShurui = txtShurui;
    }

    public void setTxtKeigenritsu(RString txtKeigenritsu) {
        this.setOriginalData("txtKeigenritsu", txtKeigenritsu);
        this.txtKeigenritsu = txtKeigenritsu;
    }

    public void setTxtFutanSogaku(RString txtFutanSogaku) {
        this.setOriginalData("txtFutanSogaku", txtFutanSogaku);
        this.txtFutanSogaku = txtFutanSogaku;
    }

    public void setTxtKeigengaku(RString txtKeigengaku) {
        this.setOriginalData("txtKeigengaku", txtKeigengaku);
        this.txtKeigengaku = txtKeigengaku;
    }

    public void setTxtKeigengoRiyoshaFutangaku(RString txtKeigengoRiyoshaFutangaku) {
        this.setOriginalData("txtKeigengoRiyoshaFutangaku", txtKeigengoRiyoshaFutangaku);
        this.txtKeigengoRiyoshaFutangaku = txtKeigengoRiyoshaFutangaku;
    }

    public void setTxtBiko(RString txtBiko) {
        this.setOriginalData("txtBiko", txtBiko);
        this.txtBiko = txtBiko;
    }

}