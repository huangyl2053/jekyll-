/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200012;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110060.DBC110060_KogakugassanShikyushinseishoOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200012.KogakuGassanSikyuSinseishoJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 保険者情報送付データ作成_(371)高額合算支給申請書情報のクラスです。
 *
 * @reamsid_L DBC-3300-040 wangxingpeng
 */
public class KogakuGassanSikyuSinseishoJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private static final RString 状態パターン = new RString("1");
    private final RString バッチID = new RString("ExecutionBatchId");
    private final RString フロー固定ID_給報出力 = new RString("DBC110060_KogakugassanShikyushinseishoOut");

    /**
     * onLoadのメソッドです。
     *
     * @param div KogakuGassanSikyuSinseishoJohoDiv
     * @return ResponseData KogakuGassanSikyuSinseishoJohoDiv
     */
    public ResponseData<KogakuGassanSikyuSinseishoJohoDiv> onLoad(KogakuGassanSikyuSinseishoJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KogakuGassanSikyuSinseishoJohoDiv
     * @return ResponseData DBC110060_KogakugassanShikyushinseishoOutParameter
     */
    public ResponseData<DBC110060_KogakugassanShikyushinseishoOutParameter> onClick_Execute(KogakuGassanSikyuSinseishoJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        DBC110060_KogakugassanShikyushinseishoOutParameter parameter = new DBC110060_KogakugassanShikyushinseishoOutParameter();
        parameter.set再処理区分(再処理区分);
        parameter.set処理年月(処理年月);
        FlowParameters fp = FlowParameters.of(バッチID, フロー固定ID_給報出力);
        FlowParameterAccessor.merge(fp);
        return ResponseData.of(parameter).respond();
    }
}
