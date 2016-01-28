/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
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
 *
 * @author LDNS 燕京
 */
@RunWith(Enclosed.class)
public class IDbT7060KaigoJigyoshaMapperTest extends DbxTestDacBase {

    private static IDbT7060KaigoJigyoshaMapper sut;
    private static DbT7060KaigoJigyoshaDac dac;
    private static DbT7060KaigoJigyoshaEntity entity;
    private static DbTestHelper dbTestHelper;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();

    }

    @Ignore
    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
            sut = sqlSession.getMapper(IDbT7060KaigoJigyoshaMapper.class);
            entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
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
        public void 正しく有効終了日がくマッピングされている() {
            assertThat(sut.getEntity().getYukoShuryoYMD(), is(entity.getYukoShuryoYMD()));
        }

        @Test
        public void 正しく異動日がくマッピングされている() {
            assertThat(sut.getEntity().getIdoYMD(), is(entity.getIdoYMD()));
        }

        @Test
        public void 正しく異動事由がくマッピングされている() {
            assertThat(sut.getEntity().getIdoJiyuCode(), is(entity.getIdoJiyuCode()));
        }

        @Test
        public void 正しく事業開始日がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoKaishiYMD(), is(entity.getJigyoKaishiYMD()));
        }

        @Test
        public void 正しく事業休止日くマッピングされている() {
            assertThat(sut.getEntity().getJigyoKyushiYMD(), is(entity.getJigyoKyushiYMD()));
        }

        @Test
        public void 正しく事業再開日がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoSaikaiYMD(), is(entity.getJigyoSaikaiYMD()));
        }

        @Test
        public void 正しく事業廃止日くマッピングされている() {
            assertThat(sut.getEntity().getJigyoHaishiYMD(), is(entity.getJigyoHaishiYMD()));
        }

        @Test
        public void 正しく事業者名称がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaName(), is(entity.getJigyoshaName()));
        }

        @Test
        public void 正しく事業者名称カナがくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaNameKana(), is(entity.getJigyoshaNameKana()));
        }

        @Test
        public void 正しく郵便番号がくマッピングされている() {
            assertThat(sut.getEntity().getYubinNo(), is(entity.getYubinNo()));
        }

        @Test
        public void 正しく事業者住所がくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaAddress(), is(entity.getJigyoshaAddress()));
        }

        @Test
        public void 正しく事業者住所カナがくマッピングされている() {
            assertThat(sut.getEntity().getJigyoshaKanaAddress(), is(entity.getJigyoshaKanaAddress()));
        }

        @Test
        public void 正しく電話番号がくマッピングされている() {
            assertThat(sut.getEntity().getTelNo(), is(entity.getTelNo()));
        }

        @Test
        public void 正しくFAX番号がくマッピングされている() {
            assertThat(sut.getEntity().getFaxNo(), is(entity.getFaxNo()));
        }

        @Test
        public void 正しく宛先部署がくマッピングされている() {
            assertThat(sut.getEntity().getAtesakiBusho(), is(entity.getAtesakiBusho()));
        }

        @Test
        public void 正しく宛先人名がくマッピングされている() {
            assertThat(sut.getEntity().getAtesakininName(), is(entity.getAtesakininName()));
        }

        @Test
        public void 正しく宛先人名カナがくマッピングされている() {
            assertThat(sut.getEntity().getAtesakininNamekana(), is(entity.getAtesakininNamekana()));
        }

        @Test
        public void 正しく指定基準該当等事業所区分がくマッピングされている() {
            assertThat(sut.getEntity().getShiteiKijungaitoJigyoshaKubun(), is(entity.getShiteiKijungaitoJigyoshaKubun()));
        }

        @Test
        public void 正しく所在市町村がくマッピングされている() {
            assertThat(sut.getEntity().getShozaiShichoson(), is(entity.getShozaiShichoson()));
        }

        @Test
        public void 正しくサービス実施地域がくマッピングされている() {
            assertThat(sut.getEntity().getServiceJisshiChiiki(), is(entity.getServiceJisshiChiiki()));
        }

        @Test
        public void 正しく法人等種別がくマッピングされている() {
            assertThat(sut.getEntity().getHojinShubetsu(), is(entity.getHojinShubetsu()));
        }

        @Test
        public void 正しくベッド数がくマッピングされている() {
            assertThat(sut.getEntity().getBedSu(), is(entity.getBedSu()));
        }

        @Test
        public void 正しく所属人数がくマッピングされている() {
            assertThat(sut.getEntity().getShozokuNinzu(), is(entity.getShozokuNinzu()));
        }

        @Test
        public void 正しく利用者数がくマッピングされている() {
            assertThat(sut.getEntity().getRiyoshaSu(), is(entity.getRiyoshaSu()));
        }

        @Test
        public void 正しく備考がくマッピングされている() {
            assertThat(sut.getEntity().getBiko(), is(entity.getBiko()));
        }

    }
}
