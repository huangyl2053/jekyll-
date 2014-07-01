package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 23 14:26:05 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChohyoSentaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChohyoSentaku_Row extends DataRow {

    private RString txtChohyoSentaku;

    public dgChohyoSentaku_Row() {
        super();
        this.txtChohyoSentaku = RString.EMPTY;
    }

    public dgChohyoSentaku_Row(RString txtChohyoSentaku) {
        super();
        this.setOriginalData("txtChohyoSentaku", txtChohyoSentaku);
        this.txtChohyoSentaku = txtChohyoSentaku;
    }

    public RString getTxtChohyoSentaku() {
        return txtChohyoSentaku;
    }

    public void setTxtChohyoSentaku(RString txtChohyoSentaku) {
        this.setOriginalData("txtChohyoSentaku", txtChohyoSentaku);
        this.txtChohyoSentaku = txtChohyoSentaku;
    }

}