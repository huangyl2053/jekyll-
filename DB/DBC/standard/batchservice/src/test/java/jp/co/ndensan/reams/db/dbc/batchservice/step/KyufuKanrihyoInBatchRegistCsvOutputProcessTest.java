/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInIchiRanEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInKekkaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.ur.urz.batchservice.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.flow._StepResult;
import jp.co.ndensan.reams.uz.uza.batch.process._BatchProcessChunkQueryExecutor;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    private static final RString 一時テーブル = new RString("DbTKyufukanrihyoDataTempTable");
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
    private static final RString 明細行 = new RString("99");
    private static final RString 作成日付 = RDate.getNowDate().seireki().separator(Separator.SLASH).toDateString();

    public static class ProcessTest extends DbcTestDacBase {

        @Test
        public void 給付管理票取込のCSVが正しく出力されること() {

            createTempTable();
            _StepResult result = BatchProcessTestHelper.execute(KyufuKanrihyoInBatchRegistCsvOutputProcess.class, createSqlParameter(), sqlSession);

            List<KyufuKanrihyoInIchiRanEntity> entityList = readIchiRanCsvFile(result);

            KyufuKanrihyoInIchiRanEntity ichiranEntity = entityList.get(0);
            assertThat(ichiranEntity.get連番(), is(new RString("1")));
            assertThat(ichiranEntity.get対象年月(), is(対象年月));
            assertThat(ichiranEntity.get支援事業者番号(), is(支援事業者番号));
            assertThat(ichiranEntity.get支援事業者名称(), is(支援事業者名称));
            assertThat(ichiranEntity.get計画作成区分コード(), is(計画作成区分コード));
            assertThat(ichiranEntity.get計画作成区分(), is(計画作成区分));
            assertThat(ichiranEntity.get作成区分コード(), is(作成区分コード));
            assertThat(ichiranEntity.get作成区分(), is(作成区分));
            assertThat(ichiranEntity.get被保険者番号(), is(被保険者番号));
            assertThat(ichiranEntity.get被保険者氏名(), is(被保険者氏名));
            assertThat(ichiranEntity.get作成種別区分コード(), is(作成種別区分コード));
            assertThat(ichiranEntity.get作成種別区分(), is(作成種別区分));
            assertThat(ichiranEntity.get要介護状態区分コード(), is(要介護状態区分コード));
            assertThat(ichiranEntity.get要介護状態区分(), is(要介護状態区分));
            assertThat(ichiranEntity.get限度額管理期間_開始(), is(限度額管理期間_開始));
            assertThat(ichiranEntity.get限度額管理期間_終了(), is(限度額管理期間_終了));
            assertThat(ichiranEntity.get区分支給限度基準額(), is(区分支給限度基準額));
            assertThat(ichiranEntity.get指定サービス単位(), is(指定サービス単位));
            assertThat(ichiranEntity.get基準該当サービス単位(), is(基準該当サービス単位));
            assertThat(ichiranEntity.get合計単位(), is(合計単位));
            assertThat(ichiranEntity.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(ichiranEntity.get備考(), is(備考));

            ichiranEntity = entityList.get(1);
            assertThat(ichiranEntity.get連番(), is(new RString("2")));
            assertThat(ichiranEntity.get計画作成区分コード(), is(RString.EMPTY));
            assertThat(ichiranEntity.get計画作成区分(), is(RString.EMPTY));
            assertThat(ichiranEntity.get作成区分コード(), is(RString.EMPTY));
            assertThat(ichiranEntity.get作成区分(), is(RString.EMPTY));
            assertThat(ichiranEntity.get作成種別区分コード(), is(RString.EMPTY));
            assertThat(ichiranEntity.get作成種別区分(), is(RString.EMPTY));
            assertThat(ichiranEntity.get区分支給限度基準額(), is(new RString("-1,000")));
            assertThat(ichiranEntity.get指定サービス単位(), is(new RString("-2,000")));
            assertThat(ichiranEntity.get基準該当サービス単位(), is(new RString("-3,000")));
            assertThat(ichiranEntity.get合計単位(), is(new RString("-4,000")));
            assertThat(ichiranEntity.get備考(), is(支援事業者未登録));

            ichiranEntity = entityList.get(2);
            assertThat(ichiranEntity.get連番(), is(new RString("3")));
            assertThat(ichiranEntity.get指定サービス単位(), is(RString.EMPTY));
            assertThat(ichiranEntity.get基準該当サービス単位(), is(RString.EMPTY));

            KyufuKanrihyoInKekkaEntity kekkaEntity = readKekkaCsvFile(result);
            assertThat(kekkaEntity.get作成日付(), is(作成日付));
            assertThat(kekkaEntity.get作成時間().length(), is(8));
            assertThat(kekkaEntity.get作成時間().substring(2, 3), is(new RString(":")));
            assertThat(kekkaEntity.get作成時間().substring(5, 6), is(new RString(":")));
            assertThat(kekkaEntity.get訪問通所サービス件数(), is(new RString("1")));
            assertThat(kekkaEntity.get短期入所サービス件数(), is(new RString("2")));
            assertThat(kekkaEntity.get居宅サービス件数(), is(new RString("3")));
            assertThat(kekkaEntity.get合計件数(), is(new RString("6")));
        }
    }

    private static List<KyufuKanrihyoInIchiRanEntity> readIchiRanCsvFile(_StepResult result) {
        RString filePath = result.getValue(RString.class, KyufuKanrihyoInBatchRegistCsvOutputProcess.OUTPUT_PARAM_KEY_一覧ファイル);
        CsvReader csvReader = createCsvReader(filePath, KyufuKanrihyoInIchiRanEntity.class);
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

    private static KyufuKanrihyoInKekkaEntity readKekkaCsvFile(_StepResult result) {
        RString filePath = result.getValue(RString.class, KyufuKanrihyoInBatchRegistCsvOutputProcess.OUTPUT_PARAM_KEY_結果ファイル);
        CsvReader csvReader = createCsvReader(filePath, KyufuKanrihyoInKekkaEntity.class);
        KyufuKanrihyoInKekkaEntity entity = (KyufuKanrihyoInKekkaEntity) csvReader.readLine();
        csvReader.close();
        return entity;
    }

    private static CsvReader createCsvReader(RString filePath, Class entity) {
        return new CsvReader.InstanceBuilder(filePath, entity)
                .setDelimiter(new RString(","))
                .setEnclosure(new RString("\""))
                .setEncode(Encode.UTF_8)
                .hasHeader(true)
                .build();
    }

    private static void createTempTable() {
        IBatchTableWriter<DbTKyufukanrihyoDataTempTableEntity> writer
                = BatchWriters.batchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.class)
                .tempTableName(一時テーブル)
                .build();
        _BatchProcessChunkQueryExecutor chunkQueryExecutor = new _BatchProcessChunkQueryExecutor(sqlSession);
//UZのインターフェースからメソッドが消えている模様。
//        writer.setChunkQueryExecuter(sqlSession, chunkQueryExecutor);
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
        entity.setKyufukanrihyoMeisaigyoNo(明細行);
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
        sqlParameter.put(KyufuKanrihyoInBatchRegistCsvOutputProcess.INPUT_PARAM_KEY_出力順ID, 1L);
        return sqlParameter;
    }
}
