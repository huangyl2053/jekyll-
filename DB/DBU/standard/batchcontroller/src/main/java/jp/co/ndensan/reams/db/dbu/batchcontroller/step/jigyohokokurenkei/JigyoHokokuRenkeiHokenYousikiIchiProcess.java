/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokurenkei.JigyoHokokuRenkeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiEucCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiHokenYousikiIchiProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper.get事業報告統計情報の取得");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("JigyoHokokuRenkeiEucCsv"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 番号_1 = new RString("1");
    private static final RString 番号_2 = new RString("2");
    private static final RString 番号_3 = new RString("3");
    private static final RString 番号_4 = new RString("4");
    private static final RString 番号_5 = new RString("5");
    private static final RString 番号_6 = new RString("6");
    private static final int 桁_5 = 5;
    private RDate 基準日;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString csvFileName;
    private JigyoHokokuRenkeiProcessParameter processParameter;

    @Override
    protected void initialize() {
        csvFileName = new RString("DUJRENF01_"
                + processParameter.get過去集計年月()
                + "_"
                + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援) + ".csv");
    }

    @BatchWriter
    private EucCsvWriter<JigyoHokokuRenkeiEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParamter());
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
                .hasHeader(true).
                build();
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式1のCSV出力(entity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void get様式1のCSV出力(DbT7021JigyoHokokuTokeiDataEntity entity) {
        JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity
                = get様式1の項目編集(entity, new RString("0200"), new RString("0301"), new RString("0302"));
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkeiEucCsvEntity(
                        entity.getShukeiTaishoYSeireki().wareki().getYear(),
                        entity.getShukeiTaishoM(),
                        entity.getShichosonCode().getColumnValue().substring(0, 桁_5),
                        RString.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        jigyoHokokuRenkeiEntity.getD005(),
                        jigyoHokokuRenkeiEntity.getD006(),
                        jigyoHokokuRenkeiEntity.getD007(),
                        jigyoHokokuRenkeiEntity.getD008(),
                        jigyoHokokuRenkeiEntity.getD009(),
                        jigyoHokokuRenkeiEntity.getD010(),
                        jigyoHokokuRenkeiEntity.getD011(),
                        jigyoHokokuRenkeiEntity.getD012(),
                        jigyoHokokuRenkeiEntity.getD013(),
                        jigyoHokokuRenkeiEntity.getD014(),
                        jigyoHokokuRenkeiEntity.getD015(),
                        jigyoHokokuRenkeiEntity.getD016(),
                        jigyoHokokuRenkeiEntity.getD017(),
                        jigyoHokokuRenkeiEntity.getD018(),
                        jigyoHokokuRenkeiEntity.getD019(),
                        jigyoHokokuRenkeiEntity.getD020(),
                        jigyoHokokuRenkeiEntity.getD021(),
                        jigyoHokokuRenkeiEntity.getD022(),
                        jigyoHokokuRenkeiEntity.getD023(),
                        jigyoHokokuRenkeiEntity.getD024(),
                        jigyoHokokuRenkeiEntity.getD025(),
                        jigyoHokokuRenkeiEntity.getD026(),
                        jigyoHokokuRenkeiEntity.getD027(),
                        jigyoHokokuRenkeiEntity.getD028(),
                        jigyoHokokuRenkeiEntity.getD029(),
                        jigyoHokokuRenkeiEntity.getD030(),
                        jigyoHokokuRenkeiEntity.getD031(),
                        jigyoHokokuRenkeiEntity.getD032(),
                        jigyoHokokuRenkeiEntity.getD033(),
                        jigyoHokokuRenkeiEntity.getD034(),
                        jigyoHokokuRenkeiEntity.getD035(),
                        jigyoHokokuRenkeiEntity.getD036())
        );
    }

    private JigyoHokokuRenkeiEntity get様式1の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03) {
        JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity = new JigyoHokokuRenkeiEntity();
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD005(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD006(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD007(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD008(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD009(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD010(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD011(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD012(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD013(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD014(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD015(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD016(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式1の項目編集2(entity, 集計番号_01, 集計番号_02, 集計番号_03, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式1の項目編集2(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_4.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD017(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD018(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD019(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD020(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_5.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD021(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD022(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD023(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD024(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式1の項目編集3(entity, 集計番号_02, 集計番号_03, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式1の項目編集3(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_02,
            RString 集計番号_03,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_02.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD025(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD026(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD027(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD028(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD029(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD030(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_03.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD031(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD032(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD033(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD034(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD035(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD036(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return jigyoHokokuRenkeiEntity;
    }
}
