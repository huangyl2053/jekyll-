/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3037ShokanJuryoininMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3037ShokanJuryoininMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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

/**
 * {@link ShokanJuryoininMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininMeisaiTest extends DbcTestBase {

    private static DbT3037ShokanJuryoininMeisaiEntity ShokanJuryoininMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininMeisai(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanJuryoininMeisai(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3037ShokanJuryoininMeisaiEntityにセットされている() {
            sut = new ShokanJuryoininMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanJuryoininMeisaiIdentifierにセットされている() {
            sut = new ShokanJuryoininMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanJuryoininMeisai(null);
        }

        @Test
        public void 指定したDbT3037ShokanJuryoininMeisaiEntityのキー情報を識別子が持つ() {

            sut = new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanJuryoininMeisaiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanJuryoininMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanJuryoininMeisaiEntity.getSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanJuryoininMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get契約番号は_entityが持つ契約番号を返す() {
            assertThat(sut.get契約番号(), is(ShokanJuryoininMeisaiEntity.getKeiyakuNo()));
        }

        @Test
        public void get支払金額は_entityが持つ支払金額を返す() {
            assertThat(sut.get支払金額(), is(ShokanJuryoininMeisaiEntity.getShiharaiKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanJuryoininMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanJuryoininMeisai sut;
        private static ShokanJuryoininMeisai result;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = DbT3037ShokanJuryoininMeisaiEntityGenerator.createDbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanJuryoininMeisaiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがDeletedに指定されたShokanJuryoininMeisaiが返る() {
            sut = TestSupport.setStateShokanJuryoininMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがDeletedに指定されたShokanJuryoininMeisaiが返る() {
            sut = TestSupport.setStateShokanJuryoininMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがDeletedに指定されたShokanJuryoininMeisaiが返る() {
            sut = TestSupport.setStateShokanJuryoininMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanJuryoininMeisaiが保持するDbT3037ShokanJuryoininMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanJuryoininMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanJuryoininMeisai setStateShokanJuryoininMeisai(EntityDataState parentState) {
            ShokanJuryoininMeisaiEntity.setState(parentState);
            return new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);
        }
    }
}
