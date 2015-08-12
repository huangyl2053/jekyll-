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
 * {@link KyufujissekiFukushiYoguHanbaihi}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiFukushiYoguHanbaihiTest extends DbcTestBase {

    private static DbT3026KyufujissekiFukushiYoguHanbaihiEntity KyufujissekiFukushiYoguHanbaihiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiFukushiYoguHanbaihi(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiFukushiYoguHanbaihi(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityにセットされている() {
            sut = new KyufujissekiFukushiYoguHanbaihi(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiFukushiYoguHanbaihiIdentifierにセットされている() {
            sut = new KyufujissekiFukushiYoguHanbaihi(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiFukushiYoguHanbaihi(null);
        }

        @Test
        public void 指定したDbT3026KyufujissekiFukushiYoguHanbaihiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);

            sut = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiFukushiYoguHanbaihiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiFukushiYoguHanbaihiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getToshiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getMeisaiNo()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(KyufujissekiFukushiYoguHanbaihiEntity.getServiceCode()));
        }

        @Test
        public void get福祉用具販売年月日は_entityが持つ福祉用具販売年月日を返す() {
            assertThat(sut.get福祉用具販売年月日(), is(KyufujissekiFukushiYoguHanbaihiEntity.getFukushiyoguHanbaiYMD()));
        }

        @Test
        public void get福祉用具商品名は_entityが持つ福祉用具商品名を返す() {
            assertThat(sut.get福祉用具商品名(), is(KyufujissekiFukushiYoguHanbaihiEntity.getFukushiyoguShohinName()));
        }

        @Test
        public void get福祉用具種目コードは_entityが持つ福祉用具種目コードを返す() {
            assertThat(sut.get福祉用具種目コード(), is(KyufujissekiFukushiYoguHanbaihiEntity.getFukushiyoguSyumokuCode()));
        }

        @Test
        public void get福祉用具製造事業者名は_entityが持つ福祉用具製造事業者名を返す() {
            assertThat(sut.get福祉用具製造事業者名(), is(KyufujissekiFukushiYoguHanbaihiEntity.getFukushiyoguSeizoJigyoshaName()));
        }

        @Test
        public void get福祉用具販売事業者名は_entityが持つ福祉用具販売事業者名を返す() {
            assertThat(sut.get福祉用具販売事業者名(), is(KyufujissekiFukushiYoguHanbaihiEntity.getFukushiyoguHanbaiJigyoshaName()));
        }

        @Test
        public void get販売金額は_entityが持つ販売金額を返す() {
            assertThat(sut.get販売金額(), is(KyufujissekiFukushiYoguHanbaihiEntity.getHanbaiKingaku()));
        }

        @Test
        public void get摘要（品目コード）は_entityが持つ摘要（品目コード）を返す() {
            assertThat(sut.get摘要（品目コード）(), is(KyufujissekiFukushiYoguHanbaihiEntity.getTekiyo()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiFukushiYoguHanbaihiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiFukushiYoguHanbaihiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiFukushiYoguHanbaihiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);

            sut = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiFukushiYoguHanbaihiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);

            sut = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;
        private static KyufujissekiFukushiYoguHanbaihi result;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            KyufujissekiFukushiYoguHanbaihiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたKyufujissekiFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateKyufujissekiFukushiYoguHanbaihi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたKyufujissekiFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateKyufujissekiFukushiYoguHanbaihi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがDeletedに指定されたKyufujissekiFukushiYoguHanbaihiが返る() {
            sut = TestSupport.setStateKyufujissekiFukushiYoguHanbaihi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiFukushiYoguHanbaihiが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiFukushiYoguHanbaihi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiFukushiYoguHanbaihi setStateKyufujissekiFukushiYoguHanbaihi(EntityDataState parentState) {
            KyufujissekiFukushiYoguHanbaihiEntity.setState(parentState);
            return new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);
        }
    }
}
