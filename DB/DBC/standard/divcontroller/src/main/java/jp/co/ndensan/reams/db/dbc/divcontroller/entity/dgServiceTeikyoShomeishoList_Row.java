package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 19:35:16 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtShomeisho;
    private RString txtJigyosha;
    private Button btnGokei;

    public dgServiceTeikyoShomeishoList_Row() {
        super();
        this.btnSelect = new Button();
        this.btnEdit = new Button();
        this.btnDelete = new Button();
        this.txtShomeisho = RString.EMPTY;
        this.txtJigyosha = RString.EMPTY;
        this.btnGokei = new Button();
    }

    public dgServiceTeikyoShomeishoList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtShomeisho, RString txtJigyosha, Button btnGokei) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShomeisho", txtShomeisho);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("btnGokei", btnGokei);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtShomeisho = txtShomeisho;
        this.txtJigyosha = txtJigyosha;
        this.btnGokei = btnGokei;
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

    public RString getTxtShomeisho() {
        return txtShomeisho;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public Button getBtnGokei() {
        return btnGokei;
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

    public void setTxtShomeisho(RString txtShomeisho) {
        this.setOriginalData("txtShomeisho", txtShomeisho);
        this.txtShomeisho = txtShomeisho;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setBtnGokei(Button btnGokei) {
        this.setOriginalData("btnGokei", btnGokei);
        this.btnGokei = btnGokei;
    }

}