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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbTKyufuInCtrlTempTableEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
public class KokuhorenIFUpdateCtrlRecordProcessTest extends DbcTestDacBase {

    public static class Test_KokuhorenIFUpdateCtrlRecordProcess extends DbcTestDacBase {

        private static DbTestHelper dbHelper;
        private static final RString 実行前状態BackUp用CSV_国保連ＩＦ管理 = new RString("KokuhorenIFUpdateCtrlRecordProcess_Bkup_DbT3104KokuhorenInterfaceKanri.csv");
        private static final RString 実行前状態BackUp用CSV_給付取込コントロールレコード = new RString("KokuhorenIFUpdateCtrlRecordProcess_Bkup_DbTKyufuInCtrlTempTable.csv");
        private static final RString 想定する実行前状態CSV_国保連ＩＦ管理 = new RString("KokuhorenIFUpdateCtrlRecordProcess_Before_DbT3104KokuhorenInterfaceKanri.csv");
        private static final RString 想定する実行前状態CSV_給付取込コントロールレコード = new RString("KokuhorenIFUpdateCtrlRecordProcess_Before_DbTKyufuInCtrlTempTable.csv");
        private static final RString 実行結果CSV = new RString("KokuhorenIFUpdateCtrlRecordProcess_RunResult_DbT3104KokuhorenInterfaceKanri.csv");
        private static final RString 想定結果CSV = new RString("KokuhorenIFUpdateCtrlRecordProcess_Result_DbT3104KokuhorenInterfaceKanri.csv");

        private static final RString 一時テーブル = new RString("DbTKyufuInCtrlTempTable");

        @BeforeClass
        public static void setUpClass() {
            DbcTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
            setUpTestData(dbHelper);
        }

        @Test
        public void バッチ処理クラスを実行したとき_実行結果CSVは_想定結果CSVと一致する() {
            createTempTable();
            BatchProcessTestHelper.execute(KokuhorenIFUpdateCtrlRecordProcess.class, createBatchParameter(), DbcTestDacBase.sqlSession);

            dbHelper.exportTableData(
                    DbcTestDacBase.sqlSession, DbT3104KokuhorenInterfaceKanriEntity.TABLE_NAME, getFilePath(実行結果CSV.toString()));

            File actual = new File(getFilePath(実行結果CSV.toString()).toString());
            File expected = new File(getFilePath(想定結果CSV.toString()).toString());

            assertThat(actual, is(CsvFileMatcher.sameCsvFileOf(expected, createCsvIgnoreColumuns(), createCsvFileOption())));
        }

        private static void setUpTestData(DbTestHelper dbHelper) {
            dbHelper.exportTableData(
                    GyomuCode.DB介護保険, new RString("DbT3104KokuhorenInterfaceKanri"), getFilePath(実行前状態BackUp用CSV_国保連ＩＦ管理.toString()));
//            dbHelper.exportTableData(
//                    GyomuCode.DB介護保険, new RString("DbTKyufuInCtrlTempTable"), getFilePath(実行前状態BackUp用CSV_給付取込コントロールレコード.toString()));
            dbHelper.cleanInsertTestDataFiles(
                    GyomuCode.DB介護保険, new RString("DbT3104KokuhorenInterfaceKanri"), getFilePath(想定する実行前状態CSV_国保連ＩＦ管理.toString()));
//            dbHelper.cleanInsertTestDataFiles(
//                    GyomuCode.DB介護保険, new RString("DbTKyufuInCtrlTempTable"), getFilePath(想定する実行前状態CSV_給付取込コントロールレコード.toString()));
        }

        private HashMap<RString, Object> createBatchParameter() {

            HashMap<RString, Object> processParameter = new HashMap<>();

            processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_SHORIYM, new RString("201410"));
            processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_KOKANSHIKIBETSUNO, new RString("121"));
            processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_SHORINICHIJI, new RString("20150102030405"));
            processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_FILENAME, new RString("ファイル名"));

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

        private CsvIgnoreColumns createCsvIgnoreColumuns() {
            List<RString> ignoreFields = new ArrayList<>();
//            ignoreFields.add(new RString("insertTimestamp"));
//            ignoreFields.add(new RString("lastUpdateTimestamp"));
            return new CsvIgnoreColumns(DbT3104KokuhorenInterfaceKanriEntity.class, ignoreFields);
        }

        private CsvFileOption createCsvFileOption() {
            return new CsvFileOption(new RString(","), new RString("\""), Encode.UTF_8);
        }

        private static void createTempTable() {
            DbTKyufuInCtrlTempTableEntity temporayEntity = new DbTKyufuInCtrlTempTableEntity();
            dbHelper.createTempTable(sqlSession, DbTKyufuInCtrlTempTableEntity.TABLE_NAME, temporayEntity);
            dbHelper.cleanInsertTestDataFiles(
                    sqlSession, new RString("DbTKyufuInCtrlTempTable"), getFilePath(想定する実行前状態CSV_給付取込コントロールレコード.toString()));

        }

    }
}
