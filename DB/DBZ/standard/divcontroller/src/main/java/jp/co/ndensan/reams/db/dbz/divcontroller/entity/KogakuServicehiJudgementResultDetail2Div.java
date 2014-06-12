package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * KogakuServicehiJudgementResultDetail2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuServicehiJudgementResultDetail2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBiko")
    private TextBox txtBiko;
    @JsonProperty("radJudgementMethod")
    private RadioButton radJudgementMethod;
    @JsonProperty("txtFushikyuRiyu")
    private TextBoxMultiLine txtFushikyuRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtBiko")
    public TextBox getTxtBiko() {
        return txtBiko;
    }

    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBox txtBiko) {
        this.txtBiko=txtBiko;
    }

    @JsonProperty("radJudgementMethod")
    public RadioButton getRadJudgementMethod() {
        return radJudgementMethod;
    }

    @JsonProperty("radJudgementMethod")
    public void setRadJudgementMethod(RadioButton radJudgementMethod) {
        this.radJudgementMethod=radJudgementMethod;
    }

    @JsonProperty("txtFushikyuRiyu")
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return txtFushikyuRiyu;
    }

    @JsonProperty("txtFushikyuRiyu")
    public void setTxtFushikyuRiyu(TextBoxMultiLine txtFushikyuRiyu) {
        this.txtFushikyuRiyu=txtFushikyuRiyu;
    }

}
