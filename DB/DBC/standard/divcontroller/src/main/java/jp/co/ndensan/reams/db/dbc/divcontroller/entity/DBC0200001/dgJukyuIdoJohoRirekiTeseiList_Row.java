package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 13:55:00 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJukyuIdoJohoRirekiTeseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJukyuIdoJohoRirekiTeseiList_Row extends DataRow {

    private RString txtHihoNo;
    private RString txtHihokenshaName;
    private RString txtIdoYMD;
    private RString txtKomoku;

    public dgJukyuIdoJohoRirekiTeseiList_Row() {
        super();
        this.txtHihoNo = RString.EMPTY;
        this.txtHihokenshaName = RString.EMPTY;
        this.txtIdoYMD = RString.EMPTY;
        this.txtKomoku = RString.EMPTY;
    }

    public dgJukyuIdoJohoRirekiTeseiList_Row(RString txtHihoNo, RString txtHihokenshaName, RString txtIdoYMD, RString txtKomoku) {
        super();
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtHihoNo = txtHihoNo;
        this.txtHihokenshaName = txtHihokenshaName;
        this.txtIdoYMD = txtIdoYMD;
        this.txtKomoku = txtKomoku;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    public RString getTxtIdoYMD() {
        return txtIdoYMD;
    }

    public RString getTxtKomoku() {
        return txtKomoku;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtHihokenshaName(RString txtHihokenshaName) {
        this.setOriginalData("txtHihokenshaName", txtHihokenshaName);
        this.txtHihokenshaName = txtHihokenshaName;
    }

    public void setTxtIdoYMD(RString txtIdoYMD) {
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.txtIdoYMD = txtIdoYMD;
    }

    public void setTxtKomoku(RString txtKomoku) {
        this.setOriginalData("txtKomoku", txtKomoku);
        this.txtKomoku = txtKomoku;
    }

}