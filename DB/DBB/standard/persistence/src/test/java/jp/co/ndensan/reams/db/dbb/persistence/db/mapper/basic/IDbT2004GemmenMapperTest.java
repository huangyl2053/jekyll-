/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
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
 * {@link IDbT2004GemmenMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2004GemmenMapperTest extends DbbTestDacBase {

    private static DbT2004GemmenEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2004GemmenDac dac;
    private static IDbT2004GemmenMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2004GemmenEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2004GemmenDac.class);
            sut = sqlSession.getMapper(IDbT2004GemmenMapper.class);
            entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
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
        public void 正しく減免申請日されている() {
            assertThat(sut.getEntity().getShinseiYMD(), is(entity.getShinseiYMD()));
        }

        @Test
        public void 正しく減免決定日されている() {
            assertThat(sut.getEntity().getKetteiYMD(), is(entity.getKetteiYMD()));
        }

        @Test
        public void 正しく減免取消日されている() {
            assertThat(sut.getEntity().getTorikeshiYMD(), is(entity.getTorikeshiYMD()));
        }

        @Test
        public void 正しく減免状態区分されている() {
            assertThat(sut.getEntity().getJotaiKubun(), is(entity.getJotaiKubun()));
        }

        @Test
        public void 正しく減免作成区分されている() {
            assertThat(sut.getEntity().getSakuseiKubun(), is(entity.getSakuseiKubun()));
        }

        @Test
        public void 正しく申請事由されている() {
            assertThat(sut.getEntity().getShinseiJiyu(), is(entity.getShinseiJiyu()));
        }

        @Test
        public void 正しく減免種類コードされている() {
            assertThat(sut.getEntity().getGemmenJiyuCode(), is(entity.getGemmenJiyuCode()));
        }

        @Test
        public void 正しく減免事由されている() {
            assertThat(sut.getEntity().getGemmenJiyu(), is(entity.getGemmenJiyu()));
        }

        @Test
        public void 正しく減免取消種類コードされている() {
            assertThat(sut.getEntity().getGemmenTorikeshiJiyuCode(), is(entity.getGemmenTorikeshiJiyuCode()));
        }

        @Test
        public void 正しく減免取消事由されている() {
            assertThat(sut.getEntity().getGemmenTorikeshiJiyu(), is(entity.getGemmenTorikeshiJiyu()));
        }

        @Test
        public void 正しく申請減免額されている() {
            assertThat(sut.getEntity().getShinseiGemmenGaku(), is(entity.getShinseiGemmenGaku()));
        }

        @Test
        public void 正しく決定減免額されている() {
            assertThat(sut.getEntity().getKetteiGemmenGaku(), is(entity.getKetteiGemmenGaku()));
        }

        @Test
        public void 正しく取消減免額されている() {
            assertThat(sut.getEntity().getTorikeshiGemmenGaku(), is(entity.getTorikeshiGemmenGaku()));
        }
    }

}
