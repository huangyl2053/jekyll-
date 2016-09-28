/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.business.core.ippangenbutsu.JigyoHokokuIppanGenbutsuBusiness;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.IKyufuJissekiKonkyoEUCEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.KyufuJissekiKonkyoRelateEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告月報_一般現物のProcessクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
public class JigyoHokokuGeppoDBU031200Process extends BatchProcessBase<KyufuJissekiKonkyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getKyufuJissekiKonkyo");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private RString eucFilePath;
    private JigyoHokokuIppanGenbutsuBusiness business;
    @BatchWriter
    private CsvWriter<IKyufuJissekiKonkyoEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        business = new JigyoHokokuIppanGenbutsuBusiness(processParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSelectDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        eucFilePath = Path.combinePath(processParameter.getCsvFilePath(), new RString("DBU031200.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IKyufuJissekiKonkyoEUCEntity.class)
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
        eucCsvWriter.writeLine(business.set事業報告統計データ(entity, processParameter.get給付集計区分(), processParameter.get集計番号()));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
    }
}
