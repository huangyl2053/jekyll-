/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokurenkei.JigyoHokokuRenkeiEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei2or3EucCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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

/**
 * 様式別連携情報作成のバッチ処理・一般状況（１）～（１０）に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiHokenYousikiIchi_SanProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

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
    private static final RString 番号_7 = new RString("7");
    private static final RString 番号_8 = new RString("8");
    private static final RString 番号_9 = new RString("9");
    private static final RString 番号_10 = new RString("10");
    private static final RString 番号_11 = new RString("11");
    private static final RString 番号_12 = new RString("12");
    private static final int 桁_4 = 4;
    private static final int 桁_3 = 3;
    private RDate 基準日;
    private RString eucFilePath;
    private RString csvFileName;
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity = new JigyoHokokuRenkeiEntity();

    @Override
    protected void initialize() {
        csvFileName = new RString("DUJRENF03_"
                + processParameter.get過去集計年月()
                + "_"
                + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援) + ".csv");
    }

    @BatchWriter
    private EucCsvWriter<JigyoHokokuRenkei2or3EucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = processParameter.getSpoolWorkPath();
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
        get様式１の３の項目編集(entity, new RString("1010"), new RString("0900"), new RString("1020"), new RString("1002"), jigyoHokokuRenkeiEntity);
    }

    @Override
    protected void afterExecute() {
        get様式１の３再掲_第二号被保険者のCSV出力();
        eucCsvWriter.close();
    }

    private void get様式１の３再掲_第二号被保険者のCSV出力() {
        eucCsvWriter.writeLine(
                new JigyoHokokuRenkei2or3EucCsvEntity(
                        dateFormat(processParameter.get過去集計年月()),
                        processParameter.get過去集計年月().substring(桁_4),
                        DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBE認定支援),
                        jigyoHokokuRenkeiEntity.getD001(),
                        jigyoHokokuRenkeiEntity.getD002(),
                        jigyoHokokuRenkeiEntity.getD003(),
                        jigyoHokokuRenkeiEntity.getD004(),
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
                        jigyoHokokuRenkeiEntity.getD036(),
                        jigyoHokokuRenkeiEntity.getD037(),
                        jigyoHokokuRenkeiEntity.getD038(),
                        jigyoHokokuRenkeiEntity.getD039(),
                        jigyoHokokuRenkeiEntity.getD040(),
                        jigyoHokokuRenkeiEntity.getD041(),
                        jigyoHokokuRenkeiEntity.getD042(),
                        jigyoHokokuRenkeiEntity.getD043(),
                        jigyoHokokuRenkeiEntity.getD044(),
                        jigyoHokokuRenkeiEntity.getD045(),
                        jigyoHokokuRenkeiEntity.getD046(),
                        jigyoHokokuRenkeiEntity.getD047(),
                        jigyoHokokuRenkeiEntity.getD048(),
                        jigyoHokokuRenkeiEntity.getD049(),
                        jigyoHokokuRenkeiEntity.getD050(),
                        jigyoHokokuRenkeiEntity.getD051(),
                        jigyoHokokuRenkeiEntity.getD052(),
                        jigyoHokokuRenkeiEntity.getD053(),
                        jigyoHokokuRenkeiEntity.getD054(),
                        jigyoHokokuRenkeiEntity.getD055(),
                        jigyoHokokuRenkeiEntity.getD056(),
                        jigyoHokokuRenkeiEntity.getD057(),
                        jigyoHokokuRenkeiEntity.getD058(),
                        jigyoHokokuRenkeiEntity.getD059(),
                        jigyoHokokuRenkeiEntity.getD060(),
                        jigyoHokokuRenkeiEntity.getD061(),
                        jigyoHokokuRenkeiEntity.getD062(),
                        jigyoHokokuRenkeiEntity.getD063(),
                        jigyoHokokuRenkeiEntity.getD064(),
                        jigyoHokokuRenkeiEntity.getD065(),
                        jigyoHokokuRenkeiEntity.getD066(),
                        jigyoHokokuRenkeiEntity.getD067(),
                        jigyoHokokuRenkeiEntity.getD068(),
                        jigyoHokokuRenkeiEntity.getD069(),
                        jigyoHokokuRenkeiEntity.getD070(),
                        jigyoHokokuRenkeiEntity.getD071(),
                        jigyoHokokuRenkeiEntity.getD072(),
                        jigyoHokokuRenkeiEntity.getD073(),
                        jigyoHokokuRenkeiEntity.getD074(),
                        jigyoHokokuRenkeiEntity.getD075(),
                        jigyoHokokuRenkeiEntity.getD076(),
                        jigyoHokokuRenkeiEntity.getD077(),
                        jigyoHokokuRenkeiEntity.getD078(),
                        jigyoHokokuRenkeiEntity.getD079(),
                        jigyoHokokuRenkeiEntity.getD080(),
                        jigyoHokokuRenkeiEntity.getD081(),
                        jigyoHokokuRenkeiEntity.getD082(),
                        jigyoHokokuRenkeiEntity.getD083(),
                        jigyoHokokuRenkeiEntity.getD084(),
                        jigyoHokokuRenkeiEntity.getD085(),
                        jigyoHokokuRenkeiEntity.getD086(),
                        jigyoHokokuRenkeiEntity.getD087(),
                        jigyoHokokuRenkeiEntity.getD088(),
                        jigyoHokokuRenkeiEntity.getD089(),
                        jigyoHokokuRenkeiEntity.getD090(),
                        jigyoHokokuRenkeiEntity.getD091(),
                        jigyoHokokuRenkeiEntity.getD092(),
                        jigyoHokokuRenkeiEntity.getD093(),
                        jigyoHokokuRenkeiEntity.getD094(),
                        jigyoHokokuRenkeiEntity.getD095(),
                        jigyoHokokuRenkeiEntity.getD096(),
                        jigyoHokokuRenkeiEntity.getD097(),
                        jigyoHokokuRenkeiEntity.getD098(),
                        jigyoHokokuRenkeiEntity.getD099(),
                        jigyoHokokuRenkeiEntity.getD100(),
                        jigyoHokokuRenkeiEntity.getD101())
        );
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD001(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD002(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD003(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD005(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD006(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD004(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集2(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集2(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD007(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD008(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD009(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD010(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD011(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD012(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD015(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD016(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD017(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD018(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD013(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD014(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集3(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集3(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_3.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD019(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD020(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD021(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD022(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD023(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD024(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD027(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD028(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD029(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD030(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD025(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD026(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集4(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集4(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_4.equals(new RString(entity.getTateNo().toString()))) {
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
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD039(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD040(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD041(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD042(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD037(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD038(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集5(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集5(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_5.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD043(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD044(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD045(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD046(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD047(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD048(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD051(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD052(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD053(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD054(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD049(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD050(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集6(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集6(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_6.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD055(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD056(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD057(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD058(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD059(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD060(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD063(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD064(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD065(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD066(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD061(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD062(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集7(entity, 集計番号_01, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集7(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_01,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_01.equals(entity.getShukeiNo().getColumnValue()) && 番号_7.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_1.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD067(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD068(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD069(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD070(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD071(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD072(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD075(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD076(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD077(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD078(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD073(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD074(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集8(entity, 集計番号_02, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集8(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_02,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_02.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD079(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD080(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD081(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD082(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD083(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_03.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD084(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD085(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD087(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD089(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD091(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD093(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD095(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        return get様式１の３の項目編集9(entity, 集計番号_03, 集計番号_04, jigyoHokokuRenkeiEntity);
    }

    private JigyoHokokuRenkeiEntity get様式１の３の項目編集9(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号_03,
            RString 集計番号_04,
            JigyoHokokuRenkeiEntity jigyoHokokuRenkeiEntity) {
        if (集計番号_03.equals(entity.getShukeiNo().getColumnValue()) && 番号_2.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD086(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD088(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD090(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD092(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD094(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD096(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
        if (集計番号_04.equals(entity.getShukeiNo().getColumnValue()) && 番号_1.equals(new RString(entity.getYokoNo().toString()))) {
            if (番号_1.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD097(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD098(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD099(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD100(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getTateNo().toString()))) {
                jigyoHokokuRenkeiEntity.setD101(new RString(entity.getShukeiKekkaAtai().toString()));
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
}
