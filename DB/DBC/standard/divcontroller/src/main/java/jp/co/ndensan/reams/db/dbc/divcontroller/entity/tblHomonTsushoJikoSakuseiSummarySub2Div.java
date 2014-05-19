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
 * tblHomonTsushoJikoSakuseiSummarySub2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblHomonTsushoJikoSakuseiSummarySub2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub211")
    private tblHomonTsushoJikoSakuseiSummarySub211AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub211;
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub221")
    private tblHomonTsushoJikoSakuseiSummarySub221AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub221;
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub231")
    private tblHomonTsushoJikoSakuseiSummarySub231AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub231;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblBrank0002() {
        return this.tblHomonTsushoJikoSakuseiSummarySub211.getLblBrank0002();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiSikyuuGendoGaku() {
        return this.tblHomonTsushoJikoSakuseiSummarySub221.getTxtHomonTsushoJikoSakuseiSikyuuGendoGaku();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHomonTsushoJikoSakuseiGendoKanriRange() {
        return this.tblHomonTsushoJikoSakuseiSummarySub231.getTxtHomonTsushoJikoSakuseiGendoKanriRange();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub211")
    private tblHomonTsushoJikoSakuseiSummarySub211AttblHomonTsushoJikoSakuseiSummarySub2 getTblHomonTsushoJikoSakuseiSummarySub211() {
        return tblHomonTsushoJikoSakuseiSummarySub211;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub211")
    private void setTblHomonTsushoJikoSakuseiSummarySub211(tblHomonTsushoJikoSakuseiSummarySub211AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub211) {
        this.tblHomonTsushoJikoSakuseiSummarySub211=tblHomonTsushoJikoSakuseiSummarySub211;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub221")
    private tblHomonTsushoJikoSakuseiSummarySub221AttblHomonTsushoJikoSakuseiSummarySub2 getTblHomonTsushoJikoSakuseiSummarySub221() {
        return tblHomonTsushoJikoSakuseiSummarySub221;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub221")
    private void setTblHomonTsushoJikoSakuseiSummarySub221(tblHomonTsushoJikoSakuseiSummarySub221AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub221) {
        this.tblHomonTsushoJikoSakuseiSummarySub221=tblHomonTsushoJikoSakuseiSummarySub221;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub231")
    private tblHomonTsushoJikoSakuseiSummarySub231AttblHomonTsushoJikoSakuseiSummarySub2 getTblHomonTsushoJikoSakuseiSummarySub231() {
        return tblHomonTsushoJikoSakuseiSummarySub231;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiSummarySub231")
    private void setTblHomonTsushoJikoSakuseiSummarySub231(tblHomonTsushoJikoSakuseiSummarySub231AttblHomonTsushoJikoSakuseiSummarySub2 tblHomonTsushoJikoSakuseiSummarySub231) {
        this.tblHomonTsushoJikoSakuseiSummarySub231=tblHomonTsushoJikoSakuseiSummarySub231;
    }

}
/**
 * tblHomonTsushoJikoSakuseiSummarySub211 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakuseiSummarySub211AttblHomonTsushoJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("lblBrank0002")
    private Label lblBrank0002;

    @JsonProperty("lblBrank0002")
    public Label getLblBrank0002() {
        return lblBrank0002;
    }

    @JsonProperty("lblBrank0002")
    public void setLblBrank0002(Label lblBrank0002) {
        this.lblBrank0002=lblBrank0002;
    }

}
/**
 * tblHomonTsushoJikoSakuseiSummarySub221 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakuseiSummarySub221AttblHomonTsushoJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("txtHomonTsushoJikoSakuseiSikyuuGendoGaku")
    private TextBox txtHomonTsushoJikoSakuseiSikyuuGendoGaku;

    @JsonProperty("txtHomonTsushoJikoSakuseiSikyuuGendoGaku")
    public TextBox getTxtHomonTsushoJikoSakuseiSikyuuGendoGaku() {
        return txtHomonTsushoJikoSakuseiSikyuuGendoGaku;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiSikyuuGendoGaku")
    public void setTxtHomonTsushoJikoSakuseiSikyuuGendoGaku(TextBox txtHomonTsushoJikoSakuseiSikyuuGendoGaku) {
        this.txtHomonTsushoJikoSakuseiSikyuuGendoGaku=txtHomonTsushoJikoSakuseiSikyuuGendoGaku;
    }

}
/**
 * tblHomonTsushoJikoSakuseiSummarySub231 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakuseiSummarySub231AttblHomonTsushoJikoSakuseiSummarySub2 extends TableCell {
    @JsonProperty("txtHomonTsushoJikoSakuseiGendoKanriRange")
    private TextBoxDateRange txtHomonTsushoJikoSakuseiGendoKanriRange;

    @JsonProperty("txtHomonTsushoJikoSakuseiGendoKanriRange")
    public TextBoxDateRange getTxtHomonTsushoJikoSakuseiGendoKanriRange() {
        return txtHomonTsushoJikoSakuseiGendoKanriRange;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiGendoKanriRange")
    public void setTxtHomonTsushoJikoSakuseiGendoKanriRange(TextBoxDateRange txtHomonTsushoJikoSakuseiGendoKanriRange) {
        this.txtHomonTsushoJikoSakuseiGendoKanriRange=txtHomonTsushoJikoSakuseiGendoKanriRange;
    }

}
