/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiGokei;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikoSakuseiGokei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiGokeiTest extends DbzTestBase {

    private static DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity KyotakuKeikakuJikoSakuseiGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiGokeiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakuseiGokei(null);
        }

        @Test
        public void 指定したDbT3009KyotakuKeikakuJikoSakuseiGokeiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);

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
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);

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
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);

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
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setXXX(主キー名2);

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
