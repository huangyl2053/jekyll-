/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200025;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200025.SogoJigyohiKagoMositateshoJohoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[179]総合事業費過誤申立書情報のクラスです。
 *
 * @reamsid_L DBC-2530-010 chenyadong
 */
public class SogoJigyohiKagoMositateshoJohoPanelHandler {

    private final SogoJigyohiKagoMositateshoJohoPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SogoJigyohiKagoMositateshoJohoPanelDiv
     */
    public SogoJigyohiKagoMositateshoJohoPanelHandler(SogoJigyohiKagoMositateshoJohoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {
        RString 状態パターン2 = new RString("2");
        KokuhorenDataSofuViewState 送付情報 = ViewStateHolder.get(ViewStateHolderName.国保連送付情報, KokuhorenDataSofuViewState.class);
        RString 再処理区分 = 送付情報.get再処理区分();
        RYearMonth 処理年月 = 送付情報.get処理年月();
        RString 外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン2);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200079.getReportId());
    }
}
