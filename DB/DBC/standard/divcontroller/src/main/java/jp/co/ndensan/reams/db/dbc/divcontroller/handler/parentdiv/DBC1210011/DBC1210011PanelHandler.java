/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1210011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.business.report.gassanketteitsuchisho.KogakuGassanShikyuKetteiTsuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi.KogakuGassanShikyuKetteiTsuchiParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1210011.DBC1210011PanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanShikyuFushikyuKetteiManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanShikyuGakuKeisanKekkaManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kougakugassanshikyuketteitsuchi.KougakuGassanShikyuKetteiTsuchi;
import jp.co.ndensan.reams.db.dbc.service.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService;
import jp.co.ndensan.reams.db.dbc.service.report.gassanketteitsuchisho.GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBCMN63003_高額合算支給決定通知書（単）のハンドラクラスです。
 *
 * @reamsid_L DBC-2310-010 chenyadong
 */
public class DBC1210011PanelHandler {

    private final DBC1210011PanelDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 拡張情報 = new RString("被保険者番号");
    private static final RString 完了メッセージメイン = new RString("高額合算支給決定通知書の発行が完了しました。");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString 項目名 = new RString("支払予定日印字有無");
    private static final YubinNo 支給額計算結果連絡先郵便番号 = new YubinNo("9999999");
    private static final ReportId 帳票ID = new ReportId("DBC100053_GassanKetteiTsuchisho");
    private static final int 整数_ZERO = 0;
    private static final int NUM_4 = 4;
    private static final RString ZERO_4 = new RString("0000");
    private static final Code CODE_003 = new Code("003");
    private static final RString 発行する = new RString("btnReportPublish");
    private static final RString 度STR = new RString("度");

    /**
     * コンストラクタです。
     *
     * @param div DBC1210011PanelDiv
     */
    public DBC1210011PanelHandler(DBC1210011PanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 支払予定日印字有無 RString
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, RString 支払予定日印字有無) {
        div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon().initialize(識別コード);
        div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKaigoKihon().initialize(被保険者番号);
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, false);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        div.getTxtZenkaiHakkoYMD().setDisabled(true);
        if (RSTRING_0.equals(支払予定日印字有無)) {
            div.getTxtShiharaiYoteiYMD().setVisible(false);

        }
        if (RSTRING_1.equals(支払予定日印字有無)) {
            div.getTxtShiharaiYoteiYMD().setVisible(true);
            div.getTxtShiharaiYoteiYMD().setDisabled(false);
        }
        div.getCcdBunshoNO().initialize(帳票ID);
        div.getTxtHakkouYMD().setValue(RDate.getNowDate());
    }

    /**
     * 受給者台帳のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyushaDaichoの{@code list}
     */
    public List<JukyushaDaicho> get受給者台帳(HihokenshaNo 被保険者番号) {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        return manager.get受給者台帳情報(被保険者番号);
    }

    /**
     * 総合事業対象者のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return SogoJigyoTaishoshaの{@code list}
     */
    public List<SogoJigyoTaishosha> get総合事業対象者(HihokenshaNo 被保険者番号) {
        SogoJigyoTaishoshaManager manager = new SogoJigyoTaishoshaManager();
        return manager.get総合事業対象者(被保険者番号);
    }

    /**
     * 高額合算支給不支給決定Listのメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return KogakuGassanShikyuFushikyuKetteiの{@code list}
     */
    public List<KogakuGassanShikyuFushikyuKettei> get高額合算支給不支給決定List(HihokenshaNo 被保険者番号) {
        KogakuGassanShikyuFushikyuKetteiManager manager = new KogakuGassanShikyuFushikyuKetteiManager();
        return manager.get高額合算支給不支給決定一覧(被保険者番号);
    }

    /**
     * 高額合算支給不支給決定Listのセットです。
     *
     * @param 高額合算支給不支給決定List KogakuGassanShikyuFushikyuKetteiの{@code list}
     * @return KogakuGassanShikyuFushikyuKetteiの{@code list}
     */
    public List<KogakuGassanShikyuFushikyuKettei> set高額合算支給不支給決定List(
            List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List) {
        List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List1 = new ArrayList<>();
        KogakuGassanShikyuGakuKeisanKekkaManager manage4 = new KogakuGassanShikyuGakuKeisanKekkaManager();
        for (KogakuGassanShikyuFushikyuKettei shikyuKettei : 高額合算支給不支給決定List) {
            List<KogakuGassanShikyuGakuKeisanKekka> 高額合算支給計算結果 = manage4.get高額合算支給額計算結果(
                    shikyuKettei.get被保険者番号(), shikyuKettei.get対象年度(), shikyuKettei.get保険者番号(),
                    shikyuKettei.get支給申請書整理番号());
            get結果(高額合算支給不支給決定List1, 高額合算支給計算結果, shikyuKettei);
        }
        return 高額合算支給不支給決定List1;
    }

    /**
     * 対象年度のセットのンメソッドです。
     *
     * @param map Map
     */
    public void set対象年度(Map<FlexibleYear, Set<RString>> map) {
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
                ddlTaishoNendodataSource.add(new KeyValueDataSource(対象年度.toDateString(),
                        対象年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString().concat(度STR)));
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
        if (map.isEmpty()) {
            return;
        }
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
        if (map.isEmpty()) {
            return;
        }
        RString select連絡票整理番号 = div.getDdlTaishoNendo().getSelectedKey()
                .concat(div.getDdlRearakuhyoSeiriNO().getSelectedKey());
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
                RString 履歴番号表示 = padZeroToLeft履歴番号(履歴番号);
                if (!履歴番号KeyValue.contains(
                        new KeyValueDataSource(履歴番号, 履歴番号表示))) {
                    履歴番号KeyValue.add(new KeyValueDataSource(履歴番号, 履歴番号表示));
                }
            }
            div.getDdlRirekiNO().setDataSource(履歴番号KeyValue);
            div.getDdlRirekiNO().setSelectedIndex(整数_ZERO);
        }
    }

    private RString padZeroToLeft履歴番号(RString 履歴番号) {
        if (履歴番号.length() >= NUM_4) {
            return 履歴番号;
        }
        RString 編集後履歴番号 = ZERO_4.concat(履歴番号);
        return 編集後履歴番号.substring(編集後履歴番号.length() - NUM_4);
    }

    /**
     * 前回発行日のセットのンメソッドです。
     *
     * @param shikyuKettei KogakuGassanShikyuFushikyuKettei
     */
    public void set前回発行日(KogakuGassanShikyuFushikyuKettei shikyuKettei) {
        div.getTxtZenkaiHakkoYMD().setDisabled(true);
        div.getTxtZenkaiHakkoYMD().clearValue();
        if (shikyuKettei != null) {
            RDate 前回発行日 = (shikyuKettei.get決定通知書作成年月日() != null && !shikyuKettei.get決定通知書作成年月日().isEmpty())
                    ? new RDate(shikyuKettei.get決定通知書作成年月日().toString()) : null;
            if (前回発行日 != null) {
                div.getTxtZenkaiHakkoYMD().setValue(前回発行日);
            }
        }
    }

    /**
     * 高額合算支給不支給決定のンメソッドです。
     *
     * @param 高額合算支給不支給決定List KogakuGassanShikyuFushikyuKetteiの{@code list}
     * @return KogakuGassanShikyuFushikyuKettei
     */
    public KogakuGassanShikyuFushikyuKettei get高額合算支給不支給決定(
            List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List) {
        RString select対象年度 = div.getDdlTaishoNendo().getSelectedKey();
        RString select連絡票整理番号 = div.getDdlRearakuhyoSeiriNO().getSelectedKey();
        RString select履歴番号 = div.getDdlRirekiNO().getSelectedKey();
        for (KogakuGassanShikyuFushikyuKettei shikyuKettei : 高額合算支給不支給決定List) {
            if (select対象年度.equals(shikyuKettei.get対象年度().toDateString())
                    && select連絡票整理番号.equals(shikyuKettei.get支給申請書整理番号())
                    && select履歴番号.equals(new RString(shikyuKettei.get履歴番号()))) {
                return shikyuKettei;
            }
        }
        return null;
    }

    /**
     * データを更新のンメソッドです。
     *
     * @param 高額合算支給不支給決定 KogakuGassanShikyuFushikyuKettei
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void データ更新(KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定, ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号) {
        if (div.getTxtHakkouYMD().getValue() != null) {
            FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkouYMD().getValue().toDateString());
            KogakuGassanShikyuFushikyuKetteiManager manager = new KogakuGassanShikyuFushikyuKetteiManager();
            manager.update決定通知書作成年月日(被保険者番号, 高額合算支給不支給決定.get対象年度(), 高額合算支給不支給決定.get保険者番号(),
                    高額合算支給不支給決定.get支給申請書整理番号(), 高額合算支給不支給決定.get履歴番号(), 発行日);
            AccessLogger.log(AccessLogType.更新, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        }
    }

    /**
     * 対象年度_連絡票整理番号Mapのメソッドです。
     *
     * @param 高額合算支給不支給決定List KogakuGassanShikyuFushikyuKetteiの{@code list}
     * @return Map
     */
    public Map<FlexibleYear, Set<RString>> put対象年度_連絡票整理番号(List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List) {
        Map<FlexibleYear, Set<RString>> 対象年度_連絡票整理番号 = new HashMap<>();
        for (KogakuGassanShikyuFushikyuKettei shikyuKettei : 高額合算支給不支給決定List) {
            if (対象年度_連絡票整理番号.containsKey(shikyuKettei.get対象年度())) {
                対象年度_連絡票整理番号.get(shikyuKettei.get対象年度()).add(shikyuKettei.get支給申請書整理番号());
            } else {
                Set<RString> 連絡票整理番号 = new HashSet<>();
                連絡票整理番号.add(shikyuKettei.get支給申請書整理番号());
                対象年度_連絡票整理番号.put(shikyuKettei.get対象年度(), 連絡票整理番号);
            }
        }
        return 対象年度_連絡票整理番号;
    }

    /**
     * 連絡票整理番号_履歴番号Mapのメソッドです。
     *
     * @param 高額合算支給不支給決定List KogakuGassanShikyuFushikyuKetteiの{@code list}
     * @return Map
     */
    public Map<RString, Set<RString>> put連絡票整理番号_履歴番号(List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List) {
        Map<RString, Set<RString>> 連絡票整理番号_履歴番号 = new HashMap<>();
        for (KogakuGassanShikyuFushikyuKettei shikyuKettei : 高額合算支給不支給決定List) {
            if (連絡票整理番号_履歴番号.containsKey(shikyuKettei.get対象年度().toDateString().
                    concat(shikyuKettei.get支給申請書整理番号()))) {
                連絡票整理番号_履歴番号.get(shikyuKettei.get対象年度().toDateString().
                        concat(shikyuKettei.get支給申請書整理番号())).add(new RString(shikyuKettei.get履歴番号()));
            } else {
                Set<RString> 履歴番号 = new HashSet<>();
                履歴番号.add(new RString(shikyuKettei.get履歴番号()));
                連絡票整理番号_履歴番号.put(shikyuKettei.get対象年度().toDateString()
                        .concat(shikyuKettei.get支給申請書整理番号()), 履歴番号);
            }

        }
        return 連絡票整理番号_履歴番号;
    }

    private void get結果(
            List<KogakuGassanShikyuFushikyuKettei> 高額合算支給不支給決定List,
            List<KogakuGassanShikyuGakuKeisanKekka> 高額合算支給計算結果,
            KogakuGassanShikyuFushikyuKettei shikyuKettei) {
        for (KogakuGassanShikyuGakuKeisanKekka keisanKekka : 高額合算支給計算結果) {
            if ((Kaigogassan_DataKubun.国保連作成.getコード().equals(keisanKekka.getデータ区分())
                    || Kaigogassan_DataKubun.国保連作成_２の返却.getコード().equals(keisanKekka.getデータ区分()))
                    && !(支給額計算結果連絡先郵便番号.equals(keisanKekka.get支給額計算結果連絡先郵便番号()))) {
                高額合算支給不支給決定List.add(shikyuKettei);
                break;
            }
        }
    }

    /**
     * 前排他のンメソッドです。
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
        ExpandedInformation expandedInfo1 = new ExpandedInformation(CODE_003, 拡張情報, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1);
    }

    /**
     * 支払予定日印字有無のセットのンメソッドです。
     *
     * @return RString
     */
    public RString set支払予定日印字有無() {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用キー = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID, 項目名);
        if (帳票制御汎用キー == null) {
            return null;
        }
        return 帳票制御汎用キー.get設定値();
    }

    /**
     * 共同処理用受給者異動連絡票データ作成です。
     *
     * @param entity KogakuGassanShikyuKetteiTsuchishoEntity
     * @param 支払予定日印字有無 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(KogakuGassanShikyuKetteiTsuchishoEntity entity, RString 支払予定日印字有無) {
        if (!RSTRING_0.equals(支払予定日印字有無) && !RSTRING_1.equals(支払予定日印字有無)) {
            return null;
        }
        if (RSTRING_0.equals(支払予定日印字有無)) {
            GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService printService
                    = new GassanKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService();
            return printService.printSingle(entity);
        } else {
            GassanKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService printService
                    = new GassanKetteiTsuchishoShiharaiYoteiBiYijiAriPrintService();
            return printService.printSingle(entity);
        }

    }

    /**
     * 更新完了メッセージ設定です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void set更新完了メッセージ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        div.getCcdKanryoMessage().setMessage(完了メッセージメイン,
                被保険者番号.getColumnValue(),
                div.getKogakuGassanShikyuKetteiTsuchishoSakuseiKihon().get氏名漢字(),
                true);
    }

    /**
     * 入力のチェックです。
     *
     * @param 支払予定日印字有無 RString
     * @return ValidationMessageControlPairs
     */
    public boolean 入力チェック(RString 支払予定日印字有無) {
        RDate 支払予定日 = div.getTxtShiharaiYoteiYMD().getValue();
        return RSTRING_1.equals(支払予定日印字有無) && 支払予定日 == null;
    }

    /**
     * 事業高額合算情報取得です。
     *
     * @param 高額合算支給不支給決定 KogakuGassanShikyuFushikyuKettei
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 支払予定日印字有無 RString
     * @return KogakuGassanShikyuKetteiTsuchishoOutputEntity
     */
    public KogakuGassanShikyuKetteiTsuchishoOutputEntity editKougakugassanShikyuketteiTsuuchisho(
            KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            RString 支払予定日印字有無) {
        KogakuGassanShikyuKetteiTsuchiParameter parameter = new KogakuGassanShikyuKetteiTsuchiParameter();
        ReportId reportId;
        if (RSTRING_0.equals(支払予定日印字有無)) {
            reportId = ReportIdDBC.DBC100053.getReportId();
        } else {
            reportId = ReportIdDBC.DBC100054.getReportId();
        }
        parameter.set口座ID(高額合算支給不支給決定.get口座ID());
        parameter.set対象年度(高額合算支給不支給決定.get対象年度());
        parameter.set履歴番号(高額合算支給不支給決定.get履歴番号());
        parameter.set帳票ID(reportId);
        parameter.set支払予定日(div.getTxtShiharaiYoteiYMD().getValue() != null
                ? new FlexibleDate(div.getTxtShiharaiYoteiYMD().getValue().toDateString()) : FlexibleDate.EMPTY);
        parameter.set文書番号(div.getCcdBunshoNO().get文書番号() != null && !div.getCcdBunshoNO().get文書番号().isEmpty() ? div.getCcdBunshoNO().get文書番号()
                : RString.HALF_SPACE.concat(RString.HALF_SPACE).concat(RString.HALF_SPACE).concat(RString.HALF_SPACE)
                .concat(RString.HALF_SPACE).concat(RString.HALF_SPACE).concat(RString.HALF_SPACE).concat(RString.HALF_SPACE)
                .concat(RString.HALF_SPACE).concat(RString.HALF_SPACE));
        parameter.set発行日(div.getTxtHakkouYMD().getValue() != null
                ? new FlexibleDate(div.getTxtHakkouYMD().getValue().toDateString()) : FlexibleDate.EMPTY);
        parameter.set被保険者番号(被保険者番号);
        parameter.set識別コード(識別コード);
        parameter.set連絡票整理番号(高額合算支給不支給決定.get支給申請書整理番号());
        KogakuGassanShikyuKetteiTsuchishoOutputEntity outputEntity = KougakuGassanShikyuKetteiTsuchi.createInstance()
                .editKougakugassanShikyuketteiTsuuchisho(parameter);
        return outputEntity;
    }

    /**
     * 状態2の設定です。
     *
     */
    public void 状態2() {
        div.getDdlTaishoNendo().setDisabled(true);
        div.getDdlRearakuhyoSeiriNO().setDisabled(true);
        div.getDdlRirekiNO().setDisabled(true);
        div.getTxtHakkouYMD().setDisabled(true);
        div.getTxtShiharaiYoteiYMD().setDisabled(true);
        div.getCcdBunshoNO().setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
    }

    /**
     * 画面変更有無check。
     *
     * @param div DBC1210011PanelDiv
     * @param 前文書番号 前文書番号
     * @return 画面変更有無
     */
    public boolean is画面変更あり(DBC1210011PanelDiv div, RString 前文書番号) {
        return div.getDdlTaishoNendo().getSelectedIndex() != 0
                || div.getDdlRearakuhyoSeiriNO().getSelectedIndex() != 0
                || div.getDdlRirekiNO().getSelectedIndex() != 0
                || !前文書番号.equals(div.getCcdBunshoNO().get文書番号())
                || !RDate.getNowDate().equals(div.getTxtHakkouYMD().getValue())
                || div.getTxtShiharaiYoteiYMD().getValue() != null;
    }
}
