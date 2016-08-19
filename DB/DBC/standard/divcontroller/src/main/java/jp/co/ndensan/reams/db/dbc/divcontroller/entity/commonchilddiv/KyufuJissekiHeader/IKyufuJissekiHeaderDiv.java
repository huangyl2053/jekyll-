package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuJissekiHeader;

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
     * サービス提供年月の前月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    void set前月(RDate サービス提供年月);

    /**
     * サービス提供年月の次月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    void set次月(RDate サービス提供年月);

    /**
     * 前事業者を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    void set前事業者(RString 事業者名称);

    /**
     * 後事業者を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    void set後事業者(RString 事業者名称);
}
