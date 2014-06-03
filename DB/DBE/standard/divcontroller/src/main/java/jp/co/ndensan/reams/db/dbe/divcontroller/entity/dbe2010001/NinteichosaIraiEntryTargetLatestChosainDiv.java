package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
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
 * NinteichosaIraiEntryTargetLatestChosain のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryTargetLatestChosainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtLatestChosaItakusakiCode")
    private TextBoxCode txtLatestChosaItakusakiCode;
    @JsonProperty("txtLatestChosaItakusakiName")
    private TextBox txtLatestChosaItakusakiName;
    @JsonProperty("btnToSearchChosaItakusaki")
    private ButtonDialog btnToSearchChosaItakusaki;
    @JsonProperty("txtLatestChosainCode")
    private TextBoxCode txtLatestChosainCode;
    @JsonProperty("txtLatestChosainName")
    private TextBox txtLatestChosainName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtLatestChosaItakusakiCode")
    public TextBoxCode getTxtLatestChosaItakusakiCode() {
        return txtLatestChosaItakusakiCode;
    }

    @JsonProperty("txtLatestChosaItakusakiCode")
    public void setTxtLatestChosaItakusakiCode(TextBoxCode txtLatestChosaItakusakiCode) {
        this.txtLatestChosaItakusakiCode=txtLatestChosaItakusakiCode;
    }

    @JsonProperty("txtLatestChosaItakusakiName")
    public TextBox getTxtLatestChosaItakusakiName() {
        return txtLatestChosaItakusakiName;
    }

    @JsonProperty("txtLatestChosaItakusakiName")
    public void setTxtLatestChosaItakusakiName(TextBox txtLatestChosaItakusakiName) {
        this.txtLatestChosaItakusakiName=txtLatestChosaItakusakiName;
    }

    @JsonProperty("btnToSearchChosaItakusaki")
    public ButtonDialog getBtnToSearchChosaItakusaki() {
        return btnToSearchChosaItakusaki;
    }

    @JsonProperty("btnToSearchChosaItakusaki")
    public void setBtnToSearchChosaItakusaki(ButtonDialog btnToSearchChosaItakusaki) {
        this.btnToSearchChosaItakusaki=btnToSearchChosaItakusaki;
    }

    @JsonProperty("txtLatestChosainCode")
    public TextBoxCode getTxtLatestChosainCode() {
        return txtLatestChosainCode;
    }

    @JsonProperty("txtLatestChosainCode")
    public void setTxtLatestChosainCode(TextBoxCode txtLatestChosainCode) {
        this.txtLatestChosainCode=txtLatestChosainCode;
    }

    @JsonProperty("txtLatestChosainName")
    public TextBox getTxtLatestChosainName() {
        return txtLatestChosainName;
    }

    @JsonProperty("txtLatestChosainName")
    public void setTxtLatestChosainName(TextBox txtLatestChosainName) {
        this.txtLatestChosainName=txtLatestChosainName;
    }

}
