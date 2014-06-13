package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceCode_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchServiceCodeDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchServiceCodeDialogDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceShuruiCode")
    private TextBoxCode txtServiceShuruiCode;
    @JsonProperty("txtServiceItemCode")
    private TextBoxCode txtServiceItemCode;
    @JsonProperty("txtKijunYM")
    private TextBoxDate txtKijunYM;
    @JsonProperty("btnSearchServiceCode")
    private Button btnSearchServiceCode;
    @JsonProperty("dgServiceCode")
    private DataGrid<dgServiceCode_Row> dgServiceCode;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtServiceShuruiCode")
    public TextBoxCode getTxtServiceShuruiCode() {
        return txtServiceShuruiCode;
    }

    @JsonProperty("txtServiceShuruiCode")
    public void setTxtServiceShuruiCode(TextBoxCode txtServiceShuruiCode) {
        this.txtServiceShuruiCode=txtServiceShuruiCode;
    }

    @JsonProperty("txtServiceItemCode")
    public TextBoxCode getTxtServiceItemCode() {
        return txtServiceItemCode;
    }

    @JsonProperty("txtServiceItemCode")
    public void setTxtServiceItemCode(TextBoxCode txtServiceItemCode) {
        this.txtServiceItemCode=txtServiceItemCode;
    }

    @JsonProperty("txtKijunYM")
    public TextBoxDate getTxtKijunYM() {
        return txtKijunYM;
    }

    @JsonProperty("txtKijunYM")
    public void setTxtKijunYM(TextBoxDate txtKijunYM) {
        this.txtKijunYM=txtKijunYM;
    }

    @JsonProperty("btnSearchServiceCode")
    public Button getBtnSearchServiceCode() {
        return btnSearchServiceCode;
    }

    @JsonProperty("btnSearchServiceCode")
    public void setBtnSearchServiceCode(Button btnSearchServiceCode) {
        this.btnSearchServiceCode=btnSearchServiceCode;
    }

    @JsonProperty("dgServiceCode")
    public DataGrid<dgServiceCode_Row> getDgServiceCode() {
        return dgServiceCode;
    }

    @JsonProperty("dgServiceCode")
    public void setDgServiceCode(DataGrid<dgServiceCode_Row> dgServiceCode) {
        this.dgServiceCode=dgServiceCode;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
