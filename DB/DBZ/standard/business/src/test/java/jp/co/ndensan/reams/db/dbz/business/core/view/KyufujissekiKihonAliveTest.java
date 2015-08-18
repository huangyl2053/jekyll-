/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3017KyufujissekiKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKihonAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonAliveTest extends DbzTestBase {

    private static DbV3017KyufujissekiKihonEntity KyufujissekiKihonAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 給付実績情報作成区分コード;
    private static RString 給付実績区分コード;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号;
        給付実績情報作成区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード;
        給付実績区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード;
        通し番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, null, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, null, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名5がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, null, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名6がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, null, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名7がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, null, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名8がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, null, 給付実績区分コード, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名9がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, null, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名10がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
        }

        @Test
        public void 指定したキーが保持するDbV3017KyufujissekiKihonEntityにセットされている() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
            assertThat(sut.get入力識別番号(), is(入力識別番号));
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.get事業所番号(), is(事業所番号));
            assertThat(sut.get給付実績情報作成区分コード(), is(給付実績情報作成区分コード));
            assertThat(sut.get給付実績区分コード(), is(給付実績区分コード));
            assertThat(sut.get通し番号(), is(通し番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiKihonAliveIdentifierにセットされている() {
            sut = new KyufujissekiKihonAlive(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
            //TODO
//            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
//            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiKihonAlive(null);
        }

        @Test
        public void 指定したDbV3017KyufujissekiKihonEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);

            //TODO
//            assertThat(sut.identifier().getXXX(), is(主キー名1));
//            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();

            sut = new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiKihonAliveEntity.getKokanShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiKihonAliveEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiKihonAliveEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiKihonAliveEntity.getHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiKihonAliveEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiKihonAliveEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiKihonAliveEntity.getJigyoshoNo()));
        }

        @Test
        public void get給付実績情報作成区分コードは_entityが持つ給付実績情報作成区分コードを返す() {
            assertThat(sut.get給付実績情報作成区分コード(), is(KyufujissekiKihonAliveEntity.getKyufuSakuseiKubunCode()));
        }

        @Test
        public void get給付実績区分コードは_entityが持つ給付実績区分コードを返す() {
            assertThat(sut.get給付実績区分コード(), is(KyufujissekiKihonAliveEntity.getKyufuJissekiKubunCode()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiKihonAliveEntity.getToshiNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();

            sut = new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiKihonAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();

            sut = new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyufujissekiKihonAlive sut;
        private static KyufujissekiKihonAlive result;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiKihonAliveEntity = DbV3017KyufujissekiKihonEntityGenerator.createDbV3017KyufujissekiKihonEntity();

        }

        @Test
        public void KyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonAliveが返る() {
            sut = TestSupport.setStateKyufujissekiKihonAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonAliveが返る() {
            sut = TestSupport.setStateKyufujissekiKihonAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがDeletedに指定されたKyufujissekiKihonAliveが返る() {
            sut = TestSupport.setStateKyufujissekiKihonAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiKihonAliveが保持するDbV3017KyufujissekiKihonEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiKihonAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiKihonAlive setStateKyufujissekiKihonAlive(EntityDataState parentState) {
            KyufujissekiKihonAliveEntity.setState(parentState);
            return new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);
        }
    }
}
