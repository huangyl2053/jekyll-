/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
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
 * {@link ShikakuShutokuJogaisha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuJogaishaTest extends DbzTestBase {

    private static DbT1009ShikakuShutokuJogaishaEntity ShikakuShutokuJogaishaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShikakuShutokuJogaisha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShikakuShutokuJogaisha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT1009ShikakuShutokuJogaishaEntityにセットされている() {
            sut = new ShikakuShutokuJogaisha(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShikakuShutokuJogaishaIdentifierにセットされている() {
            sut = new ShikakuShutokuJogaisha(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShikakuShutokuJogaisha(null);
        }

        @Test
        public void 指定したDbT1009ShikakuShutokuJogaishaEntityのキー情報を識別子が持つ() {

            sut = new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);

            sut = new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShikakuShutokuJogaishaEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShikakuShutokuJogaishaEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShikakuShutokuJogaishaEntity.getShichosonCode()));
        }

        @Test
        public void get資格取得除外理由は_entityが持つ資格取得除外理由を返す() {
            assertThat(sut.get資格取得除外理由(), is(ShikakuShutokuJogaishaEntity.getShikakuShutokuJogaiRiyu()));
        }

        @Test
        public void get資格取得除外年月日は_entityが持つ資格取得除外年月日を返す() {
            assertThat(sut.get資格取得除外年月日(), is(ShikakuShutokuJogaishaEntity.getShikakuShutokuJogaiYMD()));
        }

        @Test
        public void get資格取得除外解除年月日は_entityが持つ資格取得除外解除年月日を返す() {
            assertThat(sut.get資格取得除外解除年月日(), is(ShikakuShutokuJogaishaEntity.getShikakuShutokuJogaiKaijoYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);

            sut = new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShikakuShutokuJogaishaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);

            sut = new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShikakuShutokuJogaisha sut;
        private static ShikakuShutokuJogaisha result;

        @Before
        public void setUp() {
            ShikakuShutokuJogaishaEntity = DbT1009ShikakuShutokuJogaishaEntityGenerator.createDbT1009ShikakuShutokuJogaishaEntity();
            ShikakuShutokuJogaishaEntity.setXXX(主キー名1);
            ShikakuShutokuJogaishaEntity.setXXX(主キー名2);

        }

        @Test
        public void ShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがDeletedに指定されたShikakuShutokuJogaishaが返る() {
            sut = TestSupport.setStateShikakuShutokuJogaisha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがDeletedに指定されたShikakuShutokuJogaishaが返る() {
            sut = TestSupport.setStateShikakuShutokuJogaisha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがDeletedに指定されたShikakuShutokuJogaishaが返る() {
            sut = TestSupport.setStateShikakuShutokuJogaisha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShikakuShutokuJogaishaが保持するDbT1009ShikakuShutokuJogaishaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShikakuShutokuJogaisha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShikakuShutokuJogaisha setStateShikakuShutokuJogaisha(EntityDataState parentState) {
            ShikakuShutokuJogaishaEntity.setState(parentState);
            return new ShikakuShutokuJogaisha(ShikakuShutokuJogaishaEntity);
        }
    }
}
