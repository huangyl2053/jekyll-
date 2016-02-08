/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3107ShokanMeisaiJushochiTokureiEntityGenerator;
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
 * {@link ShokanMeisaiJushochiTokurei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanMeisaiJushochiTokureiTest extends DbcTestBase {

    private static DbT3107ShokanMeisaiJushochiTokureiEntity ShokanMeisaiJushochiTokureiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static Decimal 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_様式番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanMeisaiJushochiTokurei(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanMeisaiJushochiTokurei(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3107ShokanMeisaiJushochiTokureiEntityにセットされている() {
            sut = new ShokanMeisaiJushochiTokurei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanMeisaiJushochiTokureiIdentifierにセットされている() {
            sut = new ShokanMeisaiJushochiTokurei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanMeisaiJushochiTokurei(null);
        }

        @Test
        public void 指定したDbT3107ShokanMeisaiJushochiTokureiEntityのキー情報を識別子が持つ() {

            sut = new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanMeisaiJushochiTokureiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanMeisaiJushochiTokureiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanMeisaiJushochiTokureiEntity.getSeiriNp()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanMeisaiJushochiTokureiEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanMeisaiJushochiTokureiEntity.getYoshikiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanMeisaiJushochiTokureiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(ShokanMeisaiJushochiTokureiEntity.getServiceKomokuCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ShokanMeisaiJushochiTokureiEntity.getTanisu()));
        }

        @Test
        public void get日数_回数は_entityが持つ日数_回数を返す() {
            assertThat(sut.get日数_回数(), is(ShokanMeisaiJushochiTokureiEntity.getNissuKaisu()));
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(ShokanMeisaiJushochiTokureiEntity.getServiceTanisu()));
        }

        @Test
        public void get施設所在保険者番号は_entityが持つ施設所在保険者番号を返す() {
            assertThat(sut.get施設所在保険者番号(), is(ShokanMeisaiJushochiTokureiEntity.getShisetsuShozaiHokenshaNo()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(ShokanMeisaiJushochiTokureiEntity.getTekiyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanMeisaiJushochiTokureiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanMeisaiJushochiTokurei sut;
        private static ShokanMeisaiJushochiTokurei result;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.createDbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiJushochiTokureiが返る() {
            sut = TestSupport.setStateShokanMeisaiJushochiTokurei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiJushochiTokureiが返る() {
            sut = TestSupport.setStateShokanMeisaiJushochiTokurei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがDeletedに指定されたShokanMeisaiJushochiTokureiが返る() {
            sut = TestSupport.setStateShokanMeisaiJushochiTokurei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanMeisaiJushochiTokureiが保持するDbT3107ShokanMeisaiJushochiTokureiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanMeisaiJushochiTokurei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanMeisaiJushochiTokurei setStateShokanMeisaiJushochiTokurei(EntityDataState parentState) {
            ShokanMeisaiJushochiTokureiEntity.setState(parentState);
            return new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);
        }
    }
}
