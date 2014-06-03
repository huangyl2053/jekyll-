package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShokujiList;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:57:46 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoShokujiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoShokujiList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtService;
    private RString txtTanisu;
    private RString txtNissuKaisu;
    private RString txtKingaku;

    public dgServiceTeikyoShomeishoShokujiList_Row() {
        super();
    }

    public dgServiceTeikyoShomeishoShokujiList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtService, RString txtTanisu, RString txtNissuKaisu, RString txtKingaku) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtTanisu", txtTanisu);
        this.setOriginalData("txtNissuKaisu", txtNissuKaisu);
        this.setOriginalData("txtKingaku", txtKingaku);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtService = txtService;
        this.txtTanisu = txtTanisu;
        this.txtNissuKaisu = txtNissuKaisu;
        this.txtKingaku = txtKingaku;
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

    public RString getTxtService() {
        return txtService;
    }

    public RString getTxtTanisu() {
        return txtTanisu;
    }

    public RString getTxtNissuKaisu() {
        return txtNissuKaisu;
    }

    public RString getTxtKingaku() {
        return txtKingaku;
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

    public void setTxtService(RString txtService) {
        this.setOriginalData("txtService", txtService);
        this.txtService = txtService;
    }

    public void setTxtTanisu(RString txtTanisu) {
        this.setOriginalData("txtTanisu", txtTanisu);
        this.txtTanisu = txtTanisu;
    }

    public void setTxtNissuKaisu(RString txtNissuKaisu) {
        this.setOriginalData("txtNissuKaisu", txtNissuKaisu);
        this.txtNissuKaisu = txtNissuKaisu;
    }

    public void setTxtKingaku(RString txtKingaku) {
        this.setOriginalData("txtKingaku", txtKingaku);
        this.txtKingaku = txtKingaku;
    }

}