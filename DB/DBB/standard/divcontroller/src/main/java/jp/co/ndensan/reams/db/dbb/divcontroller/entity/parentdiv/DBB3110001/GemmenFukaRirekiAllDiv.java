package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenFukaRirekiAll のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenFukaRirekiAllDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dghukainfo")
    private DataGrid<dghukainfo_Row> dghukainfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdghukainfo
     * @return dghukainfo
     */
    @JsonProperty("dghukainfo")
    public DataGrid<dghukainfo_Row> getDghukainfo() {
        return dghukainfo;
    }

    /*
     * setdghukainfo
     * @param dghukainfo dghukainfo
     */
    @JsonProperty("dghukainfo")
    public void setDghukainfo(DataGrid<dghukainfo_Row> dghukainfo) {
        this.dghukainfo = dghukainfo;
    }

    // </editor-fold>
}
