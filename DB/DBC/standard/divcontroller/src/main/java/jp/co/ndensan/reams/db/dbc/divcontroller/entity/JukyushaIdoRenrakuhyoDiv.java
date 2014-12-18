package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IJukyushaIdoRenrakuhyoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKihonJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyotakuServicePlanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoNijiyoboJigyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRojinHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoTeiseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoYokaigoninteiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoDiv extends Panel implements IJukyushaIdoRenrakuhyoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    private JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho;
    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    private JukyushaIdoRenrakuhyoTeiseiDiv JukyushaIdoRenrakuhyoTeisei;
    @JsonProperty("JukyushaIdoRenrakuhyoYokaigonintei")
    private JukyushaIdoRenrakuhyoYokaigoninteiDiv JukyushaIdoRenrakuhyoYokaigonintei;
    @JsonProperty("JukyushaIdoRenrakuhyoShikyugendoKijungaku")
    private JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv JukyushaIdoRenrakuhyoShikyugendoKijungaku;
    @JsonProperty("JukyushaIdoRenrakuhyoKyotakuServicePlan")
    private JukyushaIdoRenrakuhyoKyotakuServicePlanDiv JukyushaIdoRenrakuhyoKyotakuServicePlan;
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    private JukyushaIdoRenrakuhyoGemmenGengakuDiv JukyushaIdoRenrakuhyoGemmenGengaku;
    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    private JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    private JukyushaIdoRenrakuhyoKyufuSeigenDiv JukyushaIdoRenrakuhyoKyufuSeigen;
    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    private JukyushaIdoRenrakuhyoNijiyoboJigyoDiv JukyushaIdoRenrakuhyoNijiyoboJigyo;
    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    private JukyushaIdoRenrakuhyoRojinHokenDiv JukyushaIdoRenrakuhyoRojinHoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public JukyushaIdoRenrakuhyoKihonJohoDiv getJukyushaIdoRenrakuhyoKihonJoho() {
        return JukyushaIdoRenrakuhyoKihonJoho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public void setJukyushaIdoRenrakuhyoKihonJoho(JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho) {
        this.JukyushaIdoRenrakuhyoKihonJoho=JukyushaIdoRenrakuhyoKihonJoho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    public JukyushaIdoRenrakuhyoTeiseiDiv getJukyushaIdoRenrakuhyoTeisei() {
        return JukyushaIdoRenrakuhyoTeisei;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    public void setJukyushaIdoRenrakuhyoTeisei(JukyushaIdoRenrakuhyoTeiseiDiv JukyushaIdoRenrakuhyoTeisei) {
        this.JukyushaIdoRenrakuhyoTeisei=JukyushaIdoRenrakuhyoTeisei;
    }

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

    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    public JukyushaIdoRenrakuhyoGemmenGengakuDiv getJukyushaIdoRenrakuhyoGemmenGengaku() {
        return JukyushaIdoRenrakuhyoGemmenGengaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    public void setJukyushaIdoRenrakuhyoGemmenGengaku(JukyushaIdoRenrakuhyoGemmenGengakuDiv JukyushaIdoRenrakuhyoGemmenGengaku) {
        this.JukyushaIdoRenrakuhyoGemmenGengaku=JukyushaIdoRenrakuhyoGemmenGengaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    public JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv getJukyushaIdoRenrakuhyoKokiKoreiKokuho() {
        return JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokiKoreiKokuho")
    public void setJukyushaIdoRenrakuhyoKokiKoreiKokuho(JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv JukyushaIdoRenrakuhyoKokiKoreiKokuho) {
        this.JukyushaIdoRenrakuhyoKokiKoreiKokuho=JukyushaIdoRenrakuhyoKokiKoreiKokuho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    public JukyushaIdoRenrakuhyoKyufuSeigenDiv getJukyushaIdoRenrakuhyoKyufuSeigen() {
        return JukyushaIdoRenrakuhyoKyufuSeigen;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    public void setJukyushaIdoRenrakuhyoKyufuSeigen(JukyushaIdoRenrakuhyoKyufuSeigenDiv JukyushaIdoRenrakuhyoKyufuSeigen) {
        this.JukyushaIdoRenrakuhyoKyufuSeigen=JukyushaIdoRenrakuhyoKyufuSeigen;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    public JukyushaIdoRenrakuhyoNijiyoboJigyoDiv getJukyushaIdoRenrakuhyoNijiyoboJigyo() {
        return JukyushaIdoRenrakuhyoNijiyoboJigyo;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoNijiyoboJigyo")
    public void setJukyushaIdoRenrakuhyoNijiyoboJigyo(JukyushaIdoRenrakuhyoNijiyoboJigyoDiv JukyushaIdoRenrakuhyoNijiyoboJigyo) {
        this.JukyushaIdoRenrakuhyoNijiyoboJigyo=JukyushaIdoRenrakuhyoNijiyoboJigyo;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    public JukyushaIdoRenrakuhyoRojinHokenDiv getJukyushaIdoRenrakuhyoRojinHoken() {
        return JukyushaIdoRenrakuhyoRojinHoken;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoRojinHoken")
    public void setJukyushaIdoRenrakuhyoRojinHoken(JukyushaIdoRenrakuhyoRojinHokenDiv JukyushaIdoRenrakuhyoRojinHoken) {
        this.JukyushaIdoRenrakuhyoRojinHoken=JukyushaIdoRenrakuhyoRojinHoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getHorizontalLine1() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getHorizontalLine1();
    }

    @JsonIgnore
    public void  setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.getJukyushaIdoRenrakuhyoTeisei().setHorizontalLine1(HorizontalLine1);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate1() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getTextBoxDate1();
    }

    @JsonIgnore
    public void  setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.getJukyushaIdoRenrakuhyoTeisei().setTextBoxDate1(TextBoxDate1);
    }

    @JsonIgnore
    public RadioButton getRadioButton1() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getRadioButton1();
    }

    @JsonIgnore
    public void  setRadioButton1(RadioButton RadioButton1) {
        this.getJukyushaIdoRenrakuhyoTeisei().setRadioButton1(RadioButton1);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine2() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getHorizontalLine2();
    }

    @JsonIgnore
    public void  setHorizontalLine2(HorizontalLine HorizontalLine2) {
        this.getJukyushaIdoRenrakuhyoTeisei().setHorizontalLine2(HorizontalLine2);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
