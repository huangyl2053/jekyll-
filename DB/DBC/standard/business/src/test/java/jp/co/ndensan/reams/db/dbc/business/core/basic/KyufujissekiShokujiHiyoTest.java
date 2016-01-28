/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3022KyufujissekiShokujiHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import org.junit.Ignore;

/**
 * {@link KyufujissekiShokujiHiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiShokujiHiyoTest extends DbcTestBase {

    private static DbT3022KyufujissekiShokujiHiyoEntity KyufujissekiShokujiHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_通し番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShokujiHiyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
        }

        @Test
        public void 指定したキーが保持するDbT3022KyufujissekiShokujiHiyoEntityにセットされている() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
            assertThat(sut.get交換情報識別番号(), is(主キー名1));
            assertThat(sut.get入力識別番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiShokujiHiyoIdentifierにセットされている() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiShokujiHiyo(null);
        }

        @Test
        public void 指定したDbT3022KyufujissekiShokujiHiyoEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiShokujiHiyoEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiShokujiHiyoEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiShokujiHiyoEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiShokujiHiyoEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiShokujiHiyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiShokujiHiyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiShokujiHiyoEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiShokujiHiyoEntity.getToshiNo()));
        }

        @Test
        public void get基本_提供日数は_entityが持つ基本_提供日数を返す() {
            assertThat(sut.get基本_提供日数(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoNissu()));
        }

        @Test
        public void get基本_提供単価は_entityが持つ基本_提供単価を返す() {
            assertThat(sut.get基本_提供単価(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoTanka()));
        }

        @Test
        public void get基本_提供金額は_entityが持つ基本_提供金額を返す() {
            assertThat(sut.get基本_提供金額(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoKingaku()));
        }

        @Test
        public void get特別_提供日数は_entityが持つ特別_提供日数を返す() {
            assertThat(sut.get特別_提供日数(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoNissu()));
        }

        @Test
        public void get特別_提供単価は_entityが持つ特別_提供単価を返す() {
            assertThat(sut.get特別_提供単価(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoTanka()));
        }

        @Test
        public void get特別_提供金額は_entityが持つ特別_提供金額を返す() {
            assertThat(sut.get特別_提供金額(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoKingaku()));
        }

        @Test
        public void get食事提供延べ日数は_entityが持つ食事提供延べ日数を返す() {
            assertThat(sut.get食事提供延べ日数(), is(KyufujissekiShokujiHiyoEntity.getSyokujiTeikyoNissu()));
        }

        @Test
        public void get公費１対象食事提供延べ日数は_entityが持つ公費１対象食事提供延べ日数を返す() {
            assertThat(sut.get公費１対象食事提供延べ日数(), is(KyufujissekiShokujiHiyoEntity.getKohi1SyokujiTeikyoNissu()));
        }

        @Test
        public void get公費２対象食事提供延べ日数は_entityが持つ公費２対象食事提供延べ日数を返す() {
            assertThat(sut.get公費２対象食事提供延べ日数(), is(KyufujissekiShokujiHiyoEntity.getKohi2SyokujiTeikyoNissu()));
        }

        @Test
        public void get公費３対象食事提供延べ日数は_entityが持つ公費３対象食事提供延べ日数を返す() {
            assertThat(sut.get公費３対象食事提供延べ日数(), is(KyufujissekiShokujiHiyoEntity.getKohi3SyokujiTeikyoNissu()));
        }

        @Test
        public void get食事提供費合計は_entityが持つ食事提供費合計を返す() {
            assertThat(sut.get食事提供費合計(), is(KyufujissekiShokujiHiyoEntity.getSyokujiTeikyohiTotal()));
        }

        @Test
        public void get標準負担額_月額は_entityが持つ標準負担額_月額を返す() {
            assertThat(sut.get標準負担額_月額(), is(KyufujissekiShokujiHiyoEntity.getGetsugakuHyojunFutanGaku()));
        }

        @Test
        public void get食事提供費請求額は_entityが持つ食事提供費請求額を返す() {
            assertThat(sut.get食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getSyokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get公費１食事提供費請求額は_entityが持つ公費１食事提供費請求額を返す() {
            assertThat(sut.get公費１食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getKohi1SyokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get公費２食事提供費請求額は_entityが持つ公費２食事提供費請求額を返す() {
            assertThat(sut.get公費２食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getKohi2SyokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get公費３食事提供費請求額は_entityが持つ公費３食事提供費請求額を返す() {
            assertThat(sut.get公費３食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getKohi3SyokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get標準負担額_日額は_entityが持つ標準負担額_日額を返す() {
            assertThat(sut.get標準負担額_日額(), is(KyufujissekiShokujiHiyoEntity.getNichigakuHyojunFutanGaku()));
        }

        @Test
        public void get後_基本食提供費用提供単価は_entityが持つ後_基本食提供費用提供単価を返す() {
            assertThat(sut.get後_基本食提供費用提供単価(), is(KyufujissekiShokujiHiyoEntity.getAtoKihonTeikyoTanka()));
        }

        @Test
        public void get後_特別食提供費用提供単価は_entityが持つ後_特別食提供費用提供単価を返す() {
            assertThat(sut.get後_特別食提供費用提供単価(), is(KyufujissekiShokujiHiyoEntity.getAtoTokubestuTeikyoTanka()));
        }

        @Test
        public void get後_食事提供費請求額は_entityが持つ後_食事提供費請求額を返す() {
            assertThat(sut.get後_食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getAtoSyokujiTeikyohiSeikyugaku()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiShokujiHiyoEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiShokujiHiyoEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiShokujiHiyoEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiShokujiHiyoEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiShokujiHiyoEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiShokujiHiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;
        private static KyufujissekiShokujiHiyo result;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiShokujiHiyoEntity.setInputShikibetsuNo(主キー名2);

        }

        @Test
        public void KyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShokujiHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiShokujiHiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShokujiHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiShokujiHiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShokujiHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiShokujiHiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiShokujiHiyoが保持するDbT3022KyufujissekiShokujiHiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiShokujiHiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiShokujiHiyo setStateKyufujissekiShokujiHiyo(EntityDataState parentState) {
            KyufujissekiShokujiHiyoEntity.setState(parentState);
            return new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);
        }
    }
}
