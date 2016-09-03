/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020;

import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.SyotaiJohoSyoriProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.SyotaiJohoCsvEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper;
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
 * 世帯情報処理のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class SyotaiJohoSyoriProcess extends BatchProcessBase<SyotaiJohoCsvEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence."
            + "db.mapper.relate.jigyohokokugeppoippan.IJigyoHokokuGeppoIppanMapper.getShotaiJohoKonkyoCSV");
//    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBU010100"));
    private static final RString ファイル名 = new RString("DBU010100.CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private SyotaiJohoSyoriProcessParameter processParameter;
    private IJigyoHokokuGeppoIppanMapper mapper;
//    private FileSpoolManager manager;
//    private RString filename;

    @BatchWriter
    private CsvWriter<SyotaiJohoCsvEntity> csvWriterSyotaiJoho;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanMapper.class);
//        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
//        filename = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        RString filename = Path.combinePath(processParameter.get出力ファイルPATH(), ファイル名);
        csvWriterSyotaiJoho = new CsvWriter.InstanceBuilder(filename).
                setEncode(Encode.UTF_8withBOM)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void beforeExecute() {
        mapper.exeShotaiDataInsert(processParameter.toSyotaiJohoSyoriMybatisParameter());
    }

    @Override
    protected void process(SyotaiJohoCsvEntity entity) {
        if (ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード().equals(entity.get集計番号())) {
            csvWriterSyotaiJoho.writeLine(entity);
        }
    }

//    @Override
//    protected void afterExecute() {
//        manager.spool(filename);
//    }
}
