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
 * {@link KogakuKyufuTaishoshaMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuKyufuTaishoshaMeisaiBuilderTest extends DbcTestBase {

    private static DbT3054KogakuKyufuTaishoshaMeisaiEntity KogakuKyufuTaishoshaMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KogakuKyufuTaishoshaMeisaiBuilder sut;
        private static KogakuKyufuTaishoshaMeisai business;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaMeisaiEntity = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
            KogakuKyufuTaishoshaMeisaiEntity.setXXX(主キー名1);
            KogakuKyufuTaishoshaMeisaiEntity.setXXX(主キー名2);

            business = new KogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス費用合計額は_設定した値と同じサービス費用合計額を返す() {
            business = sut.setサービス費用合計額(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス費用合計額).build();
            assertThat(business.getサービス費用合計額(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_サービス費用合計額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の高額給付根拠は_設定した値と同じ高額給付根拠を返す() {
            business = sut.set高額給付根拠(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_高額給付根拠).build();
            assertThat(business.get高額給付根拠(), is(DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator.DEFAULT_高額給付根拠));
        }

    }
}
