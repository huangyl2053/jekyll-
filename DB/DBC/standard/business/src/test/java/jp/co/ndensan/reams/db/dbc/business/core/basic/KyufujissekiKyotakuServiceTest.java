/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3025KyufujissekiKyotakuServiceEntityGenerator;
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
 * {@link KyufujissekiKyotakuService}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiKyotakuServiceTest extends DbcTestBase {

    private static DbT3025KyufujissekiKyotakuServiceEntity KyufujissekiKyotakuServiceEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
    private static RString サービス計画費明細行番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_通し番号;
        サービス計画費明細行番号 = DbT3025KyufujissekiKyotakuServiceEntityGenerator.DEFAULT_サービス計画費明細行番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKyotakuService(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号, サービス計画費明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKyotakuService(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号, サービス計画費明細行番号);
        }

        @Test
        public void 指定したキーが保持するDbT3025KyufujissekiKyotakuServiceEntityにセットされている() {
            sut = new KyufujissekiKyotakuService(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号, サービス計画費明細行番号);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiKyotakuServiceIdentifierにセットされている() {
            sut = new KyufujissekiKyotakuService(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号, サービス計画費明細行番号);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiKyotakuService(null);
        }

        @Test
        public void 指定したDbT3025KyufujissekiKyotakuServiceEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiKyotakuService(KyufujissekiKyotakuServiceEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);

            sut = new KyufujissekiKyotakuService(KyufujissekiKyotakuServiceEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiKyotakuServiceEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiKyotakuServiceEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiKyotakuServiceEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiKyotakuServiceEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiKyotakuServiceEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiKyotakuServiceEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiKyotakuServiceEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiKyotakuServiceEntity.getToshiNo()));
        }

        @Test
        public void getサービス計画費明細行番号は_entityが持つサービス計画費明細行番号を返す() {
            assertThat(sut.getサービス計画費明細行番号(), is(KyufujissekiKyotakuServiceEntity.getServicePlanhiMeisaiLineNo()));
        }

        @Test
        public void get指定_基準該当等事業所区分コードは_entityが持つ指定_基準該当等事業所区分コードを返す() {
            assertThat(sut.get指定_基準該当等事業所区分コード(), is(KyufujissekiKyotakuServiceEntity.getShiteiKijunGaitoJigyoshaKubunCode())
            );
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(KyufujissekiKyotakuServiceEntity.getTanisuTanka()));
        }

        @Test
        public void get居宅サービス計画作成依頼届出年月日は_entityが持つ居宅サービス計画作成依頼届出年月日を返す() {
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(KyufujissekiKyotakuServiceEntity.getKyotakuServiceSakuseiIraiYMD()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(KyufujissekiKyotakuServiceEntity.getServiceCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KyufujissekiKyotakuServiceEntity.getTanisu()));
        }

        @Test
        public void get回数は_entityが持つ回数を返す() {
            assertThat(sut.get回数(), is(KyufujissekiKyotakuServiceEntity.getKaisu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(KyufujissekiKyotakuServiceEntity.getServiceTanisu()));
        }

        @Test
        public void getサービス単位数合計は_entityが持つサービス単位数合計を返す() {
            assertThat(sut.getサービス単位数合計(), is(KyufujissekiKyotakuServiceEntity.getServiceTanisuTotal()));
        }

        @Test
        public void get請求金額は_entityが持つ請求金額を返す() {
            assertThat(sut.get請求金額(), is(KyufujissekiKyotakuServiceEntity.getSeikyuKingaku()));
        }

        @Test
        public void get担当介護支援専門員番号は_entityが持つ担当介護支援専門員番号を返す() {
            assertThat(sut.get担当介護支援専門員番号(), is(KyufujissekiKyotakuServiceEntity.getTantouKaigoShienSemmoninNo()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(KyufujissekiKyotakuServiceEntity.getTekiyo()));
        }

        @Test
        public void get後_単位数は_entityが持つ後_単位数を返す() {
            assertThat(sut.get後_単位数(), is(KyufujissekiKyotakuServiceEntity.getAtoTanisu())
            );
        }

        @Test
        public void get後_回数は_entityが持つ後_回数を返す() {
            assertThat(sut.get後_回数(), is(KyufujissekiKyotakuServiceEntity.getAtoKaisu())
            );
        }

        @Test
        public void get後_サービス単位数は_entityが持つ後_サービス単位数を返す() {
            assertThat(sut.get後_サービス単位数(), is(KyufujissekiKyotakuServiceEntity.getAtoServiceTanisu())
            );
        }

        @Test
        public void get後_サービス単位数合計は_entityが持つ後_サービス単位数合計を返す() {
            assertThat(sut.get後_サービス単位数合計(), is(KyufujissekiKyotakuServiceEntity.getAtoServiceTanisuTotal())
            );
        }

        @Test
        public void get後_請求金額は_entityが持つ後_請求金額を返す() {
            assertThat(sut.get後_請求金額(), is(KyufujissekiKyotakuServiceEntity.getAtoSeikyuKingaku())
            );
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiKyotakuServiceEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiKyotakuServiceEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiKyotakuServiceEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiKyotakuServiceEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiKyotakuServiceEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);

            sut = new KyufujissekiKyotakuService(KyufujissekiKyotakuServiceEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiKyotakuServiceEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);

            sut = new KyufujissekiKyotakuService(KyufujissekiKyotakuServiceEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiKyotakuService sut;
        private static KyufujissekiKyotakuService result;

        @Before
        public void setUp() {
            KyufujissekiKyotakuServiceEntity = DbT3025KyufujissekiKyotakuServiceEntityGenerator.createDbT3025KyufujissekiKyotakuServiceEntity();
            KyufujissekiKyotakuServiceEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKyotakuServiceEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKyotakuServiceEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKyotakuServiceEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKyotakuServiceEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKyotakuServiceEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKyotakuServiceEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKyotakuServiceEntity.setToshiNo(通し番号);
            KyufujissekiKyotakuServiceEntity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);

        }

        @Test
        public void KyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがDeletedに指定されたKyufujissekiKyotakuServiceが返る() {
            sut = TestSupport.setStateKyufujissekiKyotakuService(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがDeletedに指定されたKyufujissekiKyotakuServiceが返る() {
            sut = TestSupport.setStateKyufujissekiKyotakuService(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがDeletedに指定されたKyufujissekiKyotakuServiceが返る() {
            sut = TestSupport.setStateKyufujissekiKyotakuService(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiKyotakuServiceが保持するDbT3025KyufujissekiKyotakuServiceEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiKyotakuService(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiKyotakuService setStateKyufujissekiKyotakuService(EntityDataState parentState) {
            KyufujissekiKyotakuServiceEntity.setState(parentState);
            return new KyufujissekiKyotakuService(KyufujissekiKyotakuServiceEntity);
        }
    }
}
