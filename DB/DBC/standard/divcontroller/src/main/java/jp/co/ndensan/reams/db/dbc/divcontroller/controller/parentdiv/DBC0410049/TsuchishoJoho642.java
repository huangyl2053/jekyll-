/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410049;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorendatatorikomi.KokuhorenDataTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410049.DBC0410049TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410049.TsuchishoJoho642Div;
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
 * 総合事業費公費受給者別一覧情報のクラスです。
 *
 * @reamsid_L DBC-4710-010 qinzhen
 */
public class TsuchishoJoho642 {

    private static final ReportId REPORTID = new ReportId("DBC200083_SogojigyohiKohiJukyushaBetsuIchiran");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TsuchishoJoho642Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho642Div> onLoad(TsuchishoJoho642Div div) {

        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater, SubGyomuCode.DBC介護給付, REPORTID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタン事件のメソッドです。
     *
     * @param div TsuchishoJoho642Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho642Div> onClick_btnBack(TsuchishoJoho642Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC0410049TransitionEventName.戻る).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドです。
     *
     * @param div TsuchishoJoho642Div
     * @return ResponseData
     */
    public ResponseData<KokuhorenDataTorikomiBatchParameter> onClick_btnExcute(TsuchishoJoho642Div div) {
        if (setBatchParameter(div) != null) {
            return ResponseData.of(setBatchParameter(div)).respond();
        }
        return ResponseData.of(new KokuhorenDataTorikomiBatchParameter()).respond();
    }

    private KokuhorenDataTorikomiBatchParameter setBatchParameter(TsuchishoJoho642Div div) {
        //TODO QA1119
        if (div.getCcdKokurenJohoTorikomi().get出力順ID() != null) {
            long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付,
                    REPORTID,
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
            KokuhorenDataTorikomiBatchParameter parameter = new KokuhorenDataTorikomiBatchParameter();
            RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
            SaiShoriKubun 再処理区分 = null;
            if (SaiShoriKubun.再処理.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
                再処理区分 = SaiShoriKubun.再処理;
            } else if (SaiShoriKubun.空白.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
                再処理区分 = SaiShoriKubun.空白;
            }
            parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
            parameter.setSaishoriKubun(再処理区分);
            parameter.setShutsuryokujunId(出力順ID);
            return parameter;
        }
        return null;
    }
}
