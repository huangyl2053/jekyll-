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
    private TextBoxDate txtNinteichosaJissiYMD;
    @JsonProperty("txtNinteichosaJuryoYMD")
    private TextBoxDate txtNinteichosaJuryoYMD;
    @JsonProperty("txtNinteichosaKanryoYMD")
    private TextBoxDate txtNinteichosaKanryoYMD;

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
    public TextBoxDate getTxtNinteichosaJissiYMD() {
        return txtNinteichosaJissiYMD;
    }

    @JsonProperty("txtNinteichosaJissiYMD")
    public void setTxtNinteichosaJissiYMD(TextBoxDate txtNinteichosaJissiYMD) {
        this.txtNinteichosaJissiYMD=txtNinteichosaJissiYMD;
    }

    @JsonProperty("txtNinteichosaJuryoYMD")
    public TextBoxDate getTxtNinteichosaJuryoYMD() {
        return txtNinteichosaJuryoYMD;
    }

    @JsonProperty("txtNinteichosaJuryoYMD")
    public void setTxtNinteichosaJuryoYMD(TextBoxDate txtNinteichosaJuryoYMD) {
        this.txtNinteichosaJuryoYMD=txtNinteichosaJuryoYMD;
    }

    @JsonProperty("txtNinteichosaKanryoYMD")
    public TextBoxDate getTxtNinteichosaKanryoYMD() {
        return txtNinteichosaKanryoYMD;
    }

    @JsonProperty("txtNinteichosaKanryoYMD")
    public void setTxtNinteichosaKanryoYMD(TextBoxDate txtNinteichosaKanryoYMD) {
        this.txtNinteichosaKanryoYMD=txtNinteichosaKanryoYMD;
    }

}
