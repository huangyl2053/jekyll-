/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2012HokenryoRankDac;
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
 * {@link IDbT2012HokenryoRankMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2012HokenryoRankMapperTest extends DbbTestDacBase {

    private static DbT2012HokenryoRankEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2012HokenryoRankDac dac;
    private static IDbT2012HokenryoRankMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2012HokenryoRankEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
            sut = sqlSession.getMapper(IDbT2012HokenryoRankMapper.class);
            entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しく市町村コードされている() {
            assertThat(sut.getEntity().getShichosonCode(), is(entity.getShichosonCode()));
        }

        @Test
        public void 正しくランク区分されている() {
            assertThat(sut.getEntity().getRankKubun(), is(entity.getRankKubun()));
        }

        @Test
        public void 正しく遡及年度されている() {
            assertThat(sut.getEntity().getSokyuNendo(), is(entity.getSokyuNendo()));
        }
    }

}
