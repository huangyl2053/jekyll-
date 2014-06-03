package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
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
 * NinteichosainAdvanceEntry のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosainAdvanceEntryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChosaItakusaki")
    private Label lblChosaItakusaki;
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("imgToSearchNinteichosain")
    private StaticImage imgToSearchNinteichosain;
    @JsonProperty("btnToCopyLatestItakusaki")
    private Button btnToCopyLatestItakusaki;
    @JsonProperty("lblNinteichosain")
    private Label lblNinteichosain;
    @JsonProperty("txtNinteichosainCode")
    private TextBoxCode txtNinteichosainCode;
    @JsonProperty("txtNinteichosainName")
    private TextBox txtNinteichosainName;
    @JsonProperty("imgPadding2")
    private StaticImage imgPadding2;
    @JsonProperty("btnToCopyLatestNinteichosain")
    private Button btnToCopyLatestNinteichosain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblChosaItakusaki")
    public Label getLblChosaItakusaki() {
        return lblChosaItakusaki;
    }

    @JsonProperty("lblChosaItakusaki")
    public void setLblChosaItakusaki(Label lblChosaItakusaki) {
        this.lblChosaItakusaki=lblChosaItakusaki;
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

    @JsonProperty("imgToSearchNinteichosain")
    public StaticImage getImgToSearchNinteichosain() {
        return imgToSearchNinteichosain;
    }

    @JsonProperty("imgToSearchNinteichosain")
    public void setImgToSearchNinteichosain(StaticImage imgToSearchNinteichosain) {
        this.imgToSearchNinteichosain=imgToSearchNinteichosain;
    }

    @JsonProperty("btnToCopyLatestItakusaki")
    public Button getBtnToCopyLatestItakusaki() {
        return btnToCopyLatestItakusaki;
    }

    @JsonProperty("btnToCopyLatestItakusaki")
    public void setBtnToCopyLatestItakusaki(Button btnToCopyLatestItakusaki) {
        this.btnToCopyLatestItakusaki=btnToCopyLatestItakusaki;
    }

    @JsonProperty("lblNinteichosain")
    public Label getLblNinteichosain() {
        return lblNinteichosain;
    }

    @JsonProperty("lblNinteichosain")
    public void setLblNinteichosain(Label lblNinteichosain) {
        this.lblNinteichosain=lblNinteichosain;
    }

    @JsonProperty("txtNinteichosainCode")
    public TextBoxCode getTxtNinteichosainCode() {
        return txtNinteichosainCode;
    }

    @JsonProperty("txtNinteichosainCode")
    public void setTxtNinteichosainCode(TextBoxCode txtNinteichosainCode) {
        this.txtNinteichosainCode=txtNinteichosainCode;
    }

    @JsonProperty("txtNinteichosainName")
    public TextBox getTxtNinteichosainName() {
        return txtNinteichosainName;
    }

    @JsonProperty("txtNinteichosainName")
    public void setTxtNinteichosainName(TextBox txtNinteichosainName) {
        this.txtNinteichosainName=txtNinteichosainName;
    }

    @JsonProperty("imgPadding2")
    public StaticImage getImgPadding2() {
        return imgPadding2;
    }

    @JsonProperty("imgPadding2")
    public void setImgPadding2(StaticImage imgPadding2) {
        this.imgPadding2=imgPadding2;
    }

    @JsonProperty("btnToCopyLatestNinteichosain")
    public Button getBtnToCopyLatestNinteichosain() {
        return btnToCopyLatestNinteichosain;
    }

    @JsonProperty("btnToCopyLatestNinteichosain")
    public void setBtnToCopyLatestNinteichosain(Button btnToCopyLatestNinteichosain) {
        this.btnToCopyLatestNinteichosain=btnToCopyLatestNinteichosain;
    }

}
