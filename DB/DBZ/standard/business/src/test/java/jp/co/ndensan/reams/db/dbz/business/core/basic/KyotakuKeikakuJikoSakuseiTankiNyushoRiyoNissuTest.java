/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
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
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuTest extends DbzTestBase {

    private static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(null);
        }

        @Test
        public void 指定したDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getRirekiNo()));
        }

        @Test
        public void get前回迄利用日数は_entityが持つ前回迄利用日数を返す() {
            assertThat(sut.get前回迄利用日数(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getZenkaiRiyoNissu()));
        }

        @Test
        public void get今回計画利用日数は_entityが持つ今回計画利用日数を返す() {
            assertThat(sut.get今回計画利用日数(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getKonkaiKeikakuRiyoNissu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;
        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);

        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState parentState) {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setState(parentState);
            return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }
    }
}
