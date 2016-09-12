/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5031NinteiChosaHoshuTankaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiChosaHoshuTankaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiChosaHoshuTankaBuilderTest extends DbeTestBase {

    private static DbT5031NinteiChosaHoshuTankaEntity NinteiChosaHoshuTankaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static Code 調査区分;
    private static Code 訪問種別;
    private static FlexibleYearMonth 開始年月;
    private static FlexibleYearMonth 終了年月;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調査区分 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_調査区分;
        訪問種別 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_訪問種別;
        開始年月 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_開始年月;
        終了年月 = DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_終了年月;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static NinteiChosaHoshuTankaBuilder sut;
        private static NinteiChosaHoshuTanka business;

        @Before
        public void setUp() {
            NinteiChosaHoshuTankaEntity = new DbT5031NinteiChosaHoshuTankaEntity();

            business = new NinteiChosaHoshuTanka(NinteiChosaHoshuTankaEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の単価は_設定した値と同じ単価を返す() {
            business = sut.set単価(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_単価).build();
            assertThat(business.get単価(), is(DbT5031NinteiChosaHoshuTankaEntityGenerator.DEFAULT_単価));
        }

    }
}
