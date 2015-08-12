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
 * {@link ShokanJutakuKaishu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuTest extends DbcTestBase {

    private static DbT3049ShokanJutakuKaishuEntity ShokanJutakuKaishuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJutakuKaishu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJutakuKaishu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3049ShokanJutakuKaishuEntityにセットされている() {
            sut = new ShokanJutakuKaishu(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanJutakuKaishuIdentifierにセットされている() {
            sut = new ShokanJutakuKaishu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanJutakuKaishu(null);
        }

        @Test
        public void 指定したDbT3049ShokanJutakuKaishuEntityのキー情報を識別子が持つ() {

            sut = new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanJutakuKaishuEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanJutakuKaishuEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanJutakuKaishuEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanJutakuKaishuEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanJutakuKaishuEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanJutakuKaishuEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanJutakuKaishuEntity.getRirekiNo()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(ShokanJutakuKaishuEntity.getServiceCode()));
        }

        @Test
        public void get住宅改修着工年月日は_entityが持つ住宅改修着工年月日を返す() {
            assertThat(sut.get住宅改修着工年月日(), is(ShokanJutakuKaishuEntity.getJutakuKaishuChakkoYMD()));
        }

        @Test
        public void get住宅改修事業者名は_entityが持つ住宅改修事業者名を返す() {
            assertThat(sut.get住宅改修事業者名(), is(ShokanJutakuKaishuEntity.getJutakuKaishuJigyoshaName()));
        }

        @Test
        public void get住宅改修住宅住所は_entityが持つ住宅改修住宅住所を返す() {
            assertThat(sut.get住宅改修住宅住所(), is(ShokanJutakuKaishuEntity.getJutakuKaishuJutakuAddress()));
        }

        @Test
        public void get改修金額は_entityが持つ改修金額を返す() {
            assertThat(sut.get改修金額(), is(ShokanJutakuKaishuEntity.getKaishuKingaku()));
        }

        @Test
        public void get審査方法区分コードは_entityが持つ審査方法区分コードを返す() {
            assertThat(sut.get審査方法区分コード(), is(ShokanJutakuKaishuEntity.getShinsaHohoKubunCode()));
        }

        @Test
        public void get住宅改修完成年月日は_entityが持つ住宅改修完成年月日を返す() {
            assertThat(sut.get住宅改修完成年月日(), is(ShokanJutakuKaishuEntity.getJutakuKaishuKanseiYMD()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanJutakuKaishuEntity.getSagakuKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanJutakuKaishuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanJutakuKaishu sut;
        private static ShokanJutakuKaishu result;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setXXX(主キー名1);
            ShokanJutakuKaishuEntity.setXXX(主キー名2);

        }

        @Test
        public void ShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuが返る() {
            sut = TestSupport.setStateShokanJutakuKaishu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuが返る() {
            sut = TestSupport.setStateShokanJutakuKaishu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuが返る() {
            sut = TestSupport.setStateShokanJutakuKaishu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanJutakuKaishuが保持するDbT3049ShokanJutakuKaishuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanJutakuKaishu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanJutakuKaishu setStateShokanJutakuKaishu(EntityDataState parentState) {
            ShokanJutakuKaishuEntity.setState(parentState);
            return new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);
        }
    }
}
