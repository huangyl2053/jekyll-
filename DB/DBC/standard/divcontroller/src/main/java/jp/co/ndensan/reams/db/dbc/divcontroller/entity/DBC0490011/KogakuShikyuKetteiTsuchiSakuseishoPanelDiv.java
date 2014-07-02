package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0490011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * KogakuShikyuKetteiTsuchiSakuseishoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class KogakuShikyuKetteiTsuchiSakuseishoPanelDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoHakkoDate")
    private PrintContentsSettingDiv KogakuShikyuKetteiTsuchiSakuseishoHakkoDate;
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoLabel1")
    private Label KogakuShikyuKetteiTsuchiSakuseishoLabel1;
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod")
    private PaymentDateDiv KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod;
    @JsonProperty("CommonKariChildDiv2")
    private KaigoChohyoShutsuryokujunDiv CommonKariChildDiv2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoHakkoDate")
    public PrintContentsSettingDiv getKogakuShikyuKetteiTsuchiSakuseishoHakkoDate() {
        return KogakuShikyuKetteiTsuchiSakuseishoHakkoDate;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoHakkoDate")
    public void setKogakuShikyuKetteiTsuchiSakuseishoHakkoDate(PrintContentsSettingDiv KogakuShikyuKetteiTsuchiSakuseishoHakkoDate) {
        this.KogakuShikyuKetteiTsuchiSakuseishoHakkoDate = KogakuShikyuKetteiTsuchiSakuseishoHakkoDate;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoLabel1")
    public Label getKogakuShikyuKetteiTsuchiSakuseishoLabel1() {
        return KogakuShikyuKetteiTsuchiSakuseishoLabel1;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoLabel1")
    public void setKogakuShikyuKetteiTsuchiSakuseishoLabel1(Label KogakuShikyuKetteiTsuchiSakuseishoLabel1) {
        this.KogakuShikyuKetteiTsuchiSakuseishoLabel1 = KogakuShikyuKetteiTsuchiSakuseishoLabel1;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod")
    public PaymentDateDiv getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod() {
        return KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod;
    }

    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod")
    public void setKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod(PaymentDateDiv KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod) {
        this.KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod = KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod;
    }

    @JsonProperty("CommonKariChildDiv2")
    public KaigoChohyoShutsuryokujunDiv getCommonKariChildDiv2() {
        return CommonKariChildDiv2;
    }

    @JsonProperty("CommonKariChildDiv2")
    public void setCommonKariChildDiv2(KaigoChohyoShutsuryokujunDiv CommonKariChildDiv2) {
        this.CommonKariChildDiv2 = CommonKariChildDiv2;
    }

}
