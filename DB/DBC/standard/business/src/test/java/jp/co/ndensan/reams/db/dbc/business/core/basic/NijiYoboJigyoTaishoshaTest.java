/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3100NijiYoboJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link NijiYoboJigyoTaishosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboJigyoTaishoshaTest extends DbcTestBase {

    private static DbT3100NijiYoboJigyoTaishoshaEntity NijiYoboJigyoTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboJigyoTaishosha(null, 被保険者番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboJigyoTaishosha(証記載保険者番号, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3100NijiYoboJigyoTaishoshaEntityにセットされている() {
            sut = new NijiYoboJigyoTaishosha(証記載保険者番号, 被保険者番号, 履歴番号);
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するNijiYoboJigyoTaishoshaIdentifierにセットされている() {
            sut = new NijiYoboJigyoTaishosha(証記載保険者番号, 被保険者番号, 履歴番号);
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboJigyoTaishosha(null);
        }

        @Test
        public void 指定したDbT3100NijiYoboJigyoTaishoshaEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboJigyoTaishosha(NijiYoboJigyoTaishoshaEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboJigyoTaishosha sut;

        @Before
        public void setUp() {
            NijiYoboJigyoTaishoshaEntity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);

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
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);

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
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);

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
            NijiYoboJigyoTaishoshaEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            NijiYoboJigyoTaishoshaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboJigyoTaishoshaEntity.setRirekiNo(履歴番号);

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
