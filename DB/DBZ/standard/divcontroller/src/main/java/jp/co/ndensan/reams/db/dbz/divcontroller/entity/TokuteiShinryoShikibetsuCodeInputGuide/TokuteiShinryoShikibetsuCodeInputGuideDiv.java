package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TokuteiShinryoShikibetsuCodeInputGuide;
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
 * TokuteiShinryoShikibetsuCodeInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiShinryoShikibetsuCodeInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceShuruiCode")
    private TextBoxCode txtServiceShuruiCode;
    @JsonProperty("txtTokuteiShinryoShikibetsuCode")
    private TextBoxCode txtTokuteiShinryoShikibetsuCode;
    @JsonProperty("btnSearchTokuteiShinryoShikibetsuCode")
    private Button btnSearchTokuteiShinryoShikibetsuCode;
    @JsonProperty("txtKijunYM")
    private TextBoxDate txtKijunYM;
    @JsonProperty("dgTokuteiShinryoShikibetsuCode")
    private DataGrid<dgTokuteiShinryoShikibetsuCode_Row> dgTokuteiShinryoShikibetsuCode;
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

    @JsonProperty("txtTokuteiShinryoShikibetsuCode")
    public TextBoxCode getTxtTokuteiShinryoShikibetsuCode() {
        return txtTokuteiShinryoShikibetsuCode;
    }

    @JsonProperty("txtTokuteiShinryoShikibetsuCode")
    public void setTxtTokuteiShinryoShikibetsuCode(TextBoxCode txtTokuteiShinryoShikibetsuCode) {
        this.txtTokuteiShinryoShikibetsuCode=txtTokuteiShinryoShikibetsuCode;
    }

    @JsonProperty("btnSearchTokuteiShinryoShikibetsuCode")
    public Button getBtnSearchTokuteiShinryoShikibetsuCode() {
        return btnSearchTokuteiShinryoShikibetsuCode;
    }

    @JsonProperty("btnSearchTokuteiShinryoShikibetsuCode")
    public void setBtnSearchTokuteiShinryoShikibetsuCode(Button btnSearchTokuteiShinryoShikibetsuCode) {
        this.btnSearchTokuteiShinryoShikibetsuCode=btnSearchTokuteiShinryoShikibetsuCode;
    }

    @JsonProperty("txtKijunYM")
    public TextBoxDate getTxtKijunYM() {
        return txtKijunYM;
    }

    @JsonProperty("txtKijunYM")
    public void setTxtKijunYM(TextBoxDate txtKijunYM) {
        this.txtKijunYM=txtKijunYM;
    }

    @JsonProperty("dgTokuteiShinryoShikibetsuCode")
    public DataGrid<dgTokuteiShinryoShikibetsuCode_Row> getDgTokuteiShinryoShikibetsuCode() {
        return dgTokuteiShinryoShikibetsuCode;
    }

    @JsonProperty("dgTokuteiShinryoShikibetsuCode")
    public void setDgTokuteiShinryoShikibetsuCode(DataGrid<dgTokuteiShinryoShikibetsuCode_Row> dgTokuteiShinryoShikibetsuCode) {
        this.dgTokuteiShinryoShikibetsuCode=dgTokuteiShinryoShikibetsuCode;
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
