package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PayToKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PayToMadoguchiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PaymentDate のクラスファイル 
 * 
 * @author 自動生成
 */
public class PaymentDateDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PayToKoza")
    private PayToKozaDiv PayToKoza;
    @JsonProperty("PayToMadoguchi")
    private PayToMadoguchiDiv PayToMadoguchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("PayToKoza")
    public PayToKozaDiv getPayToKoza() {
        return PayToKoza;
    }

    @JsonProperty("PayToKoza")
    public void setPayToKoza(PayToKozaDiv PayToKoza) {
        this.PayToKoza=PayToKoza;
    }

    @JsonProperty("PayToMadoguchi")
    public PayToMadoguchiDiv getPayToMadoguchi() {
        return PayToMadoguchi;
    }

    @JsonProperty("PayToMadoguchi")
    public void setPayToMadoguchi(PayToMadoguchiDiv PayToMadoguchi) {
        this.PayToMadoguchi=PayToMadoguchi;
    }

}
