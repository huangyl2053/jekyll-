/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC3200011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120830.DBC120830_KokuhorenKyodoJukyushaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3200011.KyodoShoriyoJukyushaJohoDiv;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 国保連保有共同処理用受給者情報一覧取込
 *
 * @reamsid_L DBC-2920-040 lihang
 */
public class KyodoShoriyoJukyushaJoho {

    /**
     * onLoadです
     *
     * @param div KyodoShoriyoJukyushaJohoDiv
     * @return ResponseData
     */
    public ResponseData<KyodoShoriyoJukyushaJohoDiv> onLoad(KyodoShoriyoJukyushaJohoDiv div) {
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200057.getReportId());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンです
     *
     * @param div KyodoShoriyoJukyushaJohoDiv
     * @return ResponseData
     */
    public ResponseData<DBC120830_KokuhorenKyodoJukyushaInParameter> onClick_btnBatchRegister(KyodoShoriyoJukyushaJohoDiv div) {
        DBC120830_KokuhorenKyodoJukyushaInParameter parameter = new DBC120830_KokuhorenKyodoJukyushaInParameter();
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200057.getReportId(), 出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
        }
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        return ResponseData.of(parameter).respond();
    }
}
