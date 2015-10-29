/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link JigyoKogakuKyufuTaishoshaGokei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JigyoKogakuKyufuTaishoshaGokeiTest extends DbcTestBase {

    private static DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity JigyoKogakuKyufuTaishoshaGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuKyufuTaishoshaGokei(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuKyufuTaishoshaGokei(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityにセットされている() {
            sut = new JigyoKogakuKyufuTaishoshaGokei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJigyoKogakuKyufuTaishoshaGokeiIdentifierにセットされている() {
            sut = new JigyoKogakuKyufuTaishoshaGokei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JigyoKogakuKyufuTaishoshaGokei(null);
        }

        @Test
        public void 指定したDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのキー情報を識別子が持つ() {

            sut = new JigyoKogakuKyufuTaishoshaGokei(JigyoKogakuKyufuTaishoshaGokeiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuKyufuTaishoshaGokei(JigyoKogakuKyufuTaishoshaGokeiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getRirekiNo()));
        }

        @Test
        public void getサービス費用合計額合計は_entityが持つサービス費用合計額合計を返す() {
            assertThat(sut.getサービス費用合計額合計(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getServiceHiyoGokeiGakuGokei()));
        }

        @Test
        public void get利用者負担額合計は_entityが持つ利用者負担額合計を返す() {
            assertThat(sut.get利用者負担額合計(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getRiyoshaFutanGakuGokei()));
        }

        @Test
        public void get算定基準額は_entityが持つ算定基準額を返す() {
            assertThat(sut.get算定基準額(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getSanteiKijunGaku()));
        }

        @Test
        public void get支払済金額合計は_entityが持つ支払済金額合計を返す() {
            assertThat(sut.get支払済金額合計(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getShiharaiSumiKingakuGokei()));
        }

        @Test
        public void get事業高額支給額は_entityが持つ事業高額支給額を返す() {
            assertThat(sut.get事業高額支給額(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getJigyoKogakuShikyuGaku()));
        }

        @Test
        public void get対象者受取年月は_entityが持つ対象者受取年月を返す() {
            assertThat(sut.get対象者受取年月(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getTashoshaUketoriYM()));
        }

        @Test
        public void get対象者判定審査年月は_entityが持つ対象者判定審査年月を返す() {
            assertThat(sut.get対象者判定審査年月(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getTaishoshaHanteiShinsaYM()));
        }

        @Test
        public void get世帯集約番号は_entityが持つ世帯集約番号を返す() {
            assertThat(sut.get世帯集約番号(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getSetaiShuyakuNo()));
        }

        @Test
        public void get境界層対象者フラグは_entityが持つ境界層対象者フラグを返す() {
            assertThat(sut.get境界層対象者フラグ(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getKyokaisoTaishoshaFlag()));
        }

        @Test
        public void get社会福祉法人軽減対象フラグは_entityが持つ社会福祉法人軽減対象フラグを返す() {
            assertThat(sut.get社会福祉法人軽減対象フラグ(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getHojinKeigenTaishoFlag()));
        }

        @Test
        public void get高額対象外フラグは_entityが持つ高額対象外フラグを返す() {
            assertThat(sut.get高額対象外フラグ(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getKogakuTaishoGaiFlag()));
        }

        @Test
        public void get自動償還対象フラグは_entityが持つ自動償還対象フラグを返す() {
            assertThat(sut.get自動償還対象フラグ(), is(JigyoKogakuKyufuTaishoshaGokeiEntity.getJidoShokanTaishoFlag()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuKyufuTaishoshaGokei(JigyoKogakuKyufuTaishoshaGokeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JigyoKogakuKyufuTaishoshaGokeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuKyufuTaishoshaGokei(JigyoKogakuKyufuTaishoshaGokeiEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JigyoKogakuKyufuTaishoshaGokei sut;
        private static JigyoKogakuKyufuTaishoshaGokei result;

        @Before
        public void setUp() {
            JigyoKogakuKyufuTaishoshaGokeiEntity = DbT3109JigyoKogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
            JigyoKogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void JigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateJigyoKogakuKyufuTaishoshaGokei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateJigyoKogakuKyufuTaishoshaGokei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuKyufuTaishoshaGokeiが返る() {
            sut = TestSupport.setStateJigyoKogakuKyufuTaishoshaGokei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JigyoKogakuKyufuTaishoshaGokeiが保持するDbT3109JigyoKogakuKyufuTaishoshaGokeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJigyoKogakuKyufuTaishoshaGokei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JigyoKogakuKyufuTaishoshaGokei setStateJigyoKogakuKyufuTaishoshaGokei(EntityDataState parentState) {
            JigyoKogakuKyufuTaishoshaGokeiEntity.setState(parentState);
            return new JigyoKogakuKyufuTaishoshaGokei(JigyoKogakuKyufuTaishoshaGokeiEntity);
        }
    }
}
