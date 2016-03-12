package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaChikuGroupList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaChikuGroupListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChosaChikuGroupList")
    private DataGrid<dgChosaChikuGroupList_Row> dgChosaChikuGroupList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChosaChikuGroupList
     * @return dgChosaChikuGroupList
     */
    @JsonProperty("dgChosaChikuGroupList")
    public DataGrid<dgChosaChikuGroupList_Row> getDgChosaChikuGroupList() {
        return dgChosaChikuGroupList;
    }

    /*
     * setdgChosaChikuGroupList
     * @param dgChosaChikuGroupList dgChosaChikuGroupList
     */
    @JsonProperty("dgChosaChikuGroupList")
    public void setDgChosaChikuGroupList(DataGrid<dgChosaChikuGroupList_Row> dgChosaChikuGroupList) {
        this.dgChosaChikuGroupList = dgChosaChikuGroupList;
    }

    // </editor-fold>
}
