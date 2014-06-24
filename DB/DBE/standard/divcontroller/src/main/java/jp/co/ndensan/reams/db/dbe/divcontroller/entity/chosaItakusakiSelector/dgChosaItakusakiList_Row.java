package jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 24 11:06:10 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaItakusakiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaItakusakiList_Row extends DataRow {

    private RString chosaItakusakiNo;
    private RString chosaItakusakiName;

    public dgChosaItakusakiList_Row() {
        super();
        this.chosaItakusakiNo = RString.EMPTY;
        this.chosaItakusakiName = RString.EMPTY;
    }

    public dgChosaItakusakiList_Row(RString chosaItakusakiNo, RString chosaItakusakiName) {
        super();
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
    }

    public RString getChosaItakusakiNo() {
        return chosaItakusakiNo;
    }

    public RString getChosaItakusakiName() {
        return chosaItakusakiName;
    }

    public void setChosaItakusakiNo(RString chosaItakusakiNo) {
        this.setOriginalData("chosaItakusakiNo", chosaItakusakiNo);
        this.chosaItakusakiNo = chosaItakusakiNo;
    }

    public void setChosaItakusakiName(RString chosaItakusakiName) {
        this.setOriginalData("chosaItakusakiName", chosaItakusakiName);
        this.chosaItakusakiName = chosaItakusakiName;
    }

}