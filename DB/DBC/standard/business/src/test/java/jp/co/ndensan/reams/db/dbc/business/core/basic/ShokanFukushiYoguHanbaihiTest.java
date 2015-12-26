/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3048ShokanFukushiYoguHanbaihiEntityGenerator;
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
 * {@link ShokanFukushiYoguHanbaihi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanFukushiYoguHanbaihiTest extends DbcTestBase {

    private static DbT3048ShokanFukushiYoguHanbaihiEntity ShokanFukushiYoguHanbaihiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanFukushiYoguHanbaihi(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanFukushiYoguHanbaihi(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3048ShokanFukushiYoguHanbaihiEntityにセットされている() {
            sut = new ShokanFukushiYoguHanbaihi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanFukushiYoguHanbaihiIdentifierにセットされている() {
            sut = new ShokanFukushiYoguHanbaihi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanFukushiYoguHanbaihi(null);
        }

        @Test
        public void 指定したDbT3048ShokanFukushiYoguHanbaihiEntityのキー情報を識別子が持つ() {

            sut = new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanFukushiYoguHanbaihiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanFukushiYoguHanbaihiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanFukushiYoguHanbaihiEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanFukushiYoguHanbaihiEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanFukushiYoguHanbaihiEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanFukushiYoguHanbaihiEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanFukushiYoguHanbaihiEntity.getRirekiNo()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(ShokanFukushiYoguHanbaihiEntity.getServiceCode()));
        }

        @Test
        public void get福祉用具販売年月日は_entityが持つ福祉用具販売年月日を返す() {
            assertThat(sut.get福祉用具販売年月日(), is(ShokanFukushiYoguHanbaihiEntity.getFukushiYoguHanbaiYMD()));
        }

        @Test
        public void get福祉用具商品名は_entityが持つ福祉用具商品名を返す() {
            assertThat(sut.get福祉用具商品名(), is(ShokanFukushiYoguHanbaihiEntity.getFukushiYoguShohinName()));
        }

        @Test
        public void get福祉用具種目コードは_entityが持つ福祉用具種目コードを返す() {
            assertThat(sut.get福祉用具種目コード(), is(ShokanFukushiYoguHanbaihiEntity.getFukushiYoguShumokuCode()));
        }

        @Test
        public void get福祉用具製造事業者名は_entityが持つ福祉用具製造事業者名を返す() {
            assertThat(sut.get福祉用具製造事業者名(), is(ShokanFukushiYoguHanbaihiEntity.getFukushiYoguSeizoJigyoshaName()));
        }

        @Test
        public void get福祉用具販売事業者名は_entityが持つ福祉用具販売事業者名を返す() {
            assertThat(sut.get福祉用具販売事業者名(), is(ShokanFukushiYoguHanbaihiEntity.getFukushiYoguHanbaiJigyoshaName()));
        }

        @Test
        public void get購入金額は_entityが持つ購入金額を返す() {
            assertThat(sut.get購入金額(), is(ShokanFukushiYoguHanbaihiEntity.getKounyuKingaku()));
        }

        @Test
        public void get品目コードは_entityが持つ品目コードを返す() {
            assertThat(sut.get品目コード(), is(ShokanFukushiYoguHanbaihiEntity.getHinmokuCode()));
        }

        @Test
        public void get審査方法区分コードは_entityが持つ審査方法区分コードを返す() {
            assertThat(sut.get審査方法区分コード(), is(ShokanFukushiYoguHanbaihiEntity.getShinsaHohoKubunCode()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanFukushiYoguHanbaihiEntity.getSagakuKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanFukushiYoguHanbaihiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanFukushiYoguHanbaihi sut;
        private static ShokanFukushiYoguHanbaihi result;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.createDbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setHiHokenshaNo(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたShokanFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateShokanFukushiYoguHanbaihi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたShokanFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateShokanFukushiYoguHanbaihi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたShokanFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateShokanFukushiYoguHanbaihi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanFukushiYoguHanbaihiが保持するDbT3048ShokanFukushiYoguHanbaihiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanFukushiYoguHanbaihi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanFukushiYoguHanbaihi setStateShokanFukushiYoguHanbaihi(EntityDataState parentState) {
            ShokanFukushiYoguHanbaihiEntity.setState(parentState);
            return new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);
        }
    }
}
