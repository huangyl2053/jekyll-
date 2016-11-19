/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021051;

import jp.co.ndensan.reams.db.dbb.business.core.dbb021051.DBB021051DataUtil;
import jp.co.ndensan.reams.db.dbb.entity.csv.DBB021051ShoriKekkaKakuninListCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051ShoriKekkaListTempEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のプロセスクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class ShoriKekkaListProcess extends BatchProcessBase<DBB021051ShoriKekkaListTempEntity> {

    private final RString eucエンティティID = new RString("DBZ000001");
    private final RString eucファイル名 = new RString("処理結果確認リスト.csv");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString カンマ = new RString(",");

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "dbb021051.IDBB021051Mapper.get処理結果リスト一時");
    private boolean firstFlag;

    private DBB021051DataUtil dataUtil;
    private FileSpoolManager spoolManager;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<DBB021051ShoriKekkaKakuninListCSVEntity> csvWriter;

    @Override
    protected void initialize() {

        firstFlag = true;
        dataUtil = new DBB021051DataUtil();
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                eucエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = spoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, eucファイル名);
        csvWriter = BatchWriters.csvWriter(DBB021051ShoriKekkaKakuninListCSVEntity.class)
                .filePath(eucFilePath)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setDelimiter(カンマ)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DBB021051ShoriKekkaListTempEntity entity) {
        DBB021051ShoriKekkaKakuninListCSVEntity csvEntity = dataUtil.toShoriKekkaKakuninListCSVEntity(entity, firstFlag);
        csvWriter.writeLine(csvEntity);
        firstFlag = false;
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        spoolManager.spool(SubGyomuCode.DBZ介護共通, eucFilePath);
    }

}
