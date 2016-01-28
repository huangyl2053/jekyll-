/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3043ShokanShokujiHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link ShokanShokujiHiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanShokujiHiyoTest extends DbcTestBase {

    private static DbT3043ShokanShokujiHiyoEntity ShokanShokujiHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShokujiHiyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShokujiHiyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3043ShokanShokujiHiyoEntityにセットされている() {
            sut = new ShokanShokujiHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShokujiHiyoIdentifierにセットされている() {
            sut = new ShokanShokujiHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShokujiHiyo(null);
        }

        @Test
        public void 指定したDbT3043ShokanShokujiHiyoEntityのキー情報を識別子が持つ() {

            sut = new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanShokujiHiyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanShokujiHiyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanShokujiHiyoEntity.getSeiriNp()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanShokujiHiyoEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanShokujiHiyoEntity.getYoshikiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanShokujiHiyoEntity.getRirekiNo()));
        }

        @Test
        public void get基本提供日数は_entityが持つ基本提供日数を返す() {
            assertThat(sut.get基本提供日数(), is(ShokanShokujiHiyoEntity.getKihonTeikyoNissu()));
        }

        @Test
        public void get基本提供単価は_entityが持つ基本提供単価を返す() {
            assertThat(sut.get基本提供単価(), is(ShokanShokujiHiyoEntity.getKihonTeikyoTanka()));
        }

        @Test
        public void get基本提供金額は_entityが持つ基本提供金額を返す() {
            assertThat(sut.get基本提供金額(), is(ShokanShokujiHiyoEntity.getKihonTeikyoKingaku()));
        }

        @Test
        public void get特別提供日数は_entityが持つ特別提供日数を返す() {
            assertThat(sut.get特別提供日数(), is(ShokanShokujiHiyoEntity.getTokubetsuTeikyoNissu()));
        }

        @Test
        public void get特別提供単価は_entityが持つ特別提供単価を返す() {
            assertThat(sut.get特別提供単価(), is(ShokanShokujiHiyoEntity.getTokubetsuTeikyoTanka()));
        }

        @Test
        public void get特別提供金額は_entityが持つ特別提供金額を返す() {
            assertThat(sut.get特別提供金額(), is(ShokanShokujiHiyoEntity.getTokubetsuTeikyoKingaku()));
        }

        @Test
        public void get食事提供延べ日数は_entityが持つ食事提供延べ日数を返す() {
            assertThat(sut.get食事提供延べ日数(), is(ShokanShokujiHiyoEntity.getShokujiTeikyoTotalNissu()));
        }

        @Test
        public void get食事提供費合計は_entityが持つ食事提供費合計を返す() {
            assertThat(sut.get食事提供費合計(), is(ShokanShokujiHiyoEntity.getShokujiTeikyohiTotal()));
        }

        @Test
        public void get標準負担額_月額は_entityが持つ標準負担額_月額_を返す() {
            assertThat(sut.get標準負担額_月額(), is(ShokanShokujiHiyoEntity.getGetsugakuHyojunFutangaku()));
        }

        @Test
        public void get食事提供費請求額は_entityが持つ食事提供費請求額を返す() {
            assertThat(sut.get食事提供費請求額(), is(ShokanShokujiHiyoEntity.getShokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get標準負担額_日額は_entityが持つ標準負担額_日額を返す() {
            assertThat(sut.get標準負担額_日額(), is(ShokanShokujiHiyoEntity.getNichigakuHyojunFutangaku()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanShokujiHiyoEntity.getShikyuKubunCode()));
        }

        @Test
        public void get点数_金額は_entityが持つ点数_金額を返す() {
            assertThat(sut.get点数_金額(), is(ShokanShokujiHiyoEntity.getTensuKingaku()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(ShokanShokujiHiyoEntity.getShikyuKingaku()));
        }

        @Test
        public void get増減点は_entityが持つ増減点を返す() {
            assertThat(sut.get増減点(), is(ShokanShokujiHiyoEntity.getZougenTen()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShokujiHiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShokujiHiyo sut;
        private static ShokanShokujiHiyo result;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoが返る() {
            sut = TestSupport.setStateShokanShokujiHiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoが返る() {
            sut = TestSupport.setStateShokanShokujiHiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがDeletedに指定されたShokanShokujiHiyoが返る() {
            sut = TestSupport.setStateShokanShokujiHiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShokujiHiyoが保持するDbT3043ShokanShokujiHiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShokujiHiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShokujiHiyo setStateShokanShokujiHiyo(EntityDataState parentState) {
            ShokanShokujiHiyoEntity.setState(parentState);
            return new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);
        }
    }
}
