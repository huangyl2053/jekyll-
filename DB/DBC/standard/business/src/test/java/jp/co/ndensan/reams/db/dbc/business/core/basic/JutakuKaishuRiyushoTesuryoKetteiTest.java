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
 * {@link JutakuKaishuRiyushoTesuryoKettei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoKetteiTest extends DbcTestBase {

    private static DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity JutakuKaishuRiyushoTesuryoKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoKettei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoKettei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoKettei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJutakuKaishuRiyushoTesuryoKetteiIdentifierにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoKettei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JutakuKaishuRiyushoTesuryoKettei(null);
        }

        @Test
        public void 指定したDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのキー情報を識別子が持つ() {

            sut = new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);
        }

        @Test
        public void get介護住宅改修理由書作成事業者番号は_entityが持つ介護住宅改修理由書作成事業者番号を返す() {
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getRiyushoSakuseiJigyoshaNo()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getKetteiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getRirekiNo()));
        }

        @Test
        public void get支給・不支給決定年月日は_entityが持つ支給・不支給決定年月日を返す() {
            assertThat(sut.get支給・不支給決定年月日(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getShikyu_FushikyuKetteiYMD()));
        }

        @Test
        public void get支給・不支給区分は_entityが持つ支給・不支給区分を返す() {
            assertThat(sut.get支給・不支給区分(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getShikyu_FushikyuKubun()));
        }

        @Test
        public void get償還不支給理由等は_entityが持つ償還不支給理由等を返す() {
            assertThat(sut.get償還不支給理由等(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getFushikyuRiyu()));
        }

        @Test
        public void get住宅改修理由書作成手数料支払予定日は_entityが持つ住宅改修理由書作成手数料支払予定日を返す() {
            assertThat(sut.get住宅改修理由書作成手数料支払予定日(), is(JutakuKaishuRiyushoTesuryoKetteiEntity.getTesuryoShiharaiYoteiYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JutakuKaishuRiyushoTesuryoKetteiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKettei sut;
        private static JutakuKaishuRiyushoTesuryoKettei result;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);

        }

        @Test
        public void JutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoKetteiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoKettei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoKetteiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoKettei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoKetteiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoKettei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JutakuKaishuRiyushoTesuryoKetteiが保持するDbT3094JutakuKaishuRiyushoTesuryoKetteiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoKettei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JutakuKaishuRiyushoTesuryoKettei setStateJutakuKaishuRiyushoTesuryoKettei(EntityDataState parentState) {
            JutakuKaishuRiyushoTesuryoKetteiEntity.setState(parentState);
            return new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);
        }
    }
}
