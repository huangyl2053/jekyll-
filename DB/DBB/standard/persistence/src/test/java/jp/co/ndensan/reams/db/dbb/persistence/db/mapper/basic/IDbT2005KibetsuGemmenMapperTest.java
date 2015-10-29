/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2005KibetsuGemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2005KibetsuGemmenEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2005KibetsuGemmenDac;
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
 * {@link IDbT2005KibetsuGemmenMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IDbT2005KibetsuGemmenMapperTest extends DbbTestDacBase {

    private static DbT2005KibetsuGemmenEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2005KibetsuGemmenDac dac;
    private static IDbT2005KibetsuGemmenMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2005KibetsuGemmenEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2005KibetsuGemmenDac.class);
            sut = sqlSession.getMapper(IDbT2005KibetsuGemmenMapper.class);
            entity = DbT2005KibetsuGemmenEntityGenerator.createDbT2005KibetsuGemmenEntity();
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
        public void 正しく処理日時されている() {
            assertThat(sut.getEntity().getShoriTimestamp(), is(entity.getShoriTimestamp()));
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
        public void 正しく減免前期別介護保険料されている() {
            assertThat(sut.getEntity().getGemmenMaeKibetsuGaku(), is(entity.getGemmenMaeKibetsuGaku()));
        }

        @Test
        public void 正しく期別減免額されている() {
            assertThat(sut.getEntity().getKibetsugemmenGaku(), is(entity.getKibetsugemmenGaku()));
        }
    }

}
