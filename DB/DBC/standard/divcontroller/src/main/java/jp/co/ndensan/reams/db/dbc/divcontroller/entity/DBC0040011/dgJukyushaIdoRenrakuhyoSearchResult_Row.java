package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 18 18:44:50 JST 2014 
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
    private RString txtRenrakuhyoIdoKubun;
    private RString txtDdlIdoJiyu;
    private RString txtResultHihoNo;
    private RString txtResultHihoName;
    private RString txtResultSendYM;
    private RString txtDeleteFlg;

    public dgJukyushaIdoRenrakuhyoSearchResult_Row() {
        super();
        this.btnShowDetail = new Button();
        this.txtResultIdoDate = RString.EMPTY;
        this.txtRenrakuhyoIdoKubun = RString.EMPTY;
        this.txtDdlIdoJiyu = RString.EMPTY;
        this.txtResultHihoNo = RString.EMPTY;
        this.txtResultHihoName = RString.EMPTY;
        this.txtResultSendYM = RString.EMPTY;
        this.txtDeleteFlg = RString.EMPTY;
    }

    public dgJukyushaIdoRenrakuhyoSearchResult_Row(Button btnShowDetail, RString txtResultIdoDate, RString txtRenrakuhyoIdoKubun, RString txtDdlIdoJiyu, RString txtResultHihoNo, RString txtResultHihoName, RString txtResultSendYM, RString txtDeleteFlg) {
        super();
        this.setOriginalData("btnShowDetail", btnShowDetail);
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtRenrakuhyoIdoKubun", txtRenrakuhyoIdoKubun);
        this.setOriginalData("txtDdlIdoJiyu", txtDdlIdoJiyu);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.setOriginalData("txtResultSendYM", txtResultSendYM);
        this.setOriginalData("txtDeleteFlg", txtDeleteFlg);
        this.btnShowDetail = btnShowDetail;
        this.txtResultIdoDate = txtResultIdoDate;
        this.txtRenrakuhyoIdoKubun = txtRenrakuhyoIdoKubun;
        this.txtDdlIdoJiyu = txtDdlIdoJiyu;
        this.txtResultHihoNo = txtResultHihoNo;
        this.txtResultHihoName = txtResultHihoName;
        this.txtResultSendYM = txtResultSendYM;
        this.txtDeleteFlg = txtDeleteFlg;
    }

    public Button getBtnShowDetail() {
        return btnShowDetail;
    }

    public RString getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public RString getTxtRenrakuhyoIdoKubun() {
        return txtRenrakuhyoIdoKubun;
    }

    public RString getTxtDdlIdoJiyu() {
        return txtDdlIdoJiyu;
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

    public RString getTxtDeleteFlg() {
        return txtDeleteFlg;
    }

    public void setBtnShowDetail(Button btnShowDetail) {
        this.setOriginalData("btnShowDetail", btnShowDetail);
        this.btnShowDetail = btnShowDetail;
    }

    public void setTxtResultIdoDate(RString txtResultIdoDate) {
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.txtResultIdoDate = txtResultIdoDate;
    }

    public void setTxtRenrakuhyoIdoKubun(RString txtRenrakuhyoIdoKubun) {
        this.setOriginalData("txtRenrakuhyoIdoKubun", txtRenrakuhyoIdoKubun);
        this.txtRenrakuhyoIdoKubun = txtRenrakuhyoIdoKubun;
    }

    public void setTxtDdlIdoJiyu(RString txtDdlIdoJiyu) {
        this.setOriginalData("txtDdlIdoJiyu", txtDdlIdoJiyu);
        this.txtDdlIdoJiyu = txtDdlIdoJiyu;
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

    public void setTxtDeleteFlg(RString txtDeleteFlg) {
        this.setOriginalData("txtDeleteFlg", txtDeleteFlg);
        this.txtDeleteFlg = txtDeleteFlg;
    }

}