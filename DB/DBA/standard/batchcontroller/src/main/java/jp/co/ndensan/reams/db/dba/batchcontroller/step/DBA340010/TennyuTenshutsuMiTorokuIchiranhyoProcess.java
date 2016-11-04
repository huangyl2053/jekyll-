package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA340010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoResult;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba340010.TennyuTensyutsuMiTorokuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuHosyutaiSyosyaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 転入転出未登録一覧表のProcessクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoProcess extends BatchKeyBreakBase<TennyuHosyutaiSyosyaEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ORDER_BY = new RString("order by ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity");
    private static final RString FILENAME = new RString("ShikakuIdoMishorishaIchiranhyo_");
    private static final RString FILENAMEGO = new RString(".csv");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsumitorokuichiranhyo."
            + "ITennyuTenshutsuMiTorokuIchiranhyoMapper.get転入保留対象者");
    TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private FileSpoolManager manager;
    private RString eucFilePath;
    List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItemList;
    private TennyuTensyutsuMiTorokuIchiranhyoProcessParameter processParamter;
    @BatchWriter
    private BatchReportWriter<TennyuTenshutsuMitorokuIchiranhyoReportSource> batchWriter;
    private ReportSourceWriter<TennyuTenshutsuMitorokuIchiranhyoReportSource> reportSourceWriter;
    private EucCsvWriter<TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
        出力順Entity = get出力順項目();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        editHeader();
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順OrderBy = 出力順Entity.get出力順OrderBy();
        if (!RString.isNullOrEmpty(出力順OrderBy)) {
            出力順OrderBy = 出力順OrderBy.replace(ORDER_BY, EUC_WRITER_DELIMITER);
        }
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toTennyuTensyutsuMiTorokuIchiranhyoMybatisParameter(出力順OrderBy));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200014.getReportId().value())
                    .addBreak(new BreakerCatalog<TennyuTenshutsuMitorokuIchiranhyoReportSource>().simplePageBreaker(pageBreakKeys))
                    .create();
        } else {
            batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200014.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(TennyuHosyutaiSyosyaEntity current) {
    }

    @Override
    protected void usualProcess(TennyuHosyutaiSyosyaEntity entity) {
        TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity = new TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity();
        TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem = new TennyuTenshutsuMiTorokuIchiranhyoBodyItem();
        new TennyuTenshutsuMiTorokuIchiranhyoResult().setNyuBodyItem(entity, csvEntity, bodyItem);
        TennyuTenshutsuMiTorokuIchiranhyoReport report = TennyuTenshutsuMiTorokuIchiranhyoReport.createFrom(headItem, bodyItem);
        report.writeBy(reportSourceWriter);
        if (processParamter.getShichosoncode().size() > 1) {
            setFilePath(RString.EMPTY, manager.getEucOutputDirectry());
            eucCsvWriter.writeLine(csvEntity);
        } else {
            set市町村コードCsv(manager.getEucOutputDirectry(), csvEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (eucCsvWriter != null) {
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        }
    }

    private void set市町村コードCsv(RString spoolWorkPath, TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity) {
        RString shichosonCode = csvEntity.getShichosonCode();
        setFilePath(shichosonCode, spoolWorkPath);
        eucCsvWriter.writeLine(csvEntity);
    }

    private void setFilePath(RString shichosonCode, RString spoolWorkPath) {
        RStringBuilder filePath = new RStringBuilder();
        if (processParamter.getShichosoncode().size() > 1) {
            filePath.append(FILENAME).append(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード()).append(FILENAMEGO);
        } else {
            filePath.append(FILENAME).append(shichosonCode).append(FILENAMEGO);
        }
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    private void editHeader() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        headItem = new TennyuTenshutsuMiTorokuIchiranhyoHeadItem(association.getLasdecCode_().getColumnValue(), association.get市町村名(),
                出力順Entity.get出力順1(), 出力順Entity.get出力順2(), 出力順Entity.get出力順3(),
                出力順Entity.get出力順4(), 出力順Entity.get出力順5(), 出力順Entity.get改頁項目1(), 出力順Entity.get改頁項目2(),
                出力順Entity.get改頁項目3(), 出力順Entity.get改頁項目4(), 出力順Entity.get改頁項目5());
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(TennyuTenshutsuMiTorokuIchiranhyoResult.ShutsuryokujunEnum.class,
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA200014.getReportId(),
                processParamter.getCyohyosyutsuryokujyun());
    }
}
