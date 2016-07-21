/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
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
 * {@link IDbT7130KaigoServiceShuruiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IDbT7130KaigoServiceShuruiMapperTest extends DbxTestDacBase {

    private static DbT7130KaigoServiceShuruiEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT7130KaigoServiceShuruiDac dac;
    private static IDbT7130KaigoServiceShuruiMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    @Ignore
    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7130KaigoServiceShuruiEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
            sut = sqlSession.getMapper(IDbT7130KaigoServiceShuruiMapper.class);
            entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくサービス種類コードされている() {
            assertThat(sut.getEntity().getServiceShuruiCd(), is(entity.getServiceShuruiCd()));
        }

        @Test
        public void 正しく提供開始年月されている() {
            assertThat(sut.getEntity().getTeikyoKaishiYM(), is(entity.getTeikyoKaishiYM()));
        }

        @Test
        public void 正しく提供終了年月されている() {
            assertThat(sut.getEntity().getTeikyoshuryoYM(), is(entity.getTeikyoshuryoYM()));
        }

        @Test
        public void 正しくサービス種類名称されている() {
            assertThat(sut.getEntity().getServiceShuruiMeisho(), is(entity.getServiceShuruiMeisho()));
        }

        @Test
        public void 正しくサービス種類略称されている() {
            assertThat(sut.getEntity().getServiceShuruiRyakusho(), is(entity.getServiceShuruiRyakusho()));
        }

        @Test
        public void 正しくサービス分類コードされている() {
            assertThat(sut.getEntity().getServiceBunrruicode(), is(entity.getServiceBunrruicode()));
        }
    }

}
