/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuJissekiShakaiFukushiHojinKeigengakuModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufuJissekiShakaiFukushiHojinKeigengakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengakuModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の軽減率は_設定した値と同じ軽減率を返す() {
            sut.set軽減率(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率);
            assertThat(sut.get軽減率(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の受領すべき利用者負担の総額は_設定した値と同じ受領すべき利用者負担の総額を返す() {
            sut.set受領すべき利用者負担の総額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額);
            assertThat(sut.get受領すべき利用者負担の総額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額));
        }

        @Test
        public void 戻り値の軽減額は_設定した値と同じ軽減額を返す() {
            sut.set軽減額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額);
            assertThat(sut.get軽減額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額));
        }

        @Test
        public void 戻り値の軽減後利用者負担額は_設定した値と同じ軽減後利用者負担額を返す() {
            sut.set軽減後利用者負担額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額);
            assertThat(sut.get軽減後利用者負担額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の後_受領すべき利用者負担の総額は_設定した値と同じ後_受領すべき利用者負担の総額を返す() {
            sut.set後_受領すべき利用者負担の総額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_受領すべき利用者負担の総額);
            assertThat(sut.get後_受領すべき利用者負担の総額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_受領すべき利用者負担の総額));
        }

        @Test
        public void 戻り値の後_軽減額は_設定した値と同じ後_軽減額を返す() {
            sut.set後_軽減額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減額);
            assertThat(sut.get後_軽減額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減額));
        }

        @Test
        public void 戻り値の後_軽減後利用者負担額は_設定した値と同じ後_軽減後利用者負担額を返す() {
            sut.set後_軽減後利用者負担額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減後利用者負担額);
            assertThat(sut.get後_軽減後利用者負担額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減後利用者負担額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufuJissekiShakaiFukushiHojinKeigengakuModel sut = new KyufuJissekiShakaiFukushiHojinKeigengakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufuJissekiShakaiFukushiHojinKeigengakuModel sut = new KyufuJissekiShakaiFukushiHojinKeigengakuModel();
            sut.setEntity(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufuJissekiShakaiFukushiHojinKeigengakuModel sut = new KyufuJissekiShakaiFukushiHojinKeigengakuModel();
            sut.setEntity(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufuJissekiShakaiFukushiHojinKeigengakuModel sut = new KyufuJissekiShakaiFukushiHojinKeigengakuModel();
            sut.setEntity(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
