/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2008ShotokuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2008ShotokuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IDbT2008ShotokuMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IDbT2008ShotokuMapperTest extends DbbTestDacBase {

    private static DbT2008ShotokuEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2008ShotokuDac dac;
    private static IDbT2008ShotokuKanriMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2008ShotokuEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2008ShotokuDac.class);
            sut = sqlSession.getMapper(IDbT2008ShotokuKanriMapper.class);
            entity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく所得年度されている() {
            assertThat(sut.getEntity().getShotokuNendo(), is(entity.getShotokuNendo()));
        }

        @Test
        public void 正しく識別コードされている() {
            assertThat(sut.getEntity().getShikibetsuCode(), is(entity.getShikibetsuCode()));
        }

        @Test
        public void 正しく履歴番号されている() {
            assertThat(sut.getEntity().getRirekiNo(), is(entity.getRirekiNo()));
        }

        @Test
        public void 正しく非課税区分_住民税減免前_されている() {
            assertThat(sut.getEntity().getHiKazeiKubun(), is(entity.getHiKazeiKubun()));
        }

        @Test
        public void 正しく非課税区分_住民税減免後_されている() {
            assertThat(sut.getEntity().getHiKazeiKubunGemmenGo(), is(entity.getHiKazeiKubunGemmenGo()));
        }

        @Test
        public void 正しく合計所得金額されている() {
            assertThat(sut.getEntity().getGokeiShotokuGaku(), is(entity.getGokeiShotokuGaku()));
        }

        @Test
        public void 正しく公的年金収入額されている() {
            assertThat(sut.getEntity().getNenkiniShunyuGaku(), is(entity.getNenkiniShunyuGaku()));
        }

        @Test
        public void 正しく激変緩和措置区分されている() {
            assertThat(sut.getEntity().getGekihenKanwaKubun(), is(entity.getGekihenKanwaKubun()));
        }
    }

}
