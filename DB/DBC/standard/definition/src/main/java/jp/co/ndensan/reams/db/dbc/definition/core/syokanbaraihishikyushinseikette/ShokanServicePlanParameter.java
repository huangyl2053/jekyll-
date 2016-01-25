/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス計画費登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanServicePlanParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final RString 連番;
    private final RString 事業者区分コード;
    private final FlexibleDate 届出日;
    private final ServiceCode サービスコード;
    private final int 単位数;
    private final Decimal 単位数単価;
    private final RString 担当介護支援専門員番号;
    private final RString 摘要;
    private final RString 審査方法コード;
    private final int 請求金額;
    private final List<ShokanServicePlanEntity> サービルList;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 連番
     * @param 事業者区分コード
     * @param 届出日
     * @param サービスコード
     * @param 単位数
     * @param サービス単位数
     * @param 単位数単価
     * @param 担当介護支援専門員番号
     * @param 摘要
     * @param 審査方法コード
     * @param 請求金額
     * @param サービルList
     */
    protected ShokanServicePlanParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号, RString 連番,
            RString 事業者区分コード, FlexibleDate 届出日, ServiceCode サービスコード, int 単位数,
            int サービス単位数, Decimal 単位数単価, RString 担当介護支援専門員番号, RString 摘要,
            RString 審査方法コード, int 請求金額, List<ShokanServicePlanEntity> サービルList) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.事業者区分コード = 事業者区分コード;
        this.届出日 = 届出日;
        this.サービスコード = サービスコード;
        this.単位数 = 単位数;
        this.単位数単価 = 単位数単価;
        this.担当介護支援専門員番号 = 担当介護支援専門員番号;
        this.摘要 = 摘要;
        this.審査方法コード = 審査方法コード;
        this.請求金額 = 請求金額;
        this.サービルList = サービルList;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 連番
     * @param 事業者区分コード
     * @param 届出日
     * @param サービスコード
     * @param 単位数
     * @param 単位数単価
     * @param 担当介護支援専門員番号
     * @param 摘要
     * @param 審査方法コード
     * @param 請求金額
     * @param サービルList
     * @return
     */
    public static ShokanServicePlanParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号, RString 証明書コード,
            RString 明細番号, RString 連番, RString 事業者区分コード, FlexibleDate 届出日, ServiceCode サービスコード,
            int 単位数, Decimal 単位数単価, RString 担当介護支援専門員番号, RString 摘要, RString 審査方法コード,
            int 請求金額, List<ShokanServicePlanEntity> サービルList) {
        return new ShokanServicePlanParameter(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 証明書コード,
                明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数, 単位数単価,
                担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
    }
}
