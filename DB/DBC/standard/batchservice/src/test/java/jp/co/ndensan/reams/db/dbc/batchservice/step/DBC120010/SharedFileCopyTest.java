/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KyufuKanrihyoInBatchRegistTempSaveProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.SharedFileCopy;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SearchSharedFileOpts;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.flow._StepResult;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N2810 久保 里史
 */
@RunWith(Enclosed.class)
public class SharedFileCopyTest extends DbcTestDacBase {

    public static class Test_SharedFileCopyTest extends DbcTestDacBase {

        @Test
        public void SharedFileCopyのテスト() {
//            CreateSharedFile();
            _StepResult result = BatchProcessTestHelper.execute(SharedFileCopy.class, createBatchParameter(), DbcTestDacBase.sqlSession);
//            result.getValue(result, RString.EMPTY);
//
//            assertThat(result. is("1"));

        }

        private void CreateSharedFile() {
            FilesystemName fileName1 = FilesystemName.fromString("112000");
            FilesystemName fileName2 = FilesystemName.fromString("112001");

            SharedFile.defineSharedFile(fileName1);
            SharedFile.defineSharedFile(fileName2);
            SharedFile.copyToSharedFile(FilesystemPath.fromString(System.getenv("USERPROFILE").replace('\\', '/') + fileName1.toString() + "/"), fileName1);
            SharedFile.copyToSharedFile(FilesystemPath.fromString(System.getenv("USERPROFILE").replace('\\', '/') + fileName2.toString() + "/"), fileName2);
        }

        private HashMap<RString, Object> createBatchParameter() {
            HashMap<RString, Object> processParameter = new HashMap<>();
            processParameter.put(SharedFileCopy.PARAMETER_IN_FILEPATH, new RString(System.getenv("USERPROFILE").replace('\\', '/') + "/shared/test/"));
            processParameter.put(SharedFileCopy.PARAMETER_IN_SHAREDNAME, new RString("121"));
            processParameter.put(SharedFileCopy.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);
            return processParameter;
        }

    }
}
