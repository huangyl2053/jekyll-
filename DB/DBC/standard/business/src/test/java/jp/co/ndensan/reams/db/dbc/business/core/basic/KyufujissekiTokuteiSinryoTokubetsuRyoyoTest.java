/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoTest extends DbcTestBase {

    private static DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityにセットされている() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifierにセットされている() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(null);
        }

        @Test
        public void 指定したDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getToshiNo()));
        }

        @Test
        public void get特定診療情報レコード順次番号は_entityが持つ特定診療情報レコード順次番号を返す() {
            assertThat(sut.get特定診療情報レコード順次番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getRecodeJunjiNo()));
        }

        @Test
        public void get傷病名は_entityが持つ傷病名を返す() {
            assertThat(sut.get傷病名(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getShobyoName()));
        }

        @Test
        public void get識別番号は_entityが持つ識別番号を返す() {
            assertThat(sut.get識別番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getShikibetsuNo()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getTanisu()));
        }

        @Test
        public void get保険・回数は_entityが持つ保険・回数を返す() {
            assertThat(sut.get保険・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getHokenKaisu()));
        }

        @Test
        public void get保険・ｻｰﾋﾞｽ単位数は_entityが持つ保険・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get保険・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getHokenServiceTanisu()));
        }

        @Test
        public void get保険・合計単位数は_entityが持つ保険・合計単位数を返す() {
            assertThat(sut.get保険・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getHokenTotalTanisu()));
        }

        @Test
        public void get公費１・回数は_entityが持つ公費１・回数を返す() {
            assertThat(sut.get公費１・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi1Kaisu()));
        }

        @Test
        public void get公費１・ｻｰﾋﾞｽ単位数は_entityが持つ公費１・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get公費１・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi1ServiceTanisu()));
        }

        @Test
        public void get公費１・合計単位数は_entityが持つ公費１・合計単位数を返す() {
            assertThat(sut.get公費１・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi1TotalTanisu()));
        }

        @Test
        public void get公費２・回数は_entityが持つ公費２・回数を返す() {
            assertThat(sut.get公費２・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi2Kaisu()));
        }

        @Test
        public void get公費２・ｻｰﾋﾞｽ単位数は_entityが持つ公費２・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get公費２・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi2ServiceTanisu()));
        }

        @Test
        public void get公費２・合計単位数は_entityが持つ公費２・合計単位数を返す() {
            assertThat(sut.get公費２・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi2TotalTanisu()));
        }

        @Test
        public void get公費３・回数は_entityが持つ公費３・回数を返す() {
            assertThat(sut.get公費３・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi3Kaisu()));
        }

        @Test
        public void get公費３・ｻｰﾋﾞｽ単位数は_entityが持つ公費３・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get公費３・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi3ServiceTanisu()));
        }

        @Test
        public void get公費３・合計単位数は_entityが持つ公費３・合計単位数を返す() {
            assertThat(sut.get公費３・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKohi3TotalTanisu()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getTekiyo()));
        }

        @Test
        public void get後・単位数は_entityが持つ後・単位数を返す() {
            assertThat(sut.get後・単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoTanisu()));
        }

        @Test
        public void get後・保険・回数は_entityが持つ後・保険・回数を返す() {
            assertThat(sut.get後・保険・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoHokenKaisu()));
        }

        @Test
        public void get後・保険・ｻｰﾋﾞｽ単位数は_entityが持つ後・保険・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get後・保険・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoHokenServiceTanisu()));
        }

        @Test
        public void get後・保険・合計単位数は_entityが持つ後・保険・合計単位数を返す() {
            assertThat(sut.get後・保険・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoHokenTotalTanisu()));
        }

        @Test
        public void get後・公費１・回数は_entityが持つ後・公費１・回数を返す() {
            assertThat(sut.get後・公費１・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi1Kaisu()));
        }

        @Test
        public void get後・公費１・ｻｰﾋﾞｽ単位数は_entityが持つ後・公費１・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get後・公費１・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi1ServiceTanisu()));
        }

        @Test
        public void get後・公費１・合計単位数は_entityが持つ後・公費１・合計単位数を返す() {
            assertThat(sut.get後・公費１・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi1TotalTanisu()));
        }

        @Test
        public void get後・公費２・回数は_entityが持つ後・公費２・回数を返す() {
            assertThat(sut.get後・公費２・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi2Kaisu()));
        }

        @Test
        public void get後・公費２・ｻｰﾋﾞｽ単位数は_entityが持つ後・公費２・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get後・公費２・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi2ServiceTanisu()));
        }

        @Test
        public void get後・公費２・合計単位数は_entityが持つ後・公費２・合計単位数を返す() {
            assertThat(sut.get後・公費２・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi2TotalTanisu()));
        }

        @Test
        public void get後・公費３・回数は_entityが持つ後・公費３・回数を返す() {
            assertThat(sut.get後・公費３・回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi3Kaisu()));
        }

        @Test
        public void get後・公費３・ｻｰﾋﾞｽ単位数は_entityが持つ後・公費３・ｻｰﾋﾞｽ単位数を返す() {
            assertThat(sut.get後・公費３・ｻｰﾋﾞｽ単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi3ServiceTanisu()));
        }

        @Test
        public void get後・公費３・合計単位数は_entityが持つ後・公費３・合計単位数を返す() {
            assertThat(sut.get後・公費３・合計単位数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getAtoKohi3TotalTanisu()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo sut;
        private static KyufujissekiTokuteiSinryoTokubetsuRyoyo result;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity = DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator.createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryoTokubetsuRyoyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryoTokubetsuRyoyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryoTokubetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryoTokubetsuRyoyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiTokuteiSinryoTokubetsuRyoyoが保持するDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryoTokubetsuRyoyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiTokuteiSinryoTokubetsuRyoyo setStateKyufujissekiTokuteiSinryoTokubetsuRyoyo(EntityDataState parentState) {
            KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.setState(parentState);
            return new KyufujissekiTokuteiSinryoTokubetsuRyoyo(KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity);
        }
    }
}
