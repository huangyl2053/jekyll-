package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:39:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJutakuKaishuDetail_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutakuKaishuDetail_Row extends DataRow {

    private RString txtChakkoDueDate;
    private RString txtKanseiDueDate;
    private RString txtMitsumoriAmount;
    private RString txtKaishuJigyosha;
    private RString txtKaishuTaishoAddress;
    private RString txtKaishuContents;

    public dgJutakuKaishuDetail_Row() {
        super();
        this.txtChakkoDueDate = RString.EMPTY;
        this.txtKanseiDueDate = RString.EMPTY;
        this.txtMitsumoriAmount = RString.EMPTY;
        this.txtKaishuJigyosha = RString.EMPTY;
        this.txtKaishuTaishoAddress = RString.EMPTY;
        this.txtKaishuContents = RString.EMPTY;
    }

    public dgJutakuKaishuDetail_Row(RString txtChakkoDueDate, RString txtKanseiDueDate, RString txtMitsumoriAmount, RString txtKaishuJigyosha, RString txtKaishuTaishoAddress, RString txtKaishuContents) {
        super();
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.setOriginalData("txtMitsumoriAmount", txtMitsumoriAmount);
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.setOriginalData("txtKaishuTaishoAddress", txtKaishuTaishoAddress);
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtChakkoDueDate = txtChakkoDueDate;
        this.txtKanseiDueDate = txtKanseiDueDate;
        this.txtMitsumoriAmount = txtMitsumoriAmount;
        this.txtKaishuJigyosha = txtKaishuJigyosha;
        this.txtKaishuTaishoAddress = txtKaishuTaishoAddress;
        this.txtKaishuContents = txtKaishuContents;
    }

    public RString getTxtChakkoDueDate() {
        return txtChakkoDueDate;
    }

    public RString getTxtKanseiDueDate() {
        return txtKanseiDueDate;
    }

    public RString getTxtMitsumoriAmount() {
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

    public void setTxtChakkoDueDate(RString txtChakkoDueDate) {
        this.setOriginalData("txtChakkoDueDate", txtChakkoDueDate);
        this.txtChakkoDueDate = txtChakkoDueDate;
    }

    public void setTxtKanseiDueDate(RString txtKanseiDueDate) {
        this.setOriginalData("txtKanseiDueDate", txtKanseiDueDate);
        this.txtKanseiDueDate = txtKanseiDueDate;
    }

    public void setTxtMitsumoriAmount(RString txtMitsumoriAmount) {
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