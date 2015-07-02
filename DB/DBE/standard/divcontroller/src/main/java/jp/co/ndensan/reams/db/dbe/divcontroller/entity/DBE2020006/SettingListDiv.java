package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SettingList のクラスファイル 
 * 
 * @author 自動生成
 */
public class SettingListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTimeScheduleList")
    private DataGrid<dgTimeScheduleList_Row> dgTimeScheduleList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgTimeScheduleList")
    public DataGrid<dgTimeScheduleList_Row> getDgTimeScheduleList() {
        return dgTimeScheduleList;
    }

    @JsonProperty("dgTimeScheduleList")
    public void setDgTimeScheduleList(DataGrid<dgTimeScheduleList_Row> dgTimeScheduleList) {
        this.dgTimeScheduleList=dgTimeScheduleList;
    }

    // </editor-fold>
}
