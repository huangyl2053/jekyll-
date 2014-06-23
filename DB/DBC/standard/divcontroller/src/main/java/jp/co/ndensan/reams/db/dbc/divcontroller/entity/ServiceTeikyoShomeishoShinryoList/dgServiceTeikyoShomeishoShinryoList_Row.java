package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShinryoList;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:57:20 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceTeikyoShomeishoShinryoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceTeikyoShomeishoShinryoList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtShobyoName;
    private RString txtShikibetsuNo;
    private RString txtTanisu;
    private RString txtKaisu;
    private RString txtGokeiTanisu;

    public dgServiceTeikyoShomeishoShinryoList_Row() {
        super();
    }

    public dgServiceTeikyoShomeishoShinryoList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtShobyoName, RString txtShikibetsuNo, RString txtTanisu, RString txtKaisu, RString txtGokeiTanisu) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShobyoName", txtShobyoName);
        this.setOriginalData("txtShikibetsuNo", txtShikibetsuNo);
        this.setOriginalData("txtTanisu", txtTanisu);
        this.setOriginalData("txtKaisu", txtKaisu);
        this.setOriginalData("txtGokeiTanisu", txtGokeiTanisu);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtShobyoName = txtShobyoName;
        this.txtShikibetsuNo = txtShikibetsuNo;
        this.txtTanisu = txtTanisu;
        this.txtKaisu = txtKaisu;
        this.txtGokeiTanisu = txtGokeiTanisu;
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

    public RString getTxtShobyoName() {
        return txtShobyoName;
    }

    public RString getTxtShikibetsuNo() {
        return txtShikibetsuNo;
    }

    public RString getTxtTanisu() {
        return txtTanisu;
    }

    public RString getTxtKaisu() {
        return txtKaisu;
    }

    public RString getTxtGokeiTanisu() {
        return txtGokeiTanisu;
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

    public void setTxtShobyoName(RString txtShobyoName) {
        this.setOriginalData("txtShobyoName", txtShobyoName);
        this.txtShobyoName = txtShobyoName;
    }

    public void setTxtShikibetsuNo(RString txtShikibetsuNo) {
        this.setOriginalData("txtShikibetsuNo", txtShikibetsuNo);
        this.txtShikibetsuNo = txtShikibetsuNo;
    }

    public void setTxtTanisu(RString txtTanisu) {
        this.setOriginalData("txtTanisu", txtTanisu);
        this.txtTanisu = txtTanisu;
    }

    public void setTxtKaisu(RString txtKaisu) {
        this.setOriginalData("txtKaisu", txtKaisu);
        this.txtKaisu = txtKaisu;
    }

    public void setTxtGokeiTanisu(RString txtGokeiTanisu) {
        this.setOriginalData("txtGokeiTanisu", txtGokeiTanisu);
        this.txtGokeiTanisu = txtGokeiTanisu;
    }

}