package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplJizenShinseiPayMethod のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplJizenShinseiPayMethodDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PaymentMethod")
    private PaymentMethodDiv PaymentMethod;
    @JsonProperty("spTab3")
    private Space spTab3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("PaymentMethod")
    public PaymentMethodDiv getPaymentMethod() {
        return PaymentMethod;
    }

    @JsonProperty("PaymentMethod")
    public void setPaymentMethod(PaymentMethodDiv PaymentMethod) {
        this.PaymentMethod=PaymentMethod;
    }

    @JsonProperty("spTab3")
    public Space getSpTab3() {
        return spTab3;
    }

    @JsonProperty("spTab3")
    public void setSpTab3(Space spTab3) {
        this.spTab3=spTab3;
    }

}
