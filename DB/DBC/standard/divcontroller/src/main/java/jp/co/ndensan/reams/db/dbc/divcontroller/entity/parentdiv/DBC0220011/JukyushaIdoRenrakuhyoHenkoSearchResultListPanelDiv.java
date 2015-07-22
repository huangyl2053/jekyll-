package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoHenkoSearchResultListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    private DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResult;
    @JsonProperty("btnResearch")
    private Button btnResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    public DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> getDgJukyushaIdoRenrakuhyoHenkoSearchResult() {
        return dgJukyushaIdoRenrakuhyoHenkoSearchResult;
    }

    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResult")
    public void setDgJukyushaIdoRenrakuhyoHenkoSearchResult(DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResult) {
        this.dgJukyushaIdoRenrakuhyoHenkoSearchResult=dgJukyushaIdoRenrakuhyoHenkoSearchResult;
    }

    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch=btnResearch;
    }

    // </editor-fold>
}
