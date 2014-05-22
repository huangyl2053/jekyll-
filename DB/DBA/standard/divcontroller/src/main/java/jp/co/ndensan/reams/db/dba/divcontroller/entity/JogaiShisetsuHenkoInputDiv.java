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
 * JogaiShisetsuHenkoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaiShisetsuHenkoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuHenkoDate")
    private TextBoxFlexibleDate txtShisetsuHenkoDate;
    @JsonProperty("txtHenkoShisetsuCode")
    private TextBoxCode txtHenkoShisetsuCode;
    @JsonProperty("btnHenkoShisetsuInputGuide")
    private ButtonDialog btnHenkoShisetsuInputGuide;
    @JsonProperty("txtHenkoShisetsuMeisho")
    private TextBox txtHenkoShisetsuMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisetsuHenkoDate")
    public TextBoxFlexibleDate getTxtShisetsuHenkoDate() {
        return txtShisetsuHenkoDate;
    }

    @JsonProperty("txtShisetsuHenkoDate")
    public void setTxtShisetsuHenkoDate(TextBoxFlexibleDate txtShisetsuHenkoDate) {
        this.txtShisetsuHenkoDate=txtShisetsuHenkoDate;
    }

    @JsonProperty("txtHenkoShisetsuCode")
    public TextBoxCode getTxtHenkoShisetsuCode() {
        return txtHenkoShisetsuCode;
    }

    @JsonProperty("txtHenkoShisetsuCode")
    public void setTxtHenkoShisetsuCode(TextBoxCode txtHenkoShisetsuCode) {
        this.txtHenkoShisetsuCode=txtHenkoShisetsuCode;
    }

    @JsonProperty("btnHenkoShisetsuInputGuide")
    public ButtonDialog getBtnHenkoShisetsuInputGuide() {
        return btnHenkoShisetsuInputGuide;
    }

    @JsonProperty("btnHenkoShisetsuInputGuide")
    public void setBtnHenkoShisetsuInputGuide(ButtonDialog btnHenkoShisetsuInputGuide) {
        this.btnHenkoShisetsuInputGuide=btnHenkoShisetsuInputGuide;
    }

    @JsonProperty("txtHenkoShisetsuMeisho")
    public TextBox getTxtHenkoShisetsuMeisho() {
        return txtHenkoShisetsuMeisho;
    }

    @JsonProperty("txtHenkoShisetsuMeisho")
    public void setTxtHenkoShisetsuMeisho(TextBox txtHenkoShisetsuMeisho) {
        this.txtHenkoShisetsuMeisho=txtHenkoShisetsuMeisho;
    }

}
