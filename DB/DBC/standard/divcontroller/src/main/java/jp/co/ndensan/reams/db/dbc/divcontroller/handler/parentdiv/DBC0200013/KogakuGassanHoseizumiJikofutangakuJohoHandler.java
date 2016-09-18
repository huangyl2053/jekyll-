/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080.DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoDiv;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 保険者情報送付データ作成_[37K]高額合算補正済自己負担額情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-050 wangxingpeng
 */
public class KogakuGassanHoseizumiJikofutangakuJohoHandler {

    private final KogakuGassanHoseizumiJikofutangakuJohoDiv div;
    private static final ReportId 帳票ID = ReportIdDBC.DBC200032.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     */
    public KogakuGassanHoseizumiJikofutangakuJohoHandler(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ハンドラ
     */
    public static KogakuGassanHoseizumiJikofutangakuJohoHandler of(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        return new KogakuGassanHoseizumiJikofutangakuJohoHandler(div);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return ResponseData
     */
    public ResponseData<DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter> setBatchParameter(RString 再処理区分,
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
            DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter parameter = new DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter();
            parameter.setSaishoriKubun(再処理区分);
            FlexibleYearMonth 処理年月Fle = 処理年月 == null ? FlexibleYearMonth.EMPTY : new FlexibleYearMonth(処理年月.toDateString());
            parameter.setShoriYM(処理年月Fle);
            // TODO QA1520  処理区分がなし。
            parameter.setShoriKunbun(RString.EMPTY);
            parameter.setShutsuryokujunId(new RString(出力順ID.toString()));
            return ResponseData.of(parameter).respond();
        }
        return null;
    }
}
