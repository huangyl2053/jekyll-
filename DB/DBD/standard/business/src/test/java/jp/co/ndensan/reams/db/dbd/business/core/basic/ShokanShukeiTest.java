/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3053ShokanShukeiEntityGenerator;
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
 * {@link ShokanShukei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanShukeiTest extends DbcTestBase {

    private static DbT3053ShokanShukeiEntity ShokanShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShukei sut;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShukei(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShukei(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3053ShokanShukeiEntityにセットされている() {
            sut = new ShokanShukei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShukeiIdentifierにセットされている() {
            sut = new ShokanShukei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShukei sut;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShukei(null);
        }

        @Test
        public void 指定したDbT3053ShokanShukeiEntityのキー情報を識別子が持つ() {

            sut = new ShokanShukei(ShokanShukeiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShukei sut;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShukei(ShokanShukeiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanShukeiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanShukeiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanShukeiEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanShukeiEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanShukeiEntity.getYoshikiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(ShokanShukeiEntity.getMeisaiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShokanShukeiEntity.getRenban()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanShukeiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス実日数は_entityが持つサービス実日数を返す() {
            assertThat(sut.getサービス実日数(), is(ShokanShukeiEntity.getServiceJitsunissu()));
        }

        @Test
        public void get計画単位数は_entityが持つ計画単位数を返す() {
            assertThat(sut.get計画単位数(), is(ShokanShukeiEntity.getPlanTanisu()));
        }

        @Test
        public void get限度額管理対象単位数は_entityが持つ限度額管理対象単位数を返す() {
            assertThat(sut.get限度額管理対象単位数(), is(ShokanShukeiEntity.getGendogakuKanriTaishoTanisu()));
        }

        @Test
        public void get限度額管理対象外単位数は_entityが持つ限度額管理対象外単位数を返す() {
            assertThat(sut.get限度額管理対象外単位数(), is(ShokanShukeiEntity.getGendogakuKanriTaishogaiTanisu()));
        }

        @Test
        public void get短期入所計画日数は_entityが持つ短期入所計画日数を返す() {
            assertThat(sut.get短期入所計画日数(), is(ShokanShukeiEntity.getTankiNyushoPlanNissu()));
        }

        @Test
        public void get短期入所実日数は_entityが持つ短期入所実日数を返す() {
            assertThat(sut.get短期入所実日数(), is(ShokanShukeiEntity.getTankiNyushoJitsunissu()));
        }

        @Test
        public void get単位数合計は_entityが持つ単位数合計を返す() {
            assertThat(sut.get単位数合計(), is(ShokanShukeiEntity.getTanisuTotal()));
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(ShokanShukeiEntity.getTanisuTanka()));
        }

        @Test
        public void get請求額は_entityが持つ請求額を返す() {
            assertThat(sut.get請求額(), is(ShokanShukeiEntity.getSeikyugaku()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(ShokanShukeiEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get出来高医療費単位数合計は_entityが持つ出来高医療費単位数合計を返す() {
            assertThat(sut.get出来高医療費単位数合計(), is(ShokanShukeiEntity.getDekidakaIryohiTanisuTotal()));
        }

        @Test
        public void get出来高医療費請求額は_entityが持つ出来高医療費請求額を返す() {
            assertThat(sut.get出来高医療費請求額(), is(ShokanShukeiEntity.getDekidakaIryohiSeikyugaku()));
        }

        @Test
        public void get出来高医療費利用者負担額は_entityが持つ出来高医療費利用者負担額を返す() {
            assertThat(sut.get出来高医療費利用者負担額(), is(ShokanShukeiEntity.getDekidakaIryohiRiyoshaFutangaku()));
        }

        @Test
        public void get審査方法区分コードは_entityが持つ審査方法区分コードを返す() {
            assertThat(sut.get審査方法区分コード(), is(ShokanShukeiEntity.getShinsaHohoKubunCode()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(ShokanShukeiEntity.getShinsaYM()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(ShokanShukeiEntity.getShikyuKubunCode()));
        }

        @Test
        public void get点数_金額は_entityが持つ点数_金額を返す() {
            assertThat(sut.get点数_金額(), is(ShokanShukeiEntity.getTensuKingaku()));
        }

        @Test
        public void get支払金額は_entityが持つ支払金額を返す() {
            assertThat(sut.get支払金額(), is(ShokanShukeiEntity.getShikyuKingaku()));
        }

        @Test
        public void get増減点は_entityが持つ増減点を返す() {
            assertThat(sut.get増減点(), is(ShokanShukeiEntity.getZougenten()));
        }

        @Test
        public void get請求額差額金額は_entityが持つ請求額差額金額を返す() {
            assertThat(sut.get請求額差額金額(), is(ShokanShukeiEntity.getSeikyugakuSagakuKingaku()));
        }

        @Test
        public void get出来高請求額差額金額は_entityが持つ出来高請求額差額金額を返す() {
            assertThat(sut.get出来高請求額差額金額(), is(ShokanShukeiEntity.getDekidakaSeikyugakuSagaku()));
        }

        @Test
        public void get増減理由等は_entityが持つ増減理由等を返す() {
            assertThat(sut.get増減理由等(), is(ShokanShukeiEntity.getZougenRiyu()));
        }

        @Test
        public void get不支給理由等は_entityが持つ不支給理由等を返す() {
            assertThat(sut.get不支給理由等(), is(ShokanShukeiEntity.getHushikyuRiyu()));
        }

        @Test
        public void get購入_改修履歴等は_entityが持つ購入_改修履歴等を返す() {
            assertThat(sut.get購入_改修履歴等(), is(ShokanShukeiEntity.getKounyuKaishuRireki()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShukei sut;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShukei(ShokanShukeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShukeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShukei sut;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanShukei(ShokanShukeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShukei sut;
        private static ShokanShukei result;

        @Before
        public void setUp() {
            ShokanShukeiEntity = DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがDeletedに指定されたShokanShukeiが返る() {
            sut = TestSupport.setStateShokanShukei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがDeletedに指定されたShokanShukeiが返る() {
            sut = TestSupport.setStateShokanShukei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがDeletedに指定されたShokanShukeiが返る() {
            sut = TestSupport.setStateShokanShukei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShukeiが保持するDbT3053ShokanShukeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShukei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShukei setStateShokanShukei(EntityDataState parentState) {
            ShokanShukeiEntity.setState(parentState);
            return new ShokanShukei(ShokanShukeiEntity);
        }
    }
}
