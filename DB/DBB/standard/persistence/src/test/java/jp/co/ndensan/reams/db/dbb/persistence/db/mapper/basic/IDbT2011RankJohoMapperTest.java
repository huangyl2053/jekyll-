/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2011RankJohoDac;
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
 * {@link IDbT2011RankJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2011RankJohoMapperTest extends DbbTestDacBase {

    private static DbT2011RankJohoEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2011RankJohoDac dac;
    private static IDbT2011RankJohoMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2011RankJohoEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2011RankJohoDac.class);
            sut = sqlSession.getMapper(IDbT2011RankJohoMapper.class);
            entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しくランク区分されている() {
            assertThat(sut.getEntity().getRankKubun(), is(entity.getRankKubun()));
        }

        @Test
        public void 正しくランク名称されている() {
            assertThat(sut.getEntity().getRankName(), is(entity.getRankName()));
        }
    }

}
