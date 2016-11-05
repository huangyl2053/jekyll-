/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010;

import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.IChiJiTBLEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.ShorikekkarisutoichijiTBLEntity;
import jp.co.ndensan.reams.db.dba.entity.euc.atenasealcreate.AtenaSeelEUCEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 処理結果リストCSVの作成。
 */
public class IChiJiTBLProcess extends BatchProcessBase<IChiJiTBLEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate.IAtenaSealCreateMapper.getIChiJiTBLEntity");
    private static final RString TABLE_処理結果リスト一時TBL = new RString("ShorikekkarisutoichijiTBL");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA090010");
    private static final RString FILENAME = new RString("AtenaSealShoriKekkaList.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番 = 1;
    private boolean flg = false;
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    @BatchWriter
    private CsvWriter<AtenaSeelEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
//        eucCsvWriter = BatchWriters.csvWriter(AtenaSeelEUCEntity.class)
//                .filePath(eucFilePath)
//                .setDelimiter(コンマ)
//                .setEnclosure(ダブル引用符)
//                .setEncode(Encode.UTF_8withBOM)
//                .setNewLine(NewLine.CRLF)
//                .hasHeader(true)
//                .build();
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果リスト一時TBL,
                ShorikekkarisutoichijiTBLEntity.class);
    }

    @Override
    protected void process(IChiJiTBLEntity entity) {
        flg = true;
        eucCsvWriter.writeLine(new AtenaSealCreateResult().set処理結果リストCSV(entity, 連番++));
    }

    @Override
    protected void afterExecute() {
        if (!flg) {
            eucCsvWriter.writeLine(new AtenaSealCreateResult().set処理結果リストCSV());
        }
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }
}
