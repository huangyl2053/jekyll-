/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
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
 * {@link IDbT2007KibetsuChoshuYuyoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2007KibetsuChoshuYuyoMapperTest extends DbbTestDacBase {

    private static DbT2007KibetsuChoshuYuyoEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2007KibetsuChoshuYuyoDac dac;
    private static IDbT2007KibetsuChoshuYuyoMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2007KibetsuChoshuYuyoEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
            sut = sqlSession.getMapper(IDbT2007KibetsuChoshuYuyoMapper.class);
            entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
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
            assertThat(sut.getEntity().getChoshuHoho(), is(entity.getChoshuHoho()));
        }

        @Test
        public void 正しく期されている() {
            assertThat(sut.getEntity().getKi(), is(entity.getKi()));
        }

        @Test
        public void 正しく徴収猶予開始日されている() {
            assertThat(sut.getEntity().getYuyoStartYMD(), is(entity.getYuyoStartYMD()));
        }

        @Test
        public void 正しく徴収猶予終了日されている() {
            assertThat(sut.getEntity().getYuyoEndYMD(), is(entity.getYuyoEndYMD()));
        }
    }

}
