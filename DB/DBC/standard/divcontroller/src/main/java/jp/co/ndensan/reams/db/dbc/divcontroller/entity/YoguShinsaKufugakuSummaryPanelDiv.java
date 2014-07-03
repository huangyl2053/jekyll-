package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaKufugakuSummarySubDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaShoninDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguShinsaKufugakuSummaryPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguShinsaKufugakuSummaryPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoguShinsaKufugakuSummarySub")
    private YoguShinsaKufugakuSummarySubDiv YoguShinsaKufugakuSummarySub;
    @JsonProperty("YoguShinsaShonin")
    private YoguShinsaShoninDiv YoguShinsaShonin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguShinsaKufugakuSummarySub")
    public YoguShinsaKufugakuSummarySubDiv getYoguShinsaKufugakuSummarySub() {
        return YoguShinsaKufugakuSummarySub;
    }

    @JsonProperty("YoguShinsaKufugakuSummarySub")
    public void setYoguShinsaKufugakuSummarySub(YoguShinsaKufugakuSummarySubDiv YoguShinsaKufugakuSummarySub) {
        this.YoguShinsaKufugakuSummarySub=YoguShinsaKufugakuSummarySub;
    }

    @JsonProperty("YoguShinsaShonin")
    public YoguShinsaShoninDiv getYoguShinsaShonin() {
        return YoguShinsaShonin;
    }

    @JsonProperty("YoguShinsaShonin")
    public void setYoguShinsaShonin(YoguShinsaShoninDiv YoguShinsaShonin) {
        this.YoguShinsaShonin=YoguShinsaShonin;
    }

}
