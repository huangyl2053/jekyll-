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
 * BeforeShisetsuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class BeforeShisetsuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radBeforeShisetsuShurui")
    private RadioButton radBeforeShisetsuShurui;
    @JsonProperty("txtBeforeShisetsuTaishoDate")
    private TextBoxFlexibleDate txtBeforeShisetsuTaishoDate;
    @JsonProperty("lblBeforeShisetsu")
    private Label lblBeforeShisetsu;
    @JsonProperty("txtBeforeShisetsuCode")
    private TextBoxCode txtBeforeShisetsuCode;
    @JsonProperty("txtBeforeShisetsuMeisho")
    private TextBox txtBeforeShisetsuMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radBeforeShisetsuShurui")
    public RadioButton getRadBeforeShisetsuShurui() {
        return radBeforeShisetsuShurui;
    }

    @JsonProperty("radBeforeShisetsuShurui")
    public void setRadBeforeShisetsuShurui(RadioButton radBeforeShisetsuShurui) {
        this.radBeforeShisetsuShurui=radBeforeShisetsuShurui;
    }

    @JsonProperty("txtBeforeShisetsuTaishoDate")
    public TextBoxFlexibleDate getTxtBeforeShisetsuTaishoDate() {
        return txtBeforeShisetsuTaishoDate;
    }

    @JsonProperty("txtBeforeShisetsuTaishoDate")
    public void setTxtBeforeShisetsuTaishoDate(TextBoxFlexibleDate txtBeforeShisetsuTaishoDate) {
        this.txtBeforeShisetsuTaishoDate=txtBeforeShisetsuTaishoDate;
    }

    @JsonProperty("lblBeforeShisetsu")
    public Label getLblBeforeShisetsu() {
        return lblBeforeShisetsu;
    }

    @JsonProperty("lblBeforeShisetsu")
    public void setLblBeforeShisetsu(Label lblBeforeShisetsu) {
        this.lblBeforeShisetsu=lblBeforeShisetsu;
    }

    @JsonProperty("txtBeforeShisetsuCode")
    public TextBoxCode getTxtBeforeShisetsuCode() {
        return txtBeforeShisetsuCode;
    }

    @JsonProperty("txtBeforeShisetsuCode")
    public void setTxtBeforeShisetsuCode(TextBoxCode txtBeforeShisetsuCode) {
        this.txtBeforeShisetsuCode=txtBeforeShisetsuCode;
    }

    @JsonProperty("txtBeforeShisetsuMeisho")
    public TextBox getTxtBeforeShisetsuMeisho() {
        return txtBeforeShisetsuMeisho;
    }

    @JsonProperty("txtBeforeShisetsuMeisho")
    public void setTxtBeforeShisetsuMeisho(TextBox txtBeforeShisetsuMeisho) {
        this.txtBeforeShisetsuMeisho=txtBeforeShisetsuMeisho;
    }

}
