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
 * {@link DaisanshaKoiKyushoMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoMeisaiTest extends DbcTestBase {

    private static DbT3083DaisanshaKoiKyushoMeisaiEntity DaisanshaKoiKyushoMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyushoMeisai(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyushoMeisai(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityにセットされている() {
            sut = new DaisanshaKoiKyushoMeisai(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiKyushoMeisaiIdentifierにセットされている() {
            sut = new DaisanshaKoiKyushoMeisai(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiKyushoMeisai(null);
        }

        @Test
        public void 指定したDbT3083DaisanshaKoiKyushoMeisaiEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiKyushoMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiKyushoMeisaiEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get第三者行為求償請求番号は_entityが持つ第三者行為求償請求番号を返す() {
            assertThat(sut.get第三者行為求償請求番号(), is(DaisanshaKoiKyushoMeisaiEntity.getKyushoSeikyuNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(DaisanshaKoiKyushoMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void getサービス提供事業者番号は_entityが持つサービス提供事業者番号を返す() {
            assertThat(sut.getサービス提供事業者番号(), is(DaisanshaKoiKyushoMeisaiEntity.getServiceTeikyoJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(DaisanshaKoiKyushoMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiKyushoMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get給付額は_entityが持つ給付額を返す() {
            assertThat(sut.get給付額(), is(DaisanshaKoiKyushoMeisaiEntity.getKyufuGaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiKyushoMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisai sut;
        private static DaisanshaKoiKyushoMeisai result;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.createDbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setXXX(主キー名2);

        }

        @Test
        public void DaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoMeisaiが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyushoMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoMeisaiが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyushoMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoMeisaiが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyushoMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiKyushoMeisaiが保持するDbT3083DaisanshaKoiKyushoMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiKyushoMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiKyushoMeisai setStateDaisanshaKoiKyushoMeisai(EntityDataState parentState) {
            DaisanshaKoiKyushoMeisaiEntity.setState(parentState);
            return new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);
        }
    }
}
