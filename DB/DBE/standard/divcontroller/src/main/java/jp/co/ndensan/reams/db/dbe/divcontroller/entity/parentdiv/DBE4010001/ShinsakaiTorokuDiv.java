package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
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
 * ShinsakaiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("shinsakaitorokuichiran")
    private shinsakaitorokuichiranDiv shinsakaitorokuichiran;
    @JsonProperty("btnShinsakekkakanryooutput")
    private ButtonDownLoad btnShinsakekkakanryooutput;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getshinsakaitorokuichiran
     * @return shinsakaitorokuichiran
     */
    @JsonProperty("shinsakaitorokuichiran")
    public shinsakaitorokuichiranDiv getShinsakaitorokuichiran() {
        return shinsakaitorokuichiran;
    }

    /*
     * setshinsakaitorokuichiran
     * @param shinsakaitorokuichiran shinsakaitorokuichiran
     */
    @JsonProperty("shinsakaitorokuichiran")
    public void setShinsakaitorokuichiran(shinsakaitorokuichiranDiv shinsakaitorokuichiran) {
        this.shinsakaitorokuichiran = shinsakaitorokuichiran;
    }

    /*
     * getbtnShinsakekkakanryooutput
     * @return btnShinsakekkakanryooutput
     */
    @JsonProperty("btnShinsakekkakanryooutput")
    public ButtonDownLoad getBtnShinsakekkakanryooutput() {
        return btnShinsakekkakanryooutput;
    }

    /*
     * setbtnShinsakekkakanryooutput
     * @param btnShinsakekkakanryooutput btnShinsakekkakanryooutput
     */
    @JsonProperty("btnShinsakekkakanryooutput")
    public void setBtnShinsakekkakanryooutput(ButtonDownLoad btnShinsakekkakanryooutput) {
        this.btnShinsakekkakanryooutput = btnShinsakekkakanryooutput;
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
    public RadioButton getRadTaishoshaJotai() {
        return this.getShinsakaitorokuichiran().getRadTaishoshaJotai();
    }

    @JsonIgnore
    public void  setRadTaishoshaJotai(RadioButton radTaishoshaJotai) {
        this.getShinsakaitorokuichiran().setRadTaishoshaJotai(radTaishoshaJotai);
    }

    @JsonIgnore
    public TextBox getTxtTotalCount() {
        return this.getShinsakaitorokuichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBox txtTotalCount) {
        this.getShinsakaitorokuichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBox getTxtCompleteCount() {
        return this.getShinsakaitorokuichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBox txtCompleteCount) {
        this.getShinsakaitorokuichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBox getTxtMishoriCount() {
        return this.getShinsakaitorokuichiran().getTxtMishoriCount();
    }

    @JsonIgnore
    public void  setTxtMishoriCount(TextBox txtMishoriCount) {
        this.getShinsakaitorokuichiran().setTxtMishoriCount(txtMishoriCount);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getShinsakaitorokuichiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getShinsakaitorokuichiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
