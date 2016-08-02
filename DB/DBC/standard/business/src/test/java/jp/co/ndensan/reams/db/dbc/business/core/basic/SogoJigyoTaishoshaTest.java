/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3105SogoJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
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
 * {@link SogoJigyoTaishosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SogoJigyoTaishoshaTest extends DbcTestBase {

    private static DbT3105SogoJigyoTaishoshaEntity SogoJigyoTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static int 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoTaishosha(null, 主キー名2);
        }

        @Test
        public void 指定したキーが保持するDbT3105SogoJigyoTaishoshaEntityにセットされている() {
            sut = new SogoJigyoTaishosha(主キー名1, 主キー名2);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get履歴番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSogoJigyoTaishoshaIdentifierにセットされている() {
            sut = new SogoJigyoTaishosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SogoJigyoTaishosha(null);
        }

        @Test
        public void 指定したDbT3105SogoJigyoTaishoshaEntityのキー情報を識別子が持つ() {

            sut = new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);

            sut = new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(SogoJigyoTaishoshaEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SogoJigyoTaishoshaEntity.getRirekiNo()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(SogoJigyoTaishoshaEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(SogoJigyoTaishoshaEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(SogoJigyoTaishoshaEntity.getUketsukeYMD()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(SogoJigyoTaishoshaEntity.getKetteiYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);

            sut = new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SogoJigyoTaishoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);

            sut = new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SogoJigyoTaishosha sut;
        private static SogoJigyoTaishosha result;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);

        }

        @Test
        public void SogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたSogoJigyoTaishoshaが返る() {
            sut = TestSupport.setStateSogoJigyoTaishosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたSogoJigyoTaishoshaが返る() {
            sut = TestSupport.setStateSogoJigyoTaishosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがDeletedに指定されたSogoJigyoTaishoshaが返る() {
            sut = TestSupport.setStateSogoJigyoTaishosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SogoJigyoTaishoshaが保持するDbT3105SogoJigyoTaishoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSogoJigyoTaishosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SogoJigyoTaishosha setStateSogoJigyoTaishosha(EntityDataState parentState) {
            SogoJigyoTaishoshaEntity.setState(parentState);
            return new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);
        }
    }
}
