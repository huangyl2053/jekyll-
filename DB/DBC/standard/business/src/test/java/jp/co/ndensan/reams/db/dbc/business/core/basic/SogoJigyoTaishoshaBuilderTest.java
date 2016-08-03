/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3105SogoJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SogoJigyoTaishoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoTaishoshaBuilderTest extends DbcTestBase {

    private static DbT3105SogoJigyoTaishoshaEntity SogoJigyoTaishoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static int 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static SogoJigyoTaishoshaBuilder sut;
        private static SogoJigyoTaishosha business;

        @Before
        public void setUp() {
            SogoJigyoTaishoshaEntity = new DbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishoshaEntity.setHihokenshaNo(主キー名1);
            SogoJigyoTaishoshaEntity.setRirekiNo(主キー名2);

            business = new SogoJigyoTaishosha(SogoJigyoTaishoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            business = sut.set適用終了年月日(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_適用終了年月日).build();
            assertThat(business.get適用終了年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_決定年月日));
        }

    }
}
