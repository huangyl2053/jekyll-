/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbTKyufuInCtrlTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.CsvFileMatcher;
import jp.co.ndensan.reams.uz.uza.testhelper.CsvFileOption;
import jp.co.ndensan.reams.uz.uza.testhelper.CsvIgnoreColumns;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
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
public class KyufuKanrihyoInBatchRegistTempSaveProcessTest extends DbcTestDacBase {

    public static class Test_KyufuKanrihyoInBatchRegistTempSaveProcess extends DbcTestDacBase {

        private static DbTestHelper dbHelper;
//        private static final RString 実行前状態BackUp用CSV_国保連ＩＦ管理 = new RString("bkup_KokuhorenIFUpdateCtrlRecordProcess_DbT3104KokuhorenInterfaceKanri.csv");
//        private static final RString 実行前状態BackUp用CSV_給付取込コントロールレコード = new RString("bkup_KokuhorenIFUpdateCtrlRecordProcess_DbTKyufuInCtrlTempTable.csv");
//        private static final RString 想定する実行前状態CSV_国保連ＩＦ管理 = new RString("before_KokuhorenIFUpdateCtrlRecordProcess_DbT3104KokuhorenInterfaceKanri.csv");
//        private static final RString 想定する実行前状態CSV_給付取込コントロールレコード = new RString("before_KokuhorenIFUpdateCtrlRecordProcess_DbTKyufuInCtrlTempTable.csv");
        private static final RString 実行結果CSV_コントロールレコード = new RString("KyufuKanrihyoInBatchRegistTempSaveProcess_RunResult_DbTKyufuInCtrlTempTable.csv");
        private static final RString 実行結果CSV_データレコード = new RString("KyufuKanrihyoInBatchRegistTempSaveProcess_RunResult_DbTKyufukanrihyoDataTempTable.csv");
        private static final RString 想定結果CSV_コントロールレコード = new RString("KyufuKanrihyoInBatchRegistTempSaveProcess_Result_DbTKyufuInCtrlTempTable.csv");
        private static final RString 想定結果CSV_データレコード = new RString("KyufuKanrihyoInBatchRegistTempSaveProcess_Result_DbTKyufukanrihyoDataTempTable.csv");

        @BeforeClass
        public static void setUpClass() {
            DbcTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
            setUpTestData(dbHelper);
        }

        @Test
        public void バッチ処理クラスを実行したとき_実行結果CSVは_想定結果CSVと一致する() {
            createTempTable();
            BatchProcessTestHelper.execute(KyufuKanrihyoInBatchRegistTempSaveProcess.class, createBatchParameter(), DbcTestDacBase.sqlSession);

            dbHelper.exportTableData(
                    DbcTestDacBase.sqlSession, DbTKyufuInCtrlTempTableEntity.TABLE_NAME, getFilePath(実行結果CSV_コントロールレコード.toString()));
            dbHelper.exportTableData(
                    DbcTestDacBase.sqlSession, DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, getFilePath(実行結果CSV_データレコード.toString()));

            File actualCtrl = new File(getFilePath(実行結果CSV_コントロールレコード.toString()).toString());
            File expectedCtrl = new File(getFilePath(想定結果CSV_コントロールレコード.toString()).toString());

            assertThat(actualCtrl, is(CsvFileMatcher.sameCsvFileOf(expectedCtrl, createCsvIgnoreColumunsCtrl(), createCsvFileOption())));

            File actualData = new File(getFilePath(実行結果CSV_データレコード.toString()).toString());
            File expectedData = new File(getFilePath(想定結果CSV_データレコード.toString()).toString());

            assertThat(actualData, is(CsvFileMatcher.sameCsvFileOf(expectedData, createCsvIgnoreColumunsData(), createCsvFileOption())));
        }

        private static void setUpTestData(DbTestHelper dbHelper) {

        }

        private HashMap<RString, Object> createBatchParameter() {

            HashMap<RString, Object> processParameter = new HashMap<>();

            processParameter.put(KyufuKanrihyoInBatchRegistTempSaveProcess.PARAMETER_FILEPATH, new RString("C:/Users/N2810/shared/out/1122new.csv"));

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

        private CsvIgnoreColumns createCsvIgnoreColumunsCtrl() {
            List<RString> ignoreFields = new ArrayList<>();
//            ignoreFields.add(new RString("insertTimestamp"));
//            ignoreFields.add(new RString("lastUpdateTimestamp"));
            return new CsvIgnoreColumns(DbTKyufuInCtrlTempTableEntity.class, ignoreFields);
        }

        private CsvIgnoreColumns createCsvIgnoreColumunsData() {
            List<RString> ignoreFields = new ArrayList<>();
//            ignoreFields.add(new RString("insertTimestamp"));
//            ignoreFields.add(new RString("lastUpdateTimestamp"));
            return new CsvIgnoreColumns(DbTKyufukanrihyoDataTempTableEntity.class, ignoreFields);
        }

        private CsvFileOption createCsvFileOption() {
            return new CsvFileOption(new RString(","), new RString("\""), Encode.UTF_8);
        }

        private static void createTempTable() {
            DbTKyufuInCtrlTempTableEntity ctrltemporayEntity = new DbTKyufuInCtrlTempTableEntity();
            dbHelper.createTempTable(sqlSession, DbTKyufuInCtrlTempTableEntity.TABLE_NAME, ctrltemporayEntity);
            DbTKyufukanrihyoDataTempTableEntity datatemporayEntity = new DbTKyufukanrihyoDataTempTableEntity();
            dbHelper.createTempTable(sqlSession, DbTKyufukanrihyoDataTempTableEntity.TABLE_NAME, datatemporayEntity);

        }

    }
}
