package jp.co.ndensan.reams.db.dbb.divcontroller.entity.HonKakushuTsuchiUchiwakeKakunin;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.HonKakushuTsuchiUchiwakeKakunin.dgKakushuTsuchiUchiwakeSentaku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonKakushuTsuchiUchiwakeSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonKakushuTsuchiUchiwakeSentakuDiv extends Panel {
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
    @JsonProperty("dgKakushuTsuchiUchiwakeSentaku")
    public DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> getDgKakushuTsuchiUchiwakeSentaku() {
        return dgKakushuTsuchiUchiwakeSentaku;
    }

    @JsonProperty("dgKakushuTsuchiUchiwakeSentaku")
    public void setDgKakushuTsuchiUchiwakeSentaku(DataGrid<dgKakushuTsuchiUchiwakeSentaku_Row> dgKakushuTsuchiUchiwakeSentaku) {
        this.dgKakushuTsuchiUchiwakeSentaku=dgKakushuTsuchiUchiwakeSentaku;
    }

}
