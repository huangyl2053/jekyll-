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
 * ShisetsuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShisetsuShurui")
    private RadioButton radShisetsuShurui;
    @JsonProperty("lblShisetsu")
    private Label lblShisetsu;
    @JsonProperty("txtShisetsuCode")
    private TextBoxCode txtShisetsuCode;
    @JsonProperty("txtShisetsuMeisho")
    private TextBox txtShisetsuMeisho;
    @JsonProperty("btnShisetsuSelect")
    private ButtonDialog btnShisetsuSelect;
    @JsonProperty("btnOtherShisetsuSelect")
    private ButtonDialog btnOtherShisetsuSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShisetsuShurui")
    public RadioButton getRadShisetsuShurui() {
        return radShisetsuShurui;
    }

    @JsonProperty("radShisetsuShurui")
    public void setRadShisetsuShurui(RadioButton radShisetsuShurui) {
        this.radShisetsuShurui=radShisetsuShurui;
    }

    @JsonProperty("lblShisetsu")
    public Label getLblShisetsu() {
        return lblShisetsu;
    }

    @JsonProperty("lblShisetsu")
    public void setLblShisetsu(Label lblShisetsu) {
        this.lblShisetsu=lblShisetsu;
    }

    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode=txtShisetsuCode;
    }

    @JsonProperty("txtShisetsuMeisho")
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho=txtShisetsuMeisho;
    }

    @JsonProperty("btnShisetsuSelect")
    public ButtonDialog getBtnShisetsuSelect() {
        return btnShisetsuSelect;
    }

    @JsonProperty("btnShisetsuSelect")
    public void setBtnShisetsuSelect(ButtonDialog btnShisetsuSelect) {
        this.btnShisetsuSelect=btnShisetsuSelect;
    }

    @JsonProperty("btnOtherShisetsuSelect")
    public ButtonDialog getBtnOtherShisetsuSelect() {
        return btnOtherShisetsuSelect;
    }

    @JsonProperty("btnOtherShisetsuSelect")
    public void setBtnOtherShisetsuSelect(ButtonDialog btnOtherShisetsuSelect) {
        this.btnOtherShisetsuSelect=btnOtherShisetsuSelect;
    }

}
