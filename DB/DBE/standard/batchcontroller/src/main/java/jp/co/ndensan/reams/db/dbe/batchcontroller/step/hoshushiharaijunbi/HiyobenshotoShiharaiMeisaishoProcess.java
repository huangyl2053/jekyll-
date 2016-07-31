/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaiMeisaishoEdit;
import jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaisho;
import jp.co.ndensan.reams.db.dbe.business.report.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi.HoshuShiharaiJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のprocessです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public class HiyobenshotoShiharaiMeisaishoProcess extends BatchProcessBase<HoshuShiharaiJunbiRelateEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE622006.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi."
            + "IHoshuShiharaiJunbiMapper.get費用弁償等明細書");
    private HoshuShiharaiJunbiProcessParameter processParameter;
    private static final RString MIDDLELINE = new RString("なし");
    private static final RString なし = new RString("なし");
    private static int index = 1;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private HiyobenshotoShiharaimeisaisho meisaisho = new HiyobenshotoShiharaimeisaisho();

    @BatchWriter
    private BatchReportWriter<HiyobenshotoShiharaimeisaishoReportSource> batchWrite;
    private ReportSourceWriter<HiyobenshotoShiharaimeisaishoReportSource> reportSourceWriter;
    private RString 導入団体コード;
    private RString 市町村名;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHoshuShiharaiJunbiProcessParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        HiyobenshotoShiharaimeisaishoReport report = new HiyobenshotoShiharaimeisaishoReport(meisaisho);
        report.writeBy(reportSourceWriter);
        バッチ出力条件リストの出力();
    }

    @Override
    protected void process(HoshuShiharaiJunbiRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        HiyobenshotoShiharaiMeisaishoEdit edit = new HiyobenshotoShiharaiMeisaishoEdit();
        meisaisho = edit.getHiyobenshotoShiharaiMeisai(meisaisho, entity, getKoza(entity), index, get対象期間(),
                dateFormat9(processParameter.getFurikomishiteiday()));
        if (index % INDEX_4 == 0) {
            HiyobenshotoShiharaimeisaishoReport report = new HiyobenshotoShiharaimeisaishoReport(meisaisho);
            report.writeBy(reportSourceWriter);
            meisaisho = new HiyobenshotoShiharaimeisaisho();
        }
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

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBE.DBE622006.getReportName();
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
                ReportIdDBE.DBE622006.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
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

    private List<Koza> getKoza(HoshuShiharaiJunbiRelateEntity entity) {
        if (entity.getNinteichosaItakusakiCode() != null && !entity.getNinteichosaItakusakiCode().isEmpty()) {
            return get口座情報(new KamokuCode("003"), entity.getNinteichosaItakusakiCode());
        }
        if (entity.getShujiiIryoKikanCode() != null && !entity.getShujiiIryoKikanCode().isEmpty()) {
            return get口座情報(new KamokuCode("002"), entity.getShujiiIryoKikanCode());
        }
        if (entity.getSonotaKikanCode() != null && !entity.getSonotaKikanCode().isEmpty()) {
            return get口座情報(new KamokuCode("004"), entity.getSonotaKikanCode());
        }
        return null;
    }

    private List<Koza> get口座情報(KamokuCode kamokuCode, RString key) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.setサブ業務コード(SubGyomuCode.DBE認定支援);
        builder.set科目コード(kamokuCode);
        List<RString> 業務固有キー = new ArrayList<>();
        業務固有キー.add(key);
        builder.set業務固有キーリスト(業務固有キー);
        builder.set用途区分(new KozaYotoKubunCodeValue(new RString("1")));
        IKozaSearchKey searchKey = builder.build();
        return KozaManager.createInstance().get口座(searchKey);
    }

    private RString get対象期間() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(dateFormat9(processParameter.getJissekidaterangefrom()));
        builder.append(new RString("～"));
        builder.append(dateFormat9(processParameter.getJissekidaterangeto()).substring(INDEX_5));
        return builder.toRString();
    }
}
