/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3027KyufujissekiJutakuKaishuhiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link KyufujissekiJutakuKaishuhi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiJutakuKaishuhiTest extends DbcTestBase {

    private static DbT3027KyufujissekiJutakuKaishuhiEntity KyufujissekiJutakuKaishuhiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;
    private static RString 明細番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_通し番号;
        明細番号 = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.DEFAULT_明細番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiJutakuKaishuhi(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiJutakuKaishuhi(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
        }

        @Test
        public void 指定したキーが保持するDbT3027KyufujissekiJutakuKaishuhiEntityにセットされている() {
            sut = new KyufujissekiJutakuKaishuhi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiJutakuKaishuhiIdentifierにセットされている() {
            sut = new KyufujissekiJutakuKaishuhi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiJutakuKaishuhi(null);
        }

        @Test
        public void 指定したDbT3027KyufujissekiJutakuKaishuhiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiJutakuKaishuhi(KyufujissekiJutakuKaishuhiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiJutakuKaishuhi sut;

        @Before
        public void setUp() {
            KyufujissekiJutakuKaishuhiEntity = DbT3027KyufujissekiJutakuKaishuhiEntityGenerator.createDbT3027KyufujissekiJutakuKaishuhiEntity();
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);

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
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);

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
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);

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
            KyufujissekiJutakuKaishuhiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiJutakuKaishuhiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiJutakuKaishuhiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiJutakuKaishuhiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiJutakuKaishuhiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiJutakuKaishuhiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiJutakuKaishuhiEntity.setToshiNo(通し番号);
            KyufujissekiJutakuKaishuhiEntity.setMeisaiNo(明細番号);

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
