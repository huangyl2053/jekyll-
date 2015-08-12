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
 * {@link ShokanShakaiFukushiHojinKeigengaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShakaiFukushiHojinKeigengakuTest extends DbcTestBase {

    private static DbT3051ShokanShakaiFukushiHojinKeigengakuEntity ShokanShakaiFukushiHojinKeigengakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShakaiFukushiHojinKeigengaku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShakaiFukushiHojinKeigengaku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityにセットされている() {
            sut = new ShokanShakaiFukushiHojinKeigengaku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShakaiFukushiHojinKeigengakuIdentifierにセットされている() {
            sut = new ShokanShakaiFukushiHojinKeigengaku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShakaiFukushiHojinKeigengaku(null);
        }

        @Test
        public void 指定したDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのキー情報を識別子が持つ() {

            sut = new ShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new ShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getRirekiNo()));
        }

        @Test
        public void get軽減率は_entityが持つ軽減率を返す() {
            assertThat(sut.get軽減率(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getKeigenritsu()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get受領すべき利用者負担の総額は_entityが持つ受領すべき利用者負担の総額を返す() {
            assertThat(sut.get受領すべき利用者負担の総額(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getRiyoshaFutangakuTotal()));
        }

        @Test
        public void get軽減額は_entityが持つ軽減額を返す() {
            assertThat(sut.get軽減額(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getKeigengaku()));
        }

        @Test
        public void get軽減後利用者負担額は_entityが持つ軽減後利用者負担額を返す() {
            assertThat(sut.get軽減後利用者負担額(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getKeigengoRiyoshaFutangaku()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(ShokanShakaiFukushiHojinKeigengakuEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new ShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShakaiFukushiHojinKeigengakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new ShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShakaiFukushiHojinKeigengaku sut;
        private static ShokanShakaiFukushiHojinKeigengaku result;

        @Before
        public void setUp() {
            ShokanShakaiFukushiHojinKeigengakuEntity = DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            ShokanShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

        }

        @Test
        public void ShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたShokanShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateShokanShakaiFukushiHojinKeigengaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたShokanShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateShokanShakaiFukushiHojinKeigengaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたShokanShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateShokanShakaiFukushiHojinKeigengaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShakaiFukushiHojinKeigengakuが保持するDbT3051ShokanShakaiFukushiHojinKeigengakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShakaiFukushiHojinKeigengaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShakaiFukushiHojinKeigengaku setStateShokanShakaiFukushiHojinKeigengaku(EntityDataState parentState) {
            ShokanShakaiFukushiHojinKeigengakuEntity.setState(parentState);
            return new ShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuEntity);
        }
    }
}
