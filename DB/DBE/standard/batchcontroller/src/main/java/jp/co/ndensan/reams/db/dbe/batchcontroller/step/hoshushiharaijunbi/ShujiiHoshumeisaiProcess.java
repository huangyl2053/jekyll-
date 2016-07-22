/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiihoshumeisai.ShujiiHoshumeisaiEdit;
import jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai.ShujiiHoshumeisaiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi.HoshuShiharaiJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi.IHoshuShiharaiJunbiMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成報酬支払明細書のprocessです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public class ShujiiHoshumeisaiProcess extends BatchKeyBreakBase<HoshuShiharaiJunbiRelateEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE622001.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi."
            + "IHoshuShiharaiJunbiMapper.get主治医意見書作成報酬支払明細書");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ShujiiHoshumeisaiReportSource.ReportSourceFields.iryokikanName.name()),
                            new RString(ShujiiHoshumeisaiReportSource.ReportSourceFields.shujiiCode.name())));
    private HoshuShiharaiJunbiProcessParameter processParameter;
    private static final RString MIDDLELINE = new RString("なし");
    private static final RString なし = new RString("なし");
    private Decimal 合計件数新規在宅 = Decimal.ZERO;
    private Decimal 合計件数新規施設 = Decimal.ZERO;
    private Decimal 合計件数継続在宅 = Decimal.ZERO;
    private Decimal 合計件数継続施設 = Decimal.ZERO;
    private Decimal 合計金額 = Decimal.ZERO;

    @BatchWriter
    private BatchReportWriter<ShujiiHoshumeisaiReportSource> batchWrite;
    private ReportSourceWriter<ShujiiHoshumeisaiReportSource> reportSourceWriter;
    private RString 導入団体コード;
    private RString 市町村名;
    private RString 消費税率;
    private int index_tmp = 0;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
        消費税率 = getMapper(IHoshuShiharaiJunbiMapper.class).get消費税率(processParameter.toHoshuShiharaiJunbiProcessParameter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHoshuShiharaiJunbiProcessParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<ShinseiMonitorReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    @Override
    protected void keyBreakProcess(HoshuShiharaiJunbiRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            AccessLogger.log(AccessLogType.照会, toPersonalData(current));
            ShujiiHoshumeisaiEdit edit = new ShujiiHoshumeisaiEdit();
            ShujiiHoshumeisaiEntity shumeisaiEntity = edit.getShujiiHoshumeisaiEntity(current);
            shumeisaiEntity = editShujiiHoshumeisaiEntity(shumeisaiEntity, current);
            ShujiiHoshumeisaiReport report = new ShujiiHoshumeisaiReport(shumeisaiEntity);
            report.writeBy(reportSourceWriter);
            index_tmp++;
        }
    }

    private boolean hasBrek(HoshuShiharaiJunbiRelateEntity before, HoshuShiharaiJunbiRelateEntity current) {
        return !before.getIryoKikanMeisho().equals(current.getIryoKikanMeisho())
                || !before.getShujiiCode().equals(current.getShujiiCode());
    }

    @Override
    protected void usualProcess(HoshuShiharaiJunbiRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        ShujiiHoshumeisaiEdit edit = new ShujiiHoshumeisaiEdit();
        ShujiiHoshumeisaiEntity shumeisaiEntity = edit.getShujiiHoshumeisaiEntity(entity);
        shumeisaiEntity = editShujiiHoshumeisaiEntity(shumeisaiEntity, entity);
        ShujiiHoshumeisaiReport report = new ShujiiHoshumeisaiReport(shumeisaiEntity);
        report.writeBy(reportSourceWriter);
        index_tmp++;
    }

    private PersonalData toPersonalData(HoshuShiharaiJunbiRelateEntity entity) {
        RString hihokenshaNo = RString.EMPTY;
        if (entity.getHihokenshaNo() != null) {
            hihokenshaNo = entity.getHihokenshaNo();
        }
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                hihokenshaNo);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBE.DBE622002.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 実績期間開始日 = new RStringBuilder();
        実績期間開始日.append(new RString("【実績期間開始日】"));
        実績期間開始日.append(RString.FULL_SPACE);
        実績期間開始日.append(dateFormat(processParameter.getJissekidaterangefrom()));
        RStringBuilder 実績期間終了日 = new RStringBuilder();
        実績期間終了日.append(new RString("【実績期間終了日】"));
        実績期間終了日.append(RString.FULL_SPACE);
        実績期間終了日.append(dateFormat(processParameter.getJissekidaterangeto()));
        出力条件.add(実績期間開始日.toRString());
        出力条件.add(実績期間終了日.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE622001.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString dateFormat(FlexibleDate date) {

        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private RString dateFormat9(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString get対象期間() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(dateFormat9(processParameter.getJissekidaterangefrom()));
        builder.append(new RString("～"));
        builder.append(dateFormat9(processParameter.getJissekidaterangeto()));
        return builder.toRString();
    }

    private ShujiiHoshumeisaiEntity editShujiiHoshumeisaiEntity(ShujiiHoshumeisaiEntity shumeisaiEntity,
            HoshuShiharaiJunbiRelateEntity current) {
        合計件数新規在宅 = 合計件数新規在宅.add(rstringToDecimal(shumeisaiEntity.get新規在宅件数()));
        合計件数新規施設 = 合計件数新規施設.add(rstringToDecimal(shumeisaiEntity.get新規施設件数()));
        合計件数継続在宅 = 合計件数継続在宅.add(rstringToDecimal(shumeisaiEntity.get継続在宅件数()));
        合計件数継続施設 = 合計件数継続施設.add(rstringToDecimal(shumeisaiEntity.get継続施設件数()));
        shumeisaiEntity.set新規在宅件数(decimalToRString(合計件数新規在宅));
        shumeisaiEntity.set新規施設件数(decimalToRString(合計件数新規施設));
        shumeisaiEntity.set継続在宅件数(decimalToRString(合計件数継続在宅));
        shumeisaiEntity.set継続施設件数(decimalToRString(合計件数継続施設));
        合計金額 = 合計金額.add(rstringToDecimal(shumeisaiEntity.get合計金額()));
        shumeisaiEntity.set合計金額(decimalToRString(合計金額));
        Decimal 消費税 = 合計金額.multiply(rstringToDecimal(消費税率)).subtract(合計金額);
        shumeisaiEntity.set対象期間(get対象期間());
        shumeisaiEntity.set明細番号(intToRString(index_tmp));
        shumeisaiEntity.set生年月日(dateFormat9(current.getSeinengappiYMD()));
        shumeisaiEntity.set消費税(decimalToRString(消費税));
        shumeisaiEntity.set合計請求額(decimalToRString(合計金額.add(消費税)));
        return shumeisaiEntity;
    }

    private RString intToRString(int date) {
        return new RString(date);
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private Decimal rstringToDecimal(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return Decimal.ZERO;
        }
        return new Decimal(date.toString());
    }
}
