package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shujiilchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiilchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Button3")
    private Button Button3;
    @JsonProperty("ButtonDownLoad1")
    private ButtonDownLoad ButtonDownLoad1;
    @JsonProperty("PanelBatchParameter1")
    private PanelBatchParameter1Div PanelBatchParameter1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getButton3
     * @return Button3
     */
    @JsonProperty("Button3")
    public Button getButton3() {
        return Button3;
    }

    /*
     * setButton3
     * @param Button3 Button3
     */
    @JsonProperty("Button3")
    public void setButton3(Button Button3) {
        this.Button3 = Button3;
    }

    /*
     * getButtonDownLoad1
     * @return ButtonDownLoad1
     */
    @JsonProperty("ButtonDownLoad1")
    public ButtonDownLoad getButtonDownLoad1() {
        return ButtonDownLoad1;
    }

    /*
     * setButtonDownLoad1
     * @param ButtonDownLoad1 ButtonDownLoad1
     */
    @JsonProperty("ButtonDownLoad1")
    public void setButtonDownLoad1(ButtonDownLoad ButtonDownLoad1) {
        this.ButtonDownLoad1 = ButtonDownLoad1;
    }

    /*
     * getPanelBatchParameter1
     * @return PanelBatchParameter1
     */
    @JsonProperty("PanelBatchParameter1")
    public PanelBatchParameter1Div getPanelBatchParameter1() {
        return PanelBatchParameter1;
    }

    /*
     * setPanelBatchParameter1
     * @param PanelBatchParameter1 PanelBatchParameter1
     */
    @JsonProperty("PanelBatchParameter1")
    public void setPanelBatchParameter1(PanelBatchParameter1Div PanelBatchParameter1) {
        this.PanelBatchParameter1 = PanelBatchParameter1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return this.getPanelBatchParameter1().getDataGrid1();
    }

    @JsonIgnore
    public void  setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.getPanelBatchParameter1().setDataGrid1(DataGrid1);
    }

    // </editor-fold>
}
