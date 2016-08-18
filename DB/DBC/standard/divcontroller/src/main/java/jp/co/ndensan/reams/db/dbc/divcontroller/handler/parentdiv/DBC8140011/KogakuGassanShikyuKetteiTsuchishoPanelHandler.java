/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8140011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.KougakugassanShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011.KogakuGassanShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JigyoKogakuGassanShikyuFushikyuKetteiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JigyoKogakuGassanShikyuGakuKeisanKekkaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kougakugassanshikyuketteitsuchisho.KougakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.service.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService;
import jp.co.ndensan.reams.db.dbc.service.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 画面設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のハンドラクラスです。
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public class KogakuGassanShikyuKetteiTsuchishoPanelHandler {

    private final KogakuGassanShikyuKetteiTsuchishoPanelDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 拡張情報 = new RString("被保険者番号");
    private static final RString 完了メッセージメイン = new RString("事業分高額合算支給決定通知書の発行が完了しました。");
    private static final RString データ作成区分_1 = new RString("1");
    private static final RString データ作成区分_2 = new RString("2");
    private static final RString データ作成区分_3 = new RString("3");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString 項目名 = new RString("支払予定日印字有無");
    private static final YubinNo 支給額計算結果連絡先郵便番号 = new YubinNo("9999999");
    private static final ReportId 帳票ID = new ReportId("DBC200201_GassanJigyobunKetteiTsuchisho");
    private static final int 整数_ZERO = 0;
    private static final Code CODE_0003 = new Code("0003");
    private static final Code CODE_003 = new Code("003");
    private static final RString 発行する = new RString("btnReportPublish");
    private static final RString 再検索する = new RString("btnResearch");
    private static final RString 検索結果一覧へ = new RString("btnSearchResult");

    /**
     * コンストラクタです。
     *
     * @param div HeijunkaKakuteiDiv
     */
    public KogakuGassanShikyuKetteiTsuchishoPanelHandler(KogakuGassanShikyuKetteiTsuchishoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon().initialize(識別コード);
        div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon().initialize(被保険者番号);
        if (!get前排他(被保険者番号.getColumnValue())) {
            状態4();
            throw new PessimisticLockingException();
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        JukyushaDaichoManager manage1 = new JukyushaDaichoManager();
        List<JukyushaDaicho> 受給者台帳 = manage1.get受給者台帳情報(被保険者番号);
        SogoJigyoTaishoshaManager manage2 = new SogoJigyoTaishoshaManager();
        List<SogoJigyoTaishosha> 総合事業対象者 = manage2.get総合事業対象者(被保険者番号);
        if (受給者台帳.isEmpty() || 総合事業対象者.isEmpty()) {
            validPairs = getValidationHandler().受給共通_受給者登録なしチェック();
            if (validPairs.iterator().hasNext()) {
                return validPairs;
            }
        }
        JigyoKogakuGassanShikyuFushikyuKetteiManager manage3 = new JigyoKogakuGassanShikyuFushikyuKetteiManager();
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List = manage3.get事業高額合算支給不支給決定一覧(被保険者番号);
        if (事業高額合算支給不支給決定List.isEmpty()) {
            validPairs = getValidationHandler().高額合算支給不支給マスタデータなしチェック();
            if (validPairs.iterator().hasNext()) {
                return validPairs;
            }
        }
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List1 = new ArrayList<>();
        JigyoKogakuGassanShikyuGakuKeisanKekkaManager manage4 = new JigyoKogakuGassanShikyuGakuKeisanKekkaManager();
        for (JigyoKogakuGassanShikyuFushikyuKettei shikyuKettei : 事業高額合算支給不支給決定List) {
            if (データ作成区分_2.equals(shikyuKettei.getデータ作成区分())) {
                事業高額合算支給不支給決定List1.add(shikyuKettei);

            } else {
                List<JigyoKogakuGassanShikyuGakuKeisanKekka> 事業高額合算支給計算結果 = manage4.get事業高額合算支給額計算結果一覧(
                        shikyuKettei.get被保険者番号(), shikyuKettei.get対象年度(), shikyuKettei.get保険者番号(), shikyuKettei.get支給申請書整理番号());
                get結果(事業高額合算支給不支給決定List1, 事業高額合算支給計算結果, shikyuKettei);

            }
        }
        ViewStateHolder.put(ViewStateKeys.事業高額合算支給不支給決定List, (Serializable) 事業高額合算支給不支給決定List1);
        getMap(事業高額合算支給不支給決定List1);
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = ViewStateHolder.get(ViewStateKeys.対象年度_連絡票整理番号Map, Map.class);
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = ViewStateHolder.get(ViewStateKeys.連絡票整理番号_履歴番号Map, Map.class);
        RString 帳票制御汎用キー = set支払予定日印字有無();
        if (RSTRING_0.equals(帳票制御汎用キー)) {
            div.getTxtShiharaiYoteiYMD().setVisible(false);

        }
        if (RSTRING_1.equals(帳票制御汎用キー)) {
            div.getTxtShiharaiYoteiYMD().setVisible(true);
            div.getTxtShiharaiYoteiYMD().setDisabled(false);
        }
        div.getDdlTaishoNendo().getDataSource().clear();
        set対象年度(対象年度_連絡票整理番号);
        set連絡票整理番号(対象年度_連絡票整理番号);
        set履歴番号(連絡票整理番号_履歴番号);
        set前回発行日();
        div.getCcdBunshoNO().initialize(帳票ID);
        div.getTxtHakkouYMD().setValue(RDate.getNowDate());
        return validPairs;

    }

    private void set対象年度(Map<FlexibleYear, Set<RString>> map) {
        List<FlexibleYear> 対象年度List = new ArrayList<>(map.keySet());
        if (!対象年度List.isEmpty()) {
            Comparator<FlexibleYear> comparator = new Comparator<FlexibleYear>() {
                @Override
                public int compare(FlexibleYear s1, FlexibleYear s2) {
                    return s2.compareTo(s1);
                }
            };
            Collections.sort(対象年度List, comparator);
            List<KeyValueDataSource> ddlTaishoNendodataSource = new ArrayList();
            for (FlexibleYear 対象年度 : 対象年度List) {
                ddlTaishoNendodataSource.add(new KeyValueDataSource(対象年度.toDateString(), 対象年度.toDateString()));
            }
            div.getDdlTaishoNendo().setDataSource(ddlTaishoNendodataSource);
            div.getDdlTaishoNendo().setSelectedIndex(整数_ZERO);
        }
    }

    /**
     * 連絡票整理番号のセットのンメソッドです。
     *
     * @param map Map
     */
    public void set連絡票整理番号(Map<FlexibleYear, Set<RString>> map) {
        RString select対象年度 = div.getDdlTaishoNendo().getSelectedKey();
        List<RString> 連絡票整理番号List = new ArrayList<>(map.get(new FlexibleYear(select対象年度)));
        if (!連絡票整理番号List.isEmpty()) {
            Comparator<RString> comparator = new Comparator<RString>() {
                @Override
                public int compare(RString s1, RString s2) {
                    return s2.compareTo(s1);
                }
            };
            Collections.sort(連絡票整理番号List, comparator);
            List<KeyValueDataSource> 連絡票整理番号KeyValue = new ArrayList<>();
            for (RString 連絡票整理番号 : 連絡票整理番号List) {
                if (!連絡票整理番号KeyValue.contains(
                        new KeyValueDataSource(連絡票整理番号, 連絡票整理番号))) {
                    連絡票整理番号KeyValue.add(new KeyValueDataSource(連絡票整理番号, 連絡票整理番号));
                }
            }
            div.getDdlRearakuhyoSeiriNO().setDataSource(連絡票整理番号KeyValue);
            div.getDdlRearakuhyoSeiriNO().setSelectedIndex(整数_ZERO);
        }
    }

    /**
     * 履歴番号のセットのンメソッドです。
     *
     * @param map Map
     */
    public void set履歴番号(Map<RString, Set<RString>> map) {
        RString select連絡票整理番号 = div.getDdlRearakuhyoSeiriNO().getSelectedKey();
        List<RString> 履歴番号List = new ArrayList<>(map.get(select連絡票整理番号));
        if (!履歴番号List.isEmpty()) {
            Comparator<RString> comparator = new Comparator<RString>() {
                @Override
                public int compare(RString s1, RString s2) {
                    return s2.compareTo(s1);
                }
            };
            Collections.sort(履歴番号List, comparator);
            List<KeyValueDataSource> 履歴番号KeyValue = new ArrayList<>();
            for (RString 履歴番号 : 履歴番号List) {
                if (!履歴番号KeyValue.contains(
                        new KeyValueDataSource(履歴番号, 履歴番号))) {
                    履歴番号KeyValue.add(new KeyValueDataSource(履歴番号, 履歴番号));
                }
            }
            div.getDdlRirekiNO().setDataSource(履歴番号KeyValue);
            div.getDdlRirekiNO().setSelectedIndex(整数_ZERO);
        }
    }

    /**
     * 前回発行日のセットのンメソッドです。
     *
     *
     */
    public void set前回発行日() {
        List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定List, List.class);
        RString select対象年度 = div.getDdlTaishoNendo().getSelectedKey();
        RString select連絡票整理番号 = div.getDdlRearakuhyoSeiriNO().getSelectedKey();
        RString select履歴番号 = div.getDdlRirekiNO().getSelectedKey();
        div.getTxtZenkaiHakkoYMD().setDisabled(true);
        RDate 前回発行日 = null;
        for (JigyoKogakuGassanShikyuFushikyuKettei shikyuKettei : 事業高額合算支給不支給決定List) {
            if (select対象年度.equals(shikyuKettei.get対象年度().toDateString())
                    && select連絡票整理番号.equals(shikyuKettei.get支給申請書整理番号())
                    && select履歴番号.equals(new RString(shikyuKettei.get履歴番号()))) {
                前回発行日 = shikyuKettei.get決定通知書作成年月日() != null
                        ? new RDate(shikyuKettei.get決定通知書作成年月日().toString()) : null;

                ViewStateHolder.put(ViewStateKeys.事業高額合算支給不支給決定, shikyuKettei);
                break;
            }
        }
        if (前回発行日 != null) {
            div.getTxtZenkaiHakkoYMD().setValue(前回発行日);
        }
    }

    /**
     * データを更新のンメソッドです。
     *
     */
    public void データ更新() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定, JigyoKogakuGassanShikyuFushikyuKettei.class);
        if (div.getTxtHakkouYMD().getValue() != null) {
            FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkouYMD().getValue().toDateString());
            事業高額合算支給不支給決定 = 事業高額合算支給不支給決定.createBuilderForEdit().set決定通知書作成年月日(発行日).build();
            //TODO 決定通知リアル発行フラグ QA1241
            事業高額合算支給不支給決定.toEntity().setState(EntityDataState.Modified);
            JigyoKogakuGassanShikyuFushikyuKetteiManager manage = new JigyoKogakuGassanShikyuFushikyuKetteiManager();
            manage.save事業高額合算支給不支給決定(事業高額合算支給不支給決定);
            AccessLogger.log(AccessLogType.更新, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        }
    }

    private void getMap(List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List) {
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = new HashMap<>();
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = new HashMap<>();
        for (JigyoKogakuGassanShikyuFushikyuKettei shikyuKettei : 事業高額合算支給不支給決定List) {
            if (対象年度_連絡票整理番号.containsKey(shikyuKettei.get対象年度())) {
                対象年度_連絡票整理番号.get(shikyuKettei.get対象年度()).add(shikyuKettei.get支給申請書整理番号());
            } else {
                Set<RString> 連絡票整理番号 = new HashSet<>();
                連絡票整理番号.add(shikyuKettei.get支給申請書整理番号());
                対象年度_連絡票整理番号.put(shikyuKettei.get対象年度(), 連絡票整理番号);
            }
            if (連絡票整理番号_履歴番号.containsKey(shikyuKettei.get支給申請書整理番号())) {
                連絡票整理番号_履歴番号.get(shikyuKettei.get支給申請書整理番号()).add(new RString(shikyuKettei.get履歴番号()));
            } else {
                Set<RString> 履歴番号 = new HashSet<>();
                履歴番号.add(new RString(shikyuKettei.get履歴番号()));
                連絡票整理番号_履歴番号.put(shikyuKettei.get支給申請書整理番号(), 履歴番号);
            }

        }
        ViewStateHolder.put(ViewStateKeys.対象年度_連絡票整理番号Map, (Serializable) 対象年度_連絡票整理番号);
        ViewStateHolder.put(ViewStateKeys.連絡票整理番号_履歴番号Map, (Serializable) 連絡票整理番号_履歴番号);
    }

    private List<JigyoKogakuGassanShikyuFushikyuKettei> get結果(
            List<JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算支給不支給決定List,
            List<JigyoKogakuGassanShikyuGakuKeisanKekka> 事業高額合算支給計算結果,
            JigyoKogakuGassanShikyuFushikyuKettei shikyuKettei) {
        for (JigyoKogakuGassanShikyuGakuKeisanKekka keisanKekka : 事業高額合算支給計算結果) {
            if ((データ作成区分_1.equals(keisanKekka.getデータ区分()) || データ作成区分_3.equals(keisanKekka.getデータ区分()))
                    && !(支給額計算結果連絡先郵便番号.equals(keisanKekka.get支給額計算結果連絡先郵便番号()))) {
                事業高額合算支給不支給決定List.add(shikyuKettei);
                break;
            }

        }

        return 事業高額合算支給不支給決定List;
    }

    /**
     * 前排他のンメソッドます。
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(CODE_0003, 拡張情報, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1);
    }

    private PersonalData personalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(CODE_003, 拡張情報, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1);
    }

    /**
     * 支払予定日印字有無のセットのンメソッドます。
     *
     * @return RString
     */
    public RString set支払予定日印字有無() {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用キー = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID, 項目名);
        if (帳票制御汎用キー == null) {
            return null;
        }
        ViewStateHolder.put(ViewStateKeys.支払予定日印字有無, 帳票制御汎用キー.get設定値());
        return 帳票制御汎用キー.get設定値();
    }

    /**
     * 共同処理用受給者異動連絡票データ作成です。
     *
     * @param entity KogakuGassanShikyuKetteiTsuchisho
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(KogakuGassanShikyuKetteiTsuchisho entity) {
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        if (!RSTRING_0.equals(支払予定日印字有無) && !RSTRING_1.equals(支払予定日印字有無)) {
            return null;
        }
        if (RSTRING_0.equals(支払予定日印字有無)) {
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService printService
                    = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService();
            return printService.printSingle(entity);
        } else {
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService printService
                    = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService();
            return printService.printSingle(entity);
        }

    }

    /**
     * 更新完了メッセージ設定です。
     */
    public void set更新完了メッセージ() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        AccessLogger.log(AccessLogType.照会, personalData(識別コード, 被保険者番号.getColumnValue()));
        div.getCcdKanryoMessage().setMessage(完了メッセージメイン,
                被保険者番号.getColumnValue(),
                div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon().get氏名漢字(),
                true);
    }

    /**
     * 入力項目のチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力項目チェック() {
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        RDate 支払予定日 = div.getTxtShiharaiYoteiYMD().getValue();
        RDate 前回発行日 = div.getTxtZenkaiHakkoYMD().getValue();
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RSTRING_1.equals(支払予定日印字有無) && 支払予定日 == null) {
            validPairs = getValidationHandler().未入力チェック();
            if (validPairs.iterator().hasNext()) {
                return validPairs;
            }
        }
        if (前回発行日 == null) {
            validPairs = getValidationHandler().高額合算支給決定通知書発行済チェック();
            if (validPairs.iterator().hasNext()) {
                return validPairs;
            }
        }
        return validPairs;
    }

    /**
     * 高額合算支給情報存在エラーチェックです。
     *
     * @param データ有無 RString
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 高額合算支給情報存在エラーチェック(RString データ有無) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RSTRING_1.equals(データ有無)) {
            validPairs = getValidationHandler().高額合算支給情報存在エラーチェック();
            if (validPairs.iterator().hasNext()) {
                状態2();
                return validPairs;
            }
        }
        return validPairs;
    }

    /**
     * 事業高額合算情報取得です。
     *
     * @return KougakugassanShikyuketteiTsuuchishoOutputEntity
     */
    public KougakugassanShikyuketteiTsuuchishoOutputEntity editKougakugassanShikyuketteiTsuuchisho() {
        JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定 = ViewStateHolder.
                get(ViewStateKeys.事業高額合算支給不支給決定, JigyoKogakuGassanShikyuFushikyuKettei.class);
        Koza koza = KougakuGassanShikyuKetteiTsuchisho.createInstance().getKozaJyoho(事業高額合算支給不支給決定.get口座ID());
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 支払予定日印字有無 = ViewStateHolder.get(ViewStateKeys.支払予定日印字有無, RString.class);
        ReportId reportId;
        FlexibleDate 発行日 = div.getTxtHakkouYMD().getValue() != null
                ? new FlexibleDate(div.getTxtHakkouYMD().getValue().toDateString()) : FlexibleDate.EMPTY;
        FlexibleDate 支払予定日 = div.getTxtShiharaiYoteiYMD().getValue() != null
                ? new FlexibleDate(div.getTxtShiharaiYoteiYMD().getValue().toDateString()) : FlexibleDate.EMPTY;
        if (RSTRING_0.equals(支払予定日印字有無)) {
            reportId = ReportIdDBC.DBC200201.getReportId();
        } else {
            reportId = ReportIdDBC.DBC200202.getReportId();
        }
        RString 文書番号 = div.getCcdBunshoNO().get文書番号() != null ? div.getCcdBunshoNO().get文書番号() : RString.EMPTY;
        FlexibleYear 対象年度 = new FlexibleYear(div.getDdlTaishoNendo().getSelectedKey());
        RString 連絡票整理番号 = div.getDdlRearakuhyoSeiriNO().getSelectedKey();
        int 履歴番号 = Integer.parseInt(div.getDdlRirekiNO().getSelectedKey().toString());
        KougakugassanShikyuketteiTsuuchishoOutputEntity outputEntity = KougakuGassanShikyuKetteiTsuchisho.createInstance()
                .editKougakugassanShikyuketteiTsuuchisho(識別コード, 被保険者番号, reportId, 対象年度, 連絡票整理番号, 履歴番号,
                        文書番号, 発行日, 支払予定日, koza);
        return outputEntity;
    }

    private void 状態2() {
        div.getDdlTaishoNendo().setDisabled(true);
        div.getDdlRearakuhyoSeiriNO().setDisabled(true);
        div.getDdlRirekiNO().setDisabled(true);
        div.getTxtHakkouYMD().setDisabled(true);
        div.getTxtShiharaiYoteiYMD().setDisabled(true);
        div.getCcdBunshoNO().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
    }

    /**
     * 状態4設定です。
     *
     */
    public void 状態4() {
        div.setVisible(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(再検索する, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(再検索する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(検索結果一覧へ, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索結果一覧へ, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(発行する, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
    }

    private KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler getValidationHandler() {
        return new KogakuGassanShikyuKetteiTsuchishoPanelValidationHandler();
    }

}
