package jp.co.ndensan.reams.db.dbb.divcontroller.entity.HonKakushuTsuchiUchiwakeKakunin;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 03 19:09:14 JST 2014 
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
    private RString txtUchiwake;

    public dgKakushuTsuchiUchiwakeSentaku_Row() {
        super();
    }

    public dgKakushuTsuchiUchiwakeSentaku_Row(Button btnSentaku, RString txtJokenMeisho, RString txtUchiwake) {
        super();
        this.setOriginalData("btnSentaku", btnSentaku);
        this.setOriginalData("txtJokenMeisho", txtJokenMeisho);
        this.setOriginalData("txtUchiwake", txtUchiwake);
        this.btnSentaku = btnSentaku;
        this.txtJokenMeisho = txtJokenMeisho;
        this.txtUchiwake = txtUchiwake;
    }

    public Button getBtnSentaku() {
        return btnSentaku;
    }

    public RString getTxtJokenMeisho() {
        return txtJokenMeisho;
    }

    public RString getTxtUchiwake() {
        return txtUchiwake;
    }

    public void setBtnSentaku(Button btnSentaku) {
        this.setOriginalData("btnSentaku", btnSentaku);
        this.btnSentaku = btnSentaku;
    }

    public void setTxtJokenMeisho(RString txtJokenMeisho) {
        this.setOriginalData("txtJokenMeisho", txtJokenMeisho);
        this.txtJokenMeisho = txtJokenMeisho;
    }

    public void setTxtUchiwake(RString txtUchiwake) {
        this.setOriginalData("txtUchiwake", txtUchiwake);
        this.txtUchiwake = txtUchiwake;
    }

}