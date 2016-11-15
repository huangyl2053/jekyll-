/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011.JikoFutangakuKeisanIkkatsuPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のクラスです。
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
public class JikoFutangakuKeisanIkkatsuPanelHandler {

    private static final RString 処理枝番 = new RString("0000");
    private static final RString 被保険者番号指定RAD = new RString("hihokenshaNo");
    private static final RString 開始年度 = new RString("2014");
    private static final RString 文字_年度 = new RString("年度");
    private static final RString 開始MONTHDAY = new RString("0101");
    private static final RString 終了MONTHDAY = new RString("0731");
    private static final RString NUM_4 = new RString("4");
    private static final RString NUM_10 = new RString("10");

    private final JikoFutangakuKeisanIkkatsuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public JikoFutangakuKeisanIkkatsuPanelHandler(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {
        画面初期化対象者について計算();
        画面初期化被保険者番号();
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200203.getReportId());
    }

    /**
     * 画面初期化対象者について計算のメソッドます。
     */
    private void 画面初期化対象者について計算() {
        RDate 適用基準日 = RDate.getNowDate();
        Association 市町村コードTemp = AssociationFinderFactory.createInstance().getAssociation();
        ShoriDateKanri 処理日付管理マスタ;
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        処理日付管理マスタ = manager.get処理日付管理マスタ(SubGyomuCode.DBC介護給付,
                市町村コードTemp.get地方公共団体コード(),
                ShoriName.事業分自己負担額計算.get名称(), 処理枝番);
        if (処理日付管理マスタ != null) {
            FlexibleDate 基準年月日Temp = 処理日付管理マスタ.get基準年月日();
            RDate 前回対象開始年月日Temp = new RDate(処理日付管理マスタ.get対象開始年月日().toString());
            RString 前回対象開始年月日 = DateConverter.toWarekiHalf_Zero(前回対象開始年月日Temp);
            RTime 前回対象開始日時Temp = 処理日付管理マスタ.get対象開始日時().getRDateTime().getTime();
            RString 前回対象開始日時 = DateConverter.getTime141(前回対象開始日時Temp);
            div.getTxtZenkaiUketoriYM().setValue(new RDate(基準年月日Temp.toString()));
            div.getTxtZenkaiShoriYMD().setValue(前回対象開始年月日.concat(RString.FULL_SPACE).concat(前回対象開始日時));
        } else {
            div.getTxtZenkaiUketoriYM().clearValue();
            div.getTxtZenkaiShoriYMD().clearValue();
        }
        KokuhorenInterfaceKanri 国保連インターフェース管理;
        KokuhorenInterfaceKanriManager 国保連管理Manager = new KokuhorenInterfaceKanriManager();
        RString 処理状態区分 = ShoriJotaiKubun.終了.getコード();
        RString 交換情報識別番号 = getConfig値(ConfigNameDBC.国保連取込_高額合算自己負担額確認情報_交換情報識別番号,
                適用基準日);
        国保連インターフェース管理 = 国保連管理Manager.get新国保連インターフェース管理(処理状態区分, 交換情報識別番号);
        if (国保連インターフェース管理 != null) {
            FlexibleYearMonth 受取年月TXT = 国保連インターフェース管理.get処理年月();
            div.getTxtUketoriYM().setValue(new RDate(受取年月TXT.toString()));
        } else {
            div.getTxtUketoriYM().setValue(null);
        }
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.DBC介護給付);
    }

    /**
     * 画面初期化被保険者番号のメソッドです。
     */
    private void 画面初期化被保険者番号() {
        RString システム日付Year = RDate.getNowDate().getYear().toDateString();
        RString システム日付 = RDate.getNowDate().toDateString();
        int difference = Integer.parseInt(システム日付Year.toString()) - Integer.parseInt(開始年度.toString());
        RString システム日付MonthDay = new RString(システム日付.toString().substring(Integer.parseInt(NUM_4.toString())));
        List<KeyValueDataSource> datasource;
        if (システム日付MonthDay.compareTo(開始MONTHDAY) >= 0 && システム日付MonthDay.compareTo(終了MONTHDAY) <= 0) {
            datasource = insertIntoDatasource(difference - 1);
        } else {
            datasource = insertIntoDatasource(difference);
        }
        div.getDdlNendo().setDataSource(datasource);
        div.getDdlNendo().setSelectedKey(RDate.getNowDate().getNendo().plusYear(-1).toDateString());
    }

    /**
     * insertintoDatasourceは循環がdatasourceです。
     *
     * @param difference int
     * @return datasource List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> insertIntoDatasource(int difference) {
        List<KeyValueDataSource> datasourceList = new ArrayList();
        int 年度;
        for (int i = 0; i <= difference; i++) {
            年度 = Integer.parseInt(開始年度.toString()) + i;
            RString key = new RString(年度);
            FlexibleYear year = new FlexibleYear(key);
            RString value = year.wareki().toDateString().concat(文字_年度);
            datasourceList.add(new KeyValueDataSource(key, value));
        }
        return datasourceList;
    }

    /**
     * radSakuseiJokenのonChange事件です。
     */
    public void onChangeRadSakuseiJoken() {
        if (被保険者番号指定RAD.equals(div.getRadHihokenshaNo().getSelectedKey())) {
            div.getTxtUketoriYM().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(false);
            div.getTxtHihokenshaNo().setReadOnly(false);
            div.getBtnSearchHihokensha().setDisabled(false);
            div.getDdlNendo().setDisabled(false);
            div.getTxtHihokenshaNo().setRequired(true);
            div.getTxtZenkaiUketoriYM().clearValue();
            div.getTxtZenkaiShoriYMD().clearValue();
            div.getTxtUketoriYM().clearValue();
            div.getTxtHihokenshaNo().clearValue();
        } else {
            div.getTxtUketoriYM().setDisabled(false);
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getTxtHihokenshaNo().setReadOnly(true);
            div.getBtnSearchHihokensha().setDisabled(true);
            div.getDdlNendo().setDisabled(true);
            div.getTxtUketoriYM().setRequired(true);
            div.getTxtHihokenshaNo().clearValue();
            画面初期化対象者について計算();
            画面初期化被保険者番号();
        }
    }

    /**
     * 被保険者番号のonBlur事件です。
     */
    public void onBlur被保険者番号() {
        if (div.getTxtHihokenshaNo().getValue().toString().length() < Integer.parseInt(NUM_10.toString())
                && !div.getTxtHihokenshaNo().getValue().toString().isEmpty()) {
            div.getTxtHihokenshaNo().setValue(div.getTxtHihokenshaNo().getValue().
                    padZeroToLeft(Integer.parseInt(NUM_10.toString())));
        }
    }

}
