package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 18:48:43 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJutakuKaishuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutakuKaishuDetail_Row extends DataRow {

    private TextBoxDate txtChakkoDueDate;
    private TextBoxDate txtKanseiDueDate;
    private TextBoxNum txtKaishuAmount;
    private RString txtKaishuJigyosha;
    private RString txtKaishuTaishoAddress;
    private RString txtKaishuContents;

    public dgJutakuKaishuDetail_Row() {
        super();
        this.txtChakkoDueDate = new TextBoxDate();
        this.txtKanseiDueDate = new TextBoxDate();
        this.txtKaishuAmount = new TextBoxNum();
        this.txtKaishuJigyosha = RString.EMPTY;
        this.txtKaishuTaishoAddress = RString.EMPTY;
        this.txtKaishuContents = RString.EMPTY;
    }

    public dgJutakuKaishuDetail_Row(TextBoxDate txtChakkoDueDate, TextBoxDate txtKanseiDueDate, TextBoxNum txtKaishuAmount, RString txtKaishuJigyosha, RString txtKaishuTaishoAddress, RString txtKaishuContents) {
        super();
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.setOriginalData("txtKaishuAmount", txtKaishuAmount);
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.setOriginalData("txtKaishuTaishoAddress", txtKaishuTaishoAddress);
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtChakkoDueDate = txtChakkoDueDate;
        this.txtKanseiDueDate = txtKanseiDueDate;
        this.txtKaishuAmount = txtKaishuAmount;
        this.txtKaishuJigyosha = txtKaishuJigyosha;
        this.txtKaishuTaishoAddress = txtKaishuTaishoAddress;
        this.txtKaishuContents = txtKaishuContents;
    }

    public TextBoxDate getTxtChakkoDueDate() {
        return txtChakkoDueDate;
    }

    public TextBoxDate getTxtKanseiDueDate() {
        return txtKanseiDueDate;
    }

    public TextBoxNum getTxtKaishuAmount() {
        return txtKaishuAmount;
    }

    public RString getTxtKaishuJigyosha() {
        return txtKaishuJigyosha;
    }

    public RString getTxtKaishuTaishoAddress() {
        return txtKaishuTaishoAddress;
    }

    public RString getTxtKaishuContents() {
        return txtKaishuContents;
    }

    public void setTxtChakkoDueDate(TextBoxDate txtChakkoDueDate) {
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.txtChakkoDueDate = txtChakkoDueDate;
    }

    public void setTxtKanseiDueDate(TextBoxDate txtKanseiDueDate) {
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.txtKanseiDueDate = txtKanseiDueDate;
    }

    public void setTxtKaishuAmount(TextBoxNum txtKaishuAmount) {
        this.setOriginalData("txtKaishuAmount", txtKaishuAmount);
        this.txtKaishuAmount = txtKaishuAmount;
    }

    public void setTxtKaishuJigyosha(RString txtKaishuJigyosha) {
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.txtKaishuJigyosha = txtKaishuJigyosha;
    }

    public void setTxtKaishuTaishoAddress(RString txtKaishuTaishoAddress) {
        this.setOriginalData("txtKaishuTaishoAddress", txtKaishuTaishoAddress);
        this.txtKaishuTaishoAddress = txtKaishuTaishoAddress;
    }

    public void setTxtKaishuContents(RString txtKaishuContents) {
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtKaishuContents = txtKaishuContents;
    }

}