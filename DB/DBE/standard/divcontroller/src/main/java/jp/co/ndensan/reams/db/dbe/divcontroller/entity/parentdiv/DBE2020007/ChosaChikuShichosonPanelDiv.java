package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("btnInsert")
    private Button btnInsert;
    @JsonProperty("dgChosaChikuChichosonList")
    private DataGrid<dgChosaChikuChichosonList_Row> dgChosaChikuChichosonList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaChikuCode
     * @return txtChosaChikuCode
     */
    @JsonProperty("txtChosaChikuCode")
    public TextBox getTxtChosaChikuCode() {
        return txtChosaChikuCode;
    }

    /*
     * settxtChosaChikuCode
     * @param txtChosaChikuCode txtChosaChikuCode
     */
    @JsonProperty("txtChosaChikuCode")
    public void setTxtChosaChikuCode(TextBox txtChosaChikuCode) {
        this.txtChosaChikuCode = txtChosaChikuCode;
    }

    /*
     * gettxtChosaChikuName
     * @return txtChosaChikuName
     */
    @JsonProperty("txtChosaChikuName")
    public TextBox getTxtChosaChikuName() {
        return txtChosaChikuName;
    }

    /*
     * settxtChosaChikuName
     * @param txtChosaChikuName txtChosaChikuName
     */
    @JsonProperty("txtChosaChikuName")
    public void setTxtChosaChikuName(TextBox txtChosaChikuName) {
        this.txtChosaChikuName = txtChosaChikuName;
    }

    /*
     * getbtnInsert
     * @return btnInsert
     */
    @JsonProperty("btnInsert")
    public Button getBtnInsert() {
        return btnInsert;
    }

    /*
     * setbtnInsert
     * @param btnInsert btnInsert
     */
    @JsonProperty("btnInsert")
    public void setBtnInsert(Button btnInsert) {
        this.btnInsert = btnInsert;
    }

    /*
     * getdgChosaChikuChichosonList
     * @return dgChosaChikuChichosonList
     */
    @JsonProperty("dgChosaChikuChichosonList")
    public DataGrid<dgChosaChikuChichosonList_Row> getDgChosaChikuChichosonList() {
        return dgChosaChikuChichosonList;
    }

    /*
     * setdgChosaChikuChichosonList
     * @param dgChosaChikuChichosonList dgChosaChikuChichosonList
     */
    @JsonProperty("dgChosaChikuChichosonList")
    public void setDgChosaChikuChichosonList(DataGrid<dgChosaChikuChichosonList_Row> dgChosaChikuChichosonList) {
        this.dgChosaChikuChichosonList = dgChosaChikuChichosonList;
    }

    // </editor-fold>
}
