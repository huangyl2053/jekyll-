/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator;
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
 * {@link SaishinsaKetteiShukei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SaishinsaKetteiShukeiTest extends DbcTestBase {

    private static DbT3063SaishinsaKetteiShukeiEntity SaishinsaKetteiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaKetteiShukei(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaKetteiShukei(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3063SaishinsaKetteiShukeiEntityにセットされている() {
            sut = new SaishinsaKetteiShukei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get取扱年月(), is(主キー名1));
            assertThat(sut.get保険者区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSaishinsaKetteiShukeiIdentifierにセットされている() {
            sut = new SaishinsaKetteiShukei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SaishinsaKetteiShukei(null);
        }

        @Test
        public void 指定したDbT3063SaishinsaKetteiShukeiEntityのキー情報を識別子が持つ() {

            sut = new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);

            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);
        }

        @Test
        public void get取扱年月は_entityが持つ取扱年月を返す() {
            assertThat(sut.get取扱年月(), is(SaishinsaKetteiShukeiEntity.getToriatsukaiYM()));
        }

        @Test
        public void get保険者区分は_entityが持つ保険者区分を返す() {
            assertThat(sut.get保険者区分(), is(SaishinsaKetteiShukeiEntity.getHokenshaKubun()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SaishinsaKetteiShukeiEntity.getRirekiNo()));
        }

        @Test
        public void get介護給付費_請求_件数は_entityが持つ介護給付費_請求_件数を返す() {
            assertThat(sut.get介護給付費_請求_件数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiSeikyuKensu()));
        }

        @Test
        public void get介護給付費_請求_単位数は_entityが持つ介護給付費_請求_単位数を返す() {
            assertThat(sut.get介護給付費_請求_単位数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiSeikyuTanisu()));
        }

        @Test
        public void get介護給付費_請求_保険者負担額は_entityが持つ介護給付費_請求_保険者負担額を返す() {
            assertThat(sut.get介護給付費_請求_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiSeikyuFutangaku()));
        }

        @Test
        public void get介護給付費_決定_件数は_entityが持つ介護給付費_決定_件数を返す() {
            assertThat(sut.get介護給付費_決定_件数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiKetteiKensu()));
        }

        @Test
        public void get介護給付費_決定_単位数は_entityが持つ介護給付費_決定_単位数を返す() {
            assertThat(sut.get介護給付費_決定_単位数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiKetteiTanisu()));
        }

        @Test
        public void get介護給付費_決定_保険者負担額は_entityが持つ介護給付費_決定_保険者負担額を返す() {
            assertThat(sut.get介護給付費_決定_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiKetteiFutangaku()));
        }

        @Test
        public void get介護給付費_調整_件数は_entityが持つ介護給付費_調整_件数を返す() {
            assertThat(sut.get介護給付費_調整_件数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiChoseiKensu()));
        }

        @Test
        public void get介護給付費_調整_単位数は_entityが持つ介護給付費_調整_単位数を返す() {
            assertThat(sut.get介護給付費_調整_単位数(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiChoseiTanisu()));
        }

        @Test
        public void get介護給付費_調整_保険者負担額は_entityが持つ介護給付費_調整_保険者負担額を返す() {
            assertThat(sut.get介護給付費_調整_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKaigoKyufuhiChoseiFutangaku()));
        }

        @Test
        public void get高額介護サービス費_請求_件数は_entityが持つ高額介護サービス費_請求_件数を返す() {
            assertThat(sut.get高額介護サービス費_請求_件数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiSeikyuKensu()));
        }

        @Test
        public void get高額介護サービス費_請求_単位数は_entityが持つ高額介護サービス費_請求_単位数を返す() {
            assertThat(sut.get高額介護サービス費_請求_単位数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiSeikyuTanisu()));
        }

        @Test
        public void get高額介護サービス費_請求_保険者負担額は_entityが持つ高額介護サービス費_請求_保険者負担額を返す() {
            assertThat(sut.get高額介護サービス費_請求_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiSeikyuFutangaku()));
        }

        @Test
        public void get高額介護サービス費_決定_件数は_entityが持つ高額介護サービス費_決定_件数を返す() {
            assertThat(sut.get高額介護サービス費_決定_件数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiKetteiKensu()));
        }

        @Test
        public void get高額介護サービス費_決定_単位数は_entityが持つ高額介護サービス費_決定_単位数を返す() {
            assertThat(sut.get高額介護サービス費_決定_単位数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiKetteiTanisu()));
        }

        @Test
        public void get高額介護サービス費_決定_保険者負担額は_entityが持つ高額介護サービス費_決定_保険者負担額を返す() {
            assertThat(sut.get高額介護サービス費_決定_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiKetteiFutangaku()));
        }

        @Test
        public void get高額介護サービス費_調整_件数は_entityが持つ高額介護サービス費_調整_件数を返す() {
            assertThat(sut.get高額介護サービス費_調整_件数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiChoseiKensu()));
        }

        @Test
        public void get高額介護サービス費_調整_単位数は_entityが持つ高額介護サービス費_調整_単位数を返す() {
            assertThat(sut.get高額介護サービス費_調整_単位数(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiChoseiTanisu()));
        }

        @Test
        public void get高額介護サービス費_調整_保険者負担額は_entityが持つ高額介護サービス費_調整_保険者負担額を返す() {
            assertThat(sut.get高額介護サービス費_調整_保険者負担額(), is(SaishinsaKetteiShukeiEntity.getKogakuKaigoServicehiChoseiFutangaku()));
        }

        @Test
        public void get公費負担者番号は_entityが持つ公費負担者番号を返す() {
            assertThat(sut.get公費負担者番号(), is(SaishinsaKetteiShukeiEntity.getKohiFutanshaNo()));
        }

        @Test
        public void get作成年月日は_entityが持つ作成年月日を返す() {
            assertThat(sut.get作成年月日(), is(SaishinsaKetteiShukeiEntity.getSakuseiYMD()));
        }

        @Test
        public void get審査委員会名は_entityが持つ審査委員会名を返す() {
            assertThat(sut.get審査委員会名(), is(SaishinsaKetteiShukeiEntity.getSinsaiinkaiName()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(SaishinsaKetteiShukeiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SaishinsaKetteiShukeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SaishinsaKetteiShukei sut;
        private static SaishinsaKetteiShukei result;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);

        }

        @Test
        public void SaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiShukeiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiShukei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiShukeiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiShukei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiShukeiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiShukei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SaishinsaKetteiShukeiが保持するDbT3063SaishinsaKetteiShukeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSaishinsaKetteiShukei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SaishinsaKetteiShukei setStateSaishinsaKetteiShukei(EntityDataState parentState) {
            SaishinsaKetteiShukeiEntity.setState(parentState);
            return new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);
        }
    }
}
