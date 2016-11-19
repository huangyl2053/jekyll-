/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410028;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120090.DBC120090_ShokanShikyuKetteiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410028.TsuchishoJoho221Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 国保連情報受取データ取込_[221]償還払支給決定者一覧情報
 *
 * @reamsid_L DBC-0980-190 xuhao
 */
public class TsuchishoJoho221 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho221Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho221Div> onLoad(TsuchishoJoho221Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran")));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho221Div
     * @return ResponseData
     */
    public ResponseData<DBC120090_ShokanShikyuKetteiInParameter> onClick_btnExcute(TsuchishoJoho221Div div) {
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        DBC120090_ShokanShikyuKetteiInParameter parameter = new DBC120090_ShokanShikyuKetteiInParameter();
        parameter.setShoriYearMonth(処理年月);
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.再処理.getコード());
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.setSaishoriKubun(SaiShoriKubun.空白.getコード());
        }
        parameter.setShutsuryokujun(new RString(String.valueOf(出力順ID)));
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120090_ShokanShikyuKetteiIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }

}
