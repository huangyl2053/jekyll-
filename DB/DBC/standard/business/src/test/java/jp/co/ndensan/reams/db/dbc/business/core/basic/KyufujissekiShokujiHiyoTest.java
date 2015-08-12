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
 * {@link KyufujissekiShokujiHiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShokujiHiyoTest extends DbcTestBase {

    private static DbT3022KyufujissekiShokujiHiyoEntity KyufujissekiShokujiHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShokujiHiyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3022KyufujissekiShokujiHiyoEntityにセットされている() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiShokujiHiyoIdentifierにセットされている() {
            sut = new KyufujissekiShokujiHiyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiShokujiHiyo(null);
        }

        @Test
        public void 指定したDbT3022KyufujissekiShokujiHiyoEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiShokujiHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = DbT3022KyufujissekiShokujiHiyoEntityGenerator.createDbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);

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
        public void get基本・提供日数は_entityが持つ基本・提供日数を返す() {
            assertThat(sut.get基本・提供日数(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoNissu()));
        }

        @Test
        public void get基本・提供単価は_entityが持つ基本・提供単価を返す() {
            assertThat(sut.get基本・提供単価(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoTanka()));
        }

        @Test
        public void get基本・提供金額は_entityが持つ基本・提供金額を返す() {
            assertThat(sut.get基本・提供金額(), is(KyufujissekiShokujiHiyoEntity.getKihonTeikyoKingaku()));
        }

        @Test
        public void get特別・提供日数は_entityが持つ特別・提供日数を返す() {
            assertThat(sut.get特別・提供日数(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoNissu()));
        }

        @Test
        public void get特別・提供単価は_entityが持つ特別・提供単価を返す() {
            assertThat(sut.get特別・提供単価(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoTanka()));
        }

        @Test
        public void get特別・提供金額は_entityが持つ特別・提供金額を返す() {
            assertThat(sut.get特別・提供金額(), is(KyufujissekiShokujiHiyoEntity.getTokubestuTeikyoKingaku()));
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
        public void get標準負担額（月額）は_entityが持つ標準負担額（月額）を返す() {
            assertThat(sut.get標準負担額（月額）(), is(KyufujissekiShokujiHiyoEntity.getGetsugakuHyojunFutanGaku()));
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
        public void get標準負担額（日額）は_entityが持つ標準負担額（日額）を返す() {
            assertThat(sut.get標準負担額（日額）(), is(KyufujissekiShokujiHiyoEntity.getNichigakuHyojunFutanGaku()));
        }

        @Test
        public void get後・基本食提供費用提供単価は_entityが持つ後・基本食提供費用提供単価を返す() {
            assertThat(sut.get後・基本食提供費用提供単価(), is(KyufujissekiShokujiHiyoEntity.getAtoKihonTeikyoTanka()));
        }

        @Test
        public void get後・特別食提供費用提供単価は_entityが持つ後・特別食提供費用提供単価を返す() {
            assertThat(sut.get後・特別食提供費用提供単価(), is(KyufujissekiShokujiHiyoEntity.getAtoTokubestuTeikyoTanka()));
        }

        @Test
        public void get後・食事提供費請求額は_entityが持つ後・食事提供費請求額を返す() {
            assertThat(sut.get後・食事提供費請求額(), is(KyufujissekiShokujiHiyoEntity.getAtoSyokujiTeikyohiSeikyugaku()));
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
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);

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
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);

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
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);

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
