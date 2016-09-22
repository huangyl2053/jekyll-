/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020060;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kogakujigyoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoOutputOrder;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriReport;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.jigyokogakuketteitsuchishoyijiari.JigyoKogakuKetteiTsuchishoYijiAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.servicehishikyuketteitsuchisho.ServicehiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成の帳票発行
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public class JigyoKogakuKetteiTsuchishoYoteiSakuseiProcess extends BatchProcessBase<KetteiTsuchishoInfoTempResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakusogojigyoservice.IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper.get事業高額決定通知書出力データ");

    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString 支払方法区分_ = new RString("**************");
    private static final RString アスタリスク = new RString("*");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    private KogakuKaigoServiceProcessParameter parameter;
    private JigyoKogakuKetteiTsuchishoReportParameter mybatisParameter;
    ServicehiShikyuKetteiTsuchisho service;

    private IOutputOrder 出力順;
    private List<RString> 改頁リスト;
    private List<RString> 並び順;
    private List<RString> 通知書定型文;
    private Set<RString> 条件set;
    private RString 出力順情報;
    private int 連番;
    private RString 設定値;
    private NinshoshaSource ninshoshaSource2;

    @BatchWriter
    BatchReportWriter<JigyoKogakuKetteiTsuchishoYijiAriSource> batchReportWriter2;
    ReportSourceWriter<JigyoKogakuKetteiTsuchishoYijiAriSource> reportSourceWriter2;

    @Override
    protected void initialize() {

        連番 = INT_1;
        並び順 = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        条件set = new HashSet();
        mybatisParameter = new JigyoKogakuKetteiTsuchishoReportParameter();
        service = ServicehiShikyuKetteiTsuchisho.createInstance();
        設定値 = service.get設定値(帳票分類ID);
        get出力順();
        通知書定型文 = get通知書定型文();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisParameter.set出力順(出力順情報);
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter2 = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100062.getReportId().getColumnValue()).create();
        reportSourceWriter2 = new ReportSourceWriter<>(batchReportWriter2);
        ninshoshaSource2 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter2);

    }

    @Override
    protected void process(KetteiTsuchishoInfoTempResultEntity entity) {

        RString tempStr = entity.getサービス提供年月().toDateString().concat(new RString(entity.get履歴番号()))
                .concat(entity.get被保険者番号().getColumnValue());
        if (!条件set.contains(tempStr)) {
            KogakuKetteiTsuchiShoEntity reportEntity = getReportEntity(entity);
            JigyoKogakuKetteiTsuchishoYijiAriReport report2 = new JigyoKogakuKetteiTsuchishoYijiAriReport(設定値,
                    reportEntity, ninshoshaSource2, parameter.get文書番号(), 通知書定型文);
            report2.writeBy(reportSourceWriter2);
            条件set.add(tempStr);
            連番 = 連番 + INT_1;
        }
    }

    @Override
    protected void afterExecute() {
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        出力順 = finder.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, parameter.get出力順ID());
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

    private List<RString> get通知書定型文() {

        // TODO QA
        List<RString> list = new ArrayList<>();
        return list;
    }

    private KogakuKetteiTsuchiShoEntity getReportEntity(KetteiTsuchishoInfoTempResultEntity entity) {
        KogakuKetteiTsuchiShoEntity reportEntity = new KogakuKetteiTsuchiShoEntity();
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
        // TODO 金融機関
        reportEntity.set金融機関(entity.get金融機関名称());

        reportEntity.set支払場所(entity.get支払場所());
        reportEntity.set決定通知書番号(entity.get決定通知No());
        // TODO 支払期間
        reportEntity.set支払期間開始年月日(entity.get支払期間開始年月日());
        reportEntity.set支払期間終了年月日(entity.get支払期間終了年月日());
        reportEntity.set支払窓口開始時間(entity.get支払窓口開始時間());
        reportEntity.set支払窓口終了時間(entity.get支払窓口終了期間());
        set口座情報(reportEntity);
        return reportEntity;
    }

    private void set口座情報(KogakuKetteiTsuchiShoEntity reportEntity) {
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
}
