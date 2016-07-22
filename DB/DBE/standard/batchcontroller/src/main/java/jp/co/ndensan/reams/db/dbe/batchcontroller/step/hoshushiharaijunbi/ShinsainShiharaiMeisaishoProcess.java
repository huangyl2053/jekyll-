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
import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaiMeisaishoEdit;
import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi.HoshuShiharaiJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;
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
 * 介護認定審査会委員報酬支払明細書のprocessです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public class ShinsainShiharaiMeisaishoProcess extends BatchKeyBreakBase<HoshuShiharaiJunbiRelateEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE622003.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi."
            + "IHoshuShiharaiJunbiMapper.get介護認定審査会委員報酬支払明細書");
    private HoshuShiharaiJunbiProcessParameter processParameter;
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ShinsainShiharaimeisaishoReportSource.ReportSourceFields.shinsakaiIinCode.name())));
    private static final RString MIDDLELINE = new RString("なし");
    private static final RString なし = new RString("なし");
    private RString shinsakaiIinCode = RString.EMPTY;

    @BatchWriter
    private BatchReportWriter<ShinsainShiharaimeisaishoReportSource> batchWrite;
    private ReportSourceWriter<ShinsainShiharaimeisaishoReportSource> reportSourceWriter;
    private int index = 1;
    private Decimal 合計金額;
    private RString 導入団体コード;
    private RString 市町村名;
    private RString 消費税率;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
        消費税率 = getMapper(IHoshuShiharaiJunbiMapper.class).get消費税率(processParameter.toHoshuShiharaiJunbiProcessParameter());
    }

    @Override
    protected void keyBreakProcess(HoshuShiharaiJunbiRelateEntity entity) {
    }

    @Override
    protected void usualProcess(HoshuShiharaiJunbiRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        ShinsainShiharaiMeisaishoEdit edit = new ShinsainShiharaiMeisaishoEdit();
        ShinsainShiharaimeisaisho shinsainshi = edit.getShinsainShiharaimeisaishoEntity(entity);
        shinsainshi = getShinsainShiharaimeisaisho(shinsainshi, entity);
        ShinsainShiharaimeisaishoReport report = new ShinsainShiharaimeisaishoReport(shinsainshi);
        report.writeBy(reportSourceWriter);
        ++index;
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

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHoshuShiharaiJunbiProcessParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<ShinsainShiharaimeisaishoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBE.DBE622003.getReportName();
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
                ReportIdDBE.DBE622003.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
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

    private Decimal rstringToDecimal(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return Decimal.ZERO;
        }
        return new Decimal(date.toString());
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private ShinsainShiharaimeisaisho getShinsainShiharaimeisaisho(ShinsainShiharaimeisaisho shinsainshi, HoshuShiharaiJunbiRelateEntity entity) {
        if (!shinsakaiIinCode.equals(entity.getShinsakaiIinCode())) {
            合計金額 = Decimal.ZERO;
            shinsakaiIinCode = entity.getShinsakaiIinCode();
        }
        shinsainshi.set対象期間(get対象期間());
        shinsainshi.set明細番号(new RString(index));
        合計金額 = 合計金額.add(rstringToDecimal(shinsainshi.get報酬合計()));
        Decimal 消費税 = (合計金額.multiply(rstringToDecimal(消費税率))).subtract(合計金額);
        shinsainshi.set合計金額(decimalToRString(合計金額));
        shinsainshi.set消費税(decimalToRString(消費税));
        shinsainshi.set合計請求額(decimalToRString(合計金額.add(消費税)));
        return shinsainshi;
    }
}
