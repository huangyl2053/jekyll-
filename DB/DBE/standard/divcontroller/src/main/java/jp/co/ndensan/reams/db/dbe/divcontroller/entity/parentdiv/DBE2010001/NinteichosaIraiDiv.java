package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.session.PanelSessionAccessor;

/**
 * NinteichosaIrai のクラスファイル
 *
 * @author 自動生成
 */
public class NinteichosaIraiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiList")
    private NinteichosaIraiListDiv NinteichosaIraiList;
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
     * getNinteichosaIraiList
     * @return NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public NinteichosaIraiListDiv getNinteichosaIraiList() {
        return NinteichosaIraiList;
    }

    /*
     * setNinteichosaIraiList
     * @param NinteichosaIraiList NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public void setNinteichosaIraiList(NinteichosaIraiListDiv NinteichosaIraiList) {
        this.NinteichosaIraiList = NinteichosaIraiList;
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
    public chosairaitaishoshaichiranDiv getChosairaitaishoshaichiran() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran();
    }

    @JsonIgnore
    public void setChosairaitaishoshaichiran(chosairaitaishoshaichiranDiv chosairaitaishoshaichiran) {
        this.getNinteichosaIraiList().setChosairaitaishoshaichiran(chosairaitaishoshaichiran);
    }

    @JsonIgnore
    public RadioButton getRadShoriJyotai() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getRadShoriJyotai();
    }

    @JsonIgnore
    public void setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setRadShoriJyotai(radShoriJyotai);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtNoUpdate() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getTxtNoUpdate();
    }

    @JsonIgnore
    public void setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setTxtNoUpdate(txtNoUpdate);
    }

    @JsonIgnore
    public BatchParamPanelDiv getBatchParamPanel() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getBatchParamPanel();
    }

    @JsonIgnore
    public void setBatchParamPanel(BatchParamPanelDiv BatchParamPanel) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setBatchParamPanel(BatchParamPanel);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getBatchParamPanel().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getBatchParamPanel().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getTxtMaxCount();
    }

    @JsonIgnore
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getNinteichosaIraiList().getChosairaitaishoshaichiran().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getNinteichosaIraiList().getBtndataoutput();
    }

    @JsonIgnore
    public void setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getNinteichosaIraiList().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public Button getBtniraiauto() {
        return this.getNinteichosaIraiList().getBtniraiauto();
    }

    @JsonIgnore
    public void setBtniraiauto(Button btniraiauto) {
        this.getNinteichosaIraiList().setBtniraiauto(btniraiauto);
    }

    @JsonIgnore
    public ButtonDialog getBtnTaOutput() {
        return this.getNinteichosaIraiList().getBtnTaOutput();
    }

    @JsonIgnore
    public void setBtnTaOutput(ButtonDialog btnTaOutput) {
        this.getNinteichosaIraiList().setBtnTaOutput(btnTaOutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 最大表示件数の現在値を保持します。
     *
     * @param value 最大表示件数
     */
    public void setMaxCount(Decimal value) {
        PanelSessionAccessor.put(this, new RString("maxCount"), value);
    }

    /**
     * 最大表示件数の値を取得します。
     *
     * @return 最大表示件数
     */
    public Decimal getMaxCount() {
        return PanelSessionAccessor.get(this, new RString("maxCount"), Decimal.class);
    }
}
