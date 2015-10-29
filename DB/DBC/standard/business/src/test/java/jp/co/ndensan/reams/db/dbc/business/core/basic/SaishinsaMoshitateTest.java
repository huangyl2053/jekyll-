/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3062SaishinsaMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
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
 * {@link SaishinsaMoshitate}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SaishinsaMoshitateTest extends DbcTestBase {

    private static DbT3062SaishinsaMoshitateEntity SaishinsaMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static ServiceShuruiCode 主キー名4;
    private static ServiceKomokuCode 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
        主キー名2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
        主キー名4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
        主キー名5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
        主キー名6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaMoshitate(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SaishinsaMoshitate(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3062SaishinsaMoshitateEntityにセットされている() {
            sut = new SaishinsaMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get事業所番号(), is(主キー名1));
            assertThat(sut.get被保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSaishinsaMoshitateIdentifierにセットされている() {
            sut = new SaishinsaMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get事業所番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SaishinsaMoshitate(null);
        }

        @Test
        public void 指定したDbT3062SaishinsaMoshitateEntityのキー情報を識別子が持つ() {

            sut = new SaishinsaMoshitate(SaishinsaMoshitateEntity);

            assertThat(sut.identifier().get事業所番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new SaishinsaMoshitate(SaishinsaMoshitateEntity);
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(SaishinsaMoshitateEntity.getJigyoshoNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(SaishinsaMoshitateEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(SaishinsaMoshitateEntity.getServiceTeikyoYM()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(SaishinsaMoshitateEntity.getServiceTeikyoShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(SaishinsaMoshitateEntity.getServiceKomokuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SaishinsaMoshitateEntity.getRirekiNo()));
        }

        @Test
        public void get申立年月日は_entityが持つ申立年月日を返す() {
            assertThat(sut.get申立年月日(), is(SaishinsaMoshitateEntity.getMoshitateYMD()));
        }

        @Test
        public void get申立者区分コードは_entityが持つ申立者区分コードを返す() {
            assertThat(sut.get申立者区分コード(), is(SaishinsaMoshitateEntity.getMoshitateshaKubunCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(SaishinsaMoshitateEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get申立単位数は_entityが持つ申立単位数を返す() {
            assertThat(sut.get申立単位数(), is(SaishinsaMoshitateEntity.getMoshitateTanisu()));
        }

        @Test
        public void get申立事由コードは_entityが持つ申立事由コードを返す() {
            assertThat(sut.get申立事由コード(), is(SaishinsaMoshitateEntity.getMoshitateJiyuCode()));
        }

        @Test
        public void get国保連送付年月は_entityが持つ国保連送付年月を返す() {
            assertThat(sut.get国保連送付年月(), is(SaishinsaMoshitateEntity.getKokuhorenSofuYM()));
        }

        @Test
        public void get国保連再送付有フラグは_entityが持つ国保連再送付有フラグを返す() {
            assertThat(sut.get国保連再送付有フラグ(), is(SaishinsaMoshitateEntity.getKokuhirenSaiSofuAriFlag()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(SaishinsaMoshitateEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new SaishinsaMoshitate(SaishinsaMoshitateEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SaishinsaMoshitateEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);

            sut = new SaishinsaMoshitate(SaishinsaMoshitateEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SaishinsaMoshitate sut;
        private static SaishinsaMoshitate result;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = DbT3062SaishinsaMoshitateEntityGenerator.createDbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);

        }

        @Test
        public void SaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがDeletedに指定されたSaishinsaMoshitateが返る() {
            sut = TestSupport.setStateSaishinsaMoshitate(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがDeletedに指定されたSaishinsaMoshitateが返る() {
            sut = TestSupport.setStateSaishinsaMoshitate(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがDeletedに指定されたSaishinsaMoshitateが返る() {
            sut = TestSupport.setStateSaishinsaMoshitate(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SaishinsaMoshitateが保持するDbT3062SaishinsaMoshitateEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSaishinsaMoshitate(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SaishinsaMoshitate setStateSaishinsaMoshitate(EntityDataState parentState) {
            SaishinsaMoshitateEntity.setState(parentState);
            return new SaishinsaMoshitate(SaishinsaMoshitateEntity);
        }
    }
}
