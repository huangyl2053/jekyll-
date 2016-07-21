/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410045;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufuketteiin.KogakuKyufuKetteiInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410045.DBC0410045TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410045.TsuchishoJoho534Div;
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
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater, SubGyomuCode.DBC介護給付, REPORTID);
        return ResponseData.of(div).respond();
    }

    /**
     * 国保連情報データ取込画面へ遷移する。
     *
     * @param div 画面DIV
     * @return 国保連情報データ取込へ遷移
     */
    public ResponseData<TsuchishoJoho534Div> onClick_btnBackToKokuhorenTorikomiList(TsuchishoJoho534Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC0410045TransitionEventName.戻る).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho534Div
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuKetteiInBatchParameter> onClick_btnExcute(TsuchishoJoho534Div div) {
        KogakuKyufuKetteiInBatchParameter parameter = setBatchParameter(div);
        return ResponseData.of(new KogakuKyufuKetteiInBatchParameter()).respond();
    }
    
    /**
     * 「実行する」ボタン事件のメソッドます。
     *
     * @param div TsuchishoJoho534Div
     * @return KogakuKyufuKetteiInBatchParameter
     */
    public KogakuKyufuKetteiInBatchParameter setBatchParameter(TsuchishoJoho534Div div) {
        //TODO 
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder iOutputOrder = finder.get出力順(
                SubGyomuCode.DBC介護給付,
                REPORTID,
                Long.valueOf(div.getCcdKokurenJohoTorikomi().get出力順ID().toString()));
        if (iOutputOrder != null) {
            IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
            manager.save前回出力順(iOutputOrder);
        }
        KogakuKyufuKetteiInBatchParameter parameter = new KogakuKyufuKetteiInBatchParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        SaiShoriKubun 再処理区分 = SaiShoriKubun.toValue(div.getCcdKokurenJohoTorikomi().get再処理区分());
        long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShutsuryokujunId(出力順ID);
        return parameter;
    }
}
