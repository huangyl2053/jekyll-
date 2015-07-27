package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020008;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020008.dgChosaChikuGroupChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020008.dgChosaChikuGroupList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaChikuGroupList")
    private ChosaChikuGroupListDiv ChosaChikuGroupList;
    @JsonProperty("ChosaChikuGroupChosaChikuList")
    private ChosaChikuGroupChosaChikuListDiv ChosaChikuGroupChosaChikuList;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ChosaChikuGroupList")
    public ChosaChikuGroupListDiv getChosaChikuGroupList() {
        return ChosaChikuGroupList;
    }

    @JsonProperty("ChosaChikuGroupList")
    public void setChosaChikuGroupList(ChosaChikuGroupListDiv ChosaChikuGroupList) {
        this.ChosaChikuGroupList=ChosaChikuGroupList;
    }

    @JsonProperty("ChosaChikuGroupChosaChikuList")
    public ChosaChikuGroupChosaChikuListDiv getChosaChikuGroupChosaChikuList() {
        return ChosaChikuGroupChosaChikuList;
    }

    @JsonProperty("ChosaChikuGroupChosaChikuList")
    public void setChosaChikuGroupChosaChikuList(ChosaChikuGroupChosaChikuListDiv ChosaChikuGroupChosaChikuList) {
        this.ChosaChikuGroupChosaChikuList=ChosaChikuGroupChosaChikuList;
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
    public DataGrid<dgChosaChikuGroupList_Row> getDgChosaChikuGroupList() {
        return this.getChosaChikuGroupList().getDgChosaChikuGroupList();
    }

    @JsonIgnore
    public void  setDgChosaChikuGroupList(DataGrid<dgChosaChikuGroupList_Row> dgChosaChikuGroupList) {
        this.getChosaChikuGroupList().setDgChosaChikuGroupList(dgChosaChikuGroupList);
    }

    @JsonIgnore
    public DataGrid<dgChosaChikuGroupChosaChikuList_Row> getDgChosaChikuGroupChosaChikuList() {
        return this.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList();
    }

    @JsonIgnore
    public void  setDgChosaChikuGroupChosaChikuList(DataGrid<dgChosaChikuGroupChosaChikuList_Row> dgChosaChikuGroupChosaChikuList) {
        this.getChosaChikuGroupChosaChikuList().setDgChosaChikuGroupChosaChikuList(dgChosaChikuGroupChosaChikuList);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getChosaChikuGroupChosaChikuList().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getChosaChikuGroupChosaChikuList().setBtnDelete(btnDelete);
    }

    @JsonIgnore
    public Button getBtnInsert() {
        return this.getChosaChikuGroupChosaChikuList().getBtnInsert();
    }

    @JsonIgnore
    public void  setBtnInsert(Button btnInsert) {
        this.getChosaChikuGroupChosaChikuList().setBtnInsert(btnInsert);
    }

    // </editor-fold>
}
