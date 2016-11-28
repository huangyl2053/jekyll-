/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410045;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120810.DBC120810_KokuhorenJukyushaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410045.TsuchishoJoho534Div;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[537]受給者情報突合結果情報取込のクラスです。
 *
 * @reamsid_L DBC-2740-030 baojikui
 */
public class TsuchishoJoho534 {

    private static final ReportId REPORTID = new ReportId("DBC200006_KokuhorenJukyushaDaichoIchiran");

    /**
     * onLoad
     *
     * @param div TsuchishoJoho534Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho534Div> onLoad(TsuchishoJoho534Div div) {
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, REPORTID);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho534Div
     * @return ResponseData
     */
    public ResponseData<DBC120810_KokuhorenJukyushaInParameter> onClick_btnExcute(TsuchishoJoho534Div div) {
        if (setBatchParameter(div) != null) {
            return ResponseData.of(setBatchParameter(div)).respond();
        }
        return ResponseData.of(new DBC120810_KokuhorenJukyushaInParameter()).respond();
    }

    private DBC120810_KokuhorenJukyushaInParameter setBatchParameter(TsuchishoJoho534Div div) {
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付,
                    REPORTID,
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
            DBC120810_KokuhorenJukyushaInParameter parameter = new DBC120810_KokuhorenJukyushaInParameter();
            RDate 処理年月 = RDate.getNowDate();

            parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
            parameter.setSaishoriKubun(SaiShoriKubun.空白);
            parameter.setShutsuryokujunId(new RString(出力順ID.toString()));
            parameter.setLoginUserId(ControlDataHolder.getUserId());
            return parameter;
        }
        return null;
    }
}
