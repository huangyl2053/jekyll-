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
 * dgSogoShokaiKyufuKogakuKaigoServiceList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiKyufuKogakuKaigoServiceList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtTeikyoYM;
    private RString txtShinseiYMD;
    private RString txtKetteiYMD;

    public dgSogoShokaiKyufuKogakuKaigoServiceList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtTeikyoYM = RString.EMPTY;
        this.txtShinseiYMD = RString.EMPTY;
        this.txtKetteiYMD = RString.EMPTY;
    }

    public dgSogoShokaiKyufuKogakuKaigoServiceList_Row(ButtonDialog btnSelect, RString txtTeikyoYM, RString txtShinseiYMD, RString txtKetteiYMD) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.btnSelect = btnSelect;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtShinseiYMD = txtShinseiYMD;
        this.txtKetteiYMD = txtKetteiYMD;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public RString getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtTeikyoYM(RString txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtShinseiYMD(RString txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setTxtKetteiYMD(RString txtKetteiYMD) {
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.txtKetteiYMD = txtKetteiYMD;
    }

}