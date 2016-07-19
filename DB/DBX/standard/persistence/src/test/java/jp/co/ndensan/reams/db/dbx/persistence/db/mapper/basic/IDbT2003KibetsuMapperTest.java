/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IDbT2003KibetsuMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2003KibetsuMapperTest extends DbxTestDacBase {

    private static DbT2003KibetsuEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2003KibetsuDac dac;
    private static IDbT2003KibetsuMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2003KibetsuEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2003KibetsuDac.class);
            sut = sqlSession.getMapper(IDbT2003KibetsuMapper.class);
            entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく調定年度されている() {
            assertThat(sut.getEntity().getChoteiNendo(), is(entity.getChoteiNendo()));
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しく通知書番号されている() {
            assertThat(sut.getEntity().getTsuchishoNo(), is(entity.getTsuchishoNo()));
        }

        @Test
        public void 正しく履歴番号されている() {
            assertThat(sut.getEntity().getRirekiNo(), is(entity.getRirekiNo()));
        }

        @Test
        public void 正しく徴収方法されている() {
            assertThat(sut.getEntity().getChoshuHouhou(), is(entity.getChoshuHouhou()));
        }

        @Test
        public void 正しく期されている() {
            assertThat(sut.getEntity().getKi(), is(entity.getKi()));
        }

        @Test
        public void 正しく調定IDされている() {
            assertThat(sut.getEntity().getChoteiId(), is(entity.getChoteiId()));
        }
    }

}
