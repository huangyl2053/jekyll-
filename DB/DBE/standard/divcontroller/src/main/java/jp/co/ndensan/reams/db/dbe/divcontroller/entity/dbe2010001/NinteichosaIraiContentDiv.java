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
 * NinteichosaIraiContent のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiContentDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChosaIraiKubun")
    private DropDownList ddlChosaIraiKubun;
    @JsonProperty("txtChosaCount")
    private TextBox txtChosaCount;
    @JsonProperty("lblChosaCountUnit")
    private Label lblChosaCountUnit;
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("txtChosainName")
    private TextBox txtChosainName;
    @JsonProperty("txtChosaIraiDate")
    private TextBoxFlexibleDate txtChosaIraiDate;
    @JsonProperty("txtChosaKigenDate")
    private TextBoxFlexibleDate txtChosaKigenDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlChosaIraiKubun")
    public DropDownList getDdlChosaIraiKubun() {
        return ddlChosaIraiKubun;
    }

    @JsonProperty("ddlChosaIraiKubun")
    public void setDdlChosaIraiKubun(DropDownList ddlChosaIraiKubun) {
        this.ddlChosaIraiKubun=ddlChosaIraiKubun;
    }

    @JsonProperty("txtChosaCount")
    public TextBox getTxtChosaCount() {
        return txtChosaCount;
    }

    @JsonProperty("txtChosaCount")
    public void setTxtChosaCount(TextBox txtChosaCount) {
        this.txtChosaCount=txtChosaCount;
    }

    @JsonProperty("lblChosaCountUnit")
    public Label getLblChosaCountUnit() {
        return lblChosaCountUnit;
    }

    @JsonProperty("lblChosaCountUnit")
    public void setLblChosaCountUnit(Label lblChosaCountUnit) {
        this.lblChosaCountUnit=lblChosaCountUnit;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode=txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName=txtChosaItakusakiName;
    }

    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode=txtChosainCode;
    }

    @JsonProperty("txtChosainName")
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName=txtChosainName;
    }

    @JsonProperty("txtChosaIraiDate")
    public TextBoxFlexibleDate getTxtChosaIraiDate() {
        return txtChosaIraiDate;
    }

    @JsonProperty("txtChosaIraiDate")
    public void setTxtChosaIraiDate(TextBoxFlexibleDate txtChosaIraiDate) {
        this.txtChosaIraiDate=txtChosaIraiDate;
    }

    @JsonProperty("txtChosaKigenDate")
    public TextBoxFlexibleDate getTxtChosaKigenDate() {
        return txtChosaKigenDate;
    }

    @JsonProperty("txtChosaKigenDate")
    public void setTxtChosaKigenDate(TextBoxFlexibleDate txtChosaKigenDate) {
        this.txtChosaKigenDate=txtChosaKigenDate;
    }

}
