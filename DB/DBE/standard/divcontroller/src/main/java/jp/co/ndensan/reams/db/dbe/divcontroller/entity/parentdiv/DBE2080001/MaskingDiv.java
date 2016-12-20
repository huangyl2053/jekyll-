package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001;
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
 * Masking のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaskingDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chosairaitaishoshaichiran")
    private chosairaitaishoshaichiranDiv chosairaitaishoshaichiran;
    @JsonProperty("ButtonPanel")
    private ButtonPanelDiv ButtonPanel;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchosairaitaishoshaichiran
     * @return chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public chosairaitaishoshaichiranDiv getChosairaitaishoshaichiran() {
        return chosairaitaishoshaichiran;
    }

    /*
     * setchosairaitaishoshaichiran
     * @param chosairaitaishoshaichiran chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public void setChosairaitaishoshaichiran(chosairaitaishoshaichiranDiv chosairaitaishoshaichiran) {
        this.chosairaitaishoshaichiran = chosairaitaishoshaichiran;
    }

    /*
     * getButtonPanel
     * @return ButtonPanel
     */
    @JsonProperty("ButtonPanel")
    public ButtonPanelDiv getButtonPanel() {
        return ButtonPanel;
    }

    /*
     * setButtonPanel
     * @param ButtonPanel ButtonPanel
     */
    @JsonProperty("ButtonPanel")
    public void setButtonPanel(ButtonPanelDiv ButtonPanel) {
        this.ButtonPanel = ButtonPanel;
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
    public RadioButton getRadTaishoDataKubun() {
        return this.getChosairaitaishoshaichiran().getRadTaishoDataKubun();
    }

    @JsonIgnore
    public void  setRadTaishoDataKubun(RadioButton radTaishoDataKubun) {
        this.getChosairaitaishoshaichiran().setRadTaishoDataKubun(radTaishoDataKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtTotalCount() {
        return this.getChosairaitaishoshaichiran().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.getChosairaitaishoshaichiran().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getChosairaitaishoshaichiran().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getChosairaitaishoshaichiran().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBoxNum getTxtMishoriCount() {
        return this.getChosairaitaishoshaichiran().getTxtMishoriCount();
    }

    @JsonIgnore
    public void  setTxtMishoriCount(TextBoxNum txtMishoriCount) {
        this.getChosairaitaishoshaichiran().setTxtMishoriCount(txtMishoriCount);
    }

    @JsonIgnore
    public DataGrid<dgYokaigoNinteiTaskList_Row> getDgYokaigoNinteiTaskList() {
        return this.getChosairaitaishoshaichiran().getDgYokaigoNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgYokaigoNinteiTaskList(DataGrid<dgYokaigoNinteiTaskList_Row> dgYokaigoNinteiTaskList) {
        this.getChosairaitaishoshaichiran().setDgYokaigoNinteiTaskList(dgYokaigoNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getChosairaitaishoshaichiran().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtSaidaiHyojiKensu(TextBoxNum TxtSaidaiHyojiKensu) {
        this.getChosairaitaishoshaichiran().setTxtSaidaiHyojiKensu(TxtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getButtonPanel().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getButtonPanel().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
