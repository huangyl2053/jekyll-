package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 15:25:25 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgIchijiHanteiKeikokuCode_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIchijiHanteiKeikokuCode_Row extends DataRow {

    private RString no;
    private RString code;
    private RString setsumei;

    public dgIchijiHanteiKeikokuCode_Row() {
        super();
        this.no = RString.EMPTY;
        this.code = RString.EMPTY;
        this.setsumei = RString.EMPTY;
    }

    public dgIchijiHanteiKeikokuCode_Row(RString no, RString code, RString setsumei) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("code", code);
        this.setOriginalData("setsumei", setsumei);
        this.no = no;
        this.code = code;
        this.setsumei = setsumei;
    }

    public RString getNo() {
        return no;
    }

    public RString getCode() {
        return code;
    }

    public RString getSetsumei() {
        return setsumei;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setSetsumei(RString setsumei) {
        this.setOriginalData("setsumei", setsumei);
        this.setsumei = setsumei;
    }

}