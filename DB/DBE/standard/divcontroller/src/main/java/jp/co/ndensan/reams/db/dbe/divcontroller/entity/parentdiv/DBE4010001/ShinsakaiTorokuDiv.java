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
    @JsonProperty("shinsakaiTorokuFooterArea")
    private shinsakaiTorokuFooterAreaDiv shinsakaiTorokuFooterArea;
    @JsonProperty("shinsakaiIchiran")
    private shinsakaiIchiranDiv shinsakaiIchiran;
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
     * getshinsakaiTorokuFooterArea
     * @return shinsakaiTorokuFooterArea
     */
    @JsonProperty("shinsakaiTorokuFooterArea")
    public shinsakaiTorokuFooterAreaDiv getShinsakaiTorokuFooterArea() {
        return shinsakaiTorokuFooterArea;
    }

    /*
     * setshinsakaiTorokuFooterArea
     * @param shinsakaiTorokuFooterArea shinsakaiTorokuFooterArea
     */
    @JsonProperty("shinsakaiTorokuFooterArea")
    public void setShinsakaiTorokuFooterArea(shinsakaiTorokuFooterAreaDiv shinsakaiTorokuFooterArea) {
        this.shinsakaiTorokuFooterArea = shinsakaiTorokuFooterArea;
    }

    /*
     * getshinsakaiIchiran
     * @return shinsakaiIchiran
     */
    @JsonProperty("shinsakaiIchiran")
    public shinsakaiIchiranDiv getShinsakaiIchiran() {
        return shinsakaiIchiran;
    }

    /*
     * setshinsakaiIchiran
     * @param shinsakaiIchiran shinsakaiIchiran
     */
    @JsonProperty("shinsakaiIchiran")
    public void setShinsakaiIchiran(shinsakaiIchiranDiv shinsakaiIchiran) {
        this.shinsakaiIchiran = shinsakaiIchiran;
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
    public TextBoxNum getTxtTotalCount() {
        return this.getShinsakaitorokuichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getShinsakaitorokuichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getShinsakaitorokuichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getShinsakaitorokuichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtMishoriCount() {
        return this.getShinsakaitorokuichiran().getTxtMishoriCount();
    }

    @JsonIgnore
    public void  setTxtMishoriCount(TextBoxNum txtMishoriCount) {
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
    public TextBoxNum getTxtTaishoshaMaxHyojiKensu() {
        return this.getShinsakaitorokuichiran().getTxtTaishoshaMaxHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtTaishoshaMaxHyojiKensu(TextBoxNum txtTaishoshaMaxHyojiKensu) {
        this.getShinsakaitorokuichiran().setTxtTaishoshaMaxHyojiKensu(txtTaishoshaMaxHyojiKensu);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnShinsakekkakanryooutput() {
        return this.getShinsakaiTorokuFooterArea().getBtnShinsakekkakanryooutput();
    }

    @JsonIgnore
    public void  setBtnShinsakekkakanryooutput(ButtonDownLoad btnShinsakekkakanryooutput) {
        this.getShinsakaiTorokuFooterArea().setBtnShinsakekkakanryooutput(btnShinsakekkakanryooutput);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKensakuKaisaiYoteiYmd() {
        return this.getShinsakaiIchiran().getTxtKensakuKaisaiYoteiYmd();
    }

    @JsonIgnore
    public void  setTxtKensakuKaisaiYoteiYmd(TextBoxDateRange txtKensakuKaisaiYoteiYmd) {
        this.getShinsakaiIchiran().setTxtKensakuKaisaiYoteiYmd(txtKensakuKaisaiYoteiYmd);
    }

    @JsonIgnore
    public Button getBtnSearchShinsakai() {
        return this.getShinsakaiIchiran().getBtnSearchShinsakai();
    }

    @JsonIgnore
    public void  setBtnSearchShinsakai(Button btnSearchShinsakai) {
        this.getShinsakaiIchiran().setBtnSearchShinsakai(btnSearchShinsakai);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinsakaiMaxHyojiKensu() {
        return this.getShinsakaiIchiran().getTxtShinsakaiMaxHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtShinsakaiMaxHyojiKensu(TextBoxNum txtShinsakaiMaxHyojiKensu) {
        this.getShinsakaiIchiran().setTxtShinsakaiMaxHyojiKensu(txtShinsakaiMaxHyojiKensu);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiList_Row> getDgShinsakaiList() {
        return this.getShinsakaiIchiran().getDgShinsakaiList();
    }

    @JsonIgnore
    public void  setDgShinsakaiList(DataGrid<dgShinsakaiList_Row> dgShinsakaiList) {
        this.getShinsakaiIchiran().setDgShinsakaiList(dgShinsakaiList);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
