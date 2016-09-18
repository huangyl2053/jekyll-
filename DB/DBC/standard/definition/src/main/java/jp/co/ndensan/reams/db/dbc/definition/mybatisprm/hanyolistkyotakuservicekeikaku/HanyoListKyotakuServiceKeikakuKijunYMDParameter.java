/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkyotakuservicekeikaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 汎用リスト 居宅サービス計画のMybatisParameterクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyotakuServiceKeikakuKijunYMDParameter
        implements IMyBatisParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final FlexibleDate 基準年月日;

    /**
     * コンストラクタ
     *
     * @param 被保険者番号 RString
     * @param 対象年月 FlexibleYearMonth
     * @param 基準年月日 FlexibleDate
     */
    public HanyoListKyotakuServiceKeikakuKijunYMDParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            FlexibleDate 基準年月日) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.基準年月日 = 基準年月日;
    }

}
