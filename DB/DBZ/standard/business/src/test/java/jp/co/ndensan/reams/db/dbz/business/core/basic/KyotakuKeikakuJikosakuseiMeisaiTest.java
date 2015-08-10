/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link KyotakuKeikakuJikosakuseiMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikosakuseiMeisaiTest extends DbzTestBase {

    private static DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity KyotakuKeikakuJikosakuseiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;
    private static RString 居宅サービス区分;
    private static JigyoshaNo サービス提供事業者;
    private static ServiceShuruiCode サービス種類コード;
    private static ServiceKomokuCode サービス項目コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
        居宅サービス区分 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
        サービス提供事業者 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
        サービス種類コード = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(null, 対象年月, 履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, null, 履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, null, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 居宅サービス区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, null, サービス提供事業者, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス適用事業者がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, null, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, サービス提供事業者, null, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス項目コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityにセットされている() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get対象年月(), is(対象年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
            assertThat(sut.get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.getサービス提供事業者番号(), is(サービス提供事業者));
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.getサービス項目コード(), is(サービス項目コード));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikosakuseiMeisaiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(被保険者番号, 対象年月, 履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.identifier().getサービス提供事業者番号(), is(サービス提供事業者));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().getサービス項目コード(), is(サービス項目コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(null);
        }

        @Test
        public void 指定したDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get居宅サービス区分(), is(居宅サービス区分));
            assertThat(sut.identifier().getサービス提供事業者番号(), is(サービス提供事業者));
            assertThat(sut.identifier().getサービス種類コード(), is(サービス種類コード));
            assertThat(sut.identifier().getサービス項目コード(), is(サービス項目コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get居宅サービス区分は_entityが持つ居宅サービス区分を返す() {
            assertThat(sut.get居宅サービス区分(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKyotakuServiceKubun()));
        }

        @Test
        public void getサービス提供事業者番号は_entityが持つサービス提供事業者番号を返す() {
            assertThat(sut.getサービス提供事業者番号(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getServiceTeikyoJigyoshaNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getServiceKomokuCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getTaniSu()));
        }

        @Test
        public void get回数_日数は_entityが持つ回数_日数を返す() {
            assertThat(sut.get回数_日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKaisu_Nissu()));
        }

        @Test
        public void get種類限度内単位数_日数は_entityが持つ種類限度内単位数_日数を返す() {
            assertThat(sut.get種類限度内単位数_日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getShuruiGendoNaiTaniSu_Nissu()));
        }

        @Test
        public void get種類限度超過単位数_日数は_entityが持つ種類限度超過単位数_日数を返す() {
            assertThat(sut.get種類限度超過単位数_日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getShuruiGendoChokaTaniSu_Nissu())
            );
        }

        @Test
        public void get区分限度内単位数_日数は_entityが持つ区分限度内単位数_日数を返す() {
            assertThat(sut.get区分限度内単位数_日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKubunGendoNaiTaniSu_Nissu())
            );
        }

        @Test
        public void get区分限度超過単位数_日数は_entityが持つ区分限度超過単位数_日数を返す() {
            assertThat(sut.get区分限度超過単位数_日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKubunGendoChokaTaniSu_Nissu())
            );
        }

        @Test
        public void get単位数単価は_entityが持つ単位数単価を返す() {
            assertThat(sut.get単位数単価(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getTaniSuTanka()));
        }

        @Test
        public void get給付率は_entityが持つ給付率を返す() {
            assertThat(sut.get給付率(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKyufuRitsu()));
        }

        @Test
        public void get割引後適用率は_entityが持つ割引後適用率を返す() {
            assertThat(sut.get割引後適用率(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getWaribikiGoTekiyoRitsu()));
        }

        @Test
        public void get割引後適用単位数は_entityが持つ割引後適用単位数を返す() {
            assertThat(sut.get割引後適用単位数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getWaribikiGoTekiyoTaniSu()));
        }

        @Test
        public void get給付対象日数は_entityが持つ給付対象日数を返す() {
            assertThat(sut.get給付対象日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKyufuTaishoNissu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikosakuseiMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;
        private static KyotakuKeikakuJikosakuseiMeisai result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceTeikyoJigyoshaNo(サービス提供事業者);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

        }

        @Test
        public void KyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikosakuseiMeisaiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikosakuseiMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikosakuseiMeisaiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikosakuseiMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikosakuseiMeisaiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikosakuseiMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikosakuseiMeisaiが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikosakuseiMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikosakuseiMeisai setStateKyotakuKeikakuJikosakuseiMeisai(EntityDataState parentState) {
            KyotakuKeikakuJikosakuseiMeisaiEntity.setState(parentState);
            return new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
        }
    }
}
