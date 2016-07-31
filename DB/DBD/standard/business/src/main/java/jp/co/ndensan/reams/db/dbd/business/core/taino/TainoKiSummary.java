/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.JikoGoShunyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 滞納情報Entityのクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoKiSummary implements Serializable {

    private final FlexibleYear 賦課年度;
    private final FlexibleYear 調定年度;
    private final boolean is過年度;
    private final RString 期;
    private final Decimal 調定額;
    private final Decimal 収入額;
    private final Decimal 滞納額;
    private final RDate 納期限;
    private final FlexibleDate 時効起算日;
    private final JikoKisanbiKubun 時効起算日区分;
    private final MinoKannoKubun 未納完納区分;
    private final JikoKubun 時効区分;
    private final TsuchishoNo 通知書番号;
    private final TokuchoFuchoKubun 徴収方法;
    private final JikoGoShunyuKubun 時効後収入区分;
    private final TaishoHanteiKubun 対象管理区分;
    private final Decimal 控除額;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param is過年度 is過年度
     * @param 期 期
     * @param 調定額 調定額
     * @param 収入額 収入額
     * @param 滞納額 滞納額
     * @param 納期限 納期限
     * @param 時効起算日 時効起算日
     * @param 時効起算日区分 時効起算日区分
     * @param 未納完納区分 未納完納区分
     * @param 時効区分 時効区分
     * @param 通知書番号 通知書番号
     * @param 徴収方法 徴収方法
     * @param 時効後収入区分 時効後収入区分
     * @param 対象管理区分 対象管理区分
     * @param 控除額 控除額
     */
    public TainoKiSummary(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            boolean is過年度,
            RString 期,
            Decimal 調定額,
            Decimal 収入額,
            Decimal 滞納額,
            RDate 納期限,
            FlexibleDate 時効起算日,
            JikoKisanbiKubun 時効起算日区分,
            MinoKannoKubun 未納完納区分,
            JikoKubun 時効区分,
            TsuchishoNo 通知書番号,
            TokuchoFuchoKubun 徴収方法,
            JikoGoShunyuKubun 時効後収入区分,
            TaishoHanteiKubun 対象管理区分,
            Decimal 控除額) {
        this.賦課年度 = 賦課年度;
        this.調定年度 = 調定年度;
        this.is過年度 = is過年度;
        this.期 = 期;
        this.調定額 = 調定額;
        this.収入額 = 収入額;
        this.滞納額 = 滞納額;
        this.納期限 = 納期限;
        this.時効起算日 = 時効起算日;
        this.時効起算日区分 = 時効起算日区分;
        this.未納完納区分 = 未納完納区分;
        this.時効区分 = 時効区分;
        this.通知書番号 = 通知書番号;
        this.徴収方法 = 徴収方法;
        this.時効後収入区分 = 時効後収入区分;
        this.対象管理区分 = 対象管理区分;
        this.控除額 = 控除額;
    }

}
