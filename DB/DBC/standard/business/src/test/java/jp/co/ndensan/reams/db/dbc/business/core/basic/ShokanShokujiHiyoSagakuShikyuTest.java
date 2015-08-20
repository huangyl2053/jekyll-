/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link ShokanShokujiHiyoSagakuShikyu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoSagakuShikyuTest extends DbcTestBase {

    private static DbT3044ShokanShokujiHiyoSagakuShikyuEntity ShokanShokujiHiyoSagakuShikyuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShokujiHiyoSagakuShikyu(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShokujiHiyoSagakuShikyu(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityにセットされている() {
            sut = new ShokanShokujiHiyoSagakuShikyu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShokujiHiyoSagakuShikyuIdentifierにセットされている() {
            sut = new ShokanShokujiHiyoSagakuShikyu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShokujiHiyoSagakuShikyu(null);
        }

        @Test
        public void 指定したDbT3044ShokanShokujiHiyoSagakuShikyuEntityのキー情報を識別子が持つ() {

            sut = new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanShokujiHiyoSagakuShikyuEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanShokujiHiyoSagakuShikyuEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanShokujiHiyoSagakuShikyuEntity.getSeiriNp()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanShokujiHiyoSagakuShikyuEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanShokujiHiyoSagakuShikyuEntity.getYoshikiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanShokujiHiyoSagakuShikyuEntity.getRirekiNo()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanShokujiHiyoSagakuShikyuEntity.getSagakuKingaku()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanShokujiHiyoSagakuShikyuEntity.getShikyuKubunCode()));
        }

        @Test
        public void get点数_金額は_entityが持つ点数_金額を返す() {
            assertThat(sut.get点数_金額(), is(ShokanShokujiHiyoSagakuShikyuEntity.getTensuKingaku()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(ShokanShokujiHiyoSagakuShikyuEntity.getShikyuKingaku()));
        }

        @Test
        public void get支給_不支給理由は_entityが持つ支給_不支給理由を返す() {
            assertThat(sut.get支給_不支給理由(), is(ShokanShokujiHiyoSagakuShikyuEntity.getShikyuFushikyuRiyu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShokujiHiyoSagakuShikyuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShokujiHiyoSagakuShikyu sut;
        private static ShokanShokujiHiyoSagakuShikyu result;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.createDbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoSagakuShikyuが返る() {
            sut = TestSupport.setStateShokanShokujiHiyoSagakuShikyu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoSagakuShikyuが返る() {
            sut = TestSupport.setStateShokanShokujiHiyoSagakuShikyu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoSagakuShikyuが返る() {
            sut = TestSupport.setStateShokanShokujiHiyoSagakuShikyu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShokujiHiyoSagakuShikyuが保持するDbT3044ShokanShokujiHiyoSagakuShikyuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShokujiHiyoSagakuShikyu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShokujiHiyoSagakuShikyu setStateShokanShokujiHiyoSagakuShikyu(EntityDataState parentState) {
            ShokanShokujiHiyoSagakuShikyuEntity.setState(parentState);
            return new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);
        }
    }
}
