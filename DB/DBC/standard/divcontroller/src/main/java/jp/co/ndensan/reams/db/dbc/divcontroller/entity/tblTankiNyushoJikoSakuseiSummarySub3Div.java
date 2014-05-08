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
 * tblTankiNyushoJikoSakuseiSummarySub3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTankiNyushoJikoSakuseiSummarySub3Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub311")
    private tblTankiNyushoJikoSakuseiSummarySub311AttblTankiNyushoJikoSakuseiSummarySub3 tblTankiNyushoJikoSakuseiSummarySub311;
    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub321")
    private tblTankiNyushoJikoSakuseiSummarySub321AttblTankiNyushoJikoSakuseiSummarySub3 tblTankiNyushoJikoSakuseiSummarySub321;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblBrank0003() {
        return this.tblTankiNyushoJikoSakuseiSummarySub311.getLblBrank0003();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTankiNyushoJikoSakuseiGendoKanriRange() {
        return this.tblTankiNyushoJikoSakuseiSummarySub321.getTxtTankiNyushoJikoSakuseiGendoKanriRange();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub311")
    private tblTankiNyushoJikoSakuseiSummarySub311AttblTankiNyushoJikoSakuseiSummarySub3 getTblTankiNyushoJikoSakuseiSummarySub311() {
        return tblTankiNyushoJikoSakuseiSummarySub311;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub311")
    private void setTblTankiNyushoJikoSakuseiSummarySub311(tblTankiNyushoJikoSakuseiSummarySub311AttblTankiNyushoJikoSakuseiSummarySub3 tblTankiNyushoJikoSakuseiSummarySub311) {
        this.tblTankiNyushoJikoSakuseiSummarySub311=tblTankiNyushoJikoSakuseiSummarySub311;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub321")
    private tblTankiNyushoJikoSakuseiSummarySub321AttblTankiNyushoJikoSakuseiSummarySub3 getTblTankiNyushoJikoSakuseiSummarySub321() {
        return tblTankiNyushoJikoSakuseiSummarySub321;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiSummarySub321")
    private void setTblTankiNyushoJikoSakuseiSummarySub321(tblTankiNyushoJikoSakuseiSummarySub321AttblTankiNyushoJikoSakuseiSummarySub3 tblTankiNyushoJikoSakuseiSummarySub321) {
        this.tblTankiNyushoJikoSakuseiSummarySub321=tblTankiNyushoJikoSakuseiSummarySub321;
    }

}
/**
 * tblTankiNyushoJikoSakuseiSummarySub311 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakuseiSummarySub311AttblTankiNyushoJikoSakuseiSummarySub3 extends TableCell {
    @JsonProperty("lblBrank0003")
    private Label lblBrank0003;

    @JsonProperty("lblBrank0003")
    public Label getLblBrank0003() {
        return lblBrank0003;
    }

    @JsonProperty("lblBrank0003")
    public void setLblBrank0003(Label lblBrank0003) {
        this.lblBrank0003=lblBrank0003;
    }

}
/**
 * tblTankiNyushoJikoSakuseiSummarySub321 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakuseiSummarySub321AttblTankiNyushoJikoSakuseiSummarySub3 extends TableCell {
    @JsonProperty("txtTankiNyushoJikoSakuseiGendoKanriRange")
    private TextBoxDateRange txtTankiNyushoJikoSakuseiGendoKanriRange;

    @JsonProperty("txtTankiNyushoJikoSakuseiGendoKanriRange")
    public TextBoxDateRange getTxtTankiNyushoJikoSakuseiGendoKanriRange() {
        return txtTankiNyushoJikoSakuseiGendoKanriRange;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiGendoKanriRange")
    public void setTxtTankiNyushoJikoSakuseiGendoKanriRange(TextBoxDateRange txtTankiNyushoJikoSakuseiGendoKanriRange) {
        this.txtTankiNyushoJikoSakuseiGendoKanriRange=txtTankiNyushoJikoSakuseiGendoKanriRange;
    }

}
