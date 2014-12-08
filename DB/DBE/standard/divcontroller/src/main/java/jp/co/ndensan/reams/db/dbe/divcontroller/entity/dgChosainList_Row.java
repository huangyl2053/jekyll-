package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 15:23:28 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainList_Row extends DataRow {

    private RString chosainNo;
    private RString chosainName;

    public dgChosainList_Row() {
        super();
        this.chosainNo = RString.EMPTY;
        this.chosainName = RString.EMPTY;
    }

    public dgChosainList_Row(RString chosainNo, RString chosainName) {
        super();
        this.setOriginalData("chosainNo", chosainNo);
        this.setOriginalData("chosainName", chosainName);
        this.chosainNo = chosainNo;
        this.chosainName = chosainName;
    }

    public RString getChosainNo() {
        return chosainNo;
    }

    public RString getChosainName() {
        return chosainName;
    }

    public void setChosainNo(RString chosainNo) {
        this.setOriginalData("chosainNo", chosainNo);
        this.chosainNo = chosainNo;
    }

    public void setChosainName(RString chosainName) {
        this.setOriginalData("chosainName", chosainName);
        this.chosainName = chosainName;
    }

}