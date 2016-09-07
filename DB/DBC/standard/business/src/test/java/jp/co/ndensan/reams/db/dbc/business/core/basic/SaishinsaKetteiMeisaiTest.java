/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3064SaishinsaKetteiMeisaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link SaishinsaKetteiMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SaishinsaKetteiMeisaiTest extends DbcTestBase {

    private static DbT3064SaishinsaKetteiMeisaiEntity SaishinsaKetteiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3064SaishinsaKetteiMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaKetteiMeisai(null, 主キー名2, new Decimal(主キー名3));
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaKetteiMeisai(主キー名1, null, new Decimal(主キー名3));
        }

        @Test
        public void 指定したキーが保持するDbT3064SaishinsaKetteiMeisaiEntityにセットされている() {
            sut = new SaishinsaKetteiMeisai(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.get取扱年月(), is(主キー名1));
            assertThat(sut.get保険者区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSaishinsaKetteiMeisaiIdentifierにセットされている() {
            sut = new SaishinsaKetteiMeisai(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SaishinsaKetteiMeisai(null);
        }

        @Test
        public void 指定したDbT3064SaishinsaKetteiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new SaishinsaKetteiMeisai(SaishinsaKetteiMeisaiEntity);

            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiMeisai(SaishinsaKetteiMeisaiEntity);
        }

        @Test
        public void get取扱年月は_entityが持つ取扱年月を返す() {
            assertThat(sut.get取扱年月(), is(SaishinsaKetteiMeisaiEntity.getToriatsukaiYM()));
        }

        @Test
        public void get保険者区分は_entityが持つ保険者区分を返す() {
            assertThat(sut.get保険者区分(), is(SaishinsaKetteiMeisaiEntity.getHokenshaKubun()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(new Decimal(SaishinsaKetteiMeisaiEntity.getRirekiNo())));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(SaishinsaKetteiMeisaiEntity.getJigyoshoNo()));
        }

        @Test
        public void get事業所名は_entityが持つ事業所名を返す() {
            assertThat(sut.get事業所名(), is(SaishinsaKetteiMeisaiEntity.getJigyoshoName()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(SaishinsaKetteiMeisaiEntity.getHiHokenshaNo()));
        }

        @Test
        public void get公費受給者番号は_entityが持つ公費受給者番号を返す() {
            assertThat(sut.get公費受給者番号(), is(SaishinsaKetteiMeisaiEntity.getKohiJukyushaNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(SaishinsaKetteiMeisaiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(SaishinsaKetteiMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(SaishinsaKetteiMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス種類名は_entityが持つサービス種類名を返す() {
            assertThat(sut.getサービス種類名(), is(SaishinsaKetteiMeisaiEntity.getServiceShuruiName()));
        }

        @Test
        public void get申立事由コードは_entityが持つ申立事由コードを返す() {
            assertThat(sut.get申立事由コード(), is(SaishinsaKetteiMeisaiEntity.getMoushitateJiyuCode()));
        }

        @Test
        public void get申立事由は_entityが持つ申立事由を返す() {
            assertThat(sut.get申立事由(), is(SaishinsaKetteiMeisaiEntity.getMoushitateJiyu()));
        }

        @Test
        public void get再審査結果コードは_entityが持つ再審査結果コードを返す() {
            assertThat(sut.get再審査結果コード(), is(SaishinsaKetteiMeisaiEntity.getSaishinsaResultCode()));
        }

        @Test
        public void get当初請求単位数は_entityが持つ当初請求単位数を返す() {
            assertThat(sut.get当初請求単位数(), is(SaishinsaKetteiMeisaiEntity.getToshoSeikyuTanisu()));
        }

        @Test
        public void get原審単位数は_entityが持つ原審単位数を返す() {
            assertThat(sut.get原審単位数(), is(SaishinsaKetteiMeisaiEntity.getGenshinSeikyuTanisu()));
        }

        @Test
        public void get申立単位数は_entityが持つ申立単位数を返す() {
            assertThat(sut.get申立単位数(), is(SaishinsaKetteiMeisaiEntity.getMoushitateTanisu()));
        }

        @Test
        public void get決定単位数は_entityが持つ決定単位数を返す() {
            assertThat(sut.get決定単位数(), is(SaishinsaKetteiMeisaiEntity.getKetteiTanisu()));
        }

        @Test
        public void get調整単位数は_entityが持つ調整単位数を返す() {
            assertThat(sut.get調整単位数(), is(SaishinsaKetteiMeisaiEntity.getChoseiTanisu()));
        }

        @Test
        public void get保険者負担額は_entityが持つ保険者負担額を返す() {
            assertThat(sut.get保険者負担額(), is(SaishinsaKetteiMeisaiEntity.getHokenshaFutangaku()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(SaishinsaKetteiMeisaiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiMeisai(SaishinsaKetteiMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SaishinsaKetteiMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new SaishinsaKetteiMeisai(SaishinsaKetteiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SaishinsaKetteiMeisai sut;
        private static SaishinsaKetteiMeisai result;

        @Before
        public void setUp() {
            SaishinsaKetteiMeisaiEntity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            SaishinsaKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

        }

        @Test
        public void SaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiMeisaiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiMeisaiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたSaishinsaKetteiMeisaiが返る() {
            sut = TestSupport.setStateSaishinsaKetteiMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SaishinsaKetteiMeisaiが保持するDbT3064SaishinsaKetteiMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSaishinsaKetteiMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SaishinsaKetteiMeisai setStateSaishinsaKetteiMeisai(EntityDataState parentState) {
            SaishinsaKetteiMeisaiEntity.setState(parentState);
            return new SaishinsaKetteiMeisai(SaishinsaKetteiMeisaiEntity);
        }
    }
}
