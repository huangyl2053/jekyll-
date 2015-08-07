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
 * {@link KyufuKanrihyo200604}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200604Test extends DbcTestBase {

    private static DbT3015KyufuKanrihyo200604Entity KyufuKanrihyo200604Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3015KyufuKanrihyo200604EntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200604(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200604(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3015KyufuKanrihyo200604Entityにセットされている() {
            sut = new KyufuKanrihyo200604(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuKanrihyo200604Identifierにセットされている() {
            sut = new KyufuKanrihyo200604(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuKanrihyo200604(null);
        }

        @Test
        public void 指定したDbT3015KyufuKanrihyo200604Entityのキー情報を識別子が持つ() {

            sut = new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufuKanrihyo200604Entity.getShinsaYM()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufuKanrihyo200604Entity.getServiceTeikyoYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufuKanrihyo200604Entity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get居宅支援事業所番号は_entityが持つ居宅支援事業所番号を返す() {
            assertThat(sut.get居宅支援事業所番号(), is(KyufuKanrihyo200604Entity.getKyotakushienJigyoshoNo()));
        }

        @Test
        public void get給付管理票情報作成区分コードは_entityが持つ給付管理票情報作成区分コードを返す() {
            assertThat(sut.get給付管理票情報作成区分コード(), is(KyufuKanrihyo200604Entity.getKyufuSakuseiKubunCode()));
        }

        @Test
        public void get給付管理票作成年月日は_entityが持つ給付管理票作成年月日を返す() {
            assertThat(sut.get給付管理票作成年月日(), is(KyufuKanrihyo200604Entity.getKyufuSakuseiYMD()));
        }

        @Test
        public void get給付管理票種別区分コードは_entityが持つ給付管理票種別区分コードを返す() {
            assertThat(sut.get給付管理票種別区分コード(), is(KyufuKanrihyo200604Entity.getKyufuShubetsuKubunCode()));
        }

        @Test
        public void get給付管理票明細行番号は_entityが持つ給付管理票明細行番号を返す() {
            assertThat(sut.get給付管理票明細行番号(), is(KyufuKanrihyo200604Entity.getKyufuMeisaiLineNo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KyufuKanrihyo200604Entity.getHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuKanrihyo200604Entity.getHiHokenshaNo()));
        }

        @Test
        public void get被保険者生年月日は_entityが持つ被保険者生年月日を返す() {
            assertThat(sut.get被保険者生年月日(), is(KyufuKanrihyo200604Entity.getHiHokenshaUmareYMD()));
        }

        @Test
        public void get性別コードは_entityが持つ性別コードを返す() {
            assertThat(sut.get性別コード(), is(KyufuKanrihyo200604Entity.getSeibetsuCode()));
        }

        @Test
        public void get要介護状態区分コードは_entityが持つ要介護状態区分コードを返す() {
            assertThat(sut.get要介護状態区分コード(), is(KyufuKanrihyo200604Entity.getYoKaigoJotaiKubunCode()));
        }

        @Test
        public void get限度額適用開始年月は_entityが持つ限度額適用開始年月を返す() {
            assertThat(sut.get限度額適用開始年月(), is(KyufuKanrihyo200604Entity.getGendogakuTekiyoKaishiYM()));
        }

        @Test
        public void get限度額適用終了年月は_entityが持つ限度額適用終了年月を返す() {
            assertThat(sut.get限度額適用終了年月(), is(KyufuKanrihyo200604Entity.getGendogakuTekiyoShuryoYM()));
        }

        @Test
        public void get居宅・介護予防支給限度額は_entityが持つ居宅・介護予防支給限度額を返す() {
            assertThat(sut.get居宅・介護予防支給限度額(), is(KyufuKanrihyo200604Entity.getKyotakuKaigoYoboShikyuGendogaku()));
        }

        @Test
        public void get居宅サービス計画作成区分コードは_entityが持つ居宅サービス計画作成区分コードを返す() {
            assertThat(sut.get居宅サービス計画作成区分コード(), is(KyufuKanrihyo200604Entity.getKyotakuServicePlanSakuseiKubunCode()));
        }

        @Test
        public void getサービス事業所番号は_entityが持つサービス事業所番号を返す() {
            assertThat(sut.getサービス事業所番号(), is(KyufuKanrihyo200604Entity.getServiceJigyoshoNo()));
        }

        @Test
        public void get指定/基準該当/地域密着型サービス識別コードは_entityが持つ指定/基準該当/地域密着型サービス識別コードを返す() {
            assertThat(sut.get指定/基準該当/地域密着型サービス識別コード(), is(KyufuKanrihyo200604Entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufuKanrihyo200604Entity.getServiceShuruiCode()));
        }

        @Test
        public void get給付計画単位数／日数は_entityが持つ給付計画単位数／日数を返す() {
            assertThat(sut.get給付計画単位数／日数(), is(KyufuKanrihyo200604Entity.getKyufuKeikakuTanisuNissu()));
        }

        @Test
        public void get限度額管理期間における前月までの給付計画日数は_entityが持つ限度額管理期間における前月までの給付計画日数を返す() {
            assertThat(sut.get限度額管理期間における前月までの給付計画日数(), is(KyufuKanrihyo200604Entity.getKyufuKeikakuNissu()));
        }

        @Test
        public void get指定サービス分小計は_entityが持つ指定サービス分小計を返す() {
            assertThat(sut.get指定サービス分小計(), is(KyufuKanrihyo200604Entity.getShiteiServiceSubTotal()));
        }

        @Test
        public void get基準該当サービス分小計は_entityが持つ基準該当サービス分小計を返す() {
            assertThat(sut.get基準該当サービス分小計(), is(KyufuKanrihyo200604Entity.getKijyunGaitoServiceSubTotal()));
        }

        @Test
        public void get給付計画合計単位数/日数は_entityが持つ給付計画合計単位数/日数を返す() {
            assertThat(sut.get給付計画合計単位数/日数(), is(KyufuKanrihyo200604Entity.getKyufuKeikakuTotalTanisuNissu()));
        }

        @Test
        public void get担当介護支援専門員番号は_entityが持つ担当介護支援専門員番号を返す() {
            assertThat(sut.get担当介護支援専門員番号(), is(KyufuKanrihyo200604Entity.getTantoKaigoShienSemmoninNo()));
        }

        @Test
        public void get委託先の居宅介護支援事業所番号は_entityが持つ委託先の居宅介護支援事業所番号を返す() {
            assertThat(sut.get委託先の居宅介護支援事業所番号(), is(KyufuKanrihyo200604Entity.getKaigoShienJigyoshaNo()));
        }

        @Test
        public void get委託先の担当介護支援専門員番号は_entityが持つ委託先の担当介護支援専門員番号を返す() {
            assertThat(sut.get委託先の担当介護支援専門員番号(), is(KyufuKanrihyo200604Entity.getItakusakiTantoKaigoShienSemmoninNo()));
        }

        @Test
        public void get当初登録年月日は_entityが持つ当初登録年月日を返す() {
            assertThat(sut.get当初登録年月日(), is(KyufuKanrihyo200604Entity.getToshoTorokuYMD()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufuKanrihyo200604Entity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuKanrihyo200604Entity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuKanrihyo200604 sut;
        private static KyufuKanrihyo200604 result;

        @Before
        public void setUp() {
            KyufuKanrihyo200604Entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            KyufuKanrihyo200604Entity.setXXX(主キー名1);
            KyufuKanrihyo200604Entity.setXXX(主キー名2);

        }

        @Test
        public void KyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200604が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200604(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200604が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200604(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200604が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200604(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuKanrihyo200604が保持するDbT3015KyufuKanrihyo200604EntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuKanrihyo200604(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuKanrihyo200604 setStateKyufuKanrihyo200604(EntityDataState parentState) {
            KyufuKanrihyo200604Entity.setState(parentState);
            return new KyufuKanrihyo200604(KyufuKanrihyo200604Entity);
        }
    }
}
