/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7061JuryoIninJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LDNS 燕京
 */
public class IDbT7061JuryoIninJigyoshaMapperTest extends DbxTestDacBase {

    private static IDbT7061JuryoIninJigyoshaMapper sut;
    private static DbT7061JuryoIninJigyoshaDac dac;
    private static DbT7061JuryoIninJigyoshaEntity entity;
    private static DbTestHelper dbTestHelper;

    @Before
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @BeforeClass
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7061JuryoIninJigyoshaEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7061JuryoIninJigyoshaDac.class);
            sut = sqlSession.getMapper(IDbT7061JuryoIninJigyoshaMapper.class);
            entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくinsertDantaiCdがくマッピングされている() {
            assertThat(sut.getEntity().getInsertDantaiCd(), is(entity.getInsertDantaiCd()));
        }

        @Test
        public void 正しくisDeletedがくマッピングされている() {
            assertThat(sut.getEntity().getIsDeleted(), is(entity.getIsDeleted()));
        }

        @Test
        public void 正しく受領委任契約事業者番号がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaNo(), is(entity.getJigyoshaNo()));
        }

        @Test
        public void 正しく受領委任契約開始日がくマッピングされている() {
            assertThat(sut.getEntity().getKeiyakuShuryoYMD(), is(entity.getKeiyakuShuryoYMD()));
        }

        @Test
        public void 正しく受領委任契約終了日がくマッピングされている() {
            assertThat(sut.getEntity().getInsertDantaiCd(), is(entity.getInsertDantaiCd()));
        }

        @Test
        public void 正しく契約サービス種別がくマッピングされている() {
            assertThat(sut.getEntity().getServiceShubetsuCode(), is(entity.getServiceShubetsuCode()));
        }

        @Test
        public void 正しく契約事業者郵便番号がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaYubinNo(), is(entity.getJigyoshaYubinNo()));
        }

        @Test
        public void 正しく契約事業者住所がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaJusho(), is(entity.getJigyoshaJusho()));
        }

        @Test
        public void 正しく契約事業者電話番号がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaTelNo(), is(entity.getJigyoshaTelNo()));
        }

        @Test
        public void 正しく契約事業者FAX番号がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaFaxNo(), is(entity.getJigyoshaFaxNo()));
        }

    }
}
