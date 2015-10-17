/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3060KagoKetteiShukeiEntityGenerator;
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
 * {@link KagoKetteiShukei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoKetteiShukeiTest extends DbcTestBase {

    private static DbT3060KagoKetteiShukeiEntity KagoKetteiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoKetteiShukei(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoKetteiShukei(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3060KagoKetteiShukeiEntityにセットされている() {
            sut = new KagoKetteiShukei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get取扱年月(), is(主キー名1));
            assertThat(sut.get保険者区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKagoKetteiShukeiIdentifierにセットされている() {
            sut = new KagoKetteiShukei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KagoKetteiShukei(null);
        }

        @Test
        public void 指定したDbT3060KagoKetteiShukeiEntityのキー情報を識別子が持つ() {

            sut = new KagoKetteiShukei(KagoKetteiShukeiEntity);

            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiShukei(KagoKetteiShukeiEntity);
        }

        @Test
        public void get取扱年月は_entityが持つ取扱年月を返す() {
            assertThat(sut.get取扱年月(), is(KagoKetteiShukeiEntity.getToriatsukaiYM()));
        }

        @Test
        public void get保険者区分は_entityが持つ保険者区分を返す() {
            assertThat(sut.get保険者区分(), is(KagoKetteiShukeiEntity.getHokenshaKubun()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KagoKetteiShukeiEntity.getRirekiNo()));
        }

        @Test
        public void get介護給付費件数は_entityが持つ介護給付費件数を返す() {
            assertThat(sut.get介護給付費件数(), is(KagoKetteiShukeiEntity.getKaigoKyufuhiKensu()));
        }

        @Test
        public void get介護給付費単位数は_entityが持つ介護給付費単位数を返す() {
            assertThat(sut.get介護給付費単位数(), is(KagoKetteiShukeiEntity.getKaigoKyufuhiTanisu()));
        }

        @Test
        public void get介護給付費保険者負担額は_entityが持つ介護給付費保険者負担額を返す() {
            assertThat(sut.get介護給付費保険者負担額(), is(KagoKetteiShukeiEntity.getKaigoKyufuhiFutangaku()));
        }

        @Test
        public void get高額介護サービス費件数は_entityが持つ高額介護サービス費件数を返す() {
            assertThat(sut.get高額介護サービス費件数(), is(KagoKetteiShukeiEntity.getKogakuServicehiKensu()));
        }

        @Test
        public void get高額介護サービス費単位数は_entityが持つ高額介護サービス費単位数を返す() {
            assertThat(sut.get高額介護サービス費単位数(), is(KagoKetteiShukeiEntity.getKogakuServicehiTanisu()));
        }

        @Test
        public void get高額介護サービス費保険者負担額は_entityが持つ高額介護サービス費保険者負担額を返す() {
            assertThat(sut.get高額介護サービス費保険者負担額(), is(KagoKetteiShukeiEntity.getKogakuServicehiFutangaku()));
        }

        @Test
        public void get特定入所者介護サービス費等件数は_entityが持つ特定入所者介護サービス費等件数を返す() {
            assertThat(sut.get特定入所者介護サービス費等件数(), is(KagoKetteiShukeiEntity.getTokuteiNyushoshaServicehiKensu()));
        }

        @Test
        public void get特定入所者介護サービス費等費用額は_entityが持つ特定入所者介護サービス費等費用額を返す() {
            assertThat(sut.get特定入所者介護サービス費等費用額(), is(KagoKetteiShukeiEntity.getTokuteiNyushoshaServicehiTanisu()));
        }

        @Test
        public void get特定入所者介護サービス費等保険者負担額は_entityが持つ特定入所者介護サービス費等保険者負担額を返す() {
            assertThat(sut.get特定入所者介護サービス費等保険者負担額(), is(KagoKetteiShukeiEntity.getTokuteiNyushoshaServicehiFutangaku()));
        }

        @Test
        public void get公費負担者番号は_entityが持つ公費負担者番号を返す() {
            assertThat(sut.get公費負担者番号(), is(KagoKetteiShukeiEntity.getKohiFutanshaNo()));
        }

        @Test
        public void get作成年月日は_entityが持つ作成年月日を返す() {
            assertThat(sut.get作成年月日(), is(KagoKetteiShukeiEntity.getSakuseiYMD()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KagoKetteiShukeiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiShukei(KagoKetteiShukeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KagoKetteiShukeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiShukei(KagoKetteiShukeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KagoKetteiShukei sut;
        private static KagoKetteiShukei result;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiShukeiEntity.setHokenshaKubun(主キー名2);

        }

        @Test
        public void KagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがDeletedに指定されたKagoKetteiShukeiが返る() {
            sut = TestSupport.setStateKagoKetteiShukei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがDeletedに指定されたKagoKetteiShukeiが返る() {
            sut = TestSupport.setStateKagoKetteiShukei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがDeletedに指定されたKagoKetteiShukeiが返る() {
            sut = TestSupport.setStateKagoKetteiShukei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KagoKetteiShukeiが保持するDbT3060KagoKetteiShukeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKagoKetteiShukei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KagoKetteiShukei setStateKagoKetteiShukei(EntityDataState parentState) {
            KagoKetteiShukeiEntity.setState(parentState);
            return new KagoKetteiShukei(KagoKetteiShukeiEntity);
        }
    }
}
