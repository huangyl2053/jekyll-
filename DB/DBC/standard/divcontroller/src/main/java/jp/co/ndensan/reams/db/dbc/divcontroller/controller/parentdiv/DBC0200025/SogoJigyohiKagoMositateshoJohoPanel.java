/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200025;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110140.DBC110140_SogojigyohiKagoMoshitateshoOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200025.SogoJigyohiKagoMositateshoJohoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200025.SogoJigyohiKagoMositateshoJohoPanelHandler;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[179]総合事業費過誤申立書情報のクラスです。
 *
 * @reamsid_L DBC-2530-010 chenyadong
 */
public class SogoJigyohiKagoMositateshoJohoPanel {

    private List list;

    /**
     * 画面初期化のメソッドます。
     *
     * @param div SogoJigyohiKagoMositateshoJohoPanelDiv
     * @return ResponseData
     */
    public ResponseData<SogoJigyohiKagoMositateshoJohoPanelDiv> onLoad(SogoJigyohiKagoMositateshoJohoPanelDiv div) {

        list = getHandler(div).initialize();
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
        return ResponseData.of(param).respond();
    }

    private DBC110140_SogojigyohiKagoMoshitateshoOutParameter setBatchParameter(
            SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        DBC110140_SogojigyohiKagoMoshitateshoOutParameter parameter
                = new DBC110140_SogojigyohiKagoMoshitateshoOutParameter();
        if (list != null) {
            parameter.set再処理区分(new RString(list.get(0).toString()));
        } else {
            parameter.set再処理区分(RString.EMPTY);
        }
        parameter.set処理年月(new RYearMonth(list.get(1).toString()));
        parameter.set出力順ID(new RString(Long.toString(div.getCcdShutsuryokujun().getSelected出力順()
                .get出力順ID())));
        parameter.set送付対象情報のｺｰﾄﾞ(div.getCcdKokuhorenJohoSofu().get送付対象情報のValue());
        return parameter;
    }

    private SogoJigyohiKagoMositateshoJohoPanelHandler getHandler(SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        return new SogoJigyohiKagoMositateshoJohoPanelHandler(div);
    }
}
