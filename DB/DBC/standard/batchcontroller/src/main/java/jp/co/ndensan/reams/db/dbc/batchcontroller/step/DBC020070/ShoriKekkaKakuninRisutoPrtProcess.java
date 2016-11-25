/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc020070.ShoriKekkaKakuninRisutoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 処理結果確認リストcsvファイルの出力処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class ShoriKekkaKakuninRisutoPrtProcess extends BatchProcessBase<DbWT0002KokuhorenTorikomiErrorEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get処理結果確認情報");
    private static final RString CSV_FILE_NAME = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一覧EUCエンティティID = new RString("DBC900004");
    private static final RString 作成 = new RString("作成");

    private CsvWriter<ShoriKekkaKakuninRisutoCsvEntity> csvWriter;
    private FileSpoolManager manager;

    private boolean hasData;

    @Override
    protected void initialize() {
        hasData = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void process(DbWT0002KokuhorenTorikomiErrorEntity entity) {
        ShoriKekkaKakuninRisutoCsvEntity csvEntity = new ShoriKekkaKakuninRisutoCsvEntity();
        if (hasData) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
            csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), CSV_FILE_NAME)).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
            hasData = false;
            YMDHMS currentTime = YMDHMS.now();
            RString 年月日 = currentTime.getRDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 時刻 = currentTime.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            csvEntity.set作成日時(new RString(年月日.concat(時刻.toString()).toString()).concat(RString.HALF_SPACE).concat(作成));
        }
        csvEntity.set処理名(KaigoGassan_ErrorKubun.toValue(entity.getErrorKubun()).getキー1());
        csvEntity.set被保険者番号(entity.getHihokenshaNo().getColumnValue());
        csvEntity.setエラー内容(KaigoGassan_ErrorKubun.toValue(entity.getErrorKubun()).getキー2());
        csvEntity.set備考(entity.getBiko());

        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        if (csvWriter != null) {
            csvWriter.close();
            manager.spool(CSV_FILE_NAME);
        }
    }

}
