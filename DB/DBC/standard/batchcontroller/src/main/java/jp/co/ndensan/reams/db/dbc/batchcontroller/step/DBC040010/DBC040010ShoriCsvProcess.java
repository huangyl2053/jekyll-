/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.DBC040010ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc040010.DBC040010ShoriKekkaCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010ShoriKekkaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のプロセス クラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC040010ShoriCsvProcess extends BatchProcessBase<DBC040010ShoriKekkaTempEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040010."
            + "IKogakuGassanJikofutangakuKeisanMapper.get処理結果");
    private static final RString EUCエンティティID = new RString("DBC900004");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUCファイル名 = new RString("処理結果リスト.csv");
    private FileSpoolManager spoolManager;
    private RString eucFilePath;
    private DBC040010DataUtil util;
    private DBC040010ProcessParameter parameter;
    private boolean isFirstEntity;
    @BatchWriter
    private CsvWriter<DBC040010ShoriKekkaCSVEntity> csvWriter;

    @Override
    protected void initialize() {
        isFirstEntity = true;
        util = new DBC040010DataUtil();
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(), EUCファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(DBC040010ShoriKekkaTempEntity entity) {
        if (isFirstEntity) {
            csvWriter.writeLine(util.toDBC040010ShoriKekkaCSVEntity(entity, true, false, parameter));
            csvWriter.writeLine(util.toDBC040010ShoriKekkaCSVEntity(entity, false, true, parameter));
            isFirstEntity = false;
            return;
        }
        csvWriter.writeLine(util.toDBC040010ShoriKekkaCSVEntity(entity, false, false, parameter));
    }

    @Override
    protected void afterExecute() {
        if (isFirstEntity) {
            return;
        }
        csvWriter.close();
        spoolManager.spool(eucFilePath);
    }

}
