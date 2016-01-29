package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jan 29 17:08:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHoseitaishoYoshiki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHoseitaishoYoshiki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private TextBox txtShichosonCode;
    private TextBoxDate txtHokokuY;
    private TextBoxDate txtShukeiY;
    private RString txtToukeiTaishoKubun;

    public dgHoseitaishoYoshiki_Row() {
        super();
        this.txtShichosonCode = new TextBox();
        this.txtHokokuY = new TextBoxDate();
        this.txtShukeiY = new TextBoxDate();
        this.txtToukeiTaishoKubun = RString.EMPTY;
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtHokokuY", txtHokokuY);
        this.setOriginalData("txtShukeiY", txtShukeiY);
        this.setOriginalData("txtToukeiTaishoKubun", txtToukeiTaishoKubun);
    }

    public dgHoseitaishoYoshiki_Row(TextBox txtShichosonCode, TextBoxDate txtHokokuY, TextBoxDate txtShukeiY, RString txtToukeiTaishoKubun) {
        super();
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtHokokuY", txtHokokuY);
        this.setOriginalData("txtShukeiY", txtShukeiY);
        this.setOriginalData("txtToukeiTaishoKubun", txtToukeiTaishoKubun);
        this.txtShichosonCode = txtShichosonCode;
        this.txtHokokuY = txtHokokuY;
        this.txtShukeiY = txtShukeiY;
        this.txtToukeiTaishoKubun = txtToukeiTaishoKubun;
    }

    public TextBox getTxtShichosonCode() {
        return txtShichosonCode;
    }

    public TextBoxDate getTxtHokokuY() {
        return txtHokokuY;
    }

    public TextBoxDate getTxtShukeiY() {
        return txtShukeiY;
    }

    public RString getTxtToukeiTaishoKubun() {
        return txtToukeiTaishoKubun;
    }

    public void setTxtShichosonCode(TextBox txtShichosonCode) {
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.txtShichosonCode = txtShichosonCode;
    }

    public void setTxtHokokuY(TextBoxDate txtHokokuY) {
        this.setOriginalData("txtHokokuY", txtHokokuY);
        this.txtHokokuY = txtHokokuY;
    }

    public void setTxtShukeiY(TextBoxDate txtShukeiY) {
        this.setOriginalData("txtShukeiY", txtShukeiY);
        this.txtShukeiY = txtShukeiY;
    }

    public void setTxtToukeiTaishoKubun(RString txtToukeiTaishoKubun) {
        this.setOriginalData("txtToukeiTaishoKubun", txtToukeiTaishoKubun);
        this.txtToukeiTaishoKubun = txtToukeiTaishoKubun;
    }

    // </editor-fold>
}
