/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import org.junit.Ignore;

/**
 * {@link ShokanTokuteiShinryoTokubetsuRyoyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanTokuteiShinryoTokubetsuRyoyoTest extends DbcTestBase {

    private static DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity ShokanTokuteiShinryoTokubetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static Decimal 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityにセットされている() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanTokuteiShinryoTokubetsuRyoyoIdentifierにセットされている() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(null);
        }

        @Test
        public void 指定したDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのキー情報を識別子が持つ() {

            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getRirekiNo()));
        }

        @Test
        public void get傷病名は_entityが持つ傷病名を返す() {
            assertThat(sut.get傷病名(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getShobyoName()));
        }

        @Test
        public void get識別番号は_entityが持つ識別番号を返す() {
            assertThat(sut.get識別番号(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getShikibetsuNo()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getTanisu()));
        }

        @Test
        public void get回数は_entityが持つ回数を返す() {
            assertThat(sut.get回数(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getKaisu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getServiceTanisu()));
        }

        @Test
        public void get合計単位数は_entityが持つ合計単位数を返す() {
            assertThat(sut.get合計単位数(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getTotalTanisu()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(ShokanTokuteiShinryoTokubetsuRyoyoEntity.getTekiyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanTokuteiShinryoTokubetsuRyoyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyo sut;
        private static ShokanTokuteiShinryoTokubetsuRyoyo result;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryoTokubetsuRyoyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryoTokubetsuRyoyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryoTokubetsuRyoyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanTokuteiShinryoTokubetsuRyoyoが保持するDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanTokuteiShinryoTokubetsuRyoyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanTokuteiShinryoTokubetsuRyoyo setStateShokanTokuteiShinryoTokubetsuRyoyo(EntityDataState parentState) {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setState(parentState);
            return new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);
        }
    }
}
