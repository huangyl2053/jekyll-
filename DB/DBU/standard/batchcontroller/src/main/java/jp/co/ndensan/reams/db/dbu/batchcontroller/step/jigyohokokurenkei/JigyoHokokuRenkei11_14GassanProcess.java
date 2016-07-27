/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokurenkei.JigyoHokokuRenkei11or14Entity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.IJigyoHokokuRenkeiEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei11or14Record1EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei11or14Record2or3EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei11or14Record4EucCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 様式別連携情報作成のバッチ処理・一般状況（１１）～（１４）合算分_審査年月に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkei11_14GassanProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private RString myBatisSelsectId;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("JigyoHokokuRenkeiEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 集計番号_1100 = new RString("1100");
    private static final RString 集計番号_1200 = new RString("1200");
    private static final RString 集計番号_1400 = new RString("1400");
    private static final RString 集計番号_1391 = new RString("1391");
    private static final RString 集計番号_1392 = new RString("1392");
    private static final RString 集計番号_1393 = new RString("1393");
    private static final RString 番号_1 = new RString("1");
    private static final RString 番号_2 = new RString("2");
    private static final RString 番号_3 = new RString("3");
    private static final RString 番号_4 = new RString("4");
    private static final RString 番号_5 = new RString("5");
    private static final RString 番号_6 = new RString("6");
    private static final RString 番号_7 = new RString("7");
    private static final RString 番号_8 = new RString("8");
    private static final RString 番号_9 = new RString("9");
    private static final RString 番号_10 = new RString("10");
    private static final RString 番号_11 = new RString("11");
    private static final RString 番号_12 = new RString("12");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString csvFileName;
    private RDate 基準日;
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private JigyoHokokuRenkei11or14Entity record1Entity;
    private JigyoHokokuRenkei11or14Entity record2Entity;
    private JigyoHokokuRenkei11or14Entity record3Entity;
    private JigyoHokokuRenkei11or14Entity record4Entity;

    @Override
    protected void initialize() {
        if (processParameter.is出力_一般状況11_14合算_審査年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get事業報告統計合算分審査年月情報の取得");
        }
        if (processParameter.is出力_一般状況11_14合算_決定年月()) {
            myBatisSelsectId = new RString(
                    "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper."
                    + "get事業報告統計合算分決定年月情報の取得");
        }
        csvFileName = new RString("DUJRENF05_" + processParameter.get過去集計年月()
                + "_" + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援) + ".csv");
        record1Entity = new JigyoHokokuRenkei11or14Entity();
        record2Entity = new JigyoHokokuRenkei11or14Entity();
        record3Entity = new JigyoHokokuRenkei11or14Entity();
        record4Entity = new JigyoHokokuRenkei11or14Entity();
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
    protected void beforeExecute() {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkeiHeadEucCsvEntity(
                        RString.EMPTY,
                        new RString("H1"),
                        dateFomart(new RString(processParameter.get過去集計年月() + "01")),
                        dateFomart(RDate.getNowDate().toDateString()),
                        new RString("国民健康保険団体連合会"),
                        DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援),
                        DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBE認定支援)
                )
        );
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity entity) {
        record1Entity = get様式１の６レコード１の項目編集(entity, record1Entity);
        record2Entity = get様式１の６レコード2or3の項目編集(entity, record2Entity, 集計番号_1200);
        record3Entity = get様式１の６レコード2or3の項目編集(entity, record3Entity, 集計番号_1400);
        record4Entity = get様式１の６レコード4の項目編集(entity, record4Entity);
    }

    @Override
    protected void afterExecute() {
        get様式１の６レコード１のCSV出力();
        get様式１の６レコード２OR３のCSV出力(new RString("T2"), record2Entity);
        get様式１の６レコード２OR３のCSV出力(new RString("T3"), record3Entity);
        get様式１の６レコード４のCSV出力();
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkeiFooterEucCsvEntity(
                        RString.EMPTY,
                        new RString("E")
                )
        );
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void get様式１の６レコード１のCSV出力() {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkei11or14Record1EucCsvEntity(
                        RString.EMPTY,
                        new RString("T1"),
                        record1Entity.getD001(),
                        record1Entity.getD002(),
                        record1Entity.getD003(),
                        record1Entity.getD004(),
                        record1Entity.getD005(),
                        record1Entity.getD006(),
                        record1Entity.getD007(),
                        record1Entity.getD008(),
                        record1Entity.getD009(),
                        record1Entity.getD010(),
                        record1Entity.getD011(),
                        record1Entity.getD012(),
                        record1Entity.getD013(),
                        record1Entity.getD014(),
                        record1Entity.getD015(),
                        record1Entity.getD016(),
                        record1Entity.getD017(),
                        record1Entity.getD018(),
                        record1Entity.getD019(),
                        record1Entity.getD020(),
                        record1Entity.getD021(),
                        record1Entity.getD022(),
                        record1Entity.getD023(),
                        record1Entity.getD024(),
                        record1Entity.getD025(),
                        record1Entity.getD026(),
                        record1Entity.getD027(),
                        record1Entity.getD028(),
                        record1Entity.getD029(),
                        record1Entity.getD030(),
                        record1Entity.getD031(),
                        record1Entity.getD032(),
                        record1Entity.getD033(),
                        record1Entity.getD034(),
                        record1Entity.getD035(),
                        record1Entity.getD036(),
                        record1Entity.getD037(),
                        record1Entity.getD038(),
                        record1Entity.getD039(),
                        record1Entity.getD040(),
                        record1Entity.getD041(),
                        record1Entity.getD042(),
                        record1Entity.getD043(),
                        record1Entity.getD044(),
                        record1Entity.getD045(),
                        record1Entity.getD046(),
                        record1Entity.getD047(),
                        record1Entity.getD048(),
                        record1Entity.getD049(),
                        record1Entity.getD050(),
                        record1Entity.getD051(),
                        record1Entity.getD052(),
                        record1Entity.getD053(),
                        record1Entity.getD054(),
                        record1Entity.getD055()
                )
        );
    }

    private void get様式１の６レコード２OR３のCSV出力(RString レコード種別番号, JigyoHokokuRenkei11or14Entity recordEntity) {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkei11or14Record2or3EucCsvEntity(
                        RString.EMPTY,
                        レコード種別番号,
                        recordEntity.getD001(),
                        recordEntity.getD002(),
                        recordEntity.getD003(),
                        recordEntity.getD004(),
                        recordEntity.getD005(),
                        recordEntity.getD006(),
                        recordEntity.getD007(),
                        recordEntity.getD008(),
                        recordEntity.getD009(),
                        recordEntity.getD010(),
                        recordEntity.getD011(),
                        recordEntity.getD012(),
                        recordEntity.getD013(),
                        recordEntity.getD014(),
                        recordEntity.getD015(),
                        recordEntity.getD016(),
                        recordEntity.getD017(),
                        recordEntity.getD018(),
                        recordEntity.getD019(),
                        recordEntity.getD020(),
                        recordEntity.getD021(),
                        recordEntity.getD022(),
                        recordEntity.getD023(),
                        recordEntity.getD024(),
                        recordEntity.getD025(),
                        recordEntity.getD026(),
                        recordEntity.getD027(),
                        recordEntity.getD028(),
                        recordEntity.getD029(),
                        recordEntity.getD030(),
                        recordEntity.getD031(),
                        recordEntity.getD032(),
                        recordEntity.getD033()
                )
        );
    }

    private void get様式１の６レコード４のCSV出力() {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkei11or14Record4EucCsvEntity(
                        RString.EMPTY,
                        new RString("T4"),
                        record4Entity.getD001(),
                        record4Entity.getD002(),
                        record4Entity.getD003(),
                        record4Entity.getD004(),
                        record4Entity.getD005(),
                        record4Entity.getD006(),
                        record4Entity.getD007(),
                        record4Entity.getD008(),
                        record4Entity.getD009(),
                        record4Entity.getD010(),
                        record4Entity.getD011(),
                        record4Entity.getD012(),
                        record4Entity.getD013(),
                        record4Entity.getD014(),
                        record4Entity.getD015(),
                        record4Entity.getD016(),
                        record4Entity.getD017(),
                        record4Entity.getD018(),
                        record4Entity.getD019(),
                        record4Entity.getD020(),
                        record4Entity.getD021(),
                        record4Entity.getD022(),
                        record4Entity.getD023(),
                        record4Entity.getD024(),
                        record4Entity.getD025(),
                        record4Entity.getD026(),
                        record4Entity.getD027(),
                        record4Entity.getD028(),
                        record4Entity.getD029(),
                        record4Entity.getD030(),
                        record4Entity.getD031(),
                        record4Entity.getD032(),
                        record4Entity.getD033(),
                        record4Entity.getD034(),
                        record4Entity.getD035(),
                        record4Entity.getD036(),
                        record4Entity.getD037(),
                        record4Entity.getD038(),
                        record4Entity.getD039(),
                        record4Entity.getD040(),
                        record4Entity.getD041(),
                        record4Entity.getD042(),
                        record4Entity.getD043(),
                        record4Entity.getD044(),
                        record4Entity.getD045(),
                        record4Entity.getD046(),
                        record4Entity.getD047(),
                        record4Entity.getD048(),
                        record4Entity.getD049(),
                        record4Entity.getD050(),
                        record4Entity.getD051(),
                        record4Entity.getD052(),
                        record4Entity.getD053(),
                        record4Entity.getD054(),
                        record4Entity.getD055(),
                        record4Entity.getD056(),
                        record4Entity.getD057(),
                        record4Entity.getD058(),
                        record4Entity.getD059(),
                        record4Entity.getD060(),
                        record4Entity.getD061(),
                        record4Entity.getD062(),
                        record4Entity.getD063(),
                        record4Entity.getD064(),
                        record4Entity.getD065(),
                        record4Entity.getD066(),
                        record4Entity.getD067(),
                        record4Entity.getD068(),
                        record4Entity.getD069(),
                        record4Entity.getD070(),
                        record4Entity.getD071(),
                        record4Entity.getD072(),
                        record4Entity.getD073(),
                        record4Entity.getD074(),
                        record4Entity.getD075(),
                        record4Entity.getD076(),
                        record4Entity.getD077(),
                        record4Entity.getD078(),
                        record4Entity.getD079(),
                        record4Entity.getD080(),
                        record4Entity.getD081(),
                        record4Entity.getD082(),
                        record4Entity.getD083(),
                        record4Entity.getD084(),
                        record4Entity.getD085(),
                        record4Entity.getD086(),
                        record4Entity.getD087(),
                        record4Entity.getD088(),
                        record4Entity.getD089(),
                        record4Entity.getD090(),
                        record4Entity.getD091(),
                        record4Entity.getD092(),
                        record4Entity.getD093(),
                        record4Entity.getD094(),
                        record4Entity.getD095(),
                        record4Entity.getD096(),
                        record4Entity.getD097(),
                        record4Entity.getD098(),
                        record4Entity.getD099(),
                        record4Entity.getD100()
                )
        );
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード１の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity record1Entity) {
        if (集計番号_1100.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD001(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD002(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD003(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD004(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD005(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD006(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD007(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD008(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD009(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD010(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD011(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード１の項目編集2(entity, record1Entity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード１の項目編集2(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity record1Entity) {
        if (集計番号_1100.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD012(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD013(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD014(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD015(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD016(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD017(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD018(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD019(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD020(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD021(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD022(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード１の項目編集3(entity, record1Entity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード１の項目編集3(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity record1Entity) {
        if (集計番号_1100.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD023(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD024(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD025(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD026(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD027(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD028(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD029(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD030(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD031(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD032(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD033(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード１の項目編集4(entity, record1Entity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード１の項目編集4(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity record1Entity) {
        if (集計番号_1100.equals(entity.getShukeiNo().getColumnValue()) && 番号_4.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD034(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD035(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD036(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD037(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD038(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD039(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD040(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD041(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD042(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD043(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD044(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード１の項目編集5(entity, record1Entity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード１の項目編集5(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity record1Entity) {
        if (集計番号_1100.equals(entity.getShukeiNo().getColumnValue()) && 番号_5.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD045(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD046(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD047(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD048(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD049(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD050(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD051(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD052(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD053(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD054(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                record1Entity.setD055(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return record1Entity;
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード2or3の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity,
            RString 集計番号) {
        if (集計番号.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD001(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD002(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD003(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD004(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD005(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD006(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD007(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD008(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD009(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD010(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD011(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード2or3の項目編集2(entity, recordEntity, 集計番号);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード2or3の項目編集2(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity,
            RString 集計番号) {
        if (集計番号.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD012(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD013(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD014(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD015(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD016(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD017(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD018(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD019(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD020(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD021(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD022(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード2or3の項目編集3(entity, recordEntity, 集計番号);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード2or3の項目編集3(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity,
            RString 集計番号) {
        if (集計番号.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD023(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD024(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD025(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD026(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD027(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD028(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD029(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD030(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD031(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD032(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD033(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return recordEntity;
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1391.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD001(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD002(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD003(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD004(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD005(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD006(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD007(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD008(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD009(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD010(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集2(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集2(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1391.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD011(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD012(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD013(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD014(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD015(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD016(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD017(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD018(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD019(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD020(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集3(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集3(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1391.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD021(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD022(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD023(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD024(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD025(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD026(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD027(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD028(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD029(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD030(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集4(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集4(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1392.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD031(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD032(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD033(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD034(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD035(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD036(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD037(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD038(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD039(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD040(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集5(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集5(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1392.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD041(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD042(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD043(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD044(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD045(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD046(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD047(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD048(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD049(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD050(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集6(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集6(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1392.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD051(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD052(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD053(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD054(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD055(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD056(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD057(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD058(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD059(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD060(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集7(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集7(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1393.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD061(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD062(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD063(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD064(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD065(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD066(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD067(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD068(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD069(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD070(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集8(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集8(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1393.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD071(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD072(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD073(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD074(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD075(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD076(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD077(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD078(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD079(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD080(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集9(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集9(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1393.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD081(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD082(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD083(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD084(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD085(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD086(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD087(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD088(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD089(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD090(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の６レコード4の項目編集10(entity, recordEntity);
    }

    private JigyoHokokuRenkei11or14Entity get様式１の６レコード4の項目編集10(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuRenkei11or14Entity recordEntity) {
        if (集計番号_1393.equals(entity.getShukeiNo().getColumnValue()) && 番号_4.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD091(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD092(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD093(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD094(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD095(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD096(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD097(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD098(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD099(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                recordEntity.setD100(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return recordEntity;
    }

    private RString dateFomart(RString 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate flexibleDate = new FlexibleDate(年月日);
        return flexibleDate.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }
}
