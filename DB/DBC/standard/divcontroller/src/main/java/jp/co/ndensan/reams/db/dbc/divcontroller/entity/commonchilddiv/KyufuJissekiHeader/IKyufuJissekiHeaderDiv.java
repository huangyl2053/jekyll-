package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader;

import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 給付実績基本情報共有子Divクラス。
 *
 * @reamsid_L DBC-2970-160 linghuhang
 */
public interface IKyufuJissekiHeaderDiv extends ICommonChildDivBaseProperties {

    /**
     * 給付実績基本情報に初期化を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @param 整理番号 整理番号
     */
    void initialize(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, NyuryokuShikibetsuNo 識別番号);

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    void setサービス提供年月(RDate サービス提供年月);

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月 サービス提供年月
     */
    RDate getサービス提供年月();

    /**
     * 実績区分コードを設定します。
     *
     * @param 実績区分コード 実績区分コード
     */
    void set実績区分(RString 実績区分コード);

    /**
     * 実績区分コードを取得します。
     *
     * @return 実績区分コード 実績区分コード
     */
    RString get実績区分コード();

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    void set事業者名称(RString 事業者名称);

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    void set事業者番号(RString 事業者番号);

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号 事業者番号
     */
    RString get事業者番号();

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    void set整理番号(RString 整理番号);

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号 整理番号
     */
    RString get整理番号();

    /**
     * 識別番号名称を設定します。
     *
     * @param 識別番号名称 識別番号名称
     */
    void set識別番号名称(RString 識別番号名称);

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号 様式番号
     */
    RString get様式番号();

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    void set様式番号(RString 様式番号);

    /**
     * 要介護度を取得します。
     *
     * @return 要介護度 要介護度
     */
    RString get要介護度();

    /**
     * 被保番号を設定します。
     *
     * @param 被保番号 被保番号
     */
    void set被保番号(RString 被保番号);

    /**
     * 被保番号を取得します。
     *
     * @return 被保番号 被保番号
     */
    RString get被保番号();

    /**
     * 住民種別を設定します。
     *
     * @param 住民種別 住民種別
     */
    void set住民種別(RString 住民種別);

    /**
     * 住民種別を取得します。
     *
     * @return 住民種別 住民種別
     */
    RString get住民種別();

    /**
     * 有効期間_開始を設定します。
     *
     * @param 有効期間_開始 有効期間_開始
     */
    void set有効期間_開始(RDate 有効期間_開始);

    /**
     * 有効期間_開始を取得します。
     *
     * @return 有効期間_開始 有効期間_開始
     */
    RDate get有効期間_開始();

    /**
     * 有効期間_終了を設定します。
     *
     * @param 有効期間_終了 有効期間_終了
     */
    void set有効期間_終了(RDate 有効期間_終了);

    /**
     * 有効期間_終了を取得します。
     *
     * @return 有効期間_終了 有効期間_終了
     */
    RDate get有効期間_終了();

    /**
     * 氏名を設定します。
     *
     * @param 氏名 氏名
     */
    void set氏名(RString 氏名);

    /**
     * 氏名を取得します。
     *
     * @return 氏名 氏名
     */
    RString get氏名();

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     */
    void set性別(RString 性別);

    /**
     * 性別を取得します。
     *
     * @return 性別 性別
     */
    RString get性別();

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     */
    void set生年月日(RDate 生年月日);

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日 生年月日
     */
    RDate get生年月日();

    /**
     * 保険者を設定します。
     *
     * @param 保険者 保険者
     */
    void set保険者(RString 保険者);

    /**
     * 保険者を取得します。
     *
     * @return 保険者 保険者
     */
    RString get保険者();

    /**
     * 被保情報を設定します。
     *
     * @param 給付実績基本情報子Divデータ 給付実績基本情報子Divデータ
     */
    void set被保情報(KyufuJissekiHeader 給付実績基本情報子Divデータ);

    /**
     * 被保情報を設定します。
     *
     * @param csData_A 給付実績基本情報子Divデータ
     */
    void set被保情報2(KyufuJissekiKihonShukeiRelate csData_A);

    /**
     * 給付実績基本情報データを取得します。
     *
     * @return 給付実績基本情報データ 給付実績基本情報データ
     */
    KyufuJissekiHeaderAll get給付実績基本情報データ();

    /**
     * 給付実績基本情報を設定します。
     *
     * @param 給付実績基本情報 給付実績基本情報子Divデータ
     */
    void set給付実績基本情報データ(KyufuJissekiHeaderAll 給付実績基本情報);
}
