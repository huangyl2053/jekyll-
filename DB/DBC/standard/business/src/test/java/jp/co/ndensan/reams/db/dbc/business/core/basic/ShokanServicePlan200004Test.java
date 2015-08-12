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
 * {@link ShokanServicePlan200004}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanServicePlan200004Test extends DbcTestBase {

    private static DbT3045ShokanServicePlan200004Entity ShokanServicePlan200004Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3045ShokanServicePlan200004EntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3045ShokanServicePlan200004EntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanServicePlan200004(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanServicePlan200004(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3045ShokanServicePlan200004Entityにセットされている() {
            sut = new ShokanServicePlan200004(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanServicePlan200004Identifierにセットされている() {
            sut = new ShokanServicePlan200004(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanServicePlan200004(null);
        }

        @Test
        public void 指定したDbT3045ShokanServicePlan200004Entityのキー情報を識別子が持つ() {

            sut = new ShokanServicePlan200004(ShokanServicePlan200004Entity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);

            sut = new ShokanServicePlan200004(ShokanServicePlan200004Entity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanServicePlan200004Entity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanServicePlan200004Entity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanServicePlan200004Entity.getSeiriNp()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanServicePlan200004Entity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanServicePlan200004Entity.getYoshikiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanServicePlan200004Entity.getRirekiNo()));
        }

        @Test
        public void get指定／基準該当事業者区分コードは_entityが持つ指定／基準該当事業者区分コードを返す() {
            assertThat(sut.get指定／基準該当事業者区分コード(), is(ShokanServicePlan200004Entity.getShiteiKijunGaitoJigyoshaKubunCode()));
        }

        @Test
        public void get居宅サービス計画作成依頼届出年月日は_entityが持つ居宅サービス計画作成依頼届出年月日を返す() {
            assertThat(sut.get居宅サービス計画作成依頼届出年月日(), is(ShokanServicePlan200004Entity.getKyotakuServiceSakuseiIraiYMD()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(ShokanServicePlan200004Entity.getServiceCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ShokanServicePlan200004Entity.getTanisu()));
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(ShokanServicePlan200004Entity.getTanisuTanka()));
        }

        @Test
        public void get請求金額は_entityが持つ請求金額を返す() {
            assertThat(sut.get請求金額(), is(ShokanServicePlan200004Entity.getSeikyuKingaku()));
        }

        @Test
        public void get審査方法区分コードは_entityが持つ審査方法区分コードを返す() {
            assertThat(sut.get審査方法区分コード(), is(ShokanServicePlan200004Entity.getShinsaHohoKubunCode()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(ShokanServicePlan200004Entity.getShinsaYM()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanServicePlan200004Entity.getShikyuKubunCode()));
        }

        @Test
        public void get点数／金額は_entityが持つ点数／金額を返す() {
            assertThat(sut.get点数／金額(), is(ShokanServicePlan200004Entity.getTensuKingaku()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(ShokanServicePlan200004Entity.getShikyuKingaku()));
        }

        @Test
        public void get増減点は_entityが持つ増減点を返す() {
            assertThat(sut.get増減点(), is(ShokanServicePlan200004Entity.getZougenTen()));
        }

        @Test
        public void get差額金額は_entityが持つ差額金額を返す() {
            assertThat(sut.get差額金額(), is(ShokanServicePlan200004Entity.getSagakuKingaku()));
        }

        @Test
        public void get増減理由等は_entityが持つ増減理由等を返す() {
            assertThat(sut.get増減理由等(), is(ShokanServicePlan200004Entity.getZougenRiyu()));
        }

        @Test
        public void get不支給理由等は_entityが持つ不支給理由等を返す() {
            assertThat(sut.get不支給理由等(), is(ShokanServicePlan200004Entity.getFushikyuRiyu()));
        }

        @Test
        public void get購入・改修履歴等は_entityが持つ購入・改修履歴等を返す() {
            assertThat(sut.get購入・改修履歴等(), is(ShokanServicePlan200004Entity.getKounyuKaishuRireki()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);

            sut = new ShokanServicePlan200004(ShokanServicePlan200004Entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanServicePlan200004Entity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);

            sut = new ShokanServicePlan200004(ShokanServicePlan200004Entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanServicePlan200004 sut;
        private static ShokanServicePlan200004 result;

        @Before
        public void setUp() {
            ShokanServicePlan200004Entity = DbT3045ShokanServicePlan200004EntityGenerator.createDbT3045ShokanServicePlan200004Entity();
            ShokanServicePlan200004Entity.setXXX(主キー名1);
            ShokanServicePlan200004Entity.setXXX(主キー名2);

        }

        @Test
        public void ShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200004が返る() {
            sut = TestSupport.setStateShokanServicePlan200004(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200004が返る() {
            sut = TestSupport.setStateShokanServicePlan200004(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがDeletedに指定されたShokanServicePlan200004が返る() {
            sut = TestSupport.setStateShokanServicePlan200004(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanServicePlan200004が保持するDbT3045ShokanServicePlan200004EntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanServicePlan200004(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanServicePlan200004 setStateShokanServicePlan200004(EntityDataState parentState) {
            ShokanServicePlan200004Entity.setState(parentState);
            return new ShokanServicePlan200004(ShokanServicePlan200004Entity);
        }
    }
}
