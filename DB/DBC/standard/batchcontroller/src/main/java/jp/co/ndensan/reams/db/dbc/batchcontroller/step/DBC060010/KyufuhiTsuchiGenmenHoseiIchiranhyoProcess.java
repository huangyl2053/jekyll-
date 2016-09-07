/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060010;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufutsuchigenmenhosei.KyufuhiTsuchiGenmenHosei;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kaigojuminhyo.KyufuTsuchiGenmenHoseiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 給付費通知減免補正一覧表のプロセスクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 *
 */
public class KyufuhiTsuchiGenmenHoseiIchiranhyoProcess extends BatchProcessBase<KyufuTsuchiGenmenHoseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufutsuchigenmenhosei.IKyufuTsuchiGenmenHoseiMapper.get給付費通知減免補正一覧");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC060010"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 広域の全市町村_KEY = new RString("000000");
    private KyufuTsuchiGenmenHoseiProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private RString 市町村コード = RString.EMPTY;
    private List<RString> 市町村コードList;
    private RString 地方公共団体コード;
    @BatchWriter
    private CsvWriter<KyufuTsuchiGenmenHoseiCsvEntity> eucCsvWriter;
    private BatchReportWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportWriter;
    private ReportSourceWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        市町村コードList = processParameter.get市町村コードList();
        Collections.sort(市町村コードList, new Comparator<RString>() {
            @Override
            public int compare(RString entity1, RString entity2) {
                return entity1.compareTo(entity2);
            }
        });
        市町村コード = 市町村コードList.get(0);
        地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        RStringBuilder filePath = new RStringBuilder();
        filePath.append("KyufuhiTuchiGenmenhoseiIchiran_");
        filePath.append(市町村コードList.get(0));
        filePath.append(".csv");
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMapperParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200043.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(reportWriter);
    }

    @Override
    protected void process(KyufuTsuchiGenmenHoseiEntity entity) {
        get給付費通知減免補正一覧表のCSV出力(entity);
        get給付費通知減免補正一覧表の帳票出力(entity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        reportWriter.close();
    }

    private void get給付費通知減免補正一覧表のCSV出力(KyufuTsuchiGenmenHoseiEntity entity) {
        RStringBuilder filePath = new RStringBuilder();
        if (is広域の全市町村()) {
            if (広域の全市町村_KEY.equals(市町村コード)) {
                市町村コード = 地方公共団体コード;
                eucCsvWriter.close();
                setCreateCSV(filePath);
            }
        } else if (!市町村コード.equals(entity.getShokisaiHokenshaNo().value())) {
            市町村コード = entity.getShokisaiHokenshaNo().value();
            eucCsvWriter.close();
            setCreateCSV(filePath);
        }
        eucCsvWriter.writeLine(
                new KyufuTsuchiGenmenHoseiCsvEntity(
                        entity.getHiHokenshaNo().getColumnValue(),
                        entity.getPsmName(),
                        entity.getServiceTeikyoYM().toDateString(),
                        entity.getJigyoshoNo().getColumnValue(),
                        entity.getJigyoshaName(),
                        entity.getServiceShuruiCode().getColumnValue(),
                        entity.getServiceHiyoTotal(),
                        entity.getRiyoshaFutangaku(),
                        entity.getServiceShuruiMeisho())
        );
    }

    private void setCreateCSV(RStringBuilder filePath) {
        filePath.append("KyufuhiTuchiGenmenhoseiIchiran_");
        filePath.append(市町村コード);
        filePath.append(".csv");
        boolean delFlag = true;
        File tmpfile = new File("KyufuhiTuchiGenmenhoseiIchiran_000000.csv");
        if (tmpfile.exists()) {
            delFlag = tmpfile.delete();
        }
        delFlag = true;
        if (delFlag) {
            setFilePath(filePath);
        }
    }

    private void setFilePath(RStringBuilder filePath) {
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    private void get給付費通知減免補正一覧表の帳票出力(KyufuTsuchiGenmenHoseiEntity entity) {
        KyufuhiTsuchiGenmenHosei business = new KyufuhiTsuchiGenmenHosei();
        RString 保険者コード = AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().value();
        RString 保険者名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
        KyufuhiTuchiGenmenhoseiIchiranEntity reportEntity = business.get給付費通知減免補正一覧表の帳票情報(entity, 保険者コード, 保険者名);
        KyufuhiTuchiGenmenhoseiIchiranReport report = new KyufuhiTuchiGenmenhoseiIchiranReport(reportEntity);
        report.writeBy(reportSourceWriter);
    }

    private boolean is広域の全市町村() {
        if (広域の全市町村_KEY.equals(市町村コードList.get(0))) {
            return true;
        } else {
            return false;
        }
    }
}
