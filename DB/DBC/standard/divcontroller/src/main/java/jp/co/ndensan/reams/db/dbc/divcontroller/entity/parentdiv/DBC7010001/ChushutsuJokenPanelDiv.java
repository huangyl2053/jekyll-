package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseiKubunPanel")
    private SakuseiKubunPanelDiv SakuseiKubunPanel;
    @JsonProperty("ChushutsuJokenKotaku")
    private ChushutsuJokenKotakuDiv ChushutsuJokenKotaku;
    @JsonProperty("hiddenJigyoshaMode")
    private RString hiddenJigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseiKubunPanel
     * @return SakuseiKubunPanel
     */
    @JsonProperty("SakuseiKubunPanel")
    public SakuseiKubunPanelDiv getSakuseiKubunPanel() {
        return SakuseiKubunPanel;
    }

    /*
     * setSakuseiKubunPanel
     * @param SakuseiKubunPanel SakuseiKubunPanel
     */
    @JsonProperty("SakuseiKubunPanel")
    public void setSakuseiKubunPanel(SakuseiKubunPanelDiv SakuseiKubunPanel) {
        this.SakuseiKubunPanel = SakuseiKubunPanel;
    }

    /*
     * getChushutsuJokenKotaku
     * @return ChushutsuJokenKotaku
     */
    @JsonProperty("ChushutsuJokenKotaku")
    public ChushutsuJokenKotakuDiv getChushutsuJokenKotaku() {
        return ChushutsuJokenKotaku;
    }

    /*
     * setChushutsuJokenKotaku
     * @param ChushutsuJokenKotaku ChushutsuJokenKotaku
     */
    @JsonProperty("ChushutsuJokenKotaku")
    public void setChushutsuJokenKotaku(ChushutsuJokenKotakuDiv ChushutsuJokenKotaku) {
        this.ChushutsuJokenKotaku = ChushutsuJokenKotaku;
    }

    /*
     * gethiddenJigyoshaMode
     * @return hiddenJigyoshaMode
     */
    @JsonProperty("hiddenJigyoshaMode")
    public RString getHiddenJigyoshaMode() {
        return hiddenJigyoshaMode;
    }

    /*
     * sethiddenJigyoshaMode
     * @param hiddenJigyoshaMode hiddenJigyoshaMode
     */
    @JsonProperty("hiddenJigyoshaMode")
    public void setHiddenJigyoshaMode(RString hiddenJigyoshaMode) {
        this.hiddenJigyoshaMode = hiddenJigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getSakuseiKubunPanel().getCcdHokensya();
    }

    @JsonIgnore
    public RadioButton getRadSakuseiKubun() {
        return this.getChushutsuJokenKotaku().getRadSakuseiKubun();
    }

    @JsonIgnore
    public void setRadSakuseiKubun(RadioButton radSakuseiKubun) {
        this.getChushutsuJokenKotaku().setRadSakuseiKubun(radSakuseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadChusyutuKubun() {
        return this.getChushutsuJokenKotaku().getRadChusyutuKubun();
    }

    @JsonIgnore
    public void setRadChusyutuKubun(RadioButton radChusyutuKubun) {
        this.getChushutsuJokenKotaku().setRadChusyutuKubun(radChusyutuKubun);
    }

    @JsonIgnore
    public KijunYMDPanelDiv getKijunYMDPanel() {
        return this.getChushutsuJokenKotaku().getKijunYMDPanel();
    }

    @JsonIgnore
    public void setKijunYMDPanel(KijunYMDPanelDiv KijunYMDPanel) {
        this.getChushutsuJokenKotaku().setKijunYMDPanel(KijunYMDPanel);
    }

    @JsonIgnore
    public Space getChusyutuKubunSpace() {
        return this.getChushutsuJokenKotaku().getKijunYMDPanel().getChusyutuKubunSpace();
    }

    @JsonIgnore
    public void setChusyutuKubunSpace(Space ChusyutuKubunSpace) {
        this.getChushutsuJokenKotaku().getKijunYMDPanel().setChusyutuKubunSpace(ChusyutuKubunSpace);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunYMD() {
        return this.getChushutsuJokenKotaku().getKijunYMDPanel().getTxtKijunYMD();
    }

    @JsonIgnore
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.getChushutsuJokenKotaku().getKijunYMDPanel().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBox getTxtSienJigyosyano() {
        return this.getChushutsuJokenKotaku().getTxtSienJigyosyano();
    }

    @JsonIgnore
    public void setTxtSienJigyosyano(TextBox txtSienJigyosyano) {
        this.getChushutsuJokenKotaku().setTxtSienJigyosyano(txtSienJigyosyano);
    }

    @JsonIgnore
    public ButtonDialog getBtnSienJigyosyano() {
        return this.getChushutsuJokenKotaku().getBtnSienJigyosyano();
    }

    @JsonIgnore
    public void setBtnSienJigyosyano(ButtonDialog btnSienJigyosyano) {
        this.getChushutsuJokenKotaku().setBtnSienJigyosyano(btnSienJigyosyano);
    }

    @JsonIgnore
    public TextBox getTxtSienJigyosya() {
        return this.getChushutsuJokenKotaku().getTxtSienJigyosya();
    }

    @JsonIgnore
    public void setTxtSienJigyosya(TextBox txtSienJigyosya) {
        this.getChushutsuJokenKotaku().setTxtSienJigyosya(txtSienJigyosya);
    }

    // </editor-fold>
}
