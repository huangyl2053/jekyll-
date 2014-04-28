package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiSummaryDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServiceJikoSakusei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServiceJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuServiceJikoSakuseiSummary")
    private KyotakuServiceJikoSakuseiSummaryDiv KyotakuServiceJikoSakuseiSummary;
    @JsonProperty("dgKyotakuServiceJikoSakusei")
    private DataGrid<dgKyotakuServiceJikoSakusei_Row> dgKyotakuServiceJikoSakusei;
    @JsonProperty("KyotakuServiceJikoSakuseiDetail")
    private KyotakuServiceJikoSakuseiDetailDiv KyotakuServiceJikoSakuseiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuServiceJikoSakuseiSummary")
    public KyotakuServiceJikoSakuseiSummaryDiv getKyotakuServiceJikoSakuseiSummary() {
        return KyotakuServiceJikoSakuseiSummary;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiSummary")
    public void setKyotakuServiceJikoSakuseiSummary(KyotakuServiceJikoSakuseiSummaryDiv KyotakuServiceJikoSakuseiSummary) {
        this.KyotakuServiceJikoSakuseiSummary=KyotakuServiceJikoSakuseiSummary;
    }

    @JsonProperty("dgKyotakuServiceJikoSakusei")
    public DataGrid<dgKyotakuServiceJikoSakusei_Row> getDgKyotakuServiceJikoSakusei() {
        return dgKyotakuServiceJikoSakusei;
    }

    @JsonProperty("dgKyotakuServiceJikoSakusei")
    public void setDgKyotakuServiceJikoSakusei(DataGrid<dgKyotakuServiceJikoSakusei_Row> dgKyotakuServiceJikoSakusei) {
        this.dgKyotakuServiceJikoSakusei=dgKyotakuServiceJikoSakusei;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiDetail")
    public KyotakuServiceJikoSakuseiDetailDiv getKyotakuServiceJikoSakuseiDetail() {
        return KyotakuServiceJikoSakuseiDetail;
    }

    @JsonProperty("KyotakuServiceJikoSakuseiDetail")
    public void setKyotakuServiceJikoSakuseiDetail(KyotakuServiceJikoSakuseiDetailDiv KyotakuServiceJikoSakuseiDetail) {
        this.KyotakuServiceJikoSakuseiDetail=KyotakuServiceJikoSakuseiDetail;
    }

}
