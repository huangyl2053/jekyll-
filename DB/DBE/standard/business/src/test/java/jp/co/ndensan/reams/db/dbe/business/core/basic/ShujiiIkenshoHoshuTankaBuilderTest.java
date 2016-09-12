/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator;
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
 * {@link ShujiiIkenshoHoshuTankaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoHoshuTankaBuilderTest extends DbeTestBase {

    private static DbT5032ShujiiIkenshoHoshuTankaEntity ShujiiIkenshoHoshuTankaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static Code 在宅施設区分;
    private static Code 意見書作成回数区分;
    private static FlexibleYearMonth 開始年月;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        在宅施設区分 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
        意見書作成回数区分 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
        開始年月 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static ShujiiIkenshoHoshuTankaBuilder sut;
        private static ShujiiIkenshoHoshuTanka business;

        @Before
        public void setUp() {
            ShujiiIkenshoHoshuTankaEntity = new DbT5032ShujiiIkenshoHoshuTankaEntity();

            business = new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の終了年月は_設定した値と同じ終了年月を返す() {
            business = sut.set終了年月(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_終了年月).build();
            assertThat(business.get終了年月(), is(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_終了年月));
        }

        @Test
        public void 戻り値の単価は_設定した値と同じ単価を返す() {
            business = sut.set単価(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_単価).build();
            assertThat(business.get単価(), is(DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_単価));
        }

    }
}
