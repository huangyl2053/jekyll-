package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005;
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
 * ChosaItakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakuJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("btnChosakikanSearch")
    private ButtonDialog btnChosakikanSearch;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("txtChosaJissiDate")
    private TextBoxFlexibleDate txtChosaJissiDate;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("btnChosainSearch")
    private ButtonDialog btnChosainSearch;
    @JsonProperty("txtChosainName")
    private TextBox txtChosainName;
    @JsonProperty("txtChosahyoJuryoDate")
    private TextBoxFlexibleDate txtChosahyoJuryoDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode=txtChosaItakusakiCode;
    }

    @JsonProperty("btnChosakikanSearch")
    public ButtonDialog getBtnChosakikanSearch() {
        return btnChosakikanSearch;
    }

    @JsonProperty("btnChosakikanSearch")
    public void setBtnChosakikanSearch(ButtonDialog btnChosakikanSearch) {
        this.btnChosakikanSearch=btnChosakikanSearch;
    }

    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName=txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaJissiDate")
    public TextBoxFlexibleDate getTxtChosaJissiDate() {
        return txtChosaJissiDate;
    }

    @JsonProperty("txtChosaJissiDate")
    public void setTxtChosaJissiDate(TextBoxFlexibleDate txtChosaJissiDate) {
        this.txtChosaJissiDate=txtChosaJissiDate;
    }

    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode=txtChosainCode;
    }

    @JsonProperty("btnChosainSearch")
    public ButtonDialog getBtnChosainSearch() {
        return btnChosainSearch;
    }

    @JsonProperty("btnChosainSearch")
    public void setBtnChosainSearch(ButtonDialog btnChosainSearch) {
        this.btnChosainSearch=btnChosainSearch;
    }

    @JsonProperty("txtChosainName")
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName=txtChosainName;
    }

    @JsonProperty("txtChosahyoJuryoDate")
    public TextBoxFlexibleDate getTxtChosahyoJuryoDate() {
        return txtChosahyoJuryoDate;
    }

    @JsonProperty("txtChosahyoJuryoDate")
    public void setTxtChosahyoJuryoDate(TextBoxFlexibleDate txtChosahyoJuryoDate) {
        this.txtChosahyoJuryoDate=txtChosahyoJuryoDate;
    }

}
