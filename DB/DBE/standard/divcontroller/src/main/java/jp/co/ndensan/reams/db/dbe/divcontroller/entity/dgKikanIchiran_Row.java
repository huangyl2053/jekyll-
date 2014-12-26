package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 15:27:32 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKikanIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKikanIchiran_Row extends DataRow {

    private RString kikanNo;
    private RString kikanMeisho;

    public dgKikanIchiran_Row() {
        super();
        this.kikanNo = RString.EMPTY;
        this.kikanMeisho = RString.EMPTY;
    }

    public dgKikanIchiran_Row(RString kikanNo, RString kikanMeisho) {
        super();
        this.setOriginalData("kikanNo", kikanNo);
        this.setOriginalData("kikanMeisho", kikanMeisho);
        this.kikanNo = kikanNo;
        this.kikanMeisho = kikanMeisho;
    }

    public RString getKikanNo() {
        return kikanNo;
    }

    public RString getKikanMeisho() {
        return kikanMeisho;
    }

    public void setKikanNo(RString kikanNo) {
        this.setOriginalData("kikanNo", kikanNo);
        this.kikanNo = kikanNo;
    }

    public void setKikanMeisho(RString kikanMeisho) {
        this.setOriginalData("kikanMeisho", kikanMeisho);
        this.kikanMeisho = kikanMeisho;
    }

}