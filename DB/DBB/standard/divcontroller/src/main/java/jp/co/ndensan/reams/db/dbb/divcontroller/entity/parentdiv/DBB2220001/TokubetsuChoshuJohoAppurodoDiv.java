package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * TokubetsuChoshuJohoAppurodo のクラスファイル
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class TokubetsuChoshuJohoAppurodoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyoPanel")
    private ShoriJokyoPanelDiv ShoriJokyoPanel;
    @JsonProperty("ShoriTaishoShichosonPanel")
    private ShoriTaishoShichosonPanelDiv ShoriTaishoShichosonPanel;
    @JsonProperty("ShoriTaishoGetuPanel")
    private ShoriTaishoGetuPanelDiv ShoriTaishoGetuPanel;
    @JsonProperty("PanelUpload")
    private PanelUploadDiv PanelUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriJokyoPanel
     * @return ShoriJokyoPanel
     */
    @JsonProperty("ShoriJokyoPanel")
    public ShoriJokyoPanelDiv getShoriJokyoPanel() {
        return ShoriJokyoPanel;
    }

    /*
     * setShoriJokyoPanel
     * @param ShoriJokyoPanel ShoriJokyoPanel
     */
    @JsonProperty("ShoriJokyoPanel")
    public void setShoriJokyoPanel(ShoriJokyoPanelDiv ShoriJokyoPanel) {
        this.ShoriJokyoPanel = ShoriJokyoPanel;
    }

    /*
     * getShoriTaishoShichosonPanel
     * @return ShoriTaishoShichosonPanel
     */
    @JsonProperty("ShoriTaishoShichosonPanel")
    public ShoriTaishoShichosonPanelDiv getShoriTaishoShichosonPanel() {
        return ShoriTaishoShichosonPanel;
    }

    /*
     * setShoriTaishoShichosonPanel
     * @param ShoriTaishoShichosonPanel ShoriTaishoShichosonPanel
     */
    @JsonProperty("ShoriTaishoShichosonPanel")
    public void setShoriTaishoShichosonPanel(ShoriTaishoShichosonPanelDiv ShoriTaishoShichosonPanel) {
        this.ShoriTaishoShichosonPanel = ShoriTaishoShichosonPanel;
    }

    /*
     * getShoriTaishoGetuPanel
     * @return ShoriTaishoGetuPanel
     */
    @JsonProperty("ShoriTaishoGetuPanel")
    public ShoriTaishoGetuPanelDiv getShoriTaishoGetuPanel() {
        return ShoriTaishoGetuPanel;
    }

    /*
     * setShoriTaishoGetuPanel
     * @param ShoriTaishoGetuPanel ShoriTaishoGetuPanel
     */
    @JsonProperty("ShoriTaishoGetuPanel")
    public void setShoriTaishoGetuPanel(ShoriTaishoGetuPanelDiv ShoriTaishoGetuPanel) {
        this.ShoriTaishoGetuPanel = ShoriTaishoGetuPanel;
    }

    /*
     * getPanelUpload
     * @return PanelUpload
     */
    @JsonProperty("PanelUpload")
    public PanelUploadDiv getPanelUpload() {
        return PanelUpload;
    }

    /*
     * setPanelUpload
     * @param PanelUpload PanelUpload
     */
    @JsonProperty("PanelUpload")
    public void setPanelUpload(PanelUploadDiv PanelUpload) {
        this.PanelUpload = PanelUpload;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getShoriJokyoPanel().getDdlShoriNendo();
    }

    @JsonIgnore
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getShoriJokyoPanel().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public RadioButton getGrpHyojikeishiki() {
        return this.getShoriJokyoPanel().getGrpHyojikeishiki();
    }

    @JsonIgnore
    public void setGrpHyojikeishiki(RadioButton grpHyojikeishiki) {
        this.getShoriJokyoPanel().setGrpHyojikeishiki(grpHyojikeishiki);
    }

    @JsonIgnore
    public ShichosonPanelDiv getShichosonPanel() {
        return this.getShoriJokyoPanel().getShichosonPanel();
    }

    @JsonIgnore
    public void setShichosonPanel(ShichosonPanelDiv ShichosonPanel) {
        this.getShoriJokyoPanel().setShichosonPanel(ShichosonPanel);
    }

    @JsonIgnore
    public DropDownList getDdlShichoson() {
        return this.getShoriJokyoPanel().getShichosonPanel().getDdlShichoson();
    }

    @JsonIgnore
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.getShoriJokyoPanel().getShichosonPanel().setDdlShichoson(ddlShichoson);
    }

    @JsonIgnore
    public GetuPanelDiv getGetuPanel() {
        return this.getShoriJokyoPanel().getGetuPanel();
    }

    @JsonIgnore
    public void setGetuPanel(GetuPanelDiv GetuPanel) {
        this.getShoriJokyoPanel().setGetuPanel(GetuPanel);
    }

    @JsonIgnore
    public DropDownList getDdlGetu() {
        return this.getShoriJokyoPanel().getGetuPanel().getDdlGetu();
    }

    @JsonIgnore
    public void setDdlGetu(DropDownList ddlGetu) {
        this.getShoriJokyoPanel().getGetuPanel().setDdlGetu(ddlGetu);
    }

    @JsonIgnore
    public TextBox getTxtTaisyoFile() {
        return this.getShoriJokyoPanel().getTxtTaisyoFile();
    }

    @JsonIgnore
    public void setTxtTaisyoFile(TextBox txtTaisyoFile) {
        this.getShoriJokyoPanel().setTxtTaisyoFile(txtTaisyoFile);
    }

    @JsonIgnore
    public DataGrid<dgGetuShoriSelect_Row> getDgGetuShoriSelect() {
        return this.getShoriTaishoShichosonPanel().getDgGetuShoriSelect();
    }

    @JsonIgnore
    public void setDgGetuShoriSelect(DataGrid<dgGetuShoriSelect_Row> dgGetuShoriSelect) {
        this.getShoriTaishoShichosonPanel().setDgGetuShoriSelect(dgGetuShoriSelect);
    }

    @JsonIgnore
    public DataGrid<dgShichosonShoriSelect_Row> getDgShichosonShoriSelect() {
        return this.getShoriTaishoGetuPanel().getDgShichosonShoriSelect();
    }

    @JsonIgnore
    public void setDgShichosonShoriSelect(DataGrid<dgShichosonShoriSelect_Row> dgShichosonShoriSelect) {
        this.getShoriTaishoGetuPanel().setDgShichosonShoriSelect(dgShichosonShoriSelect);
    }

    @JsonIgnore
    public UploadPanel getUpload() {
        return this.getPanelUpload().getUpload();
    }

    @JsonIgnore
    public void setUpload(UploadPanel upload) {
        this.getPanelUpload().setUpload(upload);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getPanelUpload().getBtnUpload();
    }

    @JsonIgnore
    public void setBtnUpload(Button btnUpload) {
        this.getPanelUpload().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}
