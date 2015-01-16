/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInIchiRanEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInKekkaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.ur.urz.batchservice.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process._BatchProcessChunkQueryExecutor;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 給付管理票取込結果CSV出力の処理クラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyoInBatchRegistCsvOutputProcessTest extends DbcTestDacBase {

    private static final RString 一時テーブル = new RString("KyufuKanrihyoTorikomiTemp");
    private static final RString 一覧ファイル = new RString("KyufuKanrihyoInIchiRan.csv");
    private static final RString 結果ファイル = new RString("KyufuKanrihyoInKekka.csv");

    private static final RString 対象年月 = new RString("200412");
    private static final RString 支援事業者番号 = new RString("0001");
    private static final RString 支援事業者名称 = new RString("支援事業者名称1");
    private static final RString 計画作成区分コード = new RString("2");
    private static final RString 計画作成区分 = new RString("自己作成");
    private static final RString 作成区分コード = new RString("1");
    private static final RString 作成区分 = new RString("新規");
    private static final RString 被保険者番号 = new RString("0002");
    private static final RString 被保険者氏名 = new RString("被保険者氏名");
    private static final RString 作成種別区分コード = new RString("1");
    private static final RString 作成種別区分 = new RString("訪問通所サービス");
    private static final RString 要介護状態区分コード = new RString("0003");
    private static final RString 要介護状態区分 = RString.EMPTY;
    private static final RString 限度額管理期間_開始 = new RString("20040101");
    private static final RString 限度額管理期間_終了 = new RString("20040202");
    private static final RString 区分支給限度基準額 = new RString("1,000");
    private static final RString 指定サービス単位 = new RString("2,000");
    private static final RString 基準該当サービス単位 = new RString("3,000");
    private static final RString 合計単位 = new RString("4,000");
    private static final RString 証記載保険者番号 = new RString("0004");
    private static final RString 備考 = RString.EMPTY;
    private static final RString 支援事業者未登録 = new RString("支援事業者未登録");
    private static final RString 集計レコード = new RString("99");

    private static final RString 作成日付 = RDate.getNowDate().seireki().separator(Separator.SLASH).toDateString();

    public static class ProcessTest extends DbcTestDacBase {

        @Test
        public void 給付管理票取込結果一覧表のCSVが正しく出力されること() {

            createTempTable();
            BatchProcessTestHelper.execute(KyufuKanrihyoInBatchRegistCsvOutputProcess.class, createSqlParameter(), sqlSession);

            List<KyufuKanrihyoInIchiRanEntity> entityList = readIchiRanCsvFile();

            KyufuKanrihyoInIchiRanEntity entity = entityList.get(0);
            assertThat(entity.get連番(), is(new RString("1")));
            assertThat(entity.get対象年月(), is(対象年月));
            assertThat(entity.get支援事業者番号(), is(支援事業者番号));
            assertThat(entity.get支援事業者名称(), is(支援事業者名称));
            assertThat(entity.get計画作成区分コード(), is(計画作成区分コード));
            assertThat(entity.get計画作成区分(), is(計画作成区分));
            assertThat(entity.get作成区分コード(), is(作成区分コード));
            assertThat(entity.get作成区分(), is(作成区分));
            assertThat(entity.get被保険者番号(), is(被保険者番号));
            assertThat(entity.get被保険者氏名(), is(被保険者氏名));
            assertThat(entity.get作成種別区分コード(), is(作成種別区分コード));
            assertThat(entity.get作成種別区分(), is(作成種別区分));
            assertThat(entity.get要介護状態区分コード(), is(要介護状態区分コード));
            assertThat(entity.get要介護状態区分(), is(要介護状態区分));
            assertThat(entity.get限度額管理期間_開始(), is(限度額管理期間_開始));
            assertThat(entity.get限度額管理期間_終了(), is(限度額管理期間_終了));
            assertThat(entity.get区分支給限度基準額(), is(区分支給限度基準額));
            assertThat(entity.get指定サービス単位(), is(指定サービス単位));
            assertThat(entity.get基準該当サービス単位(), is(基準該当サービス単位));
            assertThat(entity.get合計単位(), is(合計単位));
            assertThat(entity.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(entity.get備考(), is(備考));

            entity = entityList.get(1);
            assertThat(entity.get連番(), is(new RString("2")));
            assertThat(entity.get計画作成区分コード(), is(RString.EMPTY));
            assertThat(entity.get計画作成区分(), is(RString.EMPTY));
            assertThat(entity.get作成区分コード(), is(RString.EMPTY));
            assertThat(entity.get作成区分(), is(RString.EMPTY));
            assertThat(entity.get作成種別区分コード(), is(RString.EMPTY));
            assertThat(entity.get作成種別区分(), is(RString.EMPTY));
            assertThat(entity.get区分支給限度基準額(), is(new RString("-1,000")));
            assertThat(entity.get指定サービス単位(), is(new RString("-2,000")));
            assertThat(entity.get基準該当サービス単位(), is(new RString("-3,000")));
            assertThat(entity.get合計単位(), is(new RString("-4,000")));
            assertThat(entity.get備考(), is(支援事業者未登録));

            entity = entityList.get(2);
            assertThat(entity.get連番(), is(new RString("3")));
            assertThat(entity.get指定サービス単位(), is(RString.EMPTY));
            assertThat(entity.get基準該当サービス単位(), is(RString.EMPTY));
        }

        @Test
        public void 給付管理票取込結果のCSVが正しく出力されること() {

            KyufuKanrihyoInKekkaEntity entity = readKekkaCsvFile();
            assertThat(entity.get作成日付(), is(作成日付));
            assertThat(entity.get作成時間().length(), is(8));
            assertThat(entity.get作成時間().substring(2, 3), is(new RString(":")));
            assertThat(entity.get作成時間().substring(5, 6), is(new RString(":")));
            assertThat(entity.get訪問通所サービス件数(), is(new RString("1")));
            assertThat(entity.get短期入所サービス件数(), is(new RString("2")));
            assertThat(entity.get居宅サービス件数(), is(new RString("3")));
            assertThat(entity.get合計件数(), is(new RString("6")));
        }
    }

    private static List<KyufuKanrihyoInIchiRanEntity> readIchiRanCsvFile() {
        CsvReader csvReader = createCsvReader(一覧ファイル, KyufuKanrihyoInIchiRanEntity.class);
        List<KyufuKanrihyoInIchiRanEntity> entityList = new ArrayList<>();
        while (true) {
            KyufuKanrihyoInIchiRanEntity entity = (KyufuKanrihyoInIchiRanEntity) csvReader.readLine();
            if (entity != null) {
                entityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return entityList;
    }

    private static KyufuKanrihyoInKekkaEntity readKekkaCsvFile() {
        CsvReader csvReader = createCsvReader(結果ファイル, KyufuKanrihyoInKekkaEntity.class);
        KyufuKanrihyoInKekkaEntity entity = (KyufuKanrihyoInKekkaEntity) csvReader.readLine();
        csvReader.close();
        return entity;
    }

    private static CsvReader createCsvReader(RString fileName, Class entity) {
        return new CsvReader.InstanceBuilder(getFilePath(fileName), entity)
                .setDelimiter(new RString(","))
                .setEnclosure(new RString("\""))
                .setEncode(Encode.UTF_8)
                .hasHeader(true)
                .build();
    }

    private static RString getFilePath(RString fileName) {
        RStringBuilder filePath = new RStringBuilder();
        filePath.append("src")
                .append(File.separator).append("main")
                .append(File.separator).append("resources")
                .append(File.separator).append("jp")
                .append(File.separator).append("co")
                .append(File.separator).append("ndensan")
                .append(File.separator).append("reams")
                .append(File.separator).append("db")
                .append(File.separator).append("dbc")
                .append(File.separator).append("batchservice")
                .append(File.separator).append("step")
                .append(File.separator).append("csv")
                .append(File.separator).append(fileName);
        return filePath.toRString();
    }

    private static void createTempTable() {
        IBatchTableWriter<DbTKyufukanrihyoDataTempTableEntity> writer
                = BatchWriters.batchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.class)
                .tempTableName(一時テーブル)
                .build();
        _BatchProcessChunkQueryExecutor chunkQueryExecutor = new _BatchProcessChunkQueryExecutor(sqlSession);
        writer.setChunkQueryExecuter(sqlSession, chunkQueryExecutor);
        for (DbTKyufukanrihyoDataTempTableEntity entity : createTempDataList()) {
            writer.insert(entity);
        }
        chunkQueryExecutor.close();
    }

    private static List<DbTKyufukanrihyoDataTempTableEntity> createTempDataList() {
        List<DbTKyufukanrihyoDataTempTableEntity> entityList = new ArrayList<>();
        entityList.add(createTempData("1", "200412", "1", "1", "1,000", "2", "2,000", "3,000", "4,000", "支援事業者名称1"));
        entityList.add(createTempData("2", "200412", "4", "4", "-1,000", "1", "-2,000", "-3,000", "-4,000", ""));
        entityList.add(createTempData("3", "200604", "2", "2", "1,000", "3", "2,000", "3,000", "4,000", "支援事業者名称3"));
        entityList.add(createTempData("4", "200412", "3", "2", "1,000", "4", "2,000", "3,000", "4,000", "支援事業者名称4"));
        entityList.add(createTempData("5", "200412", "5", "3", "1,000", "5", "2,000", "3,000", "4,000", "支援事業者名称5"));
        entityList.add(createTempData("6", "200412", "6", "3", "1,000", "6", "2,000", "3,000", "4,000", "支援事業者名称6"));
        entityList.add(createTempData("7", "200412", "6", "3", "1,000", "7", "2,000", "3,000", "4,000", "支援事業者名称7"));
        return entityList;
    }

    private static DbTKyufukanrihyoDataTempTableEntity createTempData(
            String renban,
            String taishoYM,
            String sakuseiKubun,
            String shubetsuKubun,
            String shikyugendogaku,
            String keikakuSakuseiKubun,
            String serviceShokei,
            String gaitoServiceShokei,
            String gokeiTanisuNissu,
            String jigyoshoMeisho) {
        DbTKyufukanrihyoDataTempTableEntity entity = new DbTKyufukanrihyoDataTempTableEntity();
        entity.setRecordShubetsu(new RString("2"));
        entity.setRenban(new RString(renban));
        entity.setKokanjohoShikibetsuNo(RString.EMPTY);
        entity.setChohyoRecordShubetsu(RString.EMPTY);
        entity.setShinsaYM(RString.EMPTY);
        entity.setTaishoYM(new RString(taishoYM));
        entity.setHokenshaNo(RString.EMPTY);
        entity.setKyotakuShienJigyoshoNo(RString.EMPTY);
        entity.setKyufukanrihyoSakuseiKubunCode(new RString(sakuseiKubun));
        entity.setKyufukanrihyoSakuseiYMD(RString.EMPTY);
        entity.setKyufukanrihyoShubetsuKubunCode(new RString(shubetsuKubun));
        entity.setKyufukanrihyoMeisaigyoNo(集計レコード);
        entity.setHihokenshaNo(RString.EMPTY);
        entity.setSeinengappiYMD(RString.EMPTY);
        entity.setSeibetsuCode(RString.EMPTY);
        entity.setYokaigojotaiKubunCode(要介護状態区分コード);
        entity.setGendogakuTekiyoKaishiYMD(限度額管理期間_開始);
        entity.setGendogakuTekiyoShuryoYMD(限度額管理期間_終了);
        entity.setKyotakuKaigoyoboShikyugendogaku(new RString(shikyugendogaku));
        entity.setKyotakuKeikakuSakuseiKubunCode(new RString(keikakuSakuseiKubun));
        entity.setServiceTeikyoJigyoshoNo(支援事業者番号);
        entity.setShiteiKijunGaitoJigyoshoKubunCode(RString.EMPTY);
        entity.setServiceShuruiCode(RString.EMPTY);
        entity.setKyufuKeikakuTanisuNissu(RString.EMPTY);
        entity.setZentsukiMadeKyufuKeikakuNissu(RString.EMPTY);
        entity.setShiteiServiceShokei(new RString(serviceShokei));
        entity.setKijunGaitoServiceShokei(new RString(gaitoServiceShokei));
        entity.setKyufuKeikakuGokeiTanisuNissu(new RString(gokeiTanisuNissu));
        entity.setKaigoshienSenmoninNo(RString.EMPTY);
        entity.setItakusakiKyotakuKaigoshienJigyoshoNo(RString.EMPTY);
        entity.setItakusakiKaigoshienSenmoninNo(RString.EMPTY);
        entity.setHihoNoHenkanShichosonCode(RString.EMPTY);
        entity.setShinHihokenshaNo(被保険者番号);
        entity.setShichosonCode(RString.EMPTY);
        entity.setKoikiJutokuSochimotoShichosonCode(RString.EMPTY);
        entity.setKyoShichosonCode(RString.EMPTY);
        entity.setShikibetsuCode(RString.EMPTY);
        entity.setKanjiMeisho(被保険者氏名);
        entity.setJigyoshoMeisho(new RString(jigyoshoMeisho));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return entity;
    }

    private static Map<RString, Object> createSqlParameter() {
        Map<RString, Object> sqlParameter = new HashMap<>();
        sqlParameter.put(new RString("出力順ID"), 1L);
        return sqlParameter;
    }
}
