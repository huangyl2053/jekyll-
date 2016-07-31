/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai.ChosaHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai.ChosaHoshuShiharaiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbi.HoshuShiharaiJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi.IHoshuShiharaiJunbiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
 * 認定調査報酬支払通知書のprocessです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
public class ChosaHoshuShiharaiProcess extends BatchProcessBase<HoshuShiharaiJunbiRelateEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE621003.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbi."
            + "IHoshuShiharaiJunbiMapper.get認定調査報酬支払通知書");
    private HoshuShiharaiJunbiProcessParameter processParameter;
    private static final RString MIDDLELINE = new RString("なし");
    private static final RString なし = new RString("なし");
    private static final int パターン番号 = 1;
    @BatchWriter
    private BatchReportWriter<ChosaHoshuShiharaiReportSource> batchWrite;
    private ReportSourceWriter<ChosaHoshuShiharaiReportSource> reportSourceWriter;
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
        バッチ出力条件リストの出力();
    }

    @Override
    protected void process(HoshuShiharaiJunbiRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        ChosaHoshuShiharaiEdit edit = new ChosaHoshuShiharaiEdit();
        List<RString> 業務固有キー = new ArrayList<>();
        業務固有キー.add(entity.getNinteichosaItakusakiCode());
        ChosaHoshuShiharaiEntity shiharaiEntity
                = edit.getChosaHoshuShiharaiEntity(entity, 消費税率, get認証者(), get通知文(), get口座情報(new KamokuCode("003"), 業務固有キー));
        shiharaiEntity.set対象期間(get対象期間());
        ChosaHoshuShiharaiReport report = new ChosaHoshuShiharaiReport(shiharaiEntity);
        report.writeBy(reportSourceWriter);
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
        RString 帳票名 = ReportIdDBE.DBE621003.getReportName();
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
                ReportIdDBE.DBE621003.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
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

    /**
     * 口座情報の編集処理です。
     *
     * @param kamokuCode 科目コード
     * @param 業務固有キー 業務固有キー
     * @return ChosaHoshuShiharaiEntity
     */
    public static Koza get口座情報(KamokuCode kamokuCode, List<RString> 業務固有キー) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.setサブ業務コード(SubGyomuCode.DBE認定支援);
        builder.set科目コード(kamokuCode);
        builder.set業務固有キーリスト(業務固有キー);
        builder.set用途区分(new KozaYotoKubunCodeValue(new RString("1")));
        IKozaSearchKey searchKey = builder.build();
        List<Koza> kozaList = KozaManager.createInstance().get口座(searchKey);
        Koza koza = null;
        if (!kozaList.isEmpty()) {
            koza = kozaList.get(0);
        }
        return koza;
    }

    private NinshoshaSource get認証者() {
        return ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                REPORT_ID,
                FlexibleDate.getNowDate(),
                reportSourceWriter);
    }

    /**
     * 通知文の編集処理です。
     *
     * @return 通知文
     */
    public static Map<Integer, RString> get通知文() {
        return ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, パターン番号);
    }

    private RString get対象期間() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(dateFormat9(processParameter.getJissekidaterangefrom()));
        builder.append(new RString("～"));
        builder.append(dateFormat9(processParameter.getJissekidaterangeto()));
        return builder.toRString();
    }
}
