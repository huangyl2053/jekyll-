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
 * dgIraisakiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIraisakiIchiran_Row extends DataRow {

    private RString 依頼先番号;
    private RString 依頼先名;
    private RString 割付定員;
    private RString 割付済人数;
    private RString 割付地区;

    public dgIraisakiIchiran_Row() {
        super();
    }

    public dgIraisakiIchiran_Row(RString 依頼先番号, RString 依頼先名, RString 割付定員, RString 割付済人数, RString 割付地区) {
        super();
        this.setOriginalData("依頼先番号", 依頼先番号);
        this.setOriginalData("依頼先名", 依頼先名);
        this.setOriginalData("割付定員", 割付定員);
        this.setOriginalData("割付済人数", 割付済人数);
        this.setOriginalData("割付地区", 割付地区);
        this.依頼先番号 = 依頼先番号;
        this.依頼先名 = 依頼先名;
        this.割付定員 = 割付定員;
        this.割付済人数 = 割付済人数;
        this.割付地区 = 割付地区;
    }

    public RString get依頼先番号() {
        return 依頼先番号;
    }

    public RString get依頼先名() {
        return 依頼先名;
    }

    public RString get割付定員() {
        return 割付定員;
    }

    public RString get割付済人数() {
        return 割付済人数;
    }

    public RString get割付地区() {
        return 割付地区;
    }

    public void set依頼先番号(RString 依頼先番号) {
        this.setOriginalData("依頼先番号", 依頼先番号);
        this.依頼先番号 = 依頼先番号;
    }

    public void set依頼先名(RString 依頼先名) {
        this.setOriginalData("依頼先名", 依頼先名);
        this.依頼先名 = 依頼先名;
    }

    public void set割付定員(RString 割付定員) {
        this.setOriginalData("割付定員", 割付定員);
        this.割付定員 = 割付定員;
    }

    public void set割付済人数(RString 割付済人数) {
        this.setOriginalData("割付済人数", 割付済人数);
        this.割付済人数 = 割付済人数;
    }

    public void set割付地区(RString 割付地区) {
        this.setOriginalData("割付地区", 割付地区);
        this.割付地区 = 割付地区;
    }

}