/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.JikoFutangakuJohoHoseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
public class JikoFutangakuJohoHoseiHandler {

    private final JikoFutangakuJohoHoseiDiv div;
    private static final RString 入力前 = new RString("onClick_btn");

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

        div.getTxtKakuninJouhouUketoriYM().setValue(new RDate(ViewStateHolder.get(ViewStateKeys.最新の処理年月,
                FlexibleYearMonth.class).toString()));
        RString 支払場所 = DbBusinessConfig.get(ConfigNameDBC.高額合算自己負担額補正_支払場所, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        div.getTxtShiharaiBasho().setValue(支払場所);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200031.getReportId());
    }

    /**
     * エラー時処理。
     *
     * @param flag boolean
     */
    public void setCommonButtonVisible(boolean flag) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(入力前, flag);
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
