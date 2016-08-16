package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiChushutsuJokenKoikiPanel のクラスファイル
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class KoikiChushutsuJokenKoikiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShichosonIchiran")
    private DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShichosonIchiran
     * @return dgShichosonIchiran
     */
    @JsonProperty("dgShichosonIchiran")
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return dgShichosonIchiran;
    }

    /*
     * setdgShichosonIchiran
     * @param dgShichosonIchiran dgShichosonIchiran
     */
    @JsonProperty("dgShichosonIchiran")
    public void setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.dgShichosonIchiran = dgShichosonIchiran;
    }

    // </editor-fold>
}
