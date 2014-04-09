package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:23 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GenJushoNyuryokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenJushoNyuryokuPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGenJusho")
    private Label lblGenJusho;
    @JsonProperty("txtGenJusho")
    private TextBox txtGenJusho;
    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    private Button btnZenkokuJushoTenshutsusaki;
    @JsonProperty("lblSpace23")
    private Label lblSpace23;
    @JsonProperty("lblMessageGenJusho")
    private Label lblMessageGenJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblGenJusho")
    public Label getLblGenJusho() {
        return lblGenJusho;
    }

    @JsonProperty("lblGenJusho")
    public void setLblGenJusho(Label lblGenJusho) {
        this.lblGenJusho=lblGenJusho;
    }

    @JsonProperty("txtGenJusho")
    public TextBox getTxtGenJusho() {
        return txtGenJusho;
    }

    @JsonProperty("txtGenJusho")
    public void setTxtGenJusho(TextBox txtGenJusho) {
        this.txtGenJusho=txtGenJusho;
    }

    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    public Button getBtnZenkokuJushoTenshutsusaki() {
        return btnZenkokuJushoTenshutsusaki;
    }

    @JsonProperty("btnZenkokuJushoTenshutsusaki")
    public void setBtnZenkokuJushoTenshutsusaki(Button btnZenkokuJushoTenshutsusaki) {
        this.btnZenkokuJushoTenshutsusaki=btnZenkokuJushoTenshutsusaki;
    }

    @JsonProperty("lblSpace23")
    public Label getLblSpace23() {
        return lblSpace23;
    }

    @JsonProperty("lblSpace23")
    public void setLblSpace23(Label lblSpace23) {
        this.lblSpace23=lblSpace23;
    }

    @JsonProperty("lblMessageGenJusho")
    public Label getLblMessageGenJusho() {
        return lblMessageGenJusho;
    }

    @JsonProperty("lblMessageGenJusho")
    public void setLblMessageGenJusho(Label lblMessageGenJusho) {
        this.lblMessageGenJusho=lblMessageGenJusho;
    }

}
