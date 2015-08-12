/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KogakuShikyuShinsaKettei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinsaKetteiTest extends DbcTestBase {

    private static DbT3112KogakuShikyuShinsaKetteiEntity KogakuShikyuShinsaKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuShikyuShinsaKettei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuShikyuShinsaKettei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3112KogakuShikyuShinsaKetteiEntityにセットされている() {
            sut = new KogakuShikyuShinsaKettei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuShikyuShinsaKetteiIdentifierにセットされている() {
            sut = new KogakuShikyuShinsaKettei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuShikyuShinsaKettei(null);
        }

        @Test
        public void 指定したDbT3112KogakuShikyuShinsaKetteiEntityのキー情報を識別子が持つ() {

            sut = new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);

            sut = new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);
        }

        @Test
        public void get決定者受取年月は_entityが持つ決定者受取年月を返す() {
            assertThat(sut.get決定者受取年月(), is(KogakuShikyuShinsaKetteiEntity.getKetteishaUketoriYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KogakuShikyuShinsaKetteiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuShikyuShinsaKetteiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KogakuShikyuShinsaKetteiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(KogakuShikyuShinsaKetteiEntity.getTsuchishoNo()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KogakuShikyuShinsaKetteiEntity.getRiyoshaFutanGaku()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(KogakuShikyuShinsaKetteiEntity.getShikyuKubunCode()));
        }

        @Test
        public void get決定年月は_entityが持つ決定年月を返す() {
            assertThat(sut.get決定年月(), is(KogakuShikyuShinsaKetteiEntity.getKetteiYM()));
        }

        @Test
        public void get事業高額支給額は_entityが持つ事業高額支給額を返す() {
            assertThat(sut.get事業高額支給額(), is(KogakuShikyuShinsaKetteiEntity.getJigyoKogakuShikyuGaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);

            sut = new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuShikyuShinsaKetteiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);

            sut = new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuShikyuShinsaKettei sut;
        private static KogakuShikyuShinsaKettei result;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setXXX(主キー名2);

        }

        @Test
        public void KogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinsaKetteiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsaKettei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinsaKetteiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsaKettei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinsaKetteiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsaKettei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuShikyuShinsaKetteiが保持するDbT3112KogakuShikyuShinsaKetteiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuShikyuShinsaKettei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuShikyuShinsaKettei setStateKogakuShikyuShinsaKettei(EntityDataState parentState) {
            KogakuShikyuShinsaKetteiEntity.setState(parentState);
            return new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);
        }
    }
}
