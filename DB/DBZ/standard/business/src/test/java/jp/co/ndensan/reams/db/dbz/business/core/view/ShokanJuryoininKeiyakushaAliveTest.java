/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanJuryoininKeiyakushaAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininKeiyakushaAliveTest extends DbzTestBase {

    private static DbV3078ShokanJuryoininKeiyakushaEntity ShokanJuryoininKeiyakushaAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static FlexibleDate 受付年月日;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
        証記載保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
        受付年月日 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininKeiyakushaAlive(null, 証記載保険者番号, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininKeiyakushaAlive(被保険者番号, null, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininKeiyakushaAlive(被保険者番号, 証記載保険者番号, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbV3078ShokanJuryoininKeiyakushaEntityにセットされている() {
            sut = new ShokanJuryoininKeiyakushaAlive(被保険者番号, 証記載保険者番号, 受付年月日, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get受付年月日(), is(受付年月日));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するShokanJuryoininKeiyakushaAliveIdentifierにセットされている() {
            sut = new ShokanJuryoininKeiyakushaAlive(被保険者番号, 証記載保険者番号, 受付年月日, 履歴番号);
            //TODO
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(証記載保険者番号));
//            assertThat(sut.identifier().getXXX(), is(受付年月日));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanJuryoininKeiyakushaAlive(null);
        }

        @Test
        public void 指定したDbV3078ShokanJuryoininKeiyakushaEntityのキー情報を識別子が持つ() {

            sut = new ShokanJuryoininKeiyakushaAlive(ShokanJuryoininKeiyakushaAliveEntity);

            //TODO
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(証記載保険者番号));
//            assertThat(sut.identifier().getXXX(), is(受付年月日));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();

            sut = new ShokanJuryoininKeiyakushaAlive(ShokanJuryoininKeiyakushaAliveEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanJuryoininKeiyakushaAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(ShokanJuryoininKeiyakushaAliveEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(ShokanJuryoininKeiyakushaAliveEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanJuryoininKeiyakushaAliveEntity.getRirekiNo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(ShokanJuryoininKeiyakushaAliveEntity.getShinseiYMD()));
        }

        @Test
        public void get事業者契約番号は_entityが持つ事業者契約番号を返す() {
            assertThat(sut.get事業者契約番号(), is(ShokanJuryoininKeiyakushaAliveEntity.getJigyoshaKeiyakuNo()));
        }

        @Test
        public void get契約サービス種類は_entityが持つ契約サービス種類を返す() {
            assertThat(sut.get契約サービス種類(), is(ShokanJuryoininKeiyakushaAliveEntity.getKeiyakuServiceShurui()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(ShokanJuryoininKeiyakushaAliveEntity.getKetteiYMD()));
        }

        @Test
        public void get承認結果区分は_entityが持つ承認結果区分を返す() {
            assertThat(sut.get承認結果区分(), is(ShokanJuryoininKeiyakushaAliveEntity.getShoninKekkaKubun()));
        }

        @Test
        public void get受領委任払適用開始年月日は_entityが持つ受領委任払適用開始年月日を返す() {
            assertThat(sut.get受領委任払適用開始年月日(), is(ShokanJuryoininKeiyakushaAliveEntity.getJuryoininKaishiYMD()));
        }

        @Test
        public void get受領委任払適用終了年月日は_entityが持つ受領委任払適用終了年月日を返す() {
            assertThat(sut.get受領委任払適用終了年月日(), is(ShokanJuryoininKeiyakushaAliveEntity.getJuryoininShuryoYMD()));
        }

        @Test
        public void get契約番号は_entityが持つ契約番号を返す() {
            assertThat(sut.get契約番号(), is(ShokanJuryoininKeiyakushaAliveEntity.getKeiyakuNo()));
        }

        @Test
        public void get不承認理由は_entityが持つ不承認理由を返す() {
            assertThat(sut.get不承認理由(), is(ShokanJuryoininKeiyakushaAliveEntity.getFuShoninRiyu()));
        }

        @Test
        public void get費用額合計は_entityが持つ費用額合計を返す() {
            assertThat(sut.get費用額合計(), is(ShokanJuryoininKeiyakushaAliveEntity.getHiyoGakuGokei()));
        }

        @Test
        public void get保険対象費用額は_entityが持つ保険対象費用額を返す() {
            assertThat(sut.get保険対象費用額(), is(ShokanJuryoininKeiyakushaAliveEntity.getHokenTaishoHiyoGaku()));
        }

        @Test
        public void get利用者自己負担額は_entityが持つ利用者自己負担額を返す() {
            assertThat(sut.get利用者自己負担額(), is(ShokanJuryoininKeiyakushaAliveEntity.getRiyoshaJikoFutanGaku()));
        }

        @Test
        public void get保険給付費額は_entityが持つ保険給付費額を返す() {
            assertThat(sut.get保険給付費額(), is(ShokanJuryoininKeiyakushaAliveEntity.getHokenKyufuhiGaku()));
        }

        @Test
        public void get承認結果通知書作成日は_entityが持つ承認結果通知書作成日を返す() {
            assertThat(sut.get承認結果通知書作成日(), is(ShokanJuryoininKeiyakushaAliveEntity.getShoninKekkaTsuchiSakuseiYMD()));
        }

        @Test
        public void get承認結果通知書再発行区分は_entityが持つ承認結果通知書再発行区分を返す() {
            assertThat(sut.get承認結果通知書再発行区分(), is(ShokanJuryoininKeiyakushaAliveEntity.getShoninKekkaTsuchiSaiHakkoKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();

            sut = new ShokanJuryoininKeiyakushaAlive(ShokanJuryoininKeiyakushaAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanJuryoininKeiyakushaAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();

            sut = new ShokanJuryoininKeiyakushaAlive(ShokanJuryoininKeiyakushaAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShokanJuryoininKeiyakushaAlive sut;
        private static ShokanJuryoininKeiyakushaAlive result;

        @BeforeClass
        public static void setUpClass() {
            ShokanJuryoininKeiyakushaAliveEntity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();

        }

        @Test
        public void ShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaAliveが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakushaAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaAliveが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakushaAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaAliveが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakushaAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanJuryoininKeiyakushaAliveが保持するDbV3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanJuryoininKeiyakushaAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanJuryoininKeiyakushaAlive setStateShokanJuryoininKeiyakushaAlive(EntityDataState parentState) {
            ShokanJuryoininKeiyakushaAliveEntity.setState(parentState);
            return new ShokanJuryoininKeiyakushaAlive(ShokanJuryoininKeiyakushaAliveEntity);
        }
    }
}
