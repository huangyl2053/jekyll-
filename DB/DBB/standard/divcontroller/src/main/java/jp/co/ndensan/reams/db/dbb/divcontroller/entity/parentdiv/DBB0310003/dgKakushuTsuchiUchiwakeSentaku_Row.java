package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Mar 21 18:26:06 CST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private Button btnSentaku;
    private RString txtJokenMeisho;
    private RString txtUchiwake;

    public dgKakushuTsuchiUchiwakeSentaku_Row() {
        super();
        this.btnSentaku = new Button();
        this.txtJokenMeisho = RString.EMPTY;
        this.txtUchiwake = RString.EMPTY;
        this.setOriginalData("btnSentaku", btnSentaku);
        this.setOriginalData("txtJokenMeisho", txtJokenMeisho);
        this.setOriginalData("txtUchiwake", txtUchiwake);
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

    // </editor-fold>
}
