/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410034;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120120.DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410034.TsuchishoJoho386Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
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
 * 国保連情報受取データ取込_[386]高額合算支給額計算結果連絡票情報のクラスです。
 *
 * @reamsid_L DBC-0980-230 wangkanglei
 */
public class TsuchishoJoho386 {

    private static final RString 帳票ID = new RString("DBC200037_GassanShikyugakuKeisankekkaRanrakuhyoTorikomiIchiran");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TsuchishoJoho386Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho386Div> onLoad(TsuchishoJoho386Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(帳票ID));
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        div.getCcdKokurenJohoTorikomi().initialize(SubGyomuCode.DBC介護給付, code.get帳票分類ID(), parmater);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件のメソッドます。
     *
     * @param div TsuchishoJoho386Div
     * @return ResponseData
     */
    public ResponseData<DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter> onClick_btnExcute(TsuchishoJoho386Div div) {
        DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter parameter = new DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter();
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
        parameter.setLoginUserId(ControlDataHolder.getUserId());
        FlowParameters fp = FlowParameters.of(new RString("ExecutionBatchId"), "DBC120120_KogakuGassanShikyugakuKeisanKekkaIn");
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}
