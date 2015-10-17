/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5123NinteiKeikakuJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKeikakuJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiKeikakuJohoBuilderTest extends DbeTestBase {

    private static DbT5123NinteiKeikakuJohoEntity NinteiKeikakuJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static NinteiKeikakuJohoBuilder sut;
        private static NinteiKeikakuJoho business;

        @Before
        public void setUp() {
            NinteiKeikakuJohoEntity = new DbT5123NinteiKeikakuJohoEntity();

            business = new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の認定調査依頼予定年月日は_設定した値と同じ認定調査依頼予定年月日を返す() {
            business = sut.set認定調査依頼予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定調査依頼予定年月日).build();
            assertThat(business.get認定調査依頼予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定調査依頼予定年月日));
        }

        @Test
        public void 戻り値の認定調査予定年月日は_設定した値と同じ認定調査予定年月日を返す() {
            business = sut.set認定調査予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定調査予定年月日).build();
            assertThat(business.get認定調査予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定調査予定年月日));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼予定年月日は_設定した値と同じ主治医意見書作成依頼予定年月日を返す() {
            business = sut.set主治医意見書作成依頼予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_主治医意見書作成依頼予定年月日).build();
            assertThat(business.get主治医意見書作成依頼予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_主治医意見書作成依頼予定年月日));
        }

        @Test
        public void 戻り値の主治医意見書登録予定年月日は_設定した値と同じ主治医意見書登録予定年月日を返す() {
            business = sut.set主治医意見書登録予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_主治医意見書登録予定年月日).build();
            assertThat(business.get主治医意見書登録予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_主治医意見書登録予定年月日));
        }

        @Test
        public void 戻り値の要介護認定一次判定予定年月日は_設定した値と同じ要介護認定一次判定予定年月日を返す() {
            business = sut.set要介護認定一次判定予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_要介護認定一次判定予定年月日).build();
            assertThat(business.get要介護認定一次判定予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_要介護認定一次判定予定年月日));
        }

        @Test
        public void 戻り値の要介護認定1_5次判定予定年月日は_設定した値と同じ要介護認定1_5次判定予定年月日を返す() {
            business = sut.set要介護認定1_5次判定予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_要介護認定1_5次判定予定年月日).build();
            assertThat(business.get要介護認定1_5次判定予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_要介護認定1_5次判定予定年月日));
        }

        @Test
        public void 戻り値の認定審査会割当予定年月日は_設定した値と同じ認定審査会割当予定年月日を返す() {
            business = sut.set認定審査会割当予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定審査会割当予定年月日).build();
            assertThat(business.get認定審査会割当予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定審査会割当予定年月日));
        }

        @Test
        public void 戻り値の認定審査会予定年月日は_設定した値と同じ認定審査会予定年月日を返す() {
            business = sut.set認定審査会予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定審査会予定年月日).build();
            assertThat(business.get認定審査会予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_認定審査会予定年月日));
        }

        @Test
        public void 戻り値のセンター送信予定年月日は_設定した値と同じセンター送信予定年月日を返す() {
            business = sut.setセンター送信予定年月日(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_センター送信予定年月日).build();
            assertThat(business.getセンター送信予定年月日(), is(DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_センター送信予定年月日));
        }

    }
}
