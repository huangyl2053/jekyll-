package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 30 14:42:38 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainIchiran_Row extends DataRow {

    private RString 介護調査員番号;
    private RString 調査員氏名;
    private RString 割付済人数;
    private RString 地区コード;
    private RString 地区;

    public dgChosainIchiran_Row() {
        super();
    }

    public dgChosainIchiran_Row(RString 介護調査員番号, RString 調査員氏名, RString 割付済人数, RString 地区コード, RString 地区) {
        super();
        this.setOriginalData("介護調査員番号", 介護調査員番号);
        this.setOriginalData("調査員氏名", 調査員氏名);
        this.setOriginalData("割付済人数", 割付済人数);
        this.setOriginalData("地区コード", 地区コード);
        this.setOriginalData("地区", 地区);
        this.介護調査員番号 = 介護調査員番号;
        this.調査員氏名 = 調査員氏名;
        this.割付済人数 = 割付済人数;
        this.地区コード = 地区コード;
        this.地区 = 地区;
    }

    public RString get介護調査員番号() {
        return 介護調査員番号;
    }

    public RString get調査員氏名() {
        return 調査員氏名;
    }

    public RString get割付済人数() {
        return 割付済人数;
    }

    public RString get地区コード() {
        return 地区コード;
    }

    public RString get地区() {
        return 地区;
    }

    public void set介護調査員番号(RString 介護調査員番号) {
        this.setOriginalData("介護調査員番号", 介護調査員番号);
        this.介護調査員番号 = 介護調査員番号;
    }

    public void set調査員氏名(RString 調査員氏名) {
        this.setOriginalData("調査員氏名", 調査員氏名);
        this.調査員氏名 = 調査員氏名;
    }

    public void set割付済人数(RString 割付済人数) {
        this.setOriginalData("割付済人数", 割付済人数);
        this.割付済人数 = 割付済人数;
    }

    public void set地区コード(RString 地区コード) {
        this.setOriginalData("地区コード", 地区コード);
        this.地区コード = 地区コード;
    }

    public void set地区(RString 地区) {
        this.setOriginalData("地区", 地区);
        this.地区 = 地区;
    }

}