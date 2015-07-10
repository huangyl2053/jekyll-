/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1013KyokaisoSochiShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoSochiShinseiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyokaisoSochiShinseiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyokaisoSochiShinseiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyokaisoSochiShinseiModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請_廃止区分は_設定した値と同じ申請_廃止区分を返す() {
            sut.set申請_廃止区分(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請_廃止区分);
            assertThat(sut.get申請_廃止区分(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請_廃止区分));
        }

        @Test
        public void 戻り値の申請_廃止年月日は_設定した値と同じ申請_廃止年月日を返す() {
            sut.set申請_廃止年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請_廃止年月日);
            assertThat(sut.get申請_廃止年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請_廃止年月日));
        }

        @Test
        public void 戻り値の保護不要根拠減額金額は_設定した値と同じ保護不要根拠減額金額を返す() {
            sut.set保護不要根拠減額金額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保護不要根拠減額金額);
            assertThat(sut.get保護不要根拠減額金額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保護不要根拠減額金額));
        }

        @Test
        public void 戻り値の境界層証明書交付年月日は_設定した値と同じ境界層証明書交付年月日を返す() {
            sut.set境界層証明書交付年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層証明書交付年月日);
            assertThat(sut.get境界層証明書交付年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層証明書交付年月日));
        }

        @Test
        public void 戻り値の給付額減額取消_減額自己負担月額は_設定した値と同じ給付額減額取消_減額自己負担月額を返す() {
            sut.set給付額減額取消_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_給付額減額取消_減額自己負担月額);
            assertThat(sut.get給付額減額取消_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_給付額減額取消_減額自己負担月額));
        }

        @Test
        public void 戻り値の居住費軽減_減額自己負担月額は_設定した値と同じ居住費軽減_減額自己負担月額を返す() {
            sut.set居住費軽減_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減_減額自己負担月額);
            assertThat(sut.get居住費軽減_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減_減額自己負担月額));
        }

        @Test
        public void 戻り値の居住費軽減_負担限度額段階コードは_設定した値と同じ居住費軽減_負担限度額段階コードを返す() {
            sut.set居住費軽減_負担限度額段階コード(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減_負担限度額段階コード);
            assertThat(sut.get居住費軽減_負担限度額段階コード(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減_負担限度額段階コード));
        }

        @Test
        public void 戻り値の食費軽減_減額自己負担月額は_設定した値と同じ食費軽減_減額自己負担月額を返す() {
            sut.set食費軽減_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減_減額自己負担月額);
            assertThat(sut.get食費軽減_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減_減額自己負担月額));
        }

        @Test
        public void 戻り値の食費軽減_負担限度額段階コードは_設定した値と同じ食費軽減_負担限度額段階コードを返す() {
            sut.set食費軽減_負担限度額段階コード(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減_負担限度額段階コード);
            assertThat(sut.get食費軽減_負担限度額段階コード(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減_負担限度額段階コード));
        }

        @Test
        public void 戻り値の利用者負担世帯合算額_減額自己負担月額は_設定した値と同じ利用者負担世帯合算額_減額自己負担月額を返す() {
            sut.set利用者負担世帯合算額_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_利用者負担世帯合算額_減額自己負担月額);
            assertThat(sut.get利用者負担世帯合算額_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_利用者負担世帯合算額_減額自己負担月額));
        }

        @Test
        public void 戻り値の保険料減額_減額自己負担月額は_設定した値と同じ保険料減額_減額自己負担月額を返す() {
            sut.set保険料減額_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保険料減額_減額自己負担月額);
            assertThat(sut.get保険料減額_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保険料減額_減額自己負担月額));
        }

        @Test
        public void 戻り値の減額自己負担月額合計額は_設定した値と同じ減額自己負担月額合計額を返す() {
            sut.set減額自己負担月額合計額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_減額自己負担月額合計額);
            assertThat(sut.get減額自己負担月額合計額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_減額自己負担月額合計額));
        }

        @Test
        public void 戻り値の境界層措置決定年月日は_設定した値と同じ境界層措置決定年月日を返す() {
            sut.set境界層措置決定年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層措置決定年月日);
            assertThat(sut.get境界層措置決定年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層措置決定年月日));
        }

        @Test
        public void 戻り値の措置該当_非該当区分は_設定した値と同じ措置該当_非該当区分を返す() {
            sut.set措置該当_非該当区分(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_措置該当_非該当区分);
            assertThat(sut.get措置該当_非該当区分(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_措置該当_非該当区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyokaisoSochiShinseiModel sut = new KyokaisoSochiShinseiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyokaisoSochiShinseiModel sut = new KyokaisoSochiShinseiModel();
            sut.setEntity(DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyokaisoSochiShinseiModel sut = new KyokaisoSochiShinseiModel();
            sut.setEntity(DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyokaisoSochiShinseiModel sut = new KyokaisoSochiShinseiModel();
            sut.setEntity(DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
