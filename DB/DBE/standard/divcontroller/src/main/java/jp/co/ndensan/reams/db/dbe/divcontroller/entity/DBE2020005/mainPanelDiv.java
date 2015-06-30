package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020005.dgChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020005.dgNinteiChosainList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * mainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class mainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaChikuPanel")
    private ChosaChikuPanelDiv ChosaChikuPanel;
    @JsonProperty("NinteiChosainPanel")
    private NinteiChosainPanelDiv NinteiChosainPanel;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ChosaChikuPanel")
    public ChosaChikuPanelDiv getChosaChikuPanel() {
        return ChosaChikuPanel;
    }

    @JsonProperty("ChosaChikuPanel")
    public void setChosaChikuPanel(ChosaChikuPanelDiv ChosaChikuPanel) {
        this.ChosaChikuPanel=ChosaChikuPanel;
    }

    @JsonProperty("NinteiChosainPanel")
    public NinteiChosainPanelDiv getNinteiChosainPanel() {
        return NinteiChosainPanel;
    }

    @JsonProperty("NinteiChosainPanel")
    public void setNinteiChosainPanel(NinteiChosainPanelDiv NinteiChosainPanel) {
        this.NinteiChosainPanel=NinteiChosainPanel;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgChosaChikuList_Row> getDgChosaChikuList() {
        return this.getChosaChikuPanel().getDgChosaChikuList();
    }

    @JsonIgnore
    public void  setDgChosaChikuList(DataGrid<dgChosaChikuList_Row> dgChosaChikuList) {
        this.getChosaChikuPanel().setDgChosaChikuList(dgChosaChikuList);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosainList_Row> getDgNinteiChosainList() {
        return this.getNinteiChosainPanel().getDgNinteiChosainList();
    }

    @JsonIgnore
    public void  setDgNinteiChosainList(DataGrid<dgNinteiChosainList_Row> dgNinteiChosainList) {
        this.getNinteiChosainPanel().setDgNinteiChosainList(dgNinteiChosainList);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getNinteiChosainPanel().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getNinteiChosainPanel().setBtnDelete(btnDelete);
    }

    @JsonIgnore
    public Button getBtnInsert() {
        return this.getNinteiChosainPanel().getBtnInsert();
    }

    @JsonIgnore
    public void  setBtnInsert(Button btnInsert) {
        this.getNinteiChosainPanel().setBtnInsert(btnInsert);
    }

    // </editor-fold>
}
