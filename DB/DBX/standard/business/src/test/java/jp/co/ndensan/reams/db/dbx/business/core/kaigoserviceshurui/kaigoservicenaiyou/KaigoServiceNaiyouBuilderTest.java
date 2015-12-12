/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouBuilder;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceNaiyouBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouBuilderTest extends DbxTestBase {

    private static DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity;

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoServiceNaiyouBuilder sut;
        private static KaigoServiceNaiyou business;

        @Before
        public void setUp() {
            kaigoServiceNaiyouEntity = new DbT7131KaigoServiceNaiyouEntity();

            business = new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の提供終了年月は_設定した値と同じ提供終了年月を返す() {
            business = sut.set提供終了年月(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供終了年月).build();
            assertThat(business.get提供終了年月(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            business = sut.setサービス名称(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス名称).build();
            assertThat(business.getサービス名称(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値のサービス略称は_設定した値と同じサービス略称を返す() {
            business = sut.setサービス略称(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス略称).build();
            assertThat(business.getサービス略称(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス略称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数));
        }
//
//        @Test
//        public void 戻り値の単位数識別は_設定した値と同じ単位数識別を返す() {
//            business = sut.set単位数識別(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数識別).build();
//            assertThat(business.get単位数識別(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数識別));
//        }
//
//        @Test
//        public void 戻り値の単位数算定単位は_設定した値と同じ単位数算定単位を返す() {
//            business = sut.set単位数算定単位(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数算定単位).build();
//            assertThat(business.get単位数算定単位(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数算定単位));
//        }
//
//        @Test
//        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
//            business = sut.set異動事由(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_異動事由).build();
//            assertThat(business.get異動事由(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_異動事由));
//        }
//
//        @Test
//        public void 戻り値の限度額対象外フラグは_設定した値と同じ限度額対象外フラグを返す() {
//            business = sut.set限度額対象外フラグ(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_限度額対象外フラグ).build();
//            assertThat(business.get限度額対象外フラグ(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_限度額対象外フラグ));
//        }
//
//        @Test
//        public void 戻り値の外部サービス利用型区分は_設定した値と同じ外部サービス利用型区分を返す() {
//            business = sut.set外部サービス利用型区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_外部サービス利用型区分).build();
//            assertThat(business.get外部サービス利用型区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_外部サービス利用型区分));
//        }
//
//        @Test
//        public void 戻り値の特別地域加算フラグは_設定した値と同じ特別地域加算フラグを返す() {
//            business = sut.set特別地域加算フラグ(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_特別地域加算フラグ).build();
//            assertThat(business.get特別地域加算フラグ(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_特別地域加算フラグ));
//        }
//
//        @Test
//        public void 戻り値の利用者負担定率・定額区分は_設定した値と同じ利用者負担定率・定額区分を返す() {
//            business = sut.set利用者負担定率・定額区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_利用者負担定率・定額区分).build();
//            assertThat(business.get利用者負担定率・定額区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_利用者負担定率・定額区分));
//        }
//
//        @Test
//        public void 戻り値の更新有無フラグは_設定した値と同じ更新有無フラグを返す() {
//            business = sut.set更新有無フラグ(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_更新有無フラグ).build();
//            assertThat(business.get更新有無フラグ(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_更新有無フラグ));
//        }
//
//        @Test
//        public void 戻り値の元点数は_設定した値と同じ元点数を返す() {
//            business = sut.set元点数(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元点数).build();
//            assertThat(business.get元点数(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元点数));
//        }
//
//        @Test
//        public void 戻り値の元限度額対象外フラグは_設定した値と同じ元限度額対象外フラグを返す() {
//            business = sut.set元限度額対象外フラグ(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元限度額対象外フラグ).build();
//            assertThat(business.get元限度額対象外フラグ(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元限度額対象外フラグ));
//        }
//
//        @Test
//        public void 戻り値の元単位数識別コードは_設定した値と同じ元単位数識別コードを返す() {
//            business = sut.set元単位数識別コード(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元単位数識別コード).build();
//            assertThat(business.get元単位数識別コード(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_元単位数識別コード));
//        }
//
//        @Test
//        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
//            business = sut.set利用者負担額(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_利用者負担額).build();
//            assertThat(business.get利用者負担額(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_利用者負担額));
//        }
//
//        @Test
//        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
//            business = sut.set給付率(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_給付率).build();
//            assertThat(business.get給付率(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_給付率));
//        }
//
//        @Test
//        public void 戻り値の二次予防事業対象者実施区分（非該当）は_設定した値と同じ二次予防事業対象者実施区分（非該当）を返す() {
//            business = sut.set二次予防事業対象者実施区分（非該当）(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_二次予防事業対象者実施区分（非該当）).build();
//            assertThat(business.get二次予防事業対象者実施区分（非該当）(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_二次予防事業対象者実施区分（非該当）));
//        }
//
//        @Test
//        public void 戻り値の要支援１受給者実施区分は_設定した値と同じ要支援１受給者実施区分を返す() {
//            business = sut.set要支援１受給者実施区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_要支援１受給者実施区分).build();
//            assertThat(business.get要支援１受給者実施区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_要支援１受給者実施区分));
//        }
//
//        @Test
//        public void 戻り値の要支援２受給者実施区分は_設定した値と同じ要支援２受給者実施区分を返す() {
//            business = sut.set要支援２受給者実施区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_要支援２受給者実施区分).build();
//            assertThat(business.get要支援２受給者実施区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_要支援２受給者実施区分));
//        }
//
//        @Test
//        public void 戻り値の対象事業者実施区分は_設定した値と同じ対象事業者実施区分を返す() {
//            business = sut.set対象事業者実施区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_対象事業者実施区分).build();
//            assertThat(business.get対象事業者実施区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_対象事業者実施区分));
//        }
//
//        @Test
//        public void 戻り値の総合事業サービス区分は_設定した値と同じ総合事業サービス区分を返す() {
//            business = sut.set総合事業サービス区分(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_総合事業サービス区分).build();
//            assertThat(business.get総合事業サービス区分(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_総合事業サービス区分));
//        }

    }
}
