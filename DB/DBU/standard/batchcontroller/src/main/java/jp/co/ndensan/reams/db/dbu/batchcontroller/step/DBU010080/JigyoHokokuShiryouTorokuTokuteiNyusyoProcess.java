/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080;

import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo2Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei.IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper;
import jp.co.ndensan.reams.db.dbu.service.core.hokenkyufushokankettei.HokenkyufuShokanKetteiManager;
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
 * 事業報告資料登録(特定入所者介護用)のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class JigyoHokokuShiryouTorokuTokuteiNyusyoProcess extends BatchProcessBase<TempDwbTKyufujissekiShukeiKonkyo2Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei."
            + "IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.getTokuteiNyusyo");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 二号被保険者 = new RString("2号");
    private static final RString FILENAME_0105 = new RString("DBU060105.CSV");
    private static final RString FILENAME_0106 = new RString("DBU060106.CSV");
    private static final RString FILENAME_0205 = new RString("DBU060205.CSV");
    private static final RString FILENAME_0206 = new RString("DBU060206.CSV");
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter;
    private IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper;
    private HokenkyufuShokanKetteiManager business;
    private RString filePath_0105;
    private RString filePath_0106;
    private RString filePath_0205;
    private RString filePath_0206;
    @BatchWriter
    private CsvWriter<TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity> 特定入所者保険給付数情報根拠_0105csvWriter;
    @BatchWriter
    private CsvWriter<TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity> 特定入所者保険給付数情報根拠_0106csvWriter;
    @BatchWriter
    private CsvWriter<TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity> 特定入所者保険給付数情報根拠_0205csvWriter;
    @BatchWriter
    private CsvWriter<TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity> 特定入所者保険給付数情報根拠_0206csvWriter;

    @Override
    protected void initialize() {
        business = new HokenkyufuShokanKetteiManager();
        filePath_0105 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0105);
        filePath_0106 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0106);
        filePath_0205 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0205);
        filePath_0206 = Path.combinePath(processParameter.getCsvFilePath(), FILENAME_0206);
        特定入所者保険給付数情報根拠_0105csvWriter = new CsvWriter.InstanceBuilder(filePath_0105).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        特定入所者保険給付数情報根拠_0106csvWriter = new CsvWriter.InstanceBuilder(filePath_0106).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        特定入所者保険給付数情報根拠_0205csvWriter = new CsvWriter.InstanceBuilder(filePath_0205).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        特定入所者保険給付数情報根拠_0206csvWriter = new CsvWriter.InstanceBuilder(filePath_0206).setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build();
        mapper = getMapper(IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.class);
        mapper.updateTokuteiマイナス対応();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        特定入所者保険給付数情報根拠_0105csvWriter.writeLine(business.set特定入所者保険給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_件数.getコード(), processParameter.get旧市町村区分()));
        特定入所者保険給付数情報根拠_0106csvWriter.writeLine(business.set特定入所者保険給付数情報根拠CSVData(entity,
                ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_給付費.getコード(), processParameter.get旧市町村区分()));
        if (二号被保険者.equals(entity.getShikakuKubun())) {
            特定入所者保険給付数情報根拠_0205csvWriter.writeLine(business.set特定入所者保険給付数情報根拠CSVData(entity,
                    ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_件数.getコード(), processParameter.get旧市町村区分()));
            特定入所者保険給付数情報根拠_0206csvWriter.writeLine(business.set特定入所者保険給付数情報根拠CSVData(entity,
                    ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_給付費.getコード(), processParameter.get旧市町村区分()));
        }
    }

    @Override
    protected void afterExecute() {
        特定入所者保険給付数情報根拠_0105csvWriter.close();
        特定入所者保険給付数情報根拠_0106csvWriter.close();
        特定入所者保険給付数情報根拠_0205csvWriter.close();
        特定入所者保険給付数情報根拠_0206csvWriter.close();
        business.追加事業報告統計データ(processParameter, mapper);
        mapper.updateShoriDateKanri(processParameter.create処理日付管理マスタへ登録MybitisParamter());
    }
}
