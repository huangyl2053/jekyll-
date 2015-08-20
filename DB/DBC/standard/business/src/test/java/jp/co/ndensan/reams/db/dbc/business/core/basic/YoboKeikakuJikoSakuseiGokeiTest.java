/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.not;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link YoboKeikakuJikoSakuseiGokei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class YoboKeikakuJikoSakuseiGokeiTest extends DbcTestBase {

    private static DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity YoboKeikakuJikoSakuseiGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static Decimal 主キー名3;
    private static RString 主キー名4;
    private static JigyoshaNo 主キー名5;
    private static ServiceShuruiCode 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new YoboKeikakuJikoSakuseiGokei(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new YoboKeikakuJikoSakuseiGokei(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityにセットされている() {
            sut = new YoboKeikakuJikoSakuseiGokei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するYoboKeikakuJikoSakuseiGokeiIdentifierにセットされている() {
            sut = new YoboKeikakuJikoSakuseiGokei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new YoboKeikakuJikoSakuseiGokei(null);
        }

        @Test
        public void 指定したDbT3012YoboKeikakuJikoSakuseiGokeiEntityのキー情報を識別子が持つ() {

            sut = new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(YoboKeikakuJikoSakuseiGokeiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(YoboKeikakuJikoSakuseiGokeiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(YoboKeikakuJikoSakuseiGokeiEntity.getRirekiNo()));
        }

        @Test
        public void get居宅サービス区分は_entityが持つ居宅サービス区分を返す() {
            assertThat(sut.get居宅サービス区分(), is(YoboKeikakuJikoSakuseiGokeiEntity.getKyotakuServiceKubun()));
        }

        @Test
        public void getサービス提供事業者番号は_entityが持つサービス提供事業者番号を返す() {
            assertThat(sut.getサービス提供事業者番号(), is(YoboKeikakuJikoSakuseiGokeiEntity.getServiceTeikyoJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(YoboKeikakuJikoSakuseiGokeiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get給付計画単位数は_entityが持つ給付計画単位数を返す() {
            assertThat(sut.get給付計画単位数(), is(YoboKeikakuJikoSakuseiGokeiEntity.getKeikakuTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(YoboKeikakuJikoSakuseiGokeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokei sut;
        private static YoboKeikakuJikoSakuseiGokei result;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = DbT3012YoboKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3012YoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);

        }

        @Test
        public void YoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiGokei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void YoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiGokei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void YoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiGokeiが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiGokei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void YoboKeikakuJikoSakuseiGokeiが保持するDbT3012YoboKeikakuJikoSakuseiGokeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiGokei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static YoboKeikakuJikoSakuseiGokei setStateYoboKeikakuJikoSakuseiGokei(EntityDataState parentState) {
            YoboKeikakuJikoSakuseiGokeiEntity.setState(parentState);
            return new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);
        }
    }
}
