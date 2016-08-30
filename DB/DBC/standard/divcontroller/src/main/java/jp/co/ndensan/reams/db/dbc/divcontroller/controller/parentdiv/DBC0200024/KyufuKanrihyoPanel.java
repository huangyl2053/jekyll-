/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200024;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110010.DBC110010_KyufukanrihyoOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200024.KyufuKanrihyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200024.KyufuKanrihyoPanelHandler;
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
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[821]給付管理票のクラスです。
 *
 * @reamsid_L DBC-3300-120 wangxingpeng
 */
public class KyufuKanrihyoPanel {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private static final RString 状態パターン = new RString("1");
    private static final ReportId 帳票ID = new ReportId("DBC200009_KyufuKanrihyoSofuIchiran");

    /**
     * onLoadのメソッドです。
     *
     * @param div KyufuKanrihyoPanelDiv
     * @return ResponseData KyufuKanrihyoPanelDiv
     */
    public ResponseData<KyufuKanrihyoPanelDiv> onLoad(KyufuKanrihyoPanelDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        div.getTxtSaishuKoshinbi().setValue(基準日);
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KyufuKanrihyoPanelDiv
     * @return ResponseData DBC110010_KyufukanrihyoOutParameter
     */
    public ResponseData<DBC110010_KyufukanrihyoOutParameter> onClick_Execute(KyufuKanrihyoPanelDiv div) {
        if (getHandler(div).setBatchParameter(再処理区分, 処理年月, 外部ＣＳＶファイル名) != null) {
            return getHandler(div).setBatchParameter(再処理区分, 処理年月, 外部ＣＳＶファイル名);
        }
        return ResponseData.of(new DBC110010_KyufukanrihyoOutParameter()).respond();
    }

    private KyufuKanrihyoPanelHandler getHandler(KyufuKanrihyoPanelDiv div) {
        return KyufuKanrihyoPanelHandler.of(div);
    }
}
