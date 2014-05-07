package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyotakuServicePlanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoNijiyoboJigyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRojinHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoYokaigoninteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoSub1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoSub1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoYokaigonintei")
    private JukyushaIdoRenrakuhyoYokaigoninteiDiv JukyushaIdoRenrakuhyoYokaigonintei;
    @JsonProperty("JukyushaIdoRenrakuhyoShikyugendoKijungaku")
    private JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv JukyushaIdoRenrakuhyoShikyugendoKijungaku;
    @JsonProperty("JukyushaIdoRenrakuhyoKyotakuServicePlan")
    private JukyushaIdoRenrakuhyoKyotakuServicePlanDiv JukyushaIdoRenrakuhyoKyotakuServicePlan;
    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    private JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    private JukyushaIdoRenrakuhyoRojinHokenDiv JukyushaIdoRenrakuhyoRojinHoken;
    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    private JukyushaIdoRenrakuhyoNijiyoboJigyoDiv JukyushaIdoRenrakuhyoNijiyoboJigyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoYokaigonintei")
    public JukyushaIdoRenrakuhyoYokaigoninteiDiv getJukyushaIdoRenrakuhyoYokaigonintei() {
        return JukyushaIdoRenrakuhyoYokaigonintei;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoYokaigonintei")
    public void setJukyushaIdoRenrakuhyoYokaigonintei(JukyushaIdoRenrakuhyoYokaigoninteiDiv JukyushaIdoRenrakuhyoYokaigonintei) {
        this.JukyushaIdoRenrakuhyoYokaigonintei=JukyushaIdoRenrakuhyoYokaigonintei;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoShikyugendoKijungaku")
    public JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv getJukyushaIdoRenrakuhyoShikyugendoKijungaku() {
        return JukyushaIdoRenrakuhyoShikyugendoKijungaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoShikyugendoKijungaku")
    public void setJukyushaIdoRenrakuhyoShikyugendoKijungaku(JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv JukyushaIdoRenrakuhyoShikyugendoKijungaku) {
        this.JukyushaIdoRenrakuhyoShikyugendoKijungaku=JukyushaIdoRenrakuhyoShikyugendoKijungaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyotakuServicePlan")
    public JukyushaIdoRenrakuhyoKyotakuServicePlanDiv getJukyushaIdoRenrakuhyoKyotakuServicePlan() {
        return JukyushaIdoRenrakuhyoKyotakuServicePlan;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyotakuServicePlan")
    public void setJukyushaIdoRenrakuhyoKyotakuServicePlan(JukyushaIdoRenrakuhyoKyotakuServicePlanDiv JukyushaIdoRenrakuhyoKyotakuServicePlan) {
        this.JukyushaIdoRenrakuhyoKyotakuServicePlan=JukyushaIdoRenrakuhyoKyotakuServicePlan;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    public JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv getJukyushaIdoRenrakuhyoKokiKoreiKokuho() {
        return JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    public void setJukyushaIdoRenrakuhyoKokiKoreiKokuho(JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv JukyushaIdoRenrakuhyoKokiKoreiKokuho) {
        this.JukyushaIdoRenrakuhyoKokiKoreiKokuho=JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    public JukyushaIdoRenrakuhyoRojinHokenDiv getJukyushaIdoRenrakuhyoRojinHoken() {
        return JukyushaIdoRenrakuhyoRojinHoken;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    public void setJukyushaIdoRenrakuhyoRojinHoken(JukyushaIdoRenrakuhyoRojinHokenDiv JukyushaIdoRenrakuhyoRojinHoken) {
        this.JukyushaIdoRenrakuhyoRojinHoken=JukyushaIdoRenrakuhyoRojinHoken;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    public JukyushaIdoRenrakuhyoNijiyoboJigyoDiv getJukyushaIdoRenrakuhyoNijiyoboJigyo() {
        return JukyushaIdoRenrakuhyoNijiyoboJigyo;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    public void setJukyushaIdoRenrakuhyoNijiyoboJigyo(JukyushaIdoRenrakuhyoNijiyoboJigyoDiv JukyushaIdoRenrakuhyoNijiyoboJigyo) {
        this.JukyushaIdoRenrakuhyoNijiyoboJigyo=JukyushaIdoRenrakuhyoNijiyoboJigyo;
    }

}
