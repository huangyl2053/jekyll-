/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.testhelper.DbbTestBase;
import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
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
 * {@link ChoshuYuyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoTest extends DbbTestBase {

    private static DbT2006ChoshuYuyoEntity ChoshuYuyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT2006ChoshuYuyoEntityにセットされている() {
            sut = new ChoshuYuyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChoshuYuyoIdentifierにセットされている() {
            sut = new ChoshuYuyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChoshuYuyo(null);
        }

        @Test
        public void 指定したDbT2006ChoshuYuyoEntityのキー情報を識別子が持つ() {

            sut = new ChoshuYuyo(ChoshuYuyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);

            sut = new ChoshuYuyo(ChoshuYuyoEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(ChoshuYuyoEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(ChoshuYuyoEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(ChoshuYuyoEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ChoshuYuyoEntity.getRirekiNo()));
        }

        @Test
        public void get徴収猶予申請年月日は_entityが持つ徴収猶予申請年月日を返す() {
            assertThat(sut.get徴収猶予申請年月日(), is(ChoshuYuyoEntity.getShinseiYMD()));
        }

        @Test
        public void get徴収猶予決定年月日は_entityが持つ徴収猶予決定年月日を返す() {
            assertThat(sut.get徴収猶予決定年月日(), is(ChoshuYuyoEntity.getKetteiYMD()));
        }

        @Test
        public void get徴収猶予取消年月日は_entityが持つ徴収猶予取消年月日を返す() {
            assertThat(sut.get徴収猶予取消年月日(), is(ChoshuYuyoEntity.getTorikeshiYMD()));
        }

        @Test
        public void get徴収猶予状態区分は_entityが持つ徴収猶予状態区分を返す() {
            assertThat(sut.get徴収猶予状態区分(), is(ChoshuYuyoEntity.getJotaiKubun()));
        }

        @Test
        public void get徴収猶予作成区分は_entityが持つ徴収猶予作成区分を返す() {
            assertThat(sut.get徴収猶予作成区分(), is(ChoshuYuyoEntity.getSakuseiKubun()));
        }

        @Test
        public void get申請事由は_entityが持つ申請事由を返す() {
            assertThat(sut.get申請事由(), is(ChoshuYuyoEntity.getShinseiJiyu()));
        }

        @Test
        public void get徴収猶予種類コードは_entityが持つ徴収猶予種類コードを返す() {
            assertThat(sut.get徴収猶予種類コード(), is(ChoshuYuyoEntity.getYuyoJiyuCode()));
        }

        @Test
        public void get徴収猶予事由は_entityが持つ徴収猶予事由を返す() {
            assertThat(sut.get徴収猶予事由(), is(ChoshuYuyoEntity.getYuyoJiyu()));
        }

        @Test
        public void get徴収猶予取消種類コードは_entityが持つ徴収猶予取消種類コードを返す() {
            assertThat(sut.get徴収猶予取消種類コード(), is(ChoshuYuyoEntity.getYuyoTorikeshiJiyuCode()));
        }

        @Test
        public void get徴収猶予取消事由は_entityが持つ徴収猶予取消事由を返す() {
            assertThat(sut.get徴収猶予取消事由(), is(ChoshuYuyoEntity.getYuyoTorikeshiJiyu()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);

            sut = new ChoshuYuyo(ChoshuYuyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChoshuYuyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);

            sut = new ChoshuYuyo(ChoshuYuyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static ChoshuYuyo sut;
        private static ChoshuYuyo result;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setXXX(主キー名1);
            ChoshuYuyoEntity.setXXX(主キー名2);

        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChoshuYuyo setStateChoshuYuyo(EntityDataState parentState) {
            ChoshuYuyoEntity.setState(parentState);
            return new ChoshuYuyo(ChoshuYuyoEntity);
        }
    }
}
