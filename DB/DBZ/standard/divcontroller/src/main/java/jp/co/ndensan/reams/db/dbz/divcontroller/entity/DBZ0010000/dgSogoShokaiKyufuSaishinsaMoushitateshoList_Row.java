package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 10:13:46 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtMoushitateYMD;
    private RString txtJigyosha;
    private RString txtTeikyoYM;
    private RString txtService;
    private RString txtTanisu;
    private RString txtRiyu;

    public dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtMoushitateYMD = RString.EMPTY;
        this.txtJigyosha = RString.EMPTY;
        this.txtTeikyoYM = RString.EMPTY;
        this.txtService = RString.EMPTY;
        this.txtTanisu = RString.EMPTY;
        this.txtRiyu = RString.EMPTY;
    }

    public dgSogoShokaiKyufuSaishinsaMoushitateshoList_Row(ButtonDialog btnSelect, RString txtMoushitateYMD, RString txtJigyosha, RString txtTeikyoYM, RString txtService, RString txtTanisu, RString txtRiyu) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtMoushitateYMD", txtMoushitateYMD);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtTanisu", txtTanisu);
        this.setOriginalData("txtRiyu", txtRiyu);
        this.btnSelect = btnSelect;
        this.txtMoushitateYMD = txtMoushitateYMD;
        this.txtJigyosha = txtJigyosha;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtService = txtService;
        this.txtTanisu = txtTanisu;
        this.txtRiyu = txtRiyu;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtMoushitateYMD() {
        return txtMoushitateYMD;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public RString getTxtService() {
        return txtService;
    }

    public RString getTxtTanisu() {
        return txtTanisu;
    }

    public RString getTxtRiyu() {
        return txtRiyu;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtMoushitateYMD(RString txtMoushitateYMD) {
        this.setOriginalData("txtMoushitateYMD", txtMoushitateYMD);
        this.txtMoushitateYMD = txtMoushitateYMD;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtTeikyoYM(RString txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtService(RString txtService) {
        this.setOriginalData("txtService", txtService);
        this.txtService = txtService;
    }

    public void setTxtTanisu(RString txtTanisu) {
        this.setOriginalData("txtTanisu", txtTanisu);
        this.txtTanisu = txtTanisu;
    }

    public void setTxtRiyu(RString txtRiyu) {
        this.setOriginalData("txtRiyu", txtRiyu);
        this.txtRiyu = txtRiyu;
    }

}