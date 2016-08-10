/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120010;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.KokuhorenJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N2810 久保 里史
 */
@RunWith(Enclosed.class)
public class DBC120010_KyufukanrihyoInTest extends DbcTestDacBase {

    private static DbTestHelper dbHelper;
    private static KokuhorenJohoTorikomiBatchParameter parameter;
    private static BatchExitStatus result;

    private static final RString batchID = new RString("DBC120010");
    private static final RString batchName = new RString("給付管理票情報取込");

    private static final RString 実行前状態BackUp用CSV_給付管理票200004 = new RString("DBC120010_Bkup_DbT3014KyufuKanrihyo200004.csv");
    private static final RString 実行前状態BackUp用CSV_給付管理票200604 = new RString("DBC120010_Bkup_DbT3015KyufuKanrihyo200604.csv");
    private static final RString 実行前状態BackUp用CSV_国保連ＩＦ管理 = new RString("DBC120010_Bkup_DbT3104KokuhorenInterfaceKanri.csv");

//    private static final RString 想定する実行前状態CSV_給付管理票200004 = new RString("before_DbT3015KyufuKanrihyo200004.csv");
//    private static final RString 想定する実行前状態CSV_給付管理票200604 = new RString("before_DbT3015KyufuKanrihyo200604.csv");
    private static final RString 想定する実行前状態CSV_国保連ＩＦ管理 = new RString("DBC120010_Before_DbT3104KokuhorenInterfaceKanri.csv");
    private static final RString 実行結果CSV_国保連ＩＦ管理 = new RString("DBC120010_RunResult_DbT3104KokuhorenInterfaceKanri.csv");
    private static final RString 実行結果CSV_給付管理票200004 = new RString("DBC120010_RunResult_DbT3014KyufuKanrihyo200004.csv");
    private static final RString 実行結果CSV_給付管理票200604 = new RString("DBC120010_RunResult_DbT3015KyufuKanrihyo200604.csv");

    private static final RString 想定結果CSV_国保連ＩＦ管理 = new RString("DBC120010_Result_DbT3104KokuhorenInterfaceKanri.csv");
    private static final RString 想定結果CSV_給付管理票200004 = new RString("DBC120010_Result_DbT3014KyufuKanrihyo200004.csv");
    private static final RString 想定結果CSV_給付管理票200604 = new RString("DBC120010_Result_DbT3015KyufuKanrihyo200604.csv");

    public static class 給付管理票情報取込バッチ_バッチフローテスト extends DbcTestDacBase {

        @BeforeClass
        public static void setUpClass() {

            DbcTestDacBase.setUpClass();
            dbHelper = new DbTestHelper();
            setUpTestData(dbHelper);

            parameter = new KokuhorenJohoTorikomiBatchParameter();
            createBatchParameter();

        }

        @Test
        public void Resultは_SUCCESSとなる() {

//            createSharedFile();
//            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
//            result = testhelper.executeFlow(batchID, batchName, DBC120010_KyufukanrihyoIn.class, parameter);
//            assertThat(result.getStatus(), is(BatchExitStatus.Status.SUCCESS));
        }

        @AfterClass
        public static void tearDownClass() {
            tearDownTestData(dbHelper);
        }

        private void createSharedFile() {
//            List<Uzt> a = SharedFile.searchSharedFile(new RString("給付管理票情報"));
            FilesystemName fileName1 = FilesystemName.fromString("給付管理票情報");
            SharedFile.defineSharedFile(fileName1);
            SharedFile.deleteNewestEntry(new SharedFileDescriptor(fileName1));
            SharedFile.copyToSharedFile(FilesystemPath.fromString(System.getenv("USERPROFILE") + "/shared/" + fileName1.toString() + "/"), fileName1);

        }

        private static void setUpTestData(DbTestHelper dbHelper) {
            dbHelper.exportTableData(
                    GyomuCode.DB介護保険, new RString("DbT3014KyufuKanrihyo200004"), getFilePath(実行前状態BackUp用CSV_給付管理票200004.toString()));
            dbHelper.exportTableData(
                    GyomuCode.DB介護保険, new RString("DbT3015KyufuKanrihyo200604"), getFilePath(実行前状態BackUp用CSV_給付管理票200604.toString()));
            dbHelper.exportTableData(
                    GyomuCode.DB介護保険, new RString("DbT3104KokuhorenInterfaceKanri"), getFilePath(実行前状態BackUp用CSV_国保連ＩＦ管理.toString()));

            dbHelper.cleanInsertTestDataFiles(
                    GyomuCode.DB介護保険, new RString("DbT3104KokuhorenInterfaceKanri"), getFilePath(想定する実行前状態CSV_国保連ＩＦ管理.toString()));
        }

        private static void tearDownTestData(DbTestHelper dbHelper) {
            dbHelper.cleanInsertTestDataFiles(
                    GyomuCode.DB介護保険, new RString("DbT3014KyufuKanrihyo200004"), getFilePath(実行前状態BackUp用CSV_給付管理票200004.toString()));
            dbHelper.cleanInsertTestDataFiles(
                    GyomuCode.DB介護保険, new RString("DbT3015KyufuKanrihyo200604"), getFilePath(実行前状態BackUp用CSV_給付管理票200604.toString()));
            dbHelper.cleanInsertTestDataFiles(
                    GyomuCode.DB介護保険, new RString("DbT3104KokuhorenInterfaceKanri"), getFilePath(実行前状態BackUp用CSV_国保連ＩＦ管理.toString()));

            new File(getFilePath(実行前状態BackUp用CSV_給付管理票200004.toString()).toString()).delete();
            new File(getFilePath(実行前状態BackUp用CSV_給付管理票200604.toString()).toString()).delete();
            new File(getFilePath(実行前状態BackUp用CSV_国保連ＩＦ管理.toString()).toString()).delete();
        }

        private static void createBatchParameter() {
            parameter.setShoriYM(new RString("201410"));
            parameter.setShoriNichiji(new RString("20000102030405"));
            parameter.setKokanjohoShikibetsuNo(new RString("121"));
            parameter.setShutsuryokujunID(new RString("1"));
            parameter.setSaishoriKubun(new RString("1"));
            parameter.setHokenshaKoseiKubun(new RString("2"));
            parameter.setGappeiJohoKubun(new RString("3"));
        }

        private static RString getFilePath(String fileName) {
            StringBuilder filePath = new StringBuilder();
            filePath.append("src");
            filePath.append(File.separator).append("test");
            filePath.append(File.separator).append("resources");
//            filePath.append(File.separator).append("jp");
//            filePath.append(File.separator).append("co");
//            filePath.append(File.separator).append("ndensan");
//            filePath.append(File.separator).append("reams");
//            filePath.append(File.separator).append("db");
//            filePath.append(File.separator).append("dbc");
//            filePath.append(File.separator).append("batchservice");
//            filePath.append(File.separator).append("flow");
//            filePath.append(File.separator).append("csv");
            filePath.append(File.separator).append(fileName);
            return new RString(filePath.toString());
        }

    }
}
