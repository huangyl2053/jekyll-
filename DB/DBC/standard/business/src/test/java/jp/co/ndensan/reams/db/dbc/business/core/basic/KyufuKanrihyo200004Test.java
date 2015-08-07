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
 * {@link KyufuKanrihyo200004}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200004Test extends DbcTestBase {

    private static DbT3014KyufuKanrihyo200004Entity KyufuKanrihyo200004Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200004(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200004(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3014KyufuKanrihyo200004Entityにセットされている() {
            sut = new KyufuKanrihyo200004(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuKanrihyo200004Identifierにセットされている() {
            sut = new KyufuKanrihyo200004(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuKanrihyo200004(null);
        }

        @Test
        public void 指定したDbT3014KyufuKanrihyo200004Entityのキー情報を識別子が持つ() {

            sut = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufuKanrihyo200004Entity.getShinsaYM()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufuKanrihyo200004Entity.getServiceTeikyoYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufuKanrihyo200004Entity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get居宅支援事業所番号は_entityが持つ居宅支援事業所番号を返す() {
            assertThat(sut.get居宅支援事業所番号(), is(KyufuKanrihyo200004Entity.getKyotakushienJigyoshoNo()));
        }

        @Test
        public void get給付管理票情報作成区分コードは_entityが持つ給付管理票情報作成区分コードを返す() {
            assertThat(sut.get給付管理票情報作成区分コード(), is(KyufuKanrihyo200004Entity.getKyufuKanrihyoSakuseiKubunCode()));
        }

        @Test
        public void get給付管理票作成年月日は_entityが持つ給付管理票作成年月日を返す() {
            assertThat(sut.get給付管理票作成年月日(), is(KyufuKanrihyo200004Entity.getKyufuKanrihyoSakuseiYMD()));
        }

        @Test
        public void get給付管理票種別区分コードは_entityが持つ給付管理票種別区分コードを返す() {
            assertThat(sut.get給付管理票種別区分コード(), is(KyufuKanrihyo200004Entity.getKyufuKanrihyoShubetsuKubunCode()));
        }

        @Test
        public void get給付管理票明細行番号は_entityが持つ給付管理票明細行番号を返す() {
            assertThat(sut.get給付管理票明細行番号(), is(KyufuKanrihyo200004Entity.getKyufuKanrihyoMeisaiLineNo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KyufuKanrihyo200004Entity.getHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuKanrihyo200004Entity.getHiHokenshaNo()));
        }

        @Test
        public void get被保険者生年月日は_entityが持つ被保険者生年月日を返す() {
            assertThat(sut.get被保険者生年月日(), is(KyufuKanrihyo200004Entity.getHiHokenshaUmareYMD()));
        }

        @Test
        public void get性別コードは_entityが持つ性別コードを返す() {
            assertThat(sut.get性別コード(), is(KyufuKanrihyo200004Entity.getSeibetsuCode()));
        }

        @Test
        public void get要介護状態区分コードは_entityが持つ要介護状態区分コードを返す() {
            assertThat(sut.get要介護状態区分コード(), is(KyufuKanrihyo200004Entity.getYoKaigoJotaiKubunCode()));
        }

        @Test
        public void get限度額適用期間は_entityが持つ限度額適用期間を返す() {
            assertThat(sut.get限度額適用期間(), is(KyufuKanrihyo200004Entity.getGendogakuTekiyoKaishiYM()));
        }

        @Test
        public void get限度額適用期間は_entityが持つ限度額適用期間を返す() {
            assertThat(sut.get限度額適用期間(), is(KyufuKanrihyo200004Entity.getGendogakuTekiyoShuryoYM()));
        }

        @Test
        public void get居宅・介護予防支給限度額は_entityが持つ居宅・介護予防支給限度額を返す() {
            assertThat(sut.get居宅・介護予防支給限度額(), is(KyufuKanrihyo200004Entity.getKyotakuKaigoYoboShikyuGendogaku()));
        }

        @Test
        public void get居宅サービス計画作成区分コードは_entityが持つ居宅サービス計画作成区分コードを返す() {
            assertThat(sut.get居宅サービス計画作成区分コード(), is(KyufuKanrihyo200004Entity.getKyotakuServicePlanSakuseiKubunCode()));
        }

        @Test
        public void getサービス事業所番号は_entityが持つサービス事業所番号を返す() {
            assertThat(sut.getサービス事業所番号(), is(KyufuKanrihyo200004Entity.getServiceJigyoshoNo()));
        }

        @Test
        public void get指定/基準該当/地域密着型サービス識別コードは_entityが持つ指定/基準該当/地域密着型サービス識別コードを返す() {
            assertThat(sut.get指定/基準該当/地域密着型サービス識別コード(), is(KyufuKanrihyo200004Entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufuKanrihyo200004Entity.getServiceShuruiCode()));
        }

        @Test
        public void get給付計画単位数／日数は_entityが持つ給付計画単位数／日数を返す() {
            assertThat(sut.get給付計画単位数／日数(), is(KyufuKanrihyo200004Entity.getKyufuKeikakuTanisuNissu()));
        }

        @Test
        public void get限度額管理期間における前月までの給付計画日数は_entityが持つ限度額管理期間における前月までの給付計画日数を返す() {
            assertThat(sut.get限度額管理期間における前月までの給付計画日数(), is(KyufuKanrihyo200004Entity.getKyufuKeikakuNissu()));
        }

        @Test
        public void get指定サービス分小計は_entityが持つ指定サービス分小計を返す() {
            assertThat(sut.get指定サービス分小計(), is(KyufuKanrihyo200004Entity.getShiteiServiceSubTotal()));
        }

        @Test
        public void get基準該当サービス分小計は_entityが持つ基準該当サービス分小計を返す() {
            assertThat(sut.get基準該当サービス分小計(), is(KyufuKanrihyo200004Entity.getKijyunGaitoServiceSubTotal()));
        }

        @Test
        public void get給付計画合計単位数/日数は_entityが持つ給付計画合計単位数/日数を返す() {
            assertThat(sut.get給付計画合計単位数/日数(), is(KyufuKanrihyo200004Entity.getKyufuKeikakuTotalTanisuNissu()));
        }

        @Test
        public void get当初登録年月日は_entityが持つ当初登録年月日を返す() {
            assertThat(sut.get当初登録年月日(), is(KyufuKanrihyo200004Entity.getToshoTorokuYMD()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufuKanrihyo200004Entity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuKanrihyo200004Entity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);

            sut = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;
        private static KyufuKanrihyo200004 result;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setXXX(主キー名1);
            KyufuKanrihyo200004Entity.setXXX(主キー名2);

        }

        @Test
        public void KyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200004が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200004(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200004が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200004(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがDeletedに指定されたKyufuKanrihyo200004が返る() {
            sut = TestSupport.setStateKyufuKanrihyo200004(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuKanrihyo200004が保持するDbT3014KyufuKanrihyo200004EntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuKanrihyo200004(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuKanrihyo200004 setStateKyufuKanrihyo200004(EntityDataState parentState) {
            KyufuKanrihyo200004Entity.setState(parentState);
            return new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);
        }
    }
}
