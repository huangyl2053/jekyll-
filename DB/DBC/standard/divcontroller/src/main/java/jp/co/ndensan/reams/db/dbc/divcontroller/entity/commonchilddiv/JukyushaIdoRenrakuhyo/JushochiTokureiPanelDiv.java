package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JushochiTokureiPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JushochiTokureiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    private RadioButton radJushochiTokureiTaishoshaKubun;
    @JsonProperty("txtJushochiTokureiTekiyoYMD")
    private TextBoxDateRange txtJushochiTokureiTekiyoYMD;
    @JsonProperty("HokenshaJohoPanel")
    private HokenshaJohoPanelDiv HokenshaJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushochiTokureiTaishoshaKubun
     * @return radJushochiTokureiTaishoshaKubun
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    public RadioButton getRadJushochiTokureiTaishoshaKubun() {
        return radJushochiTokureiTaishoshaKubun;
    }

    /*
     * setradJushochiTokureiTaishoshaKubun
     * @param radJushochiTokureiTaishoshaKubun radJushochiTokureiTaishoshaKubun
     */
    @JsonProperty("radJushochiTokureiTaishoshaKubun")
    public void setRadJushochiTokureiTaishoshaKubun(RadioButton radJushochiTokureiTaishoshaKubun) {
        this.radJushochiTokureiTaishoshaKubun = radJushochiTokureiTaishoshaKubun;
    }

    /*
     * gettxtJushochiTokureiTekiyoYMD
     * @return txtJushochiTokureiTekiyoYMD
     */
    @JsonProperty("txtJushochiTokureiTekiyoYMD")
    public TextBoxDateRange getTxtJushochiTokureiTekiyoYMD() {
        return txtJushochiTokureiTekiyoYMD;
    }

    /*
     * settxtJushochiTokureiTekiyoYMD
     * @param txtJushochiTokureiTekiyoYMD txtJushochiTokureiTekiyoYMD
     */
    @JsonProperty("txtJushochiTokureiTekiyoYMD")
    public void setTxtJushochiTokureiTekiyoYMD(TextBoxDateRange txtJushochiTokureiTekiyoYMD) {
        this.txtJushochiTokureiTekiyoYMD = txtJushochiTokureiTekiyoYMD;
    }

    /*
     * getHokenshaJohoPanel
     * @return HokenshaJohoPanel
     */
    @JsonProperty("HokenshaJohoPanel")
    public HokenshaJohoPanelDiv getHokenshaJohoPanel() {
        return HokenshaJohoPanel;
    }

    /*
     * setHokenshaJohoPanel
     * @param HokenshaJohoPanel HokenshaJohoPanel
     */
    @JsonProperty("HokenshaJohoPanel")
    public void setHokenshaJohoPanel(HokenshaJohoPanelDiv HokenshaJohoPanel) {
        this.HokenshaJohoPanel = HokenshaJohoPanel;
    }

    // </editor-fold>
}
