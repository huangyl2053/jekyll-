/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiGokei;
import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikoSakuseiGokei}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiGokeiTest extends DbzTestBase {

    private static DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity KyotakuKeikakuJikoSakuseiGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;
    private static RString 居宅サービス区分;
    private static JigyoshaNo 事業者番号;
    private static ServiceShuruiCode サービス種類コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
        居宅サービス区分 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
        事業者番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
        サービス種類コード = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(null, 対象年月, 履歴番号, 居宅サービス区分, 事業者番号, サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, null, 履歴番号, 居宅サービス区分, 事業者番号, サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, null, 居宅サービス区分, 事業者番号, サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 居宅サービス区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, 履歴番号, null, 事業者番号, サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, null, サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, 事業者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, 事業者番号, サービス種類コード);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get対象年月(), is(対象年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
            assertThat(sut.get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.getサービス提供事業者番号(), is(事業者番号));
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiGokeiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, 事業者番号, サービス種類コード);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.identifier().getサービス提供事業者番号(), is(事業者番号));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(null);
        }

        @Test
        public void 指定したDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.identifier().getサービス提供事業者番号(), is(事業者番号));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);

            sut = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getRirekiNo()));
        }

        @Test
        public void get居宅サービス区分は_entityが持つ居宅サービス区分を返す() {
            assertThat(sut.get居宅サービス区分(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getKyotakuServiceKubun()));
        }

        @Test
        public void getサービス提供事業者番号は_entityが持つサービス提供事業者番号を返す() {
            assertThat(sut.getサービス提供事業者番号(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getServiceTeikyoJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get給付計画単位数は_entityが持つ給付計画単位数を返す() {
            assertThat(sut.get給付計画単位数(), is(KyotakuKeikakuJikoSakuseiGokeiEntity.getKyufuKeikakuTaniSu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);

            sut = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikoSakuseiGokeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);

            sut = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;
        private static KyotakuKeikakuJikoSakuseiGokei result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);

        }

        @Test
        public void KyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiGokei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiGokei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiGokei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikoSakuseiGokeiが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiGokei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakuseiGokei setStateKyotakuKeikakuJikoSakuseiGokei(EntityDataState parentState) {
            KyotakuKeikakuJikoSakuseiGokeiEntity.setState(parentState);
            return new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);
        }
    }
}
