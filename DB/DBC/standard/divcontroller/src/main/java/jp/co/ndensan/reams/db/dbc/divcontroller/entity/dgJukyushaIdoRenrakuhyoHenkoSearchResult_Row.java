package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri May 23 15:48:05 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row extends DataRow {

    private Button btnModify;
    private Button btnDelete;
    private TextBoxDate txtResultIdoDate;
    private TextBoxCode txtResultHihoNo;
    private TextBox txtResultHihoName;
    private TextBoxDate txtResultSendYM;
    private Boolean txtDeletedDate;

    public dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row() {
        super();
    }

    public dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row(Button btnModify, Button btnDelete, TextBoxDate txtResultIdoDate, TextBoxCode txtResultHihoNo, TextBox txtResultHihoName, TextBoxDate txtResultSendYM, Boolean txtDeletedDate) {
        super();
        this.setOriginalData("btnModify", btnModify);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.setOriginalData("txtDeletedDate", txtDeletedDate);
        this.btnModify = btnModify;
        this.btnDelete = btnDelete;
        this.txtResultIdoDate = txtResultIdoDate;
        this.txtResultHihoNo = txtResultHihoNo;
        this.txtResultHihoName = txtResultHihoName;
        this.txtResultSendYM = txtResultSendYM;
        this.txtDeletedDate = txtDeletedDate;
    }

    public Button getBtnModify() {
        return btnModify;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public TextBoxDate getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public TextBoxCode getTxtResultHihoNo() {
        return txtResultHihoNo;
    }

    public TextBox getTxtResultHihoName() {
        return txtResultHihoName;
    }

    public TextBoxDate getTxtResultSendYM() {
        return txtResultSendYM;
    }

    public Boolean getTxtDeletedDate() {
        return txtDeletedDate;
    }

    public void setBtnModify(Button btnModify) {
        this.setOriginalData("btnModify", btnModify);
        this.btnModify = btnModify;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtResultIdoDate(TextBoxDate txtResultIdoDate) {
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.txtResultIdoDate = txtResultIdoDate;
    }

    public void setTxtResultHihoNo(TextBoxCode txtResultHihoNo) {
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.txtResultHihoNo = txtResultHihoNo;
    }

    public void setTxtResultHihoName(TextBox txtResultHihoName) {
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.txtResultHihoName = txtResultHihoName;
    }

    public void setTxtResultSendYM(TextBoxDate txtResultSendYM) {
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.txtResultSendYM = txtResultSendYM;
    }

    public void setTxtDeletedDate(Boolean txtDeletedDate) {
        this.setOriginalData("txtDeletedDate", txtDeletedDate);
        this.txtDeletedDate = txtDeletedDate;
    }

}