/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410044;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120880.DBC120880_SogojigyohiShikakuShogohyoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410044.TsuchishoJoho123Div;
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
 * 国保連情報受取データ取込_[123]総合事業費資格照合表情報のクラスです。
 *
 * @reamsid_L DBC-2890-040 dingminghao
 */
public class TsuchishoJoho123 {

    /**
     * 画面初期化のメソッド。
     *
     * @param div TsuchishoJoho123Div
     * @return 総合事業費資格総合表情報の画面。
     */
    public ResponseData<TsuchishoJoho123Div> onLoad(TsuchishoJoho123Div div) {

        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下。
     *
     * @param div TsuchishoJoho123Div
     * @return DBC120880_SogojigyohiShikakuShogohyoInParameter
     */
    public ResponseData<DBC120880_SogojigyohiShikakuShogohyoInParameter> onClick_btnExcute(TsuchishoJoho123Div div) {

        DBC120880_SogojigyohiShikakuShogohyoInParameter parameter = new DBC120880_SogojigyohiShikakuShogohyoInParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        if (処理年月 != null) {
            parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toString()));
        }
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishorikubun(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishorikubun(SaiShoriKubun.空白);
        }
        parameter.setShutsuryokujunID(null);
        parameter.setLoginUserId(ControlDataHolder.getUserId());
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120880_SogojigyohiShikakuShogohyoIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}
