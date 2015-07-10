/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyoModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定診療情報レコード順次番号は_設定した値と同じ特定診療情報レコード順次番号を返す() {
            sut.set特定診療情報レコード順次番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_特定診療情報レコード順次番号);
            assertThat(sut.get特定診療情報レコード順次番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_特定診療情報レコード順次番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            sut.set傷病名(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名);
            assertThat(sut.get傷病名(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の識別番号は_設定した値と同じ識別番号を返す() {
            sut.set識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号);
            assertThat(sut.get識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            sut.set単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数);
            assertThat(sut.get単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の保険_回数は_設定した値と同じ保険_回数を返す() {
            sut.set保険_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_回数);
            assertThat(sut.get保険_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_回数));
        }

        @Test
        public void 戻り値の保険_ｻｰﾋﾞｽ単位数は_設定した値と同じ保険_ｻｰﾋﾞｽ単位数を返す() {
            sut.set保険_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get保険_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の保険_合計単位数は_設定した値と同じ保険_合計単位数を返す() {
            sut.set保険_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_合計単位数);
            assertThat(sut.get保険_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_合計単位数));
        }

        @Test
        public void 戻り値の公費１_回数は_設定した値と同じ公費１_回数を返す() {
            sut.set公費１_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_回数);
            assertThat(sut.get公費１_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_回数));
        }

        @Test
        public void 戻り値の公費１_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費１_ｻｰﾋﾞｽ単位数を返す() {
            sut.set公費１_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get公費１_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費１_合計単位数は_設定した値と同じ公費１_合計単位数を返す() {
            sut.set公費１_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_合計単位数);
            assertThat(sut.get公費１_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_合計単位数));
        }

        @Test
        public void 戻り値の公費２_回数は_設定した値と同じ公費２_回数を返す() {
            sut.set公費２_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_回数);
            assertThat(sut.get公費２_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_回数));
        }

        @Test
        public void 戻り値の公費２_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費２_ｻｰﾋﾞｽ単位数を返す() {
            sut.set公費２_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get公費２_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費２_合計単位数は_設定した値と同じ公費２_合計単位数を返す() {
            sut.set公費２_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_合計単位数);
            assertThat(sut.get公費２_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_合計単位数));
        }

        @Test
        public void 戻り値の公費３_回数は_設定した値と同じ公費３_回数を返す() {
            sut.set公費３_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_回数);
            assertThat(sut.get公費３_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_回数));
        }

        @Test
        public void 戻り値の公費３_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費３_ｻｰﾋﾞｽ単位数を返す() {
            sut.set公費３_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get公費３_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費３_合計単位数は_設定した値と同じ公費３_合計単位数を返す() {
            sut.set公費３_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_合計単位数);
            assertThat(sut.get公費３_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_合計単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            sut.set後_単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_単位数);
            assertThat(sut.get後_単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_単位数));
        }

        @Test
        public void 戻り値の後_保険_回数は_設定した値と同じ後_保険_回数を返す() {
            sut.set後_保険_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_回数);
            assertThat(sut.get後_保険_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_回数));
        }

        @Test
        public void 戻り値の後_保険_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_保険_ｻｰﾋﾞｽ単位数を返す() {
            sut.set後_保険_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get後_保険_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_保険_合計単位数は_設定した値と同じ後_保険_合計単位数を返す() {
            sut.set後_保険_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_合計単位数);
            assertThat(sut.get後_保険_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_合計単位数));
        }

        @Test
        public void 戻り値の後_公費１_回数は_設定した値と同じ後_公費１_回数を返す() {
            sut.set後_公費１_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_回数);
            assertThat(sut.get後_公費１_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_回数));
        }

        @Test
        public void 戻り値の後_公費１_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費１_ｻｰﾋﾞｽ単位数を返す() {
            sut.set後_公費１_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get後_公費１_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費１_合計単位数は_設定した値と同じ後_公費１_合計単位数を返す() {
            sut.set後_公費１_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_合計単位数);
            assertThat(sut.get後_公費１_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_合計単位数));
        }

        @Test
        public void 戻り値の後_公費２_回数は_設定した値と同じ後_公費２_回数を返す() {
            sut.set後_公費２_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_回数);
            assertThat(sut.get後_公費２_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_回数));
        }

        @Test
        public void 戻り値の後_公費２_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費２_ｻｰﾋﾞｽ単位数を返す() {
            sut.set後_公費２_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get後_公費２_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費２_合計単位数は_設定した値と同じ後_公費２_合計単位数を返す() {
            sut.set後_公費２_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_合計単位数);
            assertThat(sut.get後_公費２_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_合計単位数));
        }

        @Test
        public void 戻り値の後_公費３_回数は_設定した値と同じ後_公費３_回数を返す() {
            sut.set後_公費３_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_回数);
            assertThat(sut.get後_公費３_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_回数));
        }

        @Test
        public void 戻り値の後_公費３_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費３_ｻｰﾋﾞｽ単位数を返す() {
            sut.set後_公費３_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数);
            assertThat(sut.get後_公費３_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費３_合計単位数は_設定した値と同じ後_公費３_合計単位数を返す() {
            sut.set後_公費３_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_合計単位数);
            assertThat(sut.get後_公費３_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_合計単位数));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoModel sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoModel sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyoModel();
            sut.setEntity(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoModel sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyoModel();
            sut.setEntity(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoModel sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyoModel();
            sut.setEntity(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
