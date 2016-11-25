/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN140001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020070.DBC020070_JigyobunShikyugakuKeisanParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001.JigyobunShikyugakuCalcPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNN1004_事業分支給額計算
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class JigyobunShikyugakuCalcPanelHandler {

    private final JigyobunShikyugakuCalcPanelDiv div;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString TAISHOSHASEARCH = new RString("taishoshaSearch");
    private static final RString HIHOKENSHANOSHTEI = new RString("hihokenshaNoShitei");
    private static final int INT_SIX = 6;
    private static final int INT_SEVEN = 7;
    private static final FlexibleYear 定値_2014 = new FlexibleYear("2014");

    /**
     * 初期化です。
     *
     * @param div JigyobunShikyugakuCalcPanelDiv
     */
    public JigyobunShikyugakuCalcPanelHandler(JigyobunShikyugakuCalcPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化です。
     */
    public void initialize画面() {
        LasdecCode 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        ShoriDateKanri 処理日付管理データ = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(
                SubGyomuCode.DBC介護給付, 地方公共団体コード, ShoriName.事業分支給額計算.get名称());
        if (処理日付管理データ != null) {
            div.getChushutsuJoken().getTxtZenkaiUketoriYM().setValue(処理日付管理データ.get基準年月日());
            div.getChushutsuJoken().getTxtZenkaiUketoriDate().setValue(処理日付管理データ.get対象開始年月日());
            if (処理日付管理データ.get対象開始日時() != null && !処理日付管理データ.get対象開始日時().isEmpty()) {
                div.getChushutsuJoken().getTxtZenkaiUketoriTime().setValue(
                        処理日付管理データ.get対象開始日時().getRDateTime().getTime());
            }
        }
        KokuhorenInterfaceKanriManager kokuManager = new KokuhorenInterfaceKanriManager();
        KokuhorenInterfaceKanri 国保連管理データ = kokuManager.get新国保連インターフェース管理(
                THREE, ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.getコード());
        if (国保連管理データ != null) {
            div.getChushutsuJoken().getTxtUketoriYM().setValue(
                    new FlexibleDate(国保連管理データ.get処理年月().toDateString()));
        }
        FlexibleYear 処理年度 = new FlexibleYear(RDate.getNowDate().getYear().toDateString());
        if (RDate.getNowDate().getMonthValue() < INT_SEVEN && 1 < RDate.getNowDate().getMonthValue()) {
            処理年度 = 処理年度.minusYear(1);
        }
        div.getDdlNendo().setDataSource(createDropDownList(処理年度, 定値_2014));
        div.getDdlNendo().setSelectedKey(RDate.getNowDate().getYear().minusYear(1).toDateString());
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200204.getReportId());
        RDate システムタイム = RDate.getNowDate();
        RString 給付の種類 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_給付の種類,
                システムタイム, SubGyomuCode.DBC介護給付);
        RString 不支給理由 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_不支給理由,
                システムタイム, SubGyomuCode.DBC介護給付);
        RString 支払場所 = DbBusinessConfig.get(ConfigNameDBC.事業分高額合算支給額計算_支払方法,
                システムタイム, SubGyomuCode.DBC介護給付);
        div.getKoshinNaiyo().getTxtKyufunoShurui().setValue(給付の種類);
        div.getKoshinNaiyo().getTxtFushikyuRiyu().setValue(不支給理由);
        div.getKoshinNaiyo().getTxtShiharaiBasho().setValue(支払場所);
    }

    private List<KeyValueDataSource> createDropDownList(FlexibleYear 処理年度, FlexibleYear 処理開始年度) {
        List<KeyValueDataSource> list = new ArrayList<>();
        while ((処理年度 != null && !処理年度.isEmpty()) && (処理開始年度 != null && !処理開始年度.isEmpty()
                && 処理開始年度.isBeforeOrEquals(処理年度))) {
            KeyValueDataSource kv = new KeyValueDataSource(処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(kv);
            処理年度 = 処理年度.minusYear(1);
        }
        return list;
    }

    /**
     * 被保険者氏名の取得
     *
     * @param 識別コード ShikibetsuCode
     */
    public void get被保険者氏名(ShikibetsuCode 識別コード) {
        if (識別コード != null && !識別コード.isEmpty()) {
            IShikibetsuTaisho 宛名識別対象情報 = ShikibetsuTaishoService.getShikibetsuTaishoFinder().get識別対象(
                    GyomuCode.DB介護保険, 識別コード, KensakuYusenKubun.住登外優先);
            if (宛名識別対象情報 != null && 宛名識別対象情報.get名称() != null && 宛名識別対象情報.get名称().getName() != null
                    && !宛名識別対象情報.get名称().getName().isEmpty()) {
                div.getChushutsuJoken().getTxtHihokenshaMei().setValue(宛名識別対象情報.get名称().getName().value());
            } else {
                div.getChushutsuJoken().getTxtHihokenshaMei().clearValue();
            }
        }
    }

    /**
     * 受取年月指定RAD状態設定です。
     */
    public void set受取年月指定RAD状態() {
        div.getChushutsuJoken().getTxtZenkaiUketoriYM().setDisabled(false);
        div.getChushutsuJoken().getTxtZenkaiUketoriDate().setDisabled(false);
        div.getChushutsuJoken().getTxtZenkaiUketoriTime().setDisabled(false);
        div.getChushutsuJoken().getTxtUketoriYM().setRequired(true);
        div.getChushutsuJoken().getTxtHihokenshaNo().setDisabled(true);
        div.getChushutsuJoken().getTxtHihokenshaMei().setDisabled(true);
        div.getChushutsuJoken().getDdlNendo().setDisabled(true);
        div.getChushutsuJoken().getBtnHihokenshaSearch().setDisabled(true);
    }

    /**
     * 被保険者指定RAD設定です。
     */
    public void set被保険者指定RAD状態() {
        div.getChushutsuJoken().getTxtZenkaiUketoriYM().setDisabled(true);
        div.getChushutsuJoken().getTxtZenkaiUketoriDate().setDisabled(true);
        div.getChushutsuJoken().getTxtZenkaiUketoriTime().setDisabled(true);
        div.getChushutsuJoken().getTxtUketoriYM().setRequired(false);
        div.getChushutsuJoken().getTxtHihokenshaNo().setDisabled(false);
        div.getChushutsuJoken().getTxtHihokenshaMei().setDisabled(false);
        div.getChushutsuJoken().getDdlNendo().setDisabled(false);
        div.getChushutsuJoken().getBtnHihokenshaSearch().setDisabled(false);
    }

    /**
     * 開始年月日の曜日の設定です。
     */
    public void set開始年月日の曜日() {
        RString 曜日 = RString.EMPTY;
        if (div.getMadoguchibaraiJoho().getTxtKaishiDate().getValue() != null
                && !div.getMadoguchibaraiJoho().getTxtKaishiDate().getValue().isEmpty()) {
            曜日 = new RString(div.getMadoguchibaraiJoho().getTxtKaishiDate().
                    getValue().getDayOfWeek().getShortTerm());
        }
        div.getMadoguchibaraiJoho().getTxtKaishiYobi().setValue(曜日);
    }

    /**
     * 終了年月日の曜日の設定です。
     */
    public void set終了年月日の曜日() {
        RString 曜日 = RString.EMPTY;
        if (div.getMadoguchibaraiJoho().getTxtShuryoDate().getValue() != null
                && !div.getMadoguchibaraiJoho().getTxtShuryoDate().getValue().isEmpty()) {
            曜日 = new RString(div.getMadoguchibaraiJoho().getTxtShuryoDate().
                    getValue().getDayOfWeek().getShortTerm());
        }
        div.getMadoguchibaraiJoho().getTxtShuryoYobi().setValue(曜日);
    }

    /**
     * バッチパラメータ作成です。
     *
     * @return DBC020070_JigyobunShikyugakuKeisanParameter
     */
    public DBC020070_JigyobunShikyugakuKeisanParameter setBatchParam() {
        DBC020070_JigyobunShikyugakuKeisanParameter parameter = new DBC020070_JigyobunShikyugakuKeisanParameter();
        if (HIHOKENSHANOSHTEI.equals(div.getChushutsuJoken().getRadHihokenshaNoShitei().getSelectedKey())) {
            parameter.set年度(new FlexibleYear(div.getChushutsuJoken().getDdlNendo().getSelectedKey()));
            parameter.set出力対象区分(TWO);
            parameter.set被保険者番号(div.getChushutsuJoken().getTxtHihokenshaNo().getValue());
            parameter.set受取年月(null);
        } else if (TAISHOSHASEARCH.equals(div.getChushutsuJoken().getRadTaishoshaSearch().getSelectedKey())) {
            parameter.set年度(null);
            parameter.set出力対象区分(ONE);
            parameter.set被保険者番号(null);
            parameter.set受取年月(new FlexibleYearMonth(div.getChushutsuJoken().getTxtUketoriYM().
                    getValue().toString().substring(0, INT_SIX)));
        }
        parameter.set処理日(FlexibleDate.getNowDate());
        parameter.set処理時間(RTime.now());
        parameter.set決定年月日(div.getKoshinNaiyo().getTxtKetteiDate().getValue());
        parameter.set窓口払開始年月日(div.getKoshinNaiyo().getTxtKaishiDate().getValue());
        parameter.set窓口払開始時刻(div.getKoshinNaiyo().getTxtKaishiTime().getValue());
        parameter.set窓口払終了年月日(div.getKoshinNaiyo().getTxtShuryoDate().getValue());
        parameter.set窓口払終了時刻(div.getKoshinNaiyo().getTxtShuryoTime().getValue());
        parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
        return parameter;
    }

    /**
     * 警告メッセージの表示判定です。
     *
     * @return boolean
     */
    public boolean is警告メッセージの表示() {
        return ((TAISHOSHASEARCH.equals(div.getChushutsuJoken().getRadTaishoshaSearch().getSelectedKey()))
                && (div.getChushutsuJoken().getTxtZenkaiUketoriYM().getValue() != null
                && !div.getChushutsuJoken().getTxtZenkaiUketoriYM().getValue().isEmpty())
                && (div.getChushutsuJoken().getTxtZenkaiUketoriDate().getValue() != null
                && !div.getChushutsuJoken().getTxtZenkaiUketoriDate().getValue().isEmpty())
                && (div.getChushutsuJoken().getTxtZenkaiUketoriTime().getValue() != null));
    }
}
