/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080.DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoHandler;
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

/**
 * 保険者情報送付データ作成_[37K]高額合算補正済自己負担額情報のクラスです。
 *
 * @reamsid_L DBC-3300-050 wangxingpeng
 */
public class KogakuGassanHoseizumiJikofutangakuJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private static final RString 状態パターン = new RString("1");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200032.getReportId();

    /**
     * onLoadのメソッドです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ResponseData KogakuGassanHoseizumiJikofutangakuJohoDiv
     */
    public ResponseData<KogakuGassanHoseizumiJikofutangakuJohoDiv> onLoad(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ResponseData
     */
    public ResponseData<DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter> onClick_Execute(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        再処理区分 = div.getCcdKokuhorenJohoSofu().get再処理区分のValue();
        処理年月 = div.getCcdKokuhorenJohoSofu().get処理年月のValue().getYearMonth();
        if (getHandler(div).setBatchParameter(再処理区分, 処理年月) != null) {
            return ResponseData.of(getHandler(div).setBatchParameter(再処理区分, 処理年月)).respond();
        }
        return ResponseData.of(new DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter()).respond();
    }

    private KogakuGassanHoseizumiJikofutangakuJohoHandler getHandler(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        return KogakuGassanHoseizumiJikofutangakuJohoHandler.of(div);
    }
}
