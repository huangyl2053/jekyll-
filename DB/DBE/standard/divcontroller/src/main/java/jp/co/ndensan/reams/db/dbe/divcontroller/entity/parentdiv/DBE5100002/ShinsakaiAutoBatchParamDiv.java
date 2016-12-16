package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinsakaiAutoBatchParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiAutoBatchParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiIchiran")
    private DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShinsakaiIchiran
     * @return dgShinsakaiIchiran
     */
    @JsonProperty("dgShinsakaiIchiran")
    public DataGrid<dgShinsakaiIchiran_Row> getDgShinsakaiIchiran() {
        return dgShinsakaiIchiran;
    }

    /*
     * setdgShinsakaiIchiran
     * @param dgShinsakaiIchiran dgShinsakaiIchiran
     */
    @JsonProperty("dgShinsakaiIchiran")
    public void setDgShinsakaiIchiran(DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran) {
        this.dgShinsakaiIchiran = dgShinsakaiIchiran;
    }

    // </editor-fold>
}
