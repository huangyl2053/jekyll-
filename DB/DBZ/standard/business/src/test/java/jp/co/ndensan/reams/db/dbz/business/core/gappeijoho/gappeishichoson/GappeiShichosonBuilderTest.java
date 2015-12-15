/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiShichosonBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiShichosonBuilderTest extends DbzTestBase {

    private static DbT7056GappeiShichosonEntity GappeiShichosonEntity;
    private static FlexibleDate 合併年月日;
    private static RString 地域番号;
    private static LasdecCode 旧市町村コード;

    @BeforeClass
    public static void setUpClass() {

        合併年月日 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
        旧市町村コード = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static GappeiShichosonBuilder sut;
        private static GappeiShichoson business;

        @Before
        public void setUp() {
            GappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
            GappeiShichosonEntity.setGappeiYMD(合併年月日);
            GappeiShichosonEntity.setChiikiNo(地域番号);
            GappeiShichosonEntity.setKyuShichosonCode(旧市町村コード);

            business = new GappeiShichoson(GappeiShichosonEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の運用開始年月日は_設定した値と同じ運用開始年月日を返す() {
            business = sut.set運用開始年月日(DbT7056GappeiShichosonEntityGenerator.DEFAULT_運用開始年月日).build();
            assertThat(business.get運用開始年月日(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_運用開始年月日));
        }

        @Test
        public void 戻り値の運用終了年月日は_設定した値と同じ運用終了年月日を返す() {
            business = sut.set運用終了年月日(DbT7056GappeiShichosonEntityGenerator.DEFAULT_運用終了年月日).build();
            assertThat(business.get運用終了年月日(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_運用終了年月日));
        }

        @Test
        public void 戻り値の旧保険者番号は_設定した値と同じ旧保険者番号を返す() {
            business = sut.set旧保険者番号(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧保険者番号).build();
            assertThat(business.get旧保険者番号(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧保険者番号));
        }

        @Test
        public void 戻り値の旧市町村名称は_設定した値と同じ旧市町村名称を返す() {
            business = sut.set旧市町村名称(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村名称).build();
            assertThat(business.get旧市町村名称(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村名称));
        }

        @Test
        public void 戻り値の都道府県名称は_設定した値と同じ都道府県名称を返す() {
            business = sut.set都道府県名称(DbT7056GappeiShichosonEntityGenerator.DEFAULT_都道府県名称).build();
            assertThat(business.get都道府県名称(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_都道府県名称));
        }

        @Test
        public void 戻り値の郡名称は_設定した値と同じ郡名称を返す() {
            business = sut.set郡名称(DbT7056GappeiShichosonEntityGenerator.DEFAULT_郡名称).build();
            assertThat(business.get郡名称(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_郡名称));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT7056GappeiShichosonEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT7056GappeiShichosonEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            business = sut.set老人保健市町村番号(DbT7056GappeiShichosonEntityGenerator.DEFAULT_老人保健市町村番号).build();
            assertThat(business.get老人保健市町村番号(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号体系は_設定した値と同じ老人保健受給者番号体系を返す() {
            business = sut.set老人保健受給者番号体系(DbT7056GappeiShichosonEntityGenerator.DEFAULT_老人保健受給者番号体系).build();
            assertThat(business.get老人保健受給者番号体系(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_老人保健受給者番号体系));
        }

        @Test
        public void 戻り値の表示有無は_設定した値と同じ表示有無を返す() {
            business = sut.set表示有無(DbT7056GappeiShichosonEntityGenerator.DEFAULT_表示有無).build();
            assertThat(business.get表示有無(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_表示有無));
        }

    }
}
