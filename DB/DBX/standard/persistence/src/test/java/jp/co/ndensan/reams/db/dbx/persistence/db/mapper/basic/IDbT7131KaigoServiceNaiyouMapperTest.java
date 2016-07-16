/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
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
 * {@link IDbT7131KaigoServiceNaiyouMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IDbT7131KaigoServiceNaiyouMapperTest extends DbxTestDacBase {

    private static DbT7131KaigoServiceNaiyouEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT7131KaigoServiceNaiyouDac dac;
    private static IDbT7131KaigoServiceNaiyouMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    @Ignore
    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7131KaigoServiceNaiyouEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
            sut = sqlSession.getMapper(IDbT7131KaigoServiceNaiyouMapper.class);
            entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくサービス種類コードされている() {
            assertThat(sut.getEntity().getServiceShuruiCd(), is(entity.getServiceShuruiCd()));
        }

        @Test
        public void 正しくサービス項目コードされている() {
            assertThat(sut.getEntity().getServiceKoumokuCd(), is(entity.getServiceKoumokuCd()));
        }

        @Test
        public void 正しく提供開始年月されている() {
            assertThat(sut.getEntity().getTeikyoKaishiYM(), is(entity.getTeikyoKaishiYM()));
        }

        @Test
        public void 正しく履歴番号されている() {
            assertThat(sut.getEntity().getRirekiNo(), is(entity.getRirekiNo()));
        }

        @Test
        public void 正しく提供終了年月されている() {
            assertThat(sut.getEntity().getTeikyoShuryoYM(), is(entity.getTeikyoShuryoYM()));
        }

        @Test
        public void 正しくサービス名称されている() {
            assertThat(sut.getEntity().getServiceName(), is(entity.getServiceName()));
        }

        @Test
        public void 正しくサービス略称されている() {
            assertThat(sut.getEntity().getServiceNameRyaku(), is(entity.getServiceNameRyaku()));
        }

        @Test
        public void 正しく単位数されている() {
            assertThat(sut.getEntity().getTaniSu(), is(entity.getTaniSu()));
        }

        @Test
        public void 正しく単位数識別されている() {
            assertThat(sut.getEntity().getTanisuShikibetsuCode(), is(entity.getTanisuShikibetsuCode()));
        }

        @Test
        public void 正しく単位数算定単位されている() {
            assertThat(sut.getEntity().getTaniSu(), is(entity.getTaniSu()));
        }

        @Test
        public void 正しく異動事由されている() {
            assertThat(sut.getEntity().getIdouJiyuCode(), is(entity.getIdouJiyuCode()));
        }
    }

}
