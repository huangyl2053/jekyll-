package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 13 14:33:05 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKyufuKanrihyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyufuKanrihyoList_Row extends DataRow {

    private Button btnSelect;
    private RString txtTaishoYM;
    private RString txtSakuseiKubun;
    private RString txtHihoNo;
    private RString txtHihokenshaName;
    private RString txtJigyosha;
    private RString txtShinsaYM;

    public dgKyufuKanrihyoList_Row() {
        super();
        this.btnSelect = new Button();
        this.txtTaishoYM = RString.EMPTY;
        this.txtSakuseiKubun = RString.EMPTY;
        this.txtHihoNo = RString.EMPTY;
        this.txtHihokenshaName = RString.EMPTY;
        this.txtJigyosha = RString.EMPTY;
        this.txtShinsaYM = RString.EMPTY;
    }

    public dgKyufuKanrihyoList_Row(Button btnSelect, RString txtTaishoYM, RString txtSakuseiKubun, RString txtHihoNo, RString txtHihokenshaName, RString txtJigyosha, RString txtShinsaYM) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtTaishoYM", txtTaishoYM);
        this.setOriginalData("txtSakuseiKubun", txtSakuseiKubun);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.btnSelect = btnSelect;
        this.txtTaishoYM = txtTaishoYM;
        this.txtSakuseiKubun = txtSakuseiKubun;
        this.txtHihoNo = txtHihoNo;
        this.txtHihokenshaName = txtHihokenshaName;
        this.txtJigyosha = txtJigyosha;
        this.txtShinsaYM = txtShinsaYM;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtTaishoYM() {
        return txtTaishoYM;
    }

    public RString getTxtSakuseiKubun() {
        return txtSakuseiKubun;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtShinsaYM() {
        return txtShinsaYM;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtTaishoYM(RString txtTaishoYM) {
        this.setOriginalData("txtTaishoYM", txtTaishoYM);
        this.txtTaishoYM = txtTaishoYM;
    }

    public void setTxtSakuseiKubun(RString txtSakuseiKubun) {
        this.setOriginalData("txtSakuseiKubun", txtSakuseiKubun);
        this.txtSakuseiKubun = txtSakuseiKubun;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihokenshaName(RString txtHihokenshaName) {
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.txtHihokenshaName = txtHihokenshaName;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtShinsaYM(RString txtShinsaYM) {
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.txtShinsaYM = txtShinsaYM;
    }

}