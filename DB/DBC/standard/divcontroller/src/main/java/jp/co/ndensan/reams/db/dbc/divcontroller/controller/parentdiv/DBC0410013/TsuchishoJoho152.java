/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120250.DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410013.TsuchishoJoho152Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 *
 * 国保連情報受取データ取込_[152]総合事業費請求額通知書情報
 *
 * @reamsid_L DBC-0980-040 quxiaodong
 */
public class TsuchishoJoho152 {

    /**
     * onLoad事件
     *
     * @param div TsuchishoJoho152Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho152Div> onLoad(TsuchishoJoho152Div div) {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onImplement 事件
     *
     * @param div TsuchishoJoho152Div
     * @return ResponseData
     */
    public ResponseData<DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInParameter> onImplement(TsuchishoJoho152Div div) {
        DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInParameter parameter
                = new DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInParameter();
        SaiShoriKubun 再処理区分 = null;
        if (SaiShoriKubun.再処理.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.再処理;
        } else if (SaiShoriKubun.空白.get名称().equals(div.getCcdKokurenJohoTorikomi().get再処理区分())) {
            再処理区分 = SaiShoriKubun.空白;
        }
        parameter.setSaishoriKubun(再処理区分);
        parameter.setShoriYM(new FlexibleYearMonth(
                div.getCcdKokurenJohoTorikomi().get処理年月().getYearMonth().toDateString()));
        parameter.setShutsuryokujunId(RString.EMPTY);
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}
