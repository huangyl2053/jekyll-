package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 26 16:15:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgIryoKikanList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIryoKikanList_Row extends DataRow {

    private RString iryoKikanNo;
    private RString iryoKikanName;

    public dgIryoKikanList_Row() {
        super();
        this.iryoKikanNo = RString.EMPTY;
        this.iryoKikanName = RString.EMPTY;
    }

    public dgIryoKikanList_Row(RString iryoKikanNo, RString iryoKikanName) {
        super();
        this.setOriginalData("iryoKikanNo", iryoKikanNo);
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.iryoKikanNo = iryoKikanNo;
        this.iryoKikanName = iryoKikanName;
    }

    public RString getIryoKikanNo() {
        return iryoKikanNo;
    }

    public RString getIryoKikanName() {
        return iryoKikanName;
    }

    public void setIryoKikanNo(RString iryoKikanNo) {
        this.setOriginalData("iryoKikanNo", iryoKikanNo);
        this.iryoKikanNo = iryoKikanNo;
    }

    public void setIryoKikanName(RString iryoKikanName) {
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.iryoKikanName = iryoKikanName;
    }

}