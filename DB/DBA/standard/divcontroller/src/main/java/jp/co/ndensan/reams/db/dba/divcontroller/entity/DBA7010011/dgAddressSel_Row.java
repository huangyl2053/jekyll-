package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA7010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 18:47:00 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgAddressSel_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgAddressSel_Row extends DataRow {

    private RString defaultDataName0;
    private RString defaultDataName1;
    private RString defaultDataName2;

    public dgAddressSel_Row() {
        super();
        this.defaultDataName0 = RString.EMPTY;
        this.defaultDataName1 = RString.EMPTY;
        this.defaultDataName2 = RString.EMPTY;
    }

    public dgAddressSel_Row(RString defaultDataName0, RString defaultDataName1, RString defaultDataName2) {
        super();
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.defaultDataName0 = defaultDataName0;
        this.defaultDataName1 = defaultDataName1;
        this.defaultDataName2 = defaultDataName2;
    }

    public RString getDefaultDataName0() {
        return defaultDataName0;
    }

    public RString getDefaultDataName1() {
        return defaultDataName1;
    }

    public RString getDefaultDataName2() {
        return defaultDataName2;
    }

    public void setDefaultDataName0(RString defaultDataName0) {
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.defaultDataName0 = defaultDataName0;
    }

    public void setDefaultDataName1(RString defaultDataName1) {
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.defaultDataName1 = defaultDataName1;
    }

    public void setDefaultDataName2(RString defaultDataName2) {
        this.setOriginalData("defaultDataName2", defaultDataName2);
        this.defaultDataName2 = defaultDataName2;
    }

}