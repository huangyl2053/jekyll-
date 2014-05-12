package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServicePlanIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServicePlanIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServicePlanIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyotakuServicePlanIchiran")
    private DataGrid<dgKyotakuServicePlanIchiran_Row> dgKyotakuServicePlanIchiran;
    @JsonProperty("KyotakuServiceTodokedeInfo")
    private KyotakuServiceTodokedeInfoDiv KyotakuServiceTodokedeInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgKyotakuServicePlanIchiran")
    public DataGrid<dgKyotakuServicePlanIchiran_Row> getDgKyotakuServicePlanIchiran() {
        return dgKyotakuServicePlanIchiran;
    }

    @JsonProperty("dgKyotakuServicePlanIchiran")
    public void setDgKyotakuServicePlanIchiran(DataGrid<dgKyotakuServicePlanIchiran_Row> dgKyotakuServicePlanIchiran) {
        this.dgKyotakuServicePlanIchiran=dgKyotakuServicePlanIchiran;
    }

    @JsonProperty("KyotakuServiceTodokedeInfo")
    public KyotakuServiceTodokedeInfoDiv getKyotakuServiceTodokedeInfo() {
        return KyotakuServiceTodokedeInfo;
    }

    @JsonProperty("KyotakuServiceTodokedeInfo")
    public void setKyotakuServiceTodokedeInfo(KyotakuServiceTodokedeInfoDiv KyotakuServiceTodokedeInfo) {
        this.KyotakuServiceTodokedeInfo=KyotakuServiceTodokedeInfo;
    }

}
