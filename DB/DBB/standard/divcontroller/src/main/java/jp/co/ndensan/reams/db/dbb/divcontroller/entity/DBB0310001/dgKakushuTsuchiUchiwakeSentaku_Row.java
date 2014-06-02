package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 02 13:54:24 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKakushuTsuchiUchiwakeSentaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKakushuTsuchiUchiwakeSentaku_Row extends DataRow {

    private Button btnSentaku;
    private RString txtJokenMeisho;

    public dgKakushuTsuchiUchiwakeSentaku_Row() {
        super();
    }

    public dgKakushuTsuchiUchiwakeSentaku_Row(Button btnSentaku, RString txtJokenMeisho) {
        super();
        this.setOriginalData("btnSentaku", btnSentaku);
        this.setOriginalData("txtJokenMeisho", txtJokenMeisho);
        this.btnSentaku = btnSentaku;
        this.txtJokenMeisho = txtJokenMeisho;
    }

    public Button getBtnSentaku() {
        return btnSentaku;
    }

    public RString getTxtJokenMeisho() {
        return txtJokenMeisho;
    }

    public void setBtnSentaku(Button btnSentaku) {
        this.setOriginalData("btnSentaku", btnSentaku);
        this.btnSentaku = btnSentaku;
    }

    public void setTxtJokenMeisho(RString txtJokenMeisho) {
        this.setOriginalData("txtJokenMeisho", txtJokenMeisho);
        this.txtJokenMeisho = txtJokenMeisho;
    }

}