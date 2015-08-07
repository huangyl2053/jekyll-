/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShokujiHiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShokujiHiyoBuilderTest extends DbcTestBase {

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

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiShokujiHiyoBuilder sut;
        private static KyufujissekiShokujiHiyo business;

        @Before
        public void setUp() {
            KyufujissekiShokujiHiyoEntity = new DbT3022KyufujissekiShokujiHiyoEntity();
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名1);
            KyufujissekiShokujiHiyoEntity.setXXX(主キー名2);

            business = new KyufujissekiShokujiHiyo(KyufujissekiShokujiHiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の基本・提供日数は_設定した値と同じ基本・提供日数を返す() {
            business = sut.set基本・提供日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供日数).build();
            assertThat(business.get基本・提供日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供日数));
        }

        @Test
        public void 戻り値の基本・提供単価は_設定した値と同じ基本・提供単価を返す() {
            business = sut.set基本・提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供単価).build();
            assertThat(business.get基本・提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供単価));
        }

        @Test
        public void 戻り値の基本・提供金額は_設定した値と同じ基本・提供金額を返す() {
            business = sut.set基本・提供金額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供金額).build();
            assertThat(business.get基本・提供金額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_基本・提供金額));
        }

        @Test
        public void 戻り値の特別・提供日数は_設定した値と同じ特別・提供日数を返す() {
            business = sut.set特別・提供日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供日数).build();
            assertThat(business.get特別・提供日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供日数));
        }

        @Test
        public void 戻り値の特別・提供単価は_設定した値と同じ特別・提供単価を返す() {
            business = sut.set特別・提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供単価).build();
            assertThat(business.get特別・提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供単価));
        }

        @Test
        public void 戻り値の特別・提供金額は_設定した値と同じ特別・提供金額を返す() {
            business = sut.set特別・提供金額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供金額).build();
            assertThat(business.get特別・提供金額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_特別・提供金額));
        }

        @Test
        public void 戻り値の食事提供延べ日数は_設定した値と同じ食事提供延べ日数を返す() {
            business = sut.set食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数).build();
            assertThat(business.get食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費１対象食事提供延べ日数は_設定した値と同じ公費１対象食事提供延べ日数を返す() {
            business = sut.set公費１対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１対象食事提供延べ日数).build();
            assertThat(business.get公費１対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費２対象食事提供延べ日数は_設定した値と同じ公費２対象食事提供延べ日数を返す() {
            business = sut.set公費２対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２対象食事提供延べ日数).build();
            assertThat(business.get公費２対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の公費３対象食事提供延べ日数は_設定した値と同じ公費３対象食事提供延べ日数を返す() {
            business = sut.set公費３対象食事提供延べ日数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３対象食事提供延べ日数).build();
            assertThat(business.get公費３対象食事提供延べ日数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３対象食事提供延べ日数));
        }

        @Test
        public void 戻り値の食事提供費合計は_設定した値と同じ食事提供費合計を返す() {
            business = sut.set食事提供費合計(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計).build();
            assertThat(business.get食事提供費合計(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計));
        }

        @Test
        public void 戻り値の標準負担額（月額）は_設定した値と同じ標準負担額（月額）を返す() {
            business = sut.set標準負担額（月額）(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額（月額）).build();
            assertThat(business.get標準負担額（月額）(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額（月額）));
        }

        @Test
        public void 戻り値の食事提供費請求額は_設定した値と同じ食事提供費請求額を返す() {
            business = sut.set食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額).build();
            assertThat(business.get食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額));
        }

        @Test
        public void 戻り値の公費１食事提供費請求額は_設定した値と同じ公費１食事提供費請求額を返す() {
            business = sut.set公費１食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１食事提供費請求額).build();
            assertThat(business.get公費１食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費１食事提供費請求額));
        }

        @Test
        public void 戻り値の公費２食事提供費請求額は_設定した値と同じ公費２食事提供費請求額を返す() {
            business = sut.set公費２食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２食事提供費請求額).build();
            assertThat(business.get公費２食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費２食事提供費請求額));
        }

        @Test
        public void 戻り値の公費３食事提供費請求額は_設定した値と同じ公費３食事提供費請求額を返す() {
            business = sut.set公費３食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３食事提供費請求額).build();
            assertThat(business.get公費３食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_公費３食事提供費請求額));
        }

        @Test
        public void 戻り値の標準負担額（日額）は_設定した値と同じ標準負担額（日額）を返す() {
            business = sut.set標準負担額（日額）(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額（日額）).build();
            assertThat(business.get標準負担額（日額）(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_標準負担額（日額）));
        }

        @Test
        public void 戻り値の後・基本食提供費用提供単価は_設定した値と同じ後・基本食提供費用提供単価を返す() {
            business = sut.set後・基本食提供費用提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・基本食提供費用提供単価).build();
            assertThat(business.get後・基本食提供費用提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・基本食提供費用提供単価));
        }

        @Test
        public void 戻り値の後・特別食提供費用提供単価は_設定した値と同じ後・特別食提供費用提供単価を返す() {
            business = sut.set後・特別食提供費用提供単価(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・特別食提供費用提供単価).build();
            assertThat(business.get後・特別食提供費用提供単価(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・特別食提供費用提供単価));
        }

        @Test
        public void 戻り値の後・食事提供費請求額は_設定した値と同じ後・食事提供費請求額を返す() {
            business = sut.set後・食事提供費請求額(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・食事提供費請求額).build();
            assertThat(business.get後・食事提供費請求額(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_後・食事提供費請求額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3022KyufujissekiShokujiHiyoEntityGenerator.DEFAULT_取込年月));
        }

    }
}
