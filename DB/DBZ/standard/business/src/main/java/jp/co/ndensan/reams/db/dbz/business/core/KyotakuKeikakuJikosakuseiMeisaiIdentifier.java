/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 居宅給付計画自己作成明細の識別子です。
 */
@Value
public class KyotakuKeikakuJikosakuseiMeisaiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final Decimal 履歴番号;
    private final RString 居宅サービス区分;
    private final JigyoshaNo サービス提供事業者番号;
    private final ServiceShuruiCode サービス種類コード;
    private final ServiceKomokuCode サービス項目コード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     */
    public KyotakuKeikakuJikosakuseiMeisaiIdentifier(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
        this.居宅サービス区分 = 居宅サービス区分;
        this.サービス提供事業者番号 = サービス提供事業者番号;
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
    }

    /**
     * get被保険者番号
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * get対象年月
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return 対象年月;
    }

    /**
     * get履歴番号
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return 履歴番号;
    }

    /**
     * get居宅サービス区分
     *
     * @return 居宅サービス区分
     */
    public RString get居宅サービス区分() {
        return 居宅サービス区分;
    }

    /**
     * getサービス提供事業者番号
     *
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getサービス提供事業者番号() {
        return サービス提供事業者番号;
    }

    /**
     * getサービス種類コード
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return サービス種類コード;
    }

    /**
     * getサービス項目コード
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return サービス項目コード;
    }
}
