package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
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
 * NinteichosaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    private TextBoxCode txtNinteiChosaItakusakiCode;
    @JsonProperty("txtNinteiChosaItakusaki")
    private TextBox txtNinteiChosaItakusaki;
    @JsonProperty("txtNinteiChosainCode")
    private TextBoxCode txtNinteiChosainCode;
    @JsonProperty("txtNinteiChosain")
    private TextBox txtNinteiChosain;
    @JsonProperty("txtNinteichosaJissiYMD")
    private TextBoxFlexibleDate txtNinteichosaJissiYMD;
    @JsonProperty("txtNinteichosaJuryoYMD")
    private TextBoxFlexibleDate txtNinteichosaJuryoYMD;
    @JsonProperty("txtNinteichosaKanryoYMD")
    private TextBoxFlexibleDate txtNinteichosaKanryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiChosaItakusakiCode")
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("txtNinteiChosaItakusakiCode")
    public void setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.txtNinteiChosaItakusakiCode=txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("txtNinteiChosaItakusaki")
    public TextBox getTxtNinteiChosaItakusaki() {
        return txtNinteiChosaItakusaki;
    }

    @JsonProperty("txtNinteiChosaItakusaki")
    public void setTxtNinteiChosaItakusaki(TextBox txtNinteiChosaItakusaki) {
        this.txtNinteiChosaItakusaki=txtNinteiChosaItakusaki;
    }

    @JsonProperty("txtNinteiChosainCode")
    public TextBoxCode getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.txtNinteiChosainCode=txtNinteiChosainCode;
    }

    @JsonProperty("txtNinteiChosain")
    public TextBox getTxtNinteiChosain() {
        return txtNinteiChosain;
    }

    @JsonProperty("txtNinteiChosain")
    public void setTxtNinteiChosain(TextBox txtNinteiChosain) {
        this.txtNinteiChosain=txtNinteiChosain;
    }

    @JsonProperty("txtNinteichosaJissiYMD")
    public TextBoxFlexibleDate getTxtNinteichosaJissiYMD() {
        return txtNinteichosaJissiYMD;
    }

    @JsonProperty("txtNinteichosaJissiYMD")
    public void setTxtNinteichosaJissiYMD(TextBoxFlexibleDate txtNinteichosaJissiYMD) {
        this.txtNinteichosaJissiYMD=txtNinteichosaJissiYMD;
    }

    @JsonProperty("txtNinteichosaJuryoYMD")
    public TextBoxFlexibleDate getTxtNinteichosaJuryoYMD() {
        return txtNinteichosaJuryoYMD;
    }

    @JsonProperty("txtNinteichosaJuryoYMD")
    public void setTxtNinteichosaJuryoYMD(TextBoxFlexibleDate txtNinteichosaJuryoYMD) {
        this.txtNinteichosaJuryoYMD=txtNinteichosaJuryoYMD;
    }

    @JsonProperty("txtNinteichosaKanryoYMD")
    public TextBoxFlexibleDate getTxtNinteichosaKanryoYMD() {
        return txtNinteichosaKanryoYMD;
    }

    @JsonProperty("txtNinteichosaKanryoYMD")
    public void setTxtNinteichosaKanryoYMD(TextBoxFlexibleDate txtNinteichosaKanryoYMD) {
        this.txtNinteichosaKanryoYMD=txtNinteichosaKanryoYMD;
    }

}
