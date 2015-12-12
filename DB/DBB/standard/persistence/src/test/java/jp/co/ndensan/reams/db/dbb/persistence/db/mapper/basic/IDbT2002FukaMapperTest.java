/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
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
 * {@link IDbT2002FukaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2002FukaMapperTest extends DbbTestDacBase {

    private static DbT2002FukaEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2002FukaDac dac;
    private static IDbT2002FukaMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2002FukaEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2002FukaDac.class);
            sut = sqlSession.getMapper(IDbT2002FukaMapper.class);
            entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
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
        public void 正しく被保険者番号されている() {
            assertThat(sut.getEntity().getHihokenshaNo(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void 正しく識別コードされている() {
            assertThat(sut.getEntity().getShikibetsuCode(), is(entity.getShikibetsuCode()));
        }

        @Test
        public void 正しく世帯コードされている() {
            assertThat(sut.getEntity().getSetaiCode(), is(entity.getSetaiCode()));
        }

        @Test
        public void 正しく世帯員数されている() {
            assertThat(sut.getEntity().getSetaiInsu(), is(entity.getSetaiInsu()));
        }

        @Test
        public void 正しく資格取得日されている() {
            assertThat(sut.getEntity().getShikakuShutokuYMD(), is(entity.getShikakuShutokuYMD()));
        }

        @Test
        public void 正しく資格取得事由されている() {
            assertThat(sut.getEntity().getShikakuShutokuJiyu(), is(entity.getShikakuShutokuJiyu()));
        }

        @Test
        public void 正しく資格喪失日されている() {
            assertThat(sut.getEntity().getShikakuSoshitsuYMD(), is(entity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void 正しく資格喪失事由されている() {
            assertThat(sut.getEntity().getShikakuSoshitsuJiyu(), is(entity.getShikakuSoshitsuJiyu()));
        }

        @Test
        public void 正しく生活保護扶助種類されている() {
            assertThat(sut.getEntity().getSeihofujoShurui(), is(entity.getSeihofujoShurui()));
        }

        @Test
        public void 正しく生保開始日されている() {
            assertThat(sut.getEntity().getSeihoKaishiYMD(), is(entity.getSeihoKaishiYMD()));
        }

        @Test
        public void 正しく生保廃止日されている() {
            assertThat(sut.getEntity().getSeihoHaishiYMD(), is(entity.getSeihoHaishiYMD()));
        }

        @Test
        public void 正しく老年開始日されている() {
            assertThat(sut.getEntity().getRonenKaishiYMD(), is(entity.getRonenKaishiYMD()));
        }

        @Test
        public void 正しく老年廃止日されている() {
            assertThat(sut.getEntity().getRonenHaishiYMD(), is(entity.getRonenHaishiYMD()));
        }

        @Test
        public void 正しく賦課期日されている() {
            assertThat(sut.getEntity().getFukaYMD(), is(entity.getFukaYMD()));
        }

        @Test
        public void 正しく課税区分されている() {
            assertThat(sut.getEntity().getKazeiKubun(), is(entity.getKazeiKubun()));
        }

        @Test
        public void 正しく世帯課税区分されている() {
            assertThat(sut.getEntity().getSetaikazeiKubun(), is(entity.getSetaikazeiKubun()));
        }

        @Test
        public void 正しく合計所得金額されている() {
            assertThat(sut.getEntity().getGokeiShotokuGaku(), is(entity.getGokeiShotokuGaku()));
        }

        @Test
        public void 正しく公的年金収入額されている() {
            assertThat(sut.getEntity().getNenkinShunyuGaku(), is(entity.getNenkinShunyuGaku()));
        }

        @Test
        public void 正しく保険料段階されている() {
            assertThat(sut.getEntity().getHokenryoDankai(), is(entity.getHokenryoDankai()));
        }

        @Test
        public void 正しく保険料算定段階1されている() {
            assertThat(sut.getEntity().getHokenryoDankai1(), is(entity.getHokenryoDankai1()));
        }

        @Test
        public void 正しく算定年額保険料1されている() {
            assertThat(sut.getEntity().getNengakuHokenryo1(), is(entity.getNengakuHokenryo1()));
        }

        @Test
        public void 正しく月割開始年月1されている() {
            assertThat(sut.getEntity().getTsukiwariStartYM1(), is(entity.getTsukiwariStartYM1()));
        }

        @Test
        public void 正しく月割終了年月1されている() {
            assertThat(sut.getEntity().getTsukiwariEndYM1(), is(entity.getTsukiwariEndYM1()));
        }

        @Test
        public void 正しく保険料算定段階2されている() {
            assertThat(sut.getEntity().getHokenryoDankai2(), is(entity.getHokenryoDankai2()));
        }

        @Test
        public void 正しく算定年額保険料2されている() {
            assertThat(sut.getEntity().getNengakuHokenryo2(), is(entity.getNengakuHokenryo2()));
        }

        @Test
        public void 正しく月割開始年月2されている() {
            assertThat(sut.getEntity().getTsukiwariStartYM2(), is(entity.getTsukiwariStartYM2()));
        }

        @Test
        public void 正しく月割終了年月2されている() {
            assertThat(sut.getEntity().getTsukiwariEndYM2(), is(entity.getTsukiwariEndYM2()));
        }

        @Test
        public void 正しく調定日時されている() {
            assertThat(sut.getEntity().getChoteiTimestamp(), is(entity.getChoteiTimestamp()));
        }

        @Test
        public void 正しく調定事由1されている() {
            assertThat(sut.getEntity().getChoteiJiyu1(), is(entity.getChoteiJiyu1()));
        }

        @Test
        public void 正しく調定事由2されている() {
            assertThat(sut.getEntity().getChoteiJiyu2(), is(entity.getChoteiJiyu2()));
        }

        @Test
        public void 正しく調定事由3されている() {
            assertThat(sut.getEntity().getChoteiJiyu3(), is(entity.getChoteiJiyu3()));
        }

        @Test
        public void 正しく調定事由4されている() {
            assertThat(sut.getEntity().getChoteiJiyu4(), is(entity.getChoteiJiyu4()));
        }

        @Test
        public void 正しく更正月されている() {
            assertThat(sut.getEntity().getKoseiM(), is(entity.getKoseiM()));
        }

        @Test
        public void 正しく減免前介護保険料_年額_されている() {
            assertThat(sut.getEntity().getGemmenMaeHokenryo(), is(entity.getGemmenMaeHokenryo()));
        }

        @Test
        public void 正しく減免額されている() {
            assertThat(sut.getEntity().getGemmenGaku(), is(entity.getGemmenGaku()));
        }

        @Test
        public void 正しく確定介護保険料_年額_されている() {
            assertThat(sut.getEntity().getKakuteiHokenryo(), is(entity.getKakuteiHokenryo()));
        }

        @Test
        public void 正しく保険料段階_仮算定時_されている() {
            assertThat(sut.getEntity().getHokenryoDankaiKarisanntei(), is(entity.getHokenryoDankaiKarisanntei()));
        }

        @Test
        public void 正しく徴収方法履歴番号されている() {
            assertThat(sut.getEntity().getChoshuHohoRirekiNo(), is(entity.getChoshuHohoRirekiNo()));
        }

        @Test
        public void 正しく異動基準日時されている() {
            assertThat(sut.getEntity().getIdoKijunTimestamp(), is(entity.getIdoKijunTimestamp()));
        }

        @Test
        public void 正しく口座区分されている() {
            assertThat(sut.getEntity().getKozaKubun(), is(entity.getKozaKubun()));
        }

        @Test
        public void 正しく境界層区分されている() {
            assertThat(sut.getEntity().getKyokaisoKubun(), is(entity.getKyokaisoKubun()));
        }

        @Test
        public void 正しく職権区分されている() {
            assertThat(sut.getEntity().getShokkenKubun(), is(entity.getShokkenKubun()));
        }

        @Test
        public void 正しく賦課市町村コードされている() {
            assertThat(sut.getEntity().getFukaShichosonCode(), is(entity.getFukaShichosonCode()));
        }
    }

}
