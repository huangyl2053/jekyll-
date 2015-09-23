package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 23 17:39:10 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
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

    private RString defaultDataName0;
    private RString ki;
    private TextBoxNum defaultDataName1;
    private TextBoxNum defaultDataName2;
    private TextBoxNum defaultDataName3;
    private TextBoxNum defaultDataName4;
    private TextBoxDate noKigen;

    public dgFuchoKanendo_Row() {
        super();
        this.defaultDataName0 = RString.EMPTY;
        this.ki = RString.EMPTY;
        this.defaultDataName1 = new TextBoxNum();
        this.defaultDataName2 = new TextBoxNum();
        this.defaultDataName3 = new TextBoxNum();
        this.defaultDataName4 = new TextBoxNum();
        this.noKigen = new TextBoxDate();
    }

    public dgFuchoKanendo_Row(RString defaultDataName0, RString ki, TextBoxNum defaultDataName1, TextBoxNum defaultDataName2, TextBoxNum defaultDataName3, TextBoxNum defaultDataName4, TextBoxDate noKigen) {
        super();
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.setOriginalData("ki", ki);
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.setOriginalData("noKigen", noKigen);
        this.defaultDataName0 = defaultDataName0;
        this.ki = ki;
        this.defaultDataName1 = defaultDataName1;
        this.defaultDataName2 = defaultDataName2;
        this.defaultDataName3 = defaultDataName3;
        this.defaultDataName4 = defaultDataName4;
        this.noKigen = noKigen;
    }

    public RString getDefaultDataName0() {
        return defaultDataName0;
    }

    public RString getKi() {
        return ki;
    }

    public TextBoxNum getDefaultDataName1() {
        return defaultDataName1;
    }

    public TextBoxNum getDefaultDataName2() {
        return defaultDataName2;
    }

    public TextBoxNum getDefaultDataName3() {
        return defaultDataName3;
    }

    public TextBoxNum getDefaultDataName4() {
        return defaultDataName4;
    }

    public TextBoxDate getNoKigen() {
        return noKigen;
    }

    public void setDefaultDataName0(RString defaultDataName0) {
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.defaultDataName0 = defaultDataName0;
    }

    public void setKi(RString ki) {
        this.setOriginalData("ki", ki);
        this.ki = ki;
    }

    public void setDefaultDataName1(TextBoxNum defaultDataName1) {
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.defaultDataName1 = defaultDataName1;
    }

    public void setDefaultDataName2(TextBoxNum defaultDataName2) {
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.defaultDataName2 = defaultDataName2;
    }

    public void setDefaultDataName3(TextBoxNum defaultDataName3) {
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.defaultDataName3 = defaultDataName3;
    }

    public void setDefaultDataName4(TextBoxNum defaultDataName4) {
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.defaultDataName4 = defaultDataName4;
    }

    public void setNoKigen(TextBoxDate noKigen) {
        this.setOriginalData("noKigen", noKigen);
        this.noKigen = noKigen;
    }

    // </editor-fold>
}