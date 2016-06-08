/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3014KyufuKanrihyo200004EntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link KyufuKanrihyo200004}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufuKanrihyo200004Test extends DbcTestBase {

    private static DbT3014KyufuKanrihyo200004Entity KyufuKanrihyo200004Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static FlexibleDate 主キー名6;
    private static RString 主キー名7;
    private static RString 主キー名8;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
        主キー名2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
        主キー名5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
        主キー名6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
        主キー名7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
        主キー名8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;

    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200004(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuKanrihyo200004(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
        }

        @Test
        public void 指定したキーが保持するDbT3014KyufuKanrihyo200004Entityにセットされている() {
            sut = new KyufuKanrihyo200004(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
            assertThat(sut.get審査年月(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuKanrihyo200004Identifierにセットされている() {
            sut = new KyufuKanrihyo200004(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
            assertThat(sut.identifier().get審査年月(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuKanrihyo200004(null);
        }

        @Test
        public void 指定したDbT3014KyufuKanrihyo200004Entityのキー情報を識別子が持つ() {

            sut = new KyufuKanrihyo200004(KyufuKanrihyo200004Entity);

            assertThat(sut.identifier().get審査年月(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuKanrihyo200004 sut;

        @Before
        public void setUp() {
            KyufuKanrihyo200004Entity = DbT3014KyufuKanrihyo200004EntityGenerator.createDbT3014KyufuKanrihyo200004Entity();
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);

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
        public void get限度額適用期間_開始は_entityが持つ限度額適用期間_開始を返す() {
            assertThat(sut.get限度額適用期間_開始(), is(KyufuKanrihyo200004Entity.getGendogakuTekiyoKaishiYM()));
        }

        @Test
        public void get限度額適用期間は_entityが持つ限度額適用期間を返す() {
            assertThat(sut.get限度額適用期間_終了(), is(KyufuKanrihyo200004Entity.getGendogakuTekiyoShuryoYM()));
        }

        @Test
        public void get居宅_介護予防支給限度額は_entityが持つ居宅_介護予防支給限度額を返す() {
            assertThat(sut.get居宅_介護予防支給限度額(), is(KyufuKanrihyo200004Entity.getKyotakuKaigoYoboShikyuGendogaku()));
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
        public void get指定_基準該当_地域密着型サービス識別コードは_entityが持つ指定_基準該当_地域密着型サービス識別コードを返す() {
            assertThat(sut.get指定_基準該当_地域密着型サービス識別コード(), is(KyufuKanrihyo200004Entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufuKanrihyo200004Entity.getServiceShuruiCode()));
        }

        @Test
        public void get給付計画単位数_日数は_entityが持つ給付計画単位数_日数を返す() {
            assertThat(sut.get給付計画単位数_日数(), is(KyufuKanrihyo200004Entity.getKyufuKeikakuTanisuNissu()));
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
        public void get給付計画合計単位数_日数は_entityが持つ給付計画合計単位数_日数を返す() {
            assertThat(sut.get給付計画合計単位数_日数(), is(KyufuKanrihyo200004Entity.getKyufuKeikakuTotalTanisuNissu()));
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
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);

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
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);

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
            KyufuKanrihyo200004Entity.setShinsaYM(主キー名1);
            KyufuKanrihyo200004Entity.setServiceTeikyoYM(主キー名2);

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
