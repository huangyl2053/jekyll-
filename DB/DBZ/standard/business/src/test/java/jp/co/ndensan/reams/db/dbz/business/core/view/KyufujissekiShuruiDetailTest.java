/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShuruiDetail}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShuruiDetailTest extends DbzTestBase {

    private static DbV3016KyufujissekiShuruiDetailEntity KyufujissekiShuruiDetailEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShuruiDetail(null, 入力識別番号, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShuruiDetail(交換情報識別番号, null, レコード種別コード, 証記載保険者番号, 被保険者番号,
                    サービス提供年月, 事業所番号, 通し番号);
        }

        @Test
        public void 指定したキーが保持するDbV3016KyufujissekiShuruiDetailEntityにセットされている() {
            sut = new KyufujissekiShuruiDetail(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号);
            assertThat(sut.get入力識別番号(), is(入力識別番号));
            assertThat(sut.get交換情報識別番号(), is(交換情報識別番号));
            assertThat(sut.getレコード種別コード(), is(レコード種別コード));
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.getサービス提供年月(), is(サービス提供年月));
            assertThat(sut.get事業所番号(), is(事業所番号));
            assertThat(sut.get通し番号(), is(通し番号));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiShuruiDetailIdentifierにセットされている() {
            sut = new KyufujissekiShuruiDetail(交換情報識別番号, 入力識別番号, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, 通し番号);
            //TODO
//            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
//            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiShuruiDetail(null);
        }

        @Test
        public void 指定したDbV3016KyufujissekiShuruiDetailEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);

            //TODO
//            assertThat(sut.identifier().get交換情報識別番号(), is(交換情報識別番号));
//            assertThat(sut.identifier().get入力識別番号(), is(入力識別番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();

            sut = new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiShuruiDetailEntity.getKokanShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiShuruiDetailEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiShuruiDetailEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiShuruiDetailEntity.getHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiShuruiDetailEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiShuruiDetailEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiShuruiDetailEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiShuruiDetailEntity.getToshiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufujissekiShuruiDetailEntity.getServiceSyuruiCode()));
        }

        @Test
        public void get保険_利用者負担額は_entityが持つ保険_利用者負担額を返す() {
            assertThat(sut.get保険_利用者負担額(), is(KyufujissekiShuruiDetailEntity.getHokenRiyoshaFutangaku()));
        }

        @Test
        public void get後_単位数合計は_entityが持つ後_単位数合計を返す() {
            assertThat(sut.get後_単位数合計(), is(KyufujissekiShuruiDetailEntity.getAtoHokenTanisuTotal()));
        }

        @Test
        public void get後_保険請求分請求額は_entityが持つ後_保険請求分請求額を返す() {
            assertThat(sut.get後_保険請求分請求額(), is(KyufujissekiShuruiDetailEntity.getAtoHokenSeikyugaku()));
        }

        @Test
        public void get後_保険_出来高単位数合計は_entityが持つ後_保険_出来高単位数合計を返す() {
            assertThat(sut.get後_保険_出来高単位数合計(), is(KyufujissekiShuruiDetailEntity.getAtoHokenDekidakaTanisuTotal()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(KyufujissekiShuruiDetailEntity.getServiceCode()));
        }

        @Test
        public void get後_サービス単位数合計は_entityが持つ後_サービス単位数合計を返す() {
            assertThat(sut.get後_サービス単位数合計(), is(KyufujissekiShuruiDetailEntity.getAtoServiceTanisuTotal()));
        }

        @Test
        public void get後_単位数は_entityが持つ後_単位数を返す() {
            assertThat(sut.get後_単位数(), is(KyufujissekiShuruiDetailEntity.getAtotanisu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();

            sut = new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiShuruiDetailEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();

            sut = new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyufujissekiShuruiDetail sut;
        private static KyufujissekiShuruiDetail result;

        @BeforeClass
        public static void setUpClass() {
            KyufujissekiShuruiDetailEntity = DbV3016KyufujissekiShuruiDetailEntityGenerator.createDbV3016KyufujissekiShuruiDetailEntity();

        }

        @Test
        public void KyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがDeletedに指定されたKyufujissekiShuruiDetailが返る() {
            sut = TestSupport.setStateKyufujissekiShuruiDetail(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがDeletedに指定されたKyufujissekiShuruiDetailが返る() {
            sut = TestSupport.setStateKyufujissekiShuruiDetail(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがDeletedに指定されたKyufujissekiShuruiDetailが返る() {
            sut = TestSupport.setStateKyufujissekiShuruiDetail(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiShuruiDetailが保持するDbV3016KyufujissekiShuruiDetailEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiShuruiDetail(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiShuruiDetail setStateKyufujissekiShuruiDetail(EntityDataState parentState) {
            KyufujissekiShuruiDetailEntity.setState(parentState);
            return new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);
        }
    }
}
