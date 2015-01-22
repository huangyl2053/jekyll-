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
 * dgErrorList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgErrorList_Row extends DataRow {

    private Button txtSelect;
    private RString txtHihokensha;
    private RString txtErrorInfo;

    public dgErrorList_Row() {
        super();
        this.txtSelect = new Button();
        this.txtHihokensha = RString.EMPTY;
        this.txtErrorInfo = RString.EMPTY;
    }

    public dgErrorList_Row(Button txtSelect, RString txtHihokensha, RString txtErrorInfo) {
        super();
        this.setOriginalData("txtSelect", txtSelect);
        this.setOriginalData("txtHihokensha", txtHihokensha);
        this.setOriginalData("txtErrorInfo", txtErrorInfo);
        this.txtSelect = txtSelect;
        this.txtHihokensha = txtHihokensha;
        this.txtErrorInfo = txtErrorInfo;
    }

    public Button getTxtSelect() {
        return txtSelect;
    }

    public RString getTxtHihokensha() {
        return txtHihokensha;
    }

    public RString getTxtErrorInfo() {
        return txtErrorInfo;
    }

    public void setTxtSelect(Button txtSelect) {
        this.setOriginalData("txtSelect", txtSelect);
        this.txtSelect = txtSelect;
    }

    public void setTxtHihokensha(RString txtHihokensha) {
        this.setOriginalData("txtHihokensha", txtHihokensha);
        this.txtHihokensha = txtHihokensha;
    }

    public void setTxtErrorInfo(RString txtErrorInfo) {
        this.setOriginalData("txtErrorInfo", txtErrorInfo);
        this.txtErrorInfo = txtErrorInfo;
    }

}