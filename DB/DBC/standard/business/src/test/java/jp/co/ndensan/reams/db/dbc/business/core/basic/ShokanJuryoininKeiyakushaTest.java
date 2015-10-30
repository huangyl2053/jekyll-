/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
import org.junit.Ignore;

/**
 * {@link ShokanJuryoininKeiyakusha}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanJuryoininKeiyakushaTest extends DbcTestBase {

    private static DbT3078ShokanJuryoininKeiyakushaEntity ShokanJuryoininKeiyakushaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static ShoKisaiHokenshaNo 主キー名2;
    private static FlexibleDate 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
        主キー名4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininKeiyakusha(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininKeiyakusha(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3078ShokanJuryoininKeiyakushaEntityにセットされている() {
            sut = new ShokanJuryoininKeiyakusha(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get証記載保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanJuryoininKeiyakushaIdentifierにセットされている() {
            sut = new ShokanJuryoininKeiyakusha(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanJuryoininKeiyakusha(null);
        }

        @Test
        public void 指定したDbT3078ShokanJuryoininKeiyakushaEntityのキー情報を識別子が持つ() {

            sut = new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);

            sut = new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanJuryoininKeiyakushaEntity.getHihokenshaNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(ShokanJuryoininKeiyakushaEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(ShokanJuryoininKeiyakushaEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanJuryoininKeiyakushaEntity.getRirekiNo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(ShokanJuryoininKeiyakushaEntity.getShinseiYMD()));
        }

        @Test
        public void get事業者契約番号は_entityが持つ事業者契約番号を返す() {
            assertThat(sut.get事業者契約番号(), is(ShokanJuryoininKeiyakushaEntity.getJigyoshaKeiyakuNo()));
        }

        @Test
        public void get契約サービス種類は_entityが持つ契約サービス種類を返す() {
            assertThat(sut.get契約サービス種類(), is(ShokanJuryoininKeiyakushaEntity.getKeiyakuServiceShurui()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(ShokanJuryoininKeiyakushaEntity.getKetteiYMD()));
        }

        @Test
        public void get承認結果区分は_entityが持つ承認結果区分を返す() {
            assertThat(sut.get承認結果区分(), is(ShokanJuryoininKeiyakushaEntity.getShoninKekkaKubun()));
        }

        @Test
        public void get受領委任払適用開始年月日は_entityが持つ受領委任払適用開始年月日を返す() {
            assertThat(sut.get受領委任払適用開始年月日(), is(ShokanJuryoininKeiyakushaEntity.getJuryoininKaishiYMD()));
        }

        @Test
        public void get受領委任払適用終了年月日は_entityが持つ受領委任払適用終了年月日を返す() {
            assertThat(sut.get受領委任払適用終了年月日(), is(ShokanJuryoininKeiyakushaEntity.getJuryoininShuryoYMD()));
        }

        @Test
        public void get契約番号は_entityが持つ契約番号を返す() {
            assertThat(sut.get契約番号(), is(ShokanJuryoininKeiyakushaEntity.getKeiyakuNo()));
        }

        @Test
        public void get不承認理由は_entityが持つ不承認理由を返す() {
            assertThat(sut.get不承認理由(), is(ShokanJuryoininKeiyakushaEntity.getFuShoninRiyu()));
        }

        @Test
        public void get費用額合計は_entityが持つ費用額合計を返す() {
            assertThat(sut.get費用額合計(), is(ShokanJuryoininKeiyakushaEntity.getHiyoGakuGokei()));
        }

        @Test
        public void get保険対象費用額は_entityが持つ保険対象費用額を返す() {
            assertThat(sut.get保険対象費用額(), is(ShokanJuryoininKeiyakushaEntity.getHokenTaishoHiyoGaku()));
        }

        @Test
        public void get利用者自己負担額は_entityが持つ利用者自己負担額を返す() {
            assertThat(sut.get利用者自己負担額(), is(ShokanJuryoininKeiyakushaEntity.getRiyoshaJikoFutanGaku()));
        }

        @Test
        public void get保険給付費額は_entityが持つ保険給付費額を返す() {
            assertThat(sut.get保険給付費額(), is(ShokanJuryoininKeiyakushaEntity.getHokenKyufuhiGaku()));
        }

        @Test
        public void get承認結果通知書作成日は_entityが持つ承認結果通知書作成日を返す() {
            assertThat(sut.get承認結果通知書作成日(), is(ShokanJuryoininKeiyakushaEntity.getShoninKekkaTsuchiSakuseiYMD()));
        }

        @Test
        public void get承認結果通知書再発行区分は_entityが持つ承認結果通知書再発行区分を返す() {
            assertThat(sut.get承認結果通知書再発行区分(), is(ShokanJuryoininKeiyakushaEntity.getShoninKekkaTsuchiSaiHakkoKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);

            sut = new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanJuryoininKeiyakushaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);

            sut = new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanJuryoininKeiyakusha sut;
        private static ShokanJuryoininKeiyakusha result;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);

        }

        @Test
        public void ShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakusha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakusha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがDeletedに指定されたShokanJuryoininKeiyakushaが返る() {
            sut = TestSupport.setStateShokanJuryoininKeiyakusha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanJuryoininKeiyakushaが保持するDbT3078ShokanJuryoininKeiyakushaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanJuryoininKeiyakusha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanJuryoininKeiyakusha setStateShokanJuryoininKeiyakusha(EntityDataState parentState) {
            ShokanJuryoininKeiyakushaEntity.setState(parentState);
            return new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);
        }
    }
}
