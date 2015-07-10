package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:21:30 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTainoJokyo3_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTainoJokyo3_Row extends DataRow {

    private RString txtKi;
    private RString txtHokenryo;
    private RString txtNokigen;
    private RString txtTaino;
    private RString txtJikoKisanYMD;
    private RString txtJikoKisanbiKbn;

    public dgTainoJokyo3_Row() {
        super();
        this.txtKi = RString.EMPTY;
        this.txtHokenryo = RString.EMPTY;
        this.txtNokigen = RString.EMPTY;
        this.txtTaino = RString.EMPTY;
        this.txtJikoKisanYMD = RString.EMPTY;
        this.txtJikoKisanbiKbn = RString.EMPTY;
    }

    public dgTainoJokyo3_Row(RString txtKi, RString txtHokenryo, RString txtNokigen, RString txtTaino, RString txtJikoKisanYMD, RString txtJikoKisanbiKbn) {
        super();
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.setOriginalData("txtNokigen", txtNokigen);
        this.setOriginalData("txtTaino", txtTaino);
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.setOriginalData("txtJikoKisanbiKbn", txtJikoKisanbiKbn);
        this.txtKi = txtKi;
        this.txtHokenryo = txtHokenryo;
        this.txtNokigen = txtNokigen;
        this.txtTaino = txtTaino;
        this.txtJikoKisanYMD = txtJikoKisanYMD;
        this.txtJikoKisanbiKbn = txtJikoKisanbiKbn;
    }

    public RString getTxtKi() {
        return txtKi;
    }

    public RString getTxtHokenryo() {
        return txtHokenryo;
    }

    public RString getTxtNokigen() {
        return txtNokigen;
    }

    public RString getTxtTaino() {
        return txtTaino;
    }

    public RString getTxtJikoKisanYMD() {
        return txtJikoKisanYMD;
    }

    public RString getTxtJikoKisanbiKbn() {
        return txtJikoKisanbiKbn;
    }

    public void setTxtKi(RString txtKi) {
        this.setOriginalData("txtKi", txtKi);
        this.txtKi = txtKi;
    }

    public void setTxtHokenryo(RString txtHokenryo) {
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.txtHokenryo = txtHokenryo;
    }

    public void setTxtNokigen(RString txtNokigen) {
        this.setOriginalData("txtNokigen", txtNokigen);
        this.txtNokigen = txtNokigen;
    }

    public void setTxtTaino(RString txtTaino) {
        this.setOriginalData("txtTaino", txtTaino);
        this.txtTaino = txtTaino;
    }

    public void setTxtJikoKisanYMD(RString txtJikoKisanYMD) {
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.txtJikoKisanYMD = txtJikoKisanYMD;
    }

    public void setTxtJikoKisanbiKbn(RString txtJikoKisanbiKbn) {
        this.setOriginalData("txtJikoKisanbiKbn", txtJikoKisanbiKbn);
        this.txtJikoKisanbiKbn = txtJikoKisanbiKbn;
    }

}