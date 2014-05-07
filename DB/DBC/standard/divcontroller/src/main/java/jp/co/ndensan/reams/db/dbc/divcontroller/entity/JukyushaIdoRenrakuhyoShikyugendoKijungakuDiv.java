package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * JukyushaIdoRenrakuhyoShikyugendoKijungaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKyuHomonTsusho")
    private Label lblKyuHomonTsusho;
    @JsonProperty("txtKyuHomonTsushoShikyuGendoKijungaku")
    private TextBoxNum txtKyuHomonTsushoShikyuGendoKijungaku;
    @JsonProperty("txtKyuHomonTsushoKanriTekiyoDateRange")
    private TextBoxDateRange txtKyuHomonTsushoKanriTekiyoDateRange;
    @JsonProperty("lblKyuTankiNyusho")
    private Label lblKyuTankiNyusho;
    @JsonProperty("txtKyuTankiNyushoShikyuGendoKijungaku")
    private TextBoxNum txtKyuTankiNyushoShikyuGendoKijungaku;
    @JsonProperty("txtKyuTankiNyushoKanriTekiyoDateRange")
    private TextBoxDateRange txtKyuTankiNyushoKanriTekiyoDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKyuHomonTsusho")
    public Label getLblKyuHomonTsusho() {
        return lblKyuHomonTsusho;
    }

    @JsonProperty("lblKyuHomonTsusho")
    public void setLblKyuHomonTsusho(Label lblKyuHomonTsusho) {
        this.lblKyuHomonTsusho=lblKyuHomonTsusho;
    }

    @JsonProperty("txtKyuHomonTsushoShikyuGendoKijungaku")
    public TextBoxNum getTxtKyuHomonTsushoShikyuGendoKijungaku() {
        return txtKyuHomonTsushoShikyuGendoKijungaku;
    }

    @JsonProperty("txtKyuHomonTsushoShikyuGendoKijungaku")
    public void setTxtKyuHomonTsushoShikyuGendoKijungaku(TextBoxNum txtKyuHomonTsushoShikyuGendoKijungaku) {
        this.txtKyuHomonTsushoShikyuGendoKijungaku=txtKyuHomonTsushoShikyuGendoKijungaku;
    }

    @JsonProperty("txtKyuHomonTsushoKanriTekiyoDateRange")
    public TextBoxDateRange getTxtKyuHomonTsushoKanriTekiyoDateRange() {
        return txtKyuHomonTsushoKanriTekiyoDateRange;
    }

    @JsonProperty("txtKyuHomonTsushoKanriTekiyoDateRange")
    public void setTxtKyuHomonTsushoKanriTekiyoDateRange(TextBoxDateRange txtKyuHomonTsushoKanriTekiyoDateRange) {
        this.txtKyuHomonTsushoKanriTekiyoDateRange=txtKyuHomonTsushoKanriTekiyoDateRange;
    }

    @JsonProperty("lblKyuTankiNyusho")
    public Label getLblKyuTankiNyusho() {
        return lblKyuTankiNyusho;
    }

    @JsonProperty("lblKyuTankiNyusho")
    public void setLblKyuTankiNyusho(Label lblKyuTankiNyusho) {
        this.lblKyuTankiNyusho=lblKyuTankiNyusho;
    }

    @JsonProperty("txtKyuTankiNyushoShikyuGendoKijungaku")
    public TextBoxNum getTxtKyuTankiNyushoShikyuGendoKijungaku() {
        return txtKyuTankiNyushoShikyuGendoKijungaku;
    }

    @JsonProperty("txtKyuTankiNyushoShikyuGendoKijungaku")
    public void setTxtKyuTankiNyushoShikyuGendoKijungaku(TextBoxNum txtKyuTankiNyushoShikyuGendoKijungaku) {
        this.txtKyuTankiNyushoShikyuGendoKijungaku=txtKyuTankiNyushoShikyuGendoKijungaku;
    }

    @JsonProperty("txtKyuTankiNyushoKanriTekiyoDateRange")
    public TextBoxDateRange getTxtKyuTankiNyushoKanriTekiyoDateRange() {
        return txtKyuTankiNyushoKanriTekiyoDateRange;
    }

    @JsonProperty("txtKyuTankiNyushoKanriTekiyoDateRange")
    public void setTxtKyuTankiNyushoKanriTekiyoDateRange(TextBoxDateRange txtKyuTankiNyushoKanriTekiyoDateRange) {
        this.txtKyuTankiNyushoKanriTekiyoDateRange=txtKyuTankiNyushoKanriTekiyoDateRange;
    }

}
