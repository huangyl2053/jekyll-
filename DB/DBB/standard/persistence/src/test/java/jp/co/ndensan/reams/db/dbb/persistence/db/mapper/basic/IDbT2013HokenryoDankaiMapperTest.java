/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT2013HokenryoDankaiMapper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
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
 * {@link IDbT2013HokenryoDankaiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2013HokenryoDankaiMapperTest extends DbbTestDacBase {

    private static DbT2013HokenryoDankaiEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2013HokenryoDankaiDac dac;
    private static IDbT2013HokenryoDankaiMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2013HokenryoDankaiEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
            sut = sqlSession.getMapper(IDbT2013HokenryoDankaiMapper.class);
            entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しく段階インデックスされている() {
            assertThat(sut.getEntity().getDankaiIndex(), is(entity.getDankaiIndex()));
        }

        @Test
        public void 正しくランク区分されている() {
            assertThat(sut.getEntity().getRankuKubun(), is(entity.getRankuKubun()));
        }

        @Test
        public void 正しく段階区分されている() {
            assertThat(sut.getEntity().getDankaiKubun(), is(entity.getDankaiKubun()));
        }

        @Test
        public void 正しく保険料率されている() {
            assertThat(sut.getEntity().getHokenryoRitsu(), is(entity.getHokenryoRitsu()));
        }

        @Test
        public void 正しく特例表記されている() {
            assertThat(sut.getEntity().getTokureiHyoki(), is(entity.getTokureiHyoki()));
        }
    }

}
