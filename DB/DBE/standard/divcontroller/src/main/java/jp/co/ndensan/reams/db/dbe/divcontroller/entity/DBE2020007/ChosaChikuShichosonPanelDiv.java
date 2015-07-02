package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020007;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaChikuShichosonPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaChikuShichosonPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaChikuCode")
    private TextBox txtChosaChikuCode;
    @JsonProperty("txtChosaChikuName")
    private TextBox txtChosaChikuName;
    @JsonProperty("dgChosaChikuChichosonList")
    private DataGrid<dgChosaChikuChichosonList_Row> dgChosaChikuChichosonList;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("btnInsert")
    private Button btnInsert;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChosaChikuCode")
    public TextBox getTxtChosaChikuCode() {
        return txtChosaChikuCode;
    }

    @JsonProperty("txtChosaChikuCode")
    public void setTxtChosaChikuCode(TextBox txtChosaChikuCode) {
        this.txtChosaChikuCode=txtChosaChikuCode;
    }

    @JsonProperty("txtChosaChikuName")
    public TextBox getTxtChosaChikuName() {
        return txtChosaChikuName;
    }

    @JsonProperty("txtChosaChikuName")
    public void setTxtChosaChikuName(TextBox txtChosaChikuName) {
        this.txtChosaChikuName=txtChosaChikuName;
    }

    @JsonProperty("dgChosaChikuChichosonList")
    public DataGrid<dgChosaChikuChichosonList_Row> getDgChosaChikuChichosonList() {
        return dgChosaChikuChichosonList;
    }

    @JsonProperty("dgChosaChikuChichosonList")
    public void setDgChosaChikuChichosonList(DataGrid<dgChosaChikuChichosonList_Row> dgChosaChikuChichosonList) {
        this.dgChosaChikuChichosonList=dgChosaChikuChichosonList;
    }

    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete=btnDelete;
    }

    @JsonProperty("btnInsert")
    public Button getBtnInsert() {
        return btnInsert;
    }

    @JsonProperty("btnInsert")
    public void setBtnInsert(Button btnInsert) {
        this.btnInsert=btnInsert;
    }

    // </editor-fold>
}
