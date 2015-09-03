/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3098TandokuJoseikinKyufuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link TandokuJoseikinKyufuShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuShinseiTest extends DbcTestBase {

    private static DbT3098TandokuJoseikinKyufuShinseiEntity TandokuJoseikinKyufuShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseikinKyufuShinsei(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseikinKyufuShinsei(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3098TandokuJoseikinKyufuShinseiEntityにセットされている() {
            sut = new TandokuJoseikinKyufuShinsei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get受付年月日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTandokuJoseikinKyufuShinseiIdentifierにセットされている() {
            sut = new TandokuJoseikinKyufuShinsei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get受付年月日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TandokuJoseikinKyufuShinsei(null);
        }

        @Test
        public void 指定したDbT3098TandokuJoseikinKyufuShinseiEntityのキー情報を識別子が持つ() {

            sut = new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get受付年月日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);

            sut = new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(TandokuJoseikinKyufuShinseiEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(TandokuJoseikinKyufuShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TandokuJoseikinKyufuShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(TandokuJoseikinKyufuShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get申請者区分は_entityが持つ申請者区分を返す() {
            assertThat(sut.get申請者区分(), is(TandokuJoseikinKyufuShinseiEntity.getShinseishaKubun()));
        }

        @Test
        public void get申請代行事業者番号は_entityが持つ申請代行事業者番号を返す() {
            assertThat(sut.get申請代行事業者番号(), is(TandokuJoseikinKyufuShinseiEntity.getDaikoJigyoshaNo()));
        }

        @Test
        public void get事業者区分は_entityが持つ事業者区分を返す() {
            assertThat(sut.get事業者区分(), is(TandokuJoseikinKyufuShinseiEntity.getJigyoshaKubun()));
        }

        @Test
        public void get申請者郵便番号は_entityが持つ申請者郵便番号を返す() {
            assertThat(sut.get申請者郵便番号(), is(TandokuJoseikinKyufuShinseiEntity.getShinseishaYubinNo()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(TandokuJoseikinKyufuShinseiEntity.getShinseishaJusho()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(TandokuJoseikinKyufuShinseiEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(TandokuJoseikinKyufuShinseiEntity.getShinseiRiyu()));
        }

        @Test
        public void get市町村単独助成種類は_entityが持つ市町村単独助成種類を返す() {
            assertThat(sut.get市町村単独助成種類(), is(TandokuJoseikinKyufuShinseiEntity.getTandokuJoseiShuruiCode()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);

            sut = new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TandokuJoseikinKyufuShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);

            sut = new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuShinsei sut;
        private static TandokuJoseikinKyufuShinsei result;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.createDbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setUketsukeYMD(主キー名2);

        }

        @Test
        public void TandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuShinseiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuShinseiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuShinseiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TandokuJoseikinKyufuShinseiが保持するDbT3098TandokuJoseikinKyufuShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTandokuJoseikinKyufuShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TandokuJoseikinKyufuShinsei setStateTandokuJoseikinKyufuShinsei(EntityDataState parentState) {
            TandokuJoseikinKyufuShinseiEntity.setState(parentState);
            return new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);
        }
    }
}
