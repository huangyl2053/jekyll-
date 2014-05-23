package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 15 16:28:05 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTekiyoJogaiShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTekiyoJogaiShisetsu_Row extends DataRow {

    private Button btnSelect;
    private RString defaultDataName1;
    private RString defaultDataName2;
    private RString defaultDataName3;
    private RString defaultDataName4;

    public dgTekiyoJogaiShisetsu_Row() {
        super();
    }

    public dgTekiyoJogaiShisetsu_Row(Button btnSelect, RString defaultDataName1, RString defaultDataName2, RString defaultDataName3, RString defaultDataName4) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.btnSelect = btnSelect;
        this.defaultDataName1 = defaultDataName1;
        this.defaultDataName2 = defaultDataName2;
        this.defaultDataName3 = defaultDataName3;
        this.defaultDataName4 = defaultDataName4;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getDefaultDataName1() {
        return defaultDataName1;
    }

    public RString getDefaultDataName2() {
        return defaultDataName2;
    }

    public RString getDefaultDataName3() {
        return defaultDataName3;
    }

    public RString getDefaultDataName4() {
        return defaultDataName4;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setDefaultDataName1(RString defaultDataName1) {
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.defaultDataName1 = defaultDataName1;
    }

    public void setDefaultDataName2(RString defaultDataName2) {
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.defaultDataName2 = defaultDataName2;
    }

    public void setDefaultDataName3(RString defaultDataName3) {
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.defaultDataName3 = defaultDataName3;
    }

    public void setDefaultDataName4(RString defaultDataName4) {
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.defaultDataName4 = defaultDataName4;
    }

}