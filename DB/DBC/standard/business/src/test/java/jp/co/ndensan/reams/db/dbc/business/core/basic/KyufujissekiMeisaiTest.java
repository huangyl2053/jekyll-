/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3018KyufujissekiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
 * {@link KyufujissekiMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiMeisaiTest extends DbcTestBase {

    private static DbT3018KyufujissekiMeisaiEntity KyufujissekiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;
    private static ServiceShuruiCode サービス種類コード;
    private static ServiceKomokuCode サービス項目コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号;
        サービス種類コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiMeisai(null, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月,
                    事業所番号, 通し番号, サービス種類コード, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiMeisai(交換情報識別番号, null,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月,
                    事業所番号, 通し番号, サービス種類コード, サービス項目コード);
        }

        @Test
        public void 指定したキーが保持するDbT3018KyufujissekiMeisaiEntityにセットされている() {
            sut = new KyufujissekiMeisai(交換情報識別番号, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月,
                    事業所番号, 通し番号, サービス種類コード, サービス項目コード);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiMeisaiIdentifierにセットされている() {
            sut = new KyufujissekiMeisai(交換情報識別番号, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月,
                    事業所番号, 通し番号, サービス種類コード, サービス項目コード);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiMeisai(null);
        }

        @Test
        public void 指定したDbT3018KyufujissekiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiMeisai(KyufujissekiMeisaiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyufujissekiMeisai(KyufujissekiMeisaiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiMeisaiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiMeisaiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiMeisaiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiMeisaiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiMeisaiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiMeisaiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiMeisaiEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiMeisaiEntity.getToshiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufujissekiMeisaiEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(KyufujissekiMeisaiEntity.getServiceKomokuCode()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KyufujissekiMeisaiEntity.getTanisu()));
        }

        @Test
        public void get日数_回数は_entityが持つ日数_回数を返す() {
            assertThat(sut.get日数_回数(), is(KyufujissekiMeisaiEntity.getNissuKaisu())
            );
        }

        @Test
        public void get公費１対象日数_回数は_entityが持つ公費１対象日数_回数を返す() {
            assertThat(sut.get公費１対象日数_回数(), is(KyufujissekiMeisaiEntity.getKohi1TaishoNissuKaisu())
            );
        }

        @Test
        public void get公費２対象日数_回数は_entityが持つ公費２対象日数_回数を返す() {
            assertThat(sut.get公費２対象日数_回数(), is(KyufujissekiMeisaiEntity.getKohi2TaishoNissuKaisu())
            );
        }

        @Test
        public void get公費３対象日数_回数は_entityが持つ公費３対象日数_回数を返す() {
            assertThat(sut.get公費３対象日数_回数(), is(KyufujissekiMeisaiEntity.getKohi3TaishoNissuKaisu())
            );
        }

        @Test
        public void getサービス単位数は_entityが持つサービス単位数を返す() {
            assertThat(sut.getサービス単位数(), is(KyufujissekiMeisaiEntity.getServiceTanisu()));
        }

        @Test
        public void get公費１対象サービス単位数は_entityが持つ公費１対象サービス単位数を返す() {
            assertThat(sut.get公費１対象サービス単位数(), is(KyufujissekiMeisaiEntity.getKohi1TaishoServiceTanisu()));
        }

        @Test
        public void get公費２対象サービス単位数は_entityが持つ公費２対象サービス単位数を返す() {
            assertThat(sut.get公費２対象サービス単位数(), is(KyufujissekiMeisaiEntity.getKohi2TaishoServiceTanisu()));
        }

        @Test
        public void get公費３対象サービス単位数は_entityが持つ公費３対象サービス単位数を返す() {
            assertThat(sut.get公費３対象サービス単位数(), is(KyufujissekiMeisaiEntity.getKohi3TaishoServiceTanisu()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(KyufujissekiMeisaiEntity.getTekiyo()));
        }

        @Test
        public void get後_単位数は_entityが持つ後_単位数を返す() {
            assertThat(sut.get後_単位数(), is(KyufujissekiMeisaiEntity.getAtoTanisu())
            );
        }

        @Test
        public void get後_日数_回数は_entityが持つ後_日数_回数を返す() {
            assertThat(sut.get後_日数_回数(), is(KyufujissekiMeisaiEntity.getAtoNissuKaisu())
            );
        }

        @Test
        public void get後_公費１対象日数_回数は_entityが持つ後_公費１対象日数_回数を返す() {
            assertThat(sut.get後_公費１対象日数_回数(), is(KyufujissekiMeisaiEntity.getAtoKohi1TaishoNissuKaisu())
            );
        }

        @Test
        public void get後_公費２対象日数_回数は_entityが持つ後_公費２対象日数_回数を返す() {
            assertThat(sut.get後_公費２対象日数_回数(), is(KyufujissekiMeisaiEntity.getAtoKohi2TaishoNissukaisu())
            );
        }

        @Test
        public void get後_公費３対象日数_回数は_entityが持つ後_公費３対象日数_回数を返す() {
            assertThat(sut.get後_公費３対象日数_回数(), is(KyufujissekiMeisaiEntity.getAtoKohi3TaishoNissuKaisu())
            );
        }

        @Test
        public void get後_サービス単位数は_entityが持つ後_サービス単位数を返す() {
            assertThat(sut.get後_サービス単位数(), is(KyufujissekiMeisaiEntity.getAtoServiceTanisu())
            );
        }

        @Test
        public void get後_公費１対象サービス単位数は_entityが持つ後_公費１対象サービス単位数を返す() {
            assertThat(sut.get後_公費１対象サービス単位数(), is(KyufujissekiMeisaiEntity.getAtoKohi1TaishoServiceTanisu())
            );
        }

        @Test
        public void get後_公費２対象サービス単位数は_entityが持つ後_公費２対象サービス単位数を返す() {
            assertThat(sut.get後_公費２対象サービス単位数(), is(KyufujissekiMeisaiEntity.getAtoKohi2TaishoServiceTanisu())
            );
        }

        @Test
        public void get後_公費３対象サービス単位数は_entityが持つ後_公費３対象サービス単位数を返す() {
            assertThat(sut.get後_公費３対象サービス単位数(), is(KyufujissekiMeisaiEntity.getAtoKohi3TaishoServiceTanisu())
            );
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiMeisaiEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiMeisaiEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiMeisaiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiMeisaiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiMeisaiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyufujissekiMeisai(KyufujissekiMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            sut = new KyufujissekiMeisai(KyufujissekiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiMeisai sut;
        private static KyufujissekiMeisai result;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = DbT3018KyufujissekiMeisaiEntityGenerator.createDbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

        }

        @Test
        public void KyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがDeletedに指定されたKyufujissekiMeisaiが返る() {
            sut = TestSupport.setStateKyufujissekiMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがDeletedに指定されたKyufujissekiMeisaiが返る() {
            sut = TestSupport.setStateKyufujissekiMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがDeletedに指定されたKyufujissekiMeisaiが返る() {
            sut = TestSupport.setStateKyufujissekiMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiMeisaiが保持するDbT3018KyufujissekiMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiMeisai setStateKyufujissekiMeisai(EntityDataState parentState) {
            KyufujissekiMeisaiEntity.setState(parentState);
            return new KyufujissekiMeisai(KyufujissekiMeisaiEntity);
        }
    }
}
