package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ResultListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ResultListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-54-17">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgResultList")
    private DataGrid<dgResultList_Row> dgResultList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgResultList
     * @return dgResultList
     */
    @JsonProperty("dgResultList")
    public DataGrid<dgResultList_Row> getDgResultList() {
        return dgResultList;
    }

    /*
     * setdgResultList
     * @param dgResultList dgResultList
     */
    @JsonProperty("dgResultList")
    public void setDgResultList(DataGrid<dgResultList_Row> dgResultList) {
        this.dgResultList = dgResultList;
    }

    // </editor-fold>
}
