package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * DBCommonInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBCommonInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaNoLabel")
    private Label HihokenshaNoLabel;
    @JsonProperty("HihokenshaNoText")
    private TextBox HihokenshaNoText;
    @JsonProperty("YokaigodoLabel")
    private Label YokaigodoLabel;
    @JsonProperty("YokaigodoText")
    private TextBox YokaigodoText;
    @JsonProperty("NinteiKikanLabel")
    private Label NinteiKikanLabel;
    @JsonProperty("NinteiKikanText")
    private TextBoxDateRange NinteiKikanText;
    @JsonProperty("KyuHihokenshaNoLabel")
    private Label KyuHihokenshaNoLabel;
    @JsonProperty("KyuHihokenshaNoText")
    private TextBox KyuHihokenshaNoText;
    @JsonProperty("KyuShichosonLabel")
    private Label KyuShichosonLabel;
    @JsonProperty("KyuShichosonCodeText")
    private TextBoxCode KyuShichosonCodeText;
    @JsonProperty("KyuShichosonText")
    private TextBox KyuShichosonText;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaNoLabel")
    public Label getHihokenshaNoLabel() {
        return HihokenshaNoLabel;
    }

    @JsonProperty("HihokenshaNoLabel")
    public void setHihokenshaNoLabel(Label HihokenshaNoLabel) {
        this.HihokenshaNoLabel=HihokenshaNoLabel;
    }

    @JsonProperty("HihokenshaNoText")
    public TextBox getHihokenshaNoText() {
        return HihokenshaNoText;
    }

    @JsonProperty("HihokenshaNoText")
    public void setHihokenshaNoText(TextBox HihokenshaNoText) {
        this.HihokenshaNoText=HihokenshaNoText;
    }

    @JsonProperty("YokaigodoLabel")
    public Label getYokaigodoLabel() {
        return YokaigodoLabel;
    }

    @JsonProperty("YokaigodoLabel")
    public void setYokaigodoLabel(Label YokaigodoLabel) {
        this.YokaigodoLabel=YokaigodoLabel;
    }

    @JsonProperty("YokaigodoText")
    public TextBox getYokaigodoText() {
        return YokaigodoText;
    }

    @JsonProperty("YokaigodoText")
    public void setYokaigodoText(TextBox YokaigodoText) {
        this.YokaigodoText=YokaigodoText;
    }

    @JsonProperty("NinteiKikanLabel")
    public Label getNinteiKikanLabel() {
        return NinteiKikanLabel;
    }

    @JsonProperty("NinteiKikanLabel")
    public void setNinteiKikanLabel(Label NinteiKikanLabel) {
        this.NinteiKikanLabel=NinteiKikanLabel;
    }

    @JsonProperty("NinteiKikanText")
    public TextBoxDateRange getNinteiKikanText() {
        return NinteiKikanText;
    }

    @JsonProperty("NinteiKikanText")
    public void setNinteiKikanText(TextBoxDateRange NinteiKikanText) {
        this.NinteiKikanText=NinteiKikanText;
    }

    @JsonProperty("KyuHihokenshaNoLabel")
    public Label getKyuHihokenshaNoLabel() {
        return KyuHihokenshaNoLabel;
    }

    @JsonProperty("KyuHihokenshaNoLabel")
    public void setKyuHihokenshaNoLabel(Label KyuHihokenshaNoLabel) {
        this.KyuHihokenshaNoLabel=KyuHihokenshaNoLabel;
    }

    @JsonProperty("KyuHihokenshaNoText")
    public TextBox getKyuHihokenshaNoText() {
        return KyuHihokenshaNoText;
    }

    @JsonProperty("KyuHihokenshaNoText")
    public void setKyuHihokenshaNoText(TextBox KyuHihokenshaNoText) {
        this.KyuHihokenshaNoText=KyuHihokenshaNoText;
    }

    @JsonProperty("KyuShichosonLabel")
    public Label getKyuShichosonLabel() {
        return KyuShichosonLabel;
    }

    @JsonProperty("KyuShichosonLabel")
    public void setKyuShichosonLabel(Label KyuShichosonLabel) {
        this.KyuShichosonLabel=KyuShichosonLabel;
    }

    @JsonProperty("KyuShichosonCodeText")
    public TextBoxCode getKyuShichosonCodeText() {
        return KyuShichosonCodeText;
    }

    @JsonProperty("KyuShichosonCodeText")
    public void setKyuShichosonCodeText(TextBoxCode KyuShichosonCodeText) {
        this.KyuShichosonCodeText=KyuShichosonCodeText;
    }

    @JsonProperty("KyuShichosonText")
    public TextBox getKyuShichosonText() {
        return KyuShichosonText;
    }

    @JsonProperty("KyuShichosonText")
    public void setKyuShichosonText(TextBox KyuShichosonText) {
        this.KyuShichosonText=KyuShichosonText;
    }

}
