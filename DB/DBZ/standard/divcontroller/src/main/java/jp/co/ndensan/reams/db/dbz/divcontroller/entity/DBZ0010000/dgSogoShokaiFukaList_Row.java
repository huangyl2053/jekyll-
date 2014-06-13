package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 10:13:46 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSogoShokaiFukaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiFukaList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtChoteiNendo;
    private RString txtFukaNendo;
    private RString txtKoseiTsuki;
    private RString txtRiyu;

    public dgSogoShokaiFukaList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtChoteiNendo = RString.EMPTY;
        this.txtFukaNendo = RString.EMPTY;
        this.txtKoseiTsuki = RString.EMPTY;
        this.txtRiyu = RString.EMPTY;
    }

    public dgSogoShokaiFukaList_Row(ButtonDialog btnSelect, RString txtChoteiNendo, RString txtFukaNendo, RString txtKoseiTsuki, RString txtRiyu) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtKoseiTsuki", txtKoseiTsuki);
        this.setOriginalData("txtRiyu", txtRiyu);
        this.btnSelect = btnSelect;
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtFukaNendo = txtFukaNendo;
        this.txtKoseiTsuki = txtKoseiTsuki;
        this.txtRiyu = txtRiyu;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    public RString getTxtFukaNendo() {
        return txtFukaNendo;
    }

    public RString getTxtKoseiTsuki() {
        return txtKoseiTsuki;
    }

    public RString getTxtRiyu() {
        return txtRiyu;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtChoteiNendo(RString txtChoteiNendo) {
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.txtChoteiNendo = txtChoteiNendo;
    }

    public void setTxtFukaNendo(RString txtFukaNendo) {
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.txtFukaNendo = txtFukaNendo;
    }

    public void setTxtKoseiTsuki(RString txtKoseiTsuki) {
        this.setOriginalData("txtKoseiTsuki", txtKoseiTsuki);
        this.txtKoseiTsuki = txtKoseiTsuki;
    }

    public void setTxtRiyu(RString txtRiyu) {
        this.setOriginalData("txtRiyu", txtRiyu);
        this.txtRiyu = txtRiyu;
    }

}