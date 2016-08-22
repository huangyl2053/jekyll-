/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.JikoFutangakuJohoHoseiDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
public class JikoFutangakuJohoHoseiHandler {

    private final JikoFutangakuJohoHoseiDiv div;
    private static final RString 送付取込区分 = new RString("2");
    private static final RString 処理状態区分 = new RString("3");
    private static final RString 交換情報識別番号 = new RString("37J");
    private static final RString MAX = new RString("MAX");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     */
    public JikoFutangakuJohoHoseiHandler(JikoFutangakuJohoHoseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {

        KokuhorenInterfaceKanri 国保連インターフェース管理Max;
        KokuhorenInterfaceKanriManager 国保連インターフェース管理Manager = new KokuhorenInterfaceKanriManager();
        国保連インターフェース管理Max = 国保連インターフェース管理Manager.get新国保連インターフェース管理(
                MAX, 送付取込区分, 処理状態区分, 交換情報識別番号);
        if (国保連インターフェース管理Max != null) {
            FlexibleYearMonth 最新の処理年月 = 国保連インターフェース管理Max.get処理年月();
            div.getTxtKakuninJouhouUketoriYM().setValue(new RDate(最新の処理年月.toString()));
        } else {
            div.getTxtKakuninJouhouUketoriYM().setValue(null);
            throw new ApplicationException(DbcErrorMessages.自己負担額確認情報取込前.getMessage());
        }
        RString 支払場所 = DbBusinessConfig.get(ConfigNameDBC.高額合算自己負担額補正_支払場所, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        div.getTxtShiharaiBasho().setValue(支払場所);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200031.getReportId());
    }

    /**
     * txtKaishiYMDのonChange事件です。
     */
    public void onChangeKaishiYMD() {
        RString week = new RString(new RDate(div.getTxtKaishiYMD().getValue().toString()).
                getDayOfWeek().getShortTerm());
        div.getTxtKaishiYoubi().setValue(week);
    }

    /**
     * txtShuryoYMDのonChange事件です。
     */
    public void onChangeShuryoYMD() {
        RString week = new RString(new RDate(div.getTxtShuryoYMD().getValue().toString()).
                getDayOfWeek().getShortTerm());
        div.getTxtShuryoYoubi().setValue(week);
    }
}
