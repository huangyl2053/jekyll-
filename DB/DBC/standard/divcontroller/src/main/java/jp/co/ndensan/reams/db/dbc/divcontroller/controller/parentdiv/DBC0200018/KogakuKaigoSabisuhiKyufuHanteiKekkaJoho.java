/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200018;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110040.DBC110040_KogakuServicehiHanteikekkaOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200018.KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200018.KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
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
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[341]高額介護サービス費給付判定結果情報のクラスです。
 *
 * @reamsid_L DBC-3300-100 wangxingpeng
 */
public class KogakuKaigoSabisuhiKyufuHanteiKekkaJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private static final RString 状態パターン = new RString("1");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200019.getReportId();
    private final RString バッチID = new RString("ExecutionBatchId");
    private final RString フロー固定ID_給報出力 = new RString("DBC110040_KogakuServicehiHanteikekkaOut");
    private static final RString 帳票出力順の取得メッセージ引数 = new RString("帳票出力順の取得");

    /**
     * onLoadのメソッドです。
     *
     * @param div KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv
     * @return ResponseData KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv
     */
    public ResponseData<KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv> onLoad(KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv
     * @return ResponseData DBC110040_KogakuServicehiHanteikekkaOutParameter
     */
    public ResponseData<DBC110040_KogakuServicehiHanteikekkaOutParameter> onClick_Execute(KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        FlowParameters fp = FlowParameters.of(バッチID, フロー固定ID_給報出力);
        FlowParameterAccessor.merge(fp);
        if (getHandler(div).setBatchParameter(再処理区分, 処理年月) != null) {
            return ResponseData.of(getHandler(div).setBatchParameter(再処理区分, 処理年月)).respond();
        }
        throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(帳票出力順の取得メッセージ引数.toString()).evaluate());
    }

    private KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler getHandler(KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div) {
        return KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler.of(div);
    }
}
