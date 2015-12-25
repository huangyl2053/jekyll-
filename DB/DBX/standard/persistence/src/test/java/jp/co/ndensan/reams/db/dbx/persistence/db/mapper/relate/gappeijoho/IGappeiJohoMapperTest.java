/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.gappeijoho;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link  IGappeiJohoMapper}のテストです。
 */
@RunWith(Enclosed.class)
public class IGappeiJohoMapperTest {

    public IGappeiJohoMapperTest() {
    }

    public static class canCreateInstance extends DbxTestDacBase {

        private static DbTestHelper dbTestHelper;

        @BeforeClass
        public static void setUpClass() {
            dbTestHelper = new DbTestHelper();
            DbxTestDacBase.setUpClassInternal();
        }

        @Test
        public void インスタンスが生成できる() {
            sqlSession.getMapper(IGappeiJohoMapper.class);
        }
    }
}
