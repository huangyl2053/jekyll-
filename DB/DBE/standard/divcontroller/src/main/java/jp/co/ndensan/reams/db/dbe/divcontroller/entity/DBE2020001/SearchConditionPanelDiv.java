package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetteiYM")
    private TextBoxFlexibleDate txtSetteiYM;
    @JsonProperty("btnPreviousMonth")
    private Button btnPreviousMonth;
    @JsonProperty("btnNextMonth")
    private Button btnNextMonth;
    @JsonProperty("ddlTaishoChiku")
    private DropDownList ddlTaishoChiku;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSetteiYM")
    public TextBoxFlexibleDate getTxtSetteiYM() {
        return txtSetteiYM;
    }

    @JsonProperty("txtSetteiYM")
    public void setTxtSetteiYM(TextBoxFlexibleDate txtSetteiYM) {
        this.txtSetteiYM=txtSetteiYM;
    }

    @JsonProperty("btnPreviousMonth")
    public Button getBtnPreviousMonth() {
        return btnPreviousMonth;
    }

    @JsonProperty("btnPreviousMonth")
    public void setBtnPreviousMonth(Button btnPreviousMonth) {
        this.btnPreviousMonth=btnPreviousMonth;
    }

    @JsonProperty("btnNextMonth")
    public Button getBtnNextMonth() {
        return btnNextMonth;
    }

    @JsonProperty("btnNextMonth")
    public void setBtnNextMonth(Button btnNextMonth) {
        this.btnNextMonth=btnNextMonth;
    }

    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku=ddlTaishoChiku;
    }

    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay=btnDisplay;
    }

    // </editor-fold>
}
