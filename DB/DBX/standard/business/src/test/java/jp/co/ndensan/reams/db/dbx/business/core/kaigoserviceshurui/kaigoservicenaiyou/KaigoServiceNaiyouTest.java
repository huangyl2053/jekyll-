/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceNaiyou}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouTest extends DbxTestBase {

    private static DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static RString サービス項目コード;
    private static FlexibleYearMonth 提供開始年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
        サービス種類コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
        提供開始年月 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供開始年月;
        履歴番号 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceNaiyou(null, サービス項目コード, 提供開始年月, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス項目コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceNaiyou(サービス種類コード, null, 提供開始年月, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT7131KaigoServiceNaiyouEntityにセットされている() {
            sut = new KaigoServiceNaiyou(サービス種類コード, サービス項目コード, 提供開始年月, 履歴番号);
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.getサービス項目コード(), is(サービス項目コード));
            assertThat(sut.get提供開始年月(), is(提供開始年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKaigoServiceNaiyouIdentifierにセットされている() {
            sut = new KaigoServiceNaiyou(サービス種類コード, サービス項目コード, 提供開始年月, 履歴番号);

            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().getサービス項目コード(), is(サービス項目コード));
            assertThat(sut.identifier().get提供開始年月(), is(提供開始年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoServiceNaiyou(null);
        }

        @Test
        public void 指定したDbT7131KaigoServiceNaiyouEntityのキー情報を識別子が持つ() {

            sut = new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().getサービス項目コード(), is(サービス項目コード));
            assertThat(sut.identifier().get提供開始年月(), is(提供開始年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();

            sut = new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(kaigoServiceNaiyouEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(kaigoServiceNaiyouEntity.getServiceKoumokuCode()));
        }

        @Test
        public void get提供開始年月は_entityが持つ提供開始年月を返す() {
            assertThat(sut.get提供開始年月(), is(kaigoServiceNaiyouEntity.getTeikyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(kaigoServiceNaiyouEntity.getRirekiNo()));
        }

        @Test
        public void get提供終了年月は_entityが持つ提供終了年月を返す() {
            assertThat(sut.get提供終了年月(), is(kaigoServiceNaiyouEntity.getTeikyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(kaigoServiceNaiyouEntity.getServiceName()));
        }

        @Test
        public void getサービス略称は_entityが持つサービス略称を返す() {
            assertThat(sut.getサービス略称(), is(kaigoServiceNaiyouEntity.getServiceNameRyaku()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(kaigoServiceNaiyouEntity.getTaniSu()));
        }
//
//        @Test
//        public void get単位数識別は_entityが持つ単位数識別を返す() {
//            assertThat(sut.get単位数識別(), is(kaigoServiceNaiyouEntity.getTanisuShikibetsuCode()));
//        }
//
//        @Test
//        public void get単位数算定単位は_entityが持つ単位数算定単位を返す() {
//            assertThat(sut.get単位数算定単位(), is(kaigoServiceNaiyouEntity.getTanisuSanteiTaniCode()));
//        }
//
//        @Test
//        public void get異動事由は_entityが持つ異動事由を返す() {
//            assertThat(sut.get異動事由(), is(kaigoServiceNaiyouEntity.getIdouJiyuCode()));
//        }
//
//        @Test
//        public void get限度額対象外フラグは_entityが持つ限度額対象外フラグを返す() {
//            assertThat(sut.get限度額対象外フラグ(), is(kaigoServiceNaiyouEntity.getGendogakuTaishogaiFlag()));
//        }
//
//        @Test
//        public void get外部サービス利用型区分は_entityが持つ外部サービス利用型区分を返す() {
//            assertThat(sut.get外部サービス利用型区分(), is(kaigoServiceNaiyouEntity.getGaibuServiceRiyoKataKubun()));
//        }
//
//        @Test
//        public void get特別地域加算フラグは_entityが持つ特別地域加算フラグを返す() {
//            assertThat(sut.get特別地域加算フラグ(), is(kaigoServiceNaiyouEntity.getTokubetsuChiikiKasanFlag()));
//        }
//
//        @Test
//        public void get利用者負担定率・定額区分は_entityが持つ利用者負担定率・定額区分を返す() {
//            assertThat(sut.get利用者負担定率・定額区分(), is(kaigoServiceNaiyouEntity.getRiyosyaFutanTeiritsuTeigakuKubun()));
//        }
//
//        @Test
//        public void get更新有無フラグは_entityが持つ更新有無フラグを返す() {
//            assertThat(sut.get更新有無フラグ(), is(kaigoServiceNaiyouEntity.getKoshinUmuFoag()));
//        }
//
//        @Test
//        public void get元点数は_entityが持つ元点数を返す() {
//            assertThat(sut.get元点数(), is(kaigoServiceNaiyouEntity.getMotoTensu()));
//        }
//
//        @Test
//        public void get元限度額対象外フラグは_entityが持つ元限度額対象外フラグを返す() {
//            assertThat(sut.get元限度額対象外フラグ(), is(kaigoServiceNaiyouEntity.getMotoGendogakuTaishogaiFlag()));
//        }
//
//        @Test
//        public void get元単位数識別コードは_entityが持つ元単位数識別コードを返す() {
//            assertThat(sut.get元単位数識別コード(), is(kaigoServiceNaiyouEntity.getMotoTaniShikibetsuCd()));
//        }
//
//        @Test
//        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
//            assertThat(sut.get利用者負担額(), is(kaigoServiceNaiyouEntity.getRiyoshaFutanGaku()));
//        }
//
//        @Test
//        public void get給付率は_entityが持つ給付率を返す() {
//            assertThat(sut.get給付率(), is(kaigoServiceNaiyouEntity.getKyufuRitsu()));
//        }
//
//        @Test
//        public void get二次予防事業対象者実施区分（非該当）は_entityが持つ二次予防事業対象者実施区分（非該当）を返す() {
//            assertThat(sut.get二次予防事業対象者実施区分（非該当）(), is(kaigoServiceNaiyouEntity.getNijiyoboJigyoTaishaJishiKubunHigaito()));
//        }
//
//        @Test
//        public void get要支援１受給者実施区分は_entityが持つ要支援１受給者実施区分を返す() {
//            assertThat(sut.get要支援１受給者実施区分(), is(kaigoServiceNaiyouEntity.getYoshien1JukyushaJishiKubun()));
//        }
//
//        @Test
//        public void get要支援２受給者実施区分は_entityが持つ要支援２受給者実施区分を返す() {
//            assertThat(sut.get要支援２受給者実施区分(), is(kaigoServiceNaiyouEntity.getYoshien2JukyushaJishiKubun()));
//        }
//
//        @Test
//        public void get対象事業者実施区分は_entityが持つ対象事業者実施区分を返す() {
//            assertThat(sut.get対象事業者実施区分(), is(kaigoServiceNaiyouEntity.getTaishoJigyoJishiKubun()));
//        }
//
//        @Test
//        public void get総合事業サービス区分は_entityが持つ総合事業サービス区分を返す() {
//            assertThat(sut.get総合事業サービス区分(), is(kaigoServiceNaiyouEntity.getSogoJigyoServiceKubun()));
//        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();

            sut = new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(kaigoServiceNaiyouEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();

            sut = new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;
        private static KaigoServiceNaiyou result;

        @BeforeClass
        public static void setUpClass() {
            kaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();

        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoServiceNaiyou setStateKaigoServiceNaiyou(EntityDataState parentState) {
            kaigoServiceNaiyouEntity.setState(parentState);
            return new KaigoServiceNaiyou(kaigoServiceNaiyouEntity);
        }
    }
}
