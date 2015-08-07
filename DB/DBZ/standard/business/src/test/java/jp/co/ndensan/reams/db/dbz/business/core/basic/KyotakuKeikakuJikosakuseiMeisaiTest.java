/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
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
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityにセットされている() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikosakuseiMeisaiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikosakuseiMeisai(null);
        }

        @Test
        public void 指定したDbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);

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
        public void get回数・日数は_entityが持つ回数・日数を返す() {
            assertThat(sut.get回数・日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKaisu_Nissu()));
        }

        @Test
        public void get種類限度内単位数・日数は_entityが持つ種類限度内単位数・日数を返す() {
            assertThat(sut.get種類限度内単位数・日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getShuruiGendoNaiTaniSu_Nissu()));
        }

        @Test
        public void get種類限度超過単位数・日数は_entityが持つ種類限度超過単位数・日数を返す() {
            assertThat(sut.get種類限度超過単位数・日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getShuruiGendoChokaTaniSu_Nissu()));
        }

        @Test
        public void get区分限度内単位数・日数は_entityが持つ区分限度内単位数・日数を返す() {
            assertThat(sut.get区分限度内単位数・日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKubunGendoNaiTaniSu_Nissu()));
        }

        @Test
        public void get区分限度超過単位数・日数は_entityが持つ区分限度超過単位数・日数を返す() {
            assertThat(sut.get区分限度超過単位数・日数(), is(KyotakuKeikakuJikosakuseiMeisaiEntity.getKubunGendoChokaTaniSu_Nissu()));
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
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);

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
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikosakuseiMeisai sut;
        private static KyotakuKeikakuJikosakuseiMeisai result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikosakuseiMeisaiEntity = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.createDbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikosakuseiMeisaiEntity.setXXX(主キー名2);

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
