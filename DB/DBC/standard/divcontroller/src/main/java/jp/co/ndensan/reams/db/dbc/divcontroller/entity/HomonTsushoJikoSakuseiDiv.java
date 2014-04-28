package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HomonTsushoJikoSakuseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HomonTsushoJikoSakuseiSummaryDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgHomonTushoJikoSakusei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HomonTsushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonTsushoJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HomonTsushoJikoSakuseiSummary")
    private HomonTsushoJikoSakuseiSummaryDiv HomonTsushoJikoSakuseiSummary;
    @JsonProperty("dgHomonTushoJikoSakusei")
    private DataGrid<dgHomonTushoJikoSakusei_Row> dgHomonTushoJikoSakusei;
    @JsonProperty("HomonTsushoJikoSakuseiDetail")
    private HomonTsushoJikoSakuseiDetailDiv HomonTsushoJikoSakuseiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HomonTsushoJikoSakuseiSummary")
    public HomonTsushoJikoSakuseiSummaryDiv getHomonTsushoJikoSakuseiSummary() {
        return HomonTsushoJikoSakuseiSummary;
    }

    @JsonProperty("HomonTsushoJikoSakuseiSummary")
    public void setHomonTsushoJikoSakuseiSummary(HomonTsushoJikoSakuseiSummaryDiv HomonTsushoJikoSakuseiSummary) {
        this.HomonTsushoJikoSakuseiSummary=HomonTsushoJikoSakuseiSummary;
    }

    @JsonProperty("dgHomonTushoJikoSakusei")
    public DataGrid<dgHomonTushoJikoSakusei_Row> getDgHomonTushoJikoSakusei() {
        return dgHomonTushoJikoSakusei;
    }

    @JsonProperty("dgHomonTushoJikoSakusei")
    public void setDgHomonTushoJikoSakusei(DataGrid<dgHomonTushoJikoSakusei_Row> dgHomonTushoJikoSakusei) {
        this.dgHomonTushoJikoSakusei=dgHomonTushoJikoSakusei;
    }

    @JsonProperty("HomonTsushoJikoSakuseiDetail")
    public HomonTsushoJikoSakuseiDetailDiv getHomonTsushoJikoSakuseiDetail() {
        return HomonTsushoJikoSakuseiDetail;
    }

    @JsonProperty("HomonTsushoJikoSakuseiDetail")
    public void setHomonTsushoJikoSakuseiDetail(HomonTsushoJikoSakuseiDetailDiv HomonTsushoJikoSakuseiDetail) {
        this.HomonTsushoJikoSakuseiDetail=HomonTsushoJikoSakuseiDetail;
    }

}
