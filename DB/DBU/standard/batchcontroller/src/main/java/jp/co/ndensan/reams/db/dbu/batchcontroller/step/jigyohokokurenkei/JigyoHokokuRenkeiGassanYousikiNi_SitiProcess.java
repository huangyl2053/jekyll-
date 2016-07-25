/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.IJigyoHokokuRenkeiEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei2_7EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiFooterEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiHeadEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiGassanYousikiNi_SitiProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private RString myBatisSelsectId;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("JigyoHokokuRenkeiEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString H1 = new RString("H1");
    private static final RString 国民健康保険団体連合会 = new RString("国民健康保険団体連合会");
    private static final RString 番号_1 = new RString("1");
    private static final RString 番号_2 = new RString("2");
    private static final RString 番号_3 = new RString("3");
    private int 件数_T1;
    private Decimal 給付費_T1;
    private int 件数_T2;
    private Decimal 給付費_T2;
    private int 件数_T3;
    private Decimal 給付費_T3;
    private int 件数_T4;
    private Decimal 給付費_T4;
    private int 件数_T5;
    private Decimal 給付費_T5;
    private int 件数_T6;
    private Decimal 給付費_T6;
    private int 件数_T7;
    private Decimal 給付費_T7;
    private int 件数_T8;
    private Decimal 給付費_T8;
    private int 件数_T9;
    private Decimal 給付費_T9;
    private int 件数_T10;
    private Decimal 給付費_T10;
    private int 件数_T11;
    private Decimal 給付費_T11;
    private int 件数_T12;
    private Decimal 給付費_T12;
    private RString csvFileName;
    private RDate 基準日;
    private JigyoHokokuRenkeiProcessParameter processParameter;

    @Override
    protected void initialize() {
        if (processParameter.is出力_保険給付決定状況合算_審査年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況合算分審査年月情報の取得");
        }
        if (processParameter.is出力_保険給付決定状況合算_決定年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況合算分決定年月情報の取得");
        }
        csvFileName = new RString("DUJRENF14_" + processParameter.get過去集計年月()
                + "_" + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援));
    }

    @BatchWriter
    private EucCsvWriter<IJigyoHokokuRenkeiEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(myBatisSelsectId, processParameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, csvFileName);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).
                build();
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２の７のデータ編集(entity);
        get様式２の７のデータ編集2(entity);
        get様式２の７のデータ編集3(entity);
    }

    @Override
    protected void afterExecute() {
        get様式２の７のCSV出力();
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void get様式２の７のCSV出力() {
        eucCsvWriter.writeLine(setヘッダレコード());
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T1"), 件数_T1, 給付費_T1));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T2"), 件数_T2, 給付費_T2));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T3"), 件数_T3, 給付費_T3));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T4"), 件数_T4, 給付費_T4));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T5"), 件数_T5, 給付費_T5));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T6"), 件数_T6, 給付費_T6));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T7"), 件数_T7, 給付費_T7));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T8"), 件数_T8, 給付費_T8));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T9"), 件数_T9, 給付費_T9));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T10"), 件数_T10, 給付費_T10));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T11"), 件数_T11, 給付費_T11));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei2_7EucCsvEntity(RString.EMPTY, new RString("T12"), 件数_T12, 給付費_T12));
        eucCsvWriter.writeLine(set終了レコード());
    }

    private JigyoHokokuRenkeiHeadEucCsvEntity setヘッダレコード() {
        return new JigyoHokokuRenkeiHeadEucCsvEntity(
                RString.EMPTY,
                H1,
                new RString(processParameter.get過去集計年月() + "01"),
                RDate.getNowDate().toDateString(),
                国民健康保険団体連合会,
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援),
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBE認定支援)
        );
    }

    private JigyoHokokuRenkeiFooterEucCsvEntity set終了レコード() {
        return new JigyoHokokuRenkeiFooterEucCsvEntity(
                RString.EMPTY,
                new RString("E")
        );
    }

    private void get様式２の７のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        if (new RString("0701").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T1 = 件数_T1 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T1 = 給付費_T1.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0702").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T2 = 件数_T2 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T2 = 給付費_T2.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0703").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T3 = 件数_T3 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T3 = 給付費_T3.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0704").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T4 = 件数_T4 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T4 = 給付費_T4.add(entity.getShukeiKekkaAtai());
            }
        }
    }

    private void get様式２の７のデータ編集2(DbT7021JigyoHokokuTokeiDataEntity entity) {
        if (new RString("0705").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T5 = 件数_T5 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T5 = 給付費_T5.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0706").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T6 = 件数_T6 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T6 = 給付費_T6.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0707").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T7 = 件数_T7 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T7 = 給付費_T7.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0801").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T8 = 件数_T8 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T8 = 給付費_T8.add(entity.getShukeiKekkaAtai());
            }
        }
    }

    private void get様式２の７のデータ編集3(DbT7021JigyoHokokuTokeiDataEntity entity) {
        if (new RString("0802").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T9 = 件数_T9 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T9 = 給付費_T9.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0803").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T10 = 件数_T10 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T10 = 給付費_T10.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0804").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T11 = 件数_T11 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T11 = 給付費_T11.add(entity.getShukeiKekkaAtai());
            }
        }
        if (new RString("0805").equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                件数_T12 = 件数_T12 + 1;
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                給付費_T12 = 給付費_T12.add(entity.getShukeiKekkaAtai());
            }
        }
    }
}
