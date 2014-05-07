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
 * JukyushaIdoRenrakuhyoYokaigonintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoYokaigoninteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinseiType")
    private Label lblShinseiType;
    @JsonProperty("radShinseiType")
    private RadioButton radShinseiType;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("lblHenkoShinseichuKubun")
    private Label lblHenkoShinseichuKubun;
    @JsonProperty("radHenkoShinseichuKubun")
    private RadioButton radHenkoShinseichuKubun;
    @JsonProperty("lblMinashiYokaigoKubun")
    private Label lblMinashiYokaigoKubun;
    @JsonProperty("radMinashiYokaigoKubun")
    private RadioButton radMinashiYokaigoKubun;
    @JsonProperty("txtNinteiDateRange")
    private TextBoxDateRange txtNinteiDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseiType")
    public Label getLblShinseiType() {
        return lblShinseiType;
    }

    @JsonProperty("lblShinseiType")
    public void setLblShinseiType(Label lblShinseiType) {
        this.lblShinseiType=lblShinseiType;
    }

    @JsonProperty("radShinseiType")
    public RadioButton getRadShinseiType() {
        return radShinseiType;
    }

    @JsonProperty("radShinseiType")
    public void setRadShinseiType(RadioButton radShinseiType) {
        this.radShinseiType=radShinseiType;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("lblHenkoShinseichuKubun")
    public Label getLblHenkoShinseichuKubun() {
        return lblHenkoShinseichuKubun;
    }

    @JsonProperty("lblHenkoShinseichuKubun")
    public void setLblHenkoShinseichuKubun(Label lblHenkoShinseichuKubun) {
        this.lblHenkoShinseichuKubun=lblHenkoShinseichuKubun;
    }

    @JsonProperty("radHenkoShinseichuKubun")
    public RadioButton getRadHenkoShinseichuKubun() {
        return radHenkoShinseichuKubun;
    }

    @JsonProperty("radHenkoShinseichuKubun")
    public void setRadHenkoShinseichuKubun(RadioButton radHenkoShinseichuKubun) {
        this.radHenkoShinseichuKubun=radHenkoShinseichuKubun;
    }

    @JsonProperty("lblMinashiYokaigoKubun")
    public Label getLblMinashiYokaigoKubun() {
        return lblMinashiYokaigoKubun;
    }

    @JsonProperty("lblMinashiYokaigoKubun")
    public void setLblMinashiYokaigoKubun(Label lblMinashiYokaigoKubun) {
        this.lblMinashiYokaigoKubun=lblMinashiYokaigoKubun;
    }

    @JsonProperty("radMinashiYokaigoKubun")
    public RadioButton getRadMinashiYokaigoKubun() {
        return radMinashiYokaigoKubun;
    }

    @JsonProperty("radMinashiYokaigoKubun")
    public void setRadMinashiYokaigoKubun(RadioButton radMinashiYokaigoKubun) {
        this.radMinashiYokaigoKubun=radMinashiYokaigoKubun;
    }

    @JsonProperty("txtNinteiDateRange")
    public TextBoxDateRange getTxtNinteiDateRange() {
        return txtNinteiDateRange;
    }

    @JsonProperty("txtNinteiDateRange")
    public void setTxtNinteiDateRange(TextBoxDateRange txtNinteiDateRange) {
        this.txtNinteiDateRange=txtNinteiDateRange;
    }

}
