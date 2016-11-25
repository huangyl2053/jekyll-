/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410017;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120280.DBC120280_SogojigyohiShikakuShogohyoKeikaSochiInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410017.TsuchishoJoho122Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 国保連情報受取データ取込_(122)総合事業費資格総合表情報のクラスです。
 *
 * @reamsid_L DBC-0980-020 gongliang
 */
public class TsuchishoJoho122 {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJoho122Div
     * @return 総合事業費資格総合表情報の画面。
     */
    public ResponseData<TsuchishoJoho122Div> onLoad(TsuchishoJoho122Div div) {

        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJoho122Div
     * @return TsuchishoJoho122Div
     */
    public ResponseData<DBC120280_SogojigyohiShikakuShogohyoKeikaSochiInParameter> onClick_btnExcute(TsuchishoJoho122Div div) {
        DBC120280_SogojigyohiShikakuShogohyoKeikaSochiInParameter parameter
                = new DBC120280_SogojigyohiShikakuShogohyoKeikaSochiInParameter();
        RDate date = div.getCcdKokurenJohoTorikomi().get処理年月();
        FlexibleYearMonth 処理年月 = date == null ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(date.getYearMonth().toDateString());
        parameter.setShoriYM(処理年月);
        parameter.setLoginUserId(ControlDataHolder.getUserId());
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120280_SogojigyohiShikakuShogohyoKeikaSochiIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}
