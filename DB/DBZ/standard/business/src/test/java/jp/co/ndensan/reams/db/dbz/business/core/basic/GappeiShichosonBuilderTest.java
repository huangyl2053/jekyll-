/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
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

    private static DbT7056GappeiShichosonEntity GappeiShichosonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static GappeiShichosonBuilder sut;
        private static GappeiShichoson business;

        @Before
        public void setUp() {
            GappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
            GappeiShichosonEntity.setXXX(主キー名1);
            GappeiShichosonEntity.setXXX(主キー名2);

            business = new GappeiShichoson(GappeiShichosonEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の合併年月日は_設定した値と同じ合併年月日を返す() {
            business = sut.set合併年月日(DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日).build();
            assertThat(business.get合併年月日(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日));
        }

        @Test
        public void 戻り値の地域番号は_設定した値と同じ地域番号を返す() {
            business = sut.set地域番号(DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号).build();
            assertThat(business.get地域番号(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号));
        }

        @Test
        public void 戻り値の旧市町村コードは_設定した値と同じ旧市町村コードを返す() {
            business = sut.set旧市町村コード(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード).build();
            assertThat(business.get旧市町村コード(), is(DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード));
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
