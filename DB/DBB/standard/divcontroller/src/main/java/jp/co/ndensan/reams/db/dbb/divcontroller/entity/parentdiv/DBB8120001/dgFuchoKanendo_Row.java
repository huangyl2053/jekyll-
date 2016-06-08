package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 24 14:32:51 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgFuchoKanendo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFuchoKanendo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">

    private TextBoxFlexibleDate choteiNendo;
    private TextBoxFlexibleDate fukaNendo;
    private RString ki;
    private TextBoxNum koseiMae;
    private TextBoxNum koseiGo;
    private TextBoxNum zogen;
    private TextBoxNum nofuGaku;
    private TextBoxDate noKigen;

    public dgFuchoKanendo_Row() {
        super();
        this.choteiNendo = new TextBoxFlexibleDate();
        this.fukaNendo = new TextBoxFlexibleDate();
        this.ki = RString.EMPTY;
        this.koseiMae = new TextBoxNum();
        this.koseiGo = new TextBoxNum();
        this.zogen = new TextBoxNum();
        this.nofuGaku = new TextBoxNum();
        this.noKigen = new TextBoxDate();
    }

    public dgFuchoKanendo_Row(TextBoxFlexibleDate choteiNendo, TextBoxFlexibleDate fukaNendo, RString ki, TextBoxNum koseiMae, TextBoxNum koseiGo, TextBoxNum zogen, TextBoxNum nofuGaku, TextBoxDate noKigen) {
        super();
        this.setOriginalData("choteiNendo", choteiNendo);
        this.setOriginalData("fukaNendo", fukaNendo);
        this.setOriginalData("ki", ki);
        this.setOriginalData("koseiMae", koseiMae);
        this.setOriginalData("koseiGo", koseiGo);
        this.setOriginalData("zogen", zogen);
        this.setOriginalData("nofuGaku", nofuGaku);
        this.setOriginalData("noKigen", noKigen);
        this.choteiNendo = choteiNendo;
        this.fukaNendo = fukaNendo;
        this.ki = ki;
        this.koseiMae = koseiMae;
        this.koseiGo = koseiGo;
        this.zogen = zogen;
        this.nofuGaku = nofuGaku;
        this.noKigen = noKigen;
    }

    public TextBoxFlexibleDate getChoteiNendo() {
        return choteiNendo;
    }

    public TextBoxFlexibleDate getFukaNendo() {
        return fukaNendo;
    }

    public RString getKi() {
        return ki;
    }

    public TextBoxNum getKoseiMae() {
        return koseiMae;
    }

    public TextBoxNum getKoseiGo() {
        return koseiGo;
    }

    public TextBoxNum getZogen() {
        return zogen;
    }

    public TextBoxNum getNofuGaku() {
        return nofuGaku;
    }

    public TextBoxDate getNoKigen() {
        return noKigen;
    }

    public void setChoteiNendo(TextBoxFlexibleDate choteiNendo) {
        this.setOriginalData("choteiNendo", choteiNendo);
        this.choteiNendo = choteiNendo;
    }

    public void setFukaNendo(TextBoxFlexibleDate fukaNendo) {
        this.setOriginalData("fukaNendo", fukaNendo);
        this.fukaNendo = fukaNendo;
    }

    public void setKi(RString ki) {
        this.setOriginalData("ki", ki);
        this.ki = ki;
    }

    public void setKoseiMae(TextBoxNum koseiMae) {
        this.setOriginalData("koseiMae", koseiMae);
        this.koseiMae = koseiMae;
    }

    public void setKoseiGo(TextBoxNum koseiGo) {
        this.setOriginalData("koseiGo", koseiGo);
        this.koseiGo = koseiGo;
    }

    public void setZogen(TextBoxNum zogen) {
        this.setOriginalData("zogen", zogen);
        this.zogen = zogen;
    }

    public void setNofuGaku(TextBoxNum nofuGaku) {
        this.setOriginalData("nofuGaku", nofuGaku);
        this.nofuGaku = nofuGaku;
    }

    public void setNoKigen(TextBoxDate noKigen) {
        this.setOriginalData("noKigen", noKigen);
        this.noKigen = noKigen;
    }

    // </editor-fold>
}