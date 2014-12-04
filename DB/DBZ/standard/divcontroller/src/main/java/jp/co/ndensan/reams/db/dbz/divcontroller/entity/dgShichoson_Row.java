package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:50:05 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShichoson_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShichoson_Row extends DataRow {

    private RString shichosonCode;
    private RString shichosonMeisho;
    private RString shichoson;

    public dgShichoson_Row() {
        super();
        this.shichosonCode = RString.EMPTY;
        this.shichosonMeisho = RString.EMPTY;
        this.shichoson = RString.EMPTY;
    }

    public dgShichoson_Row(RString shichosonCode, RString shichosonMeisho, RString shichoson) {
        super();
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("shichosonMeisho", shichosonMeisho);
        this.setOriginalData("shichoson", shichoson);
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.shichoson = shichoson;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    public RString getShichoson() {
        return shichoson;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setShichosonMeisho(RString shichosonMeisho) {
        this.setOriginalData("shichosonMeisho", shichosonMeisho);
        this.shichosonMeisho = shichosonMeisho;
    }

    public void setShichoson(RString shichoson) {
        this.setOriginalData("shichoson", shichoson);
        this.shichoson = shichoson;
    }

}