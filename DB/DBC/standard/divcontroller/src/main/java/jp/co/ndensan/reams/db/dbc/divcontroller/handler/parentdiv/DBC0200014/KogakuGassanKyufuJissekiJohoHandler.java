/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200014;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110110.DBC110110_KogakugassanKyufujissekiOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200014.KogakuGassanKyufuJissekiJohoDiv;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[38Q]高額合算給付実績情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-060 wangxingpeng
 */
public class KogakuGassanKyufuJissekiJohoHandler {

    private final KogakuGassanKyufuJissekiJohoDiv div;
    private static final ReportId 帳票ID = ReportIdDBC.DBC200042.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanKyufuJissekiJohoDiv
     */
    public KogakuGassanKyufuJissekiJohoHandler(KogakuGassanKyufuJissekiJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanKyufuJissekiJohoDiv
     * @return ハンドラ
     */
    public static KogakuGassanKyufuJissekiJohoHandler of(KogakuGassanKyufuJissekiJohoDiv div) {
        return new KogakuGassanKyufuJissekiJohoHandler(div);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return DBC110110_KogakugassanKyufujissekiOutParameter
     */
    public DBC110110_KogakugassanKyufujissekiOutParameter setBatchParameter(RString 再処理区分,
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
            DBC110110_KogakugassanKyufujissekiOutParameter parameter = new DBC110110_KogakugassanKyufujissekiOutParameter();
            parameter.set再処理区分(再処理区分);
            parameter.set処理年月(処理年月);
            parameter.set出力順ID(new RString(出力順ID.toString()));
            return parameter;
        }
        return null;
    }

}
