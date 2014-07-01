package jp.co.ndensan.reams.db.dbe.divcontroller.entity.iryoKikanDialog;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 18 19:54:35 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShujiiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShujiiIchiran_Row extends DataRow {

    private RString ishiNo;
    private RString ishiMeisho;

    public dgShujiiIchiran_Row() {
        super();
        this.ishiNo = RString.EMPTY;
        this.ishiMeisho = RString.EMPTY;
    }

    public dgShujiiIchiran_Row(RString ishiNo, RString ishiMeisho) {
        super();
        this.setOriginalData("ishiNo", ishiNo);
        this.setOriginalData("ishiMeisho", ishiMeisho);
        this.ishiNo = ishiNo;
        this.ishiMeisho = ishiMeisho;
    }

    public RString getIshiNo() {
        return ishiNo;
    }

    public RString getIshiMeisho() {
        return ishiMeisho;
    }

    public void setIshiNo(RString ishiNo) {
        this.setOriginalData("ishiNo", ishiNo);
        this.ishiNo = ishiNo;
    }

    public void setIshiMeisho(RString ishiMeisho) {
        this.setOriginalData("ishiMeisho", ishiMeisho);
        this.ishiMeisho = ishiMeisho;
    }

}