package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoTeikeibun;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 30 16:27:25 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTeikeibun_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTeikeibun_Row extends DataRow {

    private RString code;
    private RString naiyo;

    public dgTeikeibun_Row() {
        super();
        this.code = RString.EMPTY;
        this.naiyo = RString.EMPTY;
    }

    public dgTeikeibun_Row(RString code, RString naiyo) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("naiyo", naiyo);
        this.code = code;
        this.naiyo = naiyo;
    }

    public RString getCode() {
        return code;
    }

    public RString getNaiyo() {
        return naiyo;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setNaiyo(RString naiyo) {
        this.setOriginalData("naiyo", naiyo);
        this.naiyo = naiyo;
    }

}