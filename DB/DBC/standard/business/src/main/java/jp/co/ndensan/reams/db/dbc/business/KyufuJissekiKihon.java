/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 給付実績の基本情報を保持するクラスです。
 *
 * @author n8223 朴 義一
 */
public class KyufuJissekiKihon {

    private final KyufuSakuseiKubun 作成区分;
    private final RString 要介護度;
    private final Range<FlexibleDate> 認定有効期間;
    private final FlexibleYearMonth 審査年月;
    private final KeikokuKubun 警告区分;
    private final KyufuJissekiKihonHihokensha 被保険者情報;
    private final KyufuJissekiKihonKyotakuService 居宅サービス計画情報;
    private final KyufuJissekiKihonServiceKikan サービス期間情報;
    private final KyufuJissekiKihonNyutaisho 施設入退所情報;
    private final KyufuJissekiKihonKyufuritsu 給付率情報;
    private final KyufuJissekiKihonKohi 公費情報;

    /**
     * インスタンスを生成します。
     *
     * @param 作成区分 作成区分
     * @param 要介護度 要介護度
     * @param 認定有効期間 認定有効期間
     * @param 審査年月 審査年月
     * @param 警告区分 警告区分
     * @param 被保険者情報 被保険者情報
     * @param 居宅サービス計画情報 居宅サービス計画情報
     * @param サービス期間情報 サービス期間情報
     * @param 施設入退所情報 施設入退所情報
     * @param 給付率情報 給付率情報
     * @param 公費情報 公費情報
     */
    public KyufuJissekiKihon(
            KyufuSakuseiKubun 作成区分,
            RString 要介護度,
            Range<FlexibleDate> 認定有効期間,
            FlexibleYearMonth 審査年月,
            KeikokuKubun 警告区分,
            KyufuJissekiKihonHihokensha 被保険者情報,
            KyufuJissekiKihonKyotakuService 居宅サービス計画情報,
            KyufuJissekiKihonServiceKikan サービス期間情報,
            KyufuJissekiKihonNyutaisho 施設入退所情報,
            KyufuJissekiKihonKyufuritsu 給付率情報,
            KyufuJissekiKihonKohi 公費情報) throws NullPointerException {
        this.作成区分 = 作成区分;
        this.要介護度 = 要介護度;
        this.認定有効期間 = 認定有効期間;
        this.審査年月 = 審査年月;
        this.警告区分 = 警告区分;
        this.被保険者情報 = 被保険者情報;
        this.居宅サービス計画情報 = 居宅サービス計画情報;
        this.サービス期間情報 = サービス期間情報;
        this.施設入退所情報 = 施設入退所情報;
        this.給付率情報 = 給付率情報;
        this.公費情報 = 公費情報;
    }

    /**
     * 作成区分を返します。
     *
     * @return 作成区分
     */
    public KyufuSakuseiKubun get作成区分() {
        return 作成区分;
    }

    /**
     * 要介護度を返します。
     *
     * @return 要介護度
     */
    public RString get要介護度() {
        return 要介護度;
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public Range<FlexibleDate> get認定有効期間() {
        return 認定有効期間;
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return 審査年月;
    }

    /**
     * 警告区分を返します。
     *
     * @return 警告区分
     */
    public KeikokuKubun get警告区分() {
        return 警告区分;
    }

    /**
     * 被保険者情報を返します。
     *
     * @return 被保険者情報
     */
    public KyufuJissekiKihonHihokensha get被保険者情報() {
        return 被保険者情報;
    }

    /**
     * 居宅サービス計画情報を返します。
     *
     * @return 居宅サービス計画情報
     */
    public KyufuJissekiKihonKyotakuService get居宅サービス計画情報() {
        return 居宅サービス計画情報;
    }

    /**
     * サービス期間情報を返します。
     *
     * @return サービス期間情報
     */
    public KyufuJissekiKihonServiceKikan getサービス期間情報() {
        return サービス期間情報;
    }

    /**
     * 施設入退所情報を返します。
     *
     * @return 施設入退所情報
     */
    public KyufuJissekiKihonNyutaisho get施設入退所情報() {
        return 施設入退所情報;
    }

    /*
     * 給付率情報を返します。
     *
     * @return 給付率情報
     */
    public KyufuJissekiKihonKyufuritsu get給付率情報() {
        return 給付率情報;
    }

    /**
     * 公費情報を返します。
     *
     * @return 公費情報
     */
    public KyufuJissekiKihonKohi get公費情報() {
        return 公費情報;
    }
}
