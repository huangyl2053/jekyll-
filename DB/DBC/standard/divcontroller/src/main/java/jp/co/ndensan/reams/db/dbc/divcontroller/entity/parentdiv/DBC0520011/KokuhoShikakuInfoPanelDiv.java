package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KokuhoShikakuInfoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class KokuhoShikakuInfoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("headerPanel")
    private headerPanelDiv headerPanel;
    @JsonProperty("meisaiPanel")
    private meisaiPanelDiv meisaiPanel;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getheaderPanel
     * @return headerPanel
     */
    @JsonProperty("headerPanel")
    public headerPanelDiv getHeaderPanel() {
        return headerPanel;
    }

    /*
     * setheaderPanel
     * @param headerPanel headerPanel
     */
    @JsonProperty("headerPanel")
    public void setHeaderPanel(headerPanelDiv headerPanel) {
        this.headerPanel = headerPanel;
    }

    /*
     * getmeisaiPanel
     * @return meisaiPanel
     */
    @JsonProperty("meisaiPanel")
    public meisaiPanelDiv getMeisaiPanel() {
        return meisaiPanel;
    }

    /*
     * setmeisaiPanel
     * @param meisaiPanel meisaiPanel
     */
    @JsonProperty("meisaiPanel")
    public void setMeisaiPanel(meisaiPanelDiv meisaiPanel) {
        this.meisaiPanel = meisaiPanel;
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
    public DropDownList getDdlKokuhoHokenshaNo() {
        return this.getMeisaiPanel().getDdlKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void setDdlKokuhoHokenshaNo(DropDownList ddlKokuhoHokenshaNo) {
        this.getMeisaiPanel().setDdlKokuhoHokenshaNo(ddlKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishokuGaitoYMD() {
        return this.getMeisaiPanel().getTxtTaishokuGaitoYMD();
    }

    @JsonIgnore
    public void setTxtTaishokuGaitoYMD(TextBoxDate txtTaishokuGaitoYMD) {
        this.getMeisaiPanel().setTxtTaishokuGaitoYMD(txtTaishokuGaitoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtKokuhoHokenshoNo() {
        return this.getMeisaiPanel().getTxtKokuhoHokenshoNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshoNo(TextBoxNum txtKokuhoHokenshoNo) {
        this.getMeisaiPanel().setTxtKokuhoHokenshoNo(txtKokuhoHokenshoNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishokuHigaitoYMD() {
        return this.getMeisaiPanel().getTxtTaishokuHigaitoYMD();
    }

    @JsonIgnore
    public void setTxtTaishokuHigaitoYMD(TextBoxDate txtTaishokuHigaitoYMD) {
        this.getMeisaiPanel().setTxtTaishokuHigaitoYMD(txtTaishokuHigaitoYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtKokuhoKojinNo() {
        return this.getMeisaiPanel().getTxtKokuhoKojinNo();
    }

    @JsonIgnore
    public void setTxtKokuhoKojinNo(TextBoxCode txtKokuhoKojinNo) {
        this.getMeisaiPanel().setTxtKokuhoKojinNo(txtKokuhoKojinNo);
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
    public TextBoxDate getTxtShikakuShutokuYMD() {
        return this.getMeisaiPanel().getTxtShikakuShutokuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuShutokuYMD(TextBoxDate txtShikakuShutokuYMD) {
        this.getMeisaiPanel().setTxtShikakuShutokuYMD(txtShikakuShutokuYMD);
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
    public TextBoxCode getTxtKokuhoNo() {
        return this.getMeisaiPanel().getTxtKokuhoNo();
    }

    @JsonIgnore
    public void setTxtKokuhoNo(TextBoxCode txtKokuhoNo) {
        this.getMeisaiPanel().setTxtKokuhoNo(txtKokuhoNo);
    }

    @JsonIgnore
    public CheckBoxList getChkTorokuKubun() {
        return this.getMeisaiPanel().getChkTorokuKubun();
    }

    @JsonIgnore
    public void setChkTorokuKubun(CheckBoxList chkTorokuKubun) {
        this.getMeisaiPanel().setChkTorokuKubun(chkTorokuKubun);
    }

    // </editor-fold>
}
