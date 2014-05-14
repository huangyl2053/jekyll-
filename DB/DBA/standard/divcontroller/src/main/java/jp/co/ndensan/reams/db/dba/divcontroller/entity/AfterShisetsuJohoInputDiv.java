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
 * AfterShisetsuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class AfterShisetsuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radAfterShisetsuShurui")
    private RadioButton radAfterShisetsuShurui;
    @JsonProperty("txtAfterShisetsuNyushoDate")
    private TextBoxFlexibleDate txtAfterShisetsuNyushoDate;
    @JsonProperty("lblAfterShisetsu")
    private Label lblAfterShisetsu;
    @JsonProperty("txtAfterShisetsuCode")
    private TextBoxCode txtAfterShisetsuCode;
    @JsonProperty("txtAfterShisetsuMeisho")
    private TextBox txtAfterShisetsuMeisho;
    @JsonProperty("btnAfterShisetsuSelect")
    private ButtonDialog btnAfterShisetsuSelect;
    @JsonProperty("btnAfterOtherShisetsuSelect")
    private ButtonDialog btnAfterOtherShisetsuSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radAfterShisetsuShurui")
    public RadioButton getRadAfterShisetsuShurui() {
        return radAfterShisetsuShurui;
    }

    @JsonProperty("radAfterShisetsuShurui")
    public void setRadAfterShisetsuShurui(RadioButton radAfterShisetsuShurui) {
        this.radAfterShisetsuShurui=radAfterShisetsuShurui;
    }

    @JsonProperty("txtAfterShisetsuNyushoDate")
    public TextBoxFlexibleDate getTxtAfterShisetsuNyushoDate() {
        return txtAfterShisetsuNyushoDate;
    }

    @JsonProperty("txtAfterShisetsuNyushoDate")
    public void setTxtAfterShisetsuNyushoDate(TextBoxFlexibleDate txtAfterShisetsuNyushoDate) {
        this.txtAfterShisetsuNyushoDate=txtAfterShisetsuNyushoDate;
    }

    @JsonProperty("lblAfterShisetsu")
    public Label getLblAfterShisetsu() {
        return lblAfterShisetsu;
    }

    @JsonProperty("lblAfterShisetsu")
    public void setLblAfterShisetsu(Label lblAfterShisetsu) {
        this.lblAfterShisetsu=lblAfterShisetsu;
    }

    @JsonProperty("txtAfterShisetsuCode")
    public TextBoxCode getTxtAfterShisetsuCode() {
        return txtAfterShisetsuCode;
    }

    @JsonProperty("txtAfterShisetsuCode")
    public void setTxtAfterShisetsuCode(TextBoxCode txtAfterShisetsuCode) {
        this.txtAfterShisetsuCode=txtAfterShisetsuCode;
    }

    @JsonProperty("txtAfterShisetsuMeisho")
    public TextBox getTxtAfterShisetsuMeisho() {
        return txtAfterShisetsuMeisho;
    }

    @JsonProperty("txtAfterShisetsuMeisho")
    public void setTxtAfterShisetsuMeisho(TextBox txtAfterShisetsuMeisho) {
        this.txtAfterShisetsuMeisho=txtAfterShisetsuMeisho;
    }

    @JsonProperty("btnAfterShisetsuSelect")
    public ButtonDialog getBtnAfterShisetsuSelect() {
        return btnAfterShisetsuSelect;
    }

    @JsonProperty("btnAfterShisetsuSelect")
    public void setBtnAfterShisetsuSelect(ButtonDialog btnAfterShisetsuSelect) {
        this.btnAfterShisetsuSelect=btnAfterShisetsuSelect;
    }

    @JsonProperty("btnAfterOtherShisetsuSelect")
    public ButtonDialog getBtnAfterOtherShisetsuSelect() {
        return btnAfterOtherShisetsuSelect;
    }

    @JsonProperty("btnAfterOtherShisetsuSelect")
    public void setBtnAfterOtherShisetsuSelect(ButtonDialog btnAfterOtherShisetsuSelect) {
        this.btnAfterOtherShisetsuSelect=btnAfterOtherShisetsuSelect;
    }

}
