/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230001.PanelKougakuKetteiTuutisyoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JigyoKogakuShikyuHanteiKekkaManager;
import jp.co.ndensan.reams.db.dbc.service.core.servicenokanribangourendou.ServiceNoKanribangouRendou;
import jp.co.ndensan.reams.db.dbc.service.report.jigyokogakuketteitsuchishoyoteibiyijiari.JigyoKogakuKetteiTsuchishoYoteiBiYijiAriPrintService;
import jp.co.ndensan.reams.db.dbc.service.report.jigyokogakuketteitsuchishoyoteibiyijinashi.JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 新総合事業・事業高額決定通知書（単）ハンドラクラスです。
 *
 * @reamsid_L DBC-4760-010 yebangqiang
 */
public final class PanelKougakuKetteiTuutisyoHandler {

    private final PanelKougakuKetteiTuutisyoDiv div;
    private static final ReportId 帳票ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_初回申請用 = new RString("key0");
    private static final RString 画面_初回申請用様式 = new RString("0");
    private static final RString 画面_自動償還用様式 = new RString("1");
    private static final RString 支払予定日印字有無_有 = new RString("1");
    private static final RString 決定通知リアル発行区分 = new RString("1");
    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString コード_ログコード = new RString("0003");
    private static final int INT_4 = 4;

    private PanelKougakuKetteiTuutisyoHandler(PanelKougakuKetteiTuutisyoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static PanelKougakuKetteiTuutisyoHandler of(PanelKougakuKetteiTuutisyoDiv div) {
        return new PanelKougakuKetteiTuutisyoHandler(div);
    }

    /**
     * 画面初期化するメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 市町村コード LasdecCode
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月リスト List<FlexibleYearMonth>
     */
    public void 画面初期化(ShikibetsuCode 識別コード, LasdecCode 市町村コード, HihokenshaNo 被保険者番号,
            List<FlexibleYearMonth> サービス提供年月リスト) {
        div.getKyoTuuKaigoAtena().initialize(識別コード);
        if (市町村コード != null) {
            div.getKyoTuuKaigoNinnteiSikaku().initialize(市町村コード.value(), 被保険者番号.value());
        }
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        div.getKougakuKetteiTuutisyoBunsho().initialize(帳票ID, システム日付);
        div.getRadSyoukaiSinnsei().setSelectedKey(定数_初回申請用);
        div.getTxtHakkoubi().setValue(new RDate(システム日付.toString()));
        RString 支払予定日印字有無 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_支払予定日印字有無,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (支払予定日印字有無_有.equals(支払予定日印字有無)) {
            div.getTxtSiharaiYoteibi().setVisible(true);
        } else {
            div.getTxtSiharaiYoteibi().setVisible(false);
        }
        div.getTxtHakkoubi().setValue(new RDate(システム日付.toString()));
        List<KeyValueDataSource> サービス提供年月ドロップダウンリスト = new ArrayList<>();
        Set<FlexibleYearMonth> サービス提供年月Set = new HashSet<>(サービス提供年月リスト);
        List<FlexibleYearMonth> 重複排除サービス提供年月リスト = new ArrayList<>(サービス提供年月Set);
        Collections.sort(重複排除サービス提供年月リスト, new Comparator<FlexibleYearMonth>() {
            @Override
            public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
                if (o1.isBefore(o2)) {
                    return 1;
                }
                return -1;
            }
        });
        for (FlexibleYearMonth サービス提供年月 : 重複排除サービス提供年月リスト) {
            サービス提供年月ドロップダウンリスト.add(new KeyValueDataSource(サービス提供年月.toDateString(),
                    サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).toDateString()));
        }
        div.getDdlServiceYearMonth().setDataSource(サービス提供年月ドロップダウンリスト);
        FlexibleYearMonth サービス提供年月 = サービス提供年月リスト.get(0);
        div.getDdlServiceYearMonth().setSelectedKey(サービス提供年月.toDateString());
        管理番号と前回発行日の設定(被保険者番号, サービス提供年月);
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号, 識別コード));
    }

    /**
     * 被保険者番号よりサービス提供年月リストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return サービス提供年月リスト List<FlexibleYearMonth>
     */
    public List<FlexibleYearMonth> getサービス提供年月リスト(HihokenshaNo 被保険者番号) {
        JigyoKogakuShikyuHanteiKekkaManager manager = InstanceProvider.create(JigyoKogakuShikyuHanteiKekkaManager.class);
        return manager.getサービス提供年月リスト(被保険者番号);
    }

    /**
     * サービス提供年月onChange管理番号リストの内容を変更するメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void 管理番号と前回発行日の設定(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        JigyoKogakuShikyuHanteiKekkaManager manager = InstanceProvider.create(JigyoKogakuShikyuHanteiKekkaManager.class);
        List<Decimal> 管理番号リスト = manager.get管理番号リスト(被保険者番号, サービス提供年月);
        List<KeyValueDataSource> 管理番号ドロップダウンリスト = new ArrayList<>();
        Set<Decimal> 管理番号Set = new HashSet<>(管理番号リスト);
        List<Decimal> 重複排除管理番号リスト = new ArrayList<>(管理番号Set);
        Collections.sort(重複排除管理番号リスト, new Comparator<Decimal>() {
            @Override
            public int compare(Decimal o1, Decimal o2) {
                return o2.compareTo(o1);
            }
        });
        for (Decimal 管理番号 : 重複排除管理番号リスト) {
            管理番号ドロップダウンリスト.add(new KeyValueDataSource(new RString(管理番号.toString()), new RString(管理番号.toString()).padZeroToLeft(INT_4)));
        }
        Decimal 管理番号 = 管理番号リスト.get(0);
        div.getDdlKanliBanngou().setDataSource(管理番号ドロップダウンリスト);
        div.getDdlKanliBanngou().setSelectedKey(new RString(管理番号.toString()));
        前回発行日の設定(被保険者番号, サービス提供年月, 管理番号);
    }

    /**
     * 管理番号onChange前回発行日の内容を変更するメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 管理番号 Decimal
     */
    public void 前回発行日の設定(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, Decimal 管理番号) {
        JigyoKogakuShikyuHanteiKekkaManager manager = InstanceProvider.create(JigyoKogakuShikyuHanteiKekkaManager.class);
        List<FlexibleDate> 前回発行日リスト = manager.get前回発行日リスト(被保険者番号, サービス提供年月, 管理番号);
        if (!前回発行日リスト.isEmpty() && 前回発行日リスト.get(0) != null && !前回発行日リスト.get(0).isEmpty()) {
            div.getTxtZennkaiHakkoubi().setValue(new RDate(前回発行日リスト.get(0).toString()));
        } else {
            div.getTxtZennkaiHakkoubi().clearValue();
        }
    }

    /**
     * 帳票印刷するメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 支払予定日印字有無 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection 帳票印刷(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, RString 支払予定日印字有無) {
        RString 様式 = 画面_初回申請用様式;
        if (!定数_初回申請用.equals(div.getRadSyoukaiSinnsei().getSelectedKey())) {
            様式 = 画面_自動償還用様式;
        }
        FlexibleDate 支払予定日 = FlexibleDate.EMPTY;
        if (支払予定日印字有無_有.equals(支払予定日印字有無) && div.getTxtSiharaiYoteibi().getValue() != null) {
            支払予定日 = new FlexibleDate(div.getTxtSiharaiYoteibi().getValue().toDateString());
        }
        FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString());
        ServiceNoKanribangouRendou 帳票情報Mgr = ServiceNoKanribangouRendou.createInstance();
        final HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getKyoTuuKaigoNinnteiSikaku().getHookenshaCode());
        final FlexibleYearMonth サービス提供年月 = new FlexibleDate(div.getDdlServiceYearMonth().getSelectedValue()).getYearMonth();
        JigyouKetteiTutisyoResult 帳票情報Entity = 帳票情報Mgr.selectKougakuJigyouKetteiTutisyo(
                div.getKougakuKetteiTuutisyoBunsho().get文書番号(), 発行日, 被保険者番号, サービス提供年月, 様式,
                Integer.parseInt(div.getDdlKanliBanngou().getSelectedValue().toString()), 識別コード, 支払予定日,
                証記載保険者番号, div.getKyoTuuKaigoAtena().get氏名漢字());
        if (支払予定日印字有無_有.equals(支払予定日印字有無)) {
            JigyoKogakuKetteiTsuchishoYoteiBiYijiAriPrintService printAri = new JigyoKogakuKetteiTsuchishoYoteiBiYijiAriPrintService();
            return printAri.printSingle(帳票情報Entity, 被保険者番号, 識別コード, 発行日);
        } else {
            JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiPrintService printNashi = new JigyoKogakuKetteiTsuchishoYoteiBiYijiNashiPrintService();
            return printNashi.printSingle(帳票情報Entity, 被保険者番号, 識別コード, 発行日);
        }
    }

    /**
     * 事業高額介護サービス費支給判定結果更新するメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void after帳票印刷(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号, 識別コード));

        LockingKey key = new LockingKey(排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        FlexibleYearMonth サービス提供年月 = new FlexibleDate(div.getDdlServiceYearMonth().getSelectedValue()).getYearMonth();
        Decimal 履歴番号 = new Decimal(div.getDdlKanliBanngou().getSelectedKey().toString());
        JigyoKogakuShikyuHanteiKekkaManager 事業高額介護サービス費支給判定結果Mgr = InstanceProvider
                .create(JigyoKogakuShikyuHanteiKekkaManager.class);
        List<JigyoKogakuShikyuHanteiKekka> 事業高額介護サービス費支給判定結果 = 事業高額介護サービス費支給判定結果Mgr
                .getサービス費支給判定結果(被保険者番号, サービス提供年月, 履歴番号);
        FlexibleDate 決定通知書作成年月日 = new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString());
        for (JigyoKogakuShikyuHanteiKekka jigyoKogakuShikyuHanteiKekka : 事業高額介護サービス費支給判定結果) {
            jigyoKogakuShikyuHanteiKekka = jigyoKogakuShikyuHanteiKekka.createBuilderForEdit()
                    .set決定通知書作成年月日(決定通知書作成年月日).build();
            jigyoKogakuShikyuHanteiKekka = jigyoKogakuShikyuHanteiKekka.createBuilderForEdit()
                    .set決定通知リアル発行区分(決定通知リアル発行区分).build();
            事業高額介護サービス費支給判定結果Mgr.update事業高額介護サービス費支給判定結果(jigyoKogakuShikyuHanteiKekka);
        }
        RealInitialLocker.release(key);
        AccessLogger.log(AccessLogType.更新, toPersonalData(被保険者番号, 識別コード));

    }

    /**
     * isデータの変更。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月リスト List<FlexibleYearMonth>
     *
     * @return isデータの変更
     */
    public boolean isデータの変更(HihokenshaNo 被保険者番号, List<FlexibleYearMonth> サービス提供年月リスト) {
        JigyoKogakuShikyuHanteiKekkaManager manager = InstanceProvider.create(JigyoKogakuShikyuHanteiKekkaManager.class);
        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        BunshoNo bunshoNo = finder.get文書番号管理(帳票ID, システム日付);
        if (サービス提供年月リスト.isEmpty()) {
            return false;
        }
        FlexibleYearMonth サービス提供年月 = サービス提供年月リスト.get(0);
        List<Decimal> 管理番号リスト = manager.get管理番号リスト(被保険者番号, サービス提供年月);
        Decimal 管理番号 = 管理番号リスト.get(0);

        return !定数_初回申請用.equals(div.getRadSyoukaiSinnsei().getSelectedKey())
                || !サービス提供年月.toDateString().equals(div.getDdlServiceYearMonth().getSelectedKey())
                || !管理番号.equals(new Decimal(div.getDdlKanliBanngou().getSelectedKey().toString()))
                || !getEdit文書番号(bunshoNo).equals(div.getKougakuKetteiTuutisyoBunsho().get文書番号())
                || !new RDate(システム日付.toString()).equals(div.getTxtHakkoubi().getValue())
                || div.getTxtSiharaiYoteibi().getValue() != null;
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(コード_ログコード), 定数_被保険者番号,
                被保険者番号.getColumnValue());
        return PersonalData.of(識別コード, expandedInfo);
    }

    private RString getEdit文書番号(BunshoNo bunshoNo) {
        if (null == bunshoNo) {
            return RString.EMPTY;
        }
        return new RStringBuilder(bunshoNo.getEdit文書番号記号())
                .append(bunshoNo.getEditヘッダー文字())
                .append(bunshoNo.get文書番号固定文字())
                .append(bunshoNo.getEditフッター文字())
                .toRString();
    }
}
