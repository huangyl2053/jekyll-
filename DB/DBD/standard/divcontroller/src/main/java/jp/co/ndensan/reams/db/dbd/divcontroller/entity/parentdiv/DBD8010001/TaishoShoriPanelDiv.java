package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoShoriPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoShoriPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TaishoShoriIchiranPanel")
    private TaishoShoriIchiranPanelDiv TaishoShoriIchiranPanel;
    @JsonProperty("ShoriSetteiPanel")
    private ShoriSetteiPanelDiv ShoriSetteiPanel;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;
    @JsonProperty("hdnNendo")
    private RString hdnNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTaishoShoriIchiranPanel
     * @return TaishoShoriIchiranPanel
     */
    @JsonProperty("TaishoShoriIchiranPanel")
    public TaishoShoriIchiranPanelDiv getTaishoShoriIchiranPanel() {
        return TaishoShoriIchiranPanel;
    }

    /*
     * setTaishoShoriIchiranPanel
     * @param TaishoShoriIchiranPanel TaishoShoriIchiranPanel
     */
    @JsonProperty("TaishoShoriIchiranPanel")
    public void setTaishoShoriIchiranPanel(TaishoShoriIchiranPanelDiv TaishoShoriIchiranPanel) {
        this.TaishoShoriIchiranPanel = TaishoShoriIchiranPanel;
    }

    /*
     * getShoriSetteiPanel
     * @return ShoriSetteiPanel
     */
    @JsonProperty("ShoriSetteiPanel")
    public ShoriSetteiPanelDiv getShoriSetteiPanel() {
        return ShoriSetteiPanel;
    }

    /*
     * setShoriSetteiPanel
     * @param ShoriSetteiPanel ShoriSetteiPanel
     */
    @JsonProperty("ShoriSetteiPanel")
    public void setShoriSetteiPanel(ShoriSetteiPanelDiv ShoriSetteiPanel) {
        this.ShoriSetteiPanel = ShoriSetteiPanel;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    /*
     * gethdnNendo
     * @return hdnNendo
     */
    @JsonProperty("hdnNendo")
    public RString getHdnNendo() {
        return hdnNendo;
    }

    /*
     * sethdnNendo
     * @param hdnNendo hdnNendo
     */
    @JsonProperty("hdnNendo")
    public void setHdnNendo(RString hdnNendo) {
        this.hdnNendo = hdnNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getTaishoShoriIchiranPanel().getDdlShoriNendo();
    }

    @JsonIgnore
    public void  setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getTaishoShoriIchiranPanel().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShichosonshitei() {
        return this.getTaishoShoriIchiranPanel().getDdlShichosonshitei();
    }

    @JsonIgnore
    public void  setDdlShichosonshitei(DropDownList ddlShichosonshitei) {
        this.getTaishoShoriIchiranPanel().setDdlShichosonshitei(ddlShichosonshitei);
    }

    @JsonIgnore
    public Button getBtnShoriSettei() {
        return this.getTaishoShoriIchiranPanel().getBtnShoriSettei();
    }

    @JsonIgnore
    public void  setBtnShoriSettei(Button btnShoriSettei) {
        this.getTaishoShoriIchiranPanel().setBtnShoriSettei(btnShoriSettei);
    }

    @JsonIgnore
    public DataGrid<dgTaishoShoriItchiran_Row> getDgTaishoShoriItchiran() {
        return this.getTaishoShoriIchiranPanel().getDgTaishoShoriItchiran();
    }

    @JsonIgnore
    public void  setDgTaishoShoriItchiran(DataGrid<dgTaishoShoriItchiran_Row> dgTaishoShoriItchiran) {
        this.getTaishoShoriIchiranPanel().setDgTaishoShoriItchiran(dgTaishoShoriItchiran);
    }

    @JsonIgnore
    public FuairuAppurodoDiv getFuairuAppurodo() {
        return this.getTaishoShoriIchiranPanel().getFuairuAppurodo();
    }

    @JsonIgnore
    public void  setFuairuAppurodo(FuairuAppurodoDiv FuairuAppurodo) {
        this.getTaishoShoriIchiranPanel().setFuairuAppurodo(FuairuAppurodo);
    }

    @JsonIgnore
    public UploadPanel getUplTaishoFuairu() {
        return this.getTaishoShoriIchiranPanel().getFuairuAppurodo().getUplTaishoFuairu();
    }

    @JsonIgnore
    public void  setUplTaishoFuairu(UploadPanel uplTaishoFuairu) {
        this.getTaishoShoriIchiranPanel().getFuairuAppurodo().setUplTaishoFuairu(uplTaishoFuairu);
    }

    @JsonIgnore
    public Button getBtnAppurodo() {
        return this.getTaishoShoriIchiranPanel().getFuairuAppurodo().getBtnAppurodo();
    }

    @JsonIgnore
    public void  setBtnAppurodo(Button btnAppurodo) {
        this.getTaishoShoriIchiranPanel().getFuairuAppurodo().setBtnAppurodo(btnAppurodo);
    }

    @JsonIgnore
    public TextBox getTxtShoriSetteiNendo() {
        return this.getShoriSetteiPanel().getTxtShoriSetteiNendo();
    }

    @JsonIgnore
    public void  setTxtShoriSetteiNendo(TextBox txtShoriSetteiNendo) {
        this.getShoriSetteiPanel().setTxtShoriSetteiNendo(txtShoriSetteiNendo);
    }

    @JsonIgnore
    public TextBox getTxtShichosonshitei() {
        return this.getShoriSetteiPanel().getTxtShichosonshitei();
    }

    @JsonIgnore
    public void  setTxtShichosonshitei(TextBox txtShichosonshitei) {
        this.getShoriSetteiPanel().setTxtShichosonshitei(txtShichosonshitei);
    }

    @JsonIgnore
    public DataGrid<dgShoriSettei_Row> getDgShoriSettei() {
        return this.getShoriSetteiPanel().getDgShoriSettei();
    }

    @JsonIgnore
    public void  setDgShoriSettei(DataGrid<dgShoriSettei_Row> dgShoriSettei) {
        this.getShoriSetteiPanel().setDgShoriSettei(dgShoriSettei);
    }

    // </editor-fold>
}
