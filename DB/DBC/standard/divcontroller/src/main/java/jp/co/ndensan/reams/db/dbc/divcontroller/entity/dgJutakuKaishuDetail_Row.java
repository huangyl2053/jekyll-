package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。 Tue May 27 14:01:30 JST 2014
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * dgJutakuKaishuDetail_Row のクラスファイル
 *
 * @author 自動生成
 */
public class dgJutakuKaishuDetail_Row extends DataRow {

    private Button btnModify;
    private Button btnDelete;
    private TextBoxDate txtChakkoDueDate;
    private TextBoxDate txtKanseiDueDate;
    private TextBoxNum txtMitsumoriAmount;
    private RString txtKaishuJigyosha;
    private RString txtKaishuTaishoAddress;
    private RString txtKaishuContents;

    public dgJutakuKaishuDetail_Row() {
        super();
    }

    public dgJutakuKaishuDetail_Row(Button btnModify, Button btnDelete, TextBoxDate txtChakkoDueDate, TextBoxDate txtKanseiDueDate, TextBoxNum txtMitsumoriAmount, RString txtKaishuJigyosha, RString txtKaishuTaishoAddress, RString txtKaishuContents) {
        super();
        this.setOriginalData("btnModify", btnModify);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.setOriginalData("txtMitsumoriAmount", txtMitsumoriAmount);
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.setOriginalData("txtKaishuTaishoAddress", txtKaishuTaishoAddress);
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.btnModify = btnModify;
        this.btnDelete = btnDelete;
        this.txtChakkoDueDate = txtChakkoDueDate;
        this.txtKanseiDueDate = txtKanseiDueDate;
        this.txtMitsumoriAmount = txtMitsumoriAmount;
        this.txtKaishuJigyosha = txtKaishuJigyosha;
        this.txtKaishuTaishoAddress = txtKaishuTaishoAddress;
        this.txtKaishuContents = txtKaishuContents;
    }

    public Button getBtnModify() {
        return btnModify;
    }

    public Button getBtnDelete() {
        return btnDelete;
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

    public RString getTxtKaishuTaishoAddress() {
        return txtKaishuTaishoAddress;
    }

    public RString getTxtKaishuContents() {
        return txtKaishuContents;
    }

    public void setBtnModify(Button btnModify) {
        this.setOriginalData("btnModify", btnModify);
        this.btnModify = btnModify;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
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

    public void setTxtKaishuTaishoAddress(RString txtKaishuTaishoAddress) {
        this.setOriginalData("txtKaishuTaishoAddress", txtKaishuTaishoAddress);
        this.txtKaishuTaishoAddress = txtKaishuTaishoAddress;
    }

    public void setTxtKaishuContents(RString txtKaishuContents) {
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtKaishuContents = txtKaishuContents;
    }

}
