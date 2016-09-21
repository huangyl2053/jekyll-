/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.DankaibeHihokensixyaCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibehihokensixya.DankaibeHihokensixyaEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 「帳票CSVの出力」処理クラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class DankaibetsuHihokenshasuReportCSVProcess extends BatchKeyBreakBase<DankaibeHihokensixyaEntity> {

    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;
    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
                    + ".dankaibetsuhihokenshasuichiranhyosakusei.IDankaibetsuHihokenshasuIchiranhyoSakuseiMapper.selectCSV出力対象データ");
    private CsvWriter<DankaibeHihokensixyaCSVEntity> dankaibeHihokensixyaWriter;
    private RString dankaibeHihokensixyaFilePath;
    private FileSpoolManager manager;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB300004");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("ShotokuDankaiBetsuHihokenshasuIchiran.csv");
    private static final RString 市町村分 = new RString("市町村分");

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        dankaibeHihokensixyaFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        dankaibeHihokensixyaWriter = BatchWriters.csvWriter(DankaibeHihokensixyaCSVEntity.class).
                filePath(dankaibeHihokensixyaFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(DankaibeHihokensixyaEntity t) {
    }

    @Override
    protected void usualProcess(DankaibeHihokensixyaEntity entity) {
        DankaibeHihokensixyaCSVEntity output = get帳票のCSVファイル作成(entity);
        dankaibeHihokensixyaWriter.writeLine(output);
    }

    @Override
    protected void afterExecute() {
        dankaibeHihokensixyaWriter.close();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, toMyBatisParameter());
    }

    private DankaibetuHihokensyasuIchiranhyoMyBatisParameter toMyBatisParameter() {
        DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter = new DankaibetuHihokensyasuIchiranhyoMyBatisParameter();
        parameter.set市町村コード(false);
        if (市町村分.equals(processParameter.get広域分市町村分区分())) {
            parameter.set市町村コード(true);
            parameter.set市町村コードList(processParameter.get市町村コード複数());
        }
        return parameter;
    }

    private DankaibeHihokensixyaCSVEntity get帳票のCSVファイル作成(DankaibeHihokensixyaEntity entity) {
        DankaibeHihokensixyaCSVEntity output = new DankaibeHihokensixyaCSVEntity();
        output.set賦課年度(new RString(processParameter.get調定年度().toString()));
        output.set市町村コード(entity.get市町村コード());
        output.set被保険者番号(getColumnValue(entity.get被保険者番号()));
        output.set識別コード(getColumnValue(entity.get識別コード()));
        output.set資格取得日(get年月日Csv(entity.get資格取得日()));
        output.set資格喪失日(get年月日Csv(entity.get資格喪失日()));
        output.set賦課基準日(get年月日Csv(entity.get賦課基準日()));
        output.set保険者設定段階(entity.get保険者設定段階());
        output.set標準設定段階(entity.get標準設定段階());
        output.set合計所得金額(doカンマ編集(entity.get合計所得金額()));
        output.set年金収入額(doカンマ編集(entity.get年金収入額()));
        output.set生保開始日(get年月日Csv(entity.get生保開始日()));
        output.set生保終了日(get年月日Csv(entity.get生保終了日()));
        output.set老年開始日(get年月日Csv(entity.get老年開始日()));
        output.set老年終了日(get年月日Csv(entity.get老年終了日()));
        return output;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    /**
     *
     * 年月日ForCsv(共通ポリシーパターン36（1989/ 1/ 8 ）)を返します。
     *
     * @param flexibleDate 年月日ForCsv
     * @return RString 年月日ForCsv
     */
    public RString get年月日Csv(FlexibleDate flexibleDate) {
        if (null != flexibleDate) {
            return flexibleDate
                    .seireki().separator(Separator.SLASH)
                    .fillType(FillType.BLANK).toDateString();
        } else {
            return null;
        }
    }

}
