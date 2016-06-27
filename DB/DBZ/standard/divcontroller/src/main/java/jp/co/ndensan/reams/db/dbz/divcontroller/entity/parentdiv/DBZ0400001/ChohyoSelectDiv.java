package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChohyoSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChohyoSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChohyoIchiran")
    private DataGrid<dgChohyoIchiran_Row> dgChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChohyoIchiran
     * @return dgChohyoIchiran
     */
    @JsonProperty("dgChohyoIchiran")
    public DataGrid<dgChohyoIchiran_Row> getDgChohyoIchiran() {
        return dgChohyoIchiran;
    }

    /*
     * setdgChohyoIchiran
     * @param dgChohyoIchiran dgChohyoIchiran
     */
    @JsonProperty("dgChohyoIchiran")
    public void setDgChohyoIchiran(DataGrid<dgChohyoIchiran_Row> dgChohyoIchiran) {
        this.dgChohyoIchiran = dgChohyoIchiran;
    }

    // </editor-fold>
}
