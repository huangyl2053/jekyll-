package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblKyotakuServiceJikoSakuseiSummarySub2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJikoSakuseiSummarySub2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub211")
    private tblKyotakuServiceJikoSakuseiSummarySub211AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub211;
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub221")
    private tblKyotakuServiceJikoSakuseiSummarySub221AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub221;
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub231")
    private tblKyotakuServiceJikoSakuseiSummarySub231AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub231;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblBrank0001() {
        return this.tblKyotakuServiceJikoSakuseiSummarySub211.getLblBrank0001();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku() {
        return this.tblKyotakuServiceJikoSakuseiSummarySub221.getTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyotakuServiceJikoSakuseiGendoKanriRange() {
        return this.tblKyotakuServiceJikoSakuseiSummarySub231.getTxtKyotakuServiceJikoSakuseiGendoKanriRange();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub211")
    private tblKyotakuServiceJikoSakuseiSummarySub211AttblKyotakuServiceJikoSakuseiSummarySub2 getTblKyotakuServiceJikoSakuseiSummarySub211() {
        return tblKyotakuServiceJikoSakuseiSummarySub211;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub211")
    private void setTblKyotakuServiceJikoSakuseiSummarySub211(tblKyotakuServiceJikoSakuseiSummarySub211AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub211) {
        this.tblKyotakuServiceJikoSakuseiSummarySub211=tblKyotakuServiceJikoSakuseiSummarySub211;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub221")
    private tblKyotakuServiceJikoSakuseiSummarySub221AttblKyotakuServiceJikoSakuseiSummarySub2 getTblKyotakuServiceJikoSakuseiSummarySub221() {
        return tblKyotakuServiceJikoSakuseiSummarySub221;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub221")
    private void setTblKyotakuServiceJikoSakuseiSummarySub221(tblKyotakuServiceJikoSakuseiSummarySub221AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub221) {
        this.tblKyotakuServiceJikoSakuseiSummarySub221=tblKyotakuServiceJikoSakuseiSummarySub221;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub231")
    private tblKyotakuServiceJikoSakuseiSummarySub231AttblKyotakuServiceJikoSakuseiSummarySub2 getTblKyotakuServiceJikoSakuseiSummarySub231() {
        return tblKyotakuServiceJikoSakuseiSummarySub231;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiSummarySub231")
    private void setTblKyotakuServiceJikoSakuseiSummarySub231(tblKyotakuServiceJikoSakuseiSummarySub231AttblKyotakuServiceJikoSakuseiSummarySub2 tblKyotakuServiceJikoSakuseiSummarySub231) {
        this.tblKyotakuServiceJikoSakuseiSummarySub231=tblKyotakuServiceJikoSakuseiSummarySub231;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiSummarySub211 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiSummarySub211AttblKyotakuServiceJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("lblBrank0001")
    private Label lblBrank0001;

    @JsonProperty("lblBrank0001")
    public Label getLblBrank0001() {
        return lblBrank0001;
    }

    @JsonProperty("lblBrank0001")
    public void setLblBrank0001(Label lblBrank0001) {
        this.lblBrank0001=lblBrank0001;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiSummarySub221 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiSummarySub221AttblKyotakuServiceJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("txtKyotakuServiceJikoSakuseiSikyuuGendoGaku")
    private TextBox txtKyotakuServiceJikoSakuseiSikyuuGendoGaku;

    @JsonProperty("txtKyotakuServiceJikoSakuseiSikyuuGendoGaku")
    public TextBox getTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku() {
        return txtKyotakuServiceJikoSakuseiSikyuuGendoGaku;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiSikyuuGendoGaku")
    public void setTxtKyotakuServiceJikoSakuseiSikyuuGendoGaku(TextBox txtKyotakuServiceJikoSakuseiSikyuuGendoGaku) {
        this.txtKyotakuServiceJikoSakuseiSikyuuGendoGaku=txtKyotakuServiceJikoSakuseiSikyuuGendoGaku;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiSummarySub231 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiSummarySub231AttblKyotakuServiceJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("txtKyotakuServiceJikoSakuseiGendoKanriRange")
    private TextBoxDateRange txtKyotakuServiceJikoSakuseiGendoKanriRange;

    @JsonProperty("txtKyotakuServiceJikoSakuseiGendoKanriRange")
    public TextBoxDateRange getTxtKyotakuServiceJikoSakuseiGendoKanriRange() {
        return txtKyotakuServiceJikoSakuseiGendoKanriRange;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiGendoKanriRange")
    public void setTxtKyotakuServiceJikoSakuseiGendoKanriRange(TextBoxDateRange txtKyotakuServiceJikoSakuseiGendoKanriRange) {
        this.txtKyotakuServiceJikoSakuseiGendoKanriRange=txtKyotakuServiceJikoSakuseiGendoKanriRange;
    }

}
