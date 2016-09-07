/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績ヘッダ情報取得用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufuJissekiHeaderJohoMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final RString 識別番号;
    private final JigyoshaNo 事業所番号;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタ
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別番号 識別番号
     * @param 事業所番号 事業所番号
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    private KyufuJissekiHeaderJohoMapperParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, RString 識別番号, JigyoshaNo 事業所番号, RString psmShikibetsuTaisho) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.識別番号 = 識別番号;
        this.事業所番号 = 事業所番号;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 給付実績情報取得処理のMyBatisパラメータを作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別番号 識別番号
     * @return 給付実績ヘッダ情報取得用のMyBatisパラメータ
     */
    public static KyufuJissekiHeaderJohoMapperParameter createParameter_給付実績情報(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 識別番号) {
        return new KyufuJissekiHeaderJohoMapperParameter(被保険者番号,
                サービス提供年月, 整理番号, 識別番号, JigyoshaNo.EMPTY, RString.EMPTY);
    }

    /**
     * 宛名情報取得処理のMyBatisパラメータを作成します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return 給付実績ヘッダ情報取得用のMyBatisパラメータ
     */
    public static KyufuJissekiHeaderJohoMapperParameter createParameter_宛名情報(RString psmShikibetsuTaisho) {
        return new KyufuJissekiHeaderJohoMapperParameter(
                HihokenshaNo.EMPTY, FlexibleYearMonth.EMPTY, RString.EMPTY,
                RString.EMPTY, JigyoshaNo.EMPTY, psmShikibetsuTaisho);
    }

    /**
     * 事業者名称取得処理のMyBatisパラメータを作成します。
     *
     * @param 事業所番号 事業所番号
     * @param 基準年月 基準年月
     * @return 給付実績ヘッダ情報取得用のMyBatisパラメータ
     */
    public static KyufuJissekiHeaderJohoMapperParameter createParameter_事業者名称(JigyoshaNo 事業所番号,
            FlexibleYearMonth 基準年月) {
        return new KyufuJissekiHeaderJohoMapperParameter(HihokenshaNo.EMPTY,
                基準年月, RString.EMPTY, RString.EMPTY, 事業所番号, RString.EMPTY);
    }

    /**
     * 識別番号管理データ取得処理のMyBatisパラメータを作成します。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @return 給付実績ヘッダ情報取得用のMyBatisパラメータ
     */
    public static KyufuJissekiHeaderJohoMapperParameter createParameter_識別番号管理データ(FlexibleYearMonth サービス提供年月,
            RString 識別番号) {
        return new KyufuJissekiHeaderJohoMapperParameter(HihokenshaNo.EMPTY,
                サービス提供年月, RString.EMPTY, 識別番号, JigyoshaNo.EMPTY, RString.EMPTY);
    }

}
