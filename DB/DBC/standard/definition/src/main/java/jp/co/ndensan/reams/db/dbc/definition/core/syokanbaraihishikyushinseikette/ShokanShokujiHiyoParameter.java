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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 食事費用登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShokujiHiyoParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 提供購入年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final RString 連番;
    private final Decimal 基本提供日数;
    private final Decimal 基本提供単価;
    private final int 基本提供金額;
    private final Decimal 特別提供日数;
    private final Decimal 特別提供単価;
    private final int 特別提供金額;
    private final Decimal 食事提供延べ日数;
    private final int 食事提供費合計;
    private final int 標準負担月額;
    private final int 食事提供費請求額;
    private final Decimal 標準負担日額;
    private final List<ShokanShokujiHiyoEntity> 食事費用List;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 連番
     * @param 基本提供日数
     * @param 基本提供単価
     * @param 基本提供金額
     * @param 特別提供日数
     * @param 特別提供単価
     * @param 特別提供金額
     * @param 食事提供延べ日数
     * @param 食事提供費合計
     * @param 標準負担月額
     * @param 食事提供費請求額
     * @param 標準負担日額
     * @param 食事費用List
     */
    protected ShokanShokujiHiyoParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth 提供購入年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号, RString 連番, Decimal 基本提供日数,
            Decimal 基本提供単価, int 基本提供金額, Decimal 特別提供日数, Decimal 特別提供単価, int 特別提供金額,
            Decimal 食事提供延べ日数, int 食事提供費合計, int 標準負担月額,
            int 食事提供費請求額, Decimal 標準負担日額, List<ShokanShokujiHiyoEntity> 食事費用List) {
        this.被保険者番号 = 被保険者番号;
        this.提供購入年月 = 提供購入年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.基本提供日数 = 基本提供日数;
        this.基本提供単価 = 基本提供単価;
        this.基本提供金額 = 基本提供金額;
        this.特別提供日数 = 特別提供日数;
        this.特別提供単価 = 特別提供単価;
        this.特別提供金額 = 特別提供金額;
        this.食事提供延べ日数 = 食事提供延べ日数;
        this.食事提供費合計 = 食事提供費合計;
        this.標準負担月額 = 標準負担月額;
        this.食事提供費請求額 = 食事提供費請求額;
        this.標準負担日額 = 標準負担日額;
        this.食事費用List = 食事費用List;

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
     * @param 連番
     * @param 基本提供日数
     * @param 基本提供単価
     * @param 基本提供金額
     * @param 特別提供日数
     * @param 特別提供単価
     * @param 特別提供金額
     * @param 食事提供延べ日数
     * @param 食事提供費合計
     * @param 標準負担月額
     * @param 食事提供費請求額
     * @param 標準負担日額
     * @param 食事費用List
     * @return
     */
    public static ShokanShokujiHiyoParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号, FlexibleYearMonth 提供購入年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号, RString 連番, Decimal 基本提供日数,
            Decimal 基本提供単価, int 基本提供金額, Decimal 特別提供日数, Decimal 特別提供単価,
            int 特別提供金額, Decimal 食事提供延べ日数, int 食事提供費合計, int 標準負担月額,
            int 食事提供費請求額, Decimal 標準負担日額, List<ShokanShokujiHiyoEntity> 食事費用List) {
        return new ShokanShokujiHiyoParameter(被保険者番号, 提供購入年月, 整理番号, 事業者番号, 証明書コード,
                明細番号, 連番, 基本提供日数, 基本提供単価, 基本提供金額, 特別提供日数, 特別提供単価, 特別提供金額,
                食事提供延べ日数, 食事提供費合計, 標準負担月額, 食事提供費請求額, 標準負担日額, 食事費用List);
    }
}
