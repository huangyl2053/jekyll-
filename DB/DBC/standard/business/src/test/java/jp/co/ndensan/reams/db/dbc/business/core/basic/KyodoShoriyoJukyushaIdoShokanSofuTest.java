/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link KyodoShoriyoJukyushaIdoShokanSofu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoShokanSofuTest extends DbcTestBase {

    private static DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity KyodoShoriyoJukyushaIdoShokanSofuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofu(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofu(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get異動年月日(), is(主キー名1));
            assertThat(sut.get異動区分コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyodoShoriyoJukyushaIdoShokanSofuIdentifierにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyodoShoriyoJukyushaIdoShokanSofu(null);
        }

        @Test
        public void 指定したDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのキー情報を識別子が持つ() {

            sut = new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);

            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getIdoYMD()));
        }

        @Test
        public void get異動区分コードは_entityが持つ異動区分コードを返す() {
            assertThat(sut.get異動区分コード(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getIdoKubunCode()));
        }

        @Test
        public void get受給者異動事由は_entityが持つ受給者異動事由を返す() {
            assertThat(sut.get受給者異動事由(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getJukyushaIdoJiyu()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getHiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getRirekiNo()));
        }

        @Test
        public void get保険給付支払一時差止開始年月日は_entityが持つ保険給付支払一時差止開始年月日を返す() {
            assertThat(sut.get保険給付支払一時差止開始年月日(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getHokenKyufuIchijiSashitomeKaishiYMD()));
        }

        @Test
        public void get保険給付支払一時差止終了年月日は_entityが持つ保険給付支払一時差止終了年月日を返す() {
            assertThat(sut.get保険給付支払一時差止終了年月日(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getHokenKyufuIchijiSashitomeShuryoYMD()));
        }

        @Test
        public void get保険給付支払一時差止区分コードは_entityが持つ保険給付支払一時差止区分コードを返す() {
            assertThat(sut.get保険給付支払一時差止区分コード(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getHokenkyufuIchijiSashitomeKubunCode()));
        }

        @Test
        public void get保険給付支払一時差止金額は_entityが持つ保険給付支払一時差止金額を返す() {
            assertThat(sut.get保険給付支払一時差止金額(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getHokenkyufuIchijiSashitomeKingaku()));
        }

        @Test
        public void get訂正連絡票フラグは_entityが持つ訂正連絡票フラグを返す() {
            assertThat(sut.get訂正連絡票フラグ(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getTeiseiRenrakuhyoFlag()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KyodoShoriyoJukyushaIdoShokanSofuEntity.getSofuYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyodoShoriyoJukyushaIdoShokanSofuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofu sut;
        private static KyodoShoriyoJukyushaIdoShokanSofu result;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);

        }

        @Test
        public void KyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoShokanSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoShokanSofu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoShokanSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoShokanSofu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoShokanSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoShokanSofu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyodoShoriyoJukyushaIdoShokanSofuが保持するDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoShokanSofu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyodoShoriyoJukyushaIdoShokanSofu setStateKyodoShoriyoJukyushaIdoShokanSofu(EntityDataState parentState) {
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setState(parentState);
            return new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);
        }
    }
}
