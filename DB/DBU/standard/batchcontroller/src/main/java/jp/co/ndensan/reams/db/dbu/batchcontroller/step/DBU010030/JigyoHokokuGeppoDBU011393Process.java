/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.business.core.ippangenbutsu.KyufuJissekiKonkyoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.IKyufuJissekiKonkyoDBU011200EUCEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoRelateEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業報告月報_一般現物のProcessクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
public class JigyoHokokuGeppoDBU011393Process extends BatchProcessBase<KyufuJissekiKonkyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getResultKyufuJisseki");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBU011393");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private KyufuJissekiKonkyoBusiness business;
    @BatchWriter
    private CsvWriter<IKyufuJissekiKonkyoDBU011200EUCEntity> eucCsvWriter;

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
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBU011393.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IKyufuJissekiKonkyoDBU011200EUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(KyufuJissekiKonkyoRelateEntity entity) {
        eucCsvWriter.writeLine(business.set事業報告統計データ(entity, processParameter.get給付実績区分コード()));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }
}
