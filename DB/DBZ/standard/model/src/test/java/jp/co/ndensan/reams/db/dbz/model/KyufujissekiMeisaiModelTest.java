/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3018KyufujissekiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiMeisaiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiMeisaiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            sut.setサービス種類コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード);
            assertThat(sut.getサービス種類コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            sut.setサービス項目コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード);
            assertThat(sut.getサービス項目コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数_回数は_設定した値と同じ日数_回数を返す() {
            sut.set日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_日数_回数);
            assertThat(sut.get日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_日数_回数));
        }

        @Test
        public void 戻り値の公費１対象日数_回数は_設定した値と同じ公費１対象日数_回数を返す() {
            sut.set公費１対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象日数_回数);
            assertThat(sut.get公費１対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象日数_回数));
        }

        @Test
        public void 戻り値の公費２対象日数_回数は_設定した値と同じ公費２対象日数_回数を返す() {
            sut.set公費２対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象日数_回数);
            assertThat(sut.get公費２対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象日数_回数));
        }

        @Test
        public void 戻り値の公費３対象日数_回数は_設定した値と同じ公費３対象日数_回数を返す() {
            sut.set公費３対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象日数_回数);
            assertThat(sut.get公費３対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象日数_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            sut.setサービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス単位数);
            assertThat(sut.getサービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の公費１対象サービス単位数は_設定した値と同じ公費１対象サービス単位数を返す() {
            sut.set公費１対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象サービス単位数);
            assertThat(sut.get公費１対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象サービス単位数));
        }

        @Test
        public void 戻り値の公費２対象サービス単位数は_設定した値と同じ公費２対象サービス単位数を返す() {
            sut.set公費２対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象サービス単位数);
            assertThat(sut.get公費２対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象サービス単位数));
        }

        @Test
        public void 戻り値の公費３対象サービス単位数は_設定した値と同じ公費３対象サービス単位数を返す() {
            sut.set公費３対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象サービス単位数);
            assertThat(sut.get公費３対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象サービス単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            sut.set後_単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_単位数);
            assertThat(sut.get後_単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_単位数));
        }

        @Test
        public void 戻り値の後_日数_回数は_設定した値と同じ後_日数_回数を返す() {
            sut.set後_日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_日数_回数);
            assertThat(sut.get後_日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_日数_回数));
        }

        @Test
        public void 戻り値の後_公費１対象日数_回数は_設定した値と同じ後_公費１対象日数_回数を返す() {
            sut.set後_公費１対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象日数_回数);
            assertThat(sut.get後_公費１対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象日数_回数));
        }

        @Test
        public void 戻り値の後_公費２対象日数_回数は_設定した値と同じ後_公費２対象日数_回数を返す() {
            sut.set後_公費２対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象日数_回数);
            assertThat(sut.get後_公費２対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象日数_回数));
        }

        @Test
        public void 戻り値の後_公費３対象日数_回数は_設定した値と同じ後_公費３対象日数_回数を返す() {
            sut.set後_公費３対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象日数_回数);
            assertThat(sut.get後_公費３対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象日数_回数));
        }

        @Test
        public void 戻り値の後_サービス単位数は_設定した値と同じ後_サービス単位数を返す() {
            sut.set後_サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_サービス単位数);
            assertThat(sut.get後_サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_サービス単位数));
        }

        @Test
        public void 戻り値の後_公費１対象サービス単位数は_設定した値と同じ後_公費１対象サービス単位数を返す() {
            sut.set後_公費１対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象サービス単位数);
            assertThat(sut.get後_公費１対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象サービス単位数));
        }

        @Test
        public void 戻り値の後_公費２対象サービス単位数は_設定した値と同じ後_公費２対象サービス単位数を返す() {
            sut.set後_公費２対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象サービス単位数);
            assertThat(sut.get後_公費２対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象サービス単位数));
        }

        @Test
        public void 戻り値の後_公費３対象サービス単位数は_設定した値と同じ後_公費３対象サービス単位数を返す() {
            sut.set後_公費３対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象サービス単位数);
            assertThat(sut.get後_公費３対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象サービス単位数));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiMeisaiModel sut = new KyufujissekiMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiMeisaiModel sut = new KyufujissekiMeisaiModel();
            sut.setEntity(DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiMeisaiModel sut = new KyufujissekiMeisaiModel();
            sut.setEntity(DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiMeisaiModel sut = new KyufujissekiMeisaiModel();
            sut.setEntity(DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
