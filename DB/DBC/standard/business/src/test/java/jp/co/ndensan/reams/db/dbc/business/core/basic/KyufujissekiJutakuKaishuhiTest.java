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
 * {@link KyufujissekiJutakuKaishuhi}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiJutakuKaishuhiTest extends DbcTestBase {

    private static DbT3027KyufujissekiJutakuKaishuhiEntity KyufujissekiJutakuKaishuhiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiJutakuKaishuhi(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiJutakuKaishuhi(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3027KyufujissekiJutakuKaishuhiEntityにセットされている() {
            sut = new KyufujissekiJutakuKaishuhi(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiJutakuKaishuhiIdentifierにセットされている() {
            sut = new KyufujissekiJutakuKaishuhi(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiJutakuKaishuhi(null);
        }

        @Test
        public void 指定したDbT3027KyufujissekiJutakuKaishuhiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);

            sut = new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiJutakuKaishuhiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiJutakuKaishuhiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiJutakuKaishuhiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiJutakuKaishuhiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiJutakuKaishuhiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiJutakuKaishuhiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiJutakuKaishuhiEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiJutakuKaishuhiEntity.getToshiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(KyufujissekiJutakuKaishuhiEntity.getMeisaiNo()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(KyufujissekiJutakuKaishuhiEntity.getServiceCode()));
        }

        @Test
        public void get住宅改修着工年月日は_entityが持つ住宅改修着工年月日を返す() {
            assertThat(sut.get住宅改修着工年月日(), is(KyufujissekiJutakuKaishuhiEntity.getJutakuKaishuchakkoYMD()));
        }

        @Test
        public void get住宅改修事業者名は_entityが持つ住宅改修事業者名を返す() {
            assertThat(sut.get住宅改修事業者名(), is(KyufujissekiJutakuKaishuhiEntity.getJutakuKaishuJigyoshaName()));
        }

        @Test
        public void get住宅改修住宅住所は_entityが持つ住宅改修住宅住所を返す() {
            assertThat(sut.get住宅改修住宅住所(), is(KyufujissekiJutakuKaishuhiEntity.getJuutakukaishuJyutakuAdress()));
        }

        @Test
        public void get改修金額は_entityが持つ改修金額を返す() {
            assertThat(sut.get改修金額(), is(KyufujissekiJutakuKaishuhiEntity.getKaishuKingaku()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiJutakuKaishuhiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiJutakuKaishuhiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiJutakuKaishuhiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);

            sut = new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiJutakuKaishuhiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);

            sut = new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;
        private static KyufujissekiJutakuKaishuhi result;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名1);
            KyufujissekiJutakuKaishuhiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがDeletedに指定されたKyufujissekiJutakuKaishuhiが返る() {
            sut = TestSupport.setStateKyufujissekiJutakuKaishuhi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがDeletedに指定されたKyufujissekiJutakuKaishuhiが返る() {
            sut = TestSupport.setStateKyufujissekiJutakuKaishuhi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがDeletedに指定されたKyufujissekiJutakuKaishuhiが返る() {
            sut = TestSupport.setStateKyufujissekiJutakuKaishuhi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiJutakuKaishuhiが保持するDbT3027KyufujissekiJutakuKaishuhiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiJutakuKaishuhi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiJutakuKaishuhi setStateKyufujissekiJutakuKaishuhi(EntityDataState parentState) {
            KyufujissekiJutakuKaishuhiEntity.setState(parentState);
            return new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);
        }
    }
}
