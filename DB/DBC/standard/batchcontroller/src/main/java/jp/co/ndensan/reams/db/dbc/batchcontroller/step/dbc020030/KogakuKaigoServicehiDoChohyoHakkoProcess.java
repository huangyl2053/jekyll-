/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport;
import jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KogakuKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;
    ServicehiShikyuKetteiTsuchisho service;

    private List<RString> 改頁リスト;
    private List<RString> 並び順;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private Association 導入団体情報;
//    private Ninshosha 認証者;
    private RString 出力順情報;
    private Set<RString> 条件set;
    private List<RString> 通知書定型文;
    private List<RString> タイトルlist;
    private int 連番;
    private RString 設定値;
    private NinshoshaSource ninshoshaSource2;
    private NinshoshaSource ninshoshaSource3;
    private NinshoshaSource ninshoshaSource4;

    @BatchWriter
    BatchReportWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> batchReportWriter2;
    ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> reportSourceWriter2;
    @BatchWriter
    BatchReportWriter<KogakuKetteiTsuchiShoSealerSource> batchReportWriter3;
    ReportSourceWriter<KogakuKetteiTsuchiShoSealerSource> reportSourceWriter3;
    @BatchWriter
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
        設定値 = service.get設定値(帳票分類ID);
        通知書定型文 = get通知書定型文();
        get出力順();
        帳票制御共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ID);
        導入団体情報 = AssociationFinderFactory.createInstance().getAssociation();
//        認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(
//                GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
    }

    @Override
    protected BatchDbReader createReader() {
        mybatisParameter.set出力順(出力順情報);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter2 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100008.getReportId().getColumnValue()).create();
        reportSourceWriter2 = new ReportSourceWriter<>(batchReportWriter2);
        batchReportWriter3 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100009.getReportId().getColumnValue()).create();
        reportSourceWriter3 = new ReportSourceWriter<>(batchReportWriter3);
        batchReportWriter4 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100010.getReportId().getColumnValue()).create();
        reportSourceWriter4 = new ReportSourceWriter<>(batchReportWriter4);
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
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport report2
                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriReport(reportEntity, 連番, 設定値, 通知書定型文, ninshoshaSource2);
            report2.writeBy(reportSourceWriter2);

            KogakuKetteiTsuchiShoEntity reportEntity3 = getShoSealerReportEntity(entity);
            KogakuKetteiTsuchiShoSealerReport report3 = new KogakuKetteiTsuchiShoSealerReport(reportEntity3, parameter.get文書番号(),
                    通知書定型文, getインフォ(), ninshoshaSource3, タイトルlist);
            report3.writeBy(reportSourceWriter3);
            KogakuKetteiTsuchiShoEntity reportEntity4 = getShoSealer2ReportEntity(entity);
            KogakuKetteiTsuchiShoSealer2Report report4
                    = new KogakuKetteiTsuchiShoSealer2Report(設定値, reportEntity4, ninshoshaSource4, parameter.get文書番号());
            report4.writeBy(reportSourceWriter4);
            条件set.add(tempStr);
            連番 = 連番 + INT_1;
        }
    }

    @Override
    protected void afterExecute() {
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

    private RString do住所編集(KetteiTsuchishoInfoTempResultEntity entity) {
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名());
        RString 住所 = JushoHenshu.editJusho(帳票制御共通情報, 宛名情報, 導入団体情報);
        return RString.EMPTY;
    }

    private void do口座マスク編集() {
        // TODO QA
    }

    private List<RString> get通知書定型文() {
        // TODO QA
        List<RString> list = new ArrayList<>();
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
            reportEntity.set被保険者氏名(entity.get宛名().getKanjiShimei().value());
        }
        reportEntity.set被保険者番号(entity.get被保険者番号());
        reportEntity.set決定年月日(toRDate(entity.get決定年月日()));
        reportEntity.set支払予定日(parameter.get振込予定日());
        reportEntity.set受付年月日(toRDate(entity.get受付年月日()));
        reportEntity.set本人支払額(entity.get本人支払額());
        reportEntity.set対象年月(entity.getサービス提供年月());
        // TODO QA 一時表に「サービス種類」が存在しない
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
        if (null != 改頁リスト && 改頁リスト.size() >= INT_1) {
            reportEntity.set持ちもの(改頁リスト.get(INT_0));
        }
        // 金融機関
        reportEntity.set金融機関(entity.get金融機関名称());

        reportEntity.set支払場所(entity.get支払場所());
        reportEntity.set決定通知書番号(entity.get決定通知No());
        // 支払期間
        reportEntity.set支払期間開始年月日(toRDate(entity.get支払期間開始年月日()));
        reportEntity.set支払期間終了年月日(toRDate(entity.get支払期間終了年月日()));
        reportEntity.set支払窓口開始時間(entity.get支払窓口開始時間());
        reportEntity.set支払窓口終了時間(entity.get支払窓口終了期間());
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
        // TODO QA 一時表に「サービス種類」が存在しない
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
        // 支払期間
        reportEntity.set支払期間開始年月日(entity.get支払期間開始年月日());
        reportEntity.set支払期間終了年月日(entity.get支払期間終了年月日());
        reportEntity.set支払窓口開始時間(entity.get支払窓口開始時間());
        reportEntity.set支払窓口終了時間(entity.get支払窓口終了期間());
        return reportEntity;
    }

    private KogakuKetteiTsuchiShoEntity getShoSealerReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
        reportEntity.set提供年月IDX1(entity.getサービス提供年月());
        reportEntity.set提供年月IDX2(entity.getサービス提供年月());
        reportEntity.set提供年月IDX3(entity.getサービス提供年月());
        reportEntity.set提供年月IDX4(entity.getサービス提供年月());
        reportEntity.set支給額IDX1(entity.get支払金額());
        reportEntity.set支給額IDX2(entity.get支払金額());
        reportEntity.set支給額IDX3(entity.get支払金額());
        reportEntity.set支給額IDX4(entity.get支払金額());

        // TODO QA審査方法区分と決定額が設定しない
        reportEntity.set審査方法区分(entity.get審査方法区分());
        reportEntity.set決定額IDX1(entity.get高額支給額());
        reportEntity.set決定額IDX2(entity.get高額支給額());
        reportEntity.set決定額IDX3(entity.get高額支給額());
        reportEntity.set決定額IDX4(entity.get高額支給額());
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
            reportEntity.set被保険者氏名(entity.get宛名().getKanjiShimei().value());
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
        // TODO ゆうちょ銀行
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
        // TODO ゆうちょ銀行
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
        // TODO ゆうちょ銀行
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
}
