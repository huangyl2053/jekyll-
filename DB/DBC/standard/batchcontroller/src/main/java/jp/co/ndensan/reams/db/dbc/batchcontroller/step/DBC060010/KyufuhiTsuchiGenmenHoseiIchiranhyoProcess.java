/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060010;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufutsuchigenmenhosei.KyufuhiTsuchiGenmenHosei;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kaigojuminhyo.KyufuTsuchiGenmenHoseiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 給付費通知減免補正一覧表のプロセスクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 *
 */
public class KyufuhiTsuchiGenmenHoseiIchiranhyoProcess extends BatchKeyBreakBase<KyufuTsuchiGenmenHoseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufutsuchigenmenhosei.IKyufuTsuchiGenmenHoseiMapper.get給付費通知減免補正一覧");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC060010"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 広域の全市町村_KEY = new RString("000000");
    private KyufuTsuchiGenmenHoseiProcessParameter processParameter;
    private FileSpoolManager manager;
    private boolean is広域保険者 = false;
    private boolean is広域判定 = false;
    private int 取得データ = 0;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private RString 市町村コード = RString.EMPTY;
    private RString 市町村名;
    private RString 地方公共団体コード;
    private RStringBuilder filePath;
    @BatchWriter
    private CsvWriter<KyufuTsuchiGenmenHoseiCsvEntity> eucCsvWriter;
    private BatchReportWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportWriter;
    private ReportSourceWriter<KyufuhiTuchiGenmenhoseiIchiranReportSource> reportSourceWriter;
    private ShutsuryokujunRelateEntity 出力順entity;

    @Override
    protected void initialize() {
        出力順entity = ReportUtil.get出力順情報(KyufuhiTsuchiGenmenHosei.ShutsuryokujunEnum.class,
                SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200043.getReportId(),
                processParameter.get帳票出力順ID());
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        市町村コード = processParameter.get市町村コード();
        地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
        filePath = new RStringBuilder();
        filePath.append("KyufuhiTuchiGenmenhoseiIchiran_");
        filePath.append(市町村コード);
        filePath.append(".csv");
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード().is広域()
                && !processParameter.get市町村コード().equals(広域の全市町村_KEY)) {
            is広域保険者 = true;
        }
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード().is広域()) {
            is広域判定 = true;
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMapperParameter(出力順entity.get出力順OrderBy(), is広域保険者));
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
        if (!出力順entity.getPageBreakKeys().isEmpty()) {
            reportWriter = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBC.DBC200043.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付)
                    .addBreak(new BreakerCatalog<KyufuhiTuchiGenmenhoseiIchiranReportSource>().
                            simplePageBreaker(出力順entity.getPageBreakKeys())).create();
        } else {
            reportWriter = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBC.DBC200043.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付).create();
        }
        reportSourceWriter = new ReportSourceWriter(reportWriter);
    }

    @Override
    protected void keyBreakProcess(KyufuTsuchiGenmenHoseiEntity entity) {
    }

    @Override
    protected void usualProcess(KyufuTsuchiGenmenHoseiEntity entity) {
        get給付費通知減免補正一覧表のCSV出力(entity);
        get給付費通知減免補正一覧表の帳票出力(entity);
        取得データ++;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        reportWriter.close();
        RString 出力ページ数 = new RString("0");
        RString 出力CSV有無 = new RString("なし");
        RString 出力ファイル名 = RString.EMPTY;
        if (0 < 取得データ) {
            出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
            出力CSV有無 = new RString("あり");
            出力ファイル名 = filePath.toRString();
        }
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC200043.getReportId().value(),
                地方公共団体コード,
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC200043.getReportName(),
                出力ページ数,
                出力CSV有無,
                出力ファイル名,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("【サービス年月】"));
        builder.append(processParameter.getサービス開始年月().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        builder.append(new RString("～"));
        builder.append(processParameter.getサービス終了年月().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        出力条件.add(builder.toRString());
        if (is広域保険者) {
            builder = new RStringBuilder();
            builder.append(new RString("【市町村】"));
            builder.append(processParameter.get市町村名称());
            出力条件.add(builder.toRString());
        }
        if (is広域判定 && processParameter.get市町村コード().equals(広域の全市町村_KEY)) {
            builder = new RStringBuilder();
            builder.append(new RString("【市町村】"));
            builder.append(new RString("全て"));
            出力条件.add(builder.toRString());
        }
        return 出力条件;
    }

    private void get給付費通知減免補正一覧表のCSV出力(KyufuTsuchiGenmenHoseiEntity entity) {
        RStringBuilder filePaths = new RStringBuilder();
        if (is広域の全市町村()) {
            if (広域の全市町村_KEY.equals(市町村コード)) {
                市町村コード = 地方公共団体コード;
                eucCsvWriter.close();
                setCreateCSV(filePaths);
            }
        } else if (!市町村コード.equals(entity.getShokisaiHokenshaNo().value())) {
            市町村コード = entity.getShokisaiHokenshaNo().value();
            eucCsvWriter.close();
            setCreateCSV(filePaths);
        }
        eucCsvWriter.writeLine(
                new KyufuTsuchiGenmenHoseiCsvEntity(
                        entity.getHiHokenshaNo().getColumnValue(),
                        entity.getMeisho(),
                        entity.getServiceTeikyoYM().toDateString(),
                        entity.getJigyoshoNo().getColumnValue(),
                        entity.getJigyoshaName(),
                        entity.getServiceShuruiCode().getColumnValue(),
                        entity.getServiceHiyoTotal(),
                        entity.getRiyoshaFutangaku(),
                        entity.getServiceShuruiMeisho())
        );
    }

    private void setCreateCSV(RStringBuilder filePaths) {
        filePaths.append("KyufuhiTuchiGenmenhoseiIchiran_");
        filePaths.append(市町村コード);
        filePaths.append(".csv");
        boolean delFlag = true;
        File tmpfile = new File("KyufuhiTuchiGenmenhoseiIchiran_000000.csv");
        if (tmpfile.exists()) {
            delFlag = tmpfile.delete();
        }
        delFlag = true;
        if (delFlag) {
            setFilePath(filePaths);
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
        KyufuhiTuchiGenmenhoseiIchiranEntity reportEntity = business.get給付費通知減免補正一覧表の帳票情報(entity,
                保険者コード,
                保険者名,
                出力順entity);
        KyufuhiTuchiGenmenhoseiIchiranReport report = new KyufuhiTuchiGenmenhoseiIchiranReport(reportEntity);
        report.writeBy(reportSourceWriter);
    }

    private boolean is広域の全市町村() {
        return 広域の全市町村_KEY.equals(市町村コード);
    }
}
