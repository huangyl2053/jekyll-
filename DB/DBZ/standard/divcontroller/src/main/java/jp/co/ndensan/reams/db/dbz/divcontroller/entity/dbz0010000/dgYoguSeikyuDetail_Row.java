package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 13 17:25:09 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgYoguSeikyuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgYoguSeikyuDetail_Row extends DataRow {

    private Button btnSelect;
    private RString txtBuyYMD;
    private RString txtShumoku;
    private RString txtShohinName;
    private RString txtBuyAmount;
    private RString txtShinsaMethod;

    public dgYoguSeikyuDetail_Row() {
        super();
        this.btnSelect = new Button();
        this.txtBuyYMD = RString.EMPTY;
        this.txtShumoku = RString.EMPTY;
        this.txtShohinName = RString.EMPTY;
        this.txtBuyAmount = RString.EMPTY;
        this.txtShinsaMethod = RString.EMPTY;
    }

    public dgYoguSeikyuDetail_Row(Button btnSelect, RString txtBuyYMD, RString txtShumoku, RString txtShohinName, RString txtBuyAmount, RString txtShinsaMethod) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.btnSelect = btnSelect;
        this.txtBuyYMD = txtBuyYMD;
        this.txtShumoku = txtShumoku;
        this.txtShohinName = txtShohinName;
        this.txtBuyAmount = txtBuyAmount;
        this.txtShinsaMethod = txtShinsaMethod;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtBuyYMD() {
        return txtBuyYMD;
    }

    public RString getTxtShumoku() {
        return txtShumoku;
    }

    public RString getTxtShohinName() {
        return txtShohinName;
    }

    public RString getTxtBuyAmount() {
        return txtBuyAmount;
    }

    public RString getTxtShinsaMethod() {
        return txtShinsaMethod;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtBuyYMD(RString txtBuyYMD) {
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.txtBuyYMD = txtBuyYMD;
    }

    public void setTxtShumoku(RString txtShumoku) {
        this.setOriginalData("txtShumoku", txtShumoku);
        this.txtShumoku = txtShumoku;
    }

    public void setTxtShohinName(RString txtShohinName) {
        this.setOriginalData("txtShohinName", txtShohinName);
        this.txtShohinName = txtShohinName;
    }

    public void setTxtBuyAmount(RString txtBuyAmount) {
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.txtBuyAmount = txtBuyAmount;
    }

    public void setTxtShinsaMethod(RString txtShinsaMethod) {
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.txtShinsaMethod = txtShinsaMethod;
    }

}