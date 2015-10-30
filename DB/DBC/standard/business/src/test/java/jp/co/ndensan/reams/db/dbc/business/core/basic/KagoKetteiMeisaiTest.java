/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator;
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
 * {@link KagoKetteiMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KagoKetteiMeisaiTest extends DbcTestBase {

    private static DbT3061KagoKetteiMeisaiEntity KagoKetteiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoKetteiMeisai(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KagoKetteiMeisai(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3061KagoKetteiMeisaiEntityにセットされている() {
            sut = new KagoKetteiMeisai(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get取扱年月(), is(主キー名1));
            assertThat(sut.get保険者区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKagoKetteiMeisaiIdentifierにセットされている() {
            sut = new KagoKetteiMeisai(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KagoKetteiMeisai(null);
        }

        @Test
        public void 指定したDbT3061KagoKetteiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KagoKetteiMeisai(KagoKetteiMeisaiEntity);

            assertThat(sut.identifier().get取扱年月(), is(主キー名1));
            assertThat(sut.identifier().get保険者区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiMeisai(KagoKetteiMeisaiEntity);
        }

        @Test
        public void get取扱年月は_entityが持つ取扱年月を返す() {
            assertThat(sut.get取扱年月(), is(KagoKetteiMeisaiEntity.getToriatsukaiYM()));
        }

        @Test
        public void get保険者区分は_entityが持つ保険者区分を返す() {
            assertThat(sut.get保険者区分(), is(KagoKetteiMeisaiEntity.getHokenshaKubun()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KagoKetteiMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KagoKetteiMeisaiEntity.getJigyoshoNo()));
        }

        @Test
        public void get事業所名は_entityが持つ事業所名を返す() {
            assertThat(sut.get事業所名(), is(KagoKetteiMeisaiEntity.getJigyoshoName()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KagoKetteiMeisaiEntity.getHiHokenshaNo()));
        }

        @Test
        public void get公費受給者番号は_entityが持つ公費受給者番号を返す() {
            assertThat(sut.get公費受給者番号(), is(KagoKetteiMeisaiEntity.getKohiJukyushaNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KagoKetteiMeisaiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KagoKetteiMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KagoKetteiMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス種類名は_entityが持つサービス種類名を返す() {
            assertThat(sut.getサービス種類名(), is(KagoKetteiMeisaiEntity.getServiceShuruiName()));
        }

        @Test
        public void get過誤申立事由コードは_entityが持つ過誤申立事由コードを返す() {
            assertThat(sut.get過誤申立事由コード(), is(KagoKetteiMeisaiEntity.getKagomoushitateJiyuCode()));
        }

        @Test
        public void get過誤申立事由は_entityが持つ過誤申立事由を返す() {
            assertThat(sut.get過誤申立事由(), is(KagoKetteiMeisaiEntity.getKagomoushitateJiyu()));
        }

        @Test
        public void get単位数_特定入所者介護費等は_entityが持つ単位数_特定入所者介護費等を返す() {
            assertThat(sut.get単位数_特定入所者介護費等(), is(KagoKetteiMeisaiEntity.getTanisu()));
        }

        @Test
        public void get保険者負担額は_entityが持つ保険者負担額を返す() {
            assertThat(sut.get保険者負担額(), is(KagoKetteiMeisaiEntity.getHokenshaFutangaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiMeisai(KagoKetteiMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KagoKetteiMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            sut = new KagoKetteiMeisai(KagoKetteiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KagoKetteiMeisai sut;
        private static KagoKetteiMeisai result;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

        }

        @Test
        public void KagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたKagoKetteiMeisaiが返る() {
            sut = TestSupport.setStateKagoKetteiMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたKagoKetteiMeisaiが返る() {
            sut = TestSupport.setStateKagoKetteiMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがDeletedに指定されたKagoKetteiMeisaiが返る() {
            sut = TestSupport.setStateKagoKetteiMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KagoKetteiMeisaiが保持するDbT3061KagoKetteiMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKagoKetteiMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KagoKetteiMeisai setStateKagoKetteiMeisai(EntityDataState parentState) {
            KagoKetteiMeisaiEntity.setState(parentState);
            return new KagoKetteiMeisai(KagoKetteiMeisaiEntity);
        }
    }
}
