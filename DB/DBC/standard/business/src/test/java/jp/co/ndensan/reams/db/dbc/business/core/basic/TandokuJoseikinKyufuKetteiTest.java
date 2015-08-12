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
 * {@link TandokuJoseikinKyufuKettei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuKetteiTest extends DbcTestBase {

    private static DbT3097TandokuJoseikinKyufuKetteiEntity TandokuJoseikinKyufuKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseikinKyufuKettei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseikinKyufuKettei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3097TandokuJoseikinKyufuKetteiEntityにセットされている() {
            sut = new TandokuJoseikinKyufuKettei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTandokuJoseikinKyufuKetteiIdentifierにセットされている() {
            sut = new TandokuJoseikinKyufuKettei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TandokuJoseikinKyufuKettei(null);
        }

        @Test
        public void 指定したDbT3097TandokuJoseikinKyufuKetteiEntityのキー情報を識別子が持つ() {

            sut = new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);

            sut = new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(TandokuJoseikinKyufuKetteiEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(TandokuJoseikinKyufuKetteiEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TandokuJoseikinKyufuKetteiEntity.getRirekiNo()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(TandokuJoseikinKyufuKetteiEntity.getKetteiYMD()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(TandokuJoseikinKyufuKetteiEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get有効期限は_entityが持つ有効期限を返す() {
            assertThat(sut.get有効期限(), is(TandokuJoseikinKyufuKetteiEntity.getYukoKigenYMD()));
        }

        @Test
        public void get利用者負担・決定区分は_entityが持つ利用者負担・決定区分を返す() {
            assertThat(sut.get利用者負担・決定区分(), is(TandokuJoseikinKyufuKetteiEntity.getRiyoshaFutan_KetteiKubun()));
        }

        @Test
        public void get利用者負担・不承認理由は_entityが持つ利用者負担・不承認理由を返す() {
            assertThat(sut.get利用者負担・不承認理由(), is(TandokuJoseikinKyufuKetteiEntity.getRiyoshaFutan_FuShoninRiyu()));
        }

        @Test
        public void get公費受給者番号は_entityが持つ公費受給者番号を返す() {
            assertThat(sut.get公費受給者番号(), is(TandokuJoseikinKyufuKetteiEntity.getKohi_JukyushaNo()));
        }

        @Test
        public void get公費負担者番号は_entityが持つ公費負担者番号を返す() {
            assertThat(sut.get公費負担者番号(), is(TandokuJoseikinKyufuKetteiEntity.getKohi_FutanshaNo()));
        }

        @Test
        public void get給付率は_entityが持つ給付率を返す() {
            assertThat(sut.get給付率(), is(TandokuJoseikinKyufuKetteiEntity.getKyufuRitsu()));
        }

        @Test
        public void get受給者番号は_entityが持つ受給者番号を返す() {
            assertThat(sut.get受給者番号(), is(TandokuJoseikinKyufuKetteiEntity.getJukyushaNo()));
        }

        @Test
        public void get経過措置は_entityが持つ経過措置を返す() {
            assertThat(sut.get経過措置(), is(TandokuJoseikinKyufuKetteiEntity.getKeikaSochiKubun()));
        }

        @Test
        public void get国軽減は_entityが持つ国軽減を返す() {
            assertThat(sut.get国軽減(), is(TandokuJoseikinKyufuKetteiEntity.getKuniKeigenKubun()));
        }

        @Test
        public void get社会福祉法人軽減は_entityが持つ社会福祉法人軽減を返す() {
            assertThat(sut.get社会福祉法人軽減(), is(TandokuJoseikinKyufuKetteiEntity.getShakaiFukushiHojinKeigenKubun()));
        }

        @Test
        public void get特別地域加算は_entityが持つ特別地域加算を返す() {
            assertThat(sut.get特別地域加算(), is(TandokuJoseikinKyufuKetteiEntity.getTokubetsuChiikiKasanKubun()));
        }

        @Test
        public void get保留区分・滞納は_entityが持つ保留区分・滞納を返す() {
            assertThat(sut.get保留区分・滞納(), is(TandokuJoseikinKyufuKetteiEntity.getTaino_HoryuKubun()));
        }

        @Test
        public void get保留区分・認定申請中は_entityが持つ保留区分・認定申請中を返す() {
            assertThat(sut.get保留区分・認定申請中(), is(TandokuJoseikinKyufuKetteiEntity.getNinteiShinseichu_HoryuKubun()));
        }

        @Test
        public void get保留区分・認定有効期限切れは_entityが持つ保留区分・認定有効期限切れを返す() {
            assertThat(sut.get保留区分・認定有効期限切れ(), is(TandokuJoseikinKyufuKetteiEntity.getNinteiKigenGire_HoryuKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);

            sut = new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TandokuJoseikinKyufuKetteiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);

            sut = new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static TandokuJoseikinKyufuKettei sut;
        private static TandokuJoseikinKyufuKettei result;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.createDbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setXXX(主キー名2);

        }

        @Test
        public void TandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuKetteiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuKettei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuKetteiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuKettei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがDeletedに指定されたTandokuJoseikinKyufuKetteiが返る() {
            sut = TestSupport.setStateTandokuJoseikinKyufuKettei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TandokuJoseikinKyufuKetteiが保持するDbT3097TandokuJoseikinKyufuKetteiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTandokuJoseikinKyufuKettei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TandokuJoseikinKyufuKettei setStateTandokuJoseikinKyufuKettei(EntityDataState parentState) {
            TandokuJoseikinKyufuKetteiEntity.setState(parentState);
            return new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);
        }
    }
}
