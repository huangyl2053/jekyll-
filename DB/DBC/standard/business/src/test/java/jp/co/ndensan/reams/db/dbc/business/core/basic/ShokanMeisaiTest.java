/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3039ShokanMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanMeisaiTest extends DbcTestBase {

    private static DbT3039ShokanMeisaiEntity ShokanMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanMeisai sut;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanMeisai(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanMeisai(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3039ShokanMeisaiEntityにセットされている() {
            sut = new ShokanMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanMeisaiIdentifierにセットされている() {
            sut = new ShokanMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanMeisai sut;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanMeisai(null);
        }

        @Test
        public void 指定したDbT3039ShokanMeisaiEntityのキー情報を識別子が持つ() {

            sut = new ShokanMeisai(ShokanMeisaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanMeisai sut;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisai(ShokanMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanMeisaiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanMeisaiEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanMeisaiEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanMeisaiEntity.getYoshikiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(ShokanMeisaiEntity.getMeisaiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShokanMeisaiEntity.getRenban()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(ShokanMeisaiEntity.getServiceKomokuCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ShokanMeisaiEntity.getTanisu()));
        }

        @Test
        public void get日数_回数は_entityが持つ日数_回数を返す() {
            assertThat(sut.get日数_回数(), is(ShokanMeisaiEntity.getNissuKaisu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(ShokanMeisaiEntity.getServiceTanisu()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(ShokanMeisaiEntity.getTekiyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanMeisai sut;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisai(ShokanMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanMeisai sut;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisai(ShokanMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanMeisai sut;
        private static ShokanMeisai result;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiが返る() {
            sut = TestSupport.setStateShokanMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiが返る() {
            sut = TestSupport.setStateShokanMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiが返る() {
            sut = TestSupport.setStateShokanMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanMeisaiが保持するDbT3039ShokanMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanMeisai setStateShokanMeisai(EntityDataState parentState) {
            ShokanMeisaiEntity.setState(parentState);
            return new ShokanMeisai(ShokanMeisaiEntity);
        }
    }
}
