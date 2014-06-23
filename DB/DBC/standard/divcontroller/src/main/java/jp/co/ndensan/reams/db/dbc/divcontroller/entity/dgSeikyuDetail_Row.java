package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 23 16:57:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgSeikyuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyuDetail_Row extends DataRow {

    private TextBoxDate txtBuyYMD;
    private TextBox txtShumoku;
    private TextBox txtShohinName;
    private TextBoxNum txtBuyAmount;
    private TextBox txtShinsaMethod;

    public dgSeikyuDetail_Row() {
        super();
        this.txtBuyYMD = new TextBoxDate();
        this.txtShumoku = new TextBox();
        this.txtShohinName = new TextBox();
        this.txtBuyAmount = new TextBoxNum();
        this.txtShinsaMethod = new TextBox();
    }

    public dgSeikyuDetail_Row(TextBoxDate txtBuyYMD, TextBox txtShumoku, TextBox txtShohinName, TextBoxNum txtBuyAmount, TextBox txtShinsaMethod) {
        super();
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.txtBuyYMD = txtBuyYMD;
        this.txtShumoku = txtShumoku;
        this.txtShohinName = txtShohinName;
        this.txtBuyAmount = txtBuyAmount;
        this.txtShinsaMethod = txtShinsaMethod;
    }

    public TextBoxDate getTxtBuyYMD() {
        return txtBuyYMD;
    }

    public TextBox getTxtShumoku() {
        return txtShumoku;
    }

    public TextBox getTxtShohinName() {
        return txtShohinName;
    }

    public TextBoxNum getTxtBuyAmount() {
        return txtBuyAmount;
    }

    public TextBox getTxtShinsaMethod() {
        return txtShinsaMethod;
    }

    public void setTxtBuyYMD(TextBoxDate txtBuyYMD) {
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.txtBuyYMD = txtBuyYMD;
    }

    public void setTxtShumoku(TextBox txtShumoku) {
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

    public void setTxtShinsaMethod(TextBox txtShinsaMethod) {
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.txtShinsaMethod = txtShinsaMethod;
    }

}