package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceRirekiIchiran のクラスファイル
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
public class KyotakuServiceRirekiIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyotakuServiceRirekiIchiran")
    private DataGrid<dgKyotakuServiceRirekiIchiran_Row> dgKyotakuServiceRirekiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKyotakuServiceRirekiIchiran
     * @return dgKyotakuServiceRirekiIchiran
     */
    @JsonProperty("dgKyotakuServiceRirekiIchiran")
    public DataGrid<dgKyotakuServiceRirekiIchiran_Row> getDgKyotakuServiceRirekiIchiran() {
        return dgKyotakuServiceRirekiIchiran;
    }

    /*
     * setdgKyotakuServiceRirekiIchiran
     * @param dgKyotakuServiceRirekiIchiran dgKyotakuServiceRirekiIchiran
     */
    @JsonProperty("dgKyotakuServiceRirekiIchiran")
    public void setDgKyotakuServiceRirekiIchiran(DataGrid<dgKyotakuServiceRirekiIchiran_Row> dgKyotakuServiceRirekiIchiran) {
        this.dgKyotakuServiceRirekiIchiran = dgKyotakuServiceRirekiIchiran;
    }

    // </editor-fold>
}
