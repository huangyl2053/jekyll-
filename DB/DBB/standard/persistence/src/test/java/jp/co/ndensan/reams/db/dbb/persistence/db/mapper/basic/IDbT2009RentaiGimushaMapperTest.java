/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
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
 * {@link IDbT2009RentaiGimushaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2009RentaiGimushaMapperTest extends DbbTestDacBase {

    private static DbT2009RentaiGimushaEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2009RentaiGimushaDac dac;
    private static IDbT2009RentaiGimushaMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2009RentaiGimushaEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
            sut = sqlSession.getMapper(IDbT2009RentaiGimushaMapper.class);
            entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく被保険者番号されている() {
            assertThat(sut.getEntity().getHihokenshaNo(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void 正しく履歴番号されている() {
            assertThat(sut.getEntity().getRirekiNo(), is(entity.getRirekiNo()));
        }

        @Test
        public void 正しく識別コードされている() {
            assertThat(sut.getEntity().getShikibetuCode(), is(entity.getShikibetuCode()));
        }

        @Test
        public void 正しく開始年月日されている() {
            assertThat(sut.getEntity().getStartYMD(), is(entity.getStartYMD()));
        }

        @Test
        public void 正しく終了年月日されている() {
            assertThat(sut.getEntity().getEndYMD(), is(entity.getEndYMD()));
        }
    }

}
