/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410046;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120820.DBC120820_JukyushaTotsugoKekkaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410046.TsuchishoJoho537Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受給者情報突合結果情報取込のクラスです。
 *
 * @reamsid_L DBC-2760-030 qinzhen
 */
public class TsuchishoJoho537 {

    private static final ReportId REPORTID = new ReportId("DBC200058_JukyushaTotsugokekkaIchiran");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TsuchishoJoho537Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho537Div> onLoad(TsuchishoJoho537Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);

        div.getCcdKokurenJohoTorikomi().initialize(parmater, SubGyomuCode.DBC介護給付, REPORTID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドです。
     *
     * @param div TsuchishoJoho537Div
     * @return ResponseData
     */
    public ResponseData<DBC120820_JukyushaTotsugoKekkaInBatchParameter> onClick_btnExcute(TsuchishoJoho537Div div) {
        if (setBatchParameter(div) != null) {
            return ResponseData.of(setBatchParameter(div)).respond();
        }
        return ResponseData.of(new DBC120820_JukyushaTotsugoKekkaInBatchParameter()).respond();
    }

    private DBC120820_JukyushaTotsugoKekkaInBatchParameter setBatchParameter(TsuchishoJoho537Div div) {

        if (div.getCcdKokurenJohoTorikomi().get出力順ID() != null) {
            Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付,
                    REPORTID,
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
            DBC120820_JukyushaTotsugoKekkaInBatchParameter parameter = new DBC120820_JukyushaTotsugoKekkaInBatchParameter();
            RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
            parameter.set処理年月(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
            parameter.set出力順ID(出力順ID);
            return parameter;
        }
        return null;
    }
}
