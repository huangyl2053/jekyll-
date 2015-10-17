/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
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

/**
 * {@link KyufujissekiKogakuKaigoServicehi}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKogakuKaigoServicehiTest extends DbcTestBase {

    private static DbT3028KyufujissekiKogakuKaigoServicehiEntity KyufujissekiKogakuKaigoServicehiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static RString 通し番号;
    private static RString 給付実績情報作成区分コード;
    private static RString 給付実績区分コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月;
        通し番号 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号;
        給付実績情報作成区分コード = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード;
        給付実績区分コード = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKogakuKaigoServicehi(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 通し番号, 給付実績情報作成区分コード, 給付実績区分コード);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiKogakuKaigoServicehi(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 通し番号, 給付実績情報作成区分コード, 給付実績区分コード);
        }

        @Test
        public void 指定したキーが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityにセットされている() {
            sut = new KyufujissekiKogakuKaigoServicehi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 通し番号, 給付実績情報作成区分コード, 給付実績区分コード);
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.get入力識別番号(), is(入力識別番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiKogakuKaigoServicehiIdentifierにセットされている() {
            sut = new KyufujissekiKogakuKaigoServicehi(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 通し番号, 給付実績情報作成区分コード, 給付実績区分コード);
            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiKogakuKaigoServicehi(null);
        }

        @Test
        public void 指定したDbT3028KyufujissekiKogakuKaigoServicehiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);

            sut = new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiKogakuKaigoServicehiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiKogakuKaigoServicehiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getToshiNo()));
        }

        @Test
        public void get給付実績情報作成区分コードは_entityが持つ給付実績情報作成区分コードを返す() {
            assertThat(sut.get給付実績情報作成区分コード(), is(KyufujissekiKogakuKaigoServicehiEntity.getKyufuSakuseiKubunCode()));
        }

        @Test
        public void get給付実績区分コードは_entityが持つ給付実績区分コードを返す() {
            assertThat(sut.get給付実績区分コード(), is(KyufujissekiKogakuKaigoServicehiEntity.getKyufuJissekiKubunCode()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(KyufujissekiKogakuKaigoServicehiEntity.getUketsukeYMD()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(KyufujissekiKogakuKaigoServicehiEntity.getKetteiYMD()));
        }

        @Test
        public void get公費１負担番号は_entityが持つ公費１負担番号を返す() {
            assertThat(sut.get公費１負担番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi1FutanNo()));
        }

        @Test
        public void get公費２負担番号は_entityが持つ公費２負担番号を返す() {
            assertThat(sut.get公費２負担番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi2FutanNo()));
        }

        @Test
        public void get公費３負担番号は_entityが持つ公費３負担番号を返す() {
            assertThat(sut.get公費３負担番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi3FutanNo()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KyufujissekiKogakuKaigoServicehiEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get公費１負担額は_entityが持つ公費１負担額を返す() {
            assertThat(sut.get公費１負担額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi1Futangaku()));
        }

        @Test
        public void get公費２負担額は_entityが持つ公費２負担額を返す() {
            assertThat(sut.get公費２負担額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi2Futangaku()));
        }

        @Test
        public void get公費３負担額は_entityが持つ公費３負担額を返す() {
            assertThat(sut.get公費３負担額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi3Futangaku()));
        }

        @Test
        public void get支給額は_entityが持つ支給額を返す() {
            assertThat(sut.get支給額(), is(KyufujissekiKogakuKaigoServicehiEntity.getShikyugaku()));
        }

        @Test
        public void get公費１支給額は_entityが持つ公費１支給額を返す() {
            assertThat(sut.get公費１支給額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi1Shikyugaku()));
        }

        @Test
        public void get公費２支給額は_entityが持つ公費２支給額を返す() {
            assertThat(sut.get公費２支給額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi2Shikyugaku()));
        }

        @Test
        public void get公費３支給額は_entityが持つ公費３支給額を返す() {
            assertThat(sut.get公費３支給額(), is(KyufujissekiKogakuKaigoServicehiEntity.getKohi3Shikyugaku()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiKogakuKaigoServicehiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getSeiriNo()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KyufujissekiKogakuKaigoServicehiEntity.getSofuYM()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiKogakuKaigoServicehiEntity.getTorikomiYM()));
        }

        @Test
        public void get作成区分は_entityが持つ作成区分を返す() {
            assertThat(sut.get作成区分(), is(KyufujissekiKogakuKaigoServicehiEntity.getSakuseiKubun()));
        }

        @Test
        public void get管理番号は_entityが持つ管理番号を返す() {
            assertThat(sut.get管理番号(), is(KyufujissekiKogakuKaigoServicehiEntity.getKanriNo()));
        }

        @Test
        public void get保険者保有給付実績情報削除済フラグは_entityが持つ保険者保有給付実績情報削除済フラグを返す() {
            assertThat(sut.get保険者保有給付実績情報削除済フラグ(), is(KyufujissekiKogakuKaigoServicehiEntity.getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);

            sut = new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiKogakuKaigoServicehiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);

            sut = new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiKogakuKaigoServicehi sut;
        private static KyufujissekiKogakuKaigoServicehi result;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.createDbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKogakuKaigoServicehiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKogakuKaigoServicehiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKogakuKaigoServicehiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKogakuKaigoServicehiEntity.setToshiNo(通し番号);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            KyufujissekiKogakuKaigoServicehiEntity.setKyufuJissekiKubunCode(給付実績区分コード);

        }

        @Test
        public void KyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがDeletedに指定されたKyufujissekiKogakuKaigoServicehiが返る() {
            sut = TestSupport.setStateKyufujissekiKogakuKaigoServicehi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがDeletedに指定されたKyufujissekiKogakuKaigoServicehiが返る() {
            sut = TestSupport.setStateKyufujissekiKogakuKaigoServicehi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがDeletedに指定されたKyufujissekiKogakuKaigoServicehiが返る() {
            sut = TestSupport.setStateKyufujissekiKogakuKaigoServicehi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiKogakuKaigoServicehiが保持するDbT3028KyufujissekiKogakuKaigoServicehiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiKogakuKaigoServicehi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiKogakuKaigoServicehi setStateKyufujissekiKogakuKaigoServicehi(EntityDataState parentState) {
            KyufujissekiKogakuKaigoServicehiEntity.setState(parentState);
            return new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);
        }
    }
}
