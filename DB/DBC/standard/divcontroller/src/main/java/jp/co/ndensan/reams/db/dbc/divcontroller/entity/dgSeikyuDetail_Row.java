package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 13 15:32:44 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgSeikyuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyuDetail_Row extends DataRow {

    private Button btnModify;
    private Button btnDelete;
    private TextBox txtRowState;
    private TextBoxDate txtBuyYMD;
    private DropDownList txtShumoku;
    private TextBox txtShohinName;
    private TextBoxNum txtBuyAmount;
    private DropDownList txtShinsaMethod;

    public dgSeikyuDetail_Row() {
        super();
    }

    public dgSeikyuDetail_Row(Button btnModify, Button btnDelete, TextBox txtRowState, TextBoxDate txtBuyYMD, DropDownList txtShumoku, TextBox txtShohinName, TextBoxNum txtBuyAmount, DropDownList txtShinsaMethod) {
        super();
        this.setOriginalData("btnModify", btnModify);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtRowState", txtRowState);
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.btnModify = btnModify;
        this.btnDelete = btnDelete;
        this.txtRowState = txtRowState;
        this.txtBuyYMD = txtBuyYMD;
        this.txtShumoku = txtShumoku;
        this.txtShohinName = txtShohinName;
        this.txtBuyAmount = txtBuyAmount;
        this.txtShinsaMethod = txtShinsaMethod;
    }

    public Button getBtnModify() {
        return btnModify;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public TextBox getTxtRowState() {
        return txtRowState;
    }

    public TextBoxDate getTxtBuyYMD() {
        return txtBuyYMD;
    }

    public DropDownList getTxtShumoku() {
        return txtShumoku;
    }

    public TextBox getTxtShohinName() {
        return txtShohinName;
    }

    public TextBoxNum getTxtBuyAmount() {
        return txtBuyAmount;
    }

    public DropDownList getTxtShinsaMethod() {
        return txtShinsaMethod;
    }

    public void setBtnModify(Button btnModify) {
        this.setOriginalData("btnModify", btnModify);
        this.btnModify = btnModify;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtRowState(TextBox txtRowState) {
        this.setOriginalData("txtRowState", txtRowState);
        this.txtRowState = txtRowState;
    }

    public void setTxtBuyYMD(TextBoxDate txtBuyYMD) {
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.txtBuyYMD = txtBuyYMD;
    }

    public void setTxtShumoku(DropDownList txtShumoku) {
        this.setOriginalData("txtShumoku", txtShumoku);
        this.txtShumoku = txtShumoku;
    }

    public void setTxtShohinName(TextBox txtShohinName) {
        this.setOriginalData("txtShohinName", txtShohinName);
        this.txtShohinName = txtShohinName;
    }

    public void setTxtBuyAmount(TextBoxNum txtBuyAmount) {
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.txtBuyAmount = txtBuyAmount;
    }

    public void setTxtShinsaMethod(DropDownList txtShinsaMethod) {
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.txtShinsaMethod = txtShinsaMethod;
    }

}