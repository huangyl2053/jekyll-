/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410016;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120270.DBC120270_ShikakuShogohyoInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410016.TsuchishoJoho121Div;
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
 * 国保連情報受取データ取込_[121]資格照合表情報のクラスです。
 *
 * @reamsid_L DBC-0980-010 gongliang
 */
public class TsuchishoJoho121 {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJoho121Div
     * @return 資格照合表情報の画面。
     */
    public ResponseData<TsuchishoJoho121Div> onLoad(TsuchishoJoho121Div div) {

        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJoho121Div
     * @return TsuchishoJoho121Div
     */
    public ResponseData<DBC120270_ShikakuShogohyoInParameter> onClick_btnExcute(TsuchishoJoho121Div div) {
        DBC120270_ShikakuShogohyoInParameter parameter = new DBC120270_ShikakuShogohyoInParameter();
        RDate date = div.getCcdKokurenJohoTorikomi().get処理年月();
        FlexibleYearMonth 処理年月 = date == null ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(date.getYearMonth().toDateString());
        parameter.setShoriYM(処理年月);
        parameter.setLoginUserId(ControlDataHolder.getUserId());
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120270_ShikakuShogohyoIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }

}
