package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 13 17:14:02 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSogoShokaiJukyuShisetsuNyushoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiJukyuShisetsuNyushoList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtBunrui;
    private RString txtNyushoYMD;
    private RString txtTaishoYMD;
    private RString txtShisetsuName;
    private RString txtJigyosha;
    private RString txtShozaichi;

    public dgSogoShokaiJukyuShisetsuNyushoList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtBunrui = RString.EMPTY;
        this.txtNyushoYMD = RString.EMPTY;
        this.txtTaishoYMD = RString.EMPTY;
        this.txtShisetsuName = RString.EMPTY;
        this.txtJigyosha = RString.EMPTY;
        this.txtShozaichi = RString.EMPTY;
    }

    public dgSogoShokaiJukyuShisetsuNyushoList_Row(ButtonDialog btnSelect, RString txtBunrui, RString txtNyushoYMD, RString txtTaishoYMD, RString txtShisetsuName, RString txtJigyosha, RString txtShozaichi) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtBunrui", txtBunrui);
        this.setOriginalData("txtNyushoYMD", txtNyushoYMD);
        this.setOriginalData("txtTaishoYMD", txtTaishoYMD);
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtShozaichi", txtShozaichi);
        this.btnSelect = btnSelect;
        this.txtBunrui = txtBunrui;
        this.txtNyushoYMD = txtNyushoYMD;
        this.txtTaishoYMD = txtTaishoYMD;
        this.txtShisetsuName = txtShisetsuName;
        this.txtJigyosha = txtJigyosha;
        this.txtShozaichi = txtShozaichi;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtBunrui() {
        return txtBunrui;
    }

    public RString getTxtNyushoYMD() {
        return txtNyushoYMD;
    }

    public RString getTxtTaishoYMD() {
        return txtTaishoYMD;
    }

    public RString getTxtShisetsuName() {
        return txtShisetsuName;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtShozaichi() {
        return txtShozaichi;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtBunrui(RString txtBunrui) {
        this.setOriginalData("txtBunrui", txtBunrui);
        this.txtBunrui = txtBunrui;
    }

    public void setTxtNyushoYMD(RString txtNyushoYMD) {
        this.setOriginalData("txtNyushoYMD", txtNyushoYMD);
        this.txtNyushoYMD = txtNyushoYMD;
    }

    public void setTxtTaishoYMD(RString txtTaishoYMD) {
        this.setOriginalData("txtTaishoYMD", txtTaishoYMD);
        this.txtTaishoYMD = txtTaishoYMD;
    }

    public void setTxtShisetsuName(RString txtShisetsuName) {
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.txtShisetsuName = txtShisetsuName;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtShozaichi(RString txtShozaichi) {
        this.setOriginalData("txtShozaichi", txtShozaichi);
        this.txtShozaichi = txtShozaichi;
    }

}