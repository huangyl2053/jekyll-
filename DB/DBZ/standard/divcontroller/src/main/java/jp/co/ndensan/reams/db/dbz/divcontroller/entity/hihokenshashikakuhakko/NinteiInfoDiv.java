package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
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
 * NinteiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYMD")
    private TextBoxDate txtNinteiYMD;
    @JsonProperty("txtNinteiYukoFromYMD")
    private TextBoxDate txtNinteiYukoFromYMD;
    @JsonProperty("lblKara1")
    private Label lblKara1;
    @JsonProperty("txtNinteiYukoToYMD")
    private TextBoxDate txtNinteiYukoToYMD;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiYMD")
    public TextBoxDate getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    @JsonProperty("txtNinteiYMD")
    public void setTxtNinteiYMD(TextBoxDate txtNinteiYMD) {
        this.txtNinteiYMD=txtNinteiYMD;
    }

    @JsonProperty("txtNinteiYukoFromYMD")
    public TextBoxDate getTxtNinteiYukoFromYMD() {
        return txtNinteiYukoFromYMD;
    }

    @JsonProperty("txtNinteiYukoFromYMD")
    public void setTxtNinteiYukoFromYMD(TextBoxDate txtNinteiYukoFromYMD) {
        this.txtNinteiYukoFromYMD=txtNinteiYukoFromYMD;
    }

    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1=lblKara1;
    }

    @JsonProperty("txtNinteiYukoToYMD")
    public TextBoxDate getTxtNinteiYukoToYMD() {
        return txtNinteiYukoToYMD;
    }

    @JsonProperty("txtNinteiYukoToYMD")
    public void setTxtNinteiYukoToYMD(TextBoxDate txtNinteiYukoToYMD) {
        this.txtNinteiYukoToYMD=txtNinteiYukoToYMD;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

}
