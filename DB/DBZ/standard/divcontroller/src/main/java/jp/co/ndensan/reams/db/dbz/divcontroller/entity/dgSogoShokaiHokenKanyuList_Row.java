package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:40:23 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSogoShokaiHokenKanyuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiHokenKanyuList_Row extends DataRow {

    private RString txtHokenShubetsu;
    private RString txtHokenshaNo;
    private RString txtHokenshaName;
    private RString txtKigoNo;

    public dgSogoShokaiHokenKanyuList_Row() {
        super();
        this.txtHokenShubetsu = RString.EMPTY;
        this.txtHokenshaNo = RString.EMPTY;
        this.txtHokenshaName = RString.EMPTY;
        this.txtKigoNo = RString.EMPTY;
    }

    public dgSogoShokaiHokenKanyuList_Row(RString txtHokenShubetsu, RString txtHokenshaNo, RString txtHokenshaName, RString txtKigoNo) {
        super();
        this.setOriginalData("txtHokenShubetsu", txtHokenShubetsu);
        this.setOriginalData("txtHokenshaNo", txtHokenshaNo);
        this.setOriginalData("txtHokenshaName", txtHokenshaName);
        this.setOriginalData("txtKigoNo", txtKigoNo);
        this.txtHokenShubetsu = txtHokenShubetsu;
        this.txtHokenshaNo = txtHokenshaNo;
        this.txtHokenshaName = txtHokenshaName;
        this.txtKigoNo = txtKigoNo;
    }

    public RString getTxtHokenShubetsu() {
        return txtHokenShubetsu;
    }

    public RString getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    public RString getTxtHokenshaName() {
        return txtHokenshaName;
    }

    public RString getTxtKigoNo() {
        return txtKigoNo;
    }

    public void setTxtHokenShubetsu(RString txtHokenShubetsu) {
        this.setOriginalData("txtHokenShubetsu", txtHokenShubetsu);
        this.txtHokenShubetsu = txtHokenShubetsu;
    }

    public void setTxtHokenshaNo(RString txtHokenshaNo) {
        this.setOriginalData("txtHokenshaNo", txtHokenshaNo);
        this.txtHokenshaNo = txtHokenshaNo;
    }

    public void setTxtHokenshaName(RString txtHokenshaName) {
        this.setOriginalData("txtHokenshaName", txtHokenshaName);
        this.txtHokenshaName = txtHokenshaName;
    }

    public void setTxtKigoNo(RString txtKigoNo) {
        this.setOriginalData("txtKigoNo", txtKigoNo);
        this.txtKigoNo = txtKigoNo;
    }

}