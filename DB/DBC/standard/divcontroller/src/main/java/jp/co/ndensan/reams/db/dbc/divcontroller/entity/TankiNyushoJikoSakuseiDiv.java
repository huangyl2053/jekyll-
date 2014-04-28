package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TankiNyushoJikoSakuseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TankiNyushoJikoSakuseiSummaryDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTankiNyushoJikoSakusei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TankiNyushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TankiNyushoJikoSakuseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TankiNyushoJikoSakuseiSummary")
    private TankiNyushoJikoSakuseiSummaryDiv TankiNyushoJikoSakuseiSummary;
    @JsonProperty("dgTankiNyushoJikoSakusei")
    private DataGrid<dgTankiNyushoJikoSakusei_Row> dgTankiNyushoJikoSakusei;
    @JsonProperty("TankiNyushoJikoSakuseiDetail")
    private TankiNyushoJikoSakuseiDetailDiv TankiNyushoJikoSakuseiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TankiNyushoJikoSakuseiSummary")
    public TankiNyushoJikoSakuseiSummaryDiv getTankiNyushoJikoSakuseiSummary() {
        return TankiNyushoJikoSakuseiSummary;
    }

    @JsonProperty("TankiNyushoJikoSakuseiSummary")
    public void setTankiNyushoJikoSakuseiSummary(TankiNyushoJikoSakuseiSummaryDiv TankiNyushoJikoSakuseiSummary) {
        this.TankiNyushoJikoSakuseiSummary=TankiNyushoJikoSakuseiSummary;
    }

    @JsonProperty("dgTankiNyushoJikoSakusei")
    public DataGrid<dgTankiNyushoJikoSakusei_Row> getDgTankiNyushoJikoSakusei() {
        return dgTankiNyushoJikoSakusei;
    }

    @JsonProperty("dgTankiNyushoJikoSakusei")
    public void setDgTankiNyushoJikoSakusei(DataGrid<dgTankiNyushoJikoSakusei_Row> dgTankiNyushoJikoSakusei) {
        this.dgTankiNyushoJikoSakusei=dgTankiNyushoJikoSakusei;
    }

    @JsonProperty("TankiNyushoJikoSakuseiDetail")
    public TankiNyushoJikoSakuseiDetailDiv getTankiNyushoJikoSakuseiDetail() {
        return TankiNyushoJikoSakuseiDetail;
    }

    @JsonProperty("TankiNyushoJikoSakuseiDetail")
    public void setTankiNyushoJikoSakuseiDetail(TankiNyushoJikoSakuseiDetailDiv TankiNyushoJikoSakuseiDetail) {
        this.TankiNyushoJikoSakuseiDetail=TankiNyushoJikoSakuseiDetail;
    }

}
