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
 * {@link ShokanJutakuKaishuJizenShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuJizenShinseiTest extends DbcTestBase {

    private static DbT3035ShokanJutakuKaishuJizenShinseiEntity ShokanJutakuKaishuJizenShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJutakuKaishuJizenShinsei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJutakuKaishuJizenShinsei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityにセットされている() {
            sut = new ShokanJutakuKaishuJizenShinsei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanJutakuKaishuJizenShinseiIdentifierにセットされている() {
            sut = new ShokanJutakuKaishuJizenShinsei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanJutakuKaishuJizenShinsei(null);
        }

        @Test
        public void 指定したDbT3035ShokanJutakuKaishuJizenShinseiEntityのキー情報を識別子が持つ() {

            sut = new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanJutakuKaishuJizenShinseiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(ShokanJutakuKaishuJizenShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(ShokanJutakuKaishuJizenShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaNo()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaNameKanji()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaNameKana()));
        }

        @Test
        public void get事業者郵便番号は_entityが持つ事業者郵便番号を返す() {
            assertThat(sut.get事業者郵便番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaYubunNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaAddress()));
        }

        @Test
        public void get事業者電話番号は_entityが持つ事業者電話番号を返す() {
            assertThat(sut.get事業者電話番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaTelNo()));
        }

        @Test
        public void get事業者ＦＡＸ番号は_entityが持つ事業者ＦＡＸ番号を返す() {
            assertThat(sut.get事業者ＦＡＸ番号(), is(ShokanJutakuKaishuJizenShinseiEntity.getJigyoshaFaxNo()));
        }

        @Test
        public void get理由書作成者は_entityが持つ理由書作成者を返す() {
            assertThat(sut.get理由書作成者(), is(ShokanJutakuKaishuJizenShinseiEntity.getRiyushoSakuseishaKanji()));
        }

        @Test
        public void get理由書作成者カナは_entityが持つ理由書作成者カナを返す() {
            assertThat(sut.get理由書作成者カナ(), is(ShokanJutakuKaishuJizenShinseiEntity.getRiyushoSakuseishaKana()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanJutakuKaishuJizenShinseiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get契約決定年月日は_entityが持つ契約決定年月日を返す() {
            assertThat(sut.get契約決定年月日(), is(ShokanJutakuKaishuJizenShinseiEntity.getKeiyakuKetteiYMD()));
        }

        @Test
        public void get承認区分は_entityが持つ承認区分を返す() {
            assertThat(sut.get承認区分(), is(ShokanJutakuKaishuJizenShinseiEntity.getShoninKubun()));
        }

        @Test
        public void get不承認の理由は_entityが持つ不承認の理由を返す() {
            assertThat(sut.get不承認の理由(), is(ShokanJutakuKaishuJizenShinseiEntity.getFushoninRiyu()));
        }

        @Test
        public void get給付額等・費用額合計は_entityが持つ給付額等・費用額合計を返す() {
            assertThat(sut.get給付額等・費用額合計(), is(ShokanJutakuKaishuJizenShinseiEntity.getKyufugakuHiyogakuTotal()));
        }

        @Test
        public void get給付額等・保険対象費用額は_entityが持つ給付額等・保険対象費用額を返す() {
            assertThat(sut.get給付額等・保険対象費用額(), is(ShokanJutakuKaishuJizenShinseiEntity.getKyufugakuHokenTaishoHiyogaku()));
        }

        @Test
        public void get給付額等・利用者自己負担額は_entityが持つ給付額等・利用者自己負担額を返す() {
            assertThat(sut.get給付額等・利用者自己負担額(), is(ShokanJutakuKaishuJizenShinseiEntity.getKyufugakuRiyoshaJikofutangaku()));
        }

        @Test
        public void get給付額等・保険給付費額は_entityが持つ給付額等・保険給付費額を返す() {
            assertThat(sut.get給付額等・保険給付費額(), is(ShokanJutakuKaishuJizenShinseiEntity.getKyufugakuHokenkyufuhigaku()));
        }

        @Test
        public void get施工完了予定年月日は_entityが持つ施工完了予定年月日を返す() {
            assertThat(sut.get施工完了予定年月日(), is(ShokanJutakuKaishuJizenShinseiEntity.getSekoKanryoYoteiYMD()));
        }

        @Test
        public void get申請取消事由コードは_entityが持つ申請取消事由コードを返す() {
            assertThat(sut.get申請取消事由コード(), is(ShokanJutakuKaishuJizenShinseiEntity.getShinseiTorikeshiJiyuCode()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(ShokanJutakuKaishuJizenShinseiEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanJutakuKaishuJizenShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);

            sut = new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinsei sut;
        private static ShokanJutakuKaishuJizenShinsei result;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.createDbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setXXX(主キー名2);

        }

        @Test
        public void ShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuJizenShinseiが返る() {
            sut = TestSupport.setStateShokanJutakuKaishuJizenShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuJizenShinseiが返る() {
            sut = TestSupport.setStateShokanJutakuKaishuJizenShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがDeletedに指定されたShokanJutakuKaishuJizenShinseiが返る() {
            sut = TestSupport.setStateShokanJutakuKaishuJizenShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanJutakuKaishuJizenShinseiが保持するDbT3035ShokanJutakuKaishuJizenShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanJutakuKaishuJizenShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanJutakuKaishuJizenShinsei setStateShokanJutakuKaishuJizenShinsei(EntityDataState parentState) {
            ShokanJutakuKaishuJizenShinseiEntity.setState(parentState);
            return new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);
        }
    }
}
