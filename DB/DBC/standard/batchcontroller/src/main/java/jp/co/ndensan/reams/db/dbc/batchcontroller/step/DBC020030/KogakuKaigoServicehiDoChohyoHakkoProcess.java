/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020030;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KogakuKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費支給（不支給）決定通知書作成の帳票発行Process
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class KogakuKaigoServicehiDoChohyoHakkoProcess extends BatchProcessBase<KetteiTsuchishoInfoTempResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservice.IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper.get高額サービス帳票出力データ");
    private static final ReportId 帳票分類ID = new ReportId("DBC100007_KogakuKetteiTsuchiSho");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString アスタリスク = new RString("*");
    private static final RString 支払方法区分_ = new RString("**************");
    private static final RString 取り消し線_項目名 = new RString("取り消し線");
    private static final RString 帳票タイトル_項目名 = new RString("帳票タイトル");
    private static final RString 調整用_項目名 = new RString("帳票タイトル_調整用");
    private static final RString 取り消し線無し = new RString("0");
    private static final RString 高額介護 = new RString("高額介護（予防）サービス費");
    private static final RString 支給区分_1 = new RString("1");
    private static final RString 支給区分_支給 = new RString("支給");
    private static final RString 支給区分_不支給 = new RString("不支給");
    private static final RString 決定通知書_NAME = new RString("決定通知書");
    private static final RString 決定通知書_調整用_NAME = new RString("決定通知書　調整用");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;
    ServicehiShikyuKetteiTsuchisho service;

    private List<RString> 改頁リスト;
    private List<RString> 並び順;
    private RString 出力順情報;
    private Set<RString> 条件set;
    private List<RString> 通知書定型文;
    private List<RString> タイトルlist;
    private List<RString> インフォ;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private int 連番;
    private RString 設定値1;
    private RString 設定値2;
    private RString 設定値3;
    private NinshoshaSource ninshoshaSource1;
    private NinshoshaSource ninshoshaSource2;
    private NinshoshaSource ninshoshaSource3;
    private NinshoshaSource ninshoshaSource4;

    BatchReportWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> batchReportWriter1;
    ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> reportSourceWriter1;
    BatchReportWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> batchReportWriter2;
    ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> reportSourceWriter2;
    BatchReportWriter<KogakuKetteiTsuchiShoSealerSource> batchReportWriter3;
    ReportSourceWriter<KogakuKetteiTsuchiShoSealerSource> reportSourceWriter3;
    BatchReportWriter<KogakuKetteiTsuchiShoSealer2Source> batchReportWriter4;
    ReportSourceWriter<KogakuKetteiTsuchiShoSealer2Source> reportSourceWriter4;

    @Override
    protected void initialize() {

        連番 = INT_1;
        並び順 = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        条件set = new HashSet();
        mybatisParameter = new JigyoKogakuKetteiTsuchishoReportParameter();
        service = ServicehiShikyuKetteiTsuchisho.createInstance();
        タイトルlist = service.getタイトル(帳票分類ID);
        設定値1 = service.get設定値(帳票分類ID, 取り消し線_項目名);
        設定値2 = service.get設定値(帳票分類ID, 帳票タイトル_項目名);
        設定値3 = service.get設定値(帳票分類ID, 調整用_項目名);
        通知書定型文 = get通知書定型文();
        インフォ = getインフォ();
        get出力順();
        do口座マスク編集();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
    }

    @Override
    protected BatchDbReader createReader() {
        mybatisParameter.set出力順(出力順情報);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter1 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100007_支給.getReportId().getColumnValue()).create();
        reportSourceWriter1 = new ReportSourceWriter<>(batchReportWriter1);
        batchReportWriter2 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100008.getReportId().getColumnValue()).create();
        reportSourceWriter2 = new ReportSourceWriter<>(batchReportWriter2);
        batchReportWriter3 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100009.getReportId().getColumnValue()).create();
        reportSourceWriter3 = new ReportSourceWriter<>(batchReportWriter3);
        batchReportWriter4 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100010.getReportId().getColumnValue()).create();
        reportSourceWriter4 = new ReportSourceWriter<>(batchReportWriter4);
        ninshoshaSource1 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID,
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter1);
        ninshoshaSource2 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID,
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter2);
        ninshoshaSource3 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID,
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter3);
        ninshoshaSource4 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID,
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter4);
    }

    @Override
    protected void process(KetteiTsuchishoInfoTempResultEntity entity) {

        RString tempStr = entity.getサービス提供年月().toDateString().concat(new RString(entity.get履歴番号()))
                .concat(entity.get被保険者番号().getColumnValue());
        if (!条件set.contains(tempStr)) {

            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity = getReportEntity(entity);
//            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaReport report1
//                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaReport(reportEntity, 連番, getタイトル(entity), 通知書定型文, ninshoshaSource1, 帳票制御共通情報);
//            report1.writeBy(reportSourceWriter1);
//
//            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport report2
//                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiReport(reportEntity, 連番, getタイトル(entity), 通知書定型文, ninshoshaSource2, 帳票制御共通情報);
//            report2.writeBy(reportSourceWriter2);

            KogakuKetteiTsuchiShoEntity reportEntity3 = getShoSealerReportEntity(entity);
            KogakuKetteiTsuchiShoSealerReport report3 = new KogakuKetteiTsuchiShoSealerReport(reportEntity3, parameter.get文書番号(),
                    通知書定型文, インフォ, ninshoshaSource3, タイトルlist, 連番);
            report3.writeBy(reportSourceWriter3);
            KogakuKetteiTsuchiShoEntity reportEntity4 = getShoSealer2ReportEntity(entity);
            KogakuKetteiTsuchiShoSealer2Report report4
                    = new KogakuKetteiTsuchiShoSealer2Report(getタイトル(entity), reportEntity4, ninshoshaSource4, parameter.get文書番号(), 連番);
            report4.writeBy(reportSourceWriter4);
            条件set.add(tempStr);
            連番 = 連番 + INT_1;
        }
    }

    @Override
    protected void afterExecute() {
        batchReportWriter1.close();
        batchReportWriter2.close();
        batchReportWriter3.close();
        batchReportWriter4.close();
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder 出力順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, parameter.get出力順ID());
        if (出力順 != null) {
            出力順情報 = MyBatisOrderByClauseCreator.create(JigyoKogakuKetteiTsuchishoOutputOrder.class, 出力順);
            for (ISetSortItem item : 出力順.get設定項目リスト()) {
                並び順.add(item.getDB項目名());
                if (item.is改頁項目()) {
                    改頁リスト.add(item.get項目名());
                }
            }
        } else {
            出力順情報 = RString.EMPTY;
        }
    }

    private void do口座マスク編集() {
        // TODO QA1560
    }

    private List<RString> get通知書定型文() {
        // TODO QA1560
        List<RString> list = new ArrayList<>();
        list.add(RString.EMPTY);
        return list;
    }

    private KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity getReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity();
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set文書番号(parameter.get文書番号());
        if (entity.get宛名() != null && entity.get宛名().getKanjiShimei() != null) {
            reportEntity.set被保険者氏名(RString.EMPTY);
        }
        reportEntity.set被保険者番号(entity.get被保険者番号());
        reportEntity.set決定年月日(toRDate(entity.get決定年月日()));
        reportEntity.set支払予定日(parameter.get振込予定日());
        reportEntity.set受付年月日(toRDate(entity.get受付年月日()));
        reportEntity.set本人支払額(entity.get本人支払額());
        reportEntity.set対象年月(entity.getサービス提供年月());
        // TODO QA1560 一時表に「サービス種類」が存在しない
        reportEntity.set給付の種類(RString.EMPTY);

        reportEntity.set支給_不支給決定区分(entity.get支給結果());
        reportEntity.set決定額(entity.get高額支給額());
        reportEntity.set支給金額(entity.get支払金額());
        reportEntity.set支給_不支給区分(entity.get支給区分コード());
        reportEntity.set支払方法区分(entity.get支払方法区分コード());
        reportEntity.set不支給理由(entity.get不支給理由());
        if (entity.get支払方法区分コード() != null) {
            ShiharaiHohoKubun 支払方法 = ShiharaiHohoKubun.toValue(entity.get支払方法区分コード());
            if (ShiharaiHohoKubun.窓口払.getコード().equals(entity.get支払方法区分コード())) {
                reportEntity.set窓口払(支払方法.get名称());
                reportEntity.set口座払(支払方法区分_);
            } else if (ShiharaiHohoKubun.口座払.getコード().equals(entity.get支払方法区分コード())) {
                reportEntity.set窓口払(支払方法区分_);
                reportEntity.set口座払(支払方法.get名称());
            }
        } else {
            reportEntity.set窓口払(RString.EMPTY);
            reportEntity.set口座払(RString.EMPTY);
        }
        if (null != 改頁リスト && INT_1 <= 改頁リスト.size()) {
            reportEntity.set持ちもの(改頁リスト.get(INT_0));
        }
        // TODO QA1560 金融機関?
        reportEntity.set金融機関(entity.get金融機関名称());

        reportEntity.set支払場所(entity.get支払場所());
        reportEntity.set決定通知書番号(entity.get決定通知No());
        // TODO QA1560 支払期間
        reportEntity.set支払期間開始年月日(toRDate(entity.get支払期間開始年月日()));
        reportEntity.set支払期間終了年月日(toRDate(entity.get支払期間終了年月日()));
        set口座情報_3(reportEntity);
        return reportEntity;
    }

    private KogakuKetteiTsuchiShoEntity getShoSealer2ReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        if (entity.get証記載保険者番号() != null) {
            reportEntity.set証記載保険者番号(new ShoKisaiHokenshaNo(entity.get証記載保険者番号().getColumnValue()));
        }
        reportEntity.set本人支払額(entity.get本人支払額());
        reportEntity.set対象年月(entity.getサービス提供年月());
        // TODO QA1560 一時表に「サービス種類」が存在しない
        reportEntity.set給付の種類(RString.EMPTY);

        reportEntity.set支給結果(entity.get支給結果());
        reportEntity.set支給不支給決定区分(entity.get支給結果());
        reportEntity.set決定額(entity.get高額支給額());
        reportEntity.set支給金額(entity.get支払金額());
        reportEntity.set支給不支給区分(entity.get支給区分コード());
        reportEntity.set不支給理由(entity.get不支給理由());
        if (entity.get支払方法区分コード() != null) {
            ShiharaiHohoKubun 支払方法 = ShiharaiHohoKubun.toValue(entity.get支払方法区分コード());
            if (ShiharaiHohoKubun.窓口払.getコード().equals(entity.get支払方法区分コード())) {
                reportEntity.set窓口払(支払方法.get名称());
                reportEntity.set口座払(支払方法区分_);
            } else if (ShiharaiHohoKubun.口座払.getコード().equals(entity.get支払方法区分コード())) {
                reportEntity.set窓口払(支払方法区分_);
                reportEntity.set口座払(支払方法.get名称());
            }
        } else {
            reportEntity.set窓口払(RString.EMPTY);
            reportEntity.set口座払(RString.EMPTY);
        }
        if (null != 改頁リスト && 改頁リスト.size() >= INT_1) {
            reportEntity.set持ちもの(改頁リスト.get(INT_0));
        }
        reportEntity.set支払場所(entity.get支払場所());

        setKogakuKetteiTsuchiShoEntity(reportEntity, entity);
        set口座情報_2(reportEntity);
        reportEntity.set決定通知書番号(entity.get決定通知No());
        reportEntity.set自動償還対象フラグ(entity.is自動償還対象フラグ());
        // TODO QA1560 支払期間
        reportEntity.set支払期間開始年月日(entity.get支払期間開始年月日());
        reportEntity.set支払期間終了年月日(entity.get支払期間終了年月日());
        return reportEntity;
    }

    private KogakuKetteiTsuchiShoEntity getShoSealerReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        // TODO QA1560 審査方法区分と決定額が設定しない
        reportEntity.set審査方法区分(entity.get審査方法区分());
        setKogakuKetteiTsuchiShoEntity(reportEntity, entity);
        set口座情報_1(reportEntity);
        return reportEntity;
    }

    private void setKogakuKetteiTsuchiShoEntity(KogakuKetteiTsuchiShoEntity reportEntity, KetteiTsuchishoInfoTempResultEntity entity) {
        reportEntity.set連番(連番);
        reportEntity.set識別コード(entity.get識別コード());
        if (フラグ_TRUE.equals(parameter.getテスト出力フラグ())) {
            reportEntity.setテスト出力フラグ(true);
        } else {
            reportEntity.setテスト出力フラグ(false);
        }
        reportEntity.set文書番号(parameter.get文書番号());
        if (entity.get宛名() != null && entity.get宛名().getKanjiShimei() != null) {
            reportEntity.set被保険者氏名(RString.EMPTY);
        }
        reportEntity.set被保険者番号(entity.get被保険者番号());
        reportEntity.set決定年月日(entity.get決定年月日());
        if (parameter.get振込予定日() != null) {
            reportEntity.set支払予定日(new FlexibleDate(parameter.get振込予定日().toDateString()));
        }
        reportEntity.set受付年月日(entity.get受付年月日());
        reportEntity.set支払方法区分(entity.get支払方法区分コード());
    }

    private void set口座情報_3(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity reportEntity) {
        // TODO QA1560 ゆうちょ銀行
        reportEntity.setゆうちょ銀行フラグ(true);
        boolean flag = true;
        if (フラグ_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) {
            if (flag) {
                reportEntity.set金融機関上段(RString.EMPTY);
                reportEntity.set金融機関下段(RString.EMPTY);
                reportEntity.set口座種別(RString.EMPTY);
                reportEntity.set口座番号(RString.EMPTY);
            } else {
                reportEntity.set金融機関上段(RString.EMPTY);
                reportEntity.set金融機関下段(RString.EMPTY);
                reportEntity.set通帳記号(RString.EMPTY);
                reportEntity.set通帳番号(RString.EMPTY);
            }
            reportEntity.set口座名義人(RString.EMPTY);
        } else if (フラグ_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ())) {
            if (flag) {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set口座種別(アスタリスク);
                reportEntity.set口座番号(アスタリスク);
            } else {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set通帳記号(アスタリスク);
                reportEntity.set通帳番号(アスタリスク);
            }
            reportEntity.set口座名義人(アスタリスク);
        }
    }

    private void set口座情報_1(KogakuKetteiTsuchiShoEntity reportEntity) {
        // TODO QA1560 ゆうちょ銀行
        reportEntity.setゆうちょ銀行フラグ(true);
        boolean flag = true;
        if (フラグ_TRUE.equals(parameter.get利用者向け決定通知書フラグ())) {
            if (flag) {
                reportEntity.set金融機関上段(RString.EMPTY);
                reportEntity.set金融機関下段(RString.EMPTY);
                reportEntity.set口座種別(RString.EMPTY);
                reportEntity.set口座番号(RString.EMPTY);
            } else {
                reportEntity.set金融機関上段(RString.EMPTY);
                reportEntity.set金融機関下段(RString.EMPTY);
                reportEntity.set通帳記号(RString.EMPTY);
                reportEntity.set通帳番号(RString.EMPTY);
            }
            reportEntity.set口座名義人(RString.EMPTY);
        } else if (フラグ_TRUE.equals(parameter.get受領委任者向け決定通知書フラグ())) {
            if (flag) {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set口座種別(アスタリスク);
                reportEntity.set口座番号(アスタリスク);
            } else {
                reportEntity.set金融機関上段(アスタリスク);
                reportEntity.set金融機関下段(アスタリスク);
                reportEntity.set通帳記号(アスタリスク);
                reportEntity.set通帳番号(アスタリスク);
            }
            reportEntity.set口座名義人(アスタリスク);
        }
    }

    private void set口座情報_2(KogakuKetteiTsuchiShoEntity reportEntity) {
        // TODO QA1560 ゆうちょ銀行
        reportEntity.setゆうちょ銀行フラグ(true);
        boolean flag = true;
        if (flag) {
            reportEntity.set金融機関上段(RString.EMPTY);
            reportEntity.set金融機関下段(RString.EMPTY);
            reportEntity.set口座種別(RString.EMPTY);
            reportEntity.set口座番号(RString.EMPTY);
        } else {
            reportEntity.set金融機関上段(RString.EMPTY);
            reportEntity.set金融機関下段(RString.EMPTY);
            reportEntity.set通帳記号(RString.EMPTY);
            reportEntity.set通帳番号(RString.EMPTY);
        }
        reportEntity.set口座名義人(RString.EMPTY);
    }

    private List<RString> getインフォ() {
        List<RString> list = new ArrayList<>();
        RString インフォ1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, INT_1, INT_2, FlexibleDate.getNowDate());
        list.add(インフォ1);
        return list;
    }

    private RDate toRDate(FlexibleDate date) {
        if (date == null) {
            return null;
        }
        return new RDate(date.toString());
    }

    private List<RString> getタイトル(KetteiTsuchishoInfoTempResultEntity entity) {
        List<RString> list = new ArrayList<>();
        if (取り消し線無し.equals(設定値1)) {
            if (Decimal.ZERO.compareTo(entity.get支払金額()) <= 0) {
                list.add(設定値2);
            } else {
                list.add(設定値3);
            }
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
        } else if (Decimal.ZERO.compareTo(entity.get支払金額()) <= 0) {
            list.add(RString.EMPTY);
            list.add(高額介護);
            if (支給区分_1.equals(entity.get支給区分コード())) {
                list.add(支給区分_支給);
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
                list.add(支給区分_不支給);
            } else {
                list.add(RString.EMPTY);
                list.add(支給区分_支給);
                list.add(支給区分_不支給);
                list.add(RString.EMPTY);
            }
            list.add(決定通知書_NAME);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
        } else {
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(RString.EMPTY);
            list.add(高額介護);
            if (支給区分_1.equals(entity.get支給区分コード())) {
                list.add(支給区分_支給);
                list.add(RString.EMPTY);
                list.add(RString.EMPTY);
                list.add(支給区分_不支給);
            } else {
                list.add(RString.EMPTY);
                list.add(支給区分_支給);
                list.add(支給区分_不支給);
                list.add(RString.EMPTY);
            }
            list.add(決定通知書_調整用_NAME);
        }
        return list;
    }
}
