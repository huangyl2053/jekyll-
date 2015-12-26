/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3046ShokanServicePlan200604EntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link ShokanServicePlan200604}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanServicePlan200604Test extends DbcTestBase {

    private static DbT3046ShokanServicePlan200604Entity ShokanServicePlan200604Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static RString 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanServicePlan200604(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanServicePlan200604(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3046ShokanServicePlan200604Entityにセットされている() {
            sut = new ShokanServicePlan200604(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanServicePlan200604Identifierにセットされている() {
            sut = new ShokanServicePlan200604(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanServicePlan200604(null);
        }

        @Test
        public void 指定したDbT3046ShokanServicePlan200604Entityのキー情報を識別子が持つ() {

            sut = new ShokanServicePlan200604(ShokanServicePlan200604Entity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanServicePlan200604(ShokanServicePlan200604Entity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanServicePlan200604Entity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanServicePlan200604Entity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanServicePlan200604Entity.getSeiriNp()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanServicePlan200604Entity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanServicePlan200604Entity.getYoshikiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(ShokanServicePlan200604Entity.getMeisaiNo()));
        }

        @Test
        public void get指定_基準該当事業者区分コードは_entityが持つ指定_基準該当事業者区分コードを返す() {
            assertThat(sut.get指定_基準該当事業者区分コード(), is(ShokanServicePlan200604Entity.getShiteiKijunGaitoJigyoshaKubunCode()));
        }

        @Test
        public void get居宅サービス計画作成依頼届出年月日は_entityが持つ居宅サービス計画作成依頼届出年月日を返す() {
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(ShokanServicePlan200604Entity.getKyotakuServiceSakuseiIraiYMD()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(ShokanServicePlan200604Entity.getServiceCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ShokanServicePlan200604Entity.getTanisu()));
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(ShokanServicePlan200604Entity.getTanisuTanka()));
        }

        @Test
        public void get請求金額は_entityが持つ請求金額を返す() {
            assertThat(sut.get請求金額(), is(ShokanServicePlan200604Entity.getSeikyuKingaku()));
        }

        @Test
        public void get担当介護支援専門員番号は_entityが持つ担当介護支援専門員番号を返す() {
            assertThat(sut.get担当介護支援専門員番号(), is(ShokanServicePlan200604Entity.getTantokangoshienSemmoninNo()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(ShokanServicePlan200604Entity.getTekiyo()));
        }

        @Test
        public void get審査方法区分コードは_entityが持つ審査方法区分コードを返す() {
            assertThat(sut.get審査方法区分コード(), is(ShokanServicePlan200604Entity.getShinsaHohoKubunCode()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(ShokanServicePlan200604Entity.getShinsaYM()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanServicePlan200604Entity.getShikyuKubunCode()));
        }

        @Test
        public void get点数_金額は_entityが持つ点数_金額を返す() {
            assertThat(sut.get点数_金額(), is(ShokanServicePlan200604Entity.getTensuKingaku()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(ShokanServicePlan200604Entity.getShikyuKingaku()));
        }

        @Test
        public void get増減点は_entityが持つ増減点を返す() {
            assertThat(sut.get増減点(), is(ShokanServicePlan200604Entity.getZougenTen()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanServicePlan200604Entity.getSagakuKingaku()));
        }

        @Test
        public void get増減理由等は_entityが持つ増減理由等を返す() {
            assertThat(sut.get増減理由等(), is(ShokanServicePlan200604Entity.getZougenRiyu()));
        }

        @Test
        public void get不支給理由等は_entityが持つ不支給理由等を返す() {
            assertThat(sut.get不支給理由等(), is(ShokanServicePlan200604Entity.getFushikyuRiyu()));
        }

        @Test
        public void get購入_改修履歴等は_entityが持つ購入_改修履歴等を返す() {
            assertThat(sut.get購入_改修履歴等(), is(ShokanServicePlan200604Entity.getKounyuKaishuRireki()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanServicePlan200604(ShokanServicePlan200604Entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanServicePlan200604Entity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanServicePlan200604(ShokanServicePlan200604Entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanServicePlan200604 sut;
        private static ShokanServicePlan200604 result;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200604が返る() {
            sut = TestSupport.setStateShokanServicePlan200604(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200604が返る() {
            sut = TestSupport.setStateShokanServicePlan200604(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200604が返る() {
            sut = TestSupport.setStateShokanServicePlan200604(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanServicePlan200604が保持するDbT3046ShokanServicePlan200604EntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanServicePlan200604(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanServicePlan200604 setStateShokanServicePlan200604(EntityDataState parentState) {
            ShokanServicePlan200604Entity.setState(parentState);
            return new ShokanServicePlan200604(ShokanServicePlan200604Entity);
        }
    }
}
