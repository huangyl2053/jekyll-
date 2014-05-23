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
 * dgChosainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainList_Row extends DataRow {

    private RString 調査員コード;
    private RString 調査員氏名;
    private RString 割付済み人数;
    private RString 地区;

    public dgChosainList_Row() {
        super();
    }

    public dgChosainList_Row(RString 調査員コード, RString 調査員氏名, RString 割付済み人数, RString 地区) {
        super();
        this.setOriginalData("調査員コード", 調査員コード);
        this.setOriginalData("調査員氏名", 調査員氏名);
        this.setOriginalData("割付済み人数", 割付済み人数);
        this.setOriginalData("地区", 地区);
        this.調査員コード = 調査員コード;
        this.調査員氏名 = 調査員氏名;
        this.割付済み人数 = 割付済み人数;
        this.地区 = 地区;
    }

    public RString get調査員コード() {
        return 調査員コード;
    }

    public RString get調査員氏名() {
        return 調査員氏名;
    }

    public RString get割付済み人数() {
        return 割付済み人数;
    }

    public RString get地区() {
        return 地区;
    }

    public void set調査員コード(RString 調査員コード) {
        this.setOriginalData("調査員コード", 調査員コード);
        this.調査員コード = 調査員コード;
    }

    public void set調査員氏名(RString 調査員氏名) {
        this.setOriginalData("調査員氏名", 調査員氏名);
        this.調査員氏名 = 調査員氏名;
    }

    public void set割付済み人数(RString 割付済み人数) {
        this.setOriginalData("割付済み人数", 割付済み人数);
        this.割付済み人数 = 割付済み人数;
    }

    public void set地区(RString 地区) {
        this.setOriginalData("地区", 地区);
        this.地区 = 地区;
    }

}