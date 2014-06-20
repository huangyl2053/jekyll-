package jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JuryoininJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JuryoininJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KozaPayment.KozaPaymentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PaymentMethod のクラスファイル 
 * 
 * @author 自動生成
 */
public class PaymentMethodDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radPayMethod")
    private RadioButton radPayMethod;
    @JsonProperty("JuryoininJoho")
    private JuryoininJohoDiv JuryoininJoho;
    @JsonProperty("KozaPayment")
    private KozaPaymentDiv KozaPayment;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radPayMethod")
    public RadioButton getRadPayMethod() {
        return radPayMethod;
    }

    @JsonProperty("radPayMethod")
    public void setRadPayMethod(RadioButton radPayMethod) {
        this.radPayMethod=radPayMethod;
    }

    @JsonProperty("JuryoininJoho")
    public JuryoininJohoDiv getJuryoininJoho() {
        return JuryoininJoho;
    }

    @JsonProperty("JuryoininJoho")
    public void setJuryoininJoho(JuryoininJohoDiv JuryoininJoho) {
        this.JuryoininJoho=JuryoininJoho;
    }

    @JsonProperty("KozaPayment")
    public KozaPaymentDiv getKozaPayment() {
        return KozaPayment;
    }

    @JsonProperty("KozaPayment")
    public void setKozaPayment(KozaPaymentDiv KozaPayment) {
        this.KozaPayment=KozaPayment;
    }

}
