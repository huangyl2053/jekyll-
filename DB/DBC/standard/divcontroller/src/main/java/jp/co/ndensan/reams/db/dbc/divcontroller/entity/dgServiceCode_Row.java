package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 19:28:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceCode_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceCode_Row extends DataRow {

    private Button btnSelectRow;
    private RString txtServiceCode;

    public dgServiceCode_Row() {
        super();
        this.btnSelectRow = new Button();
        this.txtServiceCode = RString.EMPTY;
    }

    public dgServiceCode_Row(Button btnSelectRow, RString txtServiceCode) {
        super();
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.btnSelectRow = btnSelectRow;
        this.txtServiceCode = txtServiceCode;
    }

    public Button getBtnSelectRow() {
        return btnSelectRow;
    }

    public RString getTxtServiceCode() {
        return txtServiceCode;
    }

    public void setBtnSelectRow(Button btnSelectRow) {
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.btnSelectRow = btnSelectRow;
    }

    public void setTxtServiceCode(RString txtServiceCode) {
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.txtServiceCode = txtServiceCode;
    }

}