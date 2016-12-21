package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ikenshoget のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshogetDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Ikenshogetichiran")
    private IkenshogetichiranDiv Ikenshogetichiran;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshogetichiran
     * @return Ikenshogetichiran
     */
    @JsonProperty("Ikenshogetichiran")
    public IkenshogetichiranDiv getIkenshogetichiran() {
        return Ikenshogetichiran;
    }

    /*
     * setIkenshogetichiran
     * @param Ikenshogetichiran Ikenshogetichiran
     */
    @JsonProperty("Ikenshogetichiran")
    public void setIkenshogetichiran(IkenshogetichiranDiv Ikenshogetichiran) {
        this.Ikenshogetichiran = Ikenshogetichiran;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJyotaiKubun() {
        return this.getIkenshogetichiran().getRadJyotaiKubun();
    }

    @JsonIgnore
    public void  setRadJyotaiKubun(RadioButton radJyotaiKubun) {
        this.getIkenshogetichiran().setRadJyotaiKubun(radJyotaiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtMisyori() {
        return this.getIkenshogetichiran().getTxtMisyori();
    }

    @JsonIgnore
    public void  setTxtMisyori(TextBoxNum txtMisyori) {
        this.getIkenshogetichiran().setTxtMisyori(txtMisyori);
    }

    @JsonIgnore
    public TextBoxNum getTxtKanryouKano() {
        return this.getIkenshogetichiran().getTxtKanryouKano();
    }

    @JsonIgnore
    public void  setTxtKanryouKano(TextBoxNum txtKanryouKano) {
        this.getIkenshogetichiran().setTxtKanryouKano(txtKanryouKano);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokei() {
        return this.getIkenshogetichiran().getTxtGokei();
    }

    @JsonIgnore
    public void  setTxtGokei(TextBoxNum txtGokei) {
        this.getIkenshogetichiran().setTxtGokei(txtGokei);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getIkenshogetichiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getIkenshogetichiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnikenshogetoutput() {
        return this.getIkenshogetichiran().getBtnikenshogetoutput();
    }

    @JsonIgnore
    public void  setBtnikenshogetoutput(ButtonDownLoad btnikenshogetoutput) {
        this.getIkenshogetichiran().setBtnikenshogetoutput(btnikenshogetoutput);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxNumber() {
        return this.getIkenshogetichiran().getTxtMaxNumber();
    }

    @JsonIgnore
    public void  setTxtMaxNumber(TextBoxNum txtMaxNumber) {
        this.getIkenshogetichiran().setTxtMaxNumber(txtMaxNumber);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
