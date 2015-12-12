/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator;
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
 * {@link ShokanTokuteiNyushoshaKaigoServiceHiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanTokuteiNyushoshaKaigoServiceHiyoTest extends DbcTestBase {

    private static DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityにセットされている() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanTokuteiNyushoshaKaigoServiceHiyoIdentifierにセットされている() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(null);
        }

        @Test
        public void 指定したDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのキー情報を識別子が持つ() {

            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getRirekiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getServiceKomokuCode()));
        }

        @Test
        public void get費用単価は_entityが持つ費用単価を返す() {
            assertThat(sut.get費用単価(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHiyoTanka()));
        }

        @Test
        public void get負担限度額は_entityが持つ負担限度額を返す() {
            assertThat(sut.get負担限度額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getFutanGendogaku()));
        }

        @Test
        public void get日数は_entityが持つ日数を返す() {
            assertThat(sut.get日数(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getNissu()));
        }

        @Test
        public void get費用額は_entityが持つ費用額を返す() {
            assertThat(sut.get費用額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHiyogaku()));
        }

        @Test
        public void get保険分請求額は_entityが持つ保険分請求額を返す() {
            assertThat(sut.get保険分請求額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHokenbunSeikyugaku()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get費用額合計は_entityが持つ費用額合計を返す() {
            assertThat(sut.get費用額合計(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHiyogakuTotal()));
        }

        @Test
        public void get保険分請求額合計は_entityが持つ保険分請求額合計を返す() {
            assertThat(sut.get保険分請求額合計(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getHokenbunSeikyugakuTotal()));
        }

        @Test
        public void get利用者負担額合計は_entityが持つ利用者負担額合計を返す() {
            assertThat(sut.get利用者負担額合計(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getRiyoshaFutangakuTotal()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getShikyuKubunCode()));
        }

        @Test
        public void get点数_金額は_entityが持つ点数_金額を返す() {
            assertThat(sut.get点数_金額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getTensuKingaku()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getShikyuKingaku()));
        }

        @Test
        public void get増減点は_entityが持つ増減点を返す() {
            assertThat(sut.get増減点(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getZougenten()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.getSagakuKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyo sut;
        private static ShokanTokuteiNyushoshaKaigoServiceHiyo result;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiNyushoshaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateShokanTokuteiNyushoshaKaigoServiceHiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiNyushoshaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateShokanTokuteiNyushoshaKaigoServiceHiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたShokanTokuteiNyushoshaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateShokanTokuteiNyushoshaKaigoServiceHiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanTokuteiNyushoshaKaigoServiceHiyoが保持するDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanTokuteiNyushoshaKaigoServiceHiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanTokuteiNyushoshaKaigoServiceHiyo setStateShokanTokuteiNyushoshaKaigoServiceHiyo(EntityDataState parentState) {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setState(parentState);
            return new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);
        }
    }
}
