/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuHohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuHohoBuilderTest extends DbbTestBase {

    private static DbT2001ChoshuHohoEntity ChoshuHohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
        被保険者番号 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static ChoshuHohoBuilder sut;
        private static ChoshuHoho business;

        @Before
        public void setUp() {
            ChoshuHohoEntity = new DbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);

            business = new ChoshuHoho(ChoshuHohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の徴収方法4月は_設定した値と同じ徴収方法4月を返す() {
            business = sut.set徴収方法4月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法4月).build();
            assertThat(business.get徴収方法4月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法4月));
        }

        @Test
        public void 戻り値の徴収方法5月は_設定した値と同じ徴収方法5月を返す() {
            business = sut.set徴収方法5月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法5月).build();
            assertThat(business.get徴収方法5月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法5月));
        }

        @Test
        public void 戻り値の徴収方法6月は_設定した値と同じ徴収方法6月を返す() {
            business = sut.set徴収方法6月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法6月).build();
            assertThat(business.get徴収方法6月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法6月));
        }

        @Test
        public void 戻り値の徴収方法7月は_設定した値と同じ徴収方法7月を返す() {
            business = sut.set徴収方法7月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法7月).build();
            assertThat(business.get徴収方法7月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法7月));
        }

        @Test
        public void 戻り値の徴収方法8月は_設定した値と同じ徴収方法8月を返す() {
            business = sut.set徴収方法8月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法8月).build();
            assertThat(business.get徴収方法8月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法8月));
        }

        @Test
        public void 戻り値の徴収方法9月は_設定した値と同じ徴収方法9月を返す() {
            business = sut.set徴収方法9月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法9月).build();
            assertThat(business.get徴収方法9月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法9月));
        }

        @Test
        public void 戻り値の徴収方法10月は_設定した値と同じ徴収方法10月を返す() {
            business = sut.set徴収方法10月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法10月).build();
            assertThat(business.get徴収方法10月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法10月));
        }

        @Test
        public void 戻り値の徴収方法11月は_設定した値と同じ徴収方法11月を返す() {
            business = sut.set徴収方法11月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法11月).build();
            assertThat(business.get徴収方法11月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法11月));
        }

        @Test
        public void 戻り値の徴収方法12月は_設定した値と同じ徴収方法12月を返す() {
            business = sut.set徴収方法12月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法12月).build();
            assertThat(business.get徴収方法12月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法12月));
        }

        @Test
        public void 戻り値の徴収方法1月は_設定した値と同じ徴収方法1月を返す() {
            business = sut.set徴収方法1月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法1月).build();
            assertThat(business.get徴収方法1月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法1月));
        }

        @Test
        public void 戻り値の徴収方法2月は_設定した値と同じ徴収方法2月を返す() {
            business = sut.set徴収方法2月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法2月).build();
            assertThat(business.get徴収方法2月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法2月));
        }

        @Test
        public void 戻り値の徴収方法3月は_設定した値と同じ徴収方法3月を返す() {
            business = sut.set徴収方法3月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法3月).build();
            assertThat(business.get徴収方法3月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法3月));
        }

        @Test
        public void 戻り値の徴収方法翌4月は_設定した値と同じ徴収方法翌4月を返す() {
            business = sut.set徴収方法翌4月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌4月).build();
            assertThat(business.get徴収方法翌4月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌4月));
        }

        @Test
        public void 戻り値の徴収方法翌5月は_設定した値と同じ徴収方法翌5月を返す() {
            business = sut.set徴収方法翌5月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌5月).build();
            assertThat(business.get徴収方法翌5月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌5月));
        }

        @Test
        public void 戻り値の徴収方法翌6月は_設定した値と同じ徴収方法翌6月を返す() {
            business = sut.set徴収方法翌6月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌6月).build();
            assertThat(business.get徴収方法翌6月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌6月));
        }

        @Test
        public void 戻り値の徴収方法翌7月は_設定した値と同じ徴収方法翌7月を返す() {
            business = sut.set徴収方法翌7月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌7月).build();
            assertThat(business.get徴収方法翌7月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌7月));
        }

        @Test
        public void 戻り値の徴収方法翌8月は_設定した値と同じ徴収方法翌8月を返す() {
            business = sut.set徴収方法翌8月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌8月).build();
            assertThat(business.get徴収方法翌8月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌8月));
        }

        @Test
        public void 戻り値の徴収方法翌9月は_設定した値と同じ徴収方法翌9月を返す() {
            business = sut.set徴収方法翌9月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌9月).build();
            assertThat(business.get徴収方法翌9月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_徴収方法翌9月));
        }

        @Test
        public void 戻り値の仮徴収_基礎年金番号は_設定した値と同じ仮徴収_基礎年金番号を返す() {
            business = sut.set仮徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収基礎年金番号).build();
            assertThat(business.get仮徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収基礎年金番号));
        }

        @Test
        public void 戻り値の仮徴収_年金コードは_設定した値と同じ仮徴収_年金コードを返す() {
            business = sut.set仮徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収年金コード).build();
            assertThat(business.get仮徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収年金コード));
        }

        @Test
        public void 戻り値の仮徴収_捕捉月は_設定した値と同じ仮徴収_捕捉月を返す() {
            business = sut.set仮徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収捕捉月).build();
            assertThat(business.get仮徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_仮徴収捕捉月));
        }

        @Test
        public void 戻り値の本徴収_基礎年金番号は_設定した値と同じ本徴収_基礎年金番号を返す() {
            business = sut.set本徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収基礎年金番号).build();
            assertThat(business.get本徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収基礎年金番号));
        }

        @Test
        public void 戻り値の本徴収_年金コードは_設定した値と同じ本徴収_年金コードを返す() {
            business = sut.set本徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収年金コード).build();
            assertThat(business.get本徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収年金コード));
        }

        @Test
        public void 戻り値の本徴収_捕捉月は_設定した値と同じ本徴収_捕捉月を返す() {
            business = sut.set本徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収捕捉月).build();
            assertThat(business.get本徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_本徴収捕捉月));
        }

        @Test
        public void 戻り値の翌年度仮徴収_基礎年金番号は_設定した値と同じ翌年度仮徴収_基礎年金番号を返す() {
            business = sut.set翌年度仮徴収_基礎年金番号(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収基礎年金番号).build();
            assertThat(business.get翌年度仮徴収_基礎年金番号(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収基礎年金番号));
        }

        @Test
        public void 戻り値の翌年度仮徴収_年金コードは_設定した値と同じ翌年度仮徴収_年金コードを返す() {
            business = sut.set翌年度仮徴収_年金コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収年金コード).build();
            assertThat(business.get翌年度仮徴収_年金コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収年金コード));
        }

        @Test
        public void 戻り値の翌年度仮徴収_捕捉月は_設定した値と同じ翌年度仮徴収_捕捉月を返す() {
            business = sut.set翌年度仮徴収_捕捉月(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収捕捉月).build();
            assertThat(business.get翌年度仮徴収_捕捉月(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_翌年度仮徴収捕捉月));
        }

        @Test
        public void 戻り値の依頼情報送付済みフラグは_設定した値と同じ依頼情報送付済みフラグを返す() {
            business = sut.set依頼情報送付済みフラグ(DbT2001ChoshuHohoEntityGenerator.DEFAULT_依頼情報送付済みフラグ).build();
            assertThat(business.is依頼情報送付済みフラグ(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_依頼情報送付済みフラグ));
        }

        @Test
        public void 戻り値の追加依頼情報送付済みフラグは_設定した値と同じ追加依頼情報送付済みフラグを返す() {
            business = sut.set追加依頼情報送付済みフラグ(DbT2001ChoshuHohoEntityGenerator.DEFAULT_追加依頼情報送付済みフラグ).build();
            assertThat(business.is追加依頼情報送付済みフラグ(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_追加依頼情報送付済みフラグ));
        }

        @Test
        public void 戻り値の特別徴収停止日時は_設定した値と同じ特別徴収停止日時を返す() {
            business = sut.set特別徴収停止日時(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止日時).build();
            assertThat(business.get特別徴収停止日時(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止日時));
        }

        @Test
        public void 戻り値の特別徴収停止事由コードは_設定した値と同じ特別徴収停止事由コードを返す() {
            business = sut.set特別徴収停止事由コード(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止事由コード).build();
            assertThat(business.get特別徴収停止事由コード(), is(DbT2001ChoshuHohoEntityGenerator.DEFAULT_特別徴収停止事由コード));
        }

    }
}
