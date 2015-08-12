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
 * {@link KogakuKyufuTaishoshaGokei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuKyufuTaishoshaGokeiTest extends DbcTestBase {

    private static DbT3055KogakuKyufuTaishoshaGokeiEntity KogakuKyufuTaishoshaGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuKyufuTaishoshaGokei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuKyufuTaishoshaGokei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityにセットされている() {
            sut = new KogakuKyufuTaishoshaGokei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuKyufuTaishoshaGokeiIdentifierにセットされている() {
            sut = new KogakuKyufuTaishoshaGokei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuKyufuTaishoshaGokei(null);
        }

        @Test
        public void 指定したDbT3055KogakuKyufuTaishoshaGokeiEntityのキー情報を識別子が持つ() {

            sut = new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);

            sut = new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuKyufuTaishoshaGokeiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KogakuKyufuTaishoshaGokeiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuKyufuTaishoshaGokeiEntity.getRirekiNo()));
        }

        @Test
        public void getサービス費用合計額合計は_entityが持つサービス費用合計額合計を返す() {
            assertThat(sut.getサービス費用合計額合計(), is(KogakuKyufuTaishoshaGokeiEntity.getServiceHiyoGokeiGakuGokei()));
        }

        @Test
        public void get利用者負担額合計は_entityが持つ利用者負担額合計を返す() {
            assertThat(sut.get利用者負担額合計(), is(KogakuKyufuTaishoshaGokeiEntity.getRiyoshaFutanGakuGokei()));
        }

        @Test
        public void get算定基準額は_entityが持つ算定基準額を返す() {
            assertThat(sut.get算定基準額(), is(KogakuKyufuTaishoshaGokeiEntity.getSanteiKijunGaku()));
        }

        @Test
        public void get支払済金額合計は_entityが持つ支払済金額合計を返す() {
            assertThat(sut.get支払済金額合計(), is(KogakuKyufuTaishoshaGokeiEntity.getShiharaiSumiKingakuGokei()));
        }

        @Test
        public void get高額支給額は_entityが持つ高額支給額を返す() {
            assertThat(sut.get高額支給額(), is(KogakuKyufuTaishoshaGokeiEntity.getKogakuShikyuGaku()));
        }

        @Test
        public void get対象者受取年月は_entityが持つ対象者受取年月を返す() {
            assertThat(sut.get対象者受取年月(), is(KogakuKyufuTaishoshaGokeiEntity.getTashoshaUketoriYM()));
        }

        @Test
        public void get対象者判定審査年月は_entityが持つ対象者判定審査年月を返す() {
            assertThat(sut.get対象者判定審査年月(), is(KogakuKyufuTaishoshaGokeiEntity.getTaishoshaHanteiShinsaYM()));
        }

        @Test
        public void get世帯集約番号は_entityが持つ世帯集約番号を返す() {
            assertThat(sut.get世帯集約番号(), is(KogakuKyufuTaishoshaGokeiEntity.getSetaiShuyakuNo()));
        }

        @Test
        public void get境界層対象者フラグは_entityが持つ境界層対象者フラグを返す() {
            assertThat(sut.get境界層対象者フラグ(), is(KogakuKyufuTaishoshaGokeiEntity.getKyokaisoTaishoshaFlag()));
        }

        @Test
        public void get社会福祉法人軽減対象フラグは_entityが持つ社会福祉法人軽減対象フラグを返す() {
            assertThat(sut.get社会福祉法人軽減対象フラグ(), is(KogakuKyufuTaishoshaGokeiEntity.getHojinKeigenTaishoFlag()));
        }

        @Test
        public void get高額対象外フラグは_entityが持つ高額対象外フラグを返す() {
            assertThat(sut.get高額対象外フラグ(), is(KogakuKyufuTaishoshaGokeiEntity.getKogakuTaishoGaiFlag()));
        }

        @Test
        public void get自動償還対象フラグは_entityが持つ自動償還対象フラグを返す() {
            assertThat(sut.get自動償還対象フラグ(), is(KogakuKyufuTaishoshaGokeiEntity.getJidoShokanTaishoFlag()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);

            sut = new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuKyufuTaishoshaGokeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);

            sut = new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokei sut;
        private static KogakuKyufuTaishoshaGokei result;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setXXX(主キー名2);

        }

        @Test
        public void KogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaGokei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaGokei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaGokei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuKyufuTaishoshaGokeiが保持するDbT3055KogakuKyufuTaishoshaGokeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaGokei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuKyufuTaishoshaGokei setStateKogakuKyufuTaishoshaGokei(EntityDataState parentState) {
            KogakuKyufuTaishoshaGokeiEntity.setState(parentState);
            return new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);
        }
    }
}
