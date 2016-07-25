/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.jigyohokokurenkei;

import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.IJigyoHokokuRenkeiEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkei2_4or2_6EucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiFooterEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei.JigyoHokokuRenkeiHead2EucCsvEntity;
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
 * 様式別連携情報作成のバッチ処理・保険給付決定状況現物分に対応するのCSV出力のプロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiGassanYousikiNi_GoToRokuProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

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
    private static final RString 番号_4 = new RString("4");
    private static final RString 番号_5 = new RString("5");
    private static final RString 番号_6 = new RString("6");
    private static final RString 番号_7 = new RString("7");
    private static final RString 番号_8 = new RString("8");
    private static final RString 番号_9 = new RString("9");
    private static final RString 番号_10 = new RString("10");
    private static final RString 番号_11 = new RString("11");
    private static final RString 番号_12 = new RString("12");
    private static final RString 番号_13 = new RString("13");
    private static final RString 番号_14 = new RString("14");
    private static final RString 番号_15 = new RString("15");
    private static final RString 番号_16 = new RString("16");
    private static final RString 番号_17 = new RString("17");
    private static final RString 集計番号_0105 = new RString("0105");
    private static final RString 集計番号_0106 = new RString("0106");
    private static final RString 集計番号_0205 = new RString("0205");
    private static final RString 集計番号_0206 = new RString("0206");
    private static final RString ア_件数 = new RString("ア　件数");
    private static final RString イ_件数 = new RString("イ　給付費");
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 食費_介護療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_滞在費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 居住_療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 総計Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_食費_介護療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_滞在費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_居住_療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 給付費_総計Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_食費_介護療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_滞在費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_居住_療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_総計Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_食費_介護療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_滞在費Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_介護老人福祉施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_介護老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_介護療養型医療施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_地域密着型介護老人福祉Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_短期入所生活介護Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_老人保健施設Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_居住_療養型医療施設等Entity;
    private JigyoHokokuRenkei2_4or2_6EucCsvEntity 第２号_給付費_総計Entity;
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
        csvFileName = new RString("DUJRENF11_" + processParameter.get過去集計年月()
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
        get総数_件数のデータ編集(entity);
        get総数_給付費のデータ編集(entity);
        get第２号被保険者分_件数のデータ編集(entity);
        get第２号被保険者分_給付費のデータ編集(entity);
    }

    @Override
    protected void afterExecute() {
        get様式２の５_様式２の６のCSV出力();
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void get様式２の５_様式２の６のCSV出力() {
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_件数));
        eucCsvWriter.writeLine(null);
        eucCsvWriter.writeLine(食費Entity);
        eucCsvWriter.writeLine(食費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(食費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(食費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(食費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(食費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(食費_老人保健施設Entity);
        eucCsvWriter.writeLine(食費_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(居住_滞在費Entity);
        eucCsvWriter.writeLine(居住_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(居住_介護老人保健施設Entity);
        eucCsvWriter.writeLine(居住_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(居住_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(居住_短期入所生活介護Entity);
        eucCsvWriter.writeLine(居住_老人保健施設Entity);
        eucCsvWriter.writeLine(居住_療養型医療施設等Entity);
        eucCsvWriter.writeLine(総計Entity);
        eucCsvWriter.writeLine(null);
        eucCsvWriter.writeLine(給付費_食費Entity);
        eucCsvWriter.writeLine(給付費_食費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(給付費_食費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(給付費_食費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(給付費_食費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(給付費_食費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(給付費_食費_老人保健施設Entity);
        eucCsvWriter.writeLine(給付費_食費_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(給付費_居住_滞在費Entity);
        eucCsvWriter.writeLine(給付費_居住_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(給付費_居住_介護老人保健施設Entity);
        eucCsvWriter.writeLine(給付費_居住_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(給付費_居住_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(給付費_居住_短期入所生活介護Entity);
        eucCsvWriter.writeLine(給付費_居住_老人保健施設Entity);
        eucCsvWriter.writeLine(給付費_居住_療養型医療施設等Entity);
        eucCsvWriter.writeLine(給付費_総計Entity);
        eucCsvWriter.writeLine(setヘッダレコード(ア_件数, イ_件数));
        eucCsvWriter.writeLine(null);
        eucCsvWriter.writeLine(第２号_食費Entity);
        eucCsvWriter.writeLine(第２号_食費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_食費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_食費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_食費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_食費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_食費_老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_食費_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_居住_滞在費Entity);
        eucCsvWriter.writeLine(第２号_居住_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_居住_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_居住_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_居住_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_居住_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_居住_老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_居住_療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_総計Entity);
        eucCsvWriter.writeLine(null);
        eucCsvWriter.writeLine(第２号_給付費_食費Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_食費_介護療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_滞在費Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_介護老人福祉施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_介護老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_介護療養型医療施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_地域密着型介護老人福祉Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_短期入所生活介護Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_老人保健施設Entity);
        eucCsvWriter.writeLine(第２号_給付費_居住_療養型医療施設等Entity);
        eucCsvWriter.writeLine(第２号_給付費_総計Entity);
        eucCsvWriter.writeLine(set終了レコード());
    }

    private JigyoHokokuRenkeiHead2EucCsvEntity setヘッダレコード(RString 先頭項目_件数, RString 先頭項目_給付費) {
        return new JigyoHokokuRenkeiHead2EucCsvEntity(
                先頭項目_件数,
                先頭項目_給付費,
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

    private void get総数_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_1, 食費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_4, 食費_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_5, 食費_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_6, 食費_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_16, 食費_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_7, 食費_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_8, 食費_老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_9, 食費_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_2, 居住_滞在費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_10, 居住_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_11, 居住_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_12, 居住_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_17, 居住_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_13, 居住_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_14, 居住_老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_15, 居住_療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0105, 番号_3, 総計Entity, ア_件数);
    }

    private void get総数_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_1, 給付費_食費Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_4, 給付費_食費_介護老人福祉施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_5, 給付費_食費_介護老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_6, 給付費_食費_介護療養型医療施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_16, 給付費_食費_地域密着型介護老人福祉Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_7, 給付費_食費_短期入所生活介護Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_8, 給付費_食費_老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_9, 給付費_食費_介護療養型医療施設等Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_2, 給付費_居住_滞在費Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_10, 給付費_居住_介護老人福祉施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_11, 給付費_居住_介護老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_12, 給付費_居住_介護療養型医療施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_17, 給付費_居住_地域密着型介護老人福祉Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_13, 給付費_居住_短期入所生活介護Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_14, 給付費_居住_老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_15, 給付費_居住_療養型医療施設等Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0106, 番号_3, 給付費_総計Entity, イ_件数);
    }

    private void get第２号被保険者分_件数のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_1, 第２号_食費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_4, 第２号_食費_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_5, 第２号_食費_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_6, 第２号_食費_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_16, 第２号_食費_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_7, 第２号_食費_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_8, 第２号_食費_老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_9, 第２号_食費_介護療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_2, 第２号_居住_滞在費Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_10, 第２号_居住_介護老人福祉施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_11, 第２号_居住_介護老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_12, 第２号_居住_介護療養型医療施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_17, 第２号_居住_地域密着型介護老人福祉Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_13, 第２号_居住_短期入所生活介護Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_14, 第２号_居住_老人保健施設Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_15, 第２号_居住_療養型医療施設等Entity, ア_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0205, 番号_3, 第２号_総計Entity, ア_件数);
    }

    private void get第２号被保険者分_給付費のデータ編集(DbT7021JigyoHokokuTokeiDataEntity entity) {
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_1, 第２号_給付費_食費Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_4, 第２号_給付費_食費_介護老人福祉施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_5, 第２号_給付費_食費_介護老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_6, 第２号_給付費_食費_介護療養型医療施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_16, 第２号_給付費_食費_地域密着型介護老人福祉Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_7, 第２号_給付費_食費_短期入所生活介護Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_8, 第２号_給付費_食費_老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_9, 第２号_給付費_食費_介護療養型医療施設等Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_2, 第２号_給付費_居住_滞在費Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_10, 第２号_給付費_居住_介護老人福祉施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_11, 第２号_給付費_居住_介護老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_12, 第２号_給付費_居住_介護療養型医療施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_17, 第２号_給付費_居住_地域密着型介護老人福祉Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_13, 第２号_給付費_居住_短期入所生活介護Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_14, 第２号_給付費_居住_老人保健施設Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_15, 第２号_給付費_居住_療養型医療施設等Entity, イ_件数);
        get様式２から様式２の６のデータ編集(entity, 集計番号_0206, 番号_3, 第２号_給付費_総計Entity, イ_件数);
    }

    private void get様式２から様式２の６のデータ編集(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            RString 集計番号,
            RString 縦番号,
            JigyoHokokuRenkei2_4or2_6EucCsvEntity eucCsvEntity, RString 先頭項目) {
        eucCsvEntity.setレコード種別番号(new RString("D1"));
        eucCsvEntity.set交換情報識別番号(RString.EMPTY);
        eucCsvEntity.set先頭項目(先頭項目);
        if (集計番号.equals(entity.getShukeiNo().getColumnValue()) && 縦番号.equals(new RString(entity.getTateNo().toString()))) {
            if (番号_9.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要支援１(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_10.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要支援２(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_11.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計_予防給付(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_2.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set経過的要介護(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_3.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護１(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_4.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護２(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_5.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護３(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_6.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護４(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_7.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set要介護５(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_8.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計_介護給付(new RString(entity.getShukeiKekkaAtai().toString()));
            }
            if (番号_12.equals(new RString(entity.getYokoNo().toString()))) {
                eucCsvEntity.set計(new RString(entity.getShukeiKekkaAtai().toString()));
            }
        }
    }
}
