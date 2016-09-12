/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class YoboKeikakuJikoSakuseiTankiRiyoNissuTest extends DbcTestBase {

    private static DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;
    private static FlexibleYearMonth 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.DEFAULT_対象年月;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityにセットされている() {
            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するYoboKeikakuJikoSakuseiTankiRiyoNissuIdentifierにセットされている() {
            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(null);
        }

        @Test
        public void 指定したDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのキー情報を識別子が持つ() {

            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.getRirekiNo()));
        }

        @Test
        public void get前回迄利用日数は_entityが持つ前回迄利用日数を返す() {
            assertThat(sut.get前回迄利用日数(), is(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.getZenkaiRiyoNissu()));
        }

        @Test
        public void get今回計画利用日数は_entityが持つ今回計画利用日数を返す() {
            assertThat(sut.get今回計画利用日数(), is(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.getKonkaiKeikakuRiyoNissu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);

            sut = new YoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiTankiRiyoNissu sut;
        private static YoboKeikakuJikoSakuseiTankiRiyoNissu result;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setTaishoYM(主キー名2);

        }

        @Test
        public void YoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiTankiRiyoNissuが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiTankiRiyoNissu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void YoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiTankiRiyoNissuが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiTankiRiyoNissu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void YoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりYoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがDeletedに指定されたYoboKeikakuJikoSakuseiTankiRiyoNissuが返る() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiTankiRiyoNissu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void YoboKeikakuJikoSakuseiTankiRiyoNissuが保持するDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateYoboKeikakuJikoSakuseiTankiRiyoNissu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static YoboKeikakuJikoSakuseiTankiRiyoNissu setStateYoboKeikakuJikoSakuseiTankiRiyoNissu(EntityDataState parentState) {
            YoboKeikakuJikoSakuseiTankiRiyoNissuEntity.setState(parentState);
            return new YoboKeikakuJikoSakuseiTankiRiyoNissu(YoboKeikakuJikoSakuseiTankiRiyoNissuEntity);
        }
    }
}
