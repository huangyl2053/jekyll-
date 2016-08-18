/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060010;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kaigojuminhyo.KyufuTsuchiGenmenHoseiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
    private KyufuTsuchiGenmenHoseiProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private HokenshaNo 市町村コード = HokenshaNo.EMPTY;
    private List<HokenshaNo> 市町村コードList;
    @BatchWriter
    private CsvWriter<KyufuTsuchiGenmenHoseiCsvEntity> eucCsvWriter;
    private BatchReportWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportWriter;
    private ReportSourceWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        市町村コードList = processParameter.get市町村コードList();
        Collections.sort(市町村コードList, new Comparator<HokenshaNo>() {
            @Override
            public int compare(HokenshaNo entity1, HokenshaNo entity2) {
                return entity1.value().compareTo(entity2.value());
            }
        });
        市町村コード = 市町村コードList.get(0);
        RStringBuilder filePath = new RStringBuilder();
        filePath.append("KyufuhiTuchiGenmenhoseiIchiran_");
        filePath.append(市町村コードList.get(0).value());
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
                hasHeader(true).
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
        if (!市町村コード.equals(entity.getShokisaiHokenshaNo())) {
            eucCsvWriter.close();
            filePath.append("KyufuhiTuchiGenmenhoseiIchiran_");
            filePath.append(entity.getHiHokenshaNo().value());
            filePath.append(".csv");
            setFilePath(filePath);
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

        RString 保険者コード = AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().value();
        RString 保険者名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
        KyufuhiTuchiGenmenhoseiIchiranEntity reportEntity = new KyufuhiTuchiGenmenhoseiIchiranEntity();
        reportEntity.set保険者コード(保険者コード);
        reportEntity.set保険者名(保険者名);
        reportEntity.set出力順1(RString.EMPTY);
        reportEntity.set出力順2(RString.EMPTY);
        reportEntity.set出力順3(RString.EMPTY);
        reportEntity.set出力順4(RString.EMPTY);
        reportEntity.set出力順5(RString.EMPTY);
        reportEntity.set改ページ条件1(RString.EMPTY);
        reportEntity.set改ページ条件2(RString.EMPTY);
        reportEntity.set改ページ条件3(RString.EMPTY);
        reportEntity.set改ページ条件4(RString.EMPTY);
        reportEntity.set改ページ条件5(RString.EMPTY);
        reportEntity.set被保険者番号(entity.getHiHokenshaNo().value());
        reportEntity.set被保険者名(entity.getPsmName());
        reportEntity.set年月(entity.getServiceTeikyoYM().toDateString());
        reportEntity.setサービス事業者コード(entity.getJigyoshoNo().value());
        reportEntity.setサービス事業者(entity.getJigyoshaName());
        reportEntity.setサービス種類コード(entity.getServiceShuruiCode().value());
        reportEntity.setサービス種類(entity.getServiceShuruiMeisho());
        reportEntity.set利用者負担額(entity.getRiyoshaFutangaku());
        reportEntity.setサービス費用(entity.getServiceHiyoTotal());
        KyufuhiTuchiGenmenhoseiIchiranReport report = new KyufuhiTuchiGenmenhoseiIchiranReport(reportEntity);
        report.writeBy(reportSourceWriter);
    }
}
