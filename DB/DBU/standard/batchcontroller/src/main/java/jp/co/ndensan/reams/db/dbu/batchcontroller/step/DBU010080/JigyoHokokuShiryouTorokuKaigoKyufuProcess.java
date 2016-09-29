/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080;

import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.YoboKyufusuJohoKonkyoCsvEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei.IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper;
import jp.co.ndensan.reams.db.dbu.service.core.hokenkyufushokankettei.HokenkyufuShokanKetteiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告資料登録(介護給付・予防給付用)のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class JigyoHokokuShiryouTorokuKaigoKyufuProcess extends BatchProcessBase<TempDwbTKyufujissekiShukeiKonkyo1Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei."
            + "IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.getKaigoKyufu");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString FILENAME_0101 = new RString("DBU060101.CSV");
    private static final RString FILENAME_0102 = new RString("DBU060102.CSV");
    private static final RString FILENAME_0103 = new RString("DBU060103.CSV");
    private static final RString FILENAME_0104 = new RString("DBU060104.CSV");
    private static final RString FILENAME_0107 = new RString("DBU060107.CSV");
    private static final RString FILENAME_0108 = new RString("DBU060108.CSV");
    private static final RString FILENAME_0109 = new RString("DBU060109.CSV");
    private static final RString FILENAME_0110 = new RString("DBU060110.CSV");
    private static final RString FILENAME_0201 = new RString("DBU060201.CSV");
    private static final RString FILENAME_0202 = new RString("DBU060202.CSV");
    private static final RString FILENAME_0203 = new RString("DBU060203.CSV");
    private static final RString FILENAME_0204 = new RString("DBU060204.CSV");
    private static final RString FILENAME_0301 = new RString("DBU060301.CSV");
    private static final RString FILENAME_0302 = new RString("DBU060302.CSV");
    private static final RString FILENAME_0303 = new RString("DBU060303.CSV");
    private static final RString FILENAME_0304 = new RString("DBU060304.CSV");
    private static final RString FILENAME_0401 = new RString("DBU060401.CSV");
    private static final RString FILENAME_0402 = new RString("DBU060402.CSV");
    private static final RString FILENAME_0403 = new RString("DBU060403.CSV");
    private static final RString FILENAME_0404 = new RString("DBU060404.CSV");
    private static final RString 給付実績集計根拠一時テーブル = new RString("tempDwbTKyufujissekiShukeiKonkyo1");
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter;
    private IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper;
    private HokenkyufuShokanKetteiManager business;
    private RString filePath_0101;
    private RString filePath_0102;
    private RString filePath_0103;
    private RString filePath_0104;
    private RString filePath_0107;
    private RString filePath_0108;
    private RString filePath_0109;
    private RString filePath_0110;
    private RString filePath_0201;
    private RString filePath_0202;
    private RString filePath_0203;
    private RString filePath_0204;
    private RString filePath_0301;
    private RString filePath_0302;
    private RString filePath_0303;
    private RString filePath_0304;
    private RString filePath_0401;
    private RString filePath_0402;
    private RString filePath_0403;
    private RString filePath_0404;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TempDwbTKyufujissekiShukeiKonkyo1Entity> tempEntityWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0101csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0102csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0103csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0104csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0107csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0108csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0109csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0110csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0201csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0202csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0203csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0204csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0301csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0302csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0303csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0304csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0401csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0402csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0403csvWriter;
    @BatchWriter
    private CsvWriter<YoboKyufusuJohoKonkyoCsvEntity> 予防給付数情報根拠_0404csvWriter;

    @Override
    protected void initialize() {
        business = new HokenkyufuShokanKetteiManager();
        tempEntityWriter = new BatchEntityCreatedTempTableWriter(給付実績集計根拠一時テーブル, TempDwbTKyufujissekiShukeiKonkyo1Entity.class);
        filePath_0101 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0101);
        filePath_0102 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0102);
        filePath_0103 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0103);
        filePath_0104 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0104);
        filePath_0107 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0107);
        filePath_0108 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0108);
        filePath_0109 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0109);
        filePath_0110 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0110);
        filePath_0201 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0201);
        filePath_0202 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0202);
        filePath_0203 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0203);
        filePath_0204 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0204);
        filePath_0301 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0301);
        filePath_0302 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0302);
        filePath_0303 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0303);
        filePath_0304 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0304);
        filePath_0401 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0401);
        filePath_0402 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0402);
        filePath_0403 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0403);
        filePath_0404 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0404);
        予防給付数情報根拠_0101csvWriter = new CsvWriter.InstanceBuilder(filePath_0101).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0102csvWriter = new CsvWriter.InstanceBuilder(filePath_0102).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0103csvWriter = new CsvWriter.InstanceBuilder(filePath_0103).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0104csvWriter = new CsvWriter.InstanceBuilder(filePath_0104).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0107csvWriter = new CsvWriter.InstanceBuilder(filePath_0107).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0108csvWriter = new CsvWriter.InstanceBuilder(filePath_0108).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0109csvWriter = new CsvWriter.InstanceBuilder(filePath_0109).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0110csvWriter = new CsvWriter.InstanceBuilder(filePath_0110).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0201csvWriter = new CsvWriter.InstanceBuilder(filePath_0201).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0202csvWriter = new CsvWriter.InstanceBuilder(filePath_0202).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0203csvWriter = new CsvWriter.InstanceBuilder(filePath_0203).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0204csvWriter = new CsvWriter.InstanceBuilder(filePath_0204).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0301csvWriter = new CsvWriter.InstanceBuilder(filePath_0301).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0302csvWriter = new CsvWriter.InstanceBuilder(filePath_0302).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0303csvWriter = new CsvWriter.InstanceBuilder(filePath_0303).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0304csvWriter = new CsvWriter.InstanceBuilder(filePath_0304).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0401csvWriter = new CsvWriter.InstanceBuilder(filePath_0401).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0402csvWriter = new CsvWriter.InstanceBuilder(filePath_0402).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0403csvWriter = new CsvWriter.InstanceBuilder(filePath_0403).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        予防給付数情報根拠_0404csvWriter = new CsvWriter.InstanceBuilder(filePath_0404).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        mapper = getMapper(IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.class);
        mapper.update後_点数();
        mapper.update市町村コードと旧市町村コード();
        mapper.update負担割合区分と負担割合エラーフラグ_一回目();
        mapper.update負担割合区分と負担割合エラーフラグ_二回目();
        // TODO 内部QA:1725 Redmine#101525 テーブル「利用者負担減免マスタ」はデータベースに存在しません。
//        mapper.update利用者負担減免被保険者番号();
        // TODO 内部QA:1781 Redmine# 更新項目の値は複数件可能があります。
//        mapper.update0x02_集計();
//        mapper.update0x03_集計();
//        mapper.update0x04_集計();
        mapper.update0x04再掲_集計1();
        mapper.update0x04再掲_集計2();
        mapper.update0x04再掲_集計3();
        mapper.update0x04再掲_集計4();
        mapper.updateKyufuマイナス対応();
        mapper.delete不要データ();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(TempDwbTKyufujissekiShukeiKonkyo1Entity entity) {
        tempEntityWriter.update(business.update一時テーブルデータ(entity, processParameter.get集計年月()));
        予防給付数情報根拠_0101csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付1総数_件数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0102csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付1総数_単位数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0103csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付1総数_費用額.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0104csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付1総数_給付費.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0107csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_件数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0108csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_単位数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0109csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_費用額.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0110csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_給付費.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0201csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_件数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0202csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_単位数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0203csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_費用額.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0204csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_給付費.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0301csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_件数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0302csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_単位数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0303csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_費用額.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0304csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_給付費.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0401csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_件数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0402csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_単位数.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0403csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_費用額.getコード(), processParameter.get旧市町村区分()));
        予防給付数情報根拠_0404csvWriter.writeLine(business.set予防給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_給付費.getコード(), processParameter.get旧市町村区分()));
    }

    @Override
    protected void afterExecute() {
        予防給付数情報根拠_0101csvWriter.close();
        予防給付数情報根拠_0102csvWriter.close();
        予防給付数情報根拠_0103csvWriter.close();
        予防給付数情報根拠_0104csvWriter.close();
        予防給付数情報根拠_0107csvWriter.close();
        予防給付数情報根拠_0108csvWriter.close();
        予防給付数情報根拠_0109csvWriter.close();
        予防給付数情報根拠_0110csvWriter.close();
        予防給付数情報根拠_0201csvWriter.close();
        予防給付数情報根拠_0202csvWriter.close();
        予防給付数情報根拠_0203csvWriter.close();
        予防給付数情報根拠_0204csvWriter.close();
        予防給付数情報根拠_0301csvWriter.close();
        予防給付数情報根拠_0302csvWriter.close();
        予防給付数情報根拠_0303csvWriter.close();
        予防給付数情報根拠_0304csvWriter.close();
        予防給付数情報根拠_0401csvWriter.close();
        予防給付数情報根拠_0402csvWriter.close();
        予防給付数情報根拠_0403csvWriter.close();
        予防給付数情報根拠_0404csvWriter.close();
    }
}
