/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.JigyobunShikyugakuKeisanMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 事業分支給額計算用プロセスパラメータクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 年度;
    private RString 出力対象区分;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 受取年月;
    private FlexibleDate 処理日;
    private RTime 処理時間;
    private FlexibleDate 決定年月日;
    private FlexibleDate 窓口払開始年月日;
    private RTime 窓口払開始時刻;
    private FlexibleDate 窓口払終了年月日;
    private RTime 窓口払終了時刻;
    private Long 出力順ID;
    private RString orderBy;
    private RString 自市町村コード;

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
     * @param 出力順ID 出力順ID
     */
    public JigyobunShikyugakuKeisanProcessParameter(FlexibleYear 年度, RString 出力対象区分, HihokenshaNo 被保険者番号,
            FlexibleYearMonth 受取年月, FlexibleDate 処理日, RTime 処理時間, FlexibleDate 決定年月日, FlexibleDate 窓口払開始年月日,
            RTime 窓口払開始時刻, FlexibleDate 窓口払終了年月日, RTime 窓口払終了時刻, Long 出力順ID) {
        this.年度 = 年度;
        this.出力対象区分 = 出力対象区分;
        this.被保険者番号 = 被保険者番号;
        this.受取年月 = 受取年月;
        this.処理日 = 処理日;
        this.処理時間 = 処理時間;
        this.決定年月日 = 決定年月日;
        this.窓口払開始年月日 = 窓口払開始年月日;
        this.窓口払開始時刻 = 窓口払開始時刻;
        this.窓口払終了年月日 = 窓口払終了年月日;
        this.窓口払終了時刻 = 窓口払終了時刻;
        this.出力順ID = 出力順ID;
    }

    /**
     * MYBATISパラメータの作成です。
     *
     * @return JigyobunShikyugakuKeisanMybatisParameter
     */
    public JigyobunShikyugakuKeisanMybatisParameter toMybatisParameter() {
        return new JigyobunShikyugakuKeisanMybatisParameter(年度, 出力対象区分, 被保険者番号, 受取年月, 処理日, 処理時間, 決定年月日,
                窓口払開始年月日, 窓口払開始時刻, 窓口払終了年月日, 窓口払終了時刻, orderBy, 自市町村コード);
    }

}
