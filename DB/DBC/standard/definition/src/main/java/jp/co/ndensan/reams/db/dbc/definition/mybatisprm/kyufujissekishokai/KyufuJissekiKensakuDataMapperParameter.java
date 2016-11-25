/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績情報照会検索データ取得用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufuJissekiKensakuDataMapperParameter {

    private final NyuryokuShikibetsuNo 入力識別番号;
    private final boolean has入力識別番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月_開始;
    private final FlexibleYearMonth サービス提供年月_終了;
    private final JigyoshaNo 事業所番号;
    private final RString 整理番号;
    private final FlexibleYearMonth サービス提供年月;
    private final boolean isKey0検索対象;

    /**
     * コンストラクタ
     *
     * @param 入力識別番号 入力識別番号
     * @param has入力識別番号 入力識別番号有無
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     */
    private KyufuJissekiKensakuDataMapperParameter(NyuryokuShikibetsuNo 入力識別番号, boolean has入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, FlexibleYearMonth サービス提供年月, boolean isKey0検索対象) {
        this.入力識別番号 = 入力識別番号;
        this.has入力識別番号 = has入力識別番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月_開始 = サービス提供年月_開始;
        this.サービス提供年月_終了 = サービス提供年月_終了;
        this.事業所番号 = 事業所番号;
        this.整理番号 = 整理番号;
        this.サービス提供年月 = サービス提供年月;
        this.isKey0検索対象 = isKey0検索対象;
    }

    /**
     * コンストラクタ
     *
     * @param 入力識別番号 入力識別番号
     * @param has入力識別番号 入力識別番号有無
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     */
    private KyufuJissekiKensakuDataMapperParameter(NyuryokuShikibetsuNo 入力識別番号, boolean has入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, FlexibleYearMonth サービス提供年月) {
        this.入力識別番号 = 入力識別番号;
        this.has入力識別番号 = has入力識別番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月_開始 = サービス提供年月_開始;
        this.サービス提供年月_終了 = サービス提供年月_終了;
        this.事業所番号 = 事業所番号;
        this.整理番号 = 整理番号;
        this.サービス提供年月 = サービス提供年月;
        this.isKey0検索対象 = false;
    }

    /**
     * 給付実績情報照会検索データ取得用のMyBatisパラメータを作成します。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param サービス提供年月 サービス提供年月
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績情報照会検索データ取得用のMyBatisパラメータ
     */
    public static KyufuJissekiKensakuDataMapperParameter createParameter_給付実績検索データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, FlexibleYearMonth サービス提供年月, boolean isKey0検索対象) {
        return new KyufuJissekiKensakuDataMapperParameter(入力識別番号, 入力識別番号 != null && !RString.isNullOrEmpty(入力識別番号.value()),
                被保険者番号, サービス提供年月_開始, サービス提供年月_終了, 事業所番号, 整理番号, サービス提供年月, isKey0検索対象);
    }

    /**
     * 給付実績情報照会検索データ取得用のMyBatisパラメータを作成します。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param サービス提供年月 サービス提供年月
     * @return 給付実績情報照会検索データ取得用のMyBatisパラメータ
     */
    public static KyufuJissekiKensakuDataMapperParameter createParameter_給付実績検索データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, FlexibleYearMonth サービス提供年月) {
        return new KyufuJissekiKensakuDataMapperParameter(入力識別番号, 入力識別番号 != null && !RString.isNullOrEmpty(入力識別番号.value()),
                被保険者番号, サービス提供年月_開始, サービス提供年月_終了, 事業所番号, 整理番号, サービス提供年月);
    }
}
