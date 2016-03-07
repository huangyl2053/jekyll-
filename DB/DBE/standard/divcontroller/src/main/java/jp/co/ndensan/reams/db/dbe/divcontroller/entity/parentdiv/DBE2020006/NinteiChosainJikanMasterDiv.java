package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosainJikanMaster のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosainJikanMasterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;
    @JsonProperty("MainPanel")
    private MainPanelDiv MainPanel;
    @JsonProperty("NinteiChosaIkkatsuInputModel")
    private RString NinteiChosaIkkatsuInputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * getMainPanel
     * @return MainPanel
     */
    @JsonProperty("MainPanel")
    public MainPanelDiv getMainPanel() {
        return MainPanel;
    }

    /*
     * setMainPanel
     * @param MainPanel MainPanel
     */
    @JsonProperty("MainPanel")
    public void setMainPanel(MainPanelDiv MainPanel) {
        this.MainPanel = MainPanel;
    }

    /*
     * getNinteiChosaIkkatsuInputModel
     * @return NinteiChosaIkkatsuInputModel
     */
    @JsonProperty("NinteiChosaIkkatsuInputModel")
    public RString getNinteiChosaIkkatsuInputModel() {
        return NinteiChosaIkkatsuInputModel;
    }

    /*
     * setNinteiChosaIkkatsuInputModel
     * @param NinteiChosaIkkatsuInputModel NinteiChosaIkkatsuInputModel
     */
    @JsonProperty("NinteiChosaIkkatsuInputModel")
    public void setNinteiChosaIkkatsuInputModel(RString NinteiChosaIkkatsuInputModel) {
        this.NinteiChosaIkkatsuInputModel = NinteiChosaIkkatsuInputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTaishoChiku() {
        return this.getMainPanel().getSearchConditionPanel().getDdlTaishoChiku();
    }

    @JsonIgnore
    public void  setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.getMainPanel().getSearchConditionPanel().setDdlTaishoChiku(ddlTaishoChiku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSettingMonth() {
        return this.getMainPanel().getSearchConditionPanel().getTxtSettingMonth();
    }

    @JsonIgnore
    public void  setTxtSettingMonth(TextBoxFlexibleDate txtSettingMonth) {
        this.getMainPanel().getSearchConditionPanel().setTxtSettingMonth(txtSettingMonth);
    }

    @JsonIgnore
    public Button getBtnPrevious() {
        return this.getMainPanel().getSearchConditionPanel().getBtnPrevious();
    }

    @JsonIgnore
    public void  setBtnPrevious(Button btnPrevious) {
        this.getMainPanel().getSearchConditionPanel().setBtnPrevious(btnPrevious);
    }

    @JsonIgnore
    public Button getBtnNext() {
        return this.getMainPanel().getSearchConditionPanel().getBtnNext();
    }

    @JsonIgnore
    public void  setBtnNext(Button btnNext) {
        this.getMainPanel().getSearchConditionPanel().setBtnNext(btnNext);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiCode() {
        return this.getMainPanel().getSearchConditionPanel().getTxtNinteiChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiCode(TextBox txtNinteiChosaItakusakiCode) {
        this.getMainPanel().getSearchConditionPanel().setTxtNinteiChosaItakusakiCode(txtNinteiChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getMainPanel().getSearchConditionPanel().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getMainPanel().getSearchConditionPanel().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainCode() {
        return this.getMainPanel().getSearchConditionPanel().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBox txtNinteiChosainCode) {
        this.getMainPanel().getSearchConditionPanel().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getMainPanel().getSearchConditionPanel().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getMainPanel().getSearchConditionPanel().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearch() {
        return this.getMainPanel().getSearchConditionPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(ButtonDialog btnSearch) {
        this.getMainPanel().getSearchConditionPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgTimeScheduleList_Row> getDgTimeScheduleList() {
        return this.getMainPanel().getSettingList().getDgTimeScheduleList();
    }

    @JsonIgnore
    public void  setDgTimeScheduleList(DataGrid<dgTimeScheduleList_Row> dgTimeScheduleList) {
        this.getMainPanel().getSettingList().setDgTimeScheduleList(dgTimeScheduleList);
    }

    @JsonIgnore
    public tabSettingDiv getTabSetting() {
        return this.getMainPanel().getSettingDetail().getTabSetting();
    }

    @JsonIgnore
    public void  setTabSetting(tabSettingDiv tabSetting) {
        this.getMainPanel().getSettingDetail().setTabSetting(tabSetting);
    }

    @JsonIgnore
    public TextBoxDate getTxtSetteiYMD() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getTxtSetteiYMD();
    }

    @JsonIgnore
    public TextBox getTxtJikanWaku() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getTxtJikanWaku();
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiJikan() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getTxtKaishiJikan();
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoJikan() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getTxtShuryoJikan();
    }

    @JsonIgnore
    public RadioButton getRadYoyaku() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getRadYoyaku();
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getMainPanel().getSettingDetail().getTabSetting().getTxtBiko();
    }

    @JsonIgnore
    public Button getBtnCreate() {
        return this.getMainPanel().getSettingDetail().getBtnCreate();
    }

    @JsonIgnore
    public void  setBtnCreate(Button btnCreate) {
        this.getMainPanel().getSettingDetail().setBtnCreate(btnCreate);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getMainPanel().getSettingDetail().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getMainPanel().getSettingDetail().setBtnDelete(btnDelete);
    }

    @JsonIgnore
    public Button getBtnAbort() {
        return this.getMainPanel().getSettingDetail().getBtnAbort();
    }

    @JsonIgnore
    public void  setBtnAbort(Button btnAbort) {
        this.getMainPanel().getSettingDetail().setBtnAbort(btnAbort);
    }

    // </editor-fold>
}
