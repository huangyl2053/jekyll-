package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoKyotakuServicePlan のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKyotakuServicePlanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblPlanSakuseiKubun")
    private Label lblPlanSakuseiKubun;
    @JsonProperty("radPlanSakuseiKubun")
    private RadioButton radPlanSakuseiKubun;
    @JsonProperty("lblShienJigyosha")
    private Label lblShienJigyosha;
    @JsonProperty("txtShienJigyoshaNo")
    private TextBoxCode txtShienJigyoshaNo;
    @JsonProperty("txtShienJigyoshaName")
    private TextBoxKana txtShienJigyoshaName;
    @JsonProperty("txtKyotakuServicePlanTekiyoDateRange")
    private TextBoxDateRange txtKyotakuServicePlanTekiyoDateRange;
    @JsonProperty("lblShokiboKyotakuServiceRiyoUmu")
    private Label lblShokiboKyotakuServiceRiyoUmu;
    @JsonProperty("radShokiboKyotakuServiceRiyoUmu")
    private RadioButton radShokiboKyotakuServiceRiyoUmu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblPlanSakuseiKubun")
    public Label getLblPlanSakuseiKubun() {
        return lblPlanSakuseiKubun;
    }

    @JsonProperty("lblPlanSakuseiKubun")
    public void setLblPlanSakuseiKubun(Label lblPlanSakuseiKubun) {
        this.lblPlanSakuseiKubun=lblPlanSakuseiKubun;
    }

    @JsonProperty("radPlanSakuseiKubun")
    public RadioButton getRadPlanSakuseiKubun() {
        return radPlanSakuseiKubun;
    }

    @JsonProperty("radPlanSakuseiKubun")
    public void setRadPlanSakuseiKubun(RadioButton radPlanSakuseiKubun) {
        this.radPlanSakuseiKubun=radPlanSakuseiKubun;
    }

    @JsonProperty("lblShienJigyosha")
    public Label getLblShienJigyosha() {
        return lblShienJigyosha;
    }

    @JsonProperty("lblShienJigyosha")
    public void setLblShienJigyosha(Label lblShienJigyosha) {
        this.lblShienJigyosha=lblShienJigyosha;
    }

    @JsonProperty("txtShienJigyoshaNo")
    public TextBoxCode getTxtShienJigyoshaNo() {
        return txtShienJigyoshaNo;
    }

    @JsonProperty("txtShienJigyoshaNo")
    public void setTxtShienJigyoshaNo(TextBoxCode txtShienJigyoshaNo) {
        this.txtShienJigyoshaNo=txtShienJigyoshaNo;
    }

    @JsonProperty("txtShienJigyoshaName")
    public TextBoxKana getTxtShienJigyoshaName() {
        return txtShienJigyoshaName;
    }

    @JsonProperty("txtShienJigyoshaName")
    public void setTxtShienJigyoshaName(TextBoxKana txtShienJigyoshaName) {
        this.txtShienJigyoshaName=txtShienJigyoshaName;
    }

    @JsonProperty("txtKyotakuServicePlanTekiyoDateRange")
    public TextBoxDateRange getTxtKyotakuServicePlanTekiyoDateRange() {
        return txtKyotakuServicePlanTekiyoDateRange;
    }

    @JsonProperty("txtKyotakuServicePlanTekiyoDateRange")
    public void setTxtKyotakuServicePlanTekiyoDateRange(TextBoxDateRange txtKyotakuServicePlanTekiyoDateRange) {
        this.txtKyotakuServicePlanTekiyoDateRange=txtKyotakuServicePlanTekiyoDateRange;
    }

    @JsonProperty("lblShokiboKyotakuServiceRiyoUmu")
    public Label getLblShokiboKyotakuServiceRiyoUmu() {
        return lblShokiboKyotakuServiceRiyoUmu;
    }

    @JsonProperty("lblShokiboKyotakuServiceRiyoUmu")
    public void setLblShokiboKyotakuServiceRiyoUmu(Label lblShokiboKyotakuServiceRiyoUmu) {
        this.lblShokiboKyotakuServiceRiyoUmu=lblShokiboKyotakuServiceRiyoUmu;
    }

    @JsonProperty("radShokiboKyotakuServiceRiyoUmu")
    public RadioButton getRadShokiboKyotakuServiceRiyoUmu() {
        return radShokiboKyotakuServiceRiyoUmu;
    }

    @JsonProperty("radShokiboKyotakuServiceRiyoUmu")
    public void setRadShokiboKyotakuServiceRiyoUmu(RadioButton radShokiboKyotakuServiceRiyoUmu) {
        this.radShokiboKyotakuServiceRiyoUmu=radShokiboKyotakuServiceRiyoUmu;
    }

}
