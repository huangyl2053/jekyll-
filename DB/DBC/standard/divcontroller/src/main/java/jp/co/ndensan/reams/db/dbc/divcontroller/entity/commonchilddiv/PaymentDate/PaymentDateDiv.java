package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.paymentdate.PaymentDateHandler;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * PaymentDate のクラスファイル
 *
 * @author 自動生成
 */
public class PaymentDateDiv extends Panel implements IPaymentDateDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    /*
     * getPayToKoza
     * @return PayToKoza
     */
    @JsonProperty("PayToKoza")
    public PayToKozaDiv getPayToKoza() {
        return PayToKoza;
    }

    /*
     * setPayToKoza
     * @param PayToKoza PayToKoza
     */
    @JsonProperty("PayToKoza")
    public void setPayToKoza(PayToKozaDiv PayToKoza) {
        this.PayToKoza = PayToKoza;
    }

    /*
     * getPayToMadoguchi
     * @return PayToMadoguchi
     */
    @JsonProperty("PayToMadoguchi")
    public PayToMadoguchiDiv getPayToMadoguchi() {
        return PayToMadoguchi;
    }

    /*
     * setPayToMadoguchi
     * @param PayToMadoguchi PayToMadoguchi
     */
    @JsonProperty("PayToMadoguchi")
    public void setPayToMadoguchi(PayToMadoguchiDiv PayToMadoguchi) {
        this.PayToMadoguchi = PayToMadoguchi;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void onLoad(RString 支払方法機能区分) {
        PaymentDateHandler.of(this).onLoad(支払方法機能区分);
    }

    @JsonIgnore
    @Override
    public RDate get振込予定日() {
        return this.getPayToKoza().getTxtKozaPaymentDate().getValue();
    }

    @JsonIgnore
    @Override
    public RString get支払場所() {
        return this.getPayToMadoguchi().getTxtShiharaiBasho().getValue();
    }

    @JsonIgnore
    @Override
    public RDate get支払期間FROM() {
        return this.getPayToMadoguchi().getTxtShiharaiDateRange().getFromValue();
    }

    @JsonIgnore
    @Override
    public RDate get支払期間TO() {
        return this.getPayToMadoguchi().getTxtShiharaiDateRange().getToValue();
    }

    @JsonIgnore
    @Override
    public RTime get開始時間() {
        return this.getPayToMadoguchi().getTxtShiharaiKaishiTime().getValue();
    }

    @JsonIgnore
    @Override
    public RTime get終了時間() {
        return this.getPayToMadoguchi().getTxtShiharaiShuryoTime().getValue();
    }

    @JsonIgnore
    @Override
    public ValidationMessageControlPairs getCheckMessage() {
        return PaymentDateHandler.of(this).getCheckMessage();
    }
}
