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
 * {@link NijiYoboJigyoTaishosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboJigyoTaishoshaTest extends DbcTestBase {

    private static DbT3100NijiYoboJigyoTaishoshaEntity NijiYoboJigyoTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboJigyoTaishosha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboJigyoTaishosha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3100NijiYoboJigyoTaishoshaEntityにセットされている() {
            sut = new NijiYoboJigyoTaishosha(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNijiYoboJigyoTaishoshaIdentifierにセットされている() {
            sut = new NijiYoboJigyoTaishosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboJigyoTaishosha(null);
        }

        @Test
        public void 指定したDbT3100NijiYoboJigyoTaishoshaEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);

            sut = new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(NijiYoboJigyoTaishoshaEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(NijiYoboJigyoTaishoshaEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(NijiYoboJigyoTaishoshaEntity.getRirekiNo()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(NijiYoboJigyoTaishoshaEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(NijiYoboJigyoTaishoshaEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(NijiYoboJigyoTaishoshaEntity.getShikibetsuCode()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(NijiYoboJigyoTaishoshaEntity.getUketsukeYMD()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(NijiYoboJigyoTaishoshaEntity.getKetteiYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);

            sut = new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NijiYoboJigyoTaishoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);

            sut = new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;
        private static NijiYoboJigyoTaishosha result;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名1);
            NijiYoboJigyoTaishoshaEntity.setXXX(主キー名2);

        }

        @Test
        public void NijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたNijiYoboJigyoTaishoshaが返る() {
            sut = TestSupport.setStateNijiYoboJigyoTaishosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたNijiYoboJigyoTaishoshaが返る() {
            sut = TestSupport.setStateNijiYoboJigyoTaishosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたNijiYoboJigyoTaishoshaが返る() {
            sut = TestSupport.setStateNijiYoboJigyoTaishosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NijiYoboJigyoTaishoshaが保持するDbT3100NijiYoboJigyoTaishoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNijiYoboJigyoTaishosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NijiYoboJigyoTaishosha setStateNijiYoboJigyoTaishosha(EntityDataState parentState) {
            NijiYoboJigyoTaishoshaEntity.setState(parentState);
            return new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);
        }
    }
}
