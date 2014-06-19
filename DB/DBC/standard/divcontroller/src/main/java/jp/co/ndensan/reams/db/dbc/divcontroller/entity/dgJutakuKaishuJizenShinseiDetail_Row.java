package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 19 18:18:37 JST 2014 
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

    private TextBoxDate txtChakkoDate;
    private TextBoxDate txtKanseiDate;
    private TextBoxNum txtMitsumoriAmount;
    private RString txtKaishuJigyosha;
    private RString txtTaishoJutakuAddress;
    private RString txtKaishuContents;

    public dgJutakuKaishuJizenShinseiDetail_Row() {
        super();
        this.txtChakkoDate = new TextBoxDate();
        this.txtKanseiDate = new TextBoxDate();
        this.txtMitsumoriAmount = new TextBoxNum();
        this.txtKaishuJigyosha = RString.EMPTY;
        this.txtTaishoJutakuAddress = RString.EMPTY;
        this.txtKaishuContents = RString.EMPTY;
    }

    public dgJutakuKaishuJizenShinseiDetail_Row(TextBoxDate txtChakkoDate, TextBoxDate txtKanseiDate, TextBoxNum txtMitsumoriAmount, RString txtKaishuJigyosha, RString txtTaishoJutakuAddress, RString txtKaishuContents) {
        super();
        this.setOriginalData("txtChakkoDate", txtChakkoDate);
        this.setOriginalData("txtKanseiDate", txtKanseiDate);
        this.setOriginalData("txtMitsumoriAmount", txtMitsumoriAmount);
        this.setOriginalData("txtKaishuJigyosha", txtKaishuJigyosha);
        this.setOriginalData("txtTaishoJutakuAddress", txtTaishoJutakuAddress);
        this.setOriginalData("txtKaishuContents", txtKaishuContents);
        this.txtChakkoDate = txtChakkoDate;
        this.txtKanseiDate = txtKanseiDate;
        this.txtMitsumoriAmount = txtMitsumoriAmount;
        this.txtKaishuJigyosha = txtKaishuJigyosha;
        this.txtTaishoJutakuAddress = txtTaishoJutakuAddress;
        this.txtKaishuContents = txtKaishuContents;
    }

    public TextBoxDate getTxtChakkoDate() {
        return txtChakkoDate;
    }

    public TextBoxDate getTxtKanseiDate() {
        return txtKanseiDate;
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

    public void setTxtChakkoDate(TextBoxDate txtChakkoDate) {
        this.setOriginalData("txtChakkoDate", txtChakkoDate);
        this.txtChakkoDate = txtChakkoDate;
    }

    public void setTxtKanseiDate(TextBoxDate txtKanseiDate) {
        this.setOriginalData("txtKanseiDate", txtKanseiDate);
        this.txtKanseiDate = txtKanseiDate;
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