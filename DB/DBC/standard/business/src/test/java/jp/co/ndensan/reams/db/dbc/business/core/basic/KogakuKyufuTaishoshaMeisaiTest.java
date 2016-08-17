/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link KogakuKyufuTaishoshaMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuKyufuTaishoshaMeisaiTest extends DbcTestBase {

    private static DbT3054KogakuKyufuTaishoshaMeisaiEntity KogakuKyufuTaishoshaMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static JigyoshaNo 主キー名3;
    private static ServiceShuruiCode 主キー名4;
    private static int 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号;
        主キー名4 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        主キー名5 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuKyufuTaishoshaMeisai(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuKyufuTaishoshaMeisai(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityにセットされている() {
            sut = new KogakuKyufuTaishoshaMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuKyufuTaishoshaMeisaiIdentifierにセットされている() {
            sut = new KogakuKyufuTaishoshaMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuKyufuTaishoshaMeisai(null);
        }

        @Test
        public void 指定したDbT3054KogakuKyufuTaishoshaMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuKyufuTaishoshaMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KogakuKyufuTaishoshaMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KogakuKyufuTaishoshaMeisaiEntity.getJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KogakuKyufuTaishoshaMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuKyufuTaishoshaMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void getサービス費用合計額は_entityが持つサービス費用合計額を返す() {
            assertThat(sut.getサービス費用合計額(), is(KogakuKyufuTaishoshaMeisaiEntity.getServiceHiyoGokeiGaku()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KogakuKyufuTaishoshaMeisaiEntity.getRiyoshaFutanGaku()));
        }

        @Test
        public void get高額給付根拠は_entityが持つ高額給付根拠を返す() {
            assertThat(sut.get高額給付根拠(), is(KogakuKyufuTaishoshaMeisaiEntity.getKogakuKyufuKonkyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuKyufuTaishoshaMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuKyufuTaishoshaMeisai sut;
        private static KogakuKyufuTaishoshaMeisai result;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.createDbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void KogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaMeisaiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaMeisaiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuKyufuTaishoshaMeisaiが返る() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuKyufuTaishoshaMeisaiが保持するDbT3054KogakuKyufuTaishoshaMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuKyufuTaishoshaMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuKyufuTaishoshaMeisai setStateKogakuKyufuTaishoshaMeisai(EntityDataState parentState) {
            KogakuKyufuTaishoshaMeisaiEntity.setState(parentState);
            return new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);
        }
    }
}
