package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeCommonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeJikoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceTodokedeInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceTodokedeInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuServiceTodokedeCommon")
    private KyotakuServiceTodokedeCommonDiv KyotakuServiceTodokedeCommon;
    @JsonProperty("KyotakuServiceTodokedeJigyosha")
    private KyotakuServiceTodokedeJigyoshaDiv KyotakuServiceTodokedeJigyosha;
    @JsonProperty("KyotakuServiceTodokedeJiko")
    private KyotakuServiceTodokedeJikoDiv KyotakuServiceTodokedeJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuServiceTodokedeCommon")
    public KyotakuServiceTodokedeCommonDiv getKyotakuServiceTodokedeCommon() {
        return KyotakuServiceTodokedeCommon;
    }

    @JsonProperty("KyotakuServiceTodokedeCommon")
    public void setKyotakuServiceTodokedeCommon(KyotakuServiceTodokedeCommonDiv KyotakuServiceTodokedeCommon) {
        this.KyotakuServiceTodokedeCommon=KyotakuServiceTodokedeCommon;
    }

    @JsonProperty("KyotakuServiceTodokedeJigyosha")
    public KyotakuServiceTodokedeJigyoshaDiv getKyotakuServiceTodokedeJigyosha() {
        return KyotakuServiceTodokedeJigyosha;
    }

    @JsonProperty("KyotakuServiceTodokedeJigyosha")
    public void setKyotakuServiceTodokedeJigyosha(KyotakuServiceTodokedeJigyoshaDiv KyotakuServiceTodokedeJigyosha) {
        this.KyotakuServiceTodokedeJigyosha=KyotakuServiceTodokedeJigyosha;
    }

    @JsonProperty("KyotakuServiceTodokedeJiko")
    public KyotakuServiceTodokedeJikoDiv getKyotakuServiceTodokedeJiko() {
        return KyotakuServiceTodokedeJiko;
    }

    @JsonProperty("KyotakuServiceTodokedeJiko")
    public void setKyotakuServiceTodokedeJiko(KyotakuServiceTodokedeJikoDiv KyotakuServiceTodokedeJiko) {
        this.KyotakuServiceTodokedeJiko=KyotakuServiceTodokedeJiko;
    }

}
