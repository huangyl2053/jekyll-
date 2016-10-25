/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200015;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110130.DBC110130_HokenshaKyufujissekiOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200015.KyufuJissekiJohoDiv;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[113]給付実績情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-070 wangxingpeng
 */
public class KyufuJissekiJohoHandler {

    private final KyufuJissekiJohoDiv div;
    private static final ReportId 帳票ID = ReportIdDBC.DBC200053.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KyufuJissekiJohoDiv
     */
    public KyufuJissekiJohoHandler(KyufuJissekiJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KyufuJissekiJohoDiv
     * @return ハンドラ
     */
    public static KyufuJissekiJohoHandler of(KyufuJissekiJohoDiv div) {
        return new KyufuJissekiJohoHandler(div);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return DBC110110_KogakugassanKyufujissekiOutParameter
     */
    public DBC110130_HokenshaKyufujissekiOutParameter setBatchParameter(RString 再処理区分,
            RYearMonth 処理年月) {
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付,
                    帳票ID,
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
            DBC110130_HokenshaKyufujissekiOutParameter parameter = new DBC110130_HokenshaKyufujissekiOutParameter();
            parameter.setSaishoriKubun(再処理区分);
            if (処理年月 != null) {
                parameter.setShoriYM(new FlexibleYearMonth(処理年月.toDateString()));
            } else {
                parameter.setShoriYM(FlexibleYearMonth.EMPTY);
            }
            parameter.setShutsuryokujunId(new RString(出力順ID.toString()));
            return parameter;
        }
        return null;
    }
}
