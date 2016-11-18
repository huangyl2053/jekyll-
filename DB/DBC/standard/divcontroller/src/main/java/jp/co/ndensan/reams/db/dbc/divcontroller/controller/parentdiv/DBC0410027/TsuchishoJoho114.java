/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410027;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120060.DBC120060_KyufuJissekiKoshinInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410027.TsuchishoJoho114Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
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
 * 国保連情報受取データ取込_[114]給付実績更新結果情報
 *
 * @reamsid_L DBC-0980-130 xuhao
 */
public class TsuchishoJoho114 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho114Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho114Div> onLoad(TsuchishoJoho114Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200054_KyufujissekiKoshinkekkaIchiran")));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getIccdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho114Div
     * @return ResponseData
     */
    public ResponseData<DBC120060_KyufuJissekiKoshinInParameter> onClick_btnExcute(TsuchishoJoho114Div div) {
        DBC120060_KyufuJissekiKoshinInParameter parameter = new DBC120060_KyufuJissekiKoshinInParameter();
        RDate 処理年月 = div.getIccdKokurenJohoTorikomi().get処理年月();
        Long 出力順ID = div.getIccdKokurenJohoTorikomi().get出力順ID();
        RString 再処理区分 = div.getIccdKokurenJohoTorikomi().get再処理区分();
        parameter.setShoriYM(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        if (出力順ID != null) {
            parameter.setShutsuryokujunId(new RString(出力順ID.toString()));
        }
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.空白);
        }
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120060_KyufuJissekiKoshinIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }

}
