/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE526002;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.jizenshinsakekka.JizenShinsakekkaProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.jizenshinsakekka.JizenShinsaKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakekka.IjizenShinsaKekkaMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 事前審査結果登録データ作成processクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
public class JizenShinsaKekkaProcess extends BatchProcessBase<JizenShinsaKekkaRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakekka.IjizenShinsaKekkaMapper.getJizenShinsaKekka");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE526002"));
    private static final RString ファイル名 = new RString("審査会事前審査結果CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString あり = new RString("あり");
    private static final RString FILE = new RString("JizenShinsaKekka_");
    private static final RString FILENAMEGO = new RString(".csv");
    private static final int 桁_4 = 4;
    private static final int 桁_0 = 0;
    private RString 審査会委員コード = RString.EMPTY;
    private FileSpoolManager manager;
    private RString spoolWorkPath;
    private RString 導入団体コード;
    private RString 市町村名;
    private RString csvFileName;
    private RString eucFilePath;
    private JizenShinsakekkaProcessParameter processParameter;
    private IjizenShinsaKekkaMapper mapper;

    @BatchWriter
    BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> dbT5501Writer;
    @BatchWriter
    private CsvWriter<JizenShinsaKekkaCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, new RString("tmp.csv"));
        mapper = getMapper(IjizenShinsaKekkaMapper.class);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toJizenShinsakekkaMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT5501Writer = new BatchPermanentTableWriter(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(JizenShinsaKekkaRelateEntity entity) {
        get事前審査会用データのCSV出力(entity);
        syoriDbT5501(entity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        バッチ出力条件リストの出力();
    }

    private void get事前審査会用データのCSV出力(JizenShinsaKekkaRelateEntity entity) {
        RStringBuilder filePath = new RStringBuilder();
        if (RString.isNullOrEmpty(審査会委員コード)) {
            eucCsvWriter.close();
            boolean delFlag = true;
            File tmpfile = new File(eucFilePath.toString());
            if (tmpfile.exists()) {
                delFlag = tmpfile.delete();
            }
            delFlag = true;
            if (delFlag) {
                審査会委員コード = entity.getShinsakaiIinCode();
                filePath.append(FILE);
                filePath.append(processParameter.getShinsakaiKaisaiNo());
                filePath.append("_");
                filePath.append(entity.getShinsakaiIinCode());
                filePath.append(FILENAMEGO);
                setFilePath(filePath);
            }
        }

        if (!審査会委員コード.equals(entity.getShinsakaiIinCode())) {
            審査会委員コード = entity.getShinsakaiIinCode();
            eucCsvWriter.close();
            filePath.append(FILE);
            filePath.append(processParameter.getShinsakaiKaisaiNo());
            filePath.append("_");
            filePath.append(entity.getShinsakaiIinCode());
            filePath.append(FILENAMEGO);
            setFilePath(filePath);
        }
        eucCsvWriter.writeLine(
                new JizenShinsaKekkaCsvEntity(
                        entity.getShinsakaiKaisaiNo(),
                        entity.getShinseishoKanriNo().value(),
                        new RString(entity.getShinsakaiOrder()),
                        entity.getShinsakaiIinCode(),
                        entity.getKoroshoIfShikibetsuCode().value(),
                        RString.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY)
        );
    }

    private void setFilePath(RStringBuilder filePath) {
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
        csvFileName = filePath.toRString();
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 出力ページ数 = new RString(eucCsvWriter.getCount());
        List<RString> 出力条件 = new ArrayList<>();
        RString csv出力有無 = あり;
        RStringBuilder 実績期間開始日 = new RStringBuilder();
        実績期間開始日.append(new RString("【審査会開催年度】"));
        実績期間開始日.append(RString.FULL_SPACE);
        実績期間開始日.append(processParameter.getShinsakaiKaisaiNo().substring(桁_0, 桁_4));
        RStringBuilder 実績期間終了日 = new RStringBuilder();
        実績期間終了日.append(new RString("【審査会開催番号】"));
        実績期間終了日.append(RString.FULL_SPACE);
        実績期間終了日.append(processParameter.getShinsakaiKaisaiNo().substring(桁_4));
        出力条件.add(実績期間開始日.toRString());
        出力条件.add(実績期間終了日.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(EUC_ENTITY_ID.toRString(),
                導入団体コード, 市町村名, ジョブ番号, ファイル名,
                出力ページ数, csv出力有無, csvFileName, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private void syoriDbT5501(JizenShinsaKekkaRelateEntity entity) {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity dbt5501 = mapper.getShinsakaiKaisaiYoteiJoho(entity.getShinsakaiKaisaiNo());
        if (null != dbt5501) {
            dbt5501.setMobileDataOutputYMD(FlexibleDate.getNowDate());
            dbT5501Writer.update(dbt5501);
        }
    }

}
