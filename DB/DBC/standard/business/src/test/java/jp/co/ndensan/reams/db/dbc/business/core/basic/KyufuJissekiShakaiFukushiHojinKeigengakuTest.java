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
 * {@link KyufuJissekiShakaiFukushiHojinKeigengaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuJissekiShakaiFukushiHojinKeigengakuTest extends DbcTestBase {

    private static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity KyufuJissekiShakaiFukushiHojinKeigengakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityにセットされている() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuJissekiShakaiFukushiHojinKeigengakuIdentifierにセットされている() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(null);
        }

        @Test
        public void 指定したDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのキー情報を識別子が持つ() {

            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getToshiNo()));
        }

        @Test
        public void get軽減率は_entityが持つ軽減率を返す() {
            assertThat(sut.get軽減率(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getKeigenritsu()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getServiceSyuruiCode()));
        }

        @Test
        public void get受領すべき利用者負担の総額は_entityが持つ受領すべき利用者負担の総額を返す() {
            assertThat(sut.get受領すべき利用者負担の総額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getRiyoshaFutanTotal()));
        }

        @Test
        public void get軽減額は_entityが持つ軽減額を返す() {
            assertThat(sut.get軽減額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getKeigengaku()));
        }

        @Test
        public void get軽減後利用者負担額は_entityが持つ軽減後利用者負担額を返す() {
            assertThat(sut.get軽減後利用者負担額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getKeigengoRiyoshaFutangaku()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getBiko()));
        }

        @Test
        public void get後・受領すべき利用者負担の総額は_entityが持つ後・受領すべき利用者負担の総額を返す() {
            assertThat(sut.get後・受領すべき利用者負担の総額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getAtoRiyoshaFutanTotal()));
        }

        @Test
        public void get後・軽減額は_entityが持つ後・軽減額を返す() {
            assertThat(sut.get後・軽減額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getAtoKeigengaku()));
        }

        @Test
        public void get後・軽減後利用者負担額は_entityが持つ後・軽減後利用者負担額を返す() {
            assertThat(sut.get後・軽減後利用者負担額(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getAtoKeigengoRiyoshaFutangaku()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufuJissekiShakaiFukushiHojinKeigengakuEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuJissekiShakaiFukushiHojinKeigengakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

            sut = new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengaku sut;
        private static KyufuJissekiShakaiFukushiHojinKeigengaku result;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.createDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたKyufuJissekiShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateKyufuJissekiShakaiFukushiHojinKeigengaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたKyufuJissekiShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateKyufuJissekiShakaiFukushiHojinKeigengaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがDeletedに指定されたKyufuJissekiShakaiFukushiHojinKeigengakuが返る() {
            sut = TestSupport.setStateKyufuJissekiShakaiFukushiHojinKeigengaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuJissekiShakaiFukushiHojinKeigengakuが保持するDbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuJissekiShakaiFukushiHojinKeigengaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuJissekiShakaiFukushiHojinKeigengaku setStateKyufuJissekiShakaiFukushiHojinKeigengaku(EntityDataState parentState) {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setState(parentState);
            return new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);
        }
    }
}
