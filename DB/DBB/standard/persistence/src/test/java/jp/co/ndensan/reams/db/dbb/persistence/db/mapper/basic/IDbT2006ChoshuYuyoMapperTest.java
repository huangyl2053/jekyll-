/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
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
 * {@link IDbT2006ChoshuYuyoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2006ChoshuYuyoMapperTest extends DbbTestDacBase {

    private static DbT2006ChoshuYuyoEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2006ChoshuYuyoDac dac;
    private static IDbT2006ChoshuYuyoMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2006ChoshuYuyoEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
            sut = sqlSession.getMapper(IDbT2006ChoshuYuyoMapper.class);
            entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
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
        public void 正しく徴収猶予申請年月日されている() {
            assertThat(sut.getEntity().getShinseiYMD(), is(entity.getShinseiYMD()));
        }

        @Test
        public void 正しく徴収猶予決定年月日されている() {
            assertThat(sut.getEntity().getKetteiYMD(), is(entity.getKetteiYMD()));
        }

        @Test
        public void 正しく徴収猶予取消年月日されている() {
            assertThat(sut.getEntity().getTorikeshiYMD(), is(entity.getTorikeshiYMD()));
        }

        @Test
        public void 正しく徴収猶予状態区分されている() {
            assertThat(sut.getEntity().getJotaiKubun(), is(entity.getJotaiKubun()));
        }

        @Test
        public void 正しく徴収猶予作成区分されている() {
            assertThat(sut.getEntity().getSakuseiKubun(), is(entity.getSakuseiKubun()));
        }

        @Test
        public void 正しく申請事由されている() {
            assertThat(sut.getEntity().getShinseiJiyu(), is(entity.getShinseiJiyu()));
        }

        @Test
        public void 正しく徴収猶予種類コードされている() {
            assertThat(sut.getEntity().getYuyoJiyuCode(), is(entity.getYuyoJiyuCode()));
        }

        @Test
        public void 正しく徴収猶予事由されている() {
            assertThat(sut.getEntity().getYuyoJiyu(), is(entity.getYuyoJiyu()));
        }

        @Test
        public void 正しく徴収猶予取消種類コードされている() {
            assertThat(sut.getEntity().getYuyoTorikeshiJiyuCode(), is(entity.getYuyoTorikeshiJiyuCode()));
        }

        @Test
        public void 正しく徴収猶予取消事由されている() {
            assertThat(sut.getEntity().getYuyoTorikeshiJiyu(), is(entity.getYuyoTorikeshiJiyu()));
        }
    }

}
