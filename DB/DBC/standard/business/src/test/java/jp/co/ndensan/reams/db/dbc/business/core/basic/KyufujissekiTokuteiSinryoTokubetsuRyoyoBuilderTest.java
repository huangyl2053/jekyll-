/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;
    private static RString 主キー名9;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_通し番号;
        主キー名9 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_特定診療情報レコード順次番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder sut;
        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo business;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setInputShikibetsuNo(主キー名2);

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
        public void 戻り値の保険_回数は_設定した値と同じ保険_回数を返す() {
            business = sut.set保険_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_回数).build();
            assertThat(business.get保険_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_回数));
        }

        @Test
        public void 戻り値の保険_ｻｰﾋﾞｽ単位数は_設定した値と同じ保険_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set保険_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get保険_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の保険_合計単位数は_設定した値と同じ保険_合計単位数を返す() {
            business = sut.set保険_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_合計単位数).build();
            assertThat(business.get保険_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_保険_合計単位数));
        }

        @Test
        public void 戻り値の公費１_回数は_設定した値と同じ公費１_回数を返す() {
            business = sut.set公費１_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_回数).build();
            assertThat(business.get公費１_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_回数));
        }

        @Test
        public void 戻り値の公費１_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費１_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費１_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費１_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費１_合計単位数は_設定した値と同じ公費１_合計単位数を返す() {
            business = sut.set公費１_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_合計単位数).build();
            assertThat(business.get公費１_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費１_合計単位数));
        }

        @Test
        public void 戻り値の公費２_回数は_設定した値と同じ公費２_回数を返す() {
            business = sut.set公費２_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_回数).build();
            assertThat(business.get公費２_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_回数));
        }

        @Test
        public void 戻り値の公費２_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費２_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費２_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費２_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費２_合計単位数は_設定した値と同じ公費２_合計単位数を返す() {
            business = sut.set公費２_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_合計単位数).build();
            assertThat(business.get公費２_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費２_合計単位数));
        }

        @Test
        public void 戻り値の公費３_回数は_設定した値と同じ公費３_回数を返す() {
            business = sut.set公費３_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_回数).build();
            assertThat(business.get公費３_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_回数));
        }

        @Test
        public void 戻り値の公費３_ｻｰﾋﾞｽ単位数は_設定した値と同じ公費３_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set公費３_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get公費３_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の公費３_合計単位数は_設定した値と同じ公費３_合計単位数を返す() {
            business = sut.set公費３_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_合計単位数).build();
            assertThat(business.get公費３_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_公費３_合計単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            business = sut.set後_単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_単位数).build();
            assertThat(business.get後_単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_単位数));
        }

        @Test
        public void 戻り値の後_保険_回数は_設定した値と同じ後_保険_回数を返す() {
            business = sut.set後_保険_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_回数).build();
            assertThat(business.get後_保険_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_回数));
        }

        @Test
        public void 戻り値の後_保険_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_保険_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後_保険_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後_保険_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_保険_合計単位数は_設定した値と同じ後_保険_合計単位数を返す() {
            business = sut.set後_保険_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_合計単位数).build();
            assertThat(business.get後_保険_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_保険_合計単位数));
        }

        @Test
        public void 戻り値の後_公費１_回数は_設定した値と同じ後_公費１_回数を返す() {
            business = sut.set後_公費１_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_回数).build();
            assertThat(business.get後_公費１_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_回数));
        }

        @Test
        public void 戻り値の後_公費１_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費１_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後_公費１_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後_公費１_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費１_合計単位数は_設定した値と同じ後_公費１_合計単位数を返す() {
            business = sut.set後_公費１_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_合計単位数).build();
            assertThat(business.get後_公費１_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費１_合計単位数));
        }

        @Test
        public void 戻り値の後_公費２_回数は_設定した値と同じ後_公費２_回数を返す() {
            business = sut.set後_公費２_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_回数).build();
            assertThat(business.get後_公費２_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_回数));
        }

        @Test
        public void 戻り値の後_公費２_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費２_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後_公費２_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後_公費２_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費２_合計単位数は_設定した値と同じ後_公費２_合計単位数を返す() {
            business = sut.set後_公費２_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_合計単位数).build();
            assertThat(business.get後_公費２_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費２_合計単位数));
        }

        @Test
        public void 戻り値の後_公費３_回数は_設定した値と同じ後_公費３_回数を返す() {
            business = sut.set後_公費３_回数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_回数).build();
            assertThat(business.get後_公費３_回数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_回数));
        }

        @Test
        public void 戻り値の後_公費３_ｻｰﾋﾞｽ単位数は_設定した値と同じ後_公費３_ｻｰﾋﾞｽ単位数を返す() {
            business = sut.set後_公費３_ｻｰﾋﾞｽ単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数).build();
            assertThat(business.get後_公費３_ｻｰﾋﾞｽ単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数));
        }

        @Test
        public void 戻り値の後_公費３_合計単位数は_設定した値と同じ後_公費３_合計単位数を返す() {
            business = sut.set後_公費３_合計単位数(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_合計単位数).build();
            assertThat(business.get後_公費３_合計単位数(), is(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_後_公費３_合計単位数));
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
