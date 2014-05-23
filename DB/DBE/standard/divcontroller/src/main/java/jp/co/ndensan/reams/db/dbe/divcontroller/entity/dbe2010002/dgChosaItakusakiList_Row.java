package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri May 23 14:46:25 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaItakusakiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaItakusakiList_Row extends DataRow {

    private RString chosaItakusakiCode;
    private RString chosaItakusakiName;
    private RString defaultDataName3;
    private RString defaultDataName2;
    private RString defaultDataName4;

    public dgChosaItakusakiList_Row() {
        super();
    }

    public dgChosaItakusakiList_Row(RString chosaItakusakiCode, RString chosaItakusakiName, RString defaultDataName3, RString defaultDataName2, RString defaultDataName4) {
        super();
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.chosaItakusakiName = chosaItakusakiName;
        this.defaultDataName3 = defaultDataName3;
        this.defaultDataName2 = defaultDataName2;
        this.defaultDataName4 = defaultDataName4;
    }

    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    public RString getDefaultDataName3() {
        return defaultDataName3;
    }

    public RString getDefaultDataName2() {
        return defaultDataName2;
    }

    public RString getDefaultDataName4() {
        return defaultDataName4;
    }

    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiName = chosaItakusakiName;
    }

    public void setDefaultDataName3(RString defaultDataName3) {
        this.setOriginalData("defaultDataName3", defaultDataName3);
        this.defaultDataName3 = defaultDataName3;
    }

    public void setDefaultDataName2(RString defaultDataName2) {
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.defaultDataName2 = defaultDataName2;
    }

    public void setDefaultDataName4(RString defaultDataName4) {
        this.setOriginalData("defaultDataName4", defaultDataName4);
        this.defaultDataName4 = defaultDataName4;
    }

}