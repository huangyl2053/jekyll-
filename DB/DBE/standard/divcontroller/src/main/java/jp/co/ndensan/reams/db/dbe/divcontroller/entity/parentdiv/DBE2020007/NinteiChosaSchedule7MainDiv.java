package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaSchedule7Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaSchedule7MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaChikuPanel")
    private ChosaChikuPanelDiv ChosaChikuPanel;
    @JsonProperty("ChosaChikuShichosonPanel")
    private ChosaChikuShichosonPanelDiv ChosaChikuShichosonPanel;
    @JsonProperty("ChosaChikuShichosoInput")
    private ChosaChikuShichosoInputDiv ChosaChikuShichosoInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaChikuPanel
     * @return ChosaChikuPanel
     */
    @JsonProperty("ChosaChikuPanel")
    public ChosaChikuPanelDiv getChosaChikuPanel() {
        return ChosaChikuPanel;
    }

    /*
     * setChosaChikuPanel
     * @param ChosaChikuPanel ChosaChikuPanel
     */
    @JsonProperty("ChosaChikuPanel")
    public void setChosaChikuPanel(ChosaChikuPanelDiv ChosaChikuPanel) {
        this.ChosaChikuPanel = ChosaChikuPanel;
    }

    /*
     * getChosaChikuShichosonPanel
     * @return ChosaChikuShichosonPanel
     */
    @JsonProperty("ChosaChikuShichosonPanel")
    public ChosaChikuShichosonPanelDiv getChosaChikuShichosonPanel() {
        return ChosaChikuShichosonPanel;
    }

    /*
     * setChosaChikuShichosonPanel
     * @param ChosaChikuShichosonPanel ChosaChikuShichosonPanel
     */
    @JsonProperty("ChosaChikuShichosonPanel")
    public void setChosaChikuShichosonPanel(ChosaChikuShichosonPanelDiv ChosaChikuShichosonPanel) {
        this.ChosaChikuShichosonPanel = ChosaChikuShichosonPanel;
    }

    /*
     * getChosaChikuShichosoInput
     * @return ChosaChikuShichosoInput
     */
    @JsonProperty("ChosaChikuShichosoInput")
    public ChosaChikuShichosoInputDiv getChosaChikuShichosoInput() {
        return ChosaChikuShichosoInput;
    }

    /*
     * setChosaChikuShichosoInput
     * @param ChosaChikuShichosoInput ChosaChikuShichosoInput
     */
    @JsonProperty("ChosaChikuShichosoInput")
    public void setChosaChikuShichosoInput(ChosaChikuShichosoInputDiv ChosaChikuShichosoInput) {
        this.ChosaChikuShichosoInput = ChosaChikuShichosoInput;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgChosaChikuList_Row> getDgChosaChikuList() {
        return this.getChosaChikuPanel().getDgChosaChikuList();
    }

    @JsonIgnore
    public void  setDgChosaChikuList(DataGrid<dgChosaChikuList_Row> dgChosaChikuList) {
        this.getChosaChikuPanel().setDgChosaChikuList(dgChosaChikuList);
    }

    @JsonIgnore
    public TextBox getTxtChosaChikuCode() {
        return this.getChosaChikuShichosonPanel().getTxtChosaChikuCode();
    }

    @JsonIgnore
    public void  setTxtChosaChikuCode(TextBox txtChosaChikuCode) {
        this.getChosaChikuShichosonPanel().setTxtChosaChikuCode(txtChosaChikuCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaChikuName() {
        return this.getChosaChikuShichosonPanel().getTxtChosaChikuName();
    }

    @JsonIgnore
    public void  setTxtChosaChikuName(TextBox txtChosaChikuName) {
        this.getChosaChikuShichosonPanel().setTxtChosaChikuName(txtChosaChikuName);
    }

    @JsonIgnore
    public Button getBtnInsert() {
        return this.getChosaChikuShichosonPanel().getBtnInsert();
    }

    @JsonIgnore
    public void  setBtnInsert(Button btnInsert) {
        this.getChosaChikuShichosonPanel().setBtnInsert(btnInsert);
    }

    @JsonIgnore
    public DataGrid<dgChosaChikuChichosonList_Row> getDgChosaChikuChichosonList() {
        return this.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList();
    }

    @JsonIgnore
    public void  setDgChosaChikuChichosonList(DataGrid<dgChosaChikuChichosonList_Row> dgChosaChikuChichosonList) {
        this.getChosaChikuShichosonPanel().setDgChosaChikuChichosonList(dgChosaChikuChichosonList);
    }

    // </editor-fold>
}
