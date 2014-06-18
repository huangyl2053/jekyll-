package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
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
 * GaikyoChosaKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaikyoChosaKihonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaJissibi")
    private TextBoxFlexibleDate txtChosaJissibi;
    @JsonProperty("txtChosaKubun")
    private TextBox txtChosaKubun;
    @JsonProperty("txtJissiBasho")
    private TextBox txtJissiBasho;
    @JsonProperty("txtChosaItakusaki")
    private TextBox txtChosaItakusaki;
    @JsonProperty("txtChosaItakusakiMeisho")
    private TextBox txtChosaItakusakiMeisho;
    @JsonProperty("txtChosain")
    private TextBox txtChosain;
    @JsonProperty("txtChosainMeisho")
    private TextBox txtChosainMeisho;
    @JsonProperty("txtGaikyoTokki")
    private TextBoxMultiLine txtGaikyoTokki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChosaJissibi")
    public TextBoxFlexibleDate getTxtChosaJissibi() {
        return txtChosaJissibi;
    }

    @JsonProperty("txtChosaJissibi")
    public void setTxtChosaJissibi(TextBoxFlexibleDate txtChosaJissibi) {
        this.txtChosaJissibi=txtChosaJissibi;
    }

    @JsonProperty("txtChosaKubun")
    public TextBox getTxtChosaKubun() {
        return txtChosaKubun;
    }

    @JsonProperty("txtChosaKubun")
    public void setTxtChosaKubun(TextBox txtChosaKubun) {
        this.txtChosaKubun=txtChosaKubun;
    }

    @JsonProperty("txtJissiBasho")
    public TextBox getTxtJissiBasho() {
        return txtJissiBasho;
    }

    @JsonProperty("txtJissiBasho")
    public void setTxtJissiBasho(TextBox txtJissiBasho) {
        this.txtJissiBasho=txtJissiBasho;
    }

    @JsonProperty("txtChosaItakusaki")
    public TextBox getTxtChosaItakusaki() {
        return txtChosaItakusaki;
    }

    @JsonProperty("txtChosaItakusaki")
    public void setTxtChosaItakusaki(TextBox txtChosaItakusaki) {
        this.txtChosaItakusaki=txtChosaItakusaki;
    }

    @JsonProperty("txtChosaItakusakiMeisho")
    public TextBox getTxtChosaItakusakiMeisho() {
        return txtChosaItakusakiMeisho;
    }

    @JsonProperty("txtChosaItakusakiMeisho")
    public void setTxtChosaItakusakiMeisho(TextBox txtChosaItakusakiMeisho) {
        this.txtChosaItakusakiMeisho=txtChosaItakusakiMeisho;
    }

    @JsonProperty("txtChosain")
    public TextBox getTxtChosain() {
        return txtChosain;
    }

    @JsonProperty("txtChosain")
    public void setTxtChosain(TextBox txtChosain) {
        this.txtChosain=txtChosain;
    }

    @JsonProperty("txtChosainMeisho")
    public TextBox getTxtChosainMeisho() {
        return txtChosainMeisho;
    }

    @JsonProperty("txtChosainMeisho")
    public void setTxtChosainMeisho(TextBox txtChosainMeisho) {
        this.txtChosainMeisho=txtChosainMeisho;
    }

    @JsonProperty("txtGaikyoTokki")
    public TextBoxMultiLine getTxtGaikyoTokki() {
        return txtGaikyoTokki;
    }

    @JsonProperty("txtGaikyoTokki")
    public void setTxtGaikyoTokki(TextBoxMultiLine txtGaikyoTokki) {
        this.txtGaikyoTokki=txtGaikyoTokki;
    }

}
