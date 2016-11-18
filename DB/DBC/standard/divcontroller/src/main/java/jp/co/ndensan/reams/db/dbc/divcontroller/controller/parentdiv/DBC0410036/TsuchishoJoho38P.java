/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410036;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120150.DBC120150_KogakuGassanKyufuJissekiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410036.TsuchishoJoho38PDiv;
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
 * 国保連情報受取データ取込_[38P]高額合算給付実績情報
 *
 * @reamsid_L DBC-0980-110 xuhao
 */
public class TsuchishoJoho38P {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho38PDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho38PDiv> onLoad(TsuchishoJoho38PDiv div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200041_GassanKyufujissekiTorikomiIchiran")));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho38PDiv
     * @return ResponseData
     */
    public ResponseData<DBC120150_KogakuGassanKyufuJissekiInParameter> onClick_btnExcute(TsuchishoJoho38PDiv div) {
        DBC120150_KogakuGassanKyufuJissekiInParameter parameter = new DBC120150_KogakuGassanKyufuJissekiInParameter();
        RDate 処理年月 = div.getCcdKokurenJohoTorikomi().get処理年月();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        parameter.set処理年月(new FlexibleYearMonth(処理年月.getYearMonth().toDateString()));
        parameter.set出力順ID(new RString(出力順ID));
        if (SaiShoriKubun.再処理.get名称().equals(再処理区分)) {
            parameter.set再処理区分(SaiShoriKubun.再処理);
        } else if (SaiShoriKubun.空白.get名称().equals(再処理区分)) {
            parameter.set再処理区分(SaiShoriKubun.空白);
        }
        parameter.set処理区分(div.getCcdKokurenJohoTorikomi().get処理区分());
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120150_KogakuGassanKyufuJissekiIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }

}
