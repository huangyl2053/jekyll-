package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonKakushuTsuchiUchiwakeSentaku のクラスファイル
 *
 * @reamsid_L DBC-0780-020 gongliang
 */
public class HonKakushuTsuchiUchiwakeSentakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKakushuTsuchiUchiwakeSentaku")
    private DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> dgKakushuTsuchiUchiwakeSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKakushuTsuchiUchiwakeSentaku
     * @return dgKakushuTsuchiUchiwakeSentaku
     */
    @JsonProperty("dgKakushuTsuchiUchiwakeSentaku")
    public DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> getDgKakushuTsuchiUchiwakeSentaku() {
        return dgKakushuTsuchiUchiwakeSentaku;
    }

    /*
     * setdgKakushuTsuchiUchiwakeSentaku
     * @param dgKakushuTsuchiUchiwakeSentaku dgKakushuTsuchiUchiwakeSentaku
     */
    @JsonProperty("dgKakushuTsuchiUchiwakeSentaku")
    public void setDgKakushuTsuchiUchiwakeSentaku(DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> dgKakushuTsuchiUchiwakeSentaku) {
        this.dgKakushuTsuchiUchiwakeSentaku = dgKakushuTsuchiUchiwakeSentaku;
    }

    // </editor-fold>
}
