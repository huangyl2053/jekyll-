/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilderTest extends DbcTestBase {

    private static DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder sut;
        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo business;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);

            business = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定診療情報レコード順次番号は_設定した値と同じ特定診療情報レコード順次番号を返す() {
            business = sut.set特定診療情報レコード順次番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_特定診療情報レコード順次番号).build();
            assertThat(business.get特定診療情報レコード順次番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_特定診療情報レコード順次番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            business = sut.set傷病名(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名).build();
            assertThat(business.get傷病名(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の識別番号は_設定した値と同じ識別番号を返す() {
            business = sut.set識別番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号).build();
            assertThat(business.get識別番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の保険・回数は_設定した値と同じ保険・回数を返す() {
            business = sut.set保険・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・回数).build();
            assertThat(business.get保険・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・回数));
        }

        @Test
        public void 戻り値の保険・ｻｰﾋﾞｽ単位数は_設定した値と同じ保険・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set保険・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get保険・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の保険・合計単位数は_設定した値と同じ保険・合計単位数を返す() {
            business = sut.set保険・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・合計単位数).build();
            assertThat(business.get保険・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険・合計単位数));
        }

        @Test
        public void 戻り値の公費１・回数は_設定した値と同じ公費１・回数を返す() {
            business = sut.set公費１・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・回数).build();
            assertThat(business.get公費１・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・回数));
        }

        @Test
        public void 戻り値の公費１・ｻｰﾋﾞｽ単位数は_設定した値と同じ公費１・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費１・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費１・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費１・合計単位数は_設定した値と同じ公費１・合計単位数を返す() {
            business = sut.set公費１・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・合計単位数).build();
            assertThat(business.get公費１・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１・合計単位数));
        }

        @Test
        public void 戻り値の公費２・回数は_設定した値と同じ公費２・回数を返す() {
            business = sut.set公費２・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・回数).build();
            assertThat(business.get公費２・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・回数));
        }

        @Test
        public void 戻り値の公費２・ｻｰﾋﾞｽ単位数は_設定した値と同じ公費２・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費２・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費２・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費２・合計単位数は_設定した値と同じ公費２・合計単位数を返す() {
            business = sut.set公費２・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・合計単位数).build();
            assertThat(business.get公費２・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２・合計単位数));
        }

        @Test
        public void 戻り値の公費３・回数は_設定した値と同じ公費３・回数を返す() {
            business = sut.set公費３・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・回数).build();
            assertThat(business.get公費３・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・回数));
        }

        @Test
        public void 戻り値の公費３・ｻｰﾋﾞｽ単位数は_設定した値と同じ公費３・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費３・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費３・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費３・合計単位数は_設定した値と同じ公費３・合計単位数を返す() {
            business = sut.set公費３・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・合計単位数).build();
            assertThat(business.get公費３・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３・合計単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後・単位数は_設定した値と同じ後・単位数を返す() {
            business = sut.set後・単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・単位数).build();
            assertThat(business.get後・単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・単位数));
        }

        @Test
        public void 戻り値の後・保険・回数は_設定した値と同じ後・保険・回数を返す() {
            business = sut.set後・保険・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・回数).build();
            assertThat(business.get後・保険・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・回数));
        }

        @Test
        public void 戻り値の後・保険・ｻｰﾋﾞｽ単位数は_設定した値と同じ後・保険・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後・保険・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後・保険・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後・保険・合計単位数は_設定した値と同じ後・保険・合計単位数を返す() {
            business = sut.set後・保険・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・合計単位数).build();
            assertThat(business.get後・保険・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・保険・合計単位数));
        }

        @Test
        public void 戻り値の後・公費１・回数は_設定した値と同じ後・公費１・回数を返す() {
            business = sut.set後・公費１・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・回数).build();
            assertThat(business.get後・公費１・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・回数));
        }

        @Test
        public void 戻り値の後・公費１・ｻｰﾋﾞｽ単位数は_設定した値と同じ後・公費１・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後・公費１・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後・公費１・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後・公費１・合計単位数は_設定した値と同じ後・公費１・合計単位数を返す() {
            business = sut.set後・公費１・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・合計単位数).build();
            assertThat(business.get後・公費１・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費１・合計単位数));
        }

        @Test
        public void 戻り値の後・公費２・回数は_設定した値と同じ後・公費２・回数を返す() {
            business = sut.set後・公費２・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・回数).build();
            assertThat(business.get後・公費２・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・回数));
        }

        @Test
        public void 戻り値の後・公費２・ｻｰﾋﾞｽ単位数は_設定した値と同じ後・公費２・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後・公費２・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後・公費２・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後・公費２・合計単位数は_設定した値と同じ後・公費２・合計単位数を返す() {
            business = sut.set後・公費２・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・合計単位数).build();
            assertThat(business.get後・公費２・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費２・合計単位数));
        }

        @Test
        public void 戻り値の後・公費３・回数は_設定した値と同じ後・公費３・回数を返す() {
            business = sut.set後・公費３・回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・回数).build();
            assertThat(business.get後・公費３・回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・回数));
        }

        @Test
        public void 戻り値の後・公費３・ｻｰﾋﾞｽ単位数は_設定した値と同じ後・公費３・ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後・公費３・ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後・公費３・ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後・公費３・合計単位数は_設定した値と同じ後・公費３・合計単位数を返す() {
            business = sut.set後・公費３・合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・合計単位数).build();
            assertThat(business.get後・公費３・合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後・公費３・合計単位数));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_取込年月));
        }

    }
}
