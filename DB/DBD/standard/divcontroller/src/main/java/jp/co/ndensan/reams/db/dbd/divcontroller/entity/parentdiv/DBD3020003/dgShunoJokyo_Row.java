package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 10 13:54:12 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShunoJokyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShunoJokyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">

    private RString jotai;
    private TextBox choteiNendo;
    private TextBoxNum choteiGaku;
    private TextBoxNum shunyuGaku;
    private TextBoxNum jikoToraiMinogaku;
    private RString ki;
    private RString nokigen;
    private RString jikoKisanYMD;
    private RString jikoKisanYMDKubun;
    private RString seirekiChoteiNendo;

    public dgShunoJokyo_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.choteiNendo = new TextBox();
        this.choteiGaku = new TextBoxNum();
        this.shunyuGaku = new TextBoxNum();
        this.jikoToraiMinogaku = new TextBoxNum();
        this.ki = RString.EMPTY;
        this.nokigen = RString.EMPTY;
        this.jikoKisanYMD = RString.EMPTY;
        this.jikoKisanYMDKubun = RString.EMPTY;
        this.seirekiChoteiNendo = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("choteiNendo", choteiNendo);
        this.setOriginalData("choteiGaku", choteiGaku);
        this.setOriginalData("shunyuGaku", shunyuGaku);
        this.setOriginalData("jikoToraiMinogaku", jikoToraiMinogaku);
        this.setOriginalData("ki", ki);
        this.setOriginalData("nokigen", nokigen);
        this.setOriginalData("jikoKisanYMD", jikoKisanYMD);
        this.setOriginalData("jikoKisanYMDKubun", jikoKisanYMDKubun);
        this.setOriginalData("seirekiChoteiNendo", seirekiChoteiNendo);
    }

    public dgShunoJokyo_Row(RString jotai, TextBox choteiNendo, TextBoxNum choteiGaku, TextBoxNum shunyuGaku, TextBoxNum jikoToraiMinogaku, RString ki, RString nokigen, RString jikoKisanYMD, RString jikoKisanYMDKubun, RString seirekiChoteiNendo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("choteiNendo", choteiNendo);
        this.setOriginalData("choteiGaku", choteiGaku);
        this.setOriginalData("shunyuGaku", shunyuGaku);
        this.setOriginalData("jikoToraiMinogaku", jikoToraiMinogaku);
        this.setOriginalData("ki", ki);
        this.setOriginalData("nokigen", nokigen);
        this.setOriginalData("jikoKisanYMD", jikoKisanYMD);
        this.setOriginalData("jikoKisanYMDKubun", jikoKisanYMDKubun);
        this.setOriginalData("seirekiChoteiNendo", seirekiChoteiNendo);
        this.jotai = jotai;
        this.choteiNendo = choteiNendo;
        this.choteiGaku = choteiGaku;
        this.shunyuGaku = shunyuGaku;
        this.jikoToraiMinogaku = jikoToraiMinogaku;
        this.ki = ki;
        this.nokigen = nokigen;
        this.jikoKisanYMD = jikoKisanYMD;
        this.jikoKisanYMDKubun = jikoKisanYMDKubun;
        this.seirekiChoteiNendo = seirekiChoteiNendo;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBox getChoteiNendo() {
        return choteiNendo;
    }

    public TextBoxNum getChoteiGaku() {
        return choteiGaku;
    }

    public TextBoxNum getShunyuGaku() {
        return shunyuGaku;
    }

    public TextBoxNum getJikoToraiMinogaku() {
        return jikoToraiMinogaku;
    }

    public RString getKi() {
        return ki;
    }

    public RString getNokigen() {
        return nokigen;
    }

    public RString getJikoKisanYMD() {
        return jikoKisanYMD;
    }

    public RString getJikoKisanYMDKubun() {
        return jikoKisanYMDKubun;
    }

    public RString getSeirekiChoteiNendo() {
        return seirekiChoteiNendo;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setChoteiNendo(TextBox choteiNendo) {
        this.setOriginalData("choteiNendo", choteiNendo);
        this.choteiNendo = choteiNendo;
    }

    public void setChoteiGaku(TextBoxNum choteiGaku) {
        this.setOriginalData("choteiGaku", choteiGaku);
        this.choteiGaku = choteiGaku;
    }

    public void setShunyuGaku(TextBoxNum shunyuGaku) {
        this.setOriginalData("shunyuGaku", shunyuGaku);
        this.shunyuGaku = shunyuGaku;
    }

    public void setJikoToraiMinogaku(TextBoxNum jikoToraiMinogaku) {
        this.setOriginalData("jikoToraiMinogaku", jikoToraiMinogaku);
        this.jikoToraiMinogaku = jikoToraiMinogaku;
    }

    public void setKi(RString ki) {
        this.setOriginalData("ki", ki);
        this.ki = ki;
    }

    public void setNokigen(RString nokigen) {
        this.setOriginalData("nokigen", nokigen);
        this.nokigen = nokigen;
    }

    public void setJikoKisanYMD(RString jikoKisanYMD) {
        this.setOriginalData("jikoKisanYMD", jikoKisanYMD);
        this.jikoKisanYMD = jikoKisanYMD;
    }

    public void setJikoKisanYMDKubun(RString jikoKisanYMDKubun) {
        this.setOriginalData("jikoKisanYMDKubun", jikoKisanYMDKubun);
        this.jikoKisanYMDKubun = jikoKisanYMDKubun;
    }

    public void setSeirekiChoteiNendo(RString seirekiChoteiNendo) {
        this.setOriginalData("seirekiChoteiNendo", seirekiChoteiNendo);
        this.seirekiChoteiNendo = seirekiChoteiNendo;
    }

    // </editor-fold>
}
