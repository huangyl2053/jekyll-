/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3031KyufuJissekiCareManagementHiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyufuJissekiCareManagementHi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufuJissekiCareManagementHiTest extends DbcTestBase {

    private static DbT3031KyufuJissekiCareManagementHiEntity KyufuJissekiCareManagementHiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;
    private static FlexibleDate 主キー名9;
    private static RString 主キー名10;
    private static RString 主キー名11;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
        主キー名9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
        主キー名10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
        主キー名11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiCareManagementHi(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiCareManagementHi(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test
        public void 指定したキーが保持するDbT3031KyufuJissekiCareManagementHiEntityにセットされている() {
            sut = new KyufuJissekiCareManagementHi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
            assertThat(sut.get交換情報識別番号(), is(主キー名1));
            assertThat(sut.get入力識別番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuJissekiCareManagementHiIdentifierにセットされている() {
            sut = new KyufuJissekiCareManagementHi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuJissekiCareManagementHi(null);
        }

        @Test
        public void 指定したDbT3031KyufuJissekiCareManagementHiEntityのキー情報を識別子が持つ() {

            sut = new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufuJissekiCareManagementHiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufuJissekiCareManagementHiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufuJissekiCareManagementHiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufuJissekiCareManagementHiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuJissekiCareManagementHiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufuJissekiCareManagementHiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufuJissekiCareManagementHiEntity.getJigyoshoNo()));
        }

        @Test
        public void get指定_基準該当事業所区分コードは_entityが持つ指定_基準該当事業所区分コードを返す() {
            assertThat(sut.get指定_基準該当事業所区分コード(), is(KyufuJissekiCareManagementHiEntity.getShiteiKijungaitoJigyoshoKubunCode()));
        }

        @Test
        public void get居宅サービス計画作成依頼届出年月日は_entityが持つ居宅サービス計画作成依頼届出年月日を返す() {
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(KyufuJissekiCareManagementHiEntity.getKyotakuServiceSakuseiIraiYMD()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufuJissekiCareManagementHiEntity.getToshiNo()));
        }

        @Test
        public void getサービス計画費明細行番号は_entityが持つサービス計画費明細行番号を返す() {
            assertThat(sut.getサービス計画費明細行番号(), is(KyufuJissekiCareManagementHiEntity.getServicePlanhiMeisaiLineNo()));
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(KyufuJissekiCareManagementHiEntity.getTanisuTanka()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(KyufuJissekiCareManagementHiEntity.getServiceCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KyufuJissekiCareManagementHiEntity.getTanisu()));
        }

        @Test
        public void get回数は_entityが持つ回数を返す() {
            assertThat(sut.get回数(), is(KyufuJissekiCareManagementHiEntity.getKaisu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(KyufuJissekiCareManagementHiEntity.getServiceTanisu()));
        }

        @Test
        public void getサービス単位数合計は_entityが持つサービス単位数合計を返す() {
            assertThat(sut.getサービス単位数合計(), is(KyufuJissekiCareManagementHiEntity.getSerivceTanisuTotal()));
        }

        @Test
        public void get請求金額は_entityが持つ請求金額を返す() {
            assertThat(sut.get請求金額(), is(KyufuJissekiCareManagementHiEntity.getSeikyuKingaku()));
        }

        @Test
        public void get担当介護支援専門員番号は_entityが持つ担当介護支援専門員番号を返す() {
            assertThat(sut.get担当介護支援専門員番号(), is(KyufuJissekiCareManagementHiEntity.getTantoKaigoShienSemmoninNo()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(KyufuJissekiCareManagementHiEntity.getTekiyo()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KyufuJissekiCareManagementHiEntity.getRiyoushaFutangaku()));
        }

        @Test
        public void get後_単位数は_entityが持つ後_単位数を返す() {
            assertThat(sut.get後_単位数(), is(KyufuJissekiCareManagementHiEntity.getAtoTanisu()));
        }

        @Test
        public void get後_回数は_entityが持つ後_回数を返す() {
            assertThat(sut.get後_回数(), is(KyufuJissekiCareManagementHiEntity.getAtoKaisu()));
        }

        @Test
        public void get後_サービス単位数は_entityが持つ後_サービス単位数を返す() {
            assertThat(sut.get後_サービス単位数(), is(KyufuJissekiCareManagementHiEntity.getAtoServiceTanisu()));
        }

        @Test
        public void get後_サービス単位数合計は_entityが持つ後_サービス単位数合計を返す() {
            assertThat(sut.get後_サービス単位数合計(), is(KyufuJissekiCareManagementHiEntity.getAtoServiceTanisuTotal()));
        }

        @Test
        public void get後_請求金額は_entityが持つ後_請求金額を返す() {
            assertThat(sut.get後_請求金額(), is(KyufuJissekiCareManagementHiEntity.getAtoSeikyuKingaku()));
        }

        @Test
        public void get後_利用者負担額は_entityが持つ後_利用者負担額を返す() {
            assertThat(sut.get後_利用者負担額(), is(KyufuJissekiCareManagementHiEntity.getAtoRiyoshaFutangaku()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufuJissekiCareManagementHiEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufuJissekiCareManagementHiEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufuJissekiCareManagementHiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufuJissekiCareManagementHiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufuJissekiCareManagementHiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuJissekiCareManagementHiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuJissekiCareManagementHi sut;
        private static KyufuJissekiCareManagementHi result;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);

        }

        @Test
        public void KyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがDeletedに指定されたKyufuJissekiCareManagementHiが返る() {
            sut = TestSupport.setStateKyufuJissekiCareManagementHi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがDeletedに指定されたKyufuJissekiCareManagementHiが返る() {
            sut = TestSupport.setStateKyufuJissekiCareManagementHi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがDeletedに指定されたKyufuJissekiCareManagementHiが返る() {
            sut = TestSupport.setStateKyufuJissekiCareManagementHi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuJissekiCareManagementHiが保持するDbT3031KyufuJissekiCareManagementHiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuJissekiCareManagementHi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuJissekiCareManagementHi setStateKyufuJissekiCareManagementHi(EntityDataState parentState) {
            KyufuJissekiCareManagementHiEntity.setState(parentState);
            return new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);
        }
    }
}
