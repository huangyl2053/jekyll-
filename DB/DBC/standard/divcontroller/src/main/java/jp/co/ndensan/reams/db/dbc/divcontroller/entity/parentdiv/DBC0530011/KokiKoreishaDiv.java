package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * KokiKoreisha のクラスファイル
 *
 * @author 自動生成
 */
public class KokiKoreishaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HeaderPanel")
    private HeaderPanelDiv HeaderPanel;
    @JsonProperty("MeisaiPanel")
    private MeisaiPanelDiv MeisaiPanel;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getHeaderPanel
     * @return HeaderPanel
     */
    @JsonProperty("HeaderPanel")
    public HeaderPanelDiv getHeaderPanel() {
        return HeaderPanel;
    }

    /*
     * setHeaderPanel
     * @param HeaderPanel HeaderPanel
     */
    @JsonProperty("HeaderPanel")
    public void setHeaderPanel(HeaderPanelDiv HeaderPanel) {
        this.HeaderPanel = HeaderPanel;
    }

    /*
     * getMeisaiPanel
     * @return MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public MeisaiPanelDiv getMeisaiPanel() {
        return MeisaiPanel;
    }

    /*
     * setMeisaiPanel
     * @param MeisaiPanel MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public void setMeisaiPanel(MeisaiPanelDiv MeisaiPanel) {
        this.MeisaiPanel = MeisaiPanel;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoNinteiAtenaInfoDiv getCcdAtenaInfo() {
        return this.getHeaderPanel().getCcdAtenaInfo();
    }

    @JsonIgnore
    public IKaigoninteiShikakuInfoDiv getCcdShikakuInfo() {
        return this.getHeaderPanel().getCcdShikakuInfo();
    }

    @JsonIgnore
    public DropDownList getDdlHokenshaNo() {
        return this.getMeisaiPanel().getDdlHokenshaNo();
    }

    @JsonIgnore
    public void setDdlHokenshaNo(DropDownList ddlHokenshaNo) {
        this.getMeisaiPanel().setDdlHokenshaNo(ddlHokenshaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHokenshaKaishiYMD() {
        return this.getMeisaiPanel().getTxtHokenshaKaishiYMD();
    }

    @JsonIgnore
    public void setTxtHokenshaKaishiYMD(TextBoxDate txtHokenshaKaishiYMD) {
        this.getMeisaiPanel().setTxtHokenshaKaishiYMD(txtHokenshaKaishiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getMeisaiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getMeisaiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHokenshaShuryoYMD() {
        return this.getMeisaiPanel().getTxtHokenshaShuryoYMD();
    }

    @JsonIgnore
    public void setTxtHokenshaShuryoYMD(TextBoxDate txtHokenshaShuryoYMD) {
        this.getMeisaiPanel().setTxtHokenshaShuryoYMD(txtHokenshaShuryoYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMD() {
        return this.getMeisaiPanel().getTxtShikakuShutokuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuShutokuYMD(TextBoxDate txtShikakuShutokuYMD) {
        this.getMeisaiPanel().setTxtShikakuShutokuYMD(txtShikakuShutokuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuShutokuJiyu() {
        return this.getMeisaiPanel().getDdlShikakuShutokuJiyu();
    }

    @JsonIgnore
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.getMeisaiPanel().setDdlShikakuShutokuJiyu(ddlShikakuShutokuJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.getMeisaiPanel().getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.getMeisaiPanel().setTxtShikakuSoshitsuYMD(txtShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getMeisaiPanel().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getMeisaiPanel().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkTorokuKubun() {
        return this.getMeisaiPanel().getChkTorokuKubun();
    }

    @JsonIgnore
    public void setChkTorokuKubun(CheckBoxList chkTorokuKubun) {
        this.getMeisaiPanel().setChkTorokuKubun(chkTorokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlKojinKubunCode() {
        return this.getMeisaiPanel().getDdlKojinKubunCode();
    }

    @JsonIgnore
    public void setDdlKojinKubunCode(DropDownList ddlKojinKubunCode) {
        this.getMeisaiPanel().setDdlKojinKubunCode(ddlKojinKubunCode);
    }

    @JsonIgnore
    public TextBox getTxtRirekiNo() {
        return this.getMeisaiPanel().getTxtRirekiNo();
    }

    @JsonIgnore
    public void setTxtRirekiNo(TextBox txtRirekiNo) {
        this.getMeisaiPanel().setTxtRirekiNo(txtRirekiNo);
    }

    // </editor-fold>
}
