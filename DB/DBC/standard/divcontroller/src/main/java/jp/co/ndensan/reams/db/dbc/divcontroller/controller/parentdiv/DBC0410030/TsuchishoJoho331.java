/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410030;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufutaishoshain.KogakuKyufuTaishoshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410030.TsuchishoJoho331Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_[331]高額介護サービス費給付対象者一覧表情報
 *
 * @reamsid_L DBC-0980-210 xuhao
 */
public class TsuchishoJoho331 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho331Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho331Div> onLoad(TsuchishoJoho331Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200014_KogakuKyufuTaishoshaIchiran")));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho331Div
     * @return ResponseData
     */
    public ResponseData<KogakuKyufuTaishoshaInBatchParameter> onClick_btnExcute(TsuchishoJoho331Div div) {
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(div.getCcdKokurenJohoTorikomi().get処理年月().toString());
        RString 再処理区分 = div.getCcdKokurenJohoTorikomi().get再処理区分();
        Long 出力順ID = div.getCcdKokurenJohoTorikomi().get出力順ID();
        KogakuKyufuTaishoshaInBatchParameter parameter = new KogakuKyufuTaishoshaInBatchParameter();
        parameter.set処理年月(処理年月);
        parameter.set再処理区分(再処理区分);
        parameter.set出力順ID(出力順ID);
        return ResponseData.of(parameter).respond();
    }

}
