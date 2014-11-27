package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IPaymentMethodDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.JuryoininJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KozaPayment.IKozaPaymentDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KozaPayment.KozaPaymentDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.MadoguchiPaymentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PaymentMethod のクラスファイル 
 * 
 * @author 自動生成
 */
public class PaymentMethodDiv extends Panel implements IPaymentMethodDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radPayMethod1")
    private RadioButton radPayMethod1;
    @JsonProperty("JuryoininJoho")
    private JuryoininJohoDiv JuryoininJoho;
    @JsonProperty("radPayMethod2")
    private RadioButton radPayMethod2;
    @JsonProperty("KozaPayment")
    private KozaPaymentDiv KozaPayment;
    @JsonProperty("radPayMethod3")
    private RadioButton radPayMethod3;
    @JsonProperty("MadoguchiPayment")
    private MadoguchiPaymentDiv MadoguchiPayment;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radPayMethod1")
    public RadioButton getRadPayMethod1() {
        return radPayMethod1;
    }

    @JsonProperty("radPayMethod1")
    public void setRadPayMethod1(RadioButton radPayMethod1) {
        this.radPayMethod1=radPayMethod1;
    }

    @JsonProperty("JuryoininJoho")
    public JuryoininJohoDiv getJuryoininJoho() {
        return JuryoininJoho;
    }

    @JsonProperty("JuryoininJoho")
    public void setJuryoininJoho(JuryoininJohoDiv JuryoininJoho) {
        this.JuryoininJoho=JuryoininJoho;
    }

    @JsonProperty("radPayMethod2")
    public RadioButton getRadPayMethod2() {
        return radPayMethod2;
    }

    @JsonProperty("radPayMethod2")
    public void setRadPayMethod2(RadioButton radPayMethod2) {
        this.radPayMethod2=radPayMethod2;
    }

    @JsonProperty("KozaPayment")
    public IKozaPaymentDiv getKozaPayment() {
        return KozaPayment;
    }

    @JsonProperty("radPayMethod3")
    public RadioButton getRadPayMethod3() {
        return radPayMethod3;
    }

    @JsonProperty("radPayMethod3")
    public void setRadPayMethod3(RadioButton radPayMethod3) {
        this.radPayMethod3=radPayMethod3;
    }

    @JsonProperty("MadoguchiPayment")
    public MadoguchiPaymentDiv getMadoguchiPayment() {
        return MadoguchiPayment;
    }

    @JsonProperty("MadoguchiPayment")
    public void setMadoguchiPayment(MadoguchiPaymentDiv MadoguchiPayment) {
        this.MadoguchiPayment=MadoguchiPayment;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
