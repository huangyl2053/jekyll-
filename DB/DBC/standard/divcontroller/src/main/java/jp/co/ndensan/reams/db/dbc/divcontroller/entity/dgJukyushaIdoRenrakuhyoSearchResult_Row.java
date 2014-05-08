package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 11:22:59 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgJukyushaIdoRenrakuhyoSearchResult_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJukyushaIdoRenrakuhyoSearchResult_Row extends DataRow {

    private Button btnShowDetail;
    private TextBoxFlexibleDate txtResultIdoDate;
    private TextBoxCode txtResultHihoNo;
    private TextBox txtResultHihoName;
    private TextBoxFlexibleDate txtResultSendYM;

    public dgJukyushaIdoRenrakuhyoSearchResult_Row() {
        super();
    }

    public dgJukyushaIdoRenrakuhyoSearchResult_Row(Button btnShowDetail, TextBoxFlexibleDate txtResultIdoDate, TextBoxCode txtResultHihoNo, TextBox txtResultHihoName, TextBoxFlexibleDate txtResultSendYM) {
        super();
        this.setOriginalData("btnShowDetail", btnShowDetail);
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.btnShowDetail = btnShowDetail;
        this.txtResultIdoDate = txtResultIdoDate;
        this.txtResultHihoNo = txtResultHihoNo;
        this.txtResultHihoName = txtResultHihoName;
        this.txtResultSendYM = txtResultSendYM;
    }

    public Button getBtnShowDetail() {
        return btnShowDetail;
    }

    public TextBoxFlexibleDate getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public TextBoxCode getTxtResultHihoNo() {
        return txtResultHihoNo;
    }

    public TextBox getTxtResultHihoName() {
        return txtResultHihoName;
    }

    public TextBoxFlexibleDate getTxtResultSendYM() {
        return txtResultSendYM;
    }

    public void setBtnShowDetail(Button btnShowDetail) {
        this.setOriginalData("btnShowDetail", btnShowDetail);
        this.btnShowDetail = btnShowDetail;
    }

    public void setTxtResultIdoDate(TextBoxFlexibleDate txtResultIdoDate) {
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

    public void setTxtResultSendYM(TextBoxFlexibleDate txtResultSendYM) {
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.txtResultSendYM = txtResultSendYM;
    }

}