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
 * {@link DaisanshaKoiSongaiBaishoKinJuryo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiSongaiBaishoKinJuryoTest extends DbcTestBase {

    private static DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity DaisanshaKoiSongaiBaishoKinJuryoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityにセットされている() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiSongaiBaishoKinJuryoIdentifierにセットされている() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiSongaiBaishoKinJuryo(null);
        }

        @Test
        public void 指定したDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get第三者行為求償請求番号は_entityが持つ第三者行為求償請求番号を返す() {
            assertThat(sut.get第三者行為求償請求番号(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getKyushoSeikyuNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getRirekiNo()));
        }

        @Test
        public void get入金確認年月日は_entityが持つ入金確認年月日を返す() {
            assertThat(sut.get入金確認年月日(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getNyukinKakuninYMD()));
        }

        @Test
        public void get領収年月日は_entityが持つ領収年月日を返す() {
            assertThat(sut.get領収年月日(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getRyoshuYMD()));
        }

        @Test
        public void get領収金額は_entityが持つ領収金額を返す() {
            assertThat(sut.get領収金額(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getRyoshuKingaku()));
        }

        @Test
        public void get過不足金有無は_entityが持つ過不足金有無を返す() {
            assertThat(sut.get過不足金有無(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getMabusokuKinUMU()));
        }

        @Test
        public void get過不足額は_entityが持つ過不足額を返す() {
            assertThat(sut.get過不足額(), is(DaisanshaKoiSongaiBaishoKinJuryoEntity.getKabusokuGaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiSongaiBaishoKinJuryoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryo sut;
        private static DaisanshaKoiSongaiBaishoKinJuryo result;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setXXX(主キー名2);

        }

        @Test
        public void DaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiSongaiBaishoKinJuryoが返る() {
            sut = TestSupport.setStateDaisanshaKoiSongaiBaishoKinJuryo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiSongaiBaishoKinJuryoが返る() {
            sut = TestSupport.setStateDaisanshaKoiSongaiBaishoKinJuryo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiSongaiBaishoKinJuryoが返る() {
            sut = TestSupport.setStateDaisanshaKoiSongaiBaishoKinJuryo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiSongaiBaishoKinJuryoが保持するDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiSongaiBaishoKinJuryo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiSongaiBaishoKinJuryo setStateDaisanshaKoiSongaiBaishoKinJuryo(EntityDataState parentState) {
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setState(parentState);
            return new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);
        }
    }
}
