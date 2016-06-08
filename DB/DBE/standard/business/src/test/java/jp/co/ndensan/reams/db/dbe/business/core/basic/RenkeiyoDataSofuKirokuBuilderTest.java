/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RenkeiyoDataSofuKirokuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuBuilderTest extends DbeTestBase {

    private static DbT5191RenkeiyoDataSofuKirokuEntity RenkeiyoDataSofuKirokuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static FlexibleDate 資料作成日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
        資料作成日 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static RenkeiyoDataSofuKirokuBuilder sut;
        private static RenkeiyoDataSofuKiroku business;

        @Before
        public void setUp() {
            RenkeiyoDataSofuKirokuEntity = new DbT5191RenkeiyoDataSofuKirokuEntity();

            business = new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の資料作成日は_設定した値と同じ資料作成日を返す() {
            business = sut.set資料作成日(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日).build();
            assertThat(business.get資料作成日(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日));
        }

        @Test
        public void 戻り値の引渡し区分は_設定した値と同じ引渡し区分を返す() {
            business = sut.set引渡し区分(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_引渡し区分).build();
            assertThat(business.get引渡し区分(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_引渡し区分));
        }

        @Test
        public void 戻り値の引渡日時は_設定した値と同じ引渡日時を返す() {
            business = sut.set引渡日時(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_引渡日時).build();
            assertThat(business.get引渡日時(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_引渡日時));
        }

        @Test
        public void 戻り値の再送付区分は_設定した値と同じ再送付区分を返す() {
            business = sut.set再送付区分(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再送付区分).build();
            assertThat(business.get再送付区分(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再送付区分));
        }

        @Test
        public void 戻り値の再調査送付区分は_設定した値と同じ再調査送付区分を返す() {
            business = sut.set再調査送付区分(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再調査送付区分).build();
            assertThat(business.get再調査送付区分(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再調査送付区分));
        }

        @Test
        public void 戻り値の再意見書送付区分は_設定した値と同じ再意見書送付区分を返す() {
            business = sut.set再意見書送付区分(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再意見書送付区分).build();
            assertThat(business.get再意見書送付区分(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再意見書送付区分));
        }

        @Test
        public void 戻り値の再イメージ送付区分は_設定した値と同じ再イメージ送付区分を返す() {
            business = sut.set再イメージ送付区分(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再イメージ送付区分).build();
            assertThat(business.get再イメージ送付区分(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再イメージ送付区分));
        }

        @Test
        public void 戻り値の再送信年月日は_設定した値と同じ再送信年月日を返す() {
            business = sut.set再送信年月日(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再送信年月日).build();
            assertThat(business.get再送信年月日(), is(DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_再送信年月日));
        }

    }
}
