package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TainoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Apr 01 20:34:19 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTainoJokyo2_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTainoJokyo2_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString txtKi;
    private RString txtHokenryo;
    private RString txtNokigen;
    private RString txtTaino;
    private TextBoxFlexibleDate txtJikoKisanYMD;
    private RString txtJikoKisanbiKbn;

    public dgTainoJokyo2_Row() {
        super();
        this.txtKi = RString.EMPTY;
        this.txtHokenryo = RString.EMPTY;
        this.txtNokigen = RString.EMPTY;
        this.txtTaino = RString.EMPTY;
        this.txtJikoKisanYMD = new TextBoxFlexibleDate();
        this.txtJikoKisanbiKbn = RString.EMPTY;
        this.setOriginalData("txtKi", txtKi);
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.setOriginalData("txtNokigen", txtNokigen);
        this.setOriginalData("txtTaino", txtTaino);
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.setOriginalData("txtJikoKisanbiKbn", txtJikoKisanbiKbn);
    }

    public dgTainoJokyo2_Row(RString txtKi, RString txtHokenryo, RString txtNokigen, RString txtTaino, TextBoxFlexibleDate txtJikoKisanYMD, RString txtJikoKisanbiKbn) {
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

    public TextBoxFlexibleDate getTxtJikoKisanYMD() {
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

    public void setTxtJikoKisanYMD(TextBoxFlexibleDate txtJikoKisanYMD) {
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.txtJikoKisanYMD = txtJikoKisanYMD;
    }

    public void setTxtJikoKisanbiKbn(RString txtJikoKisanbiKbn) {
        this.setOriginalData("txtJikoKisanbiKbn", txtJikoKisanbiKbn);
        this.txtJikoKisanbiKbn = txtJikoKisanbiKbn;
    }

    // </editor-fold>
}
