/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7064CareManegerDac;
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
 * {@link IDbT7064CareManegerMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IDbT7064CareManegerMapperTest extends DbxTestDacBase {

    private static DbT7064CareManegerEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT7064CareManegerDac dac;
    private static IDbT7064CareManegerMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    @Ignore
    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7064CareManegerEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7064CareManegerDac.class);
            sut = sqlSession.getMapper(IDbT7064CareManegerMapper.class);
            entity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく介護支援専門員番号されている() {
            assertThat(sut.getEntity().getKaigoShienSenmoninNo(), is(entity.getKaigoShienSenmoninNo()));
        }

        @Test
        public void 正しく介護支援専門員名されている() {
            assertThat(sut.getEntity().getKaigoShienSenmoninMei(), is(entity.getKaigoShienSenmoninMei()));
        }

        @Test
        public void 正しく介護支援専門員名カナされている() {
            assertThat(sut.getEntity().getKaigoShienSenmoninMeiKana(), is(entity.getKaigoShienSenmoninMeiKana()));
        }

        @Test
        public void 正しく所属事業者番号されている() {
            assertThat(sut.getEntity().getShozokuJigyoshaNo(), is(entity.getShozokuJigyoshaNo()));
        }

        @Test
        public void 正しく有効開始年月日されている() {
            assertThat(sut.getEntity().getYukoKaishiDate(), is(entity.getYukoKaishiDate()));
        }

        @Test
        public void 正しく有効終了年月日されている() {
            assertThat(sut.getEntity().getYukoShuryoDate(), is(entity.getYukoShuryoDate()));
        }
    }

}
