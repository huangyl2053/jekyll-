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
 * dgSogoShokaiKyufuShokanBaraiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiKyufuShokanBaraiList_Row extends DataRow {

    private ButtonDialog txtSelect;
    private RString txtServiceYM;
    private RString txtServiceShurui;
    private RString txtShinseiYMD;
    private RString txtSeiriNo;
    private RString txtShiharaiGokei;
    private RString txtHokenGokei;
    private RString txtJikoFutanGokei;

    public dgSogoShokaiKyufuShokanBaraiList_Row() {
        super();
        this.txtSelect = new ButtonDialog();
        this.txtServiceYM = RString.EMPTY;
        this.txtServiceShurui = RString.EMPTY;
        this.txtShinseiYMD = RString.EMPTY;
        this.txtSeiriNo = RString.EMPTY;
        this.txtShiharaiGokei = RString.EMPTY;
        this.txtHokenGokei = RString.EMPTY;
        this.txtJikoFutanGokei = RString.EMPTY;
    }

    public dgSogoShokaiKyufuShokanBaraiList_Row(ButtonDialog txtSelect, RString txtServiceYM, RString txtServiceShurui, RString txtShinseiYMD, RString txtSeiriNo, RString txtShiharaiGokei, RString txtHokenGokei, RString txtJikoFutanGokei) {
        super();
        this.setOriginalData("txtSelect", txtSelect);
        this.setOriginalData("txtServiceYM", txtServiceYM);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.setOriginalData("txtShiharaiGokei", txtShiharaiGokei);
        this.setOriginalData("txtHokenGokei", txtHokenGokei);
        this.setOriginalData("txtJikoFutanGokei", txtJikoFutanGokei);
        this.txtSelect = txtSelect;
        this.txtServiceYM = txtServiceYM;
        this.txtServiceShurui = txtServiceShurui;
        this.txtShinseiYMD = txtShinseiYMD;
        this.txtSeiriNo = txtSeiriNo;
        this.txtShiharaiGokei = txtShiharaiGokei;
        this.txtHokenGokei = txtHokenGokei;
        this.txtJikoFutanGokei = txtJikoFutanGokei;
    }

    public ButtonDialog getTxtSelect() {
        return txtSelect;
    }

    public RString getTxtServiceYM() {
        return txtServiceYM;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public RString getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getTxtSeiriNo() {
        return txtSeiriNo;
    }

    public RString getTxtShiharaiGokei() {
        return txtShiharaiGokei;
    }

    public RString getTxtHokenGokei() {
        return txtHokenGokei;
    }

    public RString getTxtJikoFutanGokei() {
        return txtJikoFutanGokei;
    }

    public void setTxtSelect(ButtonDialog txtSelect) {
        this.setOriginalData("txtSelect", txtSelect);
        this.txtSelect = txtSelect;
    }

    public void setTxtServiceYM(RString txtServiceYM) {
        this.setOriginalData("txtServiceYM", txtServiceYM);
        this.txtServiceYM = txtServiceYM;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtShinseiYMD(RString txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setTxtSeiriNo(RString txtSeiriNo) {
        this.setOriginalData("txtSeiriNo", txtSeiriNo);
        this.txtSeiriNo = txtSeiriNo;
    }

    public void setTxtShiharaiGokei(RString txtShiharaiGokei) {
        this.setOriginalData("txtShiharaiGokei", txtShiharaiGokei);
        this.txtShiharaiGokei = txtShiharaiGokei;
    }

    public void setTxtHokenGokei(RString txtHokenGokei) {
        this.setOriginalData("txtHokenGokei", txtHokenGokei);
        this.txtHokenGokei = txtHokenGokei;
    }

    public void setTxtJikoFutanGokei(RString txtJikoFutanGokei) {
        this.setOriginalData("txtJikoFutanGokei", txtJikoFutanGokei);
        this.txtJikoFutanGokei = txtJikoFutanGokei;
    }

}