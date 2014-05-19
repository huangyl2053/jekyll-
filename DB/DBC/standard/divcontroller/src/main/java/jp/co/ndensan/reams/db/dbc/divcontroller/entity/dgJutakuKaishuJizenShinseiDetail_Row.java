package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 20 08:22:07 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJutakuKaishuJizenShinseiDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutakuKaishuJizenShinseiDetail_Row extends DataRow {

    private TextBoxDate txtChakkoDueDate;
    private TextBoxDate txtKanseiDueDate;
    private TextBoxNum txtMitsumoriAmount;
    private RString txtKaishuJigyosha;
    private RString txtTaishoJutakuAddress;
    private RString txtKaishuContents;

    public dgJutakuKaishuJizenShinseiDetail_Row() {
        super();
    }

    public dgJutakuKaishuJizenShinseiDetail_Row(TextBoxDate txtChakkoDueDate, TextBoxDate txtKanseiDueDate, TextBoxNum txtMitsumoriAmount, RString txtKaishuJigyosha, RString txtTaishoJutakuAddress, RString txtKaishuContents) {
        super();
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.setOriginalData("txtMitsumoriAmount", txtMitsumoriAmount);
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.setOriginalData("txtTaishoJutakuAddress", txtTaishoJutakuAddress);
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtChakkoDueDate = txtChakkoDueDate;
        this.txtKanseiDueDate = txtKanseiDueDate;
        this.txtMitsumoriAmount = txtMitsumoriAmount;
        this.txtKaishuJigyosha = txtKaishuJigyosha;
        this.txtTaishoJutakuAddress = txtTaishoJutakuAddress;
        this.txtKaishuContents = txtKaishuContents;
    }

    public TextBoxDate getTxtChakkoDueDate() {
        return txtChakkoDueDate;
    }

    public TextBoxDate getTxtKanseiDueDate() {
        return txtKanseiDueDate;
    }

    public TextBoxNum getTxtMitsumoriAmount() {
        return txtMitsumoriAmount;
    }

    public RString getTxtKaishuJigyosha() {
        return txtKaishuJigyosha;
    }

    public RString getTxtTaishoJutakuAddress() {
        return txtTaishoJutakuAddress;
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

    public void setTxtMitsumoriAmount(TextBoxNum txtMitsumoriAmount) {
        this.setOriginalData("txtMitsumoriAmount", txtMitsumoriAmount);
        this.txtMitsumoriAmount = txtMitsumoriAmount;
    }

    public void setTxtKaishuJigyosha(RString txtKaishuJigyosha) {
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.txtKaishuJigyosha = txtKaishuJigyosha;
    }

    public void setTxtTaishoJutakuAddress(RString txtTaishoJutakuAddress) {
        this.setOriginalData("txtTaishoJutakuAddress", txtTaishoJutakuAddress);
        this.txtTaishoJutakuAddress = txtTaishoJutakuAddress;
    }

    public void setTxtKaishuContents(RString txtKaishuContents) {
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtKaishuContents = txtKaishuContents;
    }

}