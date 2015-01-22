package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 20:33:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * DataGrid3_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class DataGrid3_Row extends DataRow {

    private RString defaultDataName0;
    private RString defaultDataName1;

    public DataGrid3_Row() {
        super();
        this.defaultDataName0 = RString.EMPTY;
        this.defaultDataName1 = RString.EMPTY;
    }

    public DataGrid3_Row(RString defaultDataName0, RString defaultDataName1) {
        super();
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.defaultDataName0 = defaultDataName0;
        this.defaultDataName1 = defaultDataName1;
    }

    public RString getDefaultDataName0() {
        return defaultDataName0;
    }

    public RString getDefaultDataName1() {
        return defaultDataName1;
    }

    public void setDefaultDataName0(RString defaultDataName0) {
        this.setOriginalData("defaultDataName0", defaultDataName0);
        this.defaultDataName0 = defaultDataName0;
    }

    public void setDefaultDataName1(RString defaultDataName1) {
        this.setOriginalData("defaultDataName1", defaultDataName1);
        this.defaultDataName1 = defaultDataName1;
    }

}