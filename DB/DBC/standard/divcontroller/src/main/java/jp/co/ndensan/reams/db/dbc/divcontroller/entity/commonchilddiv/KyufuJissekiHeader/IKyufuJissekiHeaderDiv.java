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
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    void setサービス提供年月(RDate サービス提供年月);

    /**
     * 実績区分コードを設定します。
     *
     * @param 実績区分コード 実績区分コード
     */
    void set実績区分(RString 実績区分コード);

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    void set事業者名称(RString 事業者名称);

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    void set整理番号(RString 整理番号);

    /**
     * 識別番号名称を設定します。
     *
     * @param 識別番号名称 識別番号名称
     */
    void set識別番号名称(RString 識別番号名称);

    /**
     * 保険者名称を設定します。
     *
     * @param 保険者名称 保険者名称
     */
    void set保険者(RString 保険者名称);
}
