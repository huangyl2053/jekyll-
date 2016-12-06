package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TainoInfo.TainoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 05 22:54:25 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTainoJokyo2_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTainoJokyo2_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">

    private RString ki;
    private RString tsuki;
    private TextBoxNum txtHokenryo;
    private TextBoxDate txtNokigen;
    private TextBoxNum txtTaino;
    private TextBoxFlexibleDate txtJikoKisanYMD;
    private RString jikoKisanbiKubun;

    public dgTainoJokyo2_Row() {
        super();
        this.ki = RString.EMPTY;
        this.tsuki = RString.EMPTY;
        this.txtHokenryo = new TextBoxNum();
        this.txtNokigen = new TextBoxDate();
        this.txtTaino = new TextBoxNum();
        this.txtJikoKisanYMD = new TextBoxFlexibleDate();
        this.jikoKisanbiKubun = RString.EMPTY;
        this.setOriginalData("ki", ki);
        this.setOriginalData("tsuki", tsuki);
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.setOriginalData("txtNokigen", txtNokigen);
        this.setOriginalData("txtTaino", txtTaino);
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.setOriginalData("jikoKisanbiKubun", jikoKisanbiKubun);
    }

    public dgTainoJokyo2_Row(RString ki, RString tsuki, TextBoxNum txtHokenryo, TextBoxDate txtNokigen, TextBoxNum txtTaino, TextBoxFlexibleDate txtJikoKisanYMD, RString jikoKisanbiKubun) {
        super();
        this.setOriginalData("ki", ki);
        this.setOriginalData("tsuki", tsuki);
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.setOriginalData("txtNokigen", txtNokigen);
        this.setOriginalData("txtTaino", txtTaino);
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.setOriginalData("jikoKisanbiKubun", jikoKisanbiKubun);
        this.ki = ki;
        this.tsuki = tsuki;
        this.txtHokenryo = txtHokenryo;
        this.txtNokigen = txtNokigen;
        this.txtTaino = txtTaino;
        this.txtJikoKisanYMD = txtJikoKisanYMD;
        this.jikoKisanbiKubun = jikoKisanbiKubun;
    }

    public RString getKi() {
        return ki;
    }

    public RString getTsuki() {
        return tsuki;
    }

    public TextBoxNum getTxtHokenryo() {
        return txtHokenryo;
    }

    public TextBoxDate getTxtNokigen() {
        return txtNokigen;
    }

    public TextBoxNum getTxtTaino() {
        return txtTaino;
    }

    public TextBoxFlexibleDate getTxtJikoKisanYMD() {
        return txtJikoKisanYMD;
    }

    public RString getJikoKisanbiKubun() {
        return jikoKisanbiKubun;
    }

    public void setKi(RString ki) {
        this.setOriginalData("ki", ki);
        this.ki = ki;
    }

    public void setTsuki(RString tsuki) {
        this.setOriginalData("tsuki", tsuki);
        this.tsuki = tsuki;
    }

    public void setTxtHokenryo(TextBoxNum txtHokenryo) {
        this.setOriginalData("txtHokenryo", txtHokenryo);
        this.txtHokenryo = txtHokenryo;
    }

    public void setTxtNokigen(TextBoxDate txtNokigen) {
        this.setOriginalData("txtNokigen", txtNokigen);
        this.txtNokigen = txtNokigen;
    }

    public void setTxtTaino(TextBoxNum txtTaino) {
        this.setOriginalData("txtTaino", txtTaino);
        this.txtTaino = txtTaino;
    }

    public void setTxtJikoKisanYMD(TextBoxFlexibleDate txtJikoKisanYMD) {
        this.setOriginalData("txtJikoKisanYMD", txtJikoKisanYMD);
        this.txtJikoKisanYMD = txtJikoKisanYMD;
    }

    public void setJikoKisanbiKubun(RString jikoKisanbiKubun) {
        this.setOriginalData("jikoKisanbiKubun", jikoKisanbiKubun);
        this.jikoKisanbiKubun = jikoKisanbiKubun;
    }

    // </editor-fold>
}
