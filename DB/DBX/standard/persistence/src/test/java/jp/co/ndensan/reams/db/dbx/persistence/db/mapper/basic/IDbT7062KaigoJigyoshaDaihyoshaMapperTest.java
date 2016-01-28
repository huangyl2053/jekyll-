/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LDNS 燕京
 */
public class IDbT7062KaigoJigyoshaDaihyoshaMapperTest extends DbxTestDacBase {

    private static IDbT7062KaigoJigyoshaDaihyoshaMapper sut;
    private static DbT7062KaigoJigyoshaDaihyoshaDac dac;
    private static DbT7062KaigoJigyoshaDaihyoshaEntity entity;
    private static DbTestHelper dbTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @BeforeClass
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7062KaigoJigyoshaDaihyoshaEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
            sut = sqlSession.getMapper(IDbT7062KaigoJigyoshaDaihyoshaMapper.class);
            entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
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
        public void 正しく事業者番号がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaNo(), is(entity.getJigyoshaNo()));
        }

        @Test
        public void 正しく有効開始日がくマッピングされている() {
            assertThat(sut.getEntity().getYukoKaishiYMD(), is(entity.getYukoKaishiYMD()));
        }

        @Test
        public void 正しく代表者名がくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaShimei(), is(entity.getDaihyoshaShimei()));
        }

        @Test
        public void 正しく代表者名カナがくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaKanaShimei(), is(entity.getDaihyoshaKanaShimei()));
        }

        @Test
        public void 正しく代表者郵便番号がくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaYubinNo(), is(entity.getDaihyoshaYubinNo()));
        }

        @Test
        public void 正しく代表者住所がくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaJusho(), is(entity.getDaihyoshaJusho()));
        }

        @Test
        public void 正しく代表者住所カナがくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaKanaJusho(), is(entity.getDaihyoshaKanaJusho()));
        }

        @Test
        public void 正しく代表者役職名がくマッピングされている() {
            assertThat(sut.getEntity().getDaihyoshaYakushokuMei(), is(entity.getDaihyoshaYakushokuMei()));
        }

        @Test
        public void 正しく開設者名称がくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaShimei(), is(entity.getKaisetsushaShimei()));
        }

        @Test
        public void 正しく開設者名称カナがくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaKanaShimei(), is(entity.getKaisetsushaKanaShimei()));
        }

        @Test
        public void 正しく開設者郵便番号がくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaYubinNo(), is(entity.getKaisetsushaYubinNo()));
        }

        @Test
        public void 正しく開設者住所がくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaJusho(), is(entity.getKaisetsushaJusho()));
        }

        @Test
        public void 正しく開設者住所カナがくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaKanaJusho(), is(entity.getKaisetsushaKanaJusho()));
        }

        @Test
        public void 正しく開設者ＦＡＸ番号がくマッピングされている() {
            assertThat(sut.getEntity().getKaisetsushaFaxNo(), is(entity.getKaisetsushaFaxNo()));
        }

        @Test
        public void 正しく開設者電話番号がくマッピングされている() {
            assertThat(sut.getEntity().getInsertDantaiCd(), is(entity.getInsertDantaiCd()));
        }

    }
}
