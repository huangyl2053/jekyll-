/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link SogoJigyoServiceCode}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoServiceCodeTest extends DbcTestBase {

    private static DbT7122SogoJigyoServiceCodeEntity SogoJigyoServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static ServiceKomokuCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoServiceCode(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoServiceCode(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT7122SogoJigyoServiceCodeEntityにセットされている() {
            sut = new SogoJigyoServiceCode(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.getサービス項目コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSogoJigyoServiceCodeIdentifierにセットされている() {
            sut = new SogoJigyoServiceCode(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SogoJigyoServiceCode(null);
        }

        @Test
        public void 指定したDbT7122SogoJigyoServiceCodeEntityのキー情報を識別子が持つ() {

            sut = new SogoJigyoServiceCode(SogoJigyoServiceCodeEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new SogoJigyoServiceCode(SogoJigyoServiceCodeEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(SogoJigyoServiceCodeEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(SogoJigyoServiceCodeEntity.getServiceKomokuCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(SogoJigyoServiceCodeEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SogoJigyoServiceCodeEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(SogoJigyoServiceCodeEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(SogoJigyoServiceCodeEntity.getServiceMeisho()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(SogoJigyoServiceCodeEntity.getTaniSu()));
        }

        @Test
        public void get限度額対象外フラグは_entityが持つ限度額対象外フラグを返す() {
            assertThat(sut.get限度額対象外フラグ(), is(SogoJigyoServiceCodeEntity.getGendoGakuTaishogaiFlag()));
        }

        @Test
        public void get単位数識別コードは_entityが持つ単位数識別コードを返す() {
            assertThat(sut.get単位数識別コード(), is(SogoJigyoServiceCodeEntity.getTaniSuShikibetsuCode()));
        }

        @Test
        public void get外部サービス利用型区分は_entityが持つ外部サービス利用型区分を返す() {
            assertThat(sut.get外部サービス利用型区分(), is(SogoJigyoServiceCodeEntity.getGaibuServiceRiyoKubun()));
        }

        @Test
        public void get特別地域加算フラグは_entityが持つ特別地域加算フラグを返す() {
            assertThat(sut.get特別地域加算フラグ(), is(SogoJigyoServiceCodeEntity.getTokubetsuChiikiKasanFlag()));
        }

        @Test
        public void get利用者負担定率_定額区分は_entityが持つ利用者負担定率_定額区分を返す() {
            assertThat(sut.get利用者負担定率_定額区分(), is(SogoJigyoServiceCodeEntity.getTeiRitsu_TeiGakuKubun()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(SogoJigyoServiceCodeEntity.getRiyoshaFutanGaku()));
        }

        @Test
        public void get給付率は_entityが持つ給付率を返す() {
            assertThat(sut.get給付率(), is(SogoJigyoServiceCodeEntity.getKyufuRitsu()));
        }

        @Test
        public void get二次予防事業対象者実施区分は_entityが持つ二次予防事業対象者実施区分を返す() {
            assertThat(sut.get二次予防事業対象者実施区分(), is(SogoJigyoServiceCodeEntity.getNijiYoboTaishosha_JissiKubun()));
        }

        @Test
        public void get要支援１受給者実施区分は_entityが持つ要支援１受給者実施区分を返す() {
            assertThat(sut.get要支援１受給者実施区分(), is(SogoJigyoServiceCodeEntity.getYoShien1_JisshiKubun()));
        }

        @Test
        public void get要支援２受給者実施区分は_entityが持つ要支援２受給者実施区分を返す() {
            assertThat(sut.get要支援２受給者実施区分(), is(SogoJigyoServiceCodeEntity.getYoShien2_JisshiKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new SogoJigyoServiceCode(SogoJigyoServiceCodeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SogoJigyoServiceCodeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new SogoJigyoServiceCode(SogoJigyoServiceCodeEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SogoJigyoServiceCode sut;
        private static SogoJigyoServiceCode result;

        @Before
        public void setUp() {
            SogoJigyoServiceCodeEntity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            SogoJigyoServiceCodeEntity.setServiceKomokuCode(主キー名2);

        }

        @Test
        public void SogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがDeletedに指定されたSogoJigyoServiceCodeが返る() {
            sut = TestSupport.setStateSogoJigyoServiceCode(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがDeletedに指定されたSogoJigyoServiceCodeが返る() {
            sut = TestSupport.setStateSogoJigyoServiceCode(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがDeletedに指定されたSogoJigyoServiceCodeが返る() {
            sut = TestSupport.setStateSogoJigyoServiceCode(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SogoJigyoServiceCodeが保持するDbT7122SogoJigyoServiceCodeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSogoJigyoServiceCode(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SogoJigyoServiceCode setStateSogoJigyoServiceCode(EntityDataState parentState) {
            SogoJigyoServiceCodeEntity.setState(parentState);
            return new SogoJigyoServiceCode(SogoJigyoServiceCodeEntity);
        }
    }
}
