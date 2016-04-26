package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChushutsuJokenKotaku のクラスファイル
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class ChushutsuJokenKotakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSakuseiKubun")
    private RadioButton radSakuseiKubun;
    @JsonProperty("radChusyutuKubun")
    private RadioButton radChusyutuKubun;
    @JsonProperty("KijunYMDPanel")
    private KijunYMDPanelDiv KijunYMDPanel;
    @JsonProperty("txtSienJigyosyano")
    private TextBox txtSienJigyosyano;
    @JsonProperty("btnSienJigyosyano")
    private ButtonDialog btnSienJigyosyano;
    @JsonProperty("txtSienJigyosya")
    private TextBox txtSienJigyosya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSakuseiKubun
     * @return radSakuseiKubun
     */
    @JsonProperty("radSakuseiKubun")
    public RadioButton getRadSakuseiKubun() {
        return radSakuseiKubun;
    }

    /*
     * setradSakuseiKubun
     * @param radSakuseiKubun radSakuseiKubun
     */
    @JsonProperty("radSakuseiKubun")
    public void setRadSakuseiKubun(RadioButton radSakuseiKubun) {
        this.radSakuseiKubun = radSakuseiKubun;
    }

    /*
     * getradChusyutuKubun
     * @return radChusyutuKubun
     */
    @JsonProperty("radChusyutuKubun")
    public RadioButton getRadChusyutuKubun() {
        return radChusyutuKubun;
    }

    /*
     * setradChusyutuKubun
     * @param radChusyutuKubun radChusyutuKubun
     */
    @JsonProperty("radChusyutuKubun")
    public void setRadChusyutuKubun(RadioButton radChusyutuKubun) {
        this.radChusyutuKubun = radChusyutuKubun;
    }

    /*
     * getKijunYMDPanel
     * @return KijunYMDPanel
     */
    @JsonProperty("KijunYMDPanel")
    public KijunYMDPanelDiv getKijunYMDPanel() {
        return KijunYMDPanel;
    }

    /*
     * setKijunYMDPanel
     * @param KijunYMDPanel KijunYMDPanel
     */
    @JsonProperty("KijunYMDPanel")
    public void setKijunYMDPanel(KijunYMDPanelDiv KijunYMDPanel) {
        this.KijunYMDPanel = KijunYMDPanel;
    }

    /*
     * gettxtSienJigyosyano
     * @return txtSienJigyosyano
     */
    @JsonProperty("txtSienJigyosyano")
    public TextBox getTxtSienJigyosyano() {
        return txtSienJigyosyano;
    }

    /*
     * settxtSienJigyosyano
     * @param txtSienJigyosyano txtSienJigyosyano
     */
    @JsonProperty("txtSienJigyosyano")
    public void setTxtSienJigyosyano(TextBox txtSienJigyosyano) {
        this.txtSienJigyosyano = txtSienJigyosyano;
    }

    /*
     * getbtnSienJigyosyano
     * @return btnSienJigyosyano
     */
    @JsonProperty("btnSienJigyosyano")
    public ButtonDialog getBtnSienJigyosyano() {
        return btnSienJigyosyano;
    }

    /*
     * setbtnSienJigyosyano
     * @param btnSienJigyosyano btnSienJigyosyano
     */
    @JsonProperty("btnSienJigyosyano")
    public void setBtnSienJigyosyano(ButtonDialog btnSienJigyosyano) {
        this.btnSienJigyosyano = btnSienJigyosyano;
    }

    /*
     * gettxtSienJigyosya
     * @return txtSienJigyosya
     */
    @JsonProperty("txtSienJigyosya")
    public TextBox getTxtSienJigyosya() {
        return txtSienJigyosya;
    }

    /*
     * settxtSienJigyosya
     * @param txtSienJigyosya txtSienJigyosya
     */
    @JsonProperty("txtSienJigyosya")
    public void setTxtSienJigyosya(TextBox txtSienJigyosya) {
        this.txtSienJigyosya = txtSienJigyosya;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getChusyutuKubunSpace() {
        return this.getKijunYMDPanel().getChusyutuKubunSpace();
    }

    @JsonIgnore
    public void setChusyutuKubunSpace(Space ChusyutuKubunSpace) {
        this.getKijunYMDPanel().setChusyutuKubunSpace(ChusyutuKubunSpace);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunYMD() {
        return this.getKijunYMDPanel().getTxtKijunYMD();
    }

    @JsonIgnore
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.getKijunYMDPanel().setTxtKijunYMD(txtKijunYMD);
    }

    // </editor-fold>
}
