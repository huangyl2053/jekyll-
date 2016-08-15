/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.flow._StepResult;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.CsvIgnoreColumns;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper._CsvDiffHelper;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N2810 久保 里史
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyoInBatchRegistFileReadProcessTest extends DbcTestDacBase {

    public static class Test_KyufuKanrihyoInBatchRegistFileReadProcess extends DbcTestDacBase {

        private static DbTestHelper dbHelper;
        private static final RString 実行前状態BackUp用CSV = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_Bkup_DbTKyufukanrihyoDataTempTable.csv");
        private static final RString 想定する実行前状態CSV = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_Before_DbTKyufukanrihyoDataTempTable.csv");

        private static final RString 実行結果CSV_給付管理票200004 = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_RunResult_DbT3014KyufuKanrihyo200004.csv");
        private static final RString 実行結果CSV_給付管理票200604 = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_RunResult_DbT3015KyufuKanrihyo200604.csv");
        private static final RString 想定結果CSV_給付管理票200004 = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_Result_DbT3014KyufuKanrihyo200004.csv");
        private static final RString 想定結果CSV_給付管理票200604 = new RString("KyufuKanrihyoInBatchRegistFileReadProcess_Result_DbT3015KyufuKanrihyo200604.csv");

        @BeforeClass
        public static void setUpClass() {
            DbcTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
            setUpTestData(dbHelper);
        }

        @Test
        public void バッチ処理クラスを実行したとき_実行結果CSVは_想定結果CSVと一致する() {
            createTempTable();
            _StepResult result
                    = BatchProcessTestHelper.execute(KyufuKanrihyoInBatchRegistFileReadProcess.class, createBatchParameter(), DbcTestDacBase.sqlSession);
            dbHelper.exportTableData(
                    DbcTestDacBase.sqlSession, DbT3014KyufuKanrihyo200004Entity.TABLE_NAME, getFilePath(実行結果CSV_給付管理票200004.toString()));
            dbHelper.exportTableData(
                    DbcTestDacBase.sqlSession, DbT3015KyufuKanrihyo200604Entity.TABLE_NAME, getFilePath(実行結果CSV_給付管理票200604.toString()));

            File actual200004 = new File(getFilePath(実行結果CSV_給付管理票200004.toString()).toString());
            File expected200004 = new File(getFilePath(想定結果CSV_給付管理票200004.toString()).toString());
            java.io.File res200004 = new java.io.File(getFilePath("result200004.txt").toString());

            List<String> colsToCompare200004 = Arrays.asList(new String[]{"shinsaYM", "serviceTeikyoYM", "shokisaiHokenshaNo", "kyotakushienJigyoshoNo", "kyufuKanrihyoSakuseiKubunCode", "kyufuKanrihyoSakuseiYMD", "kyufuKanrihyoShubetsuKubunCode", "kyufuKanrihyoMeisaiLineNo", "hokenshaNo", "hiHokenshaNo", "hiHokenshaUmareYMD", "seibetsuCode", "yoKaigoJotaiKubunCode", "gendogakuTekiyoKaishiYM", "gendogakuTekiyoShuryoYM", "kyotakuKaigoYoboShikyuGendogaku", "kyotakuServicePlanSakuseiKubunCode", "serviceJigyoshoNo", "shiteiKijungaitoChiikimitchakuServiceShikibetsuCode", "serviceShuruiCode", "kyufuKeikakuTanisuNissu", "kyufuKeikakuNissu", "shiteiServiceSubTotal", "kijyunGaitoServiceSubTotal", "kyufuKeikakuTotalTanisuNissu", "toshoTorokuYMD", "torikomiYM"});
            try {
                try (_CsvDiffHelper helper200004 = new _CsvDiffHelper(actual200004, expected200004)) {
                    long unMatchCount = helper200004.getResult(colsToCompare200004, res200004);
                    assertThat((int) unMatchCount, is(0));
                }
            } catch (Exception e) {
            }

//            assertThat(actual200004, is(CsvFileMatcher.sameCsvFileOf(expected200004, createCsvIgnoreColumuns200004(), createCsvFileOption())));
            File actual200604 = new File(getFilePath(実行結果CSV_給付管理票200604.toString()).toString());
            File expected200604 = new File(getFilePath(想定結果CSV_給付管理票200604.toString()).toString());
            java.io.File res200604 = new java.io.File(getFilePath("result200604.txt").toString());

            List<String> colsToCompare200604 = Arrays.asList(new String[]{"shinsaYM", "serviceTeikyoYM", "shokisaiHokenshaNo", "kyotakushienJigyoshoNo", "kyufuSakuseiKubunCode", "kyufuSakuseiYMD", "kyufuShubetsuKubunCode", "kyufuMeisaiLineNo", "hokenshaNo", "hiHokenshaNo", "hiHokenshaUmareYMD", "seibetsuCode", "yoKaigoJotaiKubunCode", "gendogakuTekiyoKaishiYM", "gendogakuTekiyoShuryoYM", "kyotakuKaigoYoboShikyuGendogaku", "kyotakuServicePlanSakuseiKubunCode", "serviceJigyoshoNo", "shiteiKijungaitoChiikimitchakuServiceShikibetsuCode", "serviceShuruiCode", "kyufuKeikakuTanisuNissu", "kyufuKeikakuNissu", "shiteiServiceSubTotal", "kijyunGaitoServiceSubTotal", "kyufuKeikakuTotalTanisuNissu", "tantoKaigoShienSemmoninNo", "kaigoShienJigyoshaNo", "itakusakiTantoKaigoShienSemmoninNo", "toshoTorokuYMD", "torikomiYM"});
            try {
                try (_CsvDiffHelper helper = new _CsvDiffHelper(actual200604, expected200604)) {
                    long unMatchCount = helper.getResult(colsToCompare200604, res200604);
                    assertThat((int) unMatchCount, is(0));
                }
            } catch (Exception e) {

            }

//            assertThat(actual200604, is(CsvFileMatcher.sameCsvFileOf(expected200604, createCsvIgnoreColumuns200604(), createCsvFileOption())));
        }

        private static void setUpTestData(DbTestHelper dbHelper) {
//            dbHelper.exportTableData(
//                    GyomuCode.DB介護保険, new RString("DbTKyufukanrihyoDataTempTable"), getFilePath(実行前状態BackUp用CSV.toString()));
//            dbHelper.cleanInsertTestDataFiles(
//                    GyomuCode.DB介護保険, new RString("DbTKyufukanrihyoDataTempTable"), getFilePath(想定する実行前状態CSV.toString()));
        }

        private HashMap<RString, Object> createBatchParameter() {
            HashMap<RString, Object> processParameter = new HashMap<>();
            processParameter.put(KyufuKanrihyoInBatchRegistFileReadProcess.PARAMETER_SHORINENGETSU, new RString("20141112010203"));
            return processParameter;
        }

        private static RString getFilePath(String fileName) {
            StringBuilder filePath = new StringBuilder();
            filePath.append("src");
            filePath.append(File.separator).append("test");
            filePath.append(File.separator).append("resources");
            filePath.append(File.separator).append("jp");
            filePath.append(File.separator).append("co");
            filePath.append(File.separator).append("ndensan");
            filePath.append(File.separator).append("reams");
            filePath.append(File.separator).append("db");
            filePath.append(File.separator).append("dbc");
            filePath.append(File.separator).append("batchservice");
            filePath.append(File.separator).append("step");
            filePath.append(File.separator).append("csv");
            filePath.append(File.separator).append(fileName);
            return new RString(filePath.toString());
        }

        private CsvIgnoreColumns createCsvIgnoreColumuns200004() {
            List<RString> ignoreFields = new ArrayList<>();
//            ignoreFields.add(new RString("insertTimestamp"));
//            ignoreFields.add(new RString("lastUpdateTimestamp"));
            return new CsvIgnoreColumns(DbT3014KyufuKanrihyo200004Entity.class, ignoreFields);
        }

        private CsvIgnoreColumns createCsvIgnoreColumuns200604() {
            List<RString> ignoreFields = new ArrayList<>();
//            ignoreFields.add(new RString("insertTimestamp"));
//            ignoreFields.add(new RString("lastUpdateTimestamp"));
            return new CsvIgnoreColumns(DbT3015KyufuKanrihyo200604Entity.class, ignoreFields);
        }

        private static void createTempTable() {
            DbTKyufukanrihyoDataTempTableEntity temporayEntity = new DbTKyufukanrihyoDataTempTableEntity();
            dbHelper.createTempTable(sqlSession, DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, temporayEntity);
            dbHelper.cleanInsertTestDataFiles(
                    sqlSession, new RString("DbTKyufukanrihyoDataTempTable"), getFilePath(想定する実行前状態CSV.toString()));
        }
    }
}
