/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 事業分支給額計算用Mybatisパラメータクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear 年度;
    private final RString 出力対象区分;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 受取年月;
    private final FlexibleDate 処理日;
    private final RString 処理時間;
    private final FlexibleDate 決定年月日;
    private final FlexibleDate 窓口払開始年月日;
    private final RString 窓口払開始時刻;
    private final FlexibleDate 窓口払終了年月日;
    private final RString 窓口払終了時刻;
    private final RString orderBy;
    private final RString 自市町村コード;
    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 年度 年度
     * @param 出力対象区分 出力対象区分
     * @param 被保険者番号 被保険者番号
     * @param 受取年月 受取年月
     * @param 処理日 処理日
     * @param 処理時間 処理時間
     * @param 決定年月日 決定年月日
     * @param 窓口払開始年月日 窓口払開始年月日
     * @param 窓口払開始時刻 窓口払開始時刻
     * @param 窓口払終了年月日 窓口払終了年月日
     * @param 窓口払終了時刻 窓口払終了時刻
     * @param orderBy orderBy
     * @param 自市町村コード 自市町村コード
     */
    public JigyobunShikyugakuKeisanMybatisParameter(FlexibleYear 年度, RString 出力対象区分, HihokenshaNo 被保険者番号, FlexibleYearMonth 受取年月,
            FlexibleDate 処理日, RTime 処理時間, FlexibleDate 決定年月日, FlexibleDate 窓口払開始年月日, RTime 窓口払開始時刻,
            FlexibleDate 窓口払終了年月日, RTime 窓口払終了時刻, RString orderBy, RString 自市町村コード) {
        this.年度 = 年度;
        this.出力対象区分 = 出力対象区分;
        this.被保険者番号 = 被保険者番号;
        this.受取年月 = 受取年月;
        this.処理日 = 処理日;
        this.処理時間 = getTime(処理時間);
        this.決定年月日 = 決定年月日;
        this.窓口払開始年月日 = 窓口払開始年月日;
        this.窓口払開始時刻 = getTime(窓口払開始時刻);
        this.窓口払終了年月日 = 窓口払終了年月日;
        this.窓口払終了時刻 = getTime(窓口払終了時刻);
        this.orderBy = orderBy;
        this.自市町村コード = 自市町村コード;
        this.処理名 = ShoriName.事業分支給額計算.get名称();
    }

    private RString getTime(RTime time) {
        if (time == null) {
            return null;
        }
        RString hour = new RString(time.getHour());
        RString minute = new RString(time.getMinute());
        hour = hour.length() == 1 ? new RString(0).concat(hour) : hour;
        minute = minute.length() == 1 ? new RString(0).concat(minute) : minute;
        return hour.concat(minute);
    }
}
