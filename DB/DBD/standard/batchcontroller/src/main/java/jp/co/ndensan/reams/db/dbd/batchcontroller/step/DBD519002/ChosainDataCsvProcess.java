/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd519002.RenekeiDataSakuseiFourMasterCsvManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519002.RenekeiDataSakuseiFourMasterProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainDataCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainDataReamsCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IEucFileOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 認定調査員情報CSV_ファイル出力です。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
public class ChosainDataCsvProcess extends BatchProcessBase<ChosainEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "renekeidatasakuseifourmaster.IRenekeiDataSakuseiFourMasterMapper.get認定調査員情報ＩＦのcsv情報");
    private static final EucEntityId CSV_ENTITY_ID = new EucEntityId(new RString("DBD519002"));
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ファイル名_日本語 = new RString("認定調査員情報CSV");
    private static final RString EUCエンティティID = new RString("DBD519022");
    private static final RString 出力件数_状況フラグ = new RString("【状況フラグ】TRUE");
    private static final RString 出力件数_今回処理日時開始日時 = new RString("【今回処理日時開始日時】");
    private static final RString 出力件数_今回処理日時終了日時 = new RString("【今回処理日時終了日時】");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private static final Code ログコード = new Code("0001");
    private Association association;
    private FileSpoolManager fileSpoolmanager;
    private RString csvFilePath;
    private RenekeiDataSakuseiFourMasterProcessParameter para;
    private int シーケンシャル番号;
    private CsvWriter<ChosainDataReamsCsvProcessEntity> csvReamsWriter;
    private CsvWriter<ChosainDataCsvProcessEntity> csvWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        シーケンシャル番号 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, para.toRenekeiDataSakuseiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        fileSpoolmanager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.EucOther,
                CSV_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        csvFilePath = Path.combinePath(fileSpoolmanager.getEucOutputDirectry(), para.getCsvfilename());
        if (para.isReams()) {
            csvReamsWriter = csvWriterBuild();
        } else {
            csvWriter = csvWriterBuild();
        }
    }

    private CsvWriter csvWriterBuild() {
        return new CsvWriter.InstanceBuilder(csvFilePath)
                .setEncode(Encode.SJIS)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEnclosure(CSV_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(ChosainEntity entity) {
        シーケンシャル番号++;
        RenekeiDataSakuseiFourMasterCsvManager manager = new RenekeiDataSakuseiFourMasterCsvManager();
        if (para.isReams()) {
            csvReamsWriter.writeLine(manager.toChosainDataReamsCsvProcessEntity(entity, シーケンシャル番号, para.getShikibetsucode()));
        } else {
            csvWriter.writeLine(manager.toChosainDataCsvProcessEntity(entity, シーケンシャル番号, para.getShikibetsucode()));
        }
    }

    @Override
    protected void afterExecute() {
        if (para.isReams()) {
            csvReamsWriter.close();
        } else {
            csvWriter.close();
        }
        バッチ出力条件リストの出力();
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(ログコード, 申請書管理番号, 申請書管理番号));
        AccessLogger.log(AccessLogType.照会, personalData);
        fileSpoolmanager.spool(SubGyomuCode.DBD介護受給, csvFilePath);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 出力件数 = new RString(シーケンシャル番号);
        RString 今回処理日時開始日時 = para.getKonkaishoriymdtime_from().getDate().wareki().toDateString();
        RString 今回処理日時終了日時 = para.getKonkaishoriymdtime_to().getDate().wareki().toDateString();
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(出力件数_状況フラグ);
        出力条件.add(出力件数_今回処理日時開始日時.concat(今回処理日時開始日時));
        出力条件.add(出力件数_今回処理日時終了日時.concat(今回処理日時終了日時));

        EucFileOutputJokenhyoItem eucOutputJokenhyoItem = new EucFileOutputJokenhyoItem(
                ファイル名_日本語,
                導入団体コード,
                市町村名,
                ジョブ番号,
                para.getCsvfilename(),
                EUCエンティティID,
                出力件数,
                出力条件);
        IEucFileOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(eucOutputJokenhyoItem);
        printer.print();
    }
}
