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
 * {@link NijiYoboNiniCheckList}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboNiniCheckListTest extends DbcTestBase {

    private static DbT3102NijiYoboNiniCheckListEntity NijiYoboNiniCheckListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboNiniCheckList(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboNiniCheckList(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3102NijiYoboNiniCheckListEntityにセットされている() {
            sut = new NijiYoboNiniCheckList(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNijiYoboNiniCheckListIdentifierにセットされている() {
            sut = new NijiYoboNiniCheckList(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboNiniCheckList(null);
        }

        @Test
        public void 指定したDbT3102NijiYoboNiniCheckListEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(NijiYoboNiniCheckListEntity.getShikibetsuCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(NijiYoboNiniCheckListEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(NijiYoboNiniCheckListEntity.getUketsukeYMD()));
        }

        @Test
        public void get任意質問番号は_entityが持つ任意質問番号を返す() {
            assertThat(sut.get任意質問番号(), is(NijiYoboNiniCheckListEntity.getNiniShitsumonNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(NijiYoboNiniCheckListEntity.getRirekiNo()));
        }

        @Test
        public void get任意質問事項は_entityが持つ任意質問事項を返す() {
            assertThat(sut.get任意質問事項(), is(NijiYoboNiniCheckListEntity.getNiniShitsumonJiko()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NijiYoboNiniCheckListEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;
        private static NijiYoboNiniCheckList result;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);

        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NijiYoboNiniCheckList setStateNijiYoboNiniCheckList(EntityDataState parentState) {
            NijiYoboNiniCheckListEntity.setState(parentState);
            return new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }
    }
}
