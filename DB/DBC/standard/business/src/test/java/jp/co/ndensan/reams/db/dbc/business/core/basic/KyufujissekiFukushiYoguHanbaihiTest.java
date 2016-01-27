/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator;
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
 * {@link KyufujissekiFukushiYoguHanbaihi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiFukushiYoguHanbaihiTest extends DbcTestBase {

    private static DbT3026KyufujissekiFukushiYoguHanbaihiEntity KyufujissekiFukushiYoguHanbaihiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        交換情報識別番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_通し番号;
        明細番号 = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.DEFAULT_明細番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiFukushiYoguHanbaihi(null, 入力識別番号, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);

        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiFukushiYoguHanbaihi(交換情報識別番号, null, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
        }

        @Test
        public void 指定したキーが保持するDbT3026KyufujissekiFukushiYoguHanbaihiEntityにセットされている() {
            sut = new KyufujissekiFukushiYoguHanbaihi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
            assertThat(sut.getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.get事業所番号(), is(事業所番号));
            assertThat(sut.get通し番号(), is(通し番号));
            assertThat(sut.get明細番号(), is(明細番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiFukushiYoguHanbaihiIdentifierにセットされている() {
            sut = new KyufujissekiFukushiYoguHanbaihi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号, 明細番号);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
            assertThat(sut.identifier().getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.identifier().get事業所番号(), is(事業所番号));
            assertThat(sut.identifier().get通し番号(), is(通し番号));
            assertThat(sut.identifier().get明細番号(), is(明細番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiFukushiYoguHanbaihi(null);
        }

        @Test
        public void 指定したDbT3026KyufujissekiFukushiYoguHanbaihiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiFukushiYoguHanbaihi(KyufujissekiFukushiYoguHanbaihiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
            assertThat(sut.identifier().getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.identifier().get事業所番号(), is(事業所番号));
            assertThat(sut.identifier().get通し番号(), is(通し番号));
            assertThat(sut.identifier().get明細番号(), is(明細番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiFukushiYoguHanbaihi sut;

        @Before
        public void setUp() {
            KyufujissekiFukushiYoguHanbaihiEntity = DbT3026KyufujissekiFukushiYoguHanbaihiEntityGenerator.createDbT3026KyufujissekiFukushiYoguHanbaihiEntity();
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);

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
        public void get摘要_品目コードは_entityが持つ摘要_品目コードを返す() {
            assertThat(sut.get摘要_品目コード(), is(KyufujissekiFukushiYoguHanbaihiEntity.getTekiyo())
            );
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
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);

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
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);

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
            KyufujissekiFukushiYoguHanbaihiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiFukushiYoguHanbaihiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiFukushiYoguHanbaihiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setToshiNo(通し番号);
            KyufujissekiFukushiYoguHanbaihiEntity.setMeisaiNo(明細番号);

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
