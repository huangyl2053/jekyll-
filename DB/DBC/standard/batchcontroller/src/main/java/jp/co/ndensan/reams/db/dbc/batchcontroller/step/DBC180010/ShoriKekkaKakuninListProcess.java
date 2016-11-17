/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010;

import jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutan.RiyoshaFutanWaritaiHantei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.futanwariaihanteiichiran.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.DbWT1801ShoriKekkaKakuninListEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 処理結果確認リストCSV出力プロセスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class ShoriKekkaKakuninListProcess extends BatchProcessBase<DbWT1801ShoriKekkaKakuninListEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "nenjiriyoshafutanwariaihantei.INenjiRiyoshaFutanwariaiHanteiMapper.get処理結果確認リスト");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900004"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVMEISHO = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private static final RString 被保険者台帳データがありません = new RString("被保険者台帳データがありません。");
    private static final RString 宛名データがありません = new RString("宛名データがありません。");
    private static final RString 対象データがありません = new RString("対象データがありません。");
    private static final RString 年 = new RString("年");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString EMPTY = new RString(" ");
    private static final RString 作成 = new RString("作成");
    private static final RString HALFMONTH = new RString("00");
    private int count = 1;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private CsvWriter<ShoriKekkaKakuninListEntity> eucCsvWriter;

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVMEISHO);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbWT1801ShoriKekkaKakuninListEntity entity) {
        if (count == 1) {
            eucCsvWriter.writeLine(new ShoriKekkaKakuninListEntity(
                    edit処理日(RDateTime.now()),
                    edit処理名(entity),
                    entity.getHihokenshaNo(),
                    editエラー内容(entity),
                    entity.getBiko()
            ));
        } else {
            eucCsvWriter.writeLine(new ShoriKekkaKakuninListEntity(
                    RString.EMPTY,
                    edit処理名(entity),
                    entity.getHihokenshaNo(),
                    editエラー内容(entity),
                    entity.getBiko()
            ));
        }
        count++;

    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
    }

    private RString edit処理名(DbWT1801ShoriKekkaKakuninListEntity entity) {
        if (RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_宛名取得.getコード().equals(entity.getErrorKubun())) {
            return RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_宛名取得.get名称();
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_被保険者台帳取得.getコード().equals(entity.getErrorKubun())) {
            return RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_被保険者台帳取得.get名称();
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_宛名取得.getコード().equals(entity.getErrorKubun())) {
            return RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_宛名取得.get名称();
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_被保険者台帳取得.getコード().equals(entity.getErrorKubun())) {
            return RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_被保険者台帳取得.get名称();
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.負担割合判定一覧作成.getコード().equals(entity.getErrorKubun())) {
            return RiyoshaFutanWaritaiHantei_ErrorKubun.負担割合判定一覧作成.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString editエラー内容(DbWT1801ShoriKekkaKakuninListEntity entity) {
        if (RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_宛名取得.getコード().equals(entity.getErrorKubun())) {
            return 宛名データがありません;
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_被保険者台帳取得.getコード().equals(entity.getErrorKubun())) {
            return 被保険者台帳データがありません;
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_宛名取得.getコード().equals(entity.getErrorKubun())) {
            return 宛名データがありません;
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.総合事業対象者_被保険者台帳取得.getコード().equals(entity.getErrorKubun())) {
            return 被保険者台帳データがありません;
        } else if (RiyoshaFutanWaritaiHantei_ErrorKubun.負担割合判定一覧作成.getコード().equals(entity.getErrorKubun())) {
            return 対象データがありません;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit処理日(RDateTime dateTime) {
        RString wareki = RString.EMPTY;
        if (dateTime != null) {
            wareki = dateTime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK)
                    .getYear().concat(年).concat(dateTime.getDate().wareki().separator(Separator.JAPANESE)
                            .fillType(FillType.BLANK).getMonthDay())
                    .concat(new RString(new Decimal(dateTime.getHour()).toString(HALFMONTH.toString()))).concat(時)
                    .concat(new RString(new Decimal(dateTime.getMinute()).toString(HALFMONTH.toString()))).concat(分)
                    .concat(new RString(new Decimal(dateTime.getSecond()).toString(HALFMONTH.toString()))).concat(秒)
                    .concat(EMPTY).concat(作成);
        }
        return wareki;
    }
}
