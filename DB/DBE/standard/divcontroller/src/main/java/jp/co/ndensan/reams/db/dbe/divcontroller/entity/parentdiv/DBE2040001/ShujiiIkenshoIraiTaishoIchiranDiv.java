package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoIraiTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraiTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    private ikenshoiraitaishoichiranDiv ikenshoiraitaishoichiran;
    @JsonProperty("ikenshoiraiselect")
    private ikenshoiraiselectDiv ikenshoiraiselect;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getikenshoiraitaishoichiran
     * @return ikenshoiraitaishoichiran
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    public ikenshoiraitaishoichiranDiv getIkenshoiraitaishoichiran() {
        return ikenshoiraitaishoichiran;
    }

    /*
     * setikenshoiraitaishoichiran
     * @param ikenshoiraitaishoichiran ikenshoiraitaishoichiran
     */
    @JsonProperty("ikenshoiraitaishoichiran")
    public void setIkenshoiraitaishoichiran(ikenshoiraitaishoichiranDiv ikenshoiraitaishoichiran) {
        this.ikenshoiraitaishoichiran = ikenshoiraitaishoichiran;
    }

    /*
     * getikenshoiraiselect
     * @return ikenshoiraiselect
     */
    @JsonProperty("ikenshoiraiselect")
    public ikenshoiraiselectDiv getIkenshoiraiselect() {
        return ikenshoiraiselect;
    }

    /*
     * setikenshoiraiselect
     * @param ikenshoiraiselect ikenshoiraiselect
     */
    @JsonProperty("ikenshoiraiselect")
    public void setIkenshoiraiselect(ikenshoiraiselectDiv ikenshoiraiselect) {
        this.ikenshoiraiselect = ikenshoiraiselect;
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
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTotalCount() {
        return this.getIkenshoiraitaishoichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBox txtTotalCount) {
        this.getIkenshoiraitaishoichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBox getTxtCompleteCount() {
        return this.getIkenshoiraitaishoichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBox txtCompleteCount) {
        this.getIkenshoiraitaishoichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBox getTxtNoUpdate() {
        return this.getIkenshoiraitaishoichiran().getTxtNoUpdate();
    }

    @JsonIgnore
    public void  setTxtNoUpdate(TextBox txtNoUpdate) {
        this.getIkenshoiraitaishoichiran().setTxtNoUpdate(txtNoUpdate);
    }

    @JsonIgnore
    public RadioButton getRadShoriJyotai() {
        return this.getIkenshoiraitaishoichiran().getRadShoriJyotai();
    }

    @JsonIgnore
    public void  setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.getIkenshoiraitaishoichiran().setRadShoriJyotai(radShoriJyotai);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getIkenshoiraitaishoichiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getIkenshoiraitaishoichiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnikenshoiraitaishooutput() {
        return this.getIkenshoiraiselect().getBtnikenshoiraitaishooutput();
    }

    @JsonIgnore
    public void  setBtnikenshoiraitaishooutput(ButtonDownLoad btnikenshoiraitaishooutput) {
        this.getIkenshoiraiselect().setBtnikenshoiraitaishooutput(btnikenshoiraitaishooutput);
    }

    @JsonIgnore
    public ButtonDialog getBtnIraishoToOutputDialog() {
        return this.getIkenshoiraiselect().getBtnIraishoToOutputDialog();
    }

    @JsonIgnore
    public void  setBtnIraishoToOutputDialog(ButtonDialog btnIraishoToOutputDialog) {
        this.getIkenshoiraiselect().setBtnIraishoToOutputDialog(btnIraishoToOutputDialog);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
