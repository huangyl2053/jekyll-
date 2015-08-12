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
 * {@link KogakuGassanShinseishoKanyureki}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoKanyurekiTest extends DbcTestBase {

    private static DbT3069KogakuGassanShinseishoKanyurekiEntity KogakuGassanShinseishoKanyurekiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseishoKanyureki(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityにセットされている() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShinseishoKanyurekiIdentifierにセットされている() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShinseishoKanyureki(null);
        }

        @Test
        public void 指定したDbT3069KogakuGassanShinseishoKanyurekiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShinseishoKanyurekiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShinseishoKanyurekiEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanShinseishoKanyurekiEntity.getHokenshaNo()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KogakuGassanShinseishoKanyurekiEntity.getSeiriNo()));
        }

        @Test
        public void get加入歴番号は_entityが持つ加入歴番号を返す() {
            assertThat(sut.get加入歴番号(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyurekiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShinseishoKanyurekiEntity.getRirekiNo()));
        }

        @Test
        public void get保険者名は_entityが持つ保険者名を返す() {
            assertThat(sut.get保険者名(), is(KogakuGassanShinseishoKanyurekiEntity.getHokenshaMei()));
        }

        @Test
        public void get加入期間開始年月日は_entityが持つ加入期間開始年月日を返す() {
            assertThat(sut.get加入期間開始年月日(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyuKaishiYMD()));
        }

        @Test
        public void get加入期間終了年月日は_entityが持つ加入期間終了年月日を返す() {
            assertThat(sut.get加入期間終了年月日(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyuShuryoYMD()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanShinseishoKanyurekiEntity.getJikoFutanShomeisho_SeiriNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShinseishoKanyurekiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;
        private static KogakuGassanShinseishoKanyureki result;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);

        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShinseishoKanyureki setStateKogakuGassanShinseishoKanyureki(EntityDataState parentState) {
            KogakuGassanShinseishoKanyurekiEntity.setState(parentState);
            return new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }
    }
}
