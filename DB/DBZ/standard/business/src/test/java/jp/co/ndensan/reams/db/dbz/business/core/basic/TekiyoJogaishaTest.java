/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
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
 * {@link TekiyoJogaisha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaTest extends DbzTestBase {

    private static DbT1002TekiyoJogaishaEntity TekiyoJogaishaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaisha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaisha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT1002TekiyoJogaishaEntityにセットされている() {
            sut = new TekiyoJogaisha(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTekiyoJogaishaIdentifierにセットされている() {
            sut = new TekiyoJogaisha(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TekiyoJogaisha(null);
        }

        @Test
        public void 指定したDbT1002TekiyoJogaishaEntityのキー情報を識別子が持つ() {

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TekiyoJogaishaEntity.getShikibetsuCode()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(TekiyoJogaishaEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(TekiyoJogaishaEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TekiyoJogaishaEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TekiyoJogaishaEntity.getShichosonCode()));
        }

        @Test
        public void get適用除外適用事由コードは_entityが持つ適用除外適用事由コードを返す() {
            assertThat(sut.get適用除外適用事由コード(), is(TekiyoJogaishaEntity.getTekiyoJogaiTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(TekiyoJogaishaEntity.getTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(TekiyoJogaishaEntity.getTekiyoTodokedeYMD()));
        }

        @Test
        public void get適用受付年月日は_entityが持つ適用受付年月日を返す() {
            assertThat(sut.get適用受付年月日(), is(TekiyoJogaishaEntity.getTekiyoUketsukeYMD()));
        }

        @Test
        public void get適用除外解除事由コードは_entityが持つ適用除外解除事由コードを返す() {
            assertThat(sut.get適用除外解除事由コード(), is(TekiyoJogaishaEntity.getTekiyoJogaikaijokaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(TekiyoJogaishaEntity.getKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(TekiyoJogaishaEntity.getKaijoTodokedeYMD()));
        }

        @Test
        public void get解除受付年月日は_entityが持つ解除受付年月日を返す() {
            assertThat(sut.get解除受付年月日(), is(TekiyoJogaishaEntity.getKaijoUketsukeYMD()));
        }

        @Test
        public void get入所通知発行日は_entityが持つ入所通知発行日を返す() {
            assertThat(sut.get入所通知発行日(), is(TekiyoJogaishaEntity.getNyushoTsuchiHakkoYMD()));
        }

        @Test
        public void get退所通知発行日は_entityが持つ退所通知発行日を返す() {
            assertThat(sut.get退所通知発行日(), is(TekiyoJogaishaEntity.getTaishoTsuchiHakkoYMD()));
        }

        @Test
        public void get変更通知発行日は_entityが持つ変更通知発行日を返す() {
            assertThat(sut.get変更通知発行日(), is(TekiyoJogaishaEntity.getHenkoTsuchiHakkoYMD()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(TekiyoJogaishaEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TekiyoJogaishaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;
        private static TekiyoJogaisha result;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setXXX(主キー名1);
            TekiyoJogaishaEntity.setXXX(主キー名2);

        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TekiyoJogaisha setStateTekiyoJogaisha(EntityDataState parentState) {
            TekiyoJogaishaEntity.setState(parentState);
            return new TekiyoJogaisha(TekiyoJogaishaEntity);
        }
    }
}
