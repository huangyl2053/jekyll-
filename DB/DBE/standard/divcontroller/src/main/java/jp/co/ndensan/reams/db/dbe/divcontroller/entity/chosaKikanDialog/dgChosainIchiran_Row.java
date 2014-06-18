package jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaKikanDialog;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 17:35:08 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainIchiran_Row extends DataRow {

    private RString chosainNo;
    private RString chosainMeisho;

    public dgChosainIchiran_Row() {
        super();
        this.chosainNo = RString.EMPTY;
        this.chosainMeisho = RString.EMPTY;
    }

    public dgChosainIchiran_Row(RString chosainNo, RString chosainMeisho) {
        super();
        this.setOriginalData("chosainNo", chosainNo);
        this.setOriginalData("chosainMeisho", chosainMeisho);
        this.chosainNo = chosainNo;
        this.chosainMeisho = chosainMeisho;
    }

    public RString getChosainNo() {
        return chosainNo;
    }

    public RString getChosainMeisho() {
        return chosainMeisho;
    }

    public void setChosainNo(RString chosainNo) {
        this.setOriginalData("chosainNo", chosainNo);
        this.chosainNo = chosainNo;
    }

    public void setChosainMeisho(RString chosainMeisho) {
        this.setOriginalData("chosainMeisho", chosainMeisho);
        this.chosainMeisho = chosainMeisho;
    }

}