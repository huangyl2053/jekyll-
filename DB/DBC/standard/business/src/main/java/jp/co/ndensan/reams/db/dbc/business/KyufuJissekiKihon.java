/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
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

    private final KaigoHihokenshaNo 被保番号;
    private final RString 氏名;
    private final Gender 性別;
    private final FlexibleDate 生年月日;
    private final ServiceTeikyoYM 提供年月;
    private final KyufuJissekiKubun 実績区分;
    private final RString 整理番号;
    private final RString 保険者;
    private final InputShikibetsuNo 明細書識別番号;
    private final RString 事業者;
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
    private final KyufuJissekiKihonGokeiCollection 合計;

    /**
     * インスタンスを生成します。
     *
     * @param 被保番号 被保番号
     * @param 氏名 氏名
     * @param 性別 性別
     * @param 生年月日 生年月日
     * @param 提供年月 提供年月
     * @param 実績区分 実績区分
     * @param 整理番号 整理番号
     * @param 保険者 保険者
     * @param 明細書識別番号 明細書識別番号
     * @param 事業者 事業者
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
     * @param 合計 合計
     */
    public KyufuJissekiKihon(
            KaigoHihokenshaNo 被保番号,
            RString 氏名,
            Gender 性別,
            FlexibleDate 生年月日,
            ServiceTeikyoYM 提供年月,
            KyufuJissekiKubun 実績区分,
            RString 整理番号,
            RString 保険者,
            InputShikibetsuNo 明細書識別番号,
            RString 事業者,
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
            KyufuJissekiKihonKohi 公費情報,
            KyufuJissekiKihonGokeiCollection 合計) {
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.性別 = 性別;
        this.生年月日 = 生年月日;
        this.提供年月 = 提供年月;
        this.実績区分 = 実績区分;
        this.整理番号 = 整理番号;
        this.保険者 = 保険者;
        this.明細書識別番号 = 明細書識別番号;
        this.事業者 = 事業者;
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
        this.合計 = 合計;
    }

    /**
     * 被保番号を返します。
     *
     * @return 被保番号
     */
    public KaigoHihokenshaNo get被保番号() {
        return 被保番号;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別() {
        return 性別;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 生年月日;
    }

    /**
     * 提供年月を返します。
     *
     * @return 提供年月
     */
    public ServiceTeikyoYM get提供年月() {
        return 提供年月;
    }

    /**
     * 実績区分を返します。
     *
     * @return 実績区分
     */
    public KyufuJissekiKubun get実績区分() {
        return 実績区分;
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return 整理番号;
    }

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return 保険者;
    }

    /**
     * 明細書識別番号を返します。
     *
     * @return 明細書識別番号
     */
    public InputShikibetsuNo get明細書識別番号() {
        return 明細書識別番号;
    }

    /**
     * 事業者を返します。
     *
     * @return 事業者
     */
    public RString get事業者() {
        return 事業者;
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

    /**
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

    /**
     * 合計を返します。
     *
     * @return 合計
     */
    public KyufuJissekiKihonGokeiCollection get合計() {
        return 合計;
    }
}
