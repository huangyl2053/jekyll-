package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 18:43:54 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTeiseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTeiseiList_Row extends DataRow {

    private Button txtSelect;
    private RString txtHihokensha;
    private RString txtIdoYMD;
    private RString txtTeiseiKomoku;

    public dgTeiseiList_Row() {
        super();
        this.txtSelect = new Button();
        this.txtHihokensha = RString.EMPTY;
        this.txtIdoYMD = RString.EMPTY;
        this.txtTeiseiKomoku = RString.EMPTY;
    }

    public dgTeiseiList_Row(Button txtSelect, RString txtHihokensha, RString txtIdoYMD, RString txtTeiseiKomoku) {
        super();
        this.setOriginalData("txtSelect", txtSelect);
        this.setOriginalData("txtHihokensha", txtHihokensha);
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.setOriginalData("txtTeiseiKomoku", txtTeiseiKomoku);
        this.txtSelect = txtSelect;
        this.txtHihokensha = txtHihokensha;
        this.txtIdoYMD = txtIdoYMD;
        this.txtTeiseiKomoku = txtTeiseiKomoku;
    }

    public Button getTxtSelect() {
        return txtSelect;
    }

    public RString getTxtHihokensha() {
        return txtHihokensha;
    }

    public RString getTxtIdoYMD() {
        return txtIdoYMD;
    }

    public RString getTxtTeiseiKomoku() {
        return txtTeiseiKomoku;
    }

    public void setTxtSelect(Button txtSelect) {
        this.setOriginalData("txtSelect", txtSelect);
        this.txtSelect = txtSelect;
    }

    public void setTxtHihokensha(RString txtHihokensha) {
        this.setOriginalData("txtHihokensha", txtHihokensha);
        this.txtHihokensha = txtHihokensha;
    }

    public void setTxtIdoYMD(RString txtIdoYMD) {
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.txtIdoYMD = txtIdoYMD;
    }

    public void setTxtTeiseiKomoku(RString txtTeiseiKomoku) {
        this.setOriginalData("txtTeiseiKomoku", txtTeiseiKomoku);
        this.txtTeiseiKomoku = txtTeiseiKomoku;
    }

}