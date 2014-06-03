package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoKeikakuList;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 19:54:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShokanShikyuTorokuShomeishoKeikakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShokanShikyuTorokuShomeishoKeikakuList_Row extends DataRow {

    private Button btnSelect;
    private Button btnEdit;
    private Button btnDelete;
    private RString txtService;
    private RString txtTanisu;
    private RString txtKaisu;
    private RString txtServiceTanisu;
    private RString txtTekiyo;

    public dgShokanShikyuTorokuShomeishoKeikakuList_Row() {
        super();
    }

    public dgShokanShikyuTorokuShomeishoKeikakuList_Row(Button btnSelect, Button btnEdit, Button btnDelete, RString txtService, RString txtTanisu, RString txtKaisu, RString txtServiceTanisu, RString txtTekiyo) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnEdit", btnEdit);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtTanisu", txtTanisu);
        this.setOriginalData("txtKaisu", txtKaisu);
        this.setOriginalData("txtServiceTanisu", txtServiceTanisu);
        this.setOriginalData("txtTekiyo", txtTekiyo);
        this.btnSelect = btnSelect;
        this.btnEdit = btnEdit;
        this.btnDelete = btnDelete;
        this.txtService = txtService;
        this.txtTanisu = txtTanisu;
        this.txtKaisu = txtKaisu;
        this.txtServiceTanisu = txtServiceTanisu;
        this.txtTekiyo = txtTekiyo;
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

    public RString getTxtKaisu() {
        return txtKaisu;
    }

    public RString getTxtServiceTanisu() {
        return txtServiceTanisu;
    }

    public RString getTxtTekiyo() {
        return txtTekiyo;
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

    public void setTxtKaisu(RString txtKaisu) {
        this.setOriginalData("txtKaisu", txtKaisu);
        this.txtKaisu = txtKaisu;
    }

    public void setTxtServiceTanisu(RString txtServiceTanisu) {
        this.setOriginalData("txtServiceTanisu", txtServiceTanisu);
        this.txtServiceTanisu = txtServiceTanisu;
    }

    public void setTxtTekiyo(RString txtTekiyo) {
        this.setOriginalData("txtTekiyo", txtTekiyo);
        this.txtTekiyo = txtTekiyo;
    }

}