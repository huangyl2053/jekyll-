/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200016;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110120.DBC110120_SaishinsaMoshitateshoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200016.SaisinsaMositateJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200016.SaisinsaMositateJohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[174]再審査申立書情報のクラスです。
 *
 * @reamsid_L DBC-3300-080 wangxingpeng
 */
public class SaisinsaMositateJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private static final RString 状態パターン = new RString("1");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200047.getReportId();
    private final RString バッチID = new RString("ExecutionBatchId");
    private final RString フロー固定ID_給報出力 = new RString("DBC110120_SaishinsaMoshitateshoOut");

    /**
     * onLoadのメソッドです。
     *
     * @param div SaisinsaMositateJohoDiv
     * @return ResponseData SaisinsaMositateJohoDiv
     */
    public ResponseData<SaisinsaMositateJohoDiv> onLoad(SaisinsaMositateJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div SaisinsaMositateJohoDiv
     * @return ResponseData DBC110120_SaishinsaMoshitateshoOutParameter
     */
    public ResponseData<DBC110120_SaishinsaMoshitateshoOutParameter> onClick_Execute(SaisinsaMositateJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        if (getHandler(div).setBatchParameter(再処理区分, 処理年月) != null) {
            return ResponseData.of(getHandler(div).setBatchParameter(再処理区分, 処理年月)).respond();
        }
        FlowParameters fp = FlowParameters.of(バッチID, フロー固定ID_給報出力);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(new DBC110120_SaishinsaMoshitateshoOutParameter()).respond();
    }

    private SaisinsaMositateJohoHandler getHandler(SaisinsaMositateJohoDiv div) {
        return SaisinsaMositateJohoHandler.of(div);
    }
}
