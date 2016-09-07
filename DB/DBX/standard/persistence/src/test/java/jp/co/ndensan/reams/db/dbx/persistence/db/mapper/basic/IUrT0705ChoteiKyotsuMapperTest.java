/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.UrT0705ChoteiKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.UrT0705ChoteiKyotsuDac;
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
 * {@link IUrT0705ChoteiKyotsuMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IUrT0705ChoteiKyotsuMapperTest extends DbxTestDacBase {

    private static UrT0705ChoteiKyotsuEntity entity;
    private static DbTestHelper dbTestHelper;
    private static UrT0705ChoteiKyotsuDac dac;
    private static IUrT0705ChoteiKyotsuMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, UrT0705ChoteiKyotsuEntity.TABLE_NAME);
            dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
            sut = sqlSession.getMapper(IUrT0705ChoteiKyotsuMapper.class);
            entity = UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity();
            dac.insert(entity);
        }

        @Test
        public void 正しくChoteiIdされている() {
            assertThat(sut.getEntity().getChoteiId(), is(entity.getChoteiId()));
        }

        @Test
        public void 正しくShunoIdされている() {
            assertThat(sut.getEntity().getShunoId(), is(entity.getShunoId()));
        }

        @Test
        public void 正しくKaikeiNendoされている() {
            assertThat(sut.getEntity().getKaikeiNendo(), is(entity.getKaikeiNendo()));
        }

        @Test
        public void 正しくShoriNendoされている() {
            assertThat(sut.getEntity().getShoriNendo(), is(entity.getShoriNendo()));
        }

        @Test
        public void 正しくShoriNoされている() {
            assertThat(sut.getEntity().getShoriNo(), is(entity.getShoriNo()));
        }

        @Test
        public void 正しくKoseiKaisuされている() {
            assertThat(sut.getEntity().getKoseiKaisu(), is(entity.getKoseiKaisu()));
        }

        @Test
        public void 正しくChoteiJiyuCodeされている() {
            assertThat(sut.getEntity().getChoteiJiyuCode(), is(entity.getChoteiJiyuCode()));
        }

        @Test
        public void 正しくChoteiYMDされている() {
            assertThat(sut.getEntity().getChoteiYMD(), is(entity.getChoteiYMD()));
        }

        @Test
        public void 正しくChoteigakuされている() {
            assertThat(sut.getEntity().getChoteigaku(), is(entity.getChoteigaku()));
        }

        @Test
        public void 正しくShohizeiされている() {
            assertThat(sut.getEntity().getShohizei(), is(entity.getShohizei()));
        }

        @Test
        public void 正しくNokigenYMDされている() {
            assertThat(sut.getEntity().getNokigenYMD(), is(entity.getNokigenYMD()));
        }

        @Test
        public void 正しくHoteiNokigenToYMDされている() {
            assertThat(sut.getEntity().getHoteiNokigenToYMD(), is(entity.getHoteiNokigenToYMD()));
        }

        @Test
        public void 正しくfukaShoriJokyoされている() {
            assertThat(sut.getEntity().getFukaShoriJokyo(), is(entity.getFukaShoriJokyo()));
        }
    }

}
