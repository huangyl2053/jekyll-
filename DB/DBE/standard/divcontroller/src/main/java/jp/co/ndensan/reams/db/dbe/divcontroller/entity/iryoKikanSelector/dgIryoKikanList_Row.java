package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jun 21 11:13:03 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgIryoKikanList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIryoKikanList_Row extends DataRow {

    private RString IryoKikanNo;
    private RString iryoKikanName;

    public dgIryoKikanList_Row() {
        super();
        this.IryoKikanNo = RString.EMPTY;
        this.iryoKikanName = RString.EMPTY;
    }

    public dgIryoKikanList_Row(RString IryoKikanNo, RString iryoKikanName) {
        super();
        this.setOriginalData("IryoKikanNo", IryoKikanNo);
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.IryoKikanNo = IryoKikanNo;
        this.iryoKikanName = iryoKikanName;
    }

    public RString getIryoKikanNo() {
        return IryoKikanNo;
    }

    public RString getIryoKikanName() {
        return iryoKikanName;
    }

    public void setIryoKikanNo(RString IryoKikanNo) {
        this.setOriginalData("IryoKikanNo", IryoKikanNo);
        this.IryoKikanNo = IryoKikanNo;
    }

    public void setIryoKikanName(RString iryoKikanName) {
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.iryoKikanName = iryoKikanName;
    }

}