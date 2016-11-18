/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410043;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120870.DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410043.TsuchishoJoho662Div;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 国保連情報受取データ取込_[662]総合事業費再審査決定通知書（公費）情報のクラスです。
 *
 * @reamsid_L DBC-4730-010 changying
 */
public class TsuchishoJoho662 {

    private static final ReportId REPORTID = new ReportId("DBC200081_SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohi");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TsuchishoJoho662Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho662Div> onLoad(TsuchishoJoho662Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, REPORTID, parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドです。
     *
     * @param div TsuchishoJoho662Div
     * @return ResponseData
     */
    public ResponseData<DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter> onClick_btnExcute(
            TsuchishoJoho662Div div) {
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaIn");
        FlowParameterAccessor.merge(fp);
        if (setBatchParameter(div) != null) {
            return ResponseData.of(setBatchParameter(div)).respond();
        }
        return ResponseData.of(new DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter()).respond();
    }

    /**
     * 「実行する」詳細処理のメソッドです。
     *
     * @param div TsuchishoJoho662Div
     * @return KokuhorenKyoutsuBatchParameter
     */
    public DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter setBatchParameter(TsuchishoJoho662Div div) {
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
            DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter parameter
                    = new DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaInParameter();
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
