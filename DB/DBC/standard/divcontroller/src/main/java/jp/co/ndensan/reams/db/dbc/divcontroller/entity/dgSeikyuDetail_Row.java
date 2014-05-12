package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 12 18:49:52 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;


/**
 * dgSeikyuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyuDetail_Row extends DataRow {

    private TextBoxDate txtBuyYMD;
    private DropDownList txtShumoku;
    private TextBox txtShohinName;
    private TextBoxNum txtBuyAmount;
    private DropDownList txtShinsaMethod;
    private TextBoxCode txtHinmokuCode;
    private TextBox txtProductionJigyosha;
    private TextBox txtSalesJigyosha;

    public dgSeikyuDetail_Row() {
        super();
    }

    public dgSeikyuDetail_Row(TextBoxDate txtBuyYMD, DropDownList txtShumoku, TextBox txtShohinName, TextBoxNum txtBuyAmount, DropDownList txtShinsaMethod, TextBoxCode txtHinmokuCode, TextBox txtProductionJigyosha, TextBox txtSalesJigyosha) {
        super();
        this.setOriginalData("txtBuyYMD", txtBuyYMD);
        this.setOriginalData("txtShumoku", txtShumoku);
        this.setOriginalData("txtShohinName", txtShohinName);
        this.setOriginalData("txtBuyAmount", txtBuyAmount);
        this.setOriginalData("txtShinsaMethod", txtShinsaMethod);
        this.setOriginalData("txtHinmokuCode", txtHinmokuCode);
        this.setOriginalData("txtProductionJigyosha", txtProductionJigyosha);
        this.setOriginalData("txtSalesJigyosha", txtSalesJigyosha);
        this.txtBuyYMD = txtBuyYMD;
        this.txtShumoku = txtShumoku;
        this.txtShohinName = txtShohinName;
        this.txtBuyAmount = txtBuyAmount;
        this.txtShinsaMethod = txtShinsaMethod;
        this.txtHinmokuCode = txtHinmokuCode;
        this.txtProductionJigyosha = txtProductionJigyosha;
        this.txtSalesJigyosha = txtSalesJigyosha;
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

    public TextBoxCode getTxtHinmokuCode() {
        return txtHinmokuCode;
    }

    public TextBox getTxtProductionJigyosha() {
        return txtProductionJigyosha;
    }

    public TextBox getTxtSalesJigyosha() {
        return txtSalesJigyosha;
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

    public void setTxtHinmokuCode(TextBoxCode txtHinmokuCode) {
        this.setOriginalData("txtHinmokuCode", txtHinmokuCode);
        this.txtHinmokuCode = txtHinmokuCode;
    }

    public void setTxtProductionJigyosha(TextBox txtProductionJigyosha) {
        this.setOriginalData("txtProductionJigyosha", txtProductionJigyosha);
        this.txtProductionJigyosha = txtProductionJigyosha;
    }

    public void setTxtSalesJigyosha(TextBox txtSalesJigyosha) {
        this.setOriginalData("txtSalesJigyosha", txtSalesJigyosha);
        this.txtSalesJigyosha = txtSalesJigyosha;
    }

}