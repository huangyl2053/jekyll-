/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3059KagoMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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

/**
 * {@link KagoMoshitate}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoMoshitateTest extends DbcTestBase {

    private static DbT3059KagoMoshitateEntity KagoMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_事業所番号;
        主キー名2 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_サービス提供年月;
        主キー名4 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KagoMoshitate sut;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoMoshitate(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoMoshitate(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3059KagoMoshitateEntityにセットされている() {
            sut = new KagoMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get事業所番号(), is(主キー名1));
            assertThat(sut.get被保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKagoMoshitateIdentifierにセットされている() {
            sut = new KagoMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get事業所番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KagoMoshitate sut;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KagoMoshitate(null);
        }

        @Test
        public void 指定したDbT3059KagoMoshitateEntityのキー情報を識別子が持つ() {

            sut = new KagoMoshitate(KagoMoshitateEntity);

            assertThat(sut.identifier().get事業所番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KagoMoshitate sut;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new KagoMoshitate(KagoMoshitateEntity);
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KagoMoshitateEntity.getJigyoshoNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KagoMoshitateEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KagoMoshitateEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KagoMoshitateEntity.getRirekiNo()));
        }

        @Test
        public void get申立年月日は_entityが持つ申立年月日を返す() {
            assertThat(sut.get申立年月日(), is(KagoMoshitateEntity.getMoshitateYMD()));
        }

        @Test
        public void get申立者区分コードは_entityが持つ申立者区分コードを返す() {
            assertThat(sut.get申立者区分コード(), is(KagoMoshitateEntity.getMoshitateshaKubunCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KagoMoshitateEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get申立事由コードは_entityが持つ申立事由コードを返す() {
            assertThat(sut.get申立事由コード(), is(KagoMoshitateEntity.getMoshitateJiyuCode()));
        }

        @Test
        public void get国保連送付年月は_entityが持つ国保連送付年月を返す() {
            assertThat(sut.get国保連送付年月(), is(KagoMoshitateEntity.getKokuhorenSofuYM()));
        }

        @Test
        public void get国保連再送付有フラグは_entityが持つ国保連再送付有フラグを返す() {
            assertThat(sut.get国保連再送付有フラグ(), is(KagoMoshitateEntity.getKokuhirenSaiSofuAriFlag()));
        }

        @Test
        public void get同月審査有フラグは_entityが持つ同月審査有フラグを返す() {
            assertThat(sut.get同月審査有フラグ(), is(KagoMoshitateEntity.getDogetsuShinsaAriFlag()));
        }

        @Test
        public void get申立書区分コードは_entityが持つ申立書区分コードを返す() {
            assertThat(sut.get申立書区分コード(), is(KagoMoshitateEntity.getMoshitateshoKubunCode()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KagoMoshitate sut;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new KagoMoshitate(KagoMoshitateEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KagoMoshitateEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KagoMoshitate sut;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new KagoMoshitate(KagoMoshitateEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KagoMoshitate sut;
        private static KagoMoshitate result;

        @Before
        public void setUp() {
            KagoMoshitateEntity = DbT3059KagoMoshitateEntityGenerator.createDbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);

        }

        @Test
        public void KagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがDeletedに指定されたKagoMoshitateが返る() {
            sut = TestSupport.setStateKagoMoshitate(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがDeletedに指定されたKagoMoshitateが返る() {
            sut = TestSupport.setStateKagoMoshitate(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがDeletedに指定されたKagoMoshitateが返る() {
            sut = TestSupport.setStateKagoMoshitate(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KagoMoshitateが保持するDbT3059KagoMoshitateEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKagoMoshitate(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KagoMoshitate setStateKagoMoshitate(EntityDataState parentState) {
            KagoMoshitateEntity.setState(parentState);
            return new KagoMoshitate(KagoMoshitateEntity);
        }
    }
}
