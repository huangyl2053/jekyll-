/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuJuryoininKeiyakuJigyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuJuryoininKeiyakuJigyoshaTest extends DbcTestBase {

    private static DbT3076KogakuJuryoininKeiyakuJigyoshaEntity KogakuJuryoininKeiyakuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static int 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuJuryoininKeiyakuJigyosha(null, 主キー名2);
        }

        @Test
        public void 指定したキーが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityにセットされている() {
            sut = new KogakuJuryoininKeiyakuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get履歴番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuJuryoininKeiyakuJigyoshaIdentifierにセットされている() {
            sut = new KogakuJuryoininKeiyakuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuJuryoininKeiyakuJigyosha(null);
        }

        @Test
        public void 指定したDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new KogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);

            sut = new KogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getRirekiNo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getShinseiYMD()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getKetteiYMD()));
        }

        @Test
        public void get承認結果区分は_entityが持つ承認結果区分を返す() {
            assertThat(sut.get承認結果区分(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getShoninKekkaKubun()));
        }

        @Test
        public void get受領委任払適用開始年月日は_entityが持つ受領委任払適用開始年月日を返す() {
            assertThat(sut.get受領委任払適用開始年月日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getJuryoininKaishiYMD()));
        }

        @Test
        public void get受領委任払適用終了年月日は_entityが持つ受領委任払適用終了年月日を返す() {
            assertThat(sut.get受領委任払適用終了年月日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getJuryoininShuryoYMD()));
        }

        @Test
        public void get契約番号は_entityが持つ契約番号を返す() {
            assertThat(sut.get契約番号(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getKeiyakuNo()));
        }

        @Test
        public void get不承認理由は_entityが持つ不承認理由を返す() {
            assertThat(sut.get不承認理由(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getFuShoninRiyu()));
        }

        @Test
        public void get利用者負担上限額は_entityが持つ利用者負担上限額を返す() {
            assertThat(sut.get利用者負担上限額(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getRiyoshaFutanJogenGaku()));
        }

        @Test
        public void get承認結果通知書作成日は_entityが持つ承認結果通知書作成日を返す() {
            assertThat(sut.get承認結果通知書作成日(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getShoninKekkaTsuchiSakuseiYMD()));
        }

        @Test
        public void get承認結果通知書再発行区分は_entityが持つ承認結果通知書再発行区分を返す() {
            assertThat(sut.get承認結果通知書再発行区分(), is(KogakuJuryoininKeiyakuJigyoshaEntity.getShoninKekkaTsuchiSaiHakkoKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);

            sut = new KogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuJuryoininKeiyakuJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);

            sut = new KogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuJuryoininKeiyakuJigyosha sut;
        private static KogakuJuryoininKeiyakuJigyosha result;

        @Before
        public void setUp() {
            KogakuJuryoininKeiyakuJigyoshaEntity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyoshaEntity.setHihokenshaNo(主キー名1);
            KogakuJuryoininKeiyakuJigyoshaEntity.setRirekiNo(主キー名2);

        }

        @Test
        public void KogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたKogakuJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateKogakuJuryoininKeiyakuJigyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたKogakuJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateKogakuJuryoininKeiyakuJigyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたKogakuJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateKogakuJuryoininKeiyakuJigyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuJuryoininKeiyakuJigyoshaが保持するDbT3076KogakuJuryoininKeiyakuJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuJuryoininKeiyakuJigyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuJuryoininKeiyakuJigyosha setStateKogakuJuryoininKeiyakuJigyosha(EntityDataState parentState) {
            KogakuJuryoininKeiyakuJigyoshaEntity.setState(parentState);
            return new KogakuJuryoininKeiyakuJigyosha(KogakuJuryoininKeiyakuJigyoshaEntity);
        }
    }
}
