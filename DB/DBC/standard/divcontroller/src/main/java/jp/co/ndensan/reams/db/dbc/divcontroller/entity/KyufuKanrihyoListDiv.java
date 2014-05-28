package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuKanrihyoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuKanrihyoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuKanrihyoListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyufuKanrihyoList")
    private DataGrid<dgKyufuKanrihyoList_Row> dgKyufuKanrihyoList;
    @JsonProperty("btnResearch")
    private Button btnResearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKyufuKanrihyoList")
    public DataGrid<dgKyufuKanrihyoList_Row> getDgKyufuKanrihyoList() {
        return dgKyufuKanrihyoList;
    }

    @JsonProperty("dgKyufuKanrihyoList")
    public void setDgKyufuKanrihyoList(DataGrid<dgKyufuKanrihyoList_Row> dgKyufuKanrihyoList) {
        this.dgKyufuKanrihyoList=dgKyufuKanrihyoList;
    }

    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch=btnResearch;
    }

}
