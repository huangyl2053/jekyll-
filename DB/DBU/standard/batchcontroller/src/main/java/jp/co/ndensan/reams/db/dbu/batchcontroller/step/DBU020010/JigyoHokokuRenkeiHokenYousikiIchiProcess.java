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
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokurenkei.JigyoHokokuRenkeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiEucCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
    private static final int 桁_4 = 4;
    private static final int 桁_3 = 3;
    private final RDate 基準日 = RDate.getNowDate();
    private static final RString 番号 = new RString("保険者番号");
    private static final RString 名称 = new RString("保険者名称");
    private RString eucFilePath;
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private static MapperProvider mapperProvider;
    private IJigyoHokokuRenkeiMapper mapper;
    private JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity = new JigyoHokokuRenkeiEntity();
    private Map<RString, List<RString>> 保険者番号data;
    private Map<RString, List<RString>> 保険者名称data;

    @Override
    protected void initialize() {
        RString spoolWorkPath = processParameter.getSpoolWorkPath();
        eucFilePath = Path.combinePath(spoolWorkPath, new RString("tmp.csv"));
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
    }

    @BatchWriter
    private EucCsvWriter<JigyoHokokuRenkeiEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
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
        jigyoHokokuRenkeiEntity = get様式1の項目編集(entity, new RString("0200"), new RString("0301"), new RString("0302"), jigyoHokokuRenkeiEntity);
    }

    @Override
    protected void afterExecute() {
        boolean flag = true;
        RString 保険者番号bak = RString.EMPTY;
        for (RString 保険者番号 : 保険者番号data.get(番号)) {
            if (!保険者番号bak.equals(保険者番号)) {
                eucCsvWriter.close();
                tempCsv(flag);
                flag = false;
                RStringBuilder filePath = new RStringBuilder();
                filePath.append("DUJRENF01_");
                filePath.append(processParameter.get過去集計年月());
                filePath.append("_");
                filePath.append(保険者番号);
                filePath.append(".csv");
                setFilePath(filePath);
                保険者番号bak = 保険者番号;
            }
            get様式1のCSV出力(保険者番号);
        }
        eucCsvWriter.close();
    }

    private boolean tempCsv(boolean flag) {
        if (flag) {
            File tmpfile = new File(eucFilePath.toString());
            if (tmpfile.exists()) {
                return tmpfile.delete();
            }
        }
        return true;
    }

    private void get様式1のCSV出力(RString 保険者番号) {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkeiEucCsvEntity(
                        dateFormat(processParameter.get過去集計年月()),
                        processParameter.get過去集計年月().substring(桁_4),
                        保険者番号,
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
                        jigyoHokokuRenkeiEntity.getD036()));
    }

    private void setFilePath(RStringBuilder filePath) {
        eucFilePath = Path.combinePath(processParameter.getSpoolWorkPath(), filePath.toRString());
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
    }

    private JigyoHokokuRenkeiEntity get様式1の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {

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

    private RString dateFormat(RString date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate flexibleDate = new FlexibleDate(date);
        return flexibleDate.wareki().toDateString().substring(0, 桁_3);
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
