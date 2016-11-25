/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200025;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110140.DBC110140_SogojigyohiKagoMoshitateshoOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200025.SogoJigyohiKagoMositateshoJohoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200025.SogoJigyohiKagoMositateshoJohoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[179]総合事業費過誤申立書情報のクラスです。
 *
 * @reamsid_L DBC-2530-010 chenyadong
 */
public class SogoJigyohiKagoMositateshoJohoPanel {

    private final RString バッチID = new RString("ExecutionBatchId");
    private final RString フロー固定ID_給報出力 = new RString("DBC110140_SogojigyohiKagoMoshitateshoOut");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div SogoJigyohiKagoMositateshoJohoPanelDiv
     * @return ResponseData
     */
    public ResponseData<SogoJigyohiKagoMositateshoJohoPanelDiv> onLoad(SogoJigyohiKagoMositateshoJohoPanelDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div SogoJigyohiKagoMositateshoJohoPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC110140_SogojigyohiKagoMoshitateshoOutParameter> onClick_btn(
            SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
        manager.save前回出力順(div.getCcdShutsuryokujun().getSelected出力順());
        DBC110140_SogojigyohiKagoMoshitateshoOutParameter param = setBatchParameter(div);
        FlowParameters fp = FlowParameters.of(バッチID, フロー固定ID_給報出力);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(param).respond();
    }

    private DBC110140_SogojigyohiKagoMoshitateshoOutParameter setBatchParameter(
            SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        DBC110140_SogojigyohiKagoMoshitateshoOutParameter parameter
                = new DBC110140_SogojigyohiKagoMoshitateshoOutParameter();
        KokuhorenDataSofuViewState 送付情報 = ViewStateHolder.get(ViewStateHolderName.国保連送付情報, KokuhorenDataSofuViewState.class);
        RString 再処理区分 = 送付情報.get再処理区分();
        RYearMonth 処理年月 = 送付情報.get処理年月();
        if (再処理区分 != null) {
            parameter.set再処理区分(再処理区分);
        } else {
            parameter.set再処理区分(RString.EMPTY);
        }
        if (処理年月 != null) {
            parameter.set処理年月(処理年月);
        } else {
            parameter.set処理年月(null);
        }
        parameter.set出力順ID(new RString(Long.toString(div.getCcdShutsuryokujun().getSelected出力順()
                .get出力順ID())));
        parameter.set送付対象情報のｺｰﾄﾞ(div.getCcdKokuhorenJohoSofu().get送付対象情報のkey());
        return parameter;
    }

    private SogoJigyohiKagoMositateshoJohoPanelHandler getHandler(SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        return new SogoJigyohiKagoMositateshoJohoPanelHandler(div);
    }
}
