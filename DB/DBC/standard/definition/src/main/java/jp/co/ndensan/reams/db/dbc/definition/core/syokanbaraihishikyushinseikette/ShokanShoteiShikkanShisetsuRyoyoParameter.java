/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 緊急時・所定疾患登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShoteiShikkanShisetsuRyoyoParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 提供購入年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final List<ShokanShoteiShikkanShisetsuRyoyoEntity> 緊急時所定疾患List;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 緊急時所定疾患List
     */
    protected ShokanShoteiShikkanShisetsuRyoyoParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth 提供購入年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号,
            List<ShokanShoteiShikkanShisetsuRyoyoEntity> 緊急時所定疾患List) {
        this.被保険者番号 = 被保険者番号;
        this.提供購入年月 = 提供購入年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.緊急時所定疾患List = 緊急時所定疾患List;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 緊急時所定疾患List
     * @return
     */
    public static ShokanShoteiShikkanShisetsuRyoyoParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 提供購入年月, RString 整理番号, JigyoshaNo 事業者番号, RString 証明書コード,
            RString 明細番号, List<ShokanShoteiShikkanShisetsuRyoyoEntity> 緊急時所定疾患List) {
        return new ShokanShoteiShikkanShisetsuRyoyoParameter(被保険者番号, 提供購入年月, 整理番号, 事業者番号,
                証明書コード, 明細番号, 緊急時所定疾患List);
    }
}
