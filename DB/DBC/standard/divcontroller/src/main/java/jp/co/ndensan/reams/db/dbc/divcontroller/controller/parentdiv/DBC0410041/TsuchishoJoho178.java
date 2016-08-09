/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410041;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohisaishinsaketteihokenshain.DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410041.DBC0410041TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410041.TsuchishoJoho178Div;
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
 * 国保連情報受取データ取込_[178]総合事業費過再審査定通知書情報のクラスです。
 *
 * @reamsid_L DBC-4680-010 changying
 */
public class TsuchishoJoho178 {

    private static final ReportId REPORTID = new ReportId("DBC200080_SogojigyohiSaishinsaKetteiTsuchishoTorikomiIchiran");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TsuchishoJoho178Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho178Div> onLoad(TsuchishoJoho178Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, REPORTID, parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドです。
     *
     * @param div TsuchishoJoho178Div
     * @return ResponseData
     */
    public ResponseData<DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter> onClick_btnExcute(TsuchishoJoho178Div div) {
        if (setBatchParameter(div) != null) {
            return ResponseData.of(setBatchParameter(div)).respond();
        }
        return ResponseData.of(new DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter()).respond();
    }

    /**
     * 「実行する」詳細処理のメソッドです。
     *
     * @param div TsuchishoJoho178Div
     * @return DBC120870_DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter
     */
    public DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter setBatchParameter(TsuchishoJoho178Div div) {
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
            DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter parameter = new DBC120850_SogojigyohiSaishinsaKetteiHokenshaInParameter();
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

    /**
     * 「戻る」ボタン押下時のイベントメソッドです。
     *
     * @param div DBC0410011
     * @return ResponseData<DBC0410011Div>
     */
    public ResponseData<TsuchishoJoho178Div> onClick_btnBack(TsuchishoJoho178Div div) {

        return ResponseData.of(div).forwardWithEventName(DBC0410041TransitionEventName.戻る).respond();
    }
}
