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
 * dgIshiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIshiList_Row extends DataRow {

    private RString IshiNo;
    private RString ishiName;

    public dgIshiList_Row() {
        super();
        this.IshiNo = RString.EMPTY;
        this.ishiName = RString.EMPTY;
    }

    public dgIshiList_Row(RString IshiNo, RString ishiName) {
        super();
        this.setOriginalData("IshiNo", IshiNo);
        this.setOriginalData("ishiName", ishiName);
        this.IshiNo = IshiNo;
        this.ishiName = ishiName;
    }

    public RString getIshiNo() {
        return IshiNo;
    }

    public RString getIshiName() {
        return ishiName;
    }

    public void setIshiNo(RString IshiNo) {
        this.setOriginalData("IshiNo", IshiNo);
        this.IshiNo = IshiNo;
    }

    public void setIshiName(RString ishiName) {
        this.setOriginalData("ishiName", ishiName);
        this.ishiName = ishiName;
    }

}