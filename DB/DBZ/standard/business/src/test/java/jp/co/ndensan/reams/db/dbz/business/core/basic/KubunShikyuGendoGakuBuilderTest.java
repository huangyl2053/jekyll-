/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.basic.KubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KubunShikyuGendoGakuBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7109KubunShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KubunShikyuGendoGakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KubunShikyuGendoGakuBuilderTest extends DbcTestBase {

    private static DbT7109KubunShikyuGendoGakuEntity KubunShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名2 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KubunShikyuGendoGakuBuilder sut;
        private static KubunShikyuGendoGaku business;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = new DbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            business = new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            business = sut.set要介護状態区分(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分).build();
            assertThat(business.get要介護状態区分(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            business = sut.set支給限度単位数(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数).build();
            assertThat(business.get支給限度単位数(), is(DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }

    }
}
