package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaChikuPanel のクラスファイル
 *
 */
public class ChosaChikuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChosaChikuList")
    private DataGrid<dgChosaChikuList_Row> dgChosaChikuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChosaChikuList
     * @return dgChosaChikuList
     */
    @JsonProperty("dgChosaChikuList")
    public DataGrid<dgChosaChikuList_Row> getDgChosaChikuList() {
        return dgChosaChikuList;
    }

    /*
     * setdgChosaChikuList
     * @param dgChosaChikuList dgChosaChikuList
     */
    @JsonProperty("dgChosaChikuList")
    public void setDgChosaChikuList(DataGrid<dgChosaChikuList_Row> dgChosaChikuList) {
        this.dgChosaChikuList = dgChosaChikuList;
    }

    // </editor-fold>
}
