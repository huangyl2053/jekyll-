package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * サービス利用票情報共有子Div用インタフェースクラスです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public interface IServiceRiyohyoInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * サービス利用票情報共有子Div初期化のメソッドです。
     *
     * @param 表示モード RString
     * @param 利用年月 FlexibleYearMonth
     * @param 対象年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 履歴番号 int
     */
    public void initialize(RString 表示モード, FlexibleYearMonth 利用年月, FlexibleYearMonth 対象年月,
            HihokenshaNo 被保険者番号, RString 居宅総合事業区分, int 履歴番号);

}
