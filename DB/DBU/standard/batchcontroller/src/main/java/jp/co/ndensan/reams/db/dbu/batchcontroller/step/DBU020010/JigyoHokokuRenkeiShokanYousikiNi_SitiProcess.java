/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.IJigyoHokokuRenkeiEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei27EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiFooterEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiHeadEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiShokanYousikiNi_SitiProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private RString myBatisSelsectId;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("JigyoHokokuRenkeiEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private static final RString H1 = new RString("H1");
    private static final RString 国民健康保険団体連合会 = new RString("国民健康保険団体連合会");
    private static final RString 番号_1 = new RString("1");
    private static final RString 番号_2 = new RString("2");
    private static final RString 番号_3 = new RString("3");
    private int 件数_T1;
    private Decimal 給付費_T1 = Decimal.ZERO;
    private int 件数_T2;
    private Decimal 給付費_T2 = Decimal.ZERO;
    private int 件数_T3;
    private Decimal 給付費_T3 = Decimal.ZERO;
    private int 件数_T4;
    private Decimal 給付費_T4 = Decimal.ZERO;
    private int 件数_T5;
    private Decimal 給付費_T5 = Decimal.ZERO;
    private int 件数_T6;
    private Decimal 給付費_T6 = Decimal.ZERO;
    private int 件数_T7;
    private Decimal 給付費_T7 = Decimal.ZERO;
    private int 件数_T8;
    private Decimal 給付費_T8 = Decimal.ZERO;
    private int 件数_T9;
    private Decimal 給付費_T9 = Decimal.ZERO;
    private int 件数_T10;
    private Decimal 給付費_T10 = Decimal.ZERO;
    private int 件数_T11;
    private Decimal 給付費_T11 = Decimal.ZERO;
    private int 件数_T12;
    private Decimal 給付費_T12 = Decimal.ZERO;
    private static final RString 番号 = new RString("保険者番号");
    private static final RString 名称 = new RString("保険者名称");
    private final RDate 基準日 = RDate.getNowDate();
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private static MapperProvider mapperProvider;
    private IJigyoHokokuRenkeiMapper mapper;
    private Map<RString, List<RString>> 保険者番号data;
    private Map<RString, List<RString>> 保険者名称data;

    @Override
    protected void initialize() {
        if (processParameter.is出力_保険給付決定状況償還分_審査年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況償還分審査年月情報の取得");
        }
        if (processParameter.is出力_保険給付決定状況償還分_決定年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get保険給付決定状況償還分決定年月情報の取得");
        }
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        mapper = mapperProvider.create(IJigyoHokokuRenkeiMapper.class);
        保険者番号data = new HashMap<>();
        保険者名称data = new HashMap<>();
        List<RString> 保険者番号List = new ArrayList<>();
        List<RString> 保険者名称List = new ArrayList<>();
        if (processParameter.is旧保険者分()) {
            List<DbT7056GappeiShichosonEntity> 合併市町村data = mapper.get合併市町村の取得(processParameter.toMybatisParamter());
            for (DbT7056GappeiShichosonEntity dbT7056entity : 合併市町村data) {
                保険者番号List.add(get旧保険者番号(dbT7056entity.getKyuHokenshaNo()));
                保険者名称List.add(dbT7056entity.getKyuShichosonMeisho());
            }
        } else if (processParameter.is構成市町村分()) {
            List<DbT7051KoseiShichosonMasterEntity> 構成市町村data = mapper.get構成市町村マスタの取得(processParameter.toMybatisParamter());
            for (DbT7051KoseiShichosonMasterEntity dbT7051entity : 構成市町村data) {
                保険者番号List.add(get証記載保険者番号(dbT7051entity.getShoKisaiHokenshaNo()));
                保険者名称List.add(dbT7051entity.getShichosonMeisho());
            }
        } else {
            保険者番号List.add(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告));
            保険者名称List.add(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBU介護統計報告));
        }
        保険者番号data.put(番号, 保険者番号List);
        保険者名称data.put(名称, 保険者名称List);
        RString spoolWorkPath = processParameter.getSpoolWorkPath();
        RStringBuilder filePath = new RStringBuilder();
        filePath.append("DUJRENF16_");
        filePath.append(processParameter.get過去集計年月());
        filePath.append("_");
        filePath.append(保険者番号data.get(番号).get(0));
        filePath.append(".csv");
        eucFilePath = Path.combinePath(spoolWorkPath, filePath.toRString());
    }

    @BatchWriter
    private EucCsvWriter<IJigyoHokokuRenkeiEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(myBatisSelsectId, processParameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
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
        int i = 0;
        RString 保険者番号bak = RString.EMPTY;
        for (RString 保険者番号 : 保険者番号data.get(番号)) {
            if (!保険者番号bak.equals(保険者番号) && i != 0) {
                RStringBuilder fileName = new RStringBuilder();
                fileName.append("DUJRENF16_");
                fileName.append(processParameter.get過去集計年月());
                fileName.append("_");
                fileName.append(保険者番号);
                fileName.append(".csv");
                setFilePath(fileName);
                保険者番号bak = 保険者番号;
            }
            get様式２の７のCSV出力(保険者番号, 保険者名称data.get(名称).get(i));
            i++;
            eucCsvWriter.close();   
        }
    }

    private void setFilePath(RStringBuilder filePath) {
        eucFilePath = Path.combinePath(processParameter.getSpoolWorkPath(), filePath.toRString());
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).
                build();
            }  

    private void get様式２の７のCSV出力(RString 保険者番号, RString 保険者名称) {
        eucCsvWriter.writeLine(setヘッダレコード(保険者番号, 保険者名称));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T1"), 件数_T1, 給付費_T1));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T2"), 件数_T2, 給付費_T2));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T3"), 件数_T3, 給付費_T3));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T4"), 件数_T4, 給付費_T4));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T5"), 件数_T5, 給付費_T5));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T6"), 件数_T6, 給付費_T6));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T7"), 件数_T7, 給付費_T7));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T8"), 件数_T8, 給付費_T8));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T9"), 件数_T9, 給付費_T9));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T10"), 件数_T10, 給付費_T10));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T11"), 件数_T11, 給付費_T11));
        eucCsvWriter.writeLine(new JigyoHokokuRenkei27EucCsvEntity(RString.EMPTY, new RString("T12"), 件数_T12, 給付費_T12));
        eucCsvWriter.writeLine(set終了レコード());
    }

    private JigyoHokokuRenkeiHeadEucCsvEntity setヘッダレコード(RString 保険者番号, RString 保険者名称) {
        return new JigyoHokokuRenkeiHeadEucCsvEntity(
                RString.EMPTY,
                H1,
                dateFomart(new RString(processParameter.get過去集計年月() + "01")),
                dateFomart(RDate.getNowDate().toDateString()),
                国民健康保険団体連合会,
                保険者番号,
                保険者名称);
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

    private RString dateFomart(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate flexibleDate = new FlexibleDate(年月日);
        return flexibleDate.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString get旧保険者番号(HokenshaNo date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.value();
    }

    private RString get証記載保険者番号(ShoKisaiHokenshaNo date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.value();
    }
}
