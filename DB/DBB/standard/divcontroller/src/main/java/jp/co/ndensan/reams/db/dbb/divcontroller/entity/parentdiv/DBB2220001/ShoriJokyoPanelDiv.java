package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ShoriJokyoPanel のクラスファイル
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class ShoriJokyoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriNendo")
    private DropDownList ddlShoriNendo;
    @JsonProperty("grpHyojikeishiki")
    private RadioButton grpHyojikeishiki;
    @JsonProperty("ShichosonPanel")
    private ShichosonPanelDiv ShichosonPanel;
    @JsonProperty("GetuPanel")
    private GetuPanelDiv GetuPanel;
    @JsonProperty("txtTaisyoFile")
    private TextBox txtTaisyoFile;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShoriNendo
     * @return ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public DropDownList getDdlShoriNendo() {
        return ddlShoriNendo;
    }

    /*
     * setddlShoriNendo
     * @param ddlShoriNendo ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.ddlShoriNendo = ddlShoriNendo;
    }

    /*
     * getgrpHyojikeishiki
     * @return grpHyojikeishiki
     */
    @JsonProperty("grpHyojikeishiki")
    public RadioButton getGrpHyojikeishiki() {
        return grpHyojikeishiki;
    }

    /*
     * setgrpHyojikeishiki
     * @param grpHyojikeishiki grpHyojikeishiki
     */
    @JsonProperty("grpHyojikeishiki")
    public void setGrpHyojikeishiki(RadioButton grpHyojikeishiki) {
        this.grpHyojikeishiki = grpHyojikeishiki;
    }

    /*
     * getShichosonPanel
     * @return ShichosonPanel
     */
    @JsonProperty("ShichosonPanel")
    public ShichosonPanelDiv getShichosonPanel() {
        return ShichosonPanel;
    }

    /*
     * setShichosonPanel
     * @param ShichosonPanel ShichosonPanel
     */
    @JsonProperty("ShichosonPanel")
    public void setShichosonPanel(ShichosonPanelDiv ShichosonPanel) {
        this.ShichosonPanel = ShichosonPanel;
    }

    /*
     * getGetuPanel
     * @return GetuPanel
     */
    @JsonProperty("GetuPanel")
    public GetuPanelDiv getGetuPanel() {
        return GetuPanel;
    }

    /*
     * setGetuPanel
     * @param GetuPanel GetuPanel
     */
    @JsonProperty("GetuPanel")
    public void setGetuPanel(GetuPanelDiv GetuPanel) {
        this.GetuPanel = GetuPanel;
    }

    /*
     * gettxtTaisyoFile
     * @return txtTaisyoFile
     */
    @JsonProperty("txtTaisyoFile")
    public TextBox getTxtTaisyoFile() {
        return txtTaisyoFile;
    }

    /*
     * settxtTaisyoFile
     * @param txtTaisyoFile txtTaisyoFile
     */
    @JsonProperty("txtTaisyoFile")
    public void setTxtTaisyoFile(TextBox txtTaisyoFile) {
        this.txtTaisyoFile = txtTaisyoFile;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShichoson() {
        return this.getShichosonPanel().getDdlShichoson();
    }

    @JsonIgnore
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.getShichosonPanel().setDdlShichoson(ddlShichoson);
    }

    @JsonIgnore
    public DropDownList getDdlGetu() {
        return this.getGetuPanel().getDdlGetu();
    }

    @JsonIgnore
    public void setDdlGetu(DropDownList ddlGetu) {
        this.getGetuPanel().setDdlGetu(ddlGetu);
    }

    // </editor-fold>
}
