package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 17 15:08:19 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJukyushaIdoRenrakuhyoSearchResult_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJukyushaIdoRenrakuhyoSearchResult_Row extends DataRow {

    private Button btnShowDetail;
    private RString txtResultIdoDate;
    private RString txtResultHihoNo;
    private RString txtResultHihoName;
    private RString txtResultSendYM;

    public dgJukyushaIdoRenrakuhyoSearchResult_Row() {
        super();
        this.btnShowDetail = new Button();
        this.txtResultIdoDate = RString.EMPTY;
        this.txtResultHihoNo = RString.EMPTY;
        this.txtResultHihoName = RString.EMPTY;
        this.txtResultSendYM = RString.EMPTY;
    }

    public dgJukyushaIdoRenrakuhyoSearchResult_Row(Button btnShowDetail, RString txtResultIdoDate, RString txtResultHihoNo, RString txtResultHihoName, RString txtResultSendYM) {
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

    public RString getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public RString getTxtResultHihoNo() {
        return txtResultHihoNo;
    }

    public RString getTxtResultHihoName() {
        return txtResultHihoName;
    }

    public RString getTxtResultSendYM() {
        return txtResultSendYM;
    }

    public void setBtnShowDetail(Button btnShowDetail) {
        this.setOriginalData("btnShowDetail", btnShowDetail);
        this.btnShowDetail = btnShowDetail;
    }

    public void setTxtResultIdoDate(RString txtResultIdoDate) {
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.txtResultIdoDate = txtResultIdoDate;
    }

    public void setTxtResultHihoNo(RString txtResultHihoNo) {
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.txtResultHihoNo = txtResultHihoNo;
    }

    public void setTxtResultHihoName(RString txtResultHihoName) {
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.txtResultHihoName = txtResultHihoName;
    }

    public void setTxtResultSendYM(RString txtResultSendYM) {
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.txtResultSendYM = txtResultSendYM;
    }

}