package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KonkaiShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-1850-010 zhangrui
 */
public class KonkaiShoriNaiyoDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShutokuM")
    private TextBoxDate txtShutokuM;
    @JsonProperty("txtHosokuM1")
    private TextBoxDate txtHosokuM1;
    @JsonProperty("HosokuMKoikiPanel")
    private HosokuMKoikiPanelDiv HosokuMKoikiPanel;
    @JsonProperty("txtKaishiM")
    private TextBoxDate txtKaishiM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShutokuM
     * @return txtShutokuM
     */
    @JsonProperty("txtShutokuM")
    public TextBoxDate getTxtShutokuM() {
        return txtShutokuM;
    }

    /*
     * settxtShutokuM
     * @param txtShutokuM txtShutokuM
     */
    @JsonProperty("txtShutokuM")
    public void setTxtShutokuM(TextBoxDate txtShutokuM) {
        this.txtShutokuM = txtShutokuM;
    }

    /*
     * gettxtHosokuM1
     * @return txtHosokuM1
     */
    @JsonProperty("txtHosokuM1")
    public TextBoxDate getTxtHosokuM1() {
        return txtHosokuM1;
    }

    /*
     * settxtHosokuM1
     * @param txtHosokuM1 txtHosokuM1
     */
    @JsonProperty("txtHosokuM1")
    public void setTxtHosokuM1(TextBoxDate txtHosokuM1) {
        this.txtHosokuM1 = txtHosokuM1;
    }

    /*
     * getHosokuMKoikiPanel
     * @return HosokuMKoikiPanel
     */
    @JsonProperty("HosokuMKoikiPanel")
    public HosokuMKoikiPanelDiv getHosokuMKoikiPanel() {
        return HosokuMKoikiPanel;
    }

    /*
     * setHosokuMKoikiPanel
     * @param HosokuMKoikiPanel HosokuMKoikiPanel
     */
    @JsonProperty("HosokuMKoikiPanel")
    public void setHosokuMKoikiPanel(HosokuMKoikiPanelDiv HosokuMKoikiPanel) {
        this.HosokuMKoikiPanel = HosokuMKoikiPanel;
    }

    /*
     * gettxtKaishiM
     * @return txtKaishiM
     */
    @JsonProperty("txtKaishiM")
    public TextBoxDate getTxtKaishiM() {
        return txtKaishiM;
    }

    /*
     * settxtKaishiM
     * @param txtKaishiM txtKaishiM
     */
    @JsonProperty("txtKaishiM")
    public void setTxtKaishiM(TextBoxDate txtKaishiM) {
        this.txtKaishiM = txtKaishiM;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHosokuM2() {
        return this.getHosokuMKoikiPanel().getTxtHosokuM2();
    }

    @JsonIgnore
    public void setTxtHosokuM2(TextBox txtHosokuM2) {
        this.getHosokuMKoikiPanel().setTxtHosokuM2(txtHosokuM2);
    }

    @JsonIgnore
    public TextBox getTxtHosokuM3() {
        return this.getHosokuMKoikiPanel().getTxtHosokuM3();
    }

    @JsonIgnore
    public void setTxtHosokuM3(TextBox txtHosokuM3) {
        this.getHosokuMKoikiPanel().setTxtHosokuM3(txtHosokuM3);
    }

    // </editor-fold>
}
